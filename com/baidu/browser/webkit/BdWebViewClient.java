package com.baidu.browser.webkit;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.HttpAuthHandler;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.baidu.browser.webkit.sys.BdSysWebViewClient;
import com.baidu.browser.webkit.zeus.BdZeusWebViewClient;
import java.lang.ref.SoftReference;
/* loaded from: classes.dex */
public class BdWebViewClient {
    public static final int ERROR_AUTHENTICATION = -4;
    public static final int ERROR_BAD_URL = -12;
    public static final int ERROR_CONNECT = -6;
    public static final int ERROR_FAILED_SSL_HANDSHAKE = -11;
    public static final int ERROR_FILE = -13;
    public static final int ERROR_FILE_NOT_FOUND = -14;
    public static final int ERROR_HOST_LOOKUP = -2;
    public static final int ERROR_IO = -7;
    public static final int ERROR_PROXY_AUTHENTICATION = -5;
    public static final int ERROR_REDIRECT_LOOP = -9;
    public static final int ERROR_TIMEOUT = -8;
    public static final int ERROR_TOO_MANY_REQUESTS = -15;
    public static final int ERROR_UNKNOWN = -1;
    public static final int ERROR_UNSUPPORTED_AUTH_SCHEME = -3;
    public static final int ERROR_UNSUPPORTED_SCHEME = -10;
    private SoftReference<BdHttpAuthHandler> mHttpAuthHandlerWrapper;
    private SoftReference<BdSslErrorHandler> mSslErrorHandlerWrapper;
    private SoftReference<BdSslError> mSslErrorWrapper;
    private BdSysWebViewClient mSysWebViewClient;
    private BdZeusWebViewClient mZeusWebViewClient;

    public BdWebViewClient() {
        if (BdWebViewManager.getInstance().isZeusLoaded()) {
            this.mZeusWebViewClient = new BdZeusWebViewClient(this);
        } else {
            this.mSysWebViewClient = new BdSysWebViewClient(this);
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof BdWebViewClient) && unwrap() == ((BdWebViewClient) obj).unwrap();
    }

    public int hashCode() {
        return this.mZeusWebViewClient != null ? this.mZeusWebViewClient.hashCode() : this.mSysWebViewClient.hashCode();
    }

    public boolean isContains(Object obj) {
        return this.mZeusWebViewClient != null ? this.mZeusWebViewClient == obj : this.mSysWebViewClient == obj;
    }

    public Object unwrap() {
        return this.mZeusWebViewClient != null ? this.mZeusWebViewClient : this.mSysWebViewClient;
    }

    public BdWebView obtainWebViewWrapper(WebView webView) {
        return (BdWebView) webView.getTag();
    }

    public BdWebView obtainWebViewWrapper(com.baidu.zeus.WebView webView) {
        return (BdWebView) webView.getTag();
    }

    public BdSslErrorHandler obtainSslErrorHandlerWrapper(SslErrorHandler sslErrorHandler) {
        BdSslErrorHandler bdSslErrorHandler = null;
        if (this.mSslErrorHandlerWrapper != null) {
            bdSslErrorHandler = this.mSslErrorHandlerWrapper.get();
        }
        if (bdSslErrorHandler == null || !bdSslErrorHandler.isContains(sslErrorHandler)) {
            BdSslErrorHandler bdSslErrorHandler2 = new BdSslErrorHandler(sslErrorHandler);
            this.mSslErrorHandlerWrapper = new SoftReference<>(bdSslErrorHandler2);
            return bdSslErrorHandler2;
        }
        return bdSslErrorHandler;
    }

    public BdSslErrorHandler obtainSslErrorHandlerWrapper(com.baidu.zeus.SslErrorHandler sslErrorHandler) {
        BdSslErrorHandler bdSslErrorHandler = null;
        if (this.mSslErrorHandlerWrapper != null) {
            bdSslErrorHandler = this.mSslErrorHandlerWrapper.get();
        }
        if (bdSslErrorHandler == null || !bdSslErrorHandler.isContains(sslErrorHandler)) {
            BdSslErrorHandler bdSslErrorHandler2 = new BdSslErrorHandler(sslErrorHandler);
            this.mSslErrorHandlerWrapper = new SoftReference<>(bdSslErrorHandler2);
            return bdSslErrorHandler2;
        }
        return bdSslErrorHandler;
    }

    public BdSslError obtainSslErrorWrapper(SslError sslError) {
        BdSslError bdSslError = null;
        if (this.mSslErrorWrapper != null) {
            bdSslError = this.mSslErrorWrapper.get();
        }
        if (bdSslError == null || !bdSslError.isContains(sslError)) {
            BdSslError bdSslError2 = new BdSslError(sslError);
            this.mSslErrorWrapper = new SoftReference<>(bdSslError2);
            return bdSslError2;
        }
        return bdSslError;
    }

