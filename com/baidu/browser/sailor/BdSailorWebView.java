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
import android.widget.ZoomButtonsController;
import com.baidu.browser.core.INoProGuard;
import com.baidu.browser.sailor.BdSailorWebSettings;
import com.baidu.browser.sailor.lightapp.BdLightappActionClient;
import com.baidu.browser.sailor.lightapp.BdLightappKernelClient;
import com.baidu.browser.sailor.platform.BdSailorPlatform;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.webkit.internal.ETAG;
import com.baidu.webkit.internal.GlobalConstants;
import com.baidu.webkit.internal.monitor.MonitorConstant;
import com.baidu.webkit.internal.monitor.SessionMonitorEngine;
import com.baidu.webkit.internal.utils.NetWorkUtils;
import com.baidu.webkit.sdk.ClientCertRequest;
import com.baidu.webkit.sdk.GeolocationPermissions;
import com.baidu.webkit.sdk.HttpAuthHandler;
import com.baidu.webkit.sdk.JsPromptResult;
import com.baidu.webkit.sdk.JsResult;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.PageTransformer;
import com.baidu.webkit.sdk.PermissionRequest;
import com.baidu.webkit.sdk.RenderProcessGoneDetail;
import com.baidu.webkit.sdk.VideoPlayerFactory;
import com.baidu.webkit.sdk.WebAppShortcutDataListener;
import com.baidu.webkit.sdk.WebBackForwardList;
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
import java.util.List;
import java.util.Map;
/* loaded from: classes11.dex */
public class BdSailorWebView extends FrameLayout implements INoProGuard {
    private static final String JAVASCTIPT_URL = "javascript:";
    private static final String SHOW_IMAGE_PREFIX = "imagedisplay:";
    private boolean mCanHideTitlebar;
    private boolean mCanShowTitlebar;
    private View mCurrentTitleBar;
    private WebView mCurrentWebView;
    private View mCustomView;
    private WebChromeClient.CustomViewCallback mCustomViewCallback;
    private ISailorDownloadListener mDownloadListener;
    private View mEmbeddedTitlebar;
    private int mEmbeddedTitlebarHeightPix;
    private FrameLayout mFullscreenContainer;
    private FrameLayout mFunctionViewLayer;
    private boolean mIsFunctionLayerShowing;
    private boolean mIsPageLoading;
    private View mLandingPageTitleBar;
    private BdLightappActionClient mLightappActionClient;
    private BdLightappKernelClient mLightappKernelClient;
    private boolean mLockEmbeddedTitlebar;
    private int mMarginBottom;
    private int mMarginLeft;
    private int mMarginRight;
    private int mMarginTop;
    private int mOriginalOrientation;
    private int mOuterTitlebarHeightPix;
    protected WebView.PictureListener mPictureListener;
    private View mSearchResultTitleBar;
    private int mSnapBgColor;
    private View mStatusBar;
    private int mStatusBarHeight;
    com.baidu.browser.sailor.feature.a.e mStopBackgroundkListener;
    private VideoPlayerFactory mVideoFactory;
    private g mViewDelegate;
    private BdSailorWebChromeClient mWebChromeClient;
    private BdSailorWebSettings mWebSettings;
    private BdSailorWebViewClient mWebViewClient;
    private ISailorWebViewExt mWebViewExt;
    private FrameLayout mWebViewLayer;
    private FrameLayout.LayoutParams mWebViewLayerLp;
    private static final String LOG_TAG = BdSailorWebView.class.getSimpleName();
    protected static final FrameLayout.LayoutParams COVER_SCREEN_PARAMS = new FrameLayout.LayoutParams(-1, -1);
    private static boolean sInitFirstWebView = true;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class BdSailorWebViewExt implements ISailorWebViewExt {
        private ISailorWebSettingsExt mSettingsExt;
        private BdSailorWebChromeClientExt mWebChromeClientExt;
        private BdSailorWebViewClientExt mWebViewClientExt;

        private BdSailorWebViewExt() {
        }

        /* synthetic */ BdSailorWebViewExt(BdSailorWebView bdSailorWebView, com.baidu.browser.sailor.a aVar) {
            this();
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public boolean canGoToPreloadNextExt() {
            return BdSailorWebView.this.mCurrentWebView.canGoPrerender();
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void changeWapPreloadUrlStyleExt(int i, String str) {
            BdSailorWebView.this.mCurrentWebView.changeWapPreloadUrlStyle(i, str);
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void completeSelectionExt() {
            BdSailorWebView.this.mCurrentWebView.completeSelection();
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void destroyCanvasCacheBmpExt() {
            BdSailorWebView.this.mCurrentWebView.destroyCanvasCacheBmp();
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void emulateShiftHeldOnLinkExt() {
            BdSailorWebView.this.mCurrentWebView.emulateShiftHeldOnLink();
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void emulateShiftHeldOnNormalTextExt() {
            BdSailorWebView.this.mCurrentWebView.emulateShiftHeldOnNormalText();
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void ensureRemoveSearchBoxImplExt() {
            com.baidu.webkit.internal.f secureProcessor = BdSailorWebView.this.mCurrentWebView.getSecureProcessor();
            if (secureProcessor.d()) {
                new Thread(new com.baidu.webkit.internal.g(secureProcessor), "T7@removeSearchBoxImpl").start();
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void execJavaScriptExt(String str, String... strArr) {
            if (strArr == null || strArr.length == 0) {
                BdSailorWebView.this.mCurrentWebView.loadUrl("javascript:(" + str + ")()");
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(BdSailorWebView.JAVASCTIPT_URL + str + "('");
            for (int i = 0; i < strArr.length; i++) {
                stringBuffer.append(strArr[i]);
                if (i != strArr.length - 1) {
                    stringBuffer.append(", ");
                }
            }
            stringBuffer.append("')");
            BdSailorWebView.this.mCurrentWebView.loadUrl(stringBuffer.toString());
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void exitFullScreenModeExt() {
            BdSailorWebView.this.mCurrentWebView.exitFullScreenMode();
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public int getActionNodesCountExt() {
            return BdSailorWebView.this.mCurrentWebView.getActionNodesCount();
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public float getActualZoomScaleExt() {
            return BdSailorWebView.this.mCurrentWebView.getActualZoomScale();
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public int getAdCount(String str) {
            return 0;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public int getBackgroundNightColorExt() {
            return 0;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public int getBigPluginTextNightColorExt() {
            return 0;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public int getBorderNightColorExt() {
            return 0;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public Bitmap getCanvasCacheBmpExt() {
            return BdSailorWebView.this.mCurrentWebView.getCanvasCacheBmp();
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public float getCurrentScaleExt() {
            return BdSailorWebView.this.mCurrentWebView.getCurrentScale();
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public int getDefaultLinkTextNightColorExt() {
            return 0;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public int getEmbeddedTitleBarHeightExt() {
            if (BdSailorWebView.this.mEmbeddedTitlebar != null) {
                return BdSailorWebView.this.mEmbeddedTitlebar.getHeight();
            }
            return 0;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public int getImageNightColorExt() {
            return 0;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public int getLinkTextNightColorExt() {
            return 0;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public int getMagicFilterCount() {
            return 0;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public Bitmap getMagnifierBmpExt() {
            return BdSailorWebView.this.mCurrentWebView.getMagnifierBmp();
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public float getMaxZoomScaleExt() {
            return BdSailorWebView.this.mCurrentWebView.getMaxZoomScale();
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public float getMinZoomScaleExt() {
            return BdSailorWebView.this.mCurrentWebView.getMinZoomScale();
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public int getNightModeColorStyleExt() {
            return BdSailorWebView.this.mCurrentWebView.nightModeColorStyle();
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public WebView.WebPageInfoList getPageInfo() {
            return BdSailorWebView.this.mCurrentWebView.getPageInfo();
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public List<String> getPictureUrlListExt() {
            return null;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public String getSelectionTextExt() {
            try {
                return (String) com.baidu.browser.core.util.b.a(WebView.class, this, "nativeGetSelection", null, null, "");
            } catch (Exception e) {
                return "";
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public ISailorWebSettingsExt getSettingsExt() {
            if (this.mSettingsExt == null) {
                BdSailorWebSettings settings = BdSailorWebView.this.getSettings();
                settings.getClass();
                this.mSettingsExt = new BdSailorWebSettings.BdSailorWebSettingsExt();
            }
            return this.mSettingsExt;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public int getTextNightColorExt() {
            return 0;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public int getVisitedLinkNightColorExt() {
            return 0;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public BdSailorWebChromeClientExt getWebChromeClientExt() {
            return this.mWebChromeClientExt;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public BdSailorWebViewClientExt getWebViewClientExt() {
            return this.mWebViewClientExt;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public ZoomButtonsController getZoomButtonsControllerExt() {
            try {
                return (ZoomButtonsController) com.baidu.browser.core.util.b.a(WebView.class, this, "getZoomControls", null, null, null);
            } catch (Exception e) {
                return null;
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void hideMagnifierExt(int i, int i2) {
            BdSailorWebView.this.mCurrentWebView.hideMagnifier(i, i2);
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void invokeLightappJsReadyEventExt() {
            BdSailorWebView.this.mCurrentWebView.getSecureProcessor().g = true;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public boolean isDestroyedExt() {
            return BdSailorWebView.this.mCurrentWebView.isDestroyed();
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public boolean isDrawSelectionPointerExt() {
            try {
                return ((Boolean) com.baidu.browser.core.util.b.a(WebView.class, this, "getDrawSelectionPointer", null, null, false)).booleanValue();
            } catch (Exception e) {
                return false;
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public boolean isExtendSelectionExt() {
            return false;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public boolean isFixWebViewSecurityHolesExt() {
            return BdSailorWebView.this.mCurrentWebView.getSecureProcessor().a();
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public boolean isForegroundExt() {
            return com.baidu.browser.sailor.util.b.a(BdSailorWebView.this);
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public boolean isMobileSiteExt() {
            return BdSailorWebView.this.mCurrentWebView.isMobileSite();
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public boolean isNeedImpactScriptExt() {
            return BdSailorWebView.this.mCurrentWebView.getSecureProcessor().f;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public boolean isNeedInvokeLightappJSReadyEventExt() {
            return BdSailorWebView.this.mCurrentWebView.getSecureProcessor().g;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public boolean isShiftPressedModeExt() {
            try {
                return ((Boolean) com.baidu.browser.core.util.b.a(WebView.class, this, "getShiftIsPressed", null, null, false)).booleanValue();
            } catch (Exception e) {
                return false;
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public boolean isTextSelectingModeExt() {
            return BdSailorWebView.this.mCurrentWebView.getSelectingText();
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public boolean isWapAllowScaleExt() {
            return BdSailorWebView.this.mCurrentWebView.isWapAllowScale();
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5, boolean z) {
            BdSailorWebView.this.mCurrentWebView.loadDataWithBaseURL(str, str2, str3, str4, str5, z);
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void loadUrl(String str, Map<String, String> map, boolean z) {
            BdSailorWebView.this.mCurrentWebView.loadUrl(str, map, z);
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void mediaPlayerStatusChangedExt(int i, float f, float f2) {
            BdSailorWebView.this.mCurrentWebView.mediaPlayerStatusChanged(i, f, f2);
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void mediaPlayerTimeChangedExt(float f, float f2) {
            BdSailorWebView.this.mCurrentWebView.mediaPlayerTimeChanged(f, f2);
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void moveMagnifierExt(int i, int i2) {
            BdSailorWebView.this.mCurrentWebView.moveMagnifier(i, i2);
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public boolean notifyNativeExitFullScreenIfNeededExt(int i) {
            return BdSailorWebView.this.mCurrentWebView.notifyNativeExitFullScreenIfNeeded(i);
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void onSearchKeyword(String str, String str2) {
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void onShowCommentPanel(String str, String str2) {
            if (this.mWebChromeClientExt != null) {
                this.mWebChromeClientExt.onShowCommentPanel(BdSailorWebView.this, str, str2);
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void onShowValidateComponent(String str, String str2) {
            if (this.mWebChromeClientExt != null) {
                this.mWebChromeClientExt.onShowValidateComponent(BdSailorWebView.this, str, str2);
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void pauseExt(boolean z) {
            BdSailorWebView.this.mCurrentWebView.pause(z);
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void pauseMediaExt() {
            BdSailorWebView.this.mCurrentWebView.pauseMedia();
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void resumeExt(boolean z) {
            BdSailorWebView.this.mCurrentWebView.resume(z);
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void resumeMediaExt() {
            BdSailorWebView.this.mCurrentWebView.resumeMedia();
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public boolean savePageAsLocalFilesExt(String str, String str2, WebView.SaveAsType saveAsType) {
            return BdSailorWebView.this.mCurrentWebView.savePageAsLocalFiles(str, str2, saveAsType);
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public boolean setBackgroundNightColorExt(int i) {
            return false;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void setBeginScaleExt() {
            BdSailorWebView.this.mCurrentWebView.setBeginScale();
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public boolean setBigPluginTextNightColorExt(int i) {
            return false;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public boolean setBorderNightColorExt(int i) {
            return false;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public boolean setDefaultLinkTextNightColorExt(int i) {
            return false;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void setDrawSelectionPointerExt(boolean z) {
            try {
                com.baidu.browser.core.util.b.a(WebView.class, this, "setDrawSelectionPointer", new Class[]{Boolean.TYPE}, new Object[]{Boolean.valueOf(z)}, false);
            } catch (Exception e) {
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void setEndScaleExt() {
            BdSailorWebView.this.mCurrentWebView.setEndScale();
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void setExtendSelectionExt(boolean z) {
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void setFixWebViewSecurityHolesExt(boolean z) {
            com.baidu.webkit.internal.f secureProcessor = BdSailorWebView.this.mCurrentWebView.getSecureProcessor();
            if (z != secureProcessor.c) {
                if (z) {
                    throw new RuntimeException("can not reverse!!");
                }
                secureProcessor.c = z;
                for (String str : secureProcessor.c().keySet()) {
                    secureProcessor.d.addJavascriptInterface(secureProcessor.c().get(str), str, false);
                }
                if (secureProcessor.b != null) {
                    secureProcessor.b.clear();
                }
                secureProcessor.e = null;
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public boolean setImageNightColorExt(int i) {
            return false;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void setLightappActionClientExt(BdLightappActionClient bdLightappActionClient) {
            BdSailorWebView.this.mCurrentWebView.addJavascriptInterface(new com.baidu.browser.sailor.feature.a.a(BdSailorWebView.this.mCurrentWebView, bdLightappActionClient), "Bdbox_android_xsearch");
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void setLightappKernalClientExt(BdLightappKernelClient bdLightappKernelClient) {
            BdSailorWebView.this.mLightappKernelClient = bdLightappKernelClient;
            BdSailorWebView.this.mCurrentWebView.addJavascriptInterface(new com.baidu.browser.sailor.feature.a.c(BdSailorWebView.this, bdLightappKernelClient), "BLightApp");
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public boolean setLinkTextNightColorExt(int i) {
            return false;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void setNeedImpactScriptExt(boolean z) {
            BdSailorWebView.this.mCurrentWebView.getSecureProcessor().f = z;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public boolean setNightModeColorStyleExt(int i) {
            return false;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public boolean setPreviewZoomScaleExt(float f) {
            return BdSailorWebView.this.mCurrentWebView.setPreviewZoomScale(f);
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void setShiftPressedModeExt(boolean z) {
            try {
                com.baidu.browser.core.util.b.a(WebView.class, this, "setShiftIsPressed", new Class[]{Boolean.TYPE}, new Object[]{Boolean.valueOf(z)}, false);
            } catch (Exception e) {
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void setSubjectScrollToOnloadExt(int i) {
            BdSailorWebView.this.mCurrentWebView.setSubjectScrollToOnload(i);
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void setTextFieldTextExt(String str) {
            BdSailorWebView.this.mCurrentWebView.setTextFieldText(str);
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void setTextFieldTextExt(String str, boolean z) {
            if (z) {
                BdSailorWebView.this.mCurrentWebView.insertTextFieldText(str);
            } else {
                BdSailorWebView.this.mCurrentWebView.setTextFieldText(str);
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public boolean setTextNightColorExt(int i) {
            return false;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void setTextSelectingModeExt(boolean z) {
            BdSailorWebView.this.mCurrentWebView.setSelectingText(z);
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public boolean setVisitedLinkNightColorExt(int i) {
            return BdSailorWebView.this.mCurrentWebView.setVisitedLinkNightColor(i);
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void setWebChromeClientExt(BdSailorWebChromeClientExt bdSailorWebChromeClientExt) {
            this.mWebChromeClientExt = bdSailorWebChromeClientExt;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void setWebViewClientExt(BdSailorWebViewClientExt bdSailorWebViewClientExt) {
            this.mWebViewClientExt = bdSailorWebViewClientExt;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void setWebViewStateExt(WebView.WebViewState webViewState) {
            BdSailorWebView.this.mCurrentWebView.setWebViewState(webViewState);
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void setWebViewTypeExt(WebView.WebViewType webViewType) {
            BdSailorWebView.this.mCurrentWebView.setWebViewType(webViewType);
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void showMagnifierExt(int i, int i2, int i3, int i4, boolean z) {
            BdSailorWebView.this.mCurrentWebView.showMagnifier(i, i2, i3, i4, z);
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void startCaptureContentExt() {
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void startLoadingAnimation() {
            BdSailorWebView.this.mCurrentWebView.startLoadingAnimation(null);
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void startLoadingAnimation(String str) {
            BdSailorWebView.this.mCurrentWebView.startLoadingAnimation(str);
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public boolean startPreviewZoomScaleExt() {
            return BdSailorWebView.this.mCurrentWebView.startPreviewZoomScale();
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void updatePictureUrlListExt() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a extends WebBackForwardListClient {
        private WebView acg;

        protected a(WebView webView) {
            this.acg = webView;
        }

        @Override // com.baidu.webkit.sdk.WebBackForwardListClient
        public final void onIndexChanged(WebHistoryItem webHistoryItem, int i) {
            super.onIndexChanged(webHistoryItem, i);
        }

        @Override // com.baidu.webkit.sdk.WebBackForwardListClient
        public final void onNewHistoryItem(WebHistoryItem webHistoryItem) {
            if (BdSailorWebView.this.mWebViewExt.getWebViewClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onNewPage(BdSailorWebView.this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class b implements WebView.PictureListener {
        private b() {
        }

        /* synthetic */ b(BdSailorWebView bdSailorWebView, byte b) {
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
    /* loaded from: classes11.dex */
    public class c implements DownloadListener {
        private WebView acg;

        public c(WebView webView) {
            this.acg = webView;
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
    /* loaded from: classes11.dex */
    public class d extends WebChromeClient {
        private String[] b = {"mail.163.com", "mail.126.com", "mail.yeah.net", "shouji.163.com"};

        public d() {
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void copyText(WebView webView, String str) {
            if (BdSailorWebView.this.mWebViewExt.getWebChromeClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebChromeClientExt().copyTextExt(BdSailorWebView.this, str);
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
            long currentTimeMillis = System.currentTimeMillis();
            if (BdSailorWebView.this.mWebChromeClient != null) {
                BdSailorWebView.this.mWebChromeClient.getVisitedHistory(BdSailorWebView.this, valueCallback);
            } else {
                super.getVisitedHistory(valueCallback);
            }
            SessionMonitorEngine.getInstance().onPageKeySectionTimeCost(BdSailorWebView.this.getCurrentWebView(), BdSailorWebView.this.getUrl(), MonitorConstant.KeySectionType.GET_VISITED_HISTORY.ordinal(), System.currentTimeMillis() - currentTimeMillis);
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void hideMagnifier(WebView webView, int i, int i2) {
            if (BdSailorWebView.this.mWebViewExt.getWebChromeClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebChromeClientExt().hideMagnifierExt(BdSailorWebView.this, i, i2);
            } else {
                super.hideMagnifier(webView, i, i2);
            }
            BdSailorWebView.this.mIsFunctionLayerShowing = false;
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void hideSelectionActionDialog(WebView webView) {
            if (BdSailorWebView.this.mWebViewExt.getWebChromeClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebChromeClientExt().hideSelectionActionDialogExt(BdSailorWebView.this);
            } else {
                super.hideSelectionActionDialog(webView);
            }
            BdSailorWebView.this.mIsFunctionLayerShowing = false;
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void moveMagnifier(WebView webView, int i, int i2, int i3, int i4) {
            if (BdSailorWebView.this.mWebViewExt.getWebChromeClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebChromeClientExt().moveMagnifierExt(BdSailorWebView.this, i, i2, i3, i4);
            } else {
                super.moveMagnifier(webView, i, i2, i3, i4);
            }
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final boolean needNotifyNativeExitFullScreen() {
            return BdSailorWebView.this.mWebViewExt.getWebChromeClientExt() != null ? BdSailorWebView.this.mWebViewExt.getWebChromeClientExt().needNotifyNativeExitFullScreenExt(BdSailorWebView.this) : super.needNotifyNativeExitFullScreen();
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void notifyClickWhenLoad() {
            if (BdSailorWebView.this.mWebViewExt.getWebChromeClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebChromeClientExt().notifyClickWhenLoadExt(BdSailorWebView.this);
            } else {
                super.notifyClickWhenLoad();
            }
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void notifyClientStatus(WebView webView, int i) {
            if (BdSailorWebView.this.mWebViewExt.getWebChromeClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebChromeClientExt().notifyClientStatusExt(BdSailorWebView.this, i);
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
            if (BdSailorWebView.this.mWebViewExt.getWebChromeClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebChromeClientExt().onNativeElementEnterFullScreenExt(BdSailorWebView.this);
            } else {
                super.onNativeElementEnterFullScreen();
            }
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void onNativeElementExitFullScreen() {
            if (BdSailorWebView.this.mWebViewExt.getWebChromeClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebChromeClientExt().onNativeElementExitFullScreenExt(BdSailorWebView.this);
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
            if (BdSailorWebView.this.mWebViewExt.getWebChromeClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebChromeClientExt().onPrerenderChanged(i, prerenderStatus);
            }
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void onProgressChanged(WebView webView, int i) {
            long currentTimeMillis = System.currentTimeMillis();
            super.onProgressChanged(webView, i);
            if (BdSailorWebView.this.mWebChromeClient != null) {
                BdSailorWebView.this.mWebChromeClient.onProgressChanged(BdSailorWebView.this, i);
            }
            if (webView == BdSailorWebView.this.mCurrentWebView && i == 100) {
                BdSailorWebView.this.mIsPageLoading = false;
            }
            SessionMonitorEngine.getInstance().onPageKeySectionTimeCost(webView, webView.getUrl(), MonitorConstant.KeySectionType.PROGRESSCHANGED.ordinal(), System.currentTimeMillis() - currentTimeMillis);
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
            if (BdSailorWebView.this.mWebViewExt.getWebChromeClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebChromeClientExt().onSetLoadURLExt(BdSailorWebView.this, str);
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
            if (BdZeusUtil.isWebkitLoaded() || Build.VERSION.SDK_INT >= 19) {
                if (BdSailorWebView.this.mWebViewExt != null && BdSailorWebView.this.mWebViewExt.getWebChromeClientExt() != null) {
                    BdSailorWebView.this.mIsFunctionLayerShowing = true;
                    BdSailorWebView.this.mWebViewExt.getWebChromeClientExt().performLongClickExt(BdSailorWebView.this, i, str, str2, i2, i3);
                }
                if (i == 5 || i == 8) {
                    BdSailorWebView.this.getWebViewExt().updatePictureUrlListExt();
                }
            }
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void performLongClick(WebView webView, WebView.HitTestResult hitTestResult, int i, int i2) {
            super.performLongClick(webView, hitTestResult, i, i2);
            if (BdZeusUtil.isWebkitLoaded() || Build.VERSION.SDK_INT >= 19) {
                if (BdSailorWebView.this.mWebViewExt != null && BdSailorWebView.this.mWebViewExt.getWebChromeClientExt() != null) {
                    BdSailorWebView.this.mIsFunctionLayerShowing = true;
                    BdSailorWebView.this.mWebViewExt.getWebChromeClientExt().performLongClickExt(BdSailorWebView.this, hitTestResult, i, i2);
                }
                if (hitTestResult.getType() == 5 || hitTestResult.getType() == 8) {
                    BdSailorWebView.this.getWebViewExt().updatePictureUrlListExt();
                }
            }
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void showMagnifier(WebView webView, int i, int i2, int i3, int i4) {
            BdSailorWebView.this.mIsFunctionLayerShowing = true;
            if (BdSailorWebView.this.mWebViewExt.getWebChromeClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebChromeClientExt().showMagnifierExt(BdSailorWebView.this, i, i2, i3, i4);
            } else {
                super.showMagnifier(webView, i, i2, i3, i4);
            }
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void showSelectionActionDialog(WebView webView, int i, int i2, int i3, int i4, String str) {
            BdSailorWebView.this.mIsFunctionLayerShowing = true;
            if (BdSailorWebView.this.mWebViewExt.getWebChromeClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebChromeClientExt().showSelectionActionDialogExt(BdSailorWebView.this, i, i2, i3, i4, str);
            } else {
                super.showSelectionActionDialog(webView, i, i2, i3, i4, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class e extends WebViewClient {
        private String[] b;

        private e() {
            this.b = new String[]{"wtai://", "tel:", UrlSchemaHelper.SCHEMA_TYPE_SMS, "mailto", "smsto:"};
        }

        /* synthetic */ e(BdSailorWebView bdSailorWebView, byte b) {
            this();
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void AntiHijackSign(WebView webView, String str) {
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final boolean canHandleImage(WebView webView, String str, String str2, String str3) {
            if (BdSailorWebView.this.mWebViewExt.getWebViewClientExt() != null) {
                r5 = BdSailorWebView.this.mWebViewExt.getWebViewClientExt().shouldHandleImageExt(BdSailorWebView.this, str, str2, str3, BdSailorWebView.this.mCurrentWebView == webView);
            }
            if (r5) {
                BdSailorWebView.this.stopLoading();
                return true;
            }
            return super.canHandleImage(webView, str, str2, str3);
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final int computeHookH5NavigationStep(int i) {
            Log.i(WebViewClient.LOG_TAG, "BeeFrame computeHookH5NavigationStep: offset=" + i);
            return BdSailorWebView.this.mWebViewExt.getWebViewClientExt() != null ? BdSailorWebView.this.mWebViewExt.getWebViewClientExt().computeHookH5NavigationStep(i) : super.computeHookH5NavigationStep(i);
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void doUpdateVisitedHistory(WebView webView, String str, boolean z, boolean z2, boolean z3, boolean z4) {
            long currentTimeMillis = System.currentTimeMillis();
            super.doUpdateVisitedHistory(webView, str, z, z2, z3, z4);
            if (BdSailorWebView.this.mWebViewClient != null) {
                BdSailorWebView.this.mWebViewClient.doUpdateVisitedHistory(BdSailorWebView.this, str, z);
            }
            if (BdSailorWebView.this.mWebViewExt.getWebViewClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebViewClientExt().doUpdateVisitedHistory(BdSailorWebView.this, str, z, z2, z3, z4);
            }
            SessionMonitorEngine.getInstance().onPageKeySectionTimeCost(webView, str, MonitorConstant.KeySectionType.DO_UPDATE_VISITED_HISTORY.ordinal(), System.currentTimeMillis() - currentTimeMillis);
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onAbortResourceRequest(WebView webView, String str, String str2, long j) {
            if (!(webView instanceof WebView) || BdSailorWebView.this.isDestroyed() || BdSailorWebView.this.mWebViewExt == null || BdSailorWebView.this.mWebViewExt.getWebViewClientExt() == null) {
                return;
            }
            BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onAbortResourceRequest(BdSailorWebView.this, str, str2, j);
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onCheckHasManifestAndServiceWorker(WebView webView, String str, String str2, boolean z) {
            if (BdSailorWebView.this.mWebViewExt.getWebViewClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onCheckHasManifestAndServiceWorker(BdSailorWebView.this, str, str2, z);
            } else {
                super.onCheckHasManifestAndServiceWorker(webView, str, str2, z);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onDidAsyncWiseSearchStatusChanged(WebView webView, String str, int i, long j) {
            super.onDidAsyncWiseSearchStatusChanged(webView, str, i, j);
            if (BdSailorWebView.this.mWebViewExt == null || BdSailorWebView.this.mWebViewExt.getWebViewClientExt() == null) {
                return;
            }
            BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onDidAsyncWiseSearchStatusChangedExt(BdSailorWebView.this, str, i, j);
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onDisplaySoftKeyboard(WebView webView) {
            if (BdSailorWebView.this.mWebViewExt.getWebViewClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onDisplaySoftKeyboardExt(BdSailorWebView.this);
            } else {
                super.onDisplaySoftKeyboard(webView);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onFirstContentfulPaint(WebView webView, String str) {
            if (BdSailorWebView.this.mWebViewExt == null || BdSailorWebView.this.mWebViewExt.getWebViewClientExt() == null) {
                return;
            }
            Log.i(WebViewClient.LOG_TAG, "FCPCallback onFirstContentfulPaintExt, aUrl : " + str);
            BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onFirstContentfulPaintExt(BdSailorWebView.this, str);
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onFirstLayoutDid(WebView webView, String str) {
            long currentTimeMillis = System.currentTimeMillis();
            BdSailorWebView.this.perfLog(webView, "onFirstLayoutDid");
            super.onFirstLayoutDid(webView, str);
            if (BdSailorWebView.this.mWebViewExt != null && BdSailorWebView.this.mWebViewExt.getWebViewClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onFirstLayoutDidExt(BdSailorWebView.this, str);
            }
            SessionMonitorEngine.getInstance().onPageKeySectionTimeCost(webView, str, MonitorConstant.KeySectionType.DID_FIRST_LAYOUT.ordinal(), System.currentTimeMillis() - currentTimeMillis);
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onFirstPaintDid(WebView webView, String str) {
            long currentTimeMillis = System.currentTimeMillis();
            BdSailorWebView.this.perfLog(webView, "onFirstPaintDid", "Started");
            super.onFirstPaintDid(webView, str);
            if (BdSailorWebView.this.mWebViewExt != null && BdSailorWebView.this.mWebViewExt.getWebViewClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onFirstPaintDidExt(BdSailorWebView.this, str);
            }
            BdSailorWebView.this.perfLog(webView, "onFirstPaintDid", "Finished");
            BdSailorWebView.this.perfLog(ETAG.KEY_FIRST_PAINT, str);
            SessionMonitorEngine.getInstance().onPageKeySectionTimeCost(webView, str, MonitorConstant.KeySectionType.DID_FIRST_PAINT.ordinal(), System.currentTimeMillis() - currentTimeMillis);
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onFirstScreenPaintFinished(WebView webView, String str, int i, int i2, int i3, int i4, int i5) {
            long currentTimeMillis = System.currentTimeMillis();
            BdSailorWebView.this.perfLog(webView, "onFirstScreenPaintFinished");
            super.onFirstScreenPaintFinished(webView, str, i, i2, i3, i4, i5);
            if (BdSailorWebView.this.mWebViewExt != null && BdSailorWebView.this.mWebViewExt.getWebViewClientExt() != null) {
                BdSailorWebView.this.perfLog(webView, "onFirstScreenPaintFinished 22");
                BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onFirstScreenPaintFinishedExt(BdSailorWebView.this, str);
            }
            SessionMonitorEngine.getInstance().onPageKeySectionTimeCost(webView, str, MonitorConstant.KeySectionType.FIRST_SCREEN_PAINT.ordinal(), System.currentTimeMillis() - currentTimeMillis);
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
            if (BdSailorWebView.this.mWebViewExt.getWebViewClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onFullScreenModeExt(BdSailorWebView.this, z, i, i2);
            } else {
                super.onFullScreenMode(webView, z, i, i2);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onGestureFlingEnded(WebView webView, int i, int i2) {
            BdSailorWebViewClientExt webViewClientExt;
            if (webView != BdSailorWebView.this.mCurrentWebView || (webViewClientExt = BdSailorWebView.this.getWebViewExt().getWebViewClientExt()) == null) {
                return;
            }
            webViewClientExt.onGestureFlingEnded(BdSailorWebView.this, i, i2);
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onGestureScrollEnded(WebView webView, int i, int i2) {
            BdSailorWebViewClientExt webViewClientExt;
            if (webView != BdSailorWebView.this.mCurrentWebView || (webViewClientExt = BdSailorWebView.this.getWebViewExt().getWebViewClientExt()) == null) {
                return;
            }
            webViewClientExt.onGestureScrollEnded(BdSailorWebView.this, i, i2);
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onGestureScrollStarted(WebView webView, int i, int i2) {
            BdSailorWebViewClientExt webViewClientExt;
            if (webView != BdSailorWebView.this.mCurrentWebView || (webViewClientExt = BdSailorWebView.this.getWebViewExt().getWebViewClientExt()) == null) {
                return;
            }
            webViewClientExt.onGestureScrollStarted(BdSailorWebView.this, i, i2);
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final String onGetErrorContent(WebView webView, int i, String str, String str2) {
            String str3 = null;
            if ((webView instanceof WebView) && !BdSailorWebView.this.isDestroyed() && BdSailorWebView.this.mWebViewExt != null && BdSailorWebView.this.mWebViewExt.getWebViewClientExt() != null) {
                str3 = BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onGetErrorHtmlExt(BdSailorWebView.this, i, str, str2);
            }
            return str3 != null ? str3 : BdSailorPlatform.getDefaultErrorPageHtml(webView.getContext());
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onGoBackOrForward(WebView webView, int i) {
            if (webView == BdSailorWebView.this.mCurrentWebView) {
                BdSailorWebView.this.goBackOrForward(i);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onGoBackOrForwardAnimationFinish(WebView webView, int i) {
            BdSailorWebViewClientExt webViewClientExt;
            if (webView != BdSailorWebView.this.mCurrentWebView || (webViewClientExt = BdSailorWebView.this.getWebViewExt().getWebViewClientExt()) == null) {
                return;
            }
            webViewClientExt.onGoBackOrForwardAnimationFinish(BdSailorWebView.this, i);
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onGoBackOrForwardAnimationStart(WebView webView, int i) {
            BdSailorWebViewClientExt webViewClientExt;
            if (webView != BdSailorWebView.this.mCurrentWebView || (webViewClientExt = BdSailorWebView.this.getWebViewExt().getWebViewClientExt()) == null) {
                return;
            }
            webViewClientExt.onGoBackOrForwardAnimationStart(BdSailorWebView.this, i);
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onHasVideo(WebView webView) {
            if (BdSailorWebView.this.mWebViewExt.getWebViewClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onHasVideoExt(BdSailorWebView.this);
            } else {
                super.onHasVideo(webView);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onHideSoftKeyboard(WebView webView) {
            if (BdSailorWebView.this.mWebViewExt.getWebViewClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onHideSoftKeyboardExt(BdSailorWebView.this);
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
            if (BdSailorWebView.this.mWebViewExt.getWebViewClientExt() != null ? BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onKeywordExtensionExt(BdSailorWebView.this, str, str2) : false) {
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
        public final void onNavigationAnimationFinish(WebView webView, boolean z, boolean z2) {
            BdSailorWebViewClientExt webViewClientExt;
            if (webView != BdSailorWebView.this.mCurrentWebView || (webViewClientExt = BdSailorWebView.this.getWebViewExt().getWebViewClientExt()) == null) {
                return;
            }
            webViewClientExt.onNavigationAnimationFinish(BdSailorWebView.this, z, z2);
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onNavigationAnimationStart(WebView webView, boolean z) {
            BdSailorWebViewClientExt webViewClientExt;
            if (webView != BdSailorWebView.this.mCurrentWebView || (webViewClientExt = BdSailorWebView.this.getWebViewExt().getWebViewClientExt()) == null) {
                return;
            }
            webViewClientExt.onNavigationAnimationStart(BdSailorWebView.this, z);
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onNewHistoryItem(WebView webView, String str, int i) {
            long currentTimeMillis = System.currentTimeMillis();
            if (BdSailorWebView.this.mWebViewExt != null && BdSailorWebView.this.mWebViewExt.getWebViewClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onNewPage(BdSailorWebView.this);
            }
            SessionMonitorEngine.getInstance().onPageKeySectionTimeCost(webView, str, MonitorConstant.KeySectionType.NEW_HISTORY_ITEM.ordinal(), System.currentTimeMillis() - currentTimeMillis);
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onPageCanBeScaled(WebView webView, boolean z) {
            if (BdSailorWebView.this.mWebViewExt == null || BdSailorWebView.this.mWebViewExt.getWebViewClientExt() == null) {
                super.onPageCanBeScaled(webView, z);
            } else {
                BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onPageCanBeScaledExt(BdSailorWebView.this, z);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onPageCommitVisible(WebView webView, String str, boolean z) {
            long currentTimeMillis = System.currentTimeMillis();
            super.onPageCommitVisible(webView, str, z);
            if (BdSailorWebView.this.mWebViewClient != null) {
                BdSailorWebView.this.mWebViewClient.onPageCommitVisible(BdSailorWebView.this, str);
            }
            SessionMonitorEngine.getInstance().onPageKeySectionTimeCost(webView, str, MonitorConstant.KeySectionType.PAGE_COMMIT_VISIBLE.ordinal(), System.currentTimeMillis() - currentTimeMillis);
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onPageFinished(WebView webView, String str) {
            BdSailorWebView.this.perfLog(webView, "onPageFinished");
            long currentTimeMillis = System.currentTimeMillis();
            super.onPageFinished(webView, str);
            if (BdSailorWebView.this.mWebViewClient != null) {
                BdSailorWebView.this.mWebViewClient.onPageFinished(BdSailorWebView.this, str);
            }
            if (webView == BdSailorWebView.this.mCurrentWebView) {
                BdSailorWebView.this.mIsPageLoading = false;
            }
            SessionMonitorEngine.getInstance().onPageKeySectionTimeCost(webView, str, MonitorConstant.KeySectionType.PAGEFINISH.ordinal(), System.currentTimeMillis() - currentTimeMillis);
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            BdSailorWebView.this.perfLog(webView, "onPageStarted");
            long currentTimeMillis = System.currentTimeMillis();
            super.onPageStarted(webView, str, bitmap);
            if (BdSailorWebView.this.mWebViewClient != null) {
                BdSailorWebView.this.mWebViewClient.onPageStarted(BdSailorWebView.this, str, bitmap);
            }
            SessionMonitorEngine.getInstance().onPageKeySectionTimeCost(webView, str, MonitorConstant.KeySectionType.PAGESTART.ordinal(), System.currentTimeMillis() - currentTimeMillis);
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
            if (BdSailorWebView.this.mWebViewExt.getWebViewClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onPausePluginExt(BdSailorWebView.this);
            } else {
                super.onPausePlugin();
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onPlayPlugin() {
            if (BdSailorWebView.this.mWebViewExt.getWebViewClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onPlayPluginExt(BdSailorWebView.this);
            } else {
                super.onPlayPlugin();
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onPreloadUrlFound(WebView webView, String str) {
            super.onPreloadUrlFound(webView, str);
            if (BdSailorWebView.this.mWebViewExt == null || BdSailorWebView.this.mWebViewExt.getWebViewClientExt() == null) {
                super.onPreloadUrlFound(webView, str);
            } else {
                BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onPreloadUrlFoundExt(BdSailorWebView.this, str);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onProceededAfterSslError(WebView webView, SslError sslError) {
            if (BdSailorWebView.this.mWebViewExt.getWebViewClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onProceededAfterSslErrorExt(BdSailorWebView.this, sslError);
            } else {
                super.onProceededAfterSslError(webView, sslError);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final String onProcessWebSearchUrl(WebView webView, String str) {
            return (BdSailorWebView.this.mWebViewExt == null || BdSailorWebView.this.mWebViewExt.getWebViewClientExt() == null) ? super.onProcessWebSearchUrl(webView, str) : BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onProcessWebSearchUrl(BdSailorWebView.this, str);
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
            long currentTimeMillis = System.currentTimeMillis();
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            if (BdSailorWebView.this.mWebViewClient != null && webResourceRequest.isForMainFrame() && (webResourceRequest.getUrl().toString().startsWith("http://") || webResourceRequest.getUrl().toString().startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX))) {
                BdSailorWebView.this.mWebViewClient.onReceivedError(BdSailorWebView.this, webResourceError.getErrorCode(), webResourceError.getDescription().toString(), webResourceRequest.getUrl().toString());
            }
            SessionMonitorEngine.getInstance().onPageKeySectionTimeCost(webView, webView.getUrl(), MonitorConstant.KeySectionType.RECEIVED_ERROR.ordinal(), System.currentTimeMillis() - currentTimeMillis);
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
            com.baidu.browser.sailor.feature.a featureByName = BdSailorPlatform.getInstance().getFeatureByName(BdSailorConfig.SAILOR_BASE_SSL);
            if (featureByName != null && featureByName.isEnable()) {
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
            } else if (BdSailorWebView.this.mWebViewClient != null) {
                BdSailorWebView.this.mWebViewClient.onReceivedSslError(BdSailorWebView.this, sslErrorHandler, sslError);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            return BdSailorWebView.this.mWebViewClient != null ? BdSailorWebView.this.mWebViewClient.onRenderProcessGone(BdSailorWebView.this, renderProcessGoneDetail) : super.onRenderProcessGone(webView, renderProcessGoneDetail);
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onResourceLoaded(WebView webView, String str, long j, String str2, String str3, int i) {
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onRestoreFromCache(WebView webView, String str) {
            if (BdSailorWebView.this.mWebViewExt.getWebViewClientExt() == null) {
                super.onRestoreFromCache(webView, str);
                return;
            }
            BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onRestoreFromPageCacheDid(BdSailorWebView.this, str);
            BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onRestoreFromCache(BdSailorWebView.this, str);
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onRestoreFromPageCacheDid(WebView webView, String str) {
            long currentTimeMillis = System.currentTimeMillis();
            if (BdSailorWebView.this.mWebViewExt.getWebViewClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onRestoreFromPageCacheDid(BdSailorWebView.this, str);
            } else {
                super.onRestoreFromPageCacheDid(webView, str);
            }
            SessionMonitorEngine.getInstance().onPageKeySectionTimeCost(webView, str, MonitorConstant.KeySectionType.RESTORE_FROM_CACHE.ordinal(), System.currentTimeMillis() - currentTimeMillis);
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onResumePlugin() {
            if (BdSailorWebView.this.mWebViewExt.getWebViewClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onResumePluginExt(BdSailorWebView.this);
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
        public final void onSearchLandingPageClicked(WebView webView, String str, String str2, long j) {
            super.onSearchLandingPageClicked(webView, str, str2, j);
            if (BdSailorWebView.this.mWebViewExt == null || BdSailorWebView.this.mWebViewExt.getWebViewClientExt() == null) {
                return;
            }
            BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onSearchLandingPageClicked(BdSailorWebView.this, str, str2, j);
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onSecurityCheckResult(WebView webView, String str, WebViewClient.SecurityInfo securityInfo) {
            if (BdSailorWebView.this.mWebViewExt.getWebViewClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onSecurityCheckResultExt(BdSailorWebView.this, str, securityInfo);
            }
            super.onSecurityCheckResult(webView, str, securityInfo);
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onStartFirstNavigation(WebView webView, String str, boolean z, boolean z2, boolean z3) {
            BdSailorWebViewClientExt webViewClientExt;
            if (webView != BdSailorWebView.this.mCurrentWebView || (webViewClientExt = BdSailorWebView.this.getWebViewExt().getWebViewClientExt()) == null) {
                return;
            }
            webViewClientExt.onStartFirstNavigation(BdSailorWebView.this, str, z, z2, z3);
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final boolean onSubFrameBeforeRequest(WebView webView, String str) {
            if (!(webView instanceof WebView) || BdSailorWebView.this.isDestroyed() || BdSailorWebView.this.mWebViewExt == null || BdSailorWebView.this.mWebViewExt.getWebViewClientExt() == null) {
                return false;
            }
            return BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onSubFrameBeforeRequest(BdSailorWebView.this, str);
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onSubjectsCollected(WebView webView, boolean z, int i) {
            if (BdSailorWebView.this.mWebViewExt.getWebViewClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onSubjectsCollectedExt(BdSailorWebView.this, z, i);
            } else {
                super.onSubjectsCollected(webView, z, i);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final boolean onSupportsForceZoomScale(WebView webView) {
            return BdSailorWebView.this.mWebViewExt.getWebViewClientExt() != null ? BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onSupportsForceZoomScale(BdSailorWebView.this) : super.onSupportsForceZoomScale(webView);
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final boolean onTextCopied(WebView webView) {
            if (BdSailorWebView.this.mWebViewExt.getWebViewClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onTextCopiedExt(BdSailorWebView.this);
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
            if (BdSailorWebView.this.mWebViewExt.getWebViewClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onUpdateTextFieldNextPreStatus(BdSailorWebView.this, z, z2);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onUserInteraction(WebView webView, String str, WebViewClient.InteractionType interactionType) {
            super.onUserInteraction(webView, str, interactionType);
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            long currentTimeMillis = System.currentTimeMillis();
            WebResourceResponse shouldInterceptRequest = super.shouldInterceptRequest(webView, str);
            if (shouldInterceptRequest != null) {
                return shouldInterceptRequest;
            }
            if (BdSailorWebView.this.mWebViewClient != null) {
                return BdSailorWebView.this.mWebViewClient.shouldInterceptRequest(BdSailorWebView.this, str);
            }
            SessionMonitorEngine.getInstance().onPageKeySectionTimeCost(webView, str, MonitorConstant.KeySectionType.SHOULD_INTERCEPT_REQUEST.ordinal(), System.currentTimeMillis() - currentTimeMillis);
            return shouldInterceptRequest;
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final boolean shouldKeywordExtension(WebView webView, String str) {
            return BdSailorWebView.this.mWebViewExt.getWebViewClientExt() != null ? BdSailorWebView.this.mWebViewExt.getWebViewClientExt().shouldKeywordExtensionExt(BdSailorWebView.this, str) : super.shouldKeywordExtension(webView, str);
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final boolean shouldOpenFlash(WebView webView, String str) {
            if (BdSailorWebView.this.mWebViewExt.getWebViewClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebViewClientExt().shouldOpenFlashExt(BdSailorWebView.this, str);
            }
            return super.shouldOpenFlash(webView, str);
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
            return BdSailorWebView.this.mWebViewClient != null ? BdSailorWebView.this.mWebViewClient.shouldOverrideKeyEvent(BdSailorWebView.this, keyEvent) : super.shouldOverrideKeyEvent(webView, keyEvent);
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final boolean shouldOverrideSpecialUrlLoading(WebView webView, String str) {
            long currentTimeMillis = System.currentTimeMillis();
            boolean shouldOverrideUrlLoading = BdSailorWebView.this.mWebViewClient != null ? BdSailorWebView.this.mWebViewClient.shouldOverrideUrlLoading(BdSailorWebView.this, str) : false;
            SessionMonitorEngine.getInstance().onPageKeySectionTimeCost(webView, str, MonitorConstant.KeySectionType.SHOULD_SPECIAL_LOADING.ordinal(), System.currentTimeMillis() - currentTimeMillis);
            return shouldOverrideUrlLoading;
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            int i = 0;
            BdSailorWebView.this.perfLog(webView, "shouldOverrideUrlLoading");
            long currentTimeMillis = System.currentTimeMillis();
            webView.getSecureProcessor().a(str);
            boolean shouldOverrideUrlLoading = BdSailorWebView.this.mWebViewClient != null ? BdSailorWebView.this.mWebViewClient.shouldOverrideUrlLoading(BdSailorWebView.this, str) : false;
            boolean shouldOverrideUrlLoading2 = !shouldOverrideUrlLoading ? super.shouldOverrideUrlLoading(webView, str) : shouldOverrideUrlLoading;
            if (shouldOverrideUrlLoading2 && !TextUtils.isEmpty(str)) {
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
            SessionMonitorEngine.getInstance().onPageKeySectionTimeCost(webView, str, MonitorConstant.KeySectionType.SHOULD_OVERRIDE_URL_LOADING.ordinal(), System.currentTimeMillis() - currentTimeMillis);
            return shouldOverrideUrlLoading2;
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void shouldPageRollBack(WebView webView, String str) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public static class f extends FrameLayout {
        public f(Context context) {
            super(context);
            setBackgroundColor(context.getResources().getColor(context.getResources().getIdentifier("sailor_common_black", "color", context.getPackageName())));
        }

        @Override // android.view.View
        public final boolean onTouchEvent(MotionEvent motionEvent) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes11.dex */
    public class g extends WebViewDelegate {
        public g(WebView webView) {
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
        public final View getCurrentTitleBar() {
            return BdSailorWebView.this.getCurrentTitleBar();
        }

        @Override // com.baidu.webkit.sdk.WebViewDelegate
        public final View getEmbeddedTitlebar() {
            return BdSailorWebView.this.getEmbeddedTitlebar();
        }

        @Override // com.baidu.webkit.sdk.WebViewDelegate
        public final View getLandingPageTitleBar() {
            return BdSailorWebView.this.getLandingPageTitleBar();
        }

        @Override // com.baidu.webkit.sdk.WebViewDelegate
        public final View getSearchResultTitleBar() {
            return BdSailorWebView.this.getSearchResultTitleBar();
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

        @Override // com.baidu.webkit.sdk.WebViewDelegate
        public final void setCurrentTitleBar(boolean z) {
            BdSailorWebView.this.setCurrentTitleBar(z);
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
        this.mViewDelegate = new g(webView);
        webView.setViewDelegate(this.mViewDelegate);
        if (com.baidu.browser.sailor.util.b.c() && BdZeusUtil.isWebkitLoaded()) {
            return;
        }
        getWebViewContainer().addView(webView, i, new FrameLayout.LayoutParams(-1, -1));
    }

    private void bringStatusBarToFront() {
        if (!com.baidu.browser.sailor.util.b.c() || this.mStatusBar == null || indexOfChild(this.mStatusBar) < 0) {
            return;
        }
        bringChildToFront(this.mStatusBar);
    }

    public static void cancelPreload(String str) {
    }

    private void init() {
        checkInit();
        this.mWebSettings = new BdSailorWebSettings(this.mCurrentWebView.getSettings());
        this.mWebViewExt = new BdSailorWebViewExt(this, null);
        this.mWebViewLayer = new FrameLayout(this.mCurrentWebView.getContext());
        this.mWebViewLayerLp = new FrameLayout.LayoutParams(-1, -1);
        if (!com.baidu.browser.sailor.util.b.c() || !BdZeusUtil.isWebkitLoaded()) {
            addView(this.mWebViewLayer, this.mWebViewLayerLp);
        }
        initWebView(this.mCurrentWebView);
        addWebView(this.mCurrentWebView);
        setFocusableInTouchMode(true);
        if (BdSailor.getInstance().getSailorClient() != null) {
            BdSailor.getInstance().getSailorClient().updateSearchUrlProtocol(getContext(), true);
        }
        this.mCurrentWebView.setWebViewPagerContainer(this);
        setNetworkAvailable(NetWorkUtils.getIsOnline());
        if (sInitFirstWebView) {
            Log.d(GlobalConstants.LOG_PER_TAG, ZeusPerformanceTiming.getWebViewInitTiming());
            sInitFirstWebView = true;
        }
        ZeusPerformanceTiming.recordWebkitInitStatistics(1);
    }

    private void initWebView(WebView webView) {
        webView.setWebChromeClient(new d());
        webView.setWebViewClient(new e(this, (byte) 0));
        webView.setPictureListener(new b(this, (byte) 0));
        webView.setDownloadListener(new c(webView));
        webView.setWebBackForwardListClient(new a(webView));
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
            if (com.baidu.browser.sailor.util.b.c() && BdZeusUtil.isWebkitLoaded()) {
                webView.getWebViewPager().removeView(webView);
            } else {
                getWebViewContainer().removeView(webView);
            }
        } catch (Exception e2) {
        }
    }

    private void setSearchBarTopMargin() {
        if (com.baidu.browser.sailor.util.b.c()) {
            setViewTopMargin(this.mSearchResultTitleBar, this.mStatusBarHeight);
            setViewTopMargin(this.mLandingPageTitleBar, this.mStatusBarHeight);
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

    private void setViewTopMargin(View view, int i) {
        if (view == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            view.setLayoutParams(marginLayoutParams);
            Log.d(LOG_TAG, "setViewTopMargin: view=" + view + ", top=" + marginLayoutParams.topMargin);
        }
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
            if (BdZeusUtil.isWebkitLoaded()) {
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
        if (!BdSailor.getInstance().isInit()) {
            throw new RuntimeException("Must Call BdSailor.init(Context aContext, String aWorkspace) first!");
        }
        if (!BdSailorPlatform.getInstance().isWebkitInit()) {
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

    public BdSailorWebBackForwardList copyBackForwardList() {
        WebBackForwardList copyBackForwardList;
        try {
            if (this.mCurrentWebView != null && (copyBackForwardList = this.mCurrentWebView.copyBackForwardList()) != null) {
                return new BdSailorWebBackForwardList(copyBackForwardList);
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

    public void disableMedia() {
        this.mCurrentWebView.disableMedia();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.mCurrentWebView.dispatchKeyEvent(keyEvent);
    }

    protected void doRealGoBack() {
        if (canGoBack()) {
            this.mCurrentWebView.goBack();
            if (this.mWebViewExt.getWebViewClientExt() != null) {
                this.mWebViewExt.getWebViewClientExt().onPageBackOrForwardExt(this, -1);
            }
        }
    }

    protected void doRealGoForward() {
        if (canGoForward()) {
            this.mCurrentWebView.goForward();
            if (this.mWebViewExt.getWebViewClientExt() != null) {
                this.mWebViewExt.getWebViewClientExt().onPageBackOrForwardExt(this, 1);
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

    public void enableMedia() {
        this.mCurrentWebView.enableMedia();
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

    public View getCurrentTitleBar() {
        return this.mCurrentTitleBar;
    }

    public WebView getCurrentWebView() {
        return this.mCurrentWebView;
    }

    public ISailorDownloadListener getDownloadListener() {
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

    public View getLandingPageTitleBar() {
        return this.mLandingPageTitleBar;
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

    public View getSearchResultTitleBar() {
        return this.mSearchResultTitleBar;
    }

    public BdSailorWebSettings getSettings() {
        return this.mWebSettings;
    }

    public ISailorWebSettingsExt getSettingsExt() {
        return this.mWebViewExt.getSettingsExt();
    }

    public View getStatusBar() {
        return this.mStatusBar;
    }

    public int getStatusBarHeight() {
        return this.mStatusBarHeight;
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

    public BdSailorWebChromeClient getWebChromeClient() {
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

    public BdSailorWebViewClient getWebViewClient() {
        return this.mWebViewClient;
    }

    protected FrameLayout getWebViewContainer() {
        return this.mWebViewLayer;
    }

    public ISailorWebViewExt getWebViewExt() {
        return this.mWebViewExt;
    }

    public void goBack() {
        if (canGoBack()) {
            Log.d("bfanim", "BdSailorWebView.Back");
            doRealGoBack();
        }
    }

    public void goBackOrForward(int i) {
        if (i == 0 || !canGoBackOrForward(i)) {
            return;
        }
        this.mCurrentWebView.goBackOrForward(i);
        if (this.mWebViewExt.getWebViewClientExt() != null) {
            this.mWebViewExt.getWebViewClientExt().onPageBackOrForwardExt(this, i);
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

    @SuppressLint({SchemeCollecter.CLASSIFY_ALL})
    public void hideCustomView() {
        if (this.mCustomView == null) {
            return;
        }
        try {
            getCurrentWebView().getHandler().post(new com.baidu.browser.sailor.a(this));
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
        if (str != null && str.startsWith(JAVASCTIPT_URL)) {
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
        if (com.baidu.browser.sailor.util.b.a(this)) {
            BdSailor.getInstance().setCurrentSailorWebView(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (BdSailor.getInstance().getCurSailorWebView() == this) {
            BdSailor.getInstance().setCurrentSailorWebView(null);
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
            this.mStopBackgroundkListener.onStopBackgroundWork();
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
        boolean z = true;
        switch (motionEvent.getAction()) {
            case 0:
                this.mIsFunctionLayerShowing = false;
                break;
        }
        if (!((this.mIsFunctionLayerShowing || this.mWebViewExt.isTextSelectingModeExt()) ? false : true) || !getSettings().isGestrueBackForwardEnabled()) {
            z = false;
        }
        if (z != getSettings().isGestrueBackForwardEnabledInternal()) {
            getSettings().setBackForwardGestureInternal(z);
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

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int i, Rect rect) {
        return this.mCurrentWebView.requestFocus(i, rect);
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

    public BdSailorWebBackForwardList restoreState(Bundle bundle) {
        WebBackForwardList restoreState;
        if (bundle == null || (restoreState = this.mCurrentWebView.restoreState(bundle)) == null) {
            return null;
        }
        return new BdSailorWebBackForwardList(restoreState);
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

    public BdSailorWebBackForwardList saveState(Bundle bundle) {
        WebBackForwardList saveState;
        if (bundle == null || (saveState = this.mCurrentWebView.saveState(bundle)) == null) {
            return null;
        }
        return new BdSailorWebBackForwardList(saveState);
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

    public void setCurrentTitleBar(boolean z) {
        if (this.mSearchResultTitleBar == null || this.mLandingPageTitleBar == null) {
            return;
        }
        this.mCurrentTitleBar = z ? this.mSearchResultTitleBar : this.mLandingPageTitleBar;
        this.mSearchResultTitleBar.setVisibility(z ? 0 : 8);
        this.mLandingPageTitleBar.setVisibility(z ? 8 : 0);
        this.mEmbeddedTitlebar = this.mCurrentTitleBar;
    }

    public void setDownloadListener(ISailorDownloadListener iSailorDownloadListener) {
        this.mDownloadListener = iSailorDownloadListener;
    }

    public void setDualTitleBars(View view, View view2, int i, int i2) {
        setDualTitleBars(view, view2, i, i2, true, true);
    }

    public void setDualTitleBars(View view, View view2, int i, int i2, boolean z, boolean z2) {
        this.mSearchResultTitleBar = view;
        this.mSearchResultTitleBar.setContentDescription("searchbar");
        this.mLandingPageTitleBar = view2;
        this.mLandingPageTitleBar.setContentDescription("landingbar");
        this.mCurrentTitleBar = i2 == 0 ? this.mSearchResultTitleBar : this.mLandingPageTitleBar;
        setNewTitlebar(this.mCurrentTitleBar, i, z, z2);
        setSearchBarTopMargin();
        bringStatusBarToFront();
        this.mCurrentWebView.addEmbeddedTitleBarFinished();
    }

    public void setEmbeddedTitleBar(View view) {
        setEmbeddedTitleBar(view, 0);
    }

    public void setEmbeddedTitleBar(View view, int i) {
        if (!com.baidu.browser.sailor.util.b.c()) {
            setNewTitlebar(view, i, true, true);
        } else if (view == null) {
            setNewTitlebar(view, i, true, true);
        } else {
            this.mSearchResultTitleBar = view;
            this.mCurrentTitleBar = view;
            this.mEmbeddedTitlebar = this.mCurrentTitleBar;
            this.mEmbeddedTitlebarHeightPix = com.baidu.browser.core.util.d.m(i);
        }
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
                if (!BdZeusUtil.isWebkitLoaded()) {
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
        this.mCanHideTitlebar = z;
        this.mCanShowTitlebar = z2;
        this.mLockEmbeddedTitlebar = false;
        this.mEmbeddedTitlebarHeightPix = com.baidu.browser.core.util.d.m(i);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        this.mEmbeddedTitlebar.setLayoutParams(layoutParams);
        if (BdZeusUtil.isWebkitLoaded()) {
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
            if (com.baidu.browser.sailor.util.b.c()) {
                if (this.mEmbeddedTitlebar == this.mLandingPageTitleBar) {
                    setCurrentTitleBar(false);
                } else if (this.mLandingPageTitleBar != null) {
                    if (this.mLandingPageTitleBar.getParent() != null) {
                        ((ViewGroup) this.mLandingPageTitleBar.getParent()).removeView(this.mLandingPageTitleBar);
                    }
                    this.mLandingPageTitleBar.setLayoutParams(layoutParams);
                    this.mLandingPageTitleBar.setVisibility(8);
                    addView(this.mLandingPageTitleBar);
                }
                if (this.mEmbeddedTitlebar == this.mSearchResultTitleBar) {
                    setCurrentTitleBar(true);
                } else if (this.mSearchResultTitleBar != null) {
                    if (this.mSearchResultTitleBar.getParent() != null) {
                        ((ViewGroup) this.mSearchResultTitleBar.getParent()).removeView(this.mSearchResultTitleBar);
                    }
                    this.mSearchResultTitleBar.setLayoutParams(layoutParams);
                    this.mSearchResultTitleBar.setVisibility(8);
                    addView(this.mSearchResultTitleBar);
                }
            }
            this.mCurrentWebView.addEmbeddedTitleBarFinished();
        }
    }

    public void setOuterTitlebarHeight(int i) {
        if (!BdZeusUtil.isWebkitLoaded() || com.baidu.browser.sailor.util.b.c()) {
            return;
        }
        this.mOuterTitlebarHeightPix = i;
        setWebViewLayerMarginInternal(this.mMarginLeft, this.mMarginTop + this.mOuterTitlebarHeightPix, this.mMarginRight, this.mMarginBottom);
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

    public void setStatusBar(View view, int i) {
        if (com.baidu.browser.sailor.util.b.c()) {
            if (view == null) {
                if (this.mStatusBar != null) {
                    removeView(this.mStatusBar);
                }
                this.mStatusBar = null;
                this.mStatusBarHeight = 0;
                setSearchBarTopMargin();
                this.mCurrentWebView.setStatusBar(null, 0);
                return;
            }
            this.mStatusBar = view;
            this.mStatusBarHeight = i;
            Log.i(LOG_TAG, "setStatusBar: mStatusBarHeight=" + this.mStatusBarHeight);
            if (this.mStatusBar.getParent() != null) {
                ((ViewGroup) this.mStatusBar.getParent()).removeView(this.mStatusBar);
            }
            addView(this.mStatusBar);
            setSearchBarTopMargin();
            bringStatusBarToFront();
            this.mCurrentWebView.setStatusBar(this.mStatusBar, this.mStatusBarHeight);
        }
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

    public void setWebChromeClient(BdSailorWebChromeClient bdSailorWebChromeClient) {
        this.mWebChromeClient = bdSailorWebChromeClient;
    }

    public void setWebChromeClientExt(BdSailorWebChromeClientExt bdSailorWebChromeClientExt) {
        if (this.mWebViewExt != null) {
            this.mWebViewExt.setWebChromeClientExt(bdSailorWebChromeClientExt);
        }
    }

    public void setWebViewClient(BdSailorWebViewClient bdSailorWebViewClient) {
        this.mWebViewClient = bdSailorWebViewClient;
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
                this.mFullscreenContainer = new f(activity);
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

    public void suspendScheduledTasks(String str) {
        if (isDestroyed()) {
            return;
        }
        this.mCurrentWebView.suspendScheduledTasks(str);
    }

    public void switchTitleBar(boolean z) {
        this.mCurrentWebView.switchTitleBar(z);
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
            if (com.baidu.browser.sailor.util.b.c()) {
                if (!z) {
                    setTopControlsHeight(this.mEmbeddedTitlebarHeightPix, true);
                    return;
                } else if (z2) {
                    return;
                } else {
                    setTopControlsHeight(this.mEmbeddedTitlebarHeightPix, false);
                    return;
                }
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
