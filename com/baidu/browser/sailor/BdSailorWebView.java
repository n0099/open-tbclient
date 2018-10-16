package com.baidu.browser.sailor;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Rect;
import android.net.Uri;
import android.net.http.SslCertificate;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.ConsoleMessage;
import android.webkit.DownloadListener;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import com.baidu.browser.sailor.g;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.webkit.internal.ETAG;
import com.baidu.webkit.internal.GlobalConstants;
import com.baidu.webkit.internal.utils.NetWorkUtils;
import com.baidu.webkit.sdk.ClientCertRequest;
import com.baidu.webkit.sdk.GeolocationPermissions;
import com.baidu.webkit.sdk.HttpAuthHandler;
import com.baidu.webkit.sdk.JsPromptResult;
import com.baidu.webkit.sdk.JsResult;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.PageTransformer;
import com.baidu.webkit.sdk.PermissionRequest;
import com.baidu.webkit.sdk.VideoPlayerFactory;
import com.baidu.webkit.sdk.WebAppShortcutDataListener;
import com.baidu.webkit.sdk.WebBackForwardListClient;
import com.baidu.webkit.sdk.WebChromeClient;
import com.baidu.webkit.sdk.WebHistoryItem;
import com.baidu.webkit.sdk.WebResourceError;
import com.baidu.webkit.sdk.WebResourceRequest;
import com.baidu.webkit.sdk.WebResourceResponse;
import com.baidu.webkit.sdk.WebStorage;
import com.baidu.webkit.sdk.WebView;
import com.baidu.webkit.sdk.WebViewClient;
import com.baidu.webkit.sdk.WebViewDelegate;
import com.baidu.webkit.sdk.jsapi.IJsAbility;
import com.baidu.webkit.sdk.performance.ZeusPerformanceTiming;
import com.googlecode.mp4parser.boxes.apple.TrackLoadSettingsAtom;
import java.util.Map;
/* loaded from: classes2.dex */
public class BdSailorWebView extends FrameLayout {
    private static final String JAVASCTIPT_URL = "javascript:";
    private static final String SHOW_IMAGE_PREFIX = "imagedisplay:";
    private boolean mCanHideTitlebar;
    private boolean mCanShowTitlebar;
    private WebView mCurrentWebView;
    private View mCustomView;
    private WebChromeClient.CustomViewCallback mCustomViewCallback;
    private i mDownloadListener;
    private View mEmbeddedTitlebar;
    private int mEmbeddedTitlebarHeightPix;
    private FrameLayout mFullscreenContainer;
    private FrameLayout mFunctionViewLayer;
    private boolean mIsFunctionLayerShowing;
    private boolean mIsPageLoading;
    private com.baidu.browser.sailor.a.a mLightappActionClient;
    private com.baidu.browser.sailor.a.c mLightappKernelClient;
    private boolean mLockEmbeddedTitlebar;
    private int mMarginBottom;
    private int mMarginLeft;
    private int mMarginRight;
    private int mMarginTop;
    private int mOriginalOrientation;
    private int mOuterTitlebarHeightPix;
    protected WebView.PictureListener mPictureListener;
    private int mSnapBgColor;
    com.baidu.browser.sailor.feature.a.e mStopBackgroundkListener;
    private VideoPlayerFactory mVideoFactory;
    private h mViewDelegate;
    private com.baidu.browser.sailor.e mWebChromeClient;
    private com.baidu.browser.sailor.g mWebSettings;
    private com.baidu.browser.sailor.h mWebViewClient;
    private k mWebViewExt;
    private FrameLayout mWebViewLayer;
    private FrameLayout.LayoutParams mWebViewLayerLp;
    private static final String LOG_TAG = BdSailorWebView.class.getSimpleName();
    protected static final FrameLayout.LayoutParams COVER_SCREEN_PARAMS = new FrameLayout.LayoutParams(-1, -1);
    private static boolean sInitFirstWebView = true;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements k {
        private j VF;
        private BdSailorWebViewClientExt VG;
        private com.baidu.browser.sailor.f VH;

        private a() {
        }

        /* synthetic */ a(BdSailorWebView bdSailorWebView, l lVar) {
            this();
        }

        @Override // com.baidu.browser.sailor.k
        public j getSettingsExt() {
            if (this.VF == null) {
                com.baidu.browser.sailor.g settings = BdSailorWebView.this.getSettings();
                settings.getClass();
                this.VF = new g.a();
            }
            return this.VF;
        }

        @Override // com.baidu.browser.sailor.k
        public boolean qA() {
            return BdSailorWebView.this.mCurrentWebView.getSelectingText();
        }

        @Override // com.baidu.browser.sailor.k
        public BdSailorWebViewClientExt qB() {
            return this.VG;
        }

        @Override // com.baidu.browser.sailor.k
        public com.baidu.browser.sailor.f qC() {
            return this.VH;
        }

        @Override // com.baidu.browser.sailor.k
        public void qz() {
        }

        @Override // com.baidu.browser.sailor.k
        public void setWebChromeClientExt(com.baidu.browser.sailor.f fVar) {
            this.VH = fVar;
        }

        @Override // com.baidu.browser.sailor.k
        public void setWebViewClientExt(BdSailorWebViewClientExt bdSailorWebViewClientExt) {
            this.VG = bdSailorWebViewClientExt;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b extends WebBackForwardListClient {
        private WebView VJ;

        protected b(WebView webView) {
            this.VJ = webView;
        }

        @Override // com.baidu.webkit.sdk.WebBackForwardListClient
        public final void onIndexChanged(WebHistoryItem webHistoryItem, int i) {
            super.onIndexChanged(webHistoryItem, i);
        }

        @Override // com.baidu.webkit.sdk.WebBackForwardListClient
        public final void onNewHistoryItem(WebHistoryItem webHistoryItem) {
            if (BdSailorWebView.this.mWebViewExt.qB() != null) {
                BdSailorWebView.this.mWebViewExt.qB().onNewPage(BdSailorWebView.this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class c implements WebView.PictureListener {
        private c() {
        }

        /* synthetic */ c(BdSailorWebView bdSailorWebView, byte b) {
            this();
        }

        @Override // com.baidu.webkit.sdk.WebView.PictureListener
        public final void onNewPicture(WebView webView, Picture picture) {
            if (BdSailorWebView.this.mPictureListener != null) {
                BdSailorWebView.this.mPictureListener.onNewPicture(webView, picture);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class d implements DownloadListener {
        private WebView VJ;

        public d(WebView webView) {
            this.VJ = webView;
        }

        @Override // android.webkit.DownloadListener
        public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            Log.d("// BdSailorMonitorEngine", "BdDownloadListenerBridge.onDownloadStart l=" + j + ", ---> s=" + str + ", --->s1=" + str2 + ", ---> s2=" + str3 + ", --- s3=" + str4);
            if (BdSailorWebView.this.mDownloadListener != null) {
                BdSailorWebView.this.mDownloadListener.onDownloadStart(str, str2, str3, str4, j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class e extends WebChromeClient {
        private String[] b = {"mail.163.com", "mail.126.com", "mail.yeah.net", "shouji.163.com"};

        public e() {
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void copyText(WebView webView, String str) {
            if (BdSailorWebView.this.mWebViewExt.qC() != null) {
                BdSailorWebView.this.mWebViewExt.qC().b(BdSailorWebView.this, str);
            } else {
                super.copyText(webView, str);
            }
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void doTextSearch(WebView webView, String str) {
            super.doTextSearch(webView, str);
            if (BdSailorWebView.this.mWebChromeClient != null) {
                BdSailorWebView.this.mWebChromeClient.doTextSearchExt(BdSailorWebView.this, str);
            }
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void doTextTranslate(WebView webView, String str) {
            if (BdSailorWebView.this.mWebChromeClient != null) {
                BdSailorWebView.this.mWebChromeClient.doTextTranslateExt(BdSailorWebView.this, str);
            } else {
                super.doTextTranslate(webView, str);
            }
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final Bitmap getDefaultVideoPoster() {
            return BdSailorWebView.this.mWebChromeClient != null ? BdSailorWebView.this.mWebChromeClient.getDefaultVideoPoster(BdSailorWebView.this) : super.getDefaultVideoPoster();
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final View getVideoLoadingProgressView() {
            return BdSailorWebView.this.mWebChromeClient != null ? BdSailorWebView.this.mWebChromeClient.getVideoLoadingProgressView(BdSailorWebView.this) : super.getVideoLoadingProgressView();
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void getVisitedHistory(ValueCallback<String[]> valueCallback) {
            if (BdSailorWebView.this.mWebChromeClient != null) {
                BdSailorWebView.this.mWebChromeClient.getVisitedHistory(BdSailorWebView.this, valueCallback);
            } else {
                super.getVisitedHistory(valueCallback);
            }
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void hideMagnifier(WebView webView, int i, int i2) {
            if (BdSailorWebView.this.mWebViewExt.qC() != null) {
                BdSailorWebView.this.mWebViewExt.qC().a(BdSailorWebView.this, i, i2);
            } else {
                super.hideMagnifier(webView, i, i2);
            }
            BdSailorWebView.this.mIsFunctionLayerShowing = false;
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void hideSelectionActionDialog(WebView webView) {
            if (BdSailorWebView.this.mWebViewExt.qC() != null) {
                BdSailorWebView.this.mWebViewExt.qC().b(BdSailorWebView.this);
            } else {
                super.hideSelectionActionDialog(webView);
            }
            BdSailorWebView.this.mIsFunctionLayerShowing = false;
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void moveMagnifier(WebView webView, int i, int i2, int i3, int i4) {
            if (BdSailorWebView.this.mWebViewExt.qC() != null) {
                BdSailorWebView.this.mWebViewExt.qC().b(BdSailorWebView.this, i, i2, i3, i4);
            } else {
                super.moveMagnifier(webView, i, i2, i3, i4);
            }
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final boolean needNotifyNativeExitFullScreen() {
            return BdSailorWebView.this.mWebViewExt.qC() != null ? BdSailorWebView.this.mWebViewExt.qC().c(BdSailorWebView.this) : super.needNotifyNativeExitFullScreen();
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void notifyClickWhenLoad() {
            if (BdSailorWebView.this.mWebViewExt.qC() != null) {
                BdSailorWebView.this.mWebViewExt.qC().d(BdSailorWebView.this);
            } else {
                super.notifyClickWhenLoad();
            }
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void notifyClientStatus(WebView webView, int i) {
            if (BdSailorWebView.this.mWebViewExt.qC() != null) {
                BdSailorWebView.this.mWebViewExt.qC().a(BdSailorWebView.this, i);
            } else {
                super.notifyClientStatus(webView, i);
            }
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void onCloseWindow(WebView webView) {
            if (BdSailorWebView.this.mWebChromeClient != null) {
                BdSailorWebView.this.mWebChromeClient.onCloseWindow(BdSailorWebView.this);
            } else {
                super.onCloseWindow(webView);
            }
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            boolean onConsoleMessage = super.onConsoleMessage(consoleMessage);
            return (BdSailorWebView.this.mWebChromeClient == null || onConsoleMessage) ? onConsoleMessage : BdSailorWebView.this.mWebChromeClient.onConsoleMessage(BdSailorWebView.this, consoleMessage);
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
            return BdSailorWebView.this.mWebChromeClient != null ? BdSailorWebView.this.mWebChromeClient.onCreateWindow(BdSailorWebView.this, z, z2, message) : super.onCreateWindow(webView, z, z2, message);
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
            super.onExceededDatabaseQuota(str, str2, j, j2, j3, quotaUpdater);
            if (BdSailorWebView.this.mWebChromeClient != null) {
                BdSailorWebView.this.mWebChromeClient.onExceededDatabaseQuota(BdSailorWebView.this, str, str2, j, j2, j3, quotaUpdater);
            }
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void onGeolocationPermissionsHidePrompt() {
            if (BdSailorWebView.this.mWebChromeClient != null) {
                BdSailorWebView.this.mWebChromeClient.onGeolocationPermissionsHidePrompt(BdSailorWebView.this);
            } else {
                super.onGeolocationPermissionsHidePrompt();
            }
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
            if (BdSailorWebView.this.mWebChromeClient != null) {
                BdSailorWebView.this.mWebChromeClient.onGeolocationPermissionsShowPrompt(BdSailorWebView.this, str, callback);
            }
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void onHideCustomView() {
            if (BdSailorWebView.this.mWebChromeClient != null ? BdSailorWebView.this.mWebChromeClient.onHideCustomView(BdSailorWebView.this) : false) {
                return;
            }
            BdSailorWebView.this.hideCustomView();
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            boolean z = BdSailorWebView.this.mWebChromeClient != null && BdSailorWebView.this.mWebChromeClient.onJsAlert(BdSailorWebView.this, str, str2, jsResult);
            return !z ? super.onJsAlert(webView, str, str2, jsResult) : z;
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
            if (!TextUtils.isEmpty(str)) {
                String host = Uri.parse(str).getHost();
                if (!TextUtils.isEmpty(host)) {
                    for (String str3 : this.b) {
                        if (host.contains(str3)) {
                            jsResult.confirm();
                            return true;
                        }
                    }
                }
            }
            if (super.onJsBeforeUnload(webView, str, str2, jsResult)) {
                return true;
            }
            return BdSailorWebView.this.mWebChromeClient != null && BdSailorWebView.this.mWebChromeClient.onJsBeforeUnload(BdSailorWebView.this, str, str2, jsResult);
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
            return BdSailorWebView.this.mWebChromeClient != null ? BdSailorWebView.this.mWebChromeClient.onJsConfirm(BdSailorWebView.this, str, str2, jsResult) : super.onJsConfirm(webView, str, str2, jsResult);
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            if (super.onJsPrompt(webView, str, str2, str3, jsPromptResult)) {
                return true;
            }
            if (BdSailorWebView.this.mWebChromeClient != null) {
                return BdSailorWebView.this.mWebChromeClient.onJsPrompt(BdSailorWebView.this, str, str2, str3, jsPromptResult);
            }
            return false;
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final boolean onJsTimeout() {
            if (super.onJsTimeout()) {
                return true;
            }
            return BdSailorWebView.this.mWebChromeClient != null && BdSailorWebView.this.mWebChromeClient.onJsTimeout(BdSailorWebView.this);
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void onNativeElementEnterFullScreen() {
            if (BdSailorWebView.this.mWebViewExt.qC() != null) {
                BdSailorWebView.this.mWebViewExt.qC().e(BdSailorWebView.this);
            } else {
                super.onNativeElementEnterFullScreen();
            }
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void onNativeElementExitFullScreen() {
            if (BdSailorWebView.this.mWebViewExt.qC() != null) {
                BdSailorWebView.this.mWebViewExt.qC().f(BdSailorWebView.this);
            } else {
                super.onNativeElementExitFullScreen();
            }
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void onOffsetsForFullscreenChanged(float f, float f2, float f3) {
            BdSailorWebView.this.setTopControlsHeight(BdSailorWebView.this.mEmbeddedTitlebarHeightPix, f2 > 0.0f);
            if (BdSailorWebView.this.mWebChromeClient != null) {
                BdSailorWebView.this.mWebChromeClient.onOffsetsForFullscreenChanged(BdSailorWebView.this, f, f2, f3);
            } else {
                super.onOffsetsForFullscreenChanged(f, f2, f3);
            }
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void onPermissionRequest(PermissionRequest permissionRequest) {
            if (BdSailorWebView.this.mWebChromeClient != null) {
                BdSailorWebView.this.mWebChromeClient.onPermissionRequest(BdSailorWebView.this, permissionRequest);
            } else {
                super.onPermissionRequest(permissionRequest);
            }
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void onPermissionRequestCanceled(PermissionRequest permissionRequest) {
            if (BdSailorWebView.this.mWebChromeClient != null) {
                BdSailorWebView.this.mWebChromeClient.onPermissionRequestCanceled(BdSailorWebView.this, permissionRequest);
            } else {
                super.onPermissionRequestCanceled(permissionRequest);
            }
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void onPrerenderChanged(int i, WebView.PrerenderStatus prerenderStatus) {
            super.onPrerenderChanged(i, prerenderStatus);
            if (BdSailorWebView.this.mWebViewExt.qC() != null) {
                BdSailorWebView.this.mWebViewExt.qC().onPrerenderChanged(i, prerenderStatus);
            }
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
            if (BdSailorWebView.this.mWebChromeClient != null) {
                BdSailorWebView.this.mWebChromeClient.onProgressChanged(BdSailorWebView.this, i);
            }
            if (webView == BdSailorWebView.this.mCurrentWebView && i == 100) {
                BdSailorWebView.this.mIsPageLoading = false;
            }
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void onReachedMaxAppCacheSize(long j, long j2, WebStorage.QuotaUpdater quotaUpdater) {
            super.onReachedMaxAppCacheSize(j, j2, quotaUpdater);
            if (BdSailorWebView.this.mWebChromeClient != null) {
                BdSailorWebView.this.mWebChromeClient.onReachedMaxAppCacheSize(BdSailorWebView.this, j, j2, quotaUpdater);
            }
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void onReceivedIcon(WebView webView, Bitmap bitmap) {
            if (BdSailorWebView.this.mWebChromeClient != null) {
                BdSailorWebView.this.mWebChromeClient.onReceivedIcon(BdSailorWebView.this, bitmap);
            } else {
                super.onReceivedIcon(webView, bitmap);
            }
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            if (BdSailorWebView.this.mWebChromeClient != null) {
                BdSailorWebView.this.mWebChromeClient.onReceivedTitle(BdSailorWebView.this, str);
            }
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void onReceivedTouchIconUrl(WebView webView, String str, boolean z) {
            if (BdSailorWebView.this.mWebChromeClient != null) {
                BdSailorWebView.this.mWebChromeClient.onReceivedTouchIconUrl(BdSailorWebView.this, str, z);
            } else {
                super.onReceivedTouchIconUrl(webView, str, z);
            }
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void onRequestFocus(WebView webView) {
            if (BdSailorWebView.this.mWebChromeClient != null) {
                BdSailorWebView.this.mWebChromeClient.onRequestFocus(BdSailorWebView.this);
            } else {
                super.onRequestFocus(webView);
            }
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void onSetLoadURL(WebView webView, String str) {
            super.onSetLoadURL(webView, str);
            if (BdSailorWebView.this.mWebViewExt.qC() != null) {
                BdSailorWebView.this.mWebViewExt.qC().a(BdSailorWebView.this, str);
            }
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void onShowCustomView(View view, int i, WebChromeClient.CustomViewCallback customViewCallback) {
            if (BdSailorWebView.this.mWebChromeClient != null ? BdSailorWebView.this.mWebChromeClient.onShowCustomView(BdSailorWebView.this, view, i, customViewCallback) : false) {
                return;
            }
            BdSailorWebView.this.showCustomView(BdSailorWebView.this.getContext(), view, customViewCallback);
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
            if (BdSailorWebView.this.mWebChromeClient != null ? BdSailorWebView.this.mWebChromeClient.onShowCustomView(BdSailorWebView.this, view, customViewCallback) : false) {
                return;
            }
            BdSailorWebView.this.showCustomView(BdSailorWebView.this.getContext(), view, customViewCallback);
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            return BdSailorWebView.this.mWebChromeClient != null ? BdSailorWebView.this.mWebChromeClient.onShowFileChooser(BdSailorWebView.this, valueCallback, fileChooserParams) : super.onShowFileChooser(webView, valueCallback, fileChooserParams);
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void openFileChooser(ValueCallback<Uri> valueCallback) {
            if (BdSailorWebView.this.mWebChromeClient != null) {
                BdSailorWebView.this.mWebChromeClient.openFileChooser(BdSailorWebView.this, valueCallback);
            } else {
                super.openFileChooser(valueCallback);
            }
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void openFileChooser(ValueCallback<Uri> valueCallback, String str) {
            if (BdSailorWebView.this.mWebChromeClient != null) {
                BdSailorWebView.this.mWebChromeClient.openFileChooser(BdSailorWebView.this, valueCallback, str);
            } else {
                super.openFileChooser(valueCallback, str);
            }
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
            if (BdSailorWebView.this.mWebChromeClient != null) {
                BdSailorWebView.this.mWebChromeClient.openFileChooser(BdSailorWebView.this, valueCallback, str, str2);
            } else {
                super.openFileChooser(valueCallback, str, str2);
            }
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void performLongClick(WebView webView, int i, String str, String str2, int i2, int i3) {
            super.performLongClick(webView, i, str, str2, i2, i3);
            if (com.baidu.browser.sailor.util.a.qX() || Build.VERSION.SDK_INT >= 19) {
                if (BdSailorWebView.this.mWebViewExt != null && BdSailorWebView.this.mWebViewExt.qC() != null) {
                    BdSailorWebView.this.mIsFunctionLayerShowing = true;
                    BdSailorWebView.this.mWebViewExt.qC().a(BdSailorWebView.this, i, str, str2, i2, i3);
                }
                if (i == 5 || i == 8) {
                    BdSailorWebView.this.getWebViewExt().qz();
                }
            }
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void performLongClick(WebView webView, WebView.HitTestResult hitTestResult, int i, int i2) {
            super.performLongClick(webView, hitTestResult, i, i2);
            if (com.baidu.browser.sailor.util.a.qX() || Build.VERSION.SDK_INT >= 19) {
                if (BdSailorWebView.this.mWebViewExt != null && BdSailorWebView.this.mWebViewExt.qC() != null) {
                    BdSailorWebView.this.mIsFunctionLayerShowing = true;
                    BdSailorWebView.this.mWebViewExt.qC().a(BdSailorWebView.this, hitTestResult, i, i2);
                }
                if (hitTestResult.getType() == 5 || hitTestResult.getType() == 8) {
                    BdSailorWebView.this.getWebViewExt().qz();
                }
            }
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void showMagnifier(WebView webView, int i, int i2, int i3, int i4) {
            BdSailorWebView.this.mIsFunctionLayerShowing = true;
            if (BdSailorWebView.this.mWebViewExt.qC() != null) {
                BdSailorWebView.this.mWebViewExt.qC().a(BdSailorWebView.this, i, i2, i3, i4);
            } else {
                super.showMagnifier(webView, i, i2, i3, i4);
            }
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void showSelectionActionDialog(WebView webView, int i, int i2, int i3, int i4, String str) {
            BdSailorWebView.this.mIsFunctionLayerShowing = true;
            if (BdSailorWebView.this.mWebViewExt.qC() != null) {
                BdSailorWebView.this.mWebViewExt.qC().a(BdSailorWebView.this, i, i2, i3, i4, str);
            } else {
                super.showSelectionActionDialog(webView, i, i2, i3, i4, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class f extends WebViewClient {
        private String[] b;

        private f() {
            this.b = new String[]{"wtai://", WebView.SCHEME_TEL, "sms:", "mailto", "smsto:"};
        }

        /* synthetic */ f(BdSailorWebView bdSailorWebView, byte b) {
            this();
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void AntiHijackSign(WebView webView, String str) {
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final boolean canHandleImage(WebView webView, String str, String str2, String str3) {
            if (BdSailorWebView.this.mWebViewExt.qB() != null) {
                r5 = BdSailorWebView.this.mWebViewExt.qB().shouldHandleImageExt(BdSailorWebView.this, str, str2, str3, BdSailorWebView.this.mCurrentWebView == webView);
            }
            if (r5) {
                BdSailorWebView.this.stopLoading();
                return true;
            }
            return super.canHandleImage(webView, str, str2, str3);
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void doUpdateVisitedHistory(WebView webView, String str, boolean z, boolean z2, boolean z3, boolean z4) {
            super.doUpdateVisitedHistory(webView, str, z, z2, z3, z4);
            if (BdSailorWebView.this.mWebViewClient != null) {
                BdSailorWebView.this.mWebViewClient.doUpdateVisitedHistory(BdSailorWebView.this, str, z);
            }
            if (BdSailorWebView.this.mWebViewExt.qB() != null) {
                BdSailorWebView.this.mWebViewExt.qB().doUpdateVisitedHistory(BdSailorWebView.this, str, z, z2, z3, z4);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onAbortResourceRequest(WebView webView, String str, String str2, long j) {
            if (!(webView instanceof WebView) || BdSailorWebView.this.isDestroyed() || BdSailorWebView.this.mWebViewExt == null || BdSailorWebView.this.mWebViewExt.qB() == null) {
                return;
            }
            BdSailorWebView.this.mWebViewExt.qB().onAbortResourceRequest(BdSailorWebView.this, str, str2, j);
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onCheckHasManifestAndServiceWorker(WebView webView, String str, String str2, boolean z) {
            if (BdSailorWebView.this.mWebViewExt.qB() != null) {
                BdSailorWebView.this.mWebViewExt.qB().onCheckHasManifestAndServiceWorker(BdSailorWebView.this, str, str2, z);
            } else {
                super.onCheckHasManifestAndServiceWorker(webView, str, str2, z);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onDidAsyncWiseSearchStatusChanged(WebView webView, String str, int i, long j) {
            super.onDidAsyncWiseSearchStatusChanged(webView, str, i, j);
            if (BdSailorWebView.this.mWebViewExt == null || BdSailorWebView.this.mWebViewExt.qB() == null) {
                return;
            }
            BdSailorWebView.this.mWebViewExt.qB().onDidAsyncWiseSearchStatusChangedExt(BdSailorWebView.this, str, i, j);
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onDisplaySoftKeyboard(WebView webView) {
            if (BdSailorWebView.this.mWebViewExt.qB() != null) {
                BdSailorWebView.this.mWebViewExt.qB().onDisplaySoftKeyboardExt(BdSailorWebView.this);
            } else {
                super.onDisplaySoftKeyboard(webView);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onFirstLayoutDid(WebView webView, String str) {
            BdSailorWebView.this.perfLog(webView, "onFirstLayoutDid");
            super.onFirstLayoutDid(webView, str);
            if (BdSailorWebView.this.mWebViewExt == null || BdSailorWebView.this.mWebViewExt.qB() == null) {
                return;
            }
            BdSailorWebView.this.mWebViewExt.qB().onFirstLayoutDidExt(BdSailorWebView.this, str);
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onFirstPaintDid(WebView webView, String str) {
            BdSailorWebView.this.perfLog(webView, "onFirstPaintDid", "Started");
            super.onFirstPaintDid(webView, str);
            if (BdSailorWebView.this.mWebViewExt != null && BdSailorWebView.this.mWebViewExt.qB() != null) {
                BdSailorWebView.this.mWebViewExt.qB().onFirstPaintDidExt(BdSailorWebView.this, str);
            }
            BdSailorWebView.this.perfLog(webView, "onFirstPaintDid", "Finished");
            BdSailorWebView.this.perfLog(ETAG.KEY_FIRST_PAINT, str);
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onFirstScreenPaintFinished(WebView webView, String str, int i, int i2, int i3, int i4, int i5) {
            BdSailorWebView.this.perfLog(webView, "onFirstScreenPaintFinished");
            super.onFirstScreenPaintFinished(webView, str, i, i2, i3, i4, i5);
            if (BdSailorWebView.this.mWebViewExt == null || BdSailorWebView.this.mWebViewExt.qB() == null) {
                return;
            }
            BdSailorWebView.this.perfLog(webView, "onFirstScreenPaintFinished 22");
            BdSailorWebView.this.mWebViewExt.qB().onFirstScreenPaintFinishedExt(BdSailorWebView.this, str);
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onFormResubmission(WebView webView, Message message, Message message2) {
            if (BdSailorWebView.this.mWebViewClient != null) {
                BdSailorWebView.this.mWebViewClient.onFormResubmission(BdSailorWebView.this, message, message2);
            } else {
                super.onFormResubmission(webView, message, message2);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onFullScreenMode(WebView webView, boolean z, int i, int i2) {
            if (BdSailorWebView.this.mWebViewExt.qB() != null) {
                BdSailorWebView.this.mWebViewExt.qB().onFullScreenModeExt(BdSailorWebView.this, z, i, i2);
            } else {
                super.onFullScreenMode(webView, z, i, i2);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final String onGetErrorContent(WebView webView, int i, String str, String str2) {
            String str3 = null;
            if ((webView instanceof WebView) && !BdSailorWebView.this.isDestroyed() && BdSailorWebView.this.mWebViewExt != null && BdSailorWebView.this.mWebViewExt.qB() != null) {
                str3 = BdSailorWebView.this.mWebViewExt.qB().onGetErrorHtmlExt(BdSailorWebView.this, i, str, str2);
            }
            return str3 != null ? str3 : com.baidu.browser.sailor.b.a.aZ(webView.getContext());
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onGoBackOrForward(WebView webView, int i) {
            if (webView == BdSailorWebView.this.mCurrentWebView) {
                BdSailorWebView.this.goBackOrForward(i);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onGoBackOrForwardAnimationFinish(WebView webView, int i) {
            BdSailorWebViewClientExt qB;
            if (webView != BdSailorWebView.this.mCurrentWebView || (qB = BdSailorWebView.this.getWebViewExt().qB()) == null) {
                return;
            }
            qB.onGoBackOrForwardAnimationFinish(BdSailorWebView.this, i);
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onGoBackOrForwardAnimationStart(WebView webView, int i) {
            BdSailorWebViewClientExt qB;
            if (webView != BdSailorWebView.this.mCurrentWebView || (qB = BdSailorWebView.this.getWebViewExt().qB()) == null) {
                return;
            }
            qB.onGoBackOrForwardAnimationStart(BdSailorWebView.this, i);
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onHasVideo(WebView webView) {
            if (BdSailorWebView.this.mWebViewExt.qB() != null) {
                BdSailorWebView.this.mWebViewExt.qB().onHasVideoExt(BdSailorWebView.this);
            } else {
                super.onHasVideo(webView);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onHideSoftKeyboard(WebView webView) {
            if (BdSailorWebView.this.mWebViewExt.qB() != null) {
                BdSailorWebView.this.mWebViewExt.qB().onHideSoftKeyboardExt(BdSailorWebView.this);
            } else {
                super.onHideSoftKeyboard(webView);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onHyperLink(WebView webView, String str, String str2) {
            super.onHyperLink(webView, str, str2);
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onKeywordExtension(WebView webView, String str, String str2) {
            if (BdSailorWebView.this.mWebViewExt.qB() != null ? BdSailorWebView.this.mWebViewExt.qB().onKeywordExtensionExt(BdSailorWebView.this, str, str2) : false) {
                return;
            }
            super.onKeywordExtension(webView, str, str2);
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onLoadResource(WebView webView, String str) {
            if (BdSailorWebView.this.mWebViewClient != null) {
                BdSailorWebView.this.mWebViewClient.onLoadResource(BdSailorWebView.this, str);
            } else {
                super.onLoadResource(webView, str);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onMagicFilterHideElement(WebView webView, String str, int i, int i2, int i3, int i4, int i5) {
            super.onMagicFilterHideElement(webView, str, i, i2, i3, i4, i5);
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onMainResourceHttpcodeDid(WebView webView, int i, String str) {
            super.onMainResourceHttpcodeDid(webView, i, str);
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onMainResourceResponseDid(WebView webView, String str) {
            super.onMainResourceResponseDid(webView, str);
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onNewHistoryItem(WebView webView, String str, int i) {
            if (BdSailorWebView.this.mWebViewExt == null || BdSailorWebView.this.mWebViewExt.qB() == null) {
                return;
            }
            BdSailorWebView.this.mWebViewExt.qB().onNewPage(BdSailorWebView.this);
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onPageCanBeScaled(WebView webView, boolean z) {
            if (BdSailorWebView.this.mWebViewExt == null || BdSailorWebView.this.mWebViewExt.qB() == null) {
                super.onPageCanBeScaled(webView, z);
            } else {
                BdSailorWebView.this.mWebViewExt.qB().onPageCanBeScaledExt(BdSailorWebView.this, z);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onPageCommitVisible(WebView webView, String str, boolean z) {
            super.onPageCommitVisible(webView, str, z);
            if (BdSailorWebView.this.mWebViewClient != null) {
                BdSailorWebView.this.mWebViewClient.onPageCommitVisible(BdSailorWebView.this, str);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onPageFinished(WebView webView, String str) {
            BdSailorWebView.this.perfLog(webView, "onPageFinished");
            super.onPageFinished(webView, str);
            if (BdSailorWebView.this.mWebViewClient != null) {
                BdSailorWebView.this.mWebViewClient.onPageFinished(BdSailorWebView.this, str);
            }
            if (webView == BdSailorWebView.this.mCurrentWebView) {
                BdSailorWebView.this.mIsPageLoading = false;
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            BdSailorWebView.this.perfLog(webView, "onPageStarted");
            super.onPageStarted(webView, str, bitmap);
            if (BdSailorWebView.this.mWebViewClient != null) {
                BdSailorWebView.this.mWebViewClient.onPageStarted(BdSailorWebView.this, str, bitmap);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onPageSwitching(WebView webView) {
            if (BdSailorWebView.this.isAutoShowTitlebar()) {
                BdSailorWebView.this.showEmbeddedTitleBar(false);
            }
            super.onPageSwitching(webView);
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onPausePlugin() {
            if (BdSailorWebView.this.mWebViewExt.qB() != null) {
                BdSailorWebView.this.mWebViewExt.qB().onPausePluginExt(BdSailorWebView.this);
            } else {
                super.onPausePlugin();
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onPlayPlugin() {
            if (BdSailorWebView.this.mWebViewExt.qB() != null) {
                BdSailorWebView.this.mWebViewExt.qB().onPlayPluginExt(BdSailorWebView.this);
            } else {
                super.onPlayPlugin();
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onPreloadUrlFound(WebView webView, String str) {
            super.onPreloadUrlFound(webView, str);
            if (BdSailorWebView.this.mWebViewExt == null || BdSailorWebView.this.mWebViewExt.qB() == null) {
                super.onPreloadUrlFound(webView, str);
            } else {
                BdSailorWebView.this.mWebViewExt.qB().onPreloadUrlFoundExt(BdSailorWebView.this, str);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onProceededAfterSslError(WebView webView, SslError sslError) {
            if (BdSailorWebView.this.mWebViewExt.qB() != null) {
                BdSailorWebView.this.mWebViewExt.qB().onProceededAfterSslErrorExt(BdSailorWebView.this, sslError);
            } else {
                super.onProceededAfterSslError(webView, sslError);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onReceivedClientCertRequest(WebView webView, ClientCertRequest clientCertRequest) {
            if (BdSailorWebView.this.mWebViewClient != null) {
                BdSailorWebView.this.mWebViewClient.onReceivedClientCertRequest(BdSailorWebView.this, clientCertRequest);
            } else {
                super.onReceivedClientCertRequest(webView, clientCertRequest);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            if (BdSailorWebView.this.mWebViewClient != null) {
                BdSailorWebView.this.mWebViewClient.onReceivedError(BdSailorWebView.this, i, str, str2);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            if (BdSailorWebView.this.mWebViewClient == null || !webResourceRequest.isForMainFrame()) {
                return;
            }
            if (webResourceRequest.getUrl().toString().startsWith("http://") || webResourceRequest.getUrl().toString().startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX)) {
                BdSailorWebView.this.mWebViewClient.onReceivedError(BdSailorWebView.this, webResourceError.getErrorCode(), webResourceError.getDescription().toString(), webResourceRequest.getUrl().toString());
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
            if (BdSailorWebView.this.mWebViewClient != null) {
                BdSailorWebView.this.mWebViewClient.onReceivedHttpAuthRequest(BdSailorWebView.this, httpAuthHandler, str, str2);
            } else {
                super.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            if (BdSailorWebView.this.mWebViewClient != null) {
                BdSailorWebView.this.mWebViewClient.onReceivedHttpError(BdSailorWebView.this, webResourceRequest, webResourceResponse);
            } else {
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
            if (BdSailorWebView.this.mWebViewClient != null) {
                BdSailorWebView.this.mWebViewClient.onReceivedLoginRequest(BdSailorWebView.this, str, str2, str3);
            } else {
                super.onReceivedLoginRequest(webView, str, str2, str3);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            com.baidu.browser.sailor.feature.a cC = com.baidu.browser.sailor.b.a.qR().cC("SSL");
            if (cC != null && cC.isEnable()) {
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
            } else if (BdSailorWebView.this.mWebViewClient != null) {
                BdSailorWebView.this.mWebViewClient.onReceivedSslError(BdSailorWebView.this, sslErrorHandler, sslError);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onResourceLoaded(WebView webView, String str, long j, String str2, String str3, int i) {
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onRestoreFromCache(WebView webView, String str) {
            if (BdSailorWebView.this.mWebViewExt.qB() == null) {
                super.onRestoreFromCache(webView, str);
                return;
            }
            BdSailorWebView.this.mWebViewExt.qB().onRestoreFromPageCacheDid(BdSailorWebView.this, str);
            BdSailorWebView.this.mWebViewExt.qB().onRestoreFromCache(BdSailorWebView.this, str);
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onRestoreFromPageCacheDid(WebView webView, String str) {
            if (BdSailorWebView.this.mWebViewExt.qB() != null) {
                BdSailorWebView.this.mWebViewExt.qB().onRestoreFromPageCacheDid(BdSailorWebView.this, str);
            } else {
                super.onRestoreFromPageCacheDid(webView, str);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onResumePlugin() {
            if (BdSailorWebView.this.mWebViewExt.qB() != null) {
                BdSailorWebView.this.mWebViewExt.qB().onResumePluginExt(BdSailorWebView.this);
            } else {
                super.onResumePlugin();
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onScaleChanged(WebView webView, float f, float f2) {
            if (BdSailorWebView.this.mWebViewClient != null) {
                BdSailorWebView.this.mWebViewClient.onScaleChanged(BdSailorWebView.this, f, f2);
            } else {
                super.onScaleChanged(webView, f, f2);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onSecurityCheckResult(WebView webView, String str, WebViewClient.SecurityInfo securityInfo) {
            if (BdSailorWebView.this.mWebViewExt.qB() != null) {
                BdSailorWebView.this.mWebViewExt.qB().onSecurityCheckResultExt(BdSailorWebView.this, str, securityInfo);
            }
            super.onSecurityCheckResult(webView, str, securityInfo);
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onSubjectsCollected(WebView webView, boolean z, int i) {
            if (BdSailorWebView.this.mWebViewExt.qB() != null) {
                BdSailorWebView.this.mWebViewExt.qB().onSubjectsCollectedExt(BdSailorWebView.this, z, i);
            } else {
                super.onSubjectsCollected(webView, z, i);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final boolean onSupportsForceZoomScale(WebView webView) {
            return BdSailorWebView.this.mWebViewExt.qB() != null ? BdSailorWebView.this.mWebViewExt.qB().onSupportsForceZoomScale(BdSailorWebView.this) : super.onSupportsForceZoomScale(webView);
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final boolean onTextCopied(WebView webView) {
            if (BdSailorWebView.this.mWebViewExt.qB() != null) {
                BdSailorWebView.this.mWebViewExt.qB().onTextCopiedExt(BdSailorWebView.this);
            }
            return super.onTextCopied(webView);
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
            if (BdSailorWebView.this.mWebViewClient != null) {
                BdSailorWebView.this.mWebViewClient.onUnhandledKeyEvent(BdSailorWebView.this, keyEvent);
            } else {
                super.onUnhandledKeyEvent(webView, keyEvent);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onUpdateTextFieldNextPreStatus(WebView webView, boolean z, boolean z2) {
            if (BdSailorWebView.this.mWebViewExt.qB() != null) {
                BdSailorWebView.this.mWebViewExt.qB().onUpdateTextFieldNextPreStatus(BdSailorWebView.this, z, z2);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onUserInteraction(WebView webView, String str, WebViewClient.InteractionType interactionType) {
            super.onUserInteraction(webView, str, interactionType);
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            WebResourceResponse shouldInterceptRequest = super.shouldInterceptRequest(webView, str);
            return (shouldInterceptRequest == null && BdSailorWebView.this.mWebViewClient != null) ? BdSailorWebView.this.mWebViewClient.shouldInterceptRequest(BdSailorWebView.this, str) : shouldInterceptRequest;
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final boolean shouldKeywordExtension(WebView webView, String str) {
            return BdSailorWebView.this.mWebViewExt.qB() != null ? BdSailorWebView.this.mWebViewExt.qB().shouldKeywordExtensionExt(BdSailorWebView.this, str) : super.shouldKeywordExtension(webView, str);
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final boolean shouldOpenFlash(WebView webView, String str) {
            if (BdSailorWebView.this.mWebViewExt.qB() != null) {
                BdSailorWebView.this.mWebViewExt.qB().shouldOpenFlashExt(BdSailorWebView.this, str);
            }
            return super.shouldOpenFlash(webView, str);
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
            return BdSailorWebView.this.mWebViewClient != null ? BdSailorWebView.this.mWebViewClient.shouldOverrideKeyEvent(BdSailorWebView.this, keyEvent) : super.shouldOverrideKeyEvent(webView, keyEvent);
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final boolean shouldOverrideSpecialUrlLoading(WebView webView, String str) {
            if (BdSailorWebView.this.mWebViewClient != null) {
                return BdSailorWebView.this.mWebViewClient.shouldOverrideUrlLoading(BdSailorWebView.this, str);
            }
            return false;
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            int i = 0;
            BdSailorWebView.this.perfLog(webView, "shouldOverrideUrlLoading");
            webView.getSecureProcessor().a(str);
            boolean shouldOverrideUrlLoading = BdSailorWebView.this.mWebViewClient != null ? BdSailorWebView.this.mWebViewClient.shouldOverrideUrlLoading(BdSailorWebView.this, str) : false;
            if (!shouldOverrideUrlLoading) {
                shouldOverrideUrlLoading = super.shouldOverrideUrlLoading(webView, str);
            }
            if (shouldOverrideUrlLoading && !TextUtils.isEmpty(str)) {
                String[] strArr = this.b;
                int length = strArr.length;
                while (true) {
                    if (i >= length) {
                        break;
                    } else if (str.startsWith(strArr[i])) {
                        Log.d("// BdSailorMonitorEngine", "BdWebViewClientProxy.shouldoverridetel handled by external-->onTelRequest ,url=" + str);
                        break;
                    } else {
                        i++;
                    }
                }
            }
            return shouldOverrideUrlLoading;
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void shouldPageRollBack(WebView webView, String str) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class g extends FrameLayout {
        public g(Context context) {
            super(context);
            setBackgroundColor(context.getResources().getColor(context.getResources().getIdentifier("sailor_common_black", "color", context.getPackageName())));
        }

        @Override // android.view.View
        public final boolean onTouchEvent(MotionEvent motionEvent) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public class h extends WebViewDelegate {
        public h(WebView webView) {
            super(webView);
        }

        @Override // com.baidu.webkit.sdk.WebViewDelegate
        public final boolean canGoBack() {
            return BdSailorWebView.this.canGoBack();
        }

        @Override // com.baidu.webkit.sdk.WebViewDelegate
        public final boolean canGoBackOrForward(int i) {
            return BdSailorWebView.this.canGoBackOrForward(i);
        }

        @Override // com.baidu.webkit.sdk.WebViewDelegate
        public final boolean canGoForward() {
            return BdSailorWebView.this.canGoForward();
        }

        @Override // com.baidu.webkit.sdk.WebViewDelegate
        public final int getTitlebarHeight() {
            return BdSailorWebView.this.getTitlebarHeight();
        }

        @Override // com.baidu.webkit.sdk.WebViewDelegate
        public final void goBack() {
            BdSailorWebView.this.goBack();
        }

        @Override // com.baidu.webkit.sdk.WebViewDelegate
        public final void goBackOrForward(int i) {
            BdSailorWebView.this.goBackOrForward(i);
        }

        @Override // com.baidu.webkit.sdk.WebViewDelegate
        public final void goForward() {
            BdSailorWebView.this.goForward();
        }

        @Override // com.baidu.webkit.sdk.WebViewDelegate
        public final boolean isTitlebarCanShow() {
            return BdSailorWebView.this.isTitlebarCanShow();
        }

        @Override // com.baidu.webkit.sdk.WebViewDelegate
        public final boolean isTitlebarShowing() {
            return BdSailorWebView.this.isTitlebarShowing();
        }

        @Override // com.baidu.webkit.sdk.WebViewDelegate
        public final void onOverScrolled(int i, int i2, boolean z, boolean z2) {
            BdSailorWebView.this.onOverScrolled(i, i2, z, z2);
        }

        @Override // com.baidu.webkit.sdk.WebViewDelegate
        public final void onScrollChanged(int i, int i2, int i3, int i4) {
            BdSailorWebView.this.onScrollChanged(i, i2, i3, i4);
        }

        @Override // com.baidu.webkit.sdk.WebViewDelegate
        public final boolean onTouchEvent(MotionEvent motionEvent) {
            return BdSailorWebView.this.onTouchEvent(motionEvent);
        }
    }

    public BdSailorWebView(Context context) {
        super(context);
        this.mCurrentWebView = new WebView(context);
        init();
    }

    public BdSailorWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentWebView = new WebView(context, attributeSet);
        init();
    }

    public BdSailorWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurrentWebView = new WebView(context, attributeSet, i);
        init();
    }

    private void addWebView(WebView webView) {
        addWebView(webView, -1);
    }

    private void addWebView(WebView webView, int i) {
        if (webView.getParent() != null) {
            return;
        }
        this.mViewDelegate = new h(webView);
        webView.setViewDelegate(this.mViewDelegate);
        getWebViewContainer().addView(webView, i, new FrameLayout.LayoutParams(-1, -1));
    }

    public static void cancelPreload(String str) {
    }

    private void init() {
        checkInit();
        this.mWebSettings = new com.baidu.browser.sailor.g(this.mCurrentWebView.getSettings());
        this.mWebViewExt = new a(this, null);
        this.mWebViewLayer = new FrameLayout(this.mCurrentWebView.getContext());
        this.mWebViewLayerLp = new FrameLayout.LayoutParams(-1, -1);
        addView(this.mWebViewLayer, this.mWebViewLayerLp);
        initWebView(this.mCurrentWebView);
        addWebView(this.mCurrentWebView);
        setFocusableInTouchMode(true);
        if (com.baidu.browser.sailor.a.qq().qv() != null) {
            com.baidu.browser.sailor.a.qq().qv().i(getContext(), true);
        }
        this.mCurrentWebView.setWebViewPagerContainer(this);
        setNetworkAvailable(NetWorkUtils.getIsOnline());
        if (sInitFirstWebView) {
            Log.d(GlobalConstants.LOG_PER_TAG, ZeusPerformanceTiming.getWebViewInitTiming());
            sInitFirstWebView = true;
        }
    }

    private void initWebView(WebView webView) {
        webView.setWebChromeClient(new e());
        webView.setWebViewClient(new f(this, (byte) 0));
        webView.setPictureListener(new c(this, (byte) 0));
        webView.setDownloadListener(new d(webView));
        webView.setWebBackForwardListClient(new b(webView));
        if (this.mLightappActionClient != null) {
            webView.addJavascriptInterface(new com.baidu.browser.sailor.feature.a.a(webView, this.mLightappActionClient), "Bdbox_android_xsearch");
        }
        if (this.mLightappKernelClient != null) {
            webView.addJavascriptInterface(new com.baidu.browser.sailor.feature.a.c(this, this.mLightappKernelClient), "BLightApp");
        }
        webView.setVideoPlayerFactory(this.mVideoFactory);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void perfLog(WebView webView, String str) {
        perfLog(webView, str, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void perfLog(WebView webView, String str, String str2) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void perfLog(String str, String str2) {
    }

    private void removeWebView(WebView webView) {
        try {
            getWebViewContainer().removeView(webView);
        } catch (Exception e2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTopControlsHeight(int i, boolean z) {
        this.mCurrentWebView.setTopControlsHeight(i, z);
    }

    private void setViewSize(View view, int i, int i2) {
        if (view == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(i, i2);
        } else {
            layoutParams.width = i;
            layoutParams.height = i2;
        }
        view.setLayoutParams(layoutParams);
    }

    private void setWebViewLayerMarginInternal(int i, int i2, int i3, int i4) {
        this.mWebViewLayerLp.setMargins(i, i2, i3, i4);
        this.mWebViewLayer.setLayoutParams(this.mWebViewLayerLp);
        onWebViewLayerMarginChanged(i, i2, i3, i4);
        this.mWebViewLayer.invalidate();
        this.mCurrentWebView.setWebViewMargin(i, i2, i3, i4);
    }

    public void addJavascriptInterface(Object obj, String str) {
        if (this.mCurrentWebView != null) {
            this.mCurrentWebView.addJavascriptInterface(obj, str);
        }
    }

    public void addJavascriptInterfaceExt(IJsAbility iJsAbility, String str) {
        if (this.mCurrentWebView != null) {
            this.mCurrentWebView.addJavascriptInterfaceExt(iJsAbility, str);
        }
    }

    public boolean canGoBack() {
        return this.mCurrentWebView.canGoBack();
    }

    public boolean canGoBackOrForward(int i) {
        return this.mCurrentWebView.canGoBackOrForward(i);
    }

    public boolean canGoForward() {
        return this.mCurrentWebView.canGoForward();
    }

    public boolean canZoomIn() {
        return this.mCurrentWebView.canZoomIn();
    }

    public boolean canZoomOut() {
        return this.mCurrentWebView.canZoomOut();
    }

    public Bitmap captureBitmap() {
        Bitmap captureBitmap;
        boolean z = false;
        try {
            WebView currentWebView = getCurrentWebView();
            if (currentWebView == null || currentWebView.getMeasuredWidth() <= 0 || currentWebView.getMeasuredHeight() <= 0) {
                return null;
            }
            if (com.baidu.browser.sailor.util.a.qX()) {
                captureBitmap = getCurrentWebView().captureBitmap();
            } else {
                captureBitmap = Bitmap.createBitmap(currentWebView.getMeasuredWidth(), currentWebView.getMeasuredHeight(), Bitmap.Config.RGB_565);
                Canvas canvas = new Canvas(captureBitmap);
                int save = canvas.save();
                this.mWebViewLayer.draw(canvas);
                canvas.restoreToCount(save);
            }
            if (captureBitmap == null || captureBitmap.getWidth() <= 0 || captureBitmap.getHeight() <= 0) {
                return null;
            }
            if (getTitlebarHeight() != 0 && isTitlebarShowing()) {
                z = true;
            }
            return z ? Bitmap.createBitmap(captureBitmap, 0, getTitlebarHeight(), captureBitmap.getWidth(), captureBitmap.getHeight() - getTitlebarHeight()) : captureBitmap;
        } catch (Throwable th) {
            return null;
        }
    }

    public Bitmap captureBitmap(int i, int i2) {
        return this.mCurrentWebView.captureBitmap(i, i2);
    }

    public Picture capturePicture() {
        return this.mCurrentWebView.capturePicture();
    }

    protected void checkInit() {
        if (!com.baidu.browser.sailor.a.qq().qr()) {
            throw new RuntimeException("Must Call BdSailor.init(Context aContext, String aWorkspace) first!");
        }
        if (!com.baidu.browser.sailor.b.a.qR().qs()) {
            throw new RuntimeException("Must Call BdSailor.initWebkit(String aAppId, boolean aIsZeusIntegrate) first!");
        }
    }

    public void clearCache(boolean z) {
        this.mCurrentWebView.clearCache(z);
    }

    public void clearFormData() {
        this.mCurrentWebView.clearFormData();
    }

    public void clearHistory() {
        this.mCurrentWebView.clearHistory();
    }

    public void clearMatches() {
        this.mCurrentWebView.clearMatches();
    }

    public void clearSslPreferences() {
        this.mCurrentWebView.clearSslPreferences();
    }

    public void clearView() {
        this.mCurrentWebView.clearView();
    }

    @Override // android.view.View
    public void computeScroll() {
        this.mCurrentWebView.computeScroll();
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        return this.mCurrentWebView.computeVerticalScrollRange();
    }

    public com.baidu.browser.sailor.d copyBackForwardList() {
        try {
            if (this.mCurrentWebView != null && this.mCurrentWebView.copyBackForwardList() != null) {
                return new com.baidu.browser.sailor.d(this.mCurrentWebView.copyBackForwardList());
            }
        } catch (Throwable th) {
            Log.printStackTrace(th);
        }
        return null;
    }

    public void destroy() {
        setDownloadListener(null);
        setEmbeddedTitleBar(null);
        this.mCurrentWebView.destroy();
    }

    public void disableFeature(String str) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.mCurrentWebView.dispatchKeyEvent(keyEvent);
    }

    protected void doRealGoBack() {
        if (canGoBack()) {
            this.mCurrentWebView.goBack();
            if (this.mWebViewExt.qB() != null) {
                this.mWebViewExt.qB().onPageBackOrForwardExt(this, -1);
            }
        }
    }

    protected void doRealGoForward() {
        if (canGoForward()) {
            this.mCurrentWebView.goForward();
            if (this.mWebViewExt.qB() != null) {
                this.mWebViewExt.qB().onPageBackOrForwardExt(this, 1);
            }
        }
    }

    public void documentHasImages(Message message) {
        this.mCurrentWebView.documentHasImages(message);
    }

    public void dumpInfo() {
    }

    public void emulateShiftHeld() {
        if (this.mCurrentWebView != null) {
            this.mCurrentWebView.emulateShiftHeld();
        }
    }

    public void enableFeature(String str) {
    }

    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (this.mCurrentWebView != null) {
            this.mCurrentWebView.evaluateJavascript(str, valueCallback);
        }
    }

    public int findAll(String str) {
        return this.mCurrentWebView.findAll(str);
    }

    public void findAllAsync(String str) {
        this.mCurrentWebView.findAllAsync(str);
    }

    public void findNext(boolean z) {
        this.mCurrentWebView.findNext(z);
    }

    public void flingScroll(int i, int i2) {
        this.mCurrentWebView.flingScroll(i, i2);
    }

    public void freeMemory() {
        this.mCurrentWebView.freeMemory();
    }

    public SslCertificate getCertificate() {
        return this.mCurrentWebView.getCertificate();
    }

    public int getContentHeight() {
        return this.mCurrentWebView.getContentHeight();
    }

    public int getContentWidth() {
        return this.mCurrentWebView.getContentWidth();
    }

    public WebView getCurrentWebView() {
        return this.mCurrentWebView;
    }

    public i getDownloadListener() {
        return this.mDownloadListener;
    }

    public View getEmbeddedTitlebar() {
        return this.mEmbeddedTitlebar;
    }

    public Bitmap getFavicon() {
        return this.mCurrentWebView.getFavicon();
    }

    protected ViewGroup getFunctionLayer() {
        if (this.mFunctionViewLayer == null) {
            this.mFunctionViewLayer = new FrameLayout(getContext());
            addView(this.mFunctionViewLayer);
        }
        return this.mFunctionViewLayer;
    }

    public WebView.HitTestResult getHitTestResult() {
        return this.mCurrentWebView.getHitTestResult();
    }

    public String[] getHttpAuthUsernamePassword(String str, String str2) {
        return this.mCurrentWebView.getHttpAuthUsernamePassword(str, str2);
    }

    public String getOriginalUrl() {
        return this.mCurrentWebView.getOriginalUrl();
    }

    public int getOuterTitlebarHeight() {
        return this.mOuterTitlebarHeightPix;
    }

    public int getProgress() {
        return this.mCurrentWebView.getProgress();
    }

    public float getScale() {
        return this.mCurrentWebView.getScale();
    }

    public com.baidu.browser.sailor.g getSettings() {
        return this.mWebSettings;
    }

    public j getSettingsExt() {
        return this.mWebViewExt.getSettingsExt();
    }

    public String getTitle() {
        return this.mCurrentWebView.getTitle();
    }

    public int getTitlebarHeight() {
        return this.mEmbeddedTitlebarHeightPix;
    }

    public String getUrl() {
        if (this.mCurrentWebView != null) {
            return this.mCurrentWebView.getUrl();
        }
        return null;
    }

    public void getWebAppShortcutData(WebAppShortcutDataListener webAppShortcutDataListener) {
        this.mCurrentWebView.getWebAppShortcutData(webAppShortcutDataListener);
    }

    public void getWebAppShortcutData(WebAppShortcutDataListener webAppShortcutDataListener, boolean z) {
        this.mCurrentWebView.getWebAppShortcutData(webAppShortcutDataListener, z);
    }

    public com.baidu.browser.sailor.e getWebChromeClient() {
        return this.mWebChromeClient;
    }

    public int[] getWebScrollXY() {
        try {
            return new int[]{this.mCurrentWebView.getWebView().getScrollX(), this.mCurrentWebView.getWebView().getScrollY()};
        } catch (NullPointerException e2) {
            Log.printStackTrace(e2);
            return new int[]{0, 0};
        }
    }

    public com.baidu.browser.sailor.h getWebViewClient() {
        return this.mWebViewClient;
    }

    protected FrameLayout getWebViewContainer() {
        return this.mWebViewLayer;
    }

    public k getWebViewExt() {
        return this.mWebViewExt;
    }

    public void goBack() {
        if (canGoBack()) {
            Log.d("bfanim", "BdSailorWebView.Back");
            if (this.mCurrentWebView != null) {
                this.mCurrentWebView.stopLoading();
            }
            doRealGoBack();
        }
    }

    public void goBackOrForward(int i) {
        if (i == 0 || !canGoBackOrForward(i)) {
            return;
        }
        this.mCurrentWebView.goBackOrForward(i);
        if (this.mWebViewExt.qB() != null) {
            this.mWebViewExt.qB().onPageBackOrForwardExt(this, i);
        }
    }

    public void goForward() {
        if (canGoForward()) {
            doRealGoForward();
        }
    }

    public void goNextOrPreTextField(boolean z) {
    }

    public boolean hasCustomView() {
        return this.mCustomView != null;
    }

    @SuppressLint({"all"})
    public void hideCustomView() {
        if (this.mCustomView == null) {
            return;
        }
        try {
            getCurrentWebView().getHandler().post(new l(this));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void hideEmbeddedTitleBar(boolean z) {
        if (this.mEmbeddedTitlebar == null || this.mLockEmbeddedTitlebar) {
            return;
        }
        this.mCanHideTitlebar = true;
        updateTopControlsState(true, false, z);
        updateTopControlsState(this.mCanHideTitlebar, this.mCanShowTitlebar, z);
    }

    public void invokeZoomPicker() {
        this.mCurrentWebView.invokeZoomPicker();
    }

    public boolean isAutoShowTitlebar() {
        return this.mCurrentWebView.isAutoShowTitlebar();
    }

    public boolean isDestroyed() {
        return this.mCurrentWebView.isDestroyed();
    }

    public boolean isFeatureEnable(String str) {
        return false;
    }

    @Override // android.view.View
    public boolean isFocused() {
        return this.mCurrentWebView.isFocused();
    }

    public boolean isPageLoading() {
        return this.mIsPageLoading;
    }

    public boolean isPrivateBrowsingEnabled() {
        return this.mCurrentWebView.isPrivateBrowsingEnabled();
    }

    protected boolean isTitlebarCanHide() {
        return this.mCanHideTitlebar;
    }

    public boolean isTitlebarCanShow() {
        return this.mCanShowTitlebar;
    }

    public boolean isTitlebarLock() {
        return this.mLockEmbeddedTitlebar;
    }

    public boolean isTitlebarShowing() {
        return this.mEmbeddedTitlebar != null && this.mEmbeddedTitlebar.getTranslationY() == 0.0f;
    }

    public void loadData(String str, String str2, String str3) {
        this.mCurrentWebView.loadData(str, str2, str3);
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        this.mCurrentWebView.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    public void loadImageInPage(String str) {
        this.mCurrentWebView.loadUrl(SHOW_IMAGE_PREFIX + str);
    }

    public void loadUrl(String str) {
        if (str.startsWith(JAVASCTIPT_URL)) {
            this.mCurrentWebView.loadUrl(str);
            return;
        }
        perfLog(this.mCurrentWebView, "sailor-loadUrl", "url = " + str);
        perfLog(TrackLoadSettingsAtom.TYPE, str);
        this.mCurrentWebView.loadUrl(str);
    }

    public void loadUrl(String str, Map<String, String> map) {
        if (str.startsWith(JAVASCTIPT_URL)) {
            this.mCurrentWebView.loadUrl(str);
            return;
        }
        perfLog(this.mCurrentWebView, "sailor-loadUrl", "url = " + str);
        perfLog(TrackLoadSettingsAtom.TYPE, str);
        this.mCurrentWebView.loadUrl(str, map);
    }

    public void lockEmbeddedTitlebar(boolean z) {
        this.mLockEmbeddedTitlebar = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (com.baidu.browser.sailor.util.c.a(this)) {
            com.baidu.browser.sailor.a.qq().a(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (com.baidu.browser.sailor.a.qq().qw() == this) {
            com.baidu.browser.sailor.a.qq().a((BdSailorWebView) null);
        }
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (hasCustomView()) {
            hideCustomView();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.view.View
    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        this.mCurrentWebView.onOverScrolledSuper(i, i2, z, z2);
    }

    public void onPause() {
        this.mCurrentWebView.onPause();
        if (this.mStopBackgroundkListener != null) {
            this.mStopBackgroundkListener.qD();
        }
    }

    public void onReinputErrorUrl() {
    }

    public void onResume() {
        this.mCurrentWebView.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        this.mCurrentWebView.onScrollChangedSuper(i, i2, i3, i4);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        switch (motionEvent.getAction()) {
            case 0:
                this.mIsFunctionLayerShowing = false;
                break;
        }
        if (!this.mIsFunctionLayerShowing && !this.mWebViewExt.qA()) {
            z = true;
        }
        if (z != getSettings().qx()) {
            getSettings().ap(z);
        }
        return this.mCurrentWebView.onTouchEventSuper(motionEvent);
    }

    protected void onWebViewLayerMarginChanged(int i, int i2, int i3, int i4) {
    }

    public boolean overlayHorizontalScrollbar() {
        return this.mCurrentWebView.overlayHorizontalScrollbar();
    }

    public boolean overlayVerticalScrollbar() {
        return this.mCurrentWebView.overlayVerticalScrollbar();
    }

    public boolean pageDown(boolean z) {
        return this.mCurrentWebView.pageDown(z);
    }

    public boolean pageUp(boolean z) {
        return this.mCurrentWebView.pageUp(z);
    }

    public void pauseMedia() {
        this.mCurrentWebView.pauseMedia();
    }

    public void pauseTimers() {
        this.mCurrentWebView.pauseTimers();
    }

    @Override // android.view.View
    public boolean performLongClick() {
        return this.mCurrentWebView.performLongClick();
    }

    public void postUrl(String str, byte[] bArr) {
        this.mCurrentWebView.postUrl(str, bArr);
    }

    public void reload() {
        this.mCurrentWebView.stopLoading();
        this.mCurrentWebView.reload();
        this.mIsPageLoading = false;
    }

    public void removeJavascriptInterface(String str) {
        if (this.mCurrentWebView != null) {
            this.mCurrentWebView.removeJavascriptInterface(str);
        }
    }

    public void removeJavascriptInterfaceExt(String str) {
        if (this.mCurrentWebView != null) {
            this.mCurrentWebView.removeJavascriptInterfaceExt(str);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return this.mCurrentWebView.requestChildRectangleOnScreen(view, rect, z);
    }

    public void requestFocusNodeHref(Message message) {
        if (this.mCurrentWebView != null) {
            this.mCurrentWebView.requestFocusNodeHref(message);
        } else {
            Log.e("current webview is null.");
        }
    }

    public void requestImageRef(Message message) {
        this.mCurrentWebView.requestImageRef(message);
    }

    protected void resetWebViewLayerMargin() {
        setWebViewLayerMargin(0, 0, 0, 0);
    }

    public com.baidu.browser.sailor.d restoreState(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        return new com.baidu.browser.sailor.d(this.mCurrentWebView.restoreState(bundle));
    }

    public void resumeMedia() {
        this.mCurrentWebView.resumeMedia();
    }

    public void resumeTimers() {
        this.mCurrentWebView.resumeTimers();
    }

    protected void runWithThreadProtect(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            this.mCurrentWebView.post(runnable);
        }
    }

    public void savePassword(String str, String str2, String str3) {
        this.mCurrentWebView.savePassword(str, str2, str3);
    }

    public com.baidu.browser.sailor.d saveState(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        return new com.baidu.browser.sailor.d(this.mCurrentWebView.saveState(bundle));
    }

    public void saveWebArchive(String str) {
        this.mCurrentWebView.saveWebArchive(str);
    }

    public void saveWebArchive(String str, boolean z, ValueCallback<String> valueCallback) {
        this.mCurrentWebView.saveWebArchive(str, z, valueCallback);
    }

    public void setAutoShowTitlebar(boolean z) {
        this.mCurrentWebView.setAutoShowTitlebar(z);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.mSnapBgColor = i;
        if (this.mCurrentWebView != null) {
            this.mCurrentWebView.setBackgroundColor(i);
        } else {
            super.setBackgroundColor(i);
        }
    }

    public void setCertificate(SslCertificate sslCertificate) {
        this.mCurrentWebView.setCertificate(sslCertificate);
    }

    public void setDownloadListener(i iVar) {
        this.mDownloadListener = iVar;
    }

    public void setEmbeddedTitleBar(View view) {
        setEmbeddedTitleBar(view, 0);
    }

    public void setEmbeddedTitleBar(View view, int i) {
        setNewTitlebar(view, i, true, true);
    }

    public void setFindListener(WebView.FindListener findListener) {
        this.mCurrentWebView.setFindListener(findListener);
    }

    public void setFullscreen(Activity activity, boolean z) {
        Window window;
        if (activity == null || (window = activity.getWindow()) == null) {
            return;
        }
        window.setFlags(!z ? 0 : 1024, 1024);
    }

    public void setHorizontalScrollbarOverlay(boolean z) {
        if (this.mCurrentWebView != null) {
            this.mCurrentWebView.setHorizontalScrollbarOverlay(z);
        }
    }

    public void setHttpAuthUsernamePassword(String str, String str2, String str3, String str4) {
        this.mCurrentWebView.setHttpAuthUsernamePassword(str, str2, str3, str4);
    }

    public void setInitialScale(int i) {
        this.mCurrentWebView.setInitialScale(i);
    }

    @Override // android.view.View
    public void setLayerType(int i, Paint paint) {
        if (this.mCurrentWebView != null) {
            this.mCurrentWebView.setLayerType(i, paint);
        } else {
            super.setLayerType(i, paint);
        }
    }

    public void setLigthappStopBgWorkListenerExt(com.baidu.browser.sailor.feature.a.e eVar) {
        this.mStopBackgroundkListener = eVar;
    }

    public void setMapTrackballToArrowKeys(boolean z) {
        this.mCurrentWebView.setMapTrackballToArrowKeys(z);
    }

    public void setNetworkAvailable(boolean z) {
        this.mCurrentWebView.setNetworkAvailable(z);
    }

    public void setNewTitlebar(View view, int i, boolean z) {
        setNewTitlebar(view, i, z, z);
    }

    public void setNewTitlebar(View view, int i, boolean z, boolean z2) {
        Log.d("new-titlebar", "setNewTitlebar :" + view + " allow hide: " + z + " show: " + z2 + " height: " + i);
        if (view == null) {
            if (this.mEmbeddedTitlebar != null) {
                removeView(this.mEmbeddedTitlebar);
                if (!com.baidu.browser.sailor.util.a.qX()) {
                    setWebViewLayerMargin(this.mMarginLeft, this.mMarginTop - this.mEmbeddedTitlebarHeightPix, this.mMarginRight, this.mMarginBottom);
                }
            }
            this.mEmbeddedTitlebar = null;
            this.mEmbeddedTitlebarHeightPix = 0;
            this.mCanHideTitlebar = false;
            this.mCanShowTitlebar = false;
            this.mLockEmbeddedTitlebar = false;
            setTopControlsHeight(0, false);
            return;
        }
        this.mEmbeddedTitlebar = view;
        this.mEmbeddedTitlebar.setContentDescription("linhua01__mEmbeddedTitlebar");
        this.mCanHideTitlebar = z;
        this.mCanShowTitlebar = z2;
        this.mLockEmbeddedTitlebar = false;
        this.mEmbeddedTitlebarHeightPix = com.baidu.browser.core.util.b.W(i);
        this.mEmbeddedTitlebar.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        if (com.baidu.browser.sailor.util.a.qX()) {
            setTopControlsHeight(this.mEmbeddedTitlebarHeightPix, true);
            updateTopControlsState(this.mCanHideTitlebar, this.mCanShowTitlebar, false);
        } else {
            setWebViewLayerMargin(this.mMarginLeft, this.mMarginTop + this.mEmbeddedTitlebarHeightPix, this.mMarginRight, this.mMarginBottom);
        }
        if (this.mEmbeddedTitlebar != null) {
            if (this.mEmbeddedTitlebar.getParent() != null) {
                ((ViewGroup) this.mEmbeddedTitlebar.getParent()).removeView(this.mEmbeddedTitlebar);
            }
            addView(this.mEmbeddedTitlebar);
        }
    }

    public void setOuterTitlebarHeight(int i) {
        if (com.baidu.browser.sailor.util.a.qX()) {
            this.mOuterTitlebarHeightPix = i;
            setWebViewLayerMarginInternal(this.mMarginLeft, this.mMarginTop + this.mOuterTitlebarHeightPix, this.mMarginRight, this.mMarginBottom);
        }
    }

    @Override // android.view.View
    public void setOverScrollMode(int i) {
        if (this.mCurrentWebView != null) {
            this.mCurrentWebView.setOverScrollMode(i);
        } else {
            super.setOverScrollMode(i);
        }
    }

    public void setPageTransformer(boolean z, PageTransformer pageTransformer) {
        this.mCurrentWebView.setPageTransformer(z, pageTransformer);
    }

    public void setPictureListener(WebView.PictureListener pictureListener) {
        this.mPictureListener = pictureListener;
    }

    public void setSailorWebViewSize(int i, int i2) {
        setViewSize(this.mWebViewLayer, i, i2);
        setViewSize(this.mCurrentWebView, i, i2);
        this.mCurrentWebView.setWebViewPagerSize(i, i2);
    }

    @Override // android.view.View
    public void setScrollBarStyle(int i) {
        this.mCurrentWebView.setScrollBarStyle(i);
    }

    public void setVerticalScrollbarOverlay(boolean z) {
        if (this.mCurrentWebView != null) {
            this.mCurrentWebView.setVerticalScrollbarOverlay(z);
        }
    }

    public void setVideoPlayerFactory(VideoPlayerFactory videoPlayerFactory) {
        this.mVideoFactory = videoPlayerFactory;
        this.mCurrentWebView.setVideoPlayerFactory(videoPlayerFactory);
    }

    public void setWebBackForwardListClient(WebBackForwardListClient webBackForwardListClient) {
        this.mCurrentWebView.setWebBackForwardListClient(webBackForwardListClient);
    }

    public void setWebChromeClient(com.baidu.browser.sailor.e eVar) {
        this.mWebChromeClient = eVar;
    }

    public void setWebChromeClientExt(com.baidu.browser.sailor.f fVar) {
        if (this.mWebViewExt != null) {
            this.mWebViewExt.setWebChromeClientExt(fVar);
        }
    }

    public void setWebViewClient(com.baidu.browser.sailor.h hVar) {
        this.mWebViewClient = hVar;
    }

    public void setWebViewClientExt(BdSailorWebViewClientExt bdSailorWebViewClientExt) {
        if (this.mWebViewExt != null) {
            this.mWebViewExt.setWebViewClientExt(bdSailorWebViewClientExt);
        }
    }

    protected void setWebViewLayerMargin(int i, int i2, int i3, int i4) {
        if ((i == this.mMarginLeft && i2 == this.mMarginTop && i3 == this.mMarginRight && i4 == this.mMarginBottom) ? false : true) {
            this.mMarginLeft = i;
            this.mMarginTop = i2;
            this.mMarginRight = i3;
            this.mMarginBottom = i4;
            setWebViewLayerMarginInternal(i, this.mOuterTitlebarHeightPix + i2, i3, i4);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return this.mCurrentWebView.shouldDelayChildPressedState();
    }

    public void showCustomView(Context context, View view, WebChromeClient.CustomViewCallback customViewCallback) {
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            if (this.mCustomView != null) {
                customViewCallback.onCustomViewHidden();
                return;
            }
            this.mOriginalOrientation = activity.getRequestedOrientation();
            if (activity.getWindow() != null) {
                FrameLayout frameLayout = (FrameLayout) activity.getWindow().getDecorView();
                this.mFullscreenContainer = new g(activity);
                this.mFullscreenContainer.addView(view, COVER_SCREEN_PARAMS);
                if (frameLayout != null) {
                    frameLayout.addView(this.mFullscreenContainer, COVER_SCREEN_PARAMS);
                }
                this.mCustomView = view;
                setFullscreen(activity, true);
                if (getCurrentWebView() != null) {
                    getCurrentWebView().setVisibility(4);
                }
                this.mCustomViewCallback = customViewCallback;
                activity.setRequestedOrientation(2);
            }
        }
    }

    public void showEmbeddedTitleBar(boolean z) {
        if (this.mEmbeddedTitlebar == null || this.mLockEmbeddedTitlebar) {
            return;
        }
        this.mCanShowTitlebar = true;
        updateTopControlsState(false, false, z);
        updateTopControlsState(this.mCanHideTitlebar, this.mCanShowTitlebar, z);
    }

    public boolean showFindDialog(String str, boolean z) {
        return this.mCurrentWebView.showFindDialog(str, z);
    }

    public int startPrerender(String str) {
        if (this.mCurrentWebView != null) {
            return this.mCurrentWebView.startPrerender(str);
        }
        return -1;
    }

    public void stopLoading() {
        if (isDestroyed()) {
            return;
        }
        this.mCurrentWebView.stopLoading();
        this.mIsPageLoading = false;
    }

    public void updateEmbeddedTitleBar(boolean z, boolean z2, boolean z3) {
        if (this.mEmbeddedTitlebar != null) {
            this.mCanHideTitlebar = z;
            this.mCanShowTitlebar = z2;
            updateTopControlsState(z, z2, z3);
        }
    }

    public void updateTopControlOffset(int i) {
        this.mCurrentWebView.updateTopControlOffset(i);
    }

    public void updateTopControlsState(boolean z, boolean z2, boolean z3) {
        if (this.mEmbeddedTitlebar != null) {
            Log.d("new-titlebar", "updateTopControlsState :" + z);
            this.mCurrentWebView.updateTopControlsState(z, z2, z3);
            if (z3) {
                return;
            }
            WebChromeClient webChromeClient = this.mCurrentWebView.getWebChromeClient();
            if (!z) {
                webChromeClient.onOffsetsForFullscreenChanged(0.0f, this.mEmbeddedTitlebarHeightPix, 0.0f);
            } else if (z2) {
            } else {
                webChromeClient.onOffsetsForFullscreenChanged(-this.mEmbeddedTitlebarHeightPix, 0.0f, 0.0f);
            }
        }
    }

    public boolean zoomIn() {
        return this.mCurrentWebView.zoomIn();
    }

    public boolean zoomOut() {
        return this.mCurrentWebView.zoomOut();
    }
}
