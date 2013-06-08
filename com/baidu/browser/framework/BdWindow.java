package com.baidu.browser.framework;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.baidu.browser.Browser;
import com.baidu.browser.core.util.BdLog;
import com.baidu.browser.core.util.BdUtil;
import com.baidu.browser.explorer.BdExploreChromeClient;
import com.baidu.browser.explorer.BdExploreView;
import com.baidu.browser.explorer.BdExploreViewClient;
import com.baidu.browser.explorer.BdExploreViewListener;
import com.baidu.browser.webkit.BdCookieSyncManager;
import com.baidu.browser.webkit.BdDownloadListener;
import com.baidu.browser.webkit.BdGeolocationPermissions;
import com.baidu.browser.webkit.BdGeolocationPermissionsPrompt;
import com.baidu.browser.webkit.BdValueCallback;
import com.baidu.browser.webkit.BdWebSettings;
import com.baidu.browser.webkit.BdWebView;
import com.baidu.browser.webpool.BdWebPoolBackForwardListItem;
import com.baidu.browser.webpool.BdWebPoolCustomView;
import com.baidu.browser.webpool.BdWebPoolView;
import java.net.URISyntaxException;
import java.util.Comparator;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class BdWindow extends FrameLayout implements BdExploreViewListener {
    private static final int TOAST_DUR = 2000;
    public static Comparator sLastVisitTimeComparator = new Comparator() { // from class: com.baidu.browser.framework.BdWindow.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        public int compare(BdWindow bdWindow, BdWindow bdWindow2) {
            return (int) (bdWindow.getLastVisitTime() - bdWindow.getLastVisitTime());
        }
    };
    private boolean isShowLoadingIcon;
    private BdAdColumnView mAdColumn;
    private String mAnchorUrl;
    private int mCurrentPageProgerss;
    private BdExploreView mExploreView;
    private BdFrameView mFrameView;
    private BdGeolocationPermissionsPrompt mGeolocationPermissionsPrompt;
    private boolean mIsForeground;
    private long mLastVisitTime;
    private LinearLayout mNullPage;
    private String mRegex;
    private Bundle mSearchboxBundle;
    private String mTitle;
    private String mUrl;
    private ViewStub stub;

    public BdWindow(Context context) {
        this(context, null);
    }

    public BdWindow(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BdWindow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mExploreView = new BdExploreView(context);
        this.mExploreView.setEventListener(this);
        this.mExploreView.setWebViewClient(new BdWindowCustomViewClient(this.mExploreView));
        this.mExploreView.setWebChromeClient(new BdWindowCustomChromeClient(this.mExploreView));
        this.mExploreView.setDownloadListener(new BdDownloadCustomViewListener());
        this.stub = new ViewStub(context);
        this.stub.setLayoutResource(getContext().getResources().getIdentifier("browser_geolocation_permissions_prompt", "layout", getContext().getPackageName()));
        ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        initSettings();
        addView(this.mExploreView, new FrameLayout.LayoutParams(-1, -1));
        addView(this.stub, layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams2.weight = 1.0f;
        setLayoutParams(layoutParams2);
        this.mAdColumn = new BdAdColumnView(context, this);
    }

    public void createNullPage() {
        this.mNullPage = (LinearLayout) ((Activity) getContext()).getLayoutInflater().inflate(getContext().getResources().getIdentifier("browser_search_null", "layout", getContext().getPackageName()), (ViewGroup) null);
        addView(this.mNullPage, new FrameLayout.LayoutParams(-1, -1));
    }

    public void removeNullPage() {
        if (this.mNullPage != null) {
            removeView(this.mNullPage);
            this.mNullPage = null;
        }
    }

    public void initSettings() {
        if (this.mExploreView != null) {
            BdWebSettings settings = this.mExploreView.getSettings();
            settings.setLightTouchEnabled(false);
            settings.setNeedInitialFocus(false);
            settings.setJavaScriptEnabled(true);
            settings.setLoadsImagesAutomatically(true);
            settings.setDefaultTextEncodingName("GBK");
            settings.setLoadWithOverviewMode(true);
            settings.setUseWideViewPort(true);
            settings.setGeolocationEnabled(true);
            settings.setDatabaseEnabled(true);
            settings.setDomStorageEnabled(true);
            settings.setAppCacheEnabled(true);
            String path = getContext().getDir("databases", 0).getPath();
            String path2 = getContext().getDir("geolocation", 0).getPath();
            String path3 = getContext().getDir("appcache", 0).getPath();
            settings.setGeolocationDatabasePath(path2);
            settings.setDatabasePath(path);
            settings.setAppCachePath(path3);
            settings.setSupportMultipleWindows(true);
            try {
                settings.setPluginState(BdWebSettings.PluginState.ON_DEMAND);
            } catch (Exception e) {
                e.printStackTrace();
            } catch (NoClassDefFoundError e2) {
                e2.printStackTrace();
            }
        }
    }

    public void clearAllCache() {
    }

    public void goBack() {
        this.mExploreView.goBack();
        this.mFrameView.setUrlTitle(null, this.mExploreView.getTitle());
    }

    public void goForward() {
        this.mExploreView.goForward();
        this.mFrameView.setUrlTitle(null, this.mExploreView.getTitle());
    }

    public boolean canGoForward() {
        return this.mExploreView.canGoForward();
    }

    public boolean canGoBack() {
        return this.mExploreView.canGoBack();
    }

    public void openSelectedUrl() {
        if (this.mAnchorUrl != null) {
            if (!TextUtils.isEmpty(this.mRegex)) {
                if (!Pattern.compile(this.mRegex).matcher(this.mAnchorUrl).find()) {
                    this.mFrameView.createNewWindowOpenUrl(this.mAnchorUrl);
                    return;
                } else {
                    loadUrl(this.mAnchorUrl);
                    return;
                }
            }
            loadUrl(this.mAnchorUrl);
        }
    }

    public void loadUrl(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mUrl = str;
            if (str.startsWith(Browser.SCHEME_SEARCH) || str.startsWith(Browser.SCHEME_ADD_WIDGET)) {
                this.mFrameView.getBrowser().handleUrl(this.mExploreView, str);
            } else {
                this.mExploreView.loadUrl(str);
            }
        }
    }

    public BdGeolocationPermissionsPrompt getGeolocationPermissionsPrompt() {
        if (this.mGeolocationPermissionsPrompt == null) {
            this.mGeolocationPermissionsPrompt = (BdGeolocationPermissionsPrompt) this.stub.inflate();
            this.mGeolocationPermissionsPrompt.init();
        }
        return this.mGeolocationPermissionsPrompt;
    }

    public String getUrl() {
        return this.mExploreView.getUrl();
    }

    public void reload() {
        if (this.mExploreView != null) {
            this.mExploreView.reload();
        }
    }

    public void stopLoading() {
        if (this.mExploreView != null) {
            this.mExploreView.stopLoading();
        }
    }

    public void clearHistory() {
        this.mExploreView.clearHistory();
    }

    public void freeMemory() {
        if (this.mIsForeground) {
            this.mExploreView.freeMemory(false);
        } else {
            this.mExploreView.freeMemory(true);
        }
    }

    public void setUpSelect() {
        this.mExploreView.emulateShiftHeld();
        Toast.makeText(getContext(), getContext().getResources().getIdentifier("browser_text_selection_tip", "string", getContext().getPackageName()), (int) TOAST_DUR).show();
    }

    public void setEmbeddedTitleBar(View view) {
    }

    public BdFrameView getFrameView() {
        return this.mFrameView;
    }

    public void setFrameView(BdFrameView bdFrameView) {
        this.mFrameView = bdFrameView;
    }

    public void setTab(BdWindowTabButton bdWindowTabButton) {
    }

    public int getCurrentPageProgerss() {
        return this.mCurrentPageProgerss;
    }

    public void setCurrentPageProgerss(int i) {
        this.mCurrentPageProgerss = i;
    }

    public boolean isShowLoadingIcon() {
        return this.isShowLoadingIcon;
    }

    public void setShowLoadingIcon(boolean z) {
        this.isShowLoadingIcon = z;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public String getwUrl() {
        return this.mUrl;
    }

    public void setUrl(String str) {
        this.mUrl = str;
    }

    public String getAnchorUrl() {
        return this.mAnchorUrl;
    }

    public void setmAnchorUrl(String str) {
        this.mAnchorUrl = str;
    }

    public boolean isForeground() {
        return this.mIsForeground;
    }

    public void setForeground(boolean z) {
        this.mIsForeground = z;
        this.mExploreView.setForeground(z);
    }

    public long getLastVisitTime() {
        return this.mLastVisitTime;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setLastVisitTime(long j) {
        this.mLastVisitTime = j;
    }

    public void webviewScrollBy(int i, int i2) {
        this.mExploreView.scrollBy(i, i2);
    }

    public void webviewScrollTo(int i, int i2) {
        this.mExploreView.scrollTo(i, i2);
    }

    public void release() {
        if (this.mExploreView != null) {
            this.mExploreView.clear();
            this.mExploreView = null;
        }
    }

    public String getRegex() {
        return this.mRegex;
    }

    public void setRegex(String str) {
        this.mRegex = str;
    }

    public boolean handleUrl(BdWebPoolView bdWebPoolView, String str) {
        if (!TextUtils.isEmpty(this.mRegex)) {
            if (!Pattern.compile(this.mRegex).matcher(str).find() && !checkScheme(str)) {
                this.mFrameView.createNewWindowOpenUrl(str);
                return true;
            }
            return this.mFrameView.getBrowser().handleUrl(bdWebPoolView, str);
        }
        return this.mFrameView.getBrowser().handleUrl(bdWebPoolView, str);
    }

    public boolean checkScheme(String str) {
        return str.startsWith("sms:") || str.startsWith("smsto:") || str.startsWith("tel:") || str.startsWith("mailto:") || str.startsWith("geo:0,0?q=");
    }

    @Override // com.baidu.browser.explorer.BdExploreViewListener
    public void onShowTabWindow() {
        this.mFrameView.showTabWindow();
    }

    @Override // com.baidu.browser.explorer.BdExploreViewListener
    public void onHideTabWindow() {
        this.mFrameView.hideTabWindow();
    }

    @Override // com.baidu.browser.explorer.BdExploreViewListener
    public void onLongPress(BdWebView.BdHitTestResult bdHitTestResult) {
        if (bdHitTestResult != null) {
            try {
                int type = bdHitTestResult.getType();
                if (type == 0) {
                    if (Build.VERSION.SDK_INT < 14) {
                        this.mFrameView.showSelectedPopMenu();
                    }
                } else if (type == 5) {
                    this.mAnchorUrl = bdHitTestResult.getExtra();
                    this.mFrameView.showImagePopMenu();
                } else if (type == 7) {
                    this.mAnchorUrl = bdHitTestResult.getExtra();
                    this.mFrameView.showWindowPopMenu();
                } else if (type == 8) {
                    this.mAnchorUrl = bdHitTestResult.getExtra();
                    this.mFrameView.showAnchorImagePopMenu();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.browser.explorer.BdExploreViewListener
    public void onSelectionSearch(String str) {
        this.mFrameView.onSelectionSearch(str);
    }

    @Override // com.baidu.browser.explorer.BdExploreViewListener
    public void onWebViewTouch(MotionEvent motionEvent) {
        if (this.mExploreView != null) {
            this.mExploreView.requestFocus();
        }
    }

    public void requestFocusNodeHref(Message message) {
        this.mExploreView.requestFocusNodeHref(message);
    }

    public void closeSelectedMenu() {
        this.mExploreView.doSelectionCancel();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPause() {
        this.mExploreView.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onResume() {
        if (this.mExploreView != null) {
            this.mExploreView.onResume();
        }
    }

    public Bundle getSearchboxBundle() {
        return this.mSearchboxBundle;
    }

    public void setSearchboxBundle(Bundle bundle) {
        this.mSearchboxBundle = bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean setWebViewToTarget(Message message, BdWebView.BdWebViewTransport bdWebViewTransport) {
        return this.mExploreView.setWebViewToTarget(message, bdWebViewTransport);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.mExploreView.onKeyDown(i, keyEvent)) {
            this.mFrameView.updateState(this);
            this.mFrameView.setUrlTitle(null, this.mExploreView.getTitle());
            return true;
        }
        return false;
    }

    public boolean isBlankWindow() {
        return this.mExploreView.isBlankView();
    }

    public int getWebViewCount() {
        return this.mExploreView.getWebViewCount();
    }

    public void onAdColumnCancel() {
        this.mExploreView.setEmbeddedTitleBar(null);
        this.mAdColumn = null;
    }

    public void startBrowsable(String str) {
        try {
            Intent parseUri = Intent.parseUri(str, 1);
            parseUri.addCategory("android.intent.category.BROWSABLE");
            parseUri.setComponent(null);
            if (getContext() instanceof Activity) {
                ((Activity) getContext()).startActivityIfNeeded(parseUri, -1);
            }
        } catch (ActivityNotFoundException e) {
        } catch (URISyntaxException e2) {
            BdLog.w("Bad URI " + str + ": " + e2.getMessage());
        }
    }

    @Override // android.view.View
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.mExploreView.getWebViewCount());
        return stringBuffer.toString();
    }

    /* loaded from: classes.dex */
    class BdDownloadCustomViewListener extends BdDownloadListener {
        public BdDownloadCustomViewListener() {
        }

        @Override // com.baidu.browser.webkit.BdDownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            BdLog.i(str);
            if (!BdWindow.this.mExploreView.openVideoOnDownloadStart(str, str3, str4)) {
                if (BdWindow.this.mExploreView.isContainUrl(BdWindow.this.mExploreView.getCurIndex(), str) && (BdWindow.this.mExploreView.getUrl() == null || BdWindow.this.mExploreView.isUrlEqual(BdWindow.this.mExploreView.getUrl(), str))) {
                    BdLog.i(String.valueOf(str) + " is a download link, directly go back.");
                    BdWindow.this.mExploreView.goBackNotToHome();
                }
                BdWindow.this.startBrowsable(str);
                return;
            }
            BdLog.i(String.valueOf(str) + " is a video, directly open it.");
        }
    }

    /* loaded from: classes.dex */
    class BdWindowCustomViewClient extends BdExploreViewClient {
        public BdWindowCustomViewClient(BdExploreView bdExploreView) {
            super(bdExploreView);
        }

        @Override // com.baidu.browser.explorer.BdExploreViewClient, com.baidu.browser.webpool.BdWebPoolViewClient
        public boolean shouldOverrideUrlLoading(BdWebPoolView bdWebPoolView, String str) {
            BdWindow.this.mUrl = str;
            if (BdWindow.this.mFrameView.getBrowser().shouldOverrideUrlLoading(bdWebPoolView, str)) {
                return true;
            }
            return BdWindow.this.handleUrl(bdWebPoolView, str);
        }

        @Override // com.baidu.browser.explorer.BdExploreViewClient, com.baidu.browser.webpool.BdWebPoolViewClient
        public void onPageStarted(BdWebPoolView bdWebPoolView, String str, Bitmap bitmap) {
            BdWindow.this.mCurrentPageProgerss = 10;
            BdWindow.this.isShowLoadingIcon = true;
            if (BdWindow.this.mGeolocationPermissionsPrompt != null) {
                BdWindow.this.mGeolocationPermissionsPrompt.hide();
            }
            BdWindow.this.mFrameView.getBrowser().pageStateChanged(1, str);
            BdWindow.this.mFrameView.updateState(BdWindow.this);
        }

        @Override // com.baidu.browser.explorer.BdExploreViewClient, com.baidu.browser.webpool.BdWebPoolViewClient
        public void onPageFinished(BdWebPoolView bdWebPoolView, String str) {
            BdWindow.this.removeNullPage();
            BdWindow.this.mCurrentPageProgerss = 0;
            BdWindow.this.isShowLoadingIcon = false;
            BdWindow.this.mFrameView.updateState(BdWindow.this);
            BdWindow.this.mFrameView.getBrowser().pageStateChanged(2, null);
        }

        @Override // com.baidu.browser.webpool.BdWebPoolViewClient
        public void onWebViewChanged(BdWebPoolView bdWebPoolView, BdWebPoolCustomView bdWebPoolCustomView, BdWebPoolCustomView bdWebPoolCustomView2) {
            BdWindow.this.mExploreView.doSelectionCancel();
            if (BdWindow.this.mFrameView.isCanShowAdView() && !BdUtil.hasBaiduBrowserInstalled(BdWindow.this.getContext())) {
                if (bdWebPoolCustomView != null) {
                    bdWebPoolCustomView.setEmbeddedTitleBar(null);
                }
                if (bdWebPoolCustomView2 != null && BdWindow.this.mAdColumn != null) {
                    bdWebPoolCustomView2.setEmbeddedTitleBar(BdWindow.this.mAdColumn);
                }
            }
        }

        @Override // com.baidu.browser.webpool.BdWebPoolViewClient
        public void onGoBack(BdWebPoolBackForwardListItem bdWebPoolBackForwardListItem) {
            super.onGoBack(bdWebPoolBackForwardListItem);
        }

        @Override // com.baidu.browser.webpool.BdWebPoolViewClient
        public void onGoForward(BdWebPoolBackForwardListItem bdWebPoolBackForwardListItem) {
            super.onGoForward(bdWebPoolBackForwardListItem);
        }
    }

    /* loaded from: classes.dex */
    class BdWindowCustomChromeClient extends BdExploreChromeClient {
        public BdWindowCustomChromeClient(BdExploreView bdExploreView) {
            super(bdExploreView);
        }

        @Override // com.baidu.browser.explorer.BdExploreChromeClient, com.baidu.browser.webpool.BdWebPoolChromeClient
        public void onProgressChanged(BdWebPoolView bdWebPoolView, int i) {
            if (i != 100) {
                BdWindow.this.mCurrentPageProgerss = i;
            } else {
                BdCookieSyncManager.getInstance().sync();
                BdWindow.this.mCurrentPageProgerss = 0;
                BdWindow.this.isShowLoadingIcon = false;
            }
            BdWindow.this.mFrameView.updateState(BdWindow.this);
            BdWindow.this.mFrameView.getBrowser().pageStateChanged(3, Integer.valueOf(i));
        }

        @Override // com.baidu.browser.explorer.BdExploreChromeClient, com.baidu.browser.webpool.BdWebPoolChromeClient
        public void onReceivedTitle(BdWebPoolView bdWebPoolView, String str) {
            if (str != null) {
                BdWindow.this.mTitle = str;
                BdWindow.this.mFrameView.setUrlTitle(null, BdWindow.this.mExploreView.getTitle());
            }
        }

        @Override // com.baidu.browser.explorer.BdExploreChromeClient, com.baidu.browser.webpool.BdWebPoolChromeClient
        public boolean onCreateWindow(BdWebPoolView bdWebPoolView, boolean z, boolean z2, Message message, BdWebView.BdWebViewTransport bdWebViewTransport) {
            BdLog.d(String.valueOf(z) + ", " + z2);
            if (!z && z2) {
                BdWindow.this.setWebViewToTarget(message, bdWebViewTransport);
                return false;
            }
            return false;
        }

        @Override // com.baidu.browser.webpool.BdWebPoolChromeClient
        public void openFileChooser(BdValueCallback bdValueCallback, String str) {
            BdWindow.this.mFrameView.openFileChooser(bdValueCallback, str);
        }

        @Override // com.baidu.browser.webpool.BdWebPoolChromeClient
        public void openFileChooser(BdValueCallback bdValueCallback) {
            BdWindow.this.mFrameView.openFileChooser(bdValueCallback);
        }

        @Override // com.baidu.browser.webpool.BdWebPoolChromeClient
        public void onGeolocationPermissionsHidePrompt() {
            if (BdWindow.this.mGeolocationPermissionsPrompt != null) {
                BdWindow.this.mGeolocationPermissionsPrompt.hide();
            }
        }

        @Override // com.baidu.browser.webpool.BdWebPoolChromeClient
        public void onGeolocationPermissionsShowPrompt(String str, BdGeolocationPermissions.BdCallback bdCallback) {
            if (BdWindow.this.getGeolocationPermissionsPrompt() != null) {
                BdWindow.this.getGeolocationPermissionsPrompt().show(str, bdCallback);
            }
        }
    }
}
