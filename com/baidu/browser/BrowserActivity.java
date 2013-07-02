package com.baidu.browser;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.baidu.browser.Browser;
import com.baidu.browser.core.util.BdLog;
import com.baidu.browser.core.util.BdUtil;
import com.baidu.browser.explorer.BdExploreChromeClient;
import com.baidu.browser.explorer.BdExploreView;
import com.baidu.browser.explorer.BdExploreViewClient;
import com.baidu.browser.explorer.BdExploreViewListener;
import com.baidu.browser.explorer.share.BdSharer;
import com.baidu.browser.framework.BdUploadHandler;
import com.baidu.browser.version.BdPvStatistic;
import com.baidu.browser.version.BdUpdateTask;
import com.baidu.browser.webkit.BdValueCallback;
import com.baidu.browser.webkit.BdWebSettings;
import com.baidu.browser.webkit.BdWebView;
import com.baidu.browser.webkit.BdWebViewManager;
import com.baidu.browser.webpool.BdWebPoolView;
import com.baidu.loginshare.e;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Observable;
import java.util.Observer;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class BrowserActivity extends Activity implements Browser.BrowserListener, BdExploreViewListener, Observer {
    public static BrowserActivity mySelf;
    private BdUploadHandler mUploadHandler;
    private BdValueCallback mUploadMessage;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        BdWebViewManager.getInstance().addObserver(this);
        mySelf = this;
        Browser.getInstance(this).onCreate(bundle);
        Browser.getInstance(this).setmListener(this);
        setContentView(Browser.getInstance(this).getRootView());
        Browser.getInstance(mySelf).loadUrl("http://wap.baidu.com/");
        new BdUpdateTask(this).execute(new String[0]);
        BdPvStatistic.getInstance(this).addLauchCount();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        Browser.getInstance(this).onPause();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        Browser.getInstance(this).onResume();
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        Browser.getInstance(this).onStop();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        Browser.getInstance(this).finish();
        BdPvStatistic.getInstance(this).saveLauchCount();
    }

    @Override // com.baidu.browser.Browser.BrowserListener
    public void openFileChooser(BdValueCallback bdValueCallback, String str) {
        this.mUploadHandler = new BdUploadHandler(this);
        this.mUploadHandler.openFileChooser(bdValueCallback, str);
    }

    @Override // com.baidu.browser.Browser.BrowserListener
    public void openFileChooser(BdValueCallback bdValueCallback) {
        if (this.mUploadMessage == null) {
            this.mUploadMessage = bdValueCallback;
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType("*/*");
            startActivityForResult(Intent.createChooser(intent, getString(getResources().getIdentifier("browser_choose_upload", "string", getPackageName()))), 1);
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return super.onKeyUp(i, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (Browser.getInstance(this).onKeyDown(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void testWebViewLoadUrl() {
    }

    private String composeUrl(String str) {
        if (str == null || str.length() <= 0) {
            return str;
        }
        String str2 = (str.startsWith(e.f) || str.startsWith(e.g) || str.startsWith("ftp://") || str.startsWith("rtsp://") || str.startsWith("mms://")) ? str : e.f + str;
        if (!checkStrIsUrl(str2)) {
            try {
                return "http://m.baidu.com/ssid=0/from=0/bd_page_type=1/uid=wiaui_1298960413_1175/s?tn=iphone&st=11104i&tj=i_sbtn0&pu=sz%401320_480&word=" + URLEncoder.encode(str, BdUtil.UTF8);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                return str2;
            }
        }
        return str2;
    }

    private boolean checkStrIsUrl(String str) {
        return Pattern.compile("^((https|http|ftp|rtsp|mms)?://)?(([0-9a-z_!~*'().&=+$%-]+: )?[0-9a-z_!~*'().&=+$%-]+@)?(([0-9]{1,3}\\.){3}[0-9]{1,3}|([0-9a-z_!~*'()-]+\\.)*([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]\\.[a-z]{2,6})(:[0-9]{1,4})?((/?)|(/[0-9a-z_!~*'().;?:@&=+$,%#-]+)+/?)$", 2).matcher(str).find();
    }

    private void initWebSettings(BdWebSettings bdWebSettings) {
        bdWebSettings.setLightTouchEnabled(false);
        bdWebSettings.setNeedInitialFocus(false);
        bdWebSettings.setJavaScriptEnabled(true);
        bdWebSettings.setSupportZoom(true);
        bdWebSettings.setDefaultTextEncodingName("GBK");
        bdWebSettings.setLoadWithOverviewMode(true);
        bdWebSettings.setUseWideViewPort(true);
        bdWebSettings.setRenderPriority(BdWebSettings.RenderPriority.NORMAL);
        bdWebSettings.setGeolocationEnabled(true);
        bdWebSettings.setDatabaseEnabled(true);
        bdWebSettings.setDomStorageEnabled(true);
        bdWebSettings.setAppCacheEnabled(true);
        String path = getDir("databases", 0).getPath();
        String path2 = getDir("geolocation", 0).getPath();
        String path3 = getDir("appcache", 0).getPath();
        bdWebSettings.setGeolocationDatabasePath(path2);
        bdWebSettings.setDatabasePath(path);
        bdWebSettings.setAppCachePath(path3);
        bdWebSettings.setSupportMultipleWindows(true);
        try {
            bdWebSettings.setPluginState(BdWebSettings.PluginState.ON);
        } catch (Exception e) {
            e.printStackTrace();
        } catch (NoClassDefFoundError e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.baidu.browser.Browser.BrowserListener
    public void onGoHome() {
    }

    @Override // com.baidu.browser.Browser.BrowserListener
    public void onExit() {
        finish();
    }

    @Override // com.baidu.browser.Browser.BrowserListener
    public void onOpenFromBrowser(String str, String str2) {
        BdSharer.sendTextShare(this, str, str2);
    }

    @Override // com.baidu.browser.Browser.BrowserListener
    public void onBrowserStateChanged(int i, Object obj) {
    }

    @Override // com.baidu.browser.Browser.BrowserListener
    public void onClickVoiceSearch() {
    }

    @Override // com.baidu.browser.explorer.BdExploreViewListener
    public void onLongPress(BdWebView.BdHitTestResult bdHitTestResult) {
    }

    @Override // com.baidu.browser.explorer.BdExploreViewListener
    public void onShowTabWindow() {
    }

    @Override // com.baidu.browser.explorer.BdExploreViewListener
    public void onHideTabWindow() {
    }

    @Override // com.baidu.browser.Browser.BrowserListener, com.baidu.browser.explorer.BdExploreViewListener
    public void onSelectionSearch(String str) {
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1) {
            if (this.mUploadMessage != null) {
                this.mUploadMessage.onReceiveValue((intent == null || i2 != -1) ? null : intent.getData());
                this.mUploadMessage = null;
            }
        } else if (i == 2 && this.mUploadHandler != null) {
            this.mUploadHandler.onResult(i2, intent);
        }
    }

    /* loaded from: classes.dex */
    class BdBrowserCustomViewClient extends BdExploreViewClient {
        public BdBrowserCustomViewClient(BdExploreView bdExploreView) {
            super(bdExploreView);
        }

        @Override // com.baidu.browser.explorer.BdExploreViewClient, com.baidu.browser.webpool.BdWebPoolViewClient
        public boolean shouldOverrideUrlLoading(BdWebPoolView bdWebPoolView, String str) {
            return false;
        }
    }

    /* loaded from: classes.dex */
    class BdBrowserCustomChromeClient extends BdExploreChromeClient {
        public BdBrowserCustomChromeClient(BdExploreView bdExploreView) {
            super(bdExploreView);
        }
    }

    @Override // com.baidu.browser.Browser.BrowserListener
    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
    }

    @Override // com.baidu.browser.Browser.BrowserListener
    public void onDownloadStartNoStream(String str, String str2, String str3, String str4, long j) {
    }

    @Override // com.baidu.browser.Browser.BrowserListener
    public Bundle onTabChangStarted(Bundle bundle) {
        return null;
    }

    @Override // com.baidu.browser.Browser.BrowserListener
    public Bundle onTabChangeFinished(Bundle bundle) {
        return null;
    }

    @Override // com.baidu.browser.Browser.BrowserListener
    public Message onRequestCopyHref() {
        return null;
    }

    @Override // com.baidu.browser.Browser.BrowserListener
    public void onProtocolSearch(String str) {
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        switch (((Message) obj).what) {
            case 0:
                BdLog.d("zerob13 unziping");
                return;
            case 1:
                BdLog.d("zerob13 delete zues");
                return;
            case 2:
                BdLog.d("zerob13 install successed");
                return;
            case 3:
                BdLog.d("zerob13 install failed");
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.browser.explorer.BdExploreViewListener
    public void onWebViewTouch(MotionEvent motionEvent) {
    }

    @Override // com.baidu.browser.Browser.BrowserListener
    public boolean shouldOverrideUrlLoading(BdWebPoolView bdWebPoolView, String str) {
        return false;
    }
}
