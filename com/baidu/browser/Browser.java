package com.baidu.browser;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;
import com.baidu.browser.base.Fragment;
import com.baidu.browser.bbm.BdBBM;
import com.baidu.browser.core.BdCore;
import com.baidu.browser.core.BdPath;
import com.baidu.browser.core.net.BdNetReceiver;
import com.baidu.browser.core.util.BdFileUtil;
import com.baidu.browser.core.util.BdLog;
import com.baidu.browser.explorer.share.BdSharer;
import com.baidu.browser.framework.BdFrameView;
import com.baidu.browser.webkit.BdValueCallback;
import com.baidu.browser.webpool.BdWebPoolView;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.net.URLEncoder;
/* loaded from: classes.dex */
public final class Browser extends Fragment {
    public static final int COPY_FOCUS_NODE_HREF = 103;
    public static final String IS_DEFAULT_SEARCH = "is_default_search";
    public static final String KEY_URL = "key_url";
    public static final String KEY_VALUE = "key_value";
    public static final int PROGRESS_MAX = 100;
    public static final int PROGRESS_MIN = 10;
    public static final String SCHEME_ADD_WIDGET = "addwidget://";
    public static final String SCHEME_GEO = "geo:0,0?q=";
    public static final String SCHEME_MAILTO = "mailto:";
    public static final String SCHEME_SEARCH = "search://";
    public static final String SCHEME_TEL = "tel:";
    public static final int STATE_PAGE_FINISHED = 2;
    public static final int STATE_PAGE_STARTED = 1;
    public static final int STATE_PROGRESS_CHANGED = 3;
    public static final String WEBVIEW_PICTURE_SAVE = "webview_picture";
    public static long isShareLaunched;
    private static Browser sInstance;
    private BdFrameView mFrameView;
    private String mLastAdTimeFileName;
    private BrowserListener mListener;
    private BdNetReceiver mNetReceiver;
    private long mShowAdTimeDur;

    /* loaded from: classes.dex */
    public interface BrowserListener {
        void onBrowserStateChanged(int i, Object obj);

        void onClickVoiceSearch();

        void onDownloadStart(String str, String str2, String str3, String str4, long j);

        void onDownloadStartNoStream(String str, String str2, String str3, String str4, long j);

        void onExit();

        void onGoHome();

        void onOpenFromBrowser(String str, String str2);

        void onProtocolSearch(String str);

        Message onRequestCopyHref();

        void onSelectionSearch(String str);

        Bundle onTabChangStarted(Bundle bundle);

        Bundle onTabChangeFinished(Bundle bundle);

        void openFileChooser(BdValueCallback<Uri> bdValueCallback);

        void openFileChooser(BdValueCallback<Uri> bdValueCallback, String str);

        boolean shouldOverrideUrlLoading(BdWebPoolView bdWebPoolView, String str);
    }

    private Browser(Activity activity) {
        super(activity);
        this.mLastAdTimeFileName = "browser_last_ad_time";
        this.mShowAdTimeDur = 604800000L;
    }