    public BdSslError obtainSslErrorWrapper(com.baidu.zeus.SslError sslError) {
        BdSslError bdSslError = null;
        if (this.mSslErrorWrapper != null) {
            bdSslError = this.mSslErrorWrapper.get();
        }
        if (bdSslError == null || !bdSslError.isContains(sslError)) {
            BdSslError bdSslError2 = new BdSslError(sslError);
            this.mSslErrorWrapper = new SoftReference<>(bdSslError2);
            return bdSslError2;
        }
        return bdSslError;
    }

    public BdHttpAuthHandler obtainHttpAuthHandlerWrapper(HttpAuthHandler httpAuthHandler) {
        BdHttpAuthHandler bdHttpAuthHandler = null;
        if (this.mHttpAuthHandlerWrapper != null) {
            bdHttpAuthHandler = this.mHttpAuthHandlerWrapper.get();
        }
        if (bdHttpAuthHandler == null || !bdHttpAuthHandler.isContains(httpAuthHandler)) {
            BdHttpAuthHandler bdHttpAuthHandler2 = new BdHttpAuthHandler(httpAuthHandler);
            this.mHttpAuthHandlerWrapper = new SoftReference<>(bdHttpAuthHandler2);
            return bdHttpAuthHandler2;
        }
        return bdHttpAuthHandler;
    }

    public BdHttpAuthHandler obtainHttpAuthHandlerWrapper(com.baidu.zeus.HttpAuthHandler httpAuthHandler) {
        BdHttpAuthHandler bdHttpAuthHandler = null;
        if (this.mHttpAuthHandlerWrapper != null) {
            bdHttpAuthHandler = this.mHttpAuthHandlerWrapper.get();
        }
        if (bdHttpAuthHandler == null || !bdHttpAuthHandler.isContains(httpAuthHandler)) {
            BdHttpAuthHandler bdHttpAuthHandler2 = new BdHttpAuthHandler(httpAuthHandler);
            this.mHttpAuthHandlerWrapper = new SoftReference<>(bdHttpAuthHandler2);
            return bdHttpAuthHandler2;
        }
        return bdHttpAuthHandler;
    }

    public boolean shouldOverrideUrlLoading(BdWebView bdWebView, String str) {
        return false;
    }

    public void onPageStarted(BdWebView bdWebView, String str, Bitmap bitmap) {
    }

    public void onPageFinished(BdWebView bdWebView, String str) {
    }

    public void onLoadResource(BdWebView bdWebView, String str) {
    }

    public void onReceivedError(BdWebView bdWebView, int i, String str, String str2) {
    }

    public void onFormResubmission(BdWebView bdWebView, Message message, Message message2) {
        message.sendToTarget();
    }

    public void doUpdateVisitedHistory(BdWebView bdWebView, String str, boolean z) {
    }

    public void onReceivedSslError(BdWebView bdWebView, BdSslErrorHandler bdSslErrorHandler, BdSslError bdSslError) {
        bdSslErrorHandler.cancel();
    }

    public void onReceivedHttpAuthRequest(BdWebView bdWebView, BdHttpAuthHandler bdHttpAuthHandler, String str, String str2) {
        bdHttpAuthHandler.cancel();
    }

    public boolean shouldOverrideKeyEvent(BdWebView bdWebView, KeyEvent keyEvent) {
        return false;
    }

    public void onUnhandledKeyEvent(BdWebView bdWebView, KeyEvent keyEvent) {
    }

    public void onScaleChanged(BdWebView bdWebView, float f, float f2) {
    }

    public void onWapPageStarted(BdWebView bdWebView, String str, boolean z) {
    }

    public void onWapPageFinished(BdWebView bdWebView, String str) {
    }

    public void onBaiduSearchPVCollected(BdWebView bdWebView) {
    }

    public void onFirstLayoutDid(BdWebView bdWebView, String str) {
    }

    public void onSubjectsCollected(BdWebView bdWebView, boolean z, int i) {
    }

    public boolean shouldShowSubject(BdWebView bdWebView, String str, String str2, String str3) {
        return false;
    }

    public void onMainActionsCollected(BdWebView bdWebView, boolean z, int i) {
    }

    public void onPageCanBeScaled(BdWebView bdWebView) {
    }

    public void onFullScreenMode(BdWebView bdWebView, boolean z, int i, int i2) {
    }

    public void onHasVideo(BdWebView bdWebView) {
    }
}