    @Override // com.baidu.browser.base.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initInflate();
        BdCore.getInstance().onInit(this.mActivity);
        BdBBM.initBdBBM(this.mActivity);
        if (Build.VERSION.SDK_INT >= 14) {
            this.mActivity.getWindow().setFlags(16777216, 16777216);
        }
        init();
    }

    private void init() {
        boolean z;
        String readPrivateFile = BdFileUtil.readPrivateFile(BdPath.getInstance(this.mActivity).getDirPv(), this.mLastAdTimeFileName);
        long longValue = readPrivateFile != null ? Long.valueOf(readPrivateFile).longValue() : 0L;
        long currentTimeMillis = System.currentTimeMillis();
        if (longValue > 0) {
            z = currentTimeMillis > longValue + this.mShowAdTimeDur;
        } else {
            z = true;
        }
        if (z) {
            BdLog.i("can show ad view.");
            this.mFrameView.setCanShowAdView(true);
            BdFileUtil.writePrivateFile(String.valueOf(currentTimeMillis).getBytes(), BdPath.getInstance(this.mActivity).getDirPv(), this.mLastAdTimeFileName);
        }
    }

    public void initInflate() {
        if (this.mFrameView == null) {
            this.mFrameView = (BdFrameView) this.mActivity.findViewById(this.mActivity.getResources().getIdentifier("bdframeview_id", "id", this.mActivity.getPackageName()));
            if (this.mFrameView == null) {
                this.mFrameView = new BdFrameView(this.mActivity);
                this.mFrameView.setId(this.mActivity.getResources().getIdentifier("bdframeview_id", "id", this.mActivity.getPackageName()));
                this.mFrameView.setBrowser(this);
            }
        }
    }

    @Override // com.baidu.browser.base.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    @Override // com.baidu.browser.base.Fragment
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
    }

    @Override // com.baidu.browser.base.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.browser.base.Fragment
    public void onResume() {
        super.onResume();
        initInflate();
        if (this.mFrameView != null) {
            this.mFrameView.onResume();
        }
    }

    @Override // com.baidu.browser.base.Fragment
    public void onPause() {
        super.onPause();
        if (this.mFrameView != null) {
            this.mFrameView.closeSelectedMenu();
            this.mFrameView.onPause();
        }
    }

    @Override // com.baidu.browser.base.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.browser.base.Fragment
    public void onDestroy() {
        super.onDestroy();
        BdCore.getInstance().onDestroy();
        freeMemory();
        if (this.mFrameView != null) {
            this.mFrameView.release();
        }
        this.mFrameView = null;
        sInstance = null;
    }

    @Override // com.baidu.browser.base.Fragment
    public void onLowMemory() {
        super.onLowMemory();
        if (this.mFrameView != null) {
            this.mFrameView.freeMemory();
        }
    }

    @Override // com.baidu.browser.base.Fragment
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.mFrameView == null || !this.mFrameView.onKeyDown(i, keyEvent)) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    public static Browser getInstance(Activity activity) {
        if (sInstance == null) {
            sInstance = new Browser(activity);
        }
        return sInstance;
    }

    public void clearAllCache() {
    }

    public void goBack() {
        initInflate();
        this.mFrameView.goBack();
    }

    public void goForward() {
        initInflate();
        this.mFrameView.goForward();
    }

    public boolean canGoForward() {
        initInflate();
        return this.mFrameView.canGoForward();
    }

    public boolean canGoBack() {
        initInflate();
        return this.mFrameView.canGoBack();
    }

    public void loadUrl(String str) {
        initInflate();
        this.mFrameView.loadUrl(str);
    }

    public void loadQuickUrl(String str) {
        initInflate();
        this.mFrameView.createNewWindowOpenUrl(str);
    }

    public void loadSearchUrl(String str, String str2) {
        initInflate();
        this.mFrameView.loadSearchUrl(str, str2);
    }

    public String getUrl() {
        initInflate();
        return this.mFrameView.getUrl();
    }

    public void reload() {
        initInflate();
        this.mFrameView.reload();
    }

    public void stopLoading() {
        initInflate();
        this.mFrameView.stopLoading();
    }

    public void clearHistory() {
        if (this.mFrameView != null) {
            this.mFrameView.clearHistory();
        }
    }

    public View getRootView() {
        initInflate();
        return this.mFrameView;
    }

    public void freeMemory() {
        if (this.mFrameView != null) {
            this.mFrameView.freeMemory();
        }
    }

    public void setUpSelect() {
        this.mFrameView.setUpSelect();
    }

    public void scrollBy(int i, int i2) {
        initInflate();
        this.mFrameView.webviewScrollBy(i, i2);
    }

    public void scrollTo(int i, int i2) {
        initInflate();
        this.mFrameView.webviewScrollTo(i, i2);
    }

    public void addWebViewTitle(View view) {
        initInflate();
        this.mFrameView.addWebViewTitle(view);
    }

    public void setmListener(BrowserListener browserListener) {
        this.mListener = browserListener;
    }

    private void sendSms(Activity activity, String str) {
        String str2;
        String str3 = null;
        try {
            if (str.startsWith("sms:")) {
                int indexOf = str.indexOf(63);
                if (indexOf < "sms:?".length()) {
                    str2 = str.substring("sms:".length());
                    str3 = "";
                } else {
                    str2 = str.substring("sms:".length(), indexOf);
                    int indexOf2 = str.indexOf("body=");
                    if (indexOf2 > -1) {
                        str3 = str.substring("body=".length() + indexOf2);
                        if (!TextUtils.isEmpty(str3)) {
                            str3 = URLDecoder.decode(str3, "UTF-8");
                        }
                    }
                }
            } else if (str.startsWith("smsto:")) {
                int indexOf3 = str.indexOf(63);
                if (indexOf3 < "smsto:?".length()) {
                    str2 = str.substring("smsto:".length());
                    str3 = "";
                } else {
                    str2 = str.substring("smsto:".length(), indexOf3);
                    int indexOf4 = str.indexOf("body=");
                    if (indexOf4 > -1) {
                        str3 = str.substring("body=".length() + indexOf4);
                        if (!TextUtils.isEmpty(str3)) {
                            str3 = URLDecoder.decode(str3, "UTF-8");
                        }
                    }
                }
            } else {
                str2 = null;
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.putExtra("address", str2);
            intent.putExtra("sms_body", str3);
            intent.setType("vnd.android-dir/mms-sms");
            startActivitySafely(activity, intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean handleUrl(BdWebPoolView bdWebPoolView, String str) {
        String str2;
        Activity activity = this.mActivity;
        if (str.startsWith(SCHEME_SEARCH) || str.startsWith(SCHEME_ADD_WIDGET)) {
            try {
                String decode = URLDecoder.decode(str.substring(str.lastIndexOf("/") + 1), "UTF-8");
                if (this.mListener == null || decode == null) {
                    return true;
                }
                this.mListener.onProtocolSearch(decode);
                return true;
            } catch (Exception e) {
                return true;
            }
        } else if (str.startsWith("sms:") || str.startsWith("smsto:")) {
            sendSms(activity, str);
            return true;
        } else if (str.startsWith("tel:")) {
            startActivitySafely(activity, new Intent("android.intent.action.VIEW", Uri.parse(str)));
            return true;
        } else if (str.startsWith("mailto:")) {
            startActivitySafely(activity, new Intent("android.intent.action.VIEW", Uri.parse(str)));
            return true;
        } else if (str.startsWith("geo:0,0?q=")) {
            startActivitySafely(activity, new Intent("android.intent.action.VIEW", Uri.parse("geo:0,0?q=" + URLEncoder.encode(str.substring("geo:0,0?q=".length())))));
            return true;
        } else if (str.startsWith("about:")) {
            return false;
        } else {
            try {
                Intent parseUri = Intent.parseUri(str, 1);
                if (activity.getPackageManager().resolveActivity(parseUri, 0) == null && (str2 = parseUri.getPackage()) != null) {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://search?q=pname:" + str2));
                    intent.addCategory("android.intent.category.BROWSABLE");
                    startActivitySafely(activity, intent);
                    return true;
                }
                return false;
            } catch (URISyntaxException e2) {
                Log.w("Browser", "Bad URI " + str + ": " + e2.getMessage());
                return false;
            }
        }
    }

    public static void startActivitySafely(Activity activity, Intent intent) {
        intent.addFlags(268435456);
        try {
            activity.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(activity, activity.getResources().getIdentifier("browser_msg_activity_not_found", "string", activity.getPackageName()), 0).show();
        } catch (SecurityException e2) {
            Toast.makeText(activity, activity.getResources().getIdentifier("browser_msg_activity_not_found", "string", activity.getPackageName()), 0).show();
        }
    }

    public void updateInputBoxText(String str) {
        initInflate();
        this.mFrameView.updateInputBoxText(str);
    }

    public void setGridViewScrolledDown(boolean z) {
        initInflate();
        this.mFrameView.setGridViewScrolledDown(z);
    }

    public void setVoiceViewScrolledUp() {
        if (this.mFrameView != null) {
            this.mFrameView.setVoiceViewScrolledUp();
        }
    }

    public void copyToCb(String str) {
        ((ClipboardManager) this.mActivity.getSystemService("clipboard")).setText(str);
        Toast.makeText(this.mActivity, this.mActivity.getResources().getIdentifier("browser_text_selection_ok_tip", "string", this.mActivity.getPackageName()), 0).show();
    }

    public void pageStateChanged(int i, Object obj) {
        if (this.mListener != null) {
            this.mListener.onBrowserStateChanged(i, obj);
        }
    }

    public void onGoHome() {
        if (this.mListener != null) {
            this.mListener.onGoHome();
        }
    }

    public void onExit() {
        if (this.mListener != null) {
            this.mListener.onExit();
        }
    }

    public void onOpenFromBrowser(String str, String str2) {
        if (System.currentTimeMillis() - isShareLaunched > 1000) {
            isShareLaunched = System.currentTimeMillis();
            BdSharer.sendTextShare(this.mActivity, str, str2);
        }
    }

    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        if (this.mListener != null) {
            this.mListener.onDownloadStart(str, str2, str3, str4, j);
        }
    }

    public void onDownloadStartNoStream(String str, String str2, String str3, String str4, long j) {
        if (this.mListener != null) {
            this.mListener.onDownloadStartNoStream(str, str2, str3, str4, j);
        }
    }

    public void onSelectionSearch(String str) {
        if (this.mListener != null) {
            this.mListener.onSelectionSearch(str);
        }
    }

    public Bundle onTabChangStarted(Bundle bundle) {
        if (this.mListener != null) {
            return this.mListener.onTabChangStarted(bundle);
        }
        return null;
    }

    public Bundle onTabChangeFinished(Bundle bundle) {
        if (this.mListener != null) {
            this.mListener.onTabChangeFinished(bundle);
            return null;
        }
        return null;
    }

    public void openFileChooser(BdValueCallback<Uri> bdValueCallback, String str) {
        if (this.mListener != null) {
            this.mListener.openFileChooser(bdValueCallback, str);
        }
    }

    public void openFileChooser(BdValueCallback<Uri> bdValueCallback) {
        if (this.mListener != null) {
            this.mListener.openFileChooser(bdValueCallback);
        }
    }

    public Message onRequestCopyHref() {
        if (this.mListener != null) {
            return this.mListener.onRequestCopyHref();
        }
        return null;
    }

    public boolean shouldOverrideUrlLoading(BdWebPoolView bdWebPoolView, String str) {
        if (this.mListener != null) {
            return this.mListener.shouldOverrideUrlLoading(bdWebPoolView, str);
        }
        return false;
    }
}
