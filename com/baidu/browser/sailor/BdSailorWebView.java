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
import android.os.Handler;
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
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.browser.core.INoProGuard;
import com.baidu.browser.sailor.BdSailorWebSettings;
import com.baidu.browser.sailor.platform.BdSailorPlatform;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
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
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class BdSailorWebView extends FrameLayout implements INoProGuard {
    public static final String JAVASCTIPT_URL = "javascript:";
    public static final String SHOW_IMAGE_PREFIX = "imagedisplay:";
    public boolean mCanHideTitlebar;
    public boolean mCanShowTitlebar;
    public View mCurrentTitleBar;
    public WebView mCurrentWebView;
    public View mCustomView;
    public WebChromeClient.CustomViewCallback mCustomViewCallback;
    public ISailorDownloadListener mDownloadListener;
    public View mEmbeddedTitlebar;
    public int mEmbeddedTitlebarHeightPix;
    public FrameLayout mFullscreenContainer;
    public FrameLayout mFunctionViewLayer;
    public boolean mIsFunctionLayerShowing;
    public boolean mIsPageLoading;
    public View mLandingPageTitleBar;
    public boolean mLockEmbeddedTitlebar;
    public int mMarginBottom;
    public int mMarginLeft;
    public int mMarginRight;
    public int mMarginTop;
    public int mOriginalOrientation;
    public int mOuterTitlebarHeightPix;
    public WebView.PictureListener mPictureListener;
    public View mSearchResultTitleBar;
    public int mSnapBgColor;
    public View mStatusBar;
    public int mStatusBarHeight;
    public VideoPlayerFactory mVideoFactory;
    public g mViewDelegate;
    public BdSailorWebChromeClient mWebChromeClient;
    public BdSailorWebSettings mWebSettings;
    public BdSailorWebViewClient mWebViewClient;
    public ISailorWebViewExt mWebViewExt;
    public FrameLayout mWebViewLayer;
    public FrameLayout.LayoutParams mWebViewLayerLp;
    public static final String LOG_TAG = BdSailorWebView.class.getSimpleName();
    public static final FrameLayout.LayoutParams COVER_SCREEN_PARAMS = new FrameLayout.LayoutParams(-1, -1);
    public static boolean sInitFirstWebView = true;

    /* loaded from: classes.dex */
    public class BdSailorWebViewExt implements ISailorWebViewExt {
        public ISailorWebSettingsExt mSettingsExt;
        public BdSailorWebChromeClientExt mWebChromeClientExt;
        public BdSailorWebViewClientExt mWebViewClientExt;

        public BdSailorWebViewExt() {
        }

        public /* synthetic */ BdSailorWebViewExt(BdSailorWebView bdSailorWebView, d.a.h.b.a aVar) {
            this();
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void addNoStatePrefetch(String str, String str2) {
            BdSailorWebView.this.mCurrentWebView.addNoStatePrefetch(str, str2);
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public boolean canGoToPreloadNextExt() {
            return BdSailorWebView.this.mCurrentWebView.canGoPrerender();
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void cancelCurrentNoStatePrefetch() {
            BdSailorWebView.this.mCurrentWebView.cancelCurrentNoStatePrefetch();
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void changeWapPreloadUrlStyleExt(int i2, String str) {
            BdSailorWebView.this.mCurrentWebView.changeWapPreloadUrlStyle(i2, str);
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
            BdSailorWebView.this.mCurrentWebView.getSecureProcessor().f();
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void execJavaScriptExt(String str, String... strArr) {
            if (strArr == null || strArr.length == 0) {
                BdSailorWebView.this.mCurrentWebView.loadUrl("javascript:(" + str + ")()");
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("javascript:" + str + "('");
            for (int i2 = 0; i2 < strArr.length; i2++) {
                stringBuffer.append(strArr[i2]);
                if (i2 != strArr.length - 1) {
                    stringBuffer.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
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
                return (String) d.a.h.a.k.b.a(WebView.class, this, "nativeGetSelection", null, null, "");
            } catch (Exception unused) {
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
                return (ZoomButtonsController) d.a.h.a.k.b.a(WebView.class, this, "getZoomControls", null, null, null);
            } catch (Exception unused) {
                return null;
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void hideMagnifierExt(int i2, int i3) {
            BdSailorWebView.this.mCurrentWebView.hideMagnifier(i2, i3);
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public boolean isDestroyedExt() {
            return BdSailorWebView.this.mCurrentWebView.isDestroyed();
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public boolean isDrawSelectionPointerExt() {
            try {
                return ((Boolean) d.a.h.a.k.b.a(WebView.class, this, "getDrawSelectionPointer", null, null, Boolean.FALSE)).booleanValue();
            } catch (Exception unused) {
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
            return d.a.h.b.e.b.e(BdSailorWebView.this);
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public boolean isMobileSiteExt() {
            return BdSailorWebView.this.mCurrentWebView.isMobileSite();
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public boolean isNeedImpactScriptExt() {
            return BdSailorWebView.this.mCurrentWebView.getSecureProcessor().b();
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public boolean isShiftPressedModeExt() {
            try {
                return ((Boolean) d.a.h.a.k.b.a(WebView.class, this, "getShiftIsPressed", null, null, Boolean.FALSE)).booleanValue();
            } catch (Exception unused) {
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
        public void mediaPlayerStatusChangedExt(int i2, float f2, float f3) {
            BdSailorWebView.this.mCurrentWebView.mediaPlayerStatusChanged(i2, f2, f3);
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void mediaPlayerTimeChangedExt(float f2, float f3) {
            BdSailorWebView.this.mCurrentWebView.mediaPlayerTimeChanged(f2, f3);
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void moveMagnifierExt(int i2, int i3) {
            BdSailorWebView.this.mCurrentWebView.moveMagnifier(i2, i3);
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public boolean notifyNativeExitFullScreenIfNeededExt(int i2) {
            return BdSailorWebView.this.mCurrentWebView.notifyNativeExitFullScreenIfNeeded(i2);
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void onPauseAll() {
            BdSailorWebView.this.mCurrentWebView.onPauseAll();
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void onResumeAll() {
            BdSailorWebView.this.mCurrentWebView.onResumeAll();
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void onSearchKeyword(String str, String str2) {
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void onShowCommentPanel(String str, String str2) {
            BdSailorWebChromeClientExt bdSailorWebChromeClientExt = this.mWebChromeClientExt;
            if (bdSailorWebChromeClientExt != null) {
                bdSailorWebChromeClientExt.onShowCommentPanel(BdSailorWebView.this, str, str2);
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void onShowValidateComponent(String str, String str2) {
            BdSailorWebChromeClientExt bdSailorWebChromeClientExt = this.mWebChromeClientExt;
            if (bdSailorWebChromeClientExt != null) {
                bdSailorWebChromeClientExt.onShowValidateComponent(BdSailorWebView.this, str, str2);
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
        public void resetLoadingAnimation() {
            BdSailorWebView.this.mCurrentWebView.resetLoadingAnimation();
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
        public boolean setBackgroundNightColorExt(int i2) {
            return false;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void setBeginScaleExt() {
            BdSailorWebView.this.mCurrentWebView.setBeginScale();
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public boolean setBigPluginTextNightColorExt(int i2) {
            return false;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public boolean setBorderNightColorExt(int i2) {
            return false;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public boolean setDefaultLinkTextNightColorExt(int i2) {
            return false;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void setDefaultViewSizeExt(int i2, int i3) {
            BdSailorWebView.this.mCurrentWebView.setDefaultViewSize(i2, i3);
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void setDrawSelectionPointerExt(boolean z) {
            try {
                d.a.h.a.k.b.a(WebView.class, this, "setDrawSelectionPointer", new Class[]{Boolean.TYPE}, new Object[]{Boolean.valueOf(z)}, Boolean.FALSE);
            } catch (Exception unused) {
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
            BdSailorWebView.this.mCurrentWebView.getSecureProcessor().a(z);
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public boolean setImageNightColorExt(int i2) {
            return false;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public boolean setLinkTextNightColorExt(int i2) {
            return false;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void setNeedImpactScriptExt(boolean z) {
            BdSailorWebView.this.mCurrentWebView.getSecureProcessor().b(z);
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public boolean setNightModeColorStyleExt(int i2) {
            return false;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public boolean setPreviewZoomScaleExt(float f2) {
            return BdSailorWebView.this.mCurrentWebView.setPreviewZoomScale(f2);
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void setShiftPressedModeExt(boolean z) {
            try {
                d.a.h.a.k.b.a(WebView.class, this, "setShiftIsPressed", new Class[]{Boolean.TYPE}, new Object[]{Boolean.valueOf(z)}, Boolean.FALSE);
            } catch (Exception unused) {
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void setSubjectScrollToOnloadExt(int i2) {
            BdSailorWebView.this.mCurrentWebView.setSubjectScrollToOnload(i2);
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
        public boolean setTextNightColorExt(int i2) {
            return false;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void setTextSelectingModeExt(boolean z) {
            BdSailorWebView.this.mCurrentWebView.setSelectingText(z);
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public boolean setVisitedLinkNightColorExt(int i2) {
            return BdSailorWebView.this.mCurrentWebView.setVisitedLinkNightColor(i2);
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
        public void showMagnifierExt(int i2, int i3, int i4, int i5, boolean z) {
            BdSailorWebView.this.mCurrentWebView.showMagnifier(i2, i3, i4, i5, z);
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

    /* loaded from: classes.dex */
    public class a extends WebBackForwardListClient {

        /* renamed from: a  reason: collision with root package name */
        public WebView f4426a;

        public a(WebView webView) {
            this.f4426a = webView;
        }

        @Override // com.baidu.webkit.sdk.WebBackForwardListClient
        public final void onIndexChanged(WebHistoryItem webHistoryItem, int i2) {
            super.onIndexChanged(webHistoryItem, i2);
        }

        @Override // com.baidu.webkit.sdk.WebBackForwardListClient
        public final void onNewHistoryItem(WebHistoryItem webHistoryItem) {
            if (BdSailorWebView.this.mWebViewExt.getWebViewClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onNewPage(BdSailorWebView.this);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements WebView.PictureListener {
        public b() {
        }

        public /* synthetic */ b(BdSailorWebView bdSailorWebView, byte b2) {
            this();
        }

        @Override // com.baidu.webkit.sdk.WebView.PictureListener
        public final void onNewPicture(WebView webView, Picture picture) {
            WebView.PictureListener pictureListener = BdSailorWebView.this.mPictureListener;
            if (pictureListener != null) {
                pictureListener.onNewPicture(webView, picture);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements DownloadListener {

        /* renamed from: a  reason: collision with root package name */
        public WebView f4429a;

        public c(WebView webView) {
            this.f4429a = webView;
        }

        @Override // android.webkit.DownloadListener
        public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            Log.d("// BdSailorMonitorEngine", "BdDownloadListenerBridge.onDownloadStart l=" + j + ", ---> s=" + str + ", --->s1=" + str2 + ", ---> s2=" + str3 + ", --- s3=" + str4);
            if (BdSailorWebView.this.mDownloadListener != null) {
                BdSailorWebView.this.mDownloadListener.onDownloadStart(str, str2, str3, str4, j);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d extends WebChromeClient {

        /* renamed from: a  reason: collision with root package name */
        public String[] f4431a = {"mail.163.com", "mail.126.com", "mail.yeah.net", "shouji.163.com"};

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
        public final void hideMagnifier(WebView webView, int i2, int i3) {
            if (BdSailorWebView.this.mWebViewExt.getWebChromeClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebChromeClientExt().hideMagnifierExt(BdSailorWebView.this, i2, i3);
            } else {
                super.hideMagnifier(webView, i2, i3);
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
        public final void moveMagnifier(WebView webView, int i2, int i3, int i4, int i5) {
            if (BdSailorWebView.this.mWebViewExt.getWebChromeClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebChromeClientExt().moveMagnifierExt(BdSailorWebView.this, i2, i3, i4, i5);
            } else {
                super.moveMagnifier(webView, i2, i3, i4, i5);
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
        public final void notifyClientStatus(WebView webView, int i2) {
            if (BdSailorWebView.this.mWebViewExt.getWebChromeClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebChromeClientExt().notifyClientStatusExt(BdSailorWebView.this, i2);
            } else {
                super.notifyClientStatus(webView, i2);
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
                    for (String str3 : this.f4431a) {
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
        public final void onOffsetsForFullscreenChanged(float f2, float f3, float f4) {
            BdSailorWebView bdSailorWebView = BdSailorWebView.this;
            bdSailorWebView.setTopControlsHeight(bdSailorWebView.mEmbeddedTitlebarHeightPix, f3 > 0.0f);
            if (BdSailorWebView.this.mWebChromeClient != null) {
                BdSailorWebView.this.mWebChromeClient.onOffsetsForFullscreenChanged(BdSailorWebView.this, f2, f3, f4);
            } else {
                super.onOffsetsForFullscreenChanged(f2, f3, f4);
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
        public final void onPrerenderChanged(int i2, WebView.PrerenderStatus prerenderStatus) {
            super.onPrerenderChanged(i2, prerenderStatus);
            if (BdSailorWebView.this.mWebViewExt.getWebChromeClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebChromeClientExt().onPrerenderChanged(i2, prerenderStatus);
            }
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void onProgressChanged(WebView webView, int i2) {
            long currentTimeMillis = System.currentTimeMillis();
            super.onProgressChanged(webView, i2);
            if (BdSailorWebView.this.mWebChromeClient != null) {
                BdSailorWebView.this.mWebChromeClient.onProgressChanged(BdSailorWebView.this, i2);
            }
            if (webView == BdSailorWebView.this.mCurrentWebView && i2 == 100) {
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
        public final void onShowCustomView(View view, int i2, WebChromeClient.CustomViewCallback customViewCallback) {
            if (BdSailorWebView.this.mWebChromeClient != null ? BdSailorWebView.this.mWebChromeClient.onShowCustomView(BdSailorWebView.this, view, i2, customViewCallback) : false) {
                return;
            }
            BdSailorWebView bdSailorWebView = BdSailorWebView.this;
            bdSailorWebView.showCustomView(bdSailorWebView.getContext(), view, customViewCallback);
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
            if (BdSailorWebView.this.mWebChromeClient != null ? BdSailorWebView.this.mWebChromeClient.onShowCustomView(BdSailorWebView.this, view, customViewCallback) : false) {
                return;
            }
            BdSailorWebView bdSailorWebView = BdSailorWebView.this;
            bdSailorWebView.showCustomView(bdSailorWebView.getContext(), view, customViewCallback);
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
        public final void performLongClick(WebView webView, int i2, String str, String str2, int i3, int i4) {
            super.performLongClick(webView, i2, str, str2, i3, i4);
            if (BdZeusUtil.isWebkitLoaded() || Build.VERSION.SDK_INT >= 19) {
                if (BdSailorWebView.this.mWebViewExt != null && BdSailorWebView.this.mWebViewExt.getWebChromeClientExt() != null) {
                    BdSailorWebView.this.mIsFunctionLayerShowing = true;
                    BdSailorWebView.this.mWebViewExt.getWebChromeClientExt().performLongClickExt(BdSailorWebView.this, i2, str, str2, i3, i4);
                }
                if (i2 == 5 || i2 == 8) {
                    BdSailorWebView.this.getWebViewExt().updatePictureUrlListExt();
                }
            }
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void performLongClick(WebView webView, WebView.HitTestResult hitTestResult, int i2, int i3) {
            super.performLongClick(webView, hitTestResult, i2, i3);
            if (BdZeusUtil.isWebkitLoaded() || Build.VERSION.SDK_INT >= 19) {
                if (BdSailorWebView.this.mWebViewExt != null && BdSailorWebView.this.mWebViewExt.getWebChromeClientExt() != null) {
                    BdSailorWebView.this.mIsFunctionLayerShowing = true;
                    BdSailorWebView.this.mWebViewExt.getWebChromeClientExt().performLongClickExt(BdSailorWebView.this, hitTestResult, i2, i3);
                }
                if (hitTestResult.getType() == 5 || hitTestResult.getType() == 8) {
                    BdSailorWebView.this.getWebViewExt().updatePictureUrlListExt();
                }
            }
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void showMagnifier(WebView webView, int i2, int i3, int i4, int i5) {
            BdSailorWebView.this.mIsFunctionLayerShowing = true;
            if (BdSailorWebView.this.mWebViewExt.getWebChromeClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebChromeClientExt().showMagnifierExt(BdSailorWebView.this, i2, i3, i4, i5);
            } else {
                super.showMagnifier(webView, i2, i3, i4, i5);
            }
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void showSelectionActionDialog(WebView webView, int i2, int i3, int i4, int i5, String str) {
            BdSailorWebView.this.mIsFunctionLayerShowing = true;
            if (BdSailorWebView.this.mWebViewExt.getWebChromeClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebChromeClientExt().showSelectionActionDialogExt(BdSailorWebView.this, i2, i3, i4, i5, str);
            } else {
                super.showSelectionActionDialog(webView, i2, i3, i4, i5, str);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e extends WebViewClient {

        /* renamed from: a  reason: collision with root package name */
        public String[] f4433a;

        public e() {
            this.f4433a = new String[]{"wtai://", "tel:", UrlSchemaHelper.SCHEMA_TYPE_SMS, "mailto", "smsto:"};
        }

        public /* synthetic */ e(BdSailorWebView bdSailorWebView, byte b2) {
            this();
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void AntiHijackSign(WebView webView, String str) {
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final boolean canHandleImage(WebView webView, String str, String str2, String str3) {
            boolean z = false;
            if (BdSailorWebView.this.mWebViewExt.getWebViewClientExt() != null) {
                BdSailorWebViewClientExt webViewClientExt = BdSailorWebView.this.mWebViewExt.getWebViewClientExt();
                BdSailorWebView bdSailorWebView = BdSailorWebView.this;
                z = webViewClientExt.shouldHandleImageExt(bdSailorWebView, str, str2, str3, bdSailorWebView.mCurrentWebView == webView);
                Log.i("WebViewClient", "canHandleImage ret=" + z);
            }
            if (z) {
                BdSailorWebView.this.stopLoading();
                return true;
            }
            return super.canHandleImage(webView, str, str2, str3);
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final int computeHookH5NavigationStep(int i2) {
            Log.i("WebViewClient", "BeeFrame computeHookH5NavigationStep: offset=" + i2);
            return BdSailorWebView.this.mWebViewExt.getWebViewClientExt() != null ? BdSailorWebView.this.mWebViewExt.getWebViewClientExt().computeHookH5NavigationStep(i2) : super.computeHookH5NavigationStep(i2);
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
            Log.i("pwa", "onCheckHasManifestAndServiceWorker has=" + z + ",url=" + str);
            if (BdSailorWebView.this.mWebViewExt.getWebViewClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onCheckHasManifestAndServiceWorker(BdSailorWebView.this, str, str2, z);
            } else {
                super.onCheckHasManifestAndServiceWorker(webView, str, str2, z);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onDidAsyncWiseSearchStatusChanged(WebView webView, String str, int i2, long j) {
            super.onDidAsyncWiseSearchStatusChanged(webView, str, i2, j);
            if (BdSailorWebView.this.mWebViewExt == null || BdSailorWebView.this.mWebViewExt.getWebViewClientExt() == null) {
                return;
            }
            Log.i("WebViewClient", "onDidAsyncWiseSearchStatusChangedExt status : " + i2 + ", aUrl : " + str);
            BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onDidAsyncWiseSearchStatusChangedExt(BdSailorWebView.this, str, i2, j);
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
            Log.i("WebViewClient", "FCPCallback onFirstContentfulPaintExt, aUrl : " + str);
            BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onFirstContentfulPaintExt(BdSailorWebView.this, str);
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onFirstImagePaint(WebView webView, String str) {
            if (BdSailorWebView.this.mWebViewExt == null || BdSailorWebView.this.mWebViewExt.getWebViewClientExt() == null) {
                return;
            }
            Log.i("WebViewClient", "FIPCallback onFirstImagePaintExt, aUrl : " + str);
            BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onFirstImagePaintExt(BdSailorWebView.this, str);
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
        public final void onFirstScreenPaintFinished(WebView webView, String str, int i2, int i3, int i4, int i5, int i6) {
            System.currentTimeMillis();
            BdSailorWebView.this.perfLog(webView, "onFirstScreenPaintFinished");
            super.onFirstScreenPaintFinished(webView, str, i2, i3, i4, i5, i6);
            if (BdSailorWebView.this.mWebViewExt == null || BdSailorWebView.this.mWebViewExt.getWebViewClientExt() == null) {
                return;
            }
            BdSailorWebView.this.perfLog(webView, "onFirstScreenPaintFinished 22");
            BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onFirstScreenPaintFinishedExt(BdSailorWebView.this, str);
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onFirstTextPaint(WebView webView, String str) {
            if (BdSailorWebView.this.mWebViewExt == null || BdSailorWebView.this.mWebViewExt.getWebViewClientExt() == null) {
                return;
            }
            Log.i("WebViewClient", "FTPCallback onFirstTextPaintExt, aUrl : " + str);
            BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onFirstTextPaintExt(BdSailorWebView.this, str);
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
        public final void onFullScreenMode(WebView webView, boolean z, int i2, int i3) {
            if (BdSailorWebView.this.mWebViewExt.getWebViewClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onFullScreenModeExt(BdSailorWebView.this, z, i2, i3);
            } else {
                super.onFullScreenMode(webView, z, i2, i3);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onGestureFlingEnded(WebView webView, int i2, int i3) {
            BdSailorWebViewClientExt webViewClientExt;
            if (webView != BdSailorWebView.this.mCurrentWebView || (webViewClientExt = BdSailorWebView.this.getWebViewExt().getWebViewClientExt()) == null) {
                return;
            }
            webViewClientExt.onGestureFlingEnded(BdSailorWebView.this, i2, i3);
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onGestureScrollEnded(WebView webView, int i2, int i3) {
            BdSailorWebViewClientExt webViewClientExt;
            if (webView != BdSailorWebView.this.mCurrentWebView || (webViewClientExt = BdSailorWebView.this.getWebViewExt().getWebViewClientExt()) == null) {
                return;
            }
            webViewClientExt.onGestureScrollEnded(BdSailorWebView.this, i2, i3);
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onGestureScrollStarted(WebView webView, int i2, int i3) {
            BdSailorWebViewClientExt webViewClientExt;
            if (webView != BdSailorWebView.this.mCurrentWebView || (webViewClientExt = BdSailorWebView.this.getWebViewExt().getWebViewClientExt()) == null) {
                return;
            }
            webViewClientExt.onGestureScrollStarted(BdSailorWebView.this, i2, i3);
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final String onGetErrorContent(WebView webView, int i2, String str, String str2) {
            String onGetErrorHtmlExt = (!(webView instanceof WebView) || BdSailorWebView.this.isDestroyed() || BdSailorWebView.this.mWebViewExt == null || BdSailorWebView.this.mWebViewExt.getWebViewClientExt() == null) ? null : BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onGetErrorHtmlExt(BdSailorWebView.this, i2, str, str2);
            return onGetErrorHtmlExt != null ? onGetErrorHtmlExt : BdSailorPlatform.getDefaultErrorPageHtml(webView.getContext());
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onGoBackOrForward(WebView webView, int i2) {
            if (webView == BdSailorWebView.this.mCurrentWebView) {
                BdSailorWebView.this.goBackOrForward(i2);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onGoBackOrForwardAnimationFinish(WebView webView, int i2) {
            BdSailorWebViewClientExt webViewClientExt;
            if (webView != BdSailorWebView.this.mCurrentWebView || (webViewClientExt = BdSailorWebView.this.getWebViewExt().getWebViewClientExt()) == null) {
                return;
            }
            webViewClientExt.onGoBackOrForwardAnimationFinish(BdSailorWebView.this, i2);
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onGoBackOrForwardAnimationStart(WebView webView, int i2) {
            BdSailorWebViewClientExt webViewClientExt;
            if (webView != BdSailorWebView.this.mCurrentWebView || (webViewClientExt = BdSailorWebView.this.getWebViewExt().getWebViewClientExt()) == null) {
                return;
            }
            webViewClientExt.onGoBackOrForwardAnimationStart(BdSailorWebView.this, i2);
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onGotNotResponse(WebView webView) {
            if (BdSailorWebView.this.mWebViewExt.getWebViewClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onGotNotResponse(BdSailorWebView.this);
            } else {
                super.onGotNotResponse(webView);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onHandleBackForwardBeyondHistory(int i2) {
            Log.i("WebViewClient", "BeeFrame onHandleBackForwardBeyondHistory: offset=" + i2);
            if (BdSailorWebView.this.mWebViewExt.getWebViewClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onHandleBackForwardBeyondHistory(i2);
            } else {
                super.onHandleBackForwardBeyondHistory(i2);
            }
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
        public final void onMagicFilterHideElement(WebView webView, String str, int i2, int i3, int i4, int i5, int i6) {
            super.onMagicFilterHideElement(webView, str, i2, i3, i4, i5, i6);
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onMainResourceHttpcodeDid(WebView webView, int i2, String str) {
            super.onMainResourceHttpcodeDid(webView, i2, str);
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
        public final void onNewHistoryItem(WebView webView, String str, int i2) {
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
        public final void onReceivedError(WebView webView, int i2, String str, String str2) {
            super.onReceivedError(webView, i2, str, str2);
            if (BdSailorWebView.this.mWebViewClient != null) {
                BdSailorWebView.this.mWebViewClient.onReceivedError(BdSailorWebView.this, i2, str, str2);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            long currentTimeMillis = System.currentTimeMillis();
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            if (BdSailorWebView.this.mWebViewClient != null) {
                if (webResourceRequest.isForMainFrame() && (webResourceRequest.getUrl().toString().startsWith("http://") || webResourceRequest.getUrl().toString().startsWith("https://"))) {
                    BdSailorWebView.this.mWebViewClient.onReceivedError(BdSailorWebView.this, webResourceError.getErrorCode(), webResourceError.getDescription().toString(), webResourceRequest.getUrl().toString());
                }
                BdSailorWebView.this.mWebViewClient.onReceivedError(BdSailorWebView.this, webResourceRequest, webResourceError);
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
        public final void onResourceLoaded(WebView webView, String str, long j, String str2, String str3, int i2) {
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
        public final void onScaleChanged(WebView webView, float f2, float f3) {
            if (BdSailorWebView.this.mWebViewClient != null) {
                BdSailorWebView.this.mWebViewClient.onScaleChanged(BdSailorWebView.this, f2, f3);
            } else {
                super.onScaleChanged(webView, f2, f3);
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
        public final void onSubjectsCollected(WebView webView, boolean z, int i2) {
            if (BdSailorWebView.this.mWebViewExt.getWebViewClientExt() != null) {
                BdSailorWebView.this.mWebViewExt.getWebViewClientExt().onSubjectsCollectedExt(BdSailorWebView.this, z, i2);
            } else {
                super.onSubjectsCollected(webView, z, i2);
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
        public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            BdSailorWebView.this.perfLog(webView, "shouldOverrideUrlLoading");
            long currentTimeMillis = System.currentTimeMillis();
            String uri = webResourceRequest.getUrl().toString();
            webView.getSecureProcessor().a(uri);
            int i2 = 0;
            boolean shouldOverrideUrlLoading = BdSailorWebView.this.mWebViewClient != null ? BdSailorWebView.this.mWebViewClient.shouldOverrideUrlLoading(BdSailorWebView.this, webResourceRequest) : false;
            if (!shouldOverrideUrlLoading) {
                shouldOverrideUrlLoading = super.shouldOverrideUrlLoading(webView, webResourceRequest);
            }
            if (!shouldOverrideUrlLoading) {
                shouldOverrideUrlLoading = shouldOverrideUrlLoading(webView, uri);
            }
            if (shouldOverrideUrlLoading && !TextUtils.isEmpty(uri)) {
                String[] strArr = this.f4433a;
                int length = strArr.length;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (uri.startsWith(strArr[i2])) {
                        Log.d("// BdSailorMonitorEngine", "BdWebViewClientProxy.shouldoverridetel handled by external-->onTelRequest ,url=" + uri);
                        break;
                    } else {
                        i2++;
                    }
                }
            }
            SessionMonitorEngine.getInstance().onPageKeySectionTimeCost(webView, uri, MonitorConstant.KeySectionType.SHOULD_OVERRIDE_URL_LOADING.ordinal(), System.currentTimeMillis() - currentTimeMillis);
            return shouldOverrideUrlLoading;
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            boolean shouldOverrideUrlLoading = BdSailorWebView.this.mWebViewClient != null ? BdSailorWebView.this.mWebViewClient.shouldOverrideUrlLoading(BdSailorWebView.this, str) : false;
            return !shouldOverrideUrlLoading ? super.shouldOverrideUrlLoading(webView, str) : shouldOverrideUrlLoading;
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void shouldPageRollBack(WebView webView, String str) {
        }
    }

    /* loaded from: classes.dex */
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

    /* loaded from: classes.dex */
    public class g extends WebViewDelegate {
        public g(WebView webView) {
            super(webView);
        }

        @Override // com.baidu.webkit.sdk.WebViewDelegate
        public final boolean canGoBack() {
            return BdSailorWebView.this.canGoBack();
        }

        @Override // com.baidu.webkit.sdk.WebViewDelegate
        public final boolean canGoBackOrForward(int i2) {
            return BdSailorWebView.this.canGoBackOrForward(i2);
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
        public final void goBackOrForward(int i2) {
            BdSailorWebView.this.goBackOrForward(i2);
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
        public final void onOverScrolled(int i2, int i3, boolean z, boolean z2) {
            BdSailorWebView.this.onOverScrolled(i2, i3, z, z2);
        }

        @Override // com.baidu.webkit.sdk.WebViewDelegate
        public final void onScrollChanged(int i2, int i3, int i4, int i5) {
            BdSailorWebView.this.onScrollChanged(i2, i3, i4, i5);
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

    public BdSailorWebView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mCurrentWebView = new WebView(context, attributeSet, i2);
        init();
    }

    private void addWebView(WebView webView) {
        addWebView(webView, -1);
    }

    private void addWebView(WebView webView, int i2) {
        if (webView.getParent() != null) {
            return;
        }
        g gVar = new g(webView);
        this.mViewDelegate = gVar;
        webView.setViewDelegate(gVar);
        if (d.a.h.b.e.b.c() && BdZeusUtil.isWebkitLoaded()) {
            return;
        }
        getWebViewContainer().addView(webView, i2, new FrameLayout.LayoutParams(-1, -1));
    }

    private void bringStatusBarToFront() {
        View view;
        if (!d.a.h.b.e.b.c() || (view = this.mStatusBar) == null || indexOfChild(view) < 0) {
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
        if (!d.a.h.b.e.b.c() || !BdZeusUtil.isWebkitLoaded()) {
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
            Log.i(GlobalConstants.LOG_PER_TAG, " timing = \n" + ZeusPerformanceTiming.getWebViewInitTiming());
            sInitFirstWebView = false;
        }
        ZeusPerformanceTiming.recordWebkitInitStatistics(1);
    }

    private void initWebView(WebView webView) {
        webView.setWebChromeClient(new d());
        webView.setWebViewClient(new e(this, (byte) 0));
        webView.setPictureListener(new b(this, (byte) 0));
        webView.setDownloadListener(new c(webView));
        webView.setWebBackForwardListClient(new a(webView));
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
            if (d.a.h.b.e.b.c() && BdZeusUtil.isWebkitLoaded()) {
                webView.getWebViewPager().removeView(webView);
            } else {
                getWebViewContainer().removeView(webView);
            }
        } catch (Exception unused) {
        }
    }

    private void setSearchBarTopMargin() {
        if (d.a.h.b.e.b.c()) {
            setViewTopMargin(this.mSearchResultTitleBar, this.mStatusBarHeight);
            setViewTopMargin(this.mLandingPageTitleBar, this.mStatusBarHeight);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTopControlsHeight(int i2, boolean z) {
        this.mCurrentWebView.setTopControlsHeight(i2, z);
    }

    private void setViewSize(View view, int i2, int i3) {
        if (view == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(i2, i3);
        } else {
            layoutParams.width = i2;
            layoutParams.height = i3;
        }
        view.setLayoutParams(layoutParams);
    }

    private void setViewTopMargin(View view, int i2) {
        if (view == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i2;
            view.setLayoutParams(marginLayoutParams);
            String str = LOG_TAG;
            Log.d(str, "setViewTopMargin: view=" + view + ", top=" + marginLayoutParams.topMargin);
        }
    }

    private void setWebViewLayerMarginInternal(int i2, int i3, int i4, int i5) {
        this.mWebViewLayerLp.setMargins(i2, i3, i4, i5);
        this.mWebViewLayer.setLayoutParams(this.mWebViewLayerLp);
        onWebViewLayerMarginChanged(i2, i3, i4, i5);
        this.mWebViewLayer.invalidate();
        this.mCurrentWebView.setWebViewMargin(i2, i3, i4, i5);
    }

    public void addJavascriptInterface(Object obj, String str) {
        WebView webView = this.mCurrentWebView;
        if (webView != null) {
            webView.addJavascriptInterface(obj, str);
        }
    }

    public void addJavascriptInterfaceExt(IJsAbility iJsAbility, String str) {
        WebView webView = this.mCurrentWebView;
        if (webView != null) {
            webView.addJavascriptInterfaceExt(iJsAbility, str);
        }
    }

    public boolean canGoBack() {
        return this.mCurrentWebView.canGoBack();
    }

    public boolean canGoBackOrForward(int i2) {
        return this.mCurrentWebView.canGoBackOrForward(i2);
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
        try {
            WebView currentWebView = getCurrentWebView();
            if (currentWebView != null && currentWebView.getMeasuredWidth() > 0 && currentWebView.getMeasuredHeight() > 0) {
                if (BdZeusUtil.isWebkitLoaded()) {
                    captureBitmap = getCurrentWebView().captureBitmap();
                } else {
                    captureBitmap = Bitmap.createBitmap(currentWebView.getMeasuredWidth(), currentWebView.getMeasuredHeight(), Bitmap.Config.RGB_565);
                    Canvas canvas = new Canvas(captureBitmap);
                    int save = canvas.save();
                    this.mWebViewLayer.draw(canvas);
                    canvas.restoreToCount(save);
                }
                if (captureBitmap != null && captureBitmap.getWidth() > 0 && captureBitmap.getHeight() > 0) {
                    return getTitlebarHeight() != 0 && isTitlebarShowing() ? Bitmap.createBitmap(captureBitmap, 0, getTitlebarHeight(), captureBitmap.getWidth(), captureBitmap.getHeight() - getTitlebarHeight()) : captureBitmap;
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public Bitmap captureBitmap(int i2, int i3) {
        return this.mCurrentWebView.captureBitmap(i2, i3);
    }

    public Picture capturePicture() {
        return this.mCurrentWebView.capturePicture();
    }

    public void checkInit() {
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
    public int computeVerticalScrollRange() {
        return this.mCurrentWebView.computeVerticalScrollRange();
    }

    public BdSailorWebBackForwardList copyBackForwardList() {
        WebBackForwardList copyBackForwardList;
        try {
            if (this.mCurrentWebView == null || (copyBackForwardList = this.mCurrentWebView.copyBackForwardList()) == null) {
                return null;
            }
            return new BdSailorWebBackForwardList(copyBackForwardList);
        } catch (Throwable th) {
            Log.printStackTrace(th);
            return null;
        }
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

    public void doRealGoBack() {
        if (canGoBack()) {
            this.mCurrentWebView.goBack();
            if (this.mWebViewExt.getWebViewClientExt() != null) {
                this.mWebViewExt.getWebViewClientExt().onPageBackOrForwardExt(this, -1);
            }
        }
    }

    public void doRealGoForward() {
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
        WebView webView = this.mCurrentWebView;
        if (webView != null) {
            webView.emulateShiftHeld();
        }
    }

    public void enableFeature(String str) {
    }

    public void enableMedia() {
        this.mCurrentWebView.enableMedia();
    }

    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        WebView webView = this.mCurrentWebView;
        if (webView != null) {
            webView.evaluateJavascript(str, valueCallback);
        }
    }

    public int findAll(String str) {
        return this.mCurrentWebView.findAll(str);
    }

    public void findAllAsync(String str) {
        this.mCurrentWebView.findAllAsync(str);
    }

    @Override // android.view.ViewGroup, android.view.View
    public View findFocus() {
        WebView webView = this.mCurrentWebView;
        return webView != null ? webView.findFocus() : super.findFocus();
    }

    public void findNext(boolean z) {
        this.mCurrentWebView.findNext(z);
    }

    public void flingScroll(int i2, int i3) {
        this.mCurrentWebView.flingScroll(i2, i3);
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

    public ViewGroup getFunctionLayer() {
        if (this.mFunctionViewLayer == null) {
            FrameLayout frameLayout = new FrameLayout(getContext());
            this.mFunctionViewLayer = frameLayout;
            addView(frameLayout);
        }
        return this.mFunctionViewLayer;
    }

    @Override // android.view.View
    public Handler getHandler() {
        WebView webView = this.mCurrentWebView;
        return webView != null ? webView.getHandler() : super.getHandler();
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

    public boolean getRendererPriorityWaivedWhenNotVisible() {
        WebView webView = this.mCurrentWebView;
        if (webView != null) {
            return webView.getRendererPriorityWaivedWhenNotVisible();
        }
        return false;
    }

    public int getRendererRequestedPriority() {
        WebView webView = this.mCurrentWebView;
        if (webView != null) {
            return webView.getRendererRequestedPriority();
        }
        return 0;
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
        WebView webView = this.mCurrentWebView;
        if (webView != null) {
            return webView.getUrl();
        }
        return null;
    }

    public void getWebAppShortcutData(WebAppShortcutDataListener webAppShortcutDataListener) {
        Log.i("pwa", "bdsailorwebvew.getWebAppShortcutData");
        this.mCurrentWebView.getWebAppShortcutData(webAppShortcutDataListener);
    }

    public void getWebAppShortcutData(WebAppShortcutDataListener webAppShortcutDataListener, boolean z) {
        Log.i("pwa", "bdsailorwebvew.getWebAppShortcutData");
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

    public FrameLayout getWebViewContainer() {
        return this.mWebViewLayer;
    }

    public ISailorWebViewExt getWebViewExt() {
        return this.mWebViewExt;
    }

    public Looper getWebViewLooper() {
        WebView webView = this.mCurrentWebView;
        return webView != null ? webView.getWebViewLooper() : Looper.myLooper();
    }

    public void goBack() {
        if (canGoBack()) {
            Log.d("bfanim", "BdSailorWebView.Back");
            doRealGoBack();
        }
    }

    public void goBackOrForward(int i2) {
        if (i2 == 0 || !canGoBackOrForward(i2)) {
            return;
        }
        this.mCurrentWebView.goBackOrForward(i2);
        if (this.mWebViewExt.getWebViewClientExt() != null) {
            this.mWebViewExt.getWebViewClientExt().onPageBackOrForwardExt(this, i2);
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
            getCurrentWebView().getHandler().post(new d.a.h.b.a(this));
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

    public boolean isTitlebarCanHide() {
        return this.mCanHideTitlebar;
    }

    public boolean isTitlebarCanShow() {
        return this.mCanShowTitlebar;
    }

    public boolean isTitlebarLock() {
        return this.mLockEmbeddedTitlebar;
    }

    public boolean isTitlebarShowing() {
        View view = this.mEmbeddedTitlebar;
        return view != null && view.getTranslationY() == 0.0f;
    }

    public void loadData(String str, String str2, String str3) {
        this.mCurrentWebView.loadData(str, str2, str3);
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        this.mCurrentWebView.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    public void loadImageInPage(String str) {
        WebView webView = this.mCurrentWebView;
        webView.loadUrl(SHOW_IMAGE_PREFIX + str);
    }

    public void loadUrl(String str) {
        if (str == null || !str.startsWith("javascript:")) {
            WebView webView = this.mCurrentWebView;
            perfLog(webView, "sailor-loadUrl", "url = " + str);
            perfLog("load", str);
        }
        this.mCurrentWebView.loadUrl(str);
    }

    public void loadUrl(String str, Map<String, String> map) {
        if (str.startsWith("javascript:")) {
            this.mCurrentWebView.loadUrl(str);
            return;
        }
        WebView webView = this.mCurrentWebView;
        perfLog(webView, "sailor-loadUrl", "url = " + str);
        perfLog("load", str);
        this.mCurrentWebView.loadUrl(str, map);
    }

    public void lockEmbeddedTitlebar(boolean z) {
        this.mLockEmbeddedTitlebar = z;
    }

    public void notifyPageActive(String str, WebView webView) {
        notifyPageActive(str, webView, false);
    }

    public void notifyPageActive(String str, WebView webView, boolean z) {
        Log.i("huqin-multiwebview", "BdSailorWebView notifyPageActive, webView = " + webView + ", url = " + str + ", isOpen = " + z);
        SessionMonitorEngine.getInstance().notifyPageActive(str, webView, z);
        this.mCurrentWebView.onPageSwapFromWebview(webView, str, true);
    }

    public void notifyPageLeave(String str, WebView webView) {
        Log.i("huqin-multiwebview", "BdSailorWebView notifyPageLeave, webView = " + webView + ", url = " + str);
        SessionMonitorEngine.getInstance().notifyPageLeave(str, webView);
        this.mCurrentWebView.onPageSwapFromWebview(webView, str, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (d.a.h.b.e.b.e(this)) {
            BdSailor.getInstance().setCurrentSailorWebView(this);
        }
    }

    @Override // android.view.View
    public boolean onCheckIsTextEditor() {
        WebView webView = this.mCurrentWebView;
        if (webView != null) {
            return webView.onCheckIsTextEditor();
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (BdSailor.getInstance().getCurSailorWebView() == this) {
            BdSailor.getInstance().setCurrentSailorWebView(null);
        }
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (hasCustomView()) {
            hideCustomView();
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // android.view.View
    public void onOverScrolled(int i2, int i3, boolean z, boolean z2) {
        this.mCurrentWebView.onOverScrolledSuper(i2, i3, z, z2);
    }

    public void onPause() {
        this.mCurrentWebView.onPause();
    }

    public void onReinputErrorUrl() {
    }

    public void onResume() {
        this.mCurrentWebView.onResume();
    }

    @Override // android.view.View
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        this.mCurrentWebView.onScrollChangedSuper(i2, i3, i4, i5);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (motionEvent.getAction() == 0) {
            this.mIsFunctionLayerShowing = false;
        }
        if (((this.mIsFunctionLayerShowing || this.mWebViewExt.isTextSelectingModeExt()) ? false : true) && getSettings().isGestrueBackForwardEnabled()) {
            z = true;
        }
        if (z != getSettings().isGestrueBackForwardEnabledInternal()) {
            getSettings().setBackForwardGestureInternal(z);
        }
        return this.mCurrentWebView.onTouchEventSuper(motionEvent);
    }

    public void onWebViewLayerMarginChanged(int i2, int i3, int i4, int i5) {
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
        WebView webView = this.mCurrentWebView;
        if (webView != null) {
            webView.removeJavascriptInterface(str);
        }
    }

    public void removeJavascriptInterfaceExt(String str) {
        WebView webView = this.mCurrentWebView;
        if (webView != null) {
            webView.removeJavascriptInterfaceExt(str);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return this.mCurrentWebView.requestChildRectangleOnScreen(view, rect, z);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int i2, Rect rect) {
        return this.mCurrentWebView.requestFocus(i2, rect);
    }

    public void requestFocusNodeHref(Message message) {
        WebView webView = this.mCurrentWebView;
        if (webView != null) {
            webView.requestFocusNodeHref(message);
        } else {
            Log.e("current webview is null.");
        }
    }

    public void requestImageRef(Message message) {
        this.mCurrentWebView.requestImageRef(message);
    }

    public void resetWebViewLayerMargin() {
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

    public void runWithThreadProtect(Runnable runnable) {
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
    public void setBackgroundColor(int i2) {
        this.mSnapBgColor = i2;
        WebView webView = this.mCurrentWebView;
        if (webView != null) {
            webView.setBackgroundColor(i2);
        } else {
            super.setBackgroundColor(i2);
        }
    }

    public void setCertificate(SslCertificate sslCertificate) {
        this.mCurrentWebView.setCertificate(sslCertificate);
    }

    public void setCurrentTitleBar(boolean z) {
        View view;
        View view2 = this.mSearchResultTitleBar;
        if (view2 == null || (view = this.mLandingPageTitleBar) == null) {
            return;
        }
        if (!z) {
            view2 = view;
        }
        this.mCurrentTitleBar = view2;
        this.mSearchResultTitleBar.setVisibility(z ? 0 : 8);
        this.mLandingPageTitleBar.setVisibility(z ? 8 : 0);
        this.mEmbeddedTitlebar = this.mCurrentTitleBar;
    }

    public void setDownloadListener(ISailorDownloadListener iSailorDownloadListener) {
        this.mDownloadListener = iSailorDownloadListener;
    }

    public void setDualTitleBars(View view, View view2, int i2, int i3) {
        setDualTitleBars(view, view2, i2, i3, true, true);
    }

    public void setDualTitleBars(View view, View view2, int i2, int i3, boolean z, boolean z2) {
        this.mSearchResultTitleBar = view;
        view.setContentDescription("searchbar");
        this.mLandingPageTitleBar = view2;
        view2.setContentDescription("landingbar");
        View view3 = i3 == 0 ? this.mSearchResultTitleBar : this.mLandingPageTitleBar;
        this.mCurrentTitleBar = view3;
        setNewTitlebar(view3, i2, z, z2);
        setSearchBarTopMargin();
        bringStatusBarToFront();
        this.mCurrentWebView.addEmbeddedTitleBarFinished();
    }

    public void setEmbeddedTitleBar(View view) {
        setEmbeddedTitleBar(view, 0);
    }

    public void setEmbeddedTitleBar(View view, int i2) {
        if (!d.a.h.b.e.b.c()) {
            setNewTitlebar(view, i2, true, true);
        } else if (view == null) {
            setNewTitlebar(view, i2, true, true);
        } else {
            this.mSearchResultTitleBar = view;
            this.mCurrentTitleBar = view;
            this.mEmbeddedTitlebar = view;
            this.mEmbeddedTitlebarHeightPix = d.a.h.a.k.d.a(i2);
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
        WebView webView = this.mCurrentWebView;
        if (webView != null) {
            webView.setHorizontalScrollbarOverlay(z);
        }
    }

    public void setHttpAuthUsernamePassword(String str, String str2, String str3, String str4) {
        this.mCurrentWebView.setHttpAuthUsernamePassword(str, str2, str3, str4);
    }

    public void setInitialScale(int i2) {
        this.mCurrentWebView.setInitialScale(i2);
    }

    @Override // android.view.View
    public void setLayerType(int i2, Paint paint) {
        WebView webView = this.mCurrentWebView;
        if (webView != null) {
            webView.setLayerType(i2, paint);
        } else {
            super.setLayerType(i2, paint);
        }
    }

    public void setMapTrackballToArrowKeys(boolean z) {
        this.mCurrentWebView.setMapTrackballToArrowKeys(z);
    }

    public void setNetworkAvailable(boolean z) {
        this.mCurrentWebView.setNetworkAvailable(z);
    }

    public void setNewTitlebar(View view, int i2, boolean z) {
        setNewTitlebar(view, i2, z, z);
    }

    public void setNewTitlebar(View view, int i2, boolean z, boolean z2) {
        Log.d("new-titlebar", "setNewTitlebar :" + view + " allow hide: " + z + " show: " + z2 + " height: " + i2);
        if (view == null) {
            View view2 = this.mEmbeddedTitlebar;
            if (view2 != null) {
                removeView(view2);
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
        this.mEmbeddedTitlebarHeightPix = d.a.h.a.k.d.a(i2);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        this.mEmbeddedTitlebar.setLayoutParams(layoutParams);
        if (BdZeusUtil.isWebkitLoaded()) {
            setTopControlsHeight(this.mEmbeddedTitlebarHeightPix, true);
            updateTopControlsState(this.mCanHideTitlebar, this.mCanShowTitlebar, false);
        } else {
            setWebViewLayerMargin(this.mMarginLeft, this.mMarginTop + this.mEmbeddedTitlebarHeightPix, this.mMarginRight, this.mMarginBottom);
        }
        View view3 = this.mEmbeddedTitlebar;
        if (view3 != null) {
            if (view3.getParent() != null) {
                ((ViewGroup) this.mEmbeddedTitlebar.getParent()).removeView(this.mEmbeddedTitlebar);
            }
            addView(this.mEmbeddedTitlebar);
            if (d.a.h.b.e.b.c()) {
                View view4 = this.mEmbeddedTitlebar;
                View view5 = this.mLandingPageTitleBar;
                if (view4 == view5) {
                    setCurrentTitleBar(false);
                } else if (view5 != null) {
                    if (view5.getParent() != null) {
                        ((ViewGroup) this.mLandingPageTitleBar.getParent()).removeView(this.mLandingPageTitleBar);
                    }
                    this.mLandingPageTitleBar.setLayoutParams(layoutParams);
                    this.mLandingPageTitleBar.setVisibility(8);
                    addView(this.mLandingPageTitleBar);
                }
                View view6 = this.mEmbeddedTitlebar;
                View view7 = this.mSearchResultTitleBar;
                if (view6 == view7) {
                    setCurrentTitleBar(true);
                } else if (view7 != null) {
                    if (view7.getParent() != null) {
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

    public void setOuterTitlebarHeight(int i2) {
        if (!BdZeusUtil.isWebkitLoaded() || d.a.h.b.e.b.c()) {
            return;
        }
        this.mOuterTitlebarHeightPix = i2;
        setWebViewLayerMarginInternal(this.mMarginLeft, this.mMarginTop + i2, this.mMarginRight, this.mMarginBottom);
    }

    @Override // android.view.View
    public void setOverScrollMode(int i2) {
        WebView webView = this.mCurrentWebView;
        if (webView != null) {
            webView.setOverScrollMode(i2);
        } else {
            super.setOverScrollMode(i2);
        }
    }

    public void setPageTransformer(boolean z, PageTransformer pageTransformer) {
        this.mCurrentWebView.setPageTransformer(z, pageTransformer);
    }

    public void setPictureListener(WebView.PictureListener pictureListener) {
        this.mPictureListener = pictureListener;
    }

    public void setRendererPriorityPolicy(int i2, boolean z) {
        WebView webView = this.mCurrentWebView;
        if (webView != null) {
            webView.setRendererPriorityPolicy(i2, z);
        }
    }

    public void setSailorWebViewSize(int i2, int i3) {
        setViewSize(this.mWebViewLayer, i2, i3);
        setViewSize(this.mCurrentWebView, i2, i3);
        this.mCurrentWebView.setWebViewPagerSize(i2, i3);
    }

    @Override // android.view.View
    public void setScrollBarStyle(int i2) {
        this.mCurrentWebView.setScrollBarStyle(i2);
    }

    public void setStatusBar(View view, int i2) {
        if (d.a.h.b.e.b.c()) {
            if (view == null) {
                View view2 = this.mStatusBar;
                if (view2 != null) {
                    removeView(view2);
                }
                this.mStatusBar = null;
                this.mStatusBarHeight = 0;
                setSearchBarTopMargin();
                this.mCurrentWebView.setStatusBar(null, 0);
                return;
            }
            this.mStatusBar = view;
            this.mStatusBarHeight = i2;
            String str = LOG_TAG;
            Log.i(str, "setStatusBar: mStatusBarHeight=" + this.mStatusBarHeight);
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
        WebView webView = this.mCurrentWebView;
        if (webView != null) {
            webView.setVerticalScrollbarOverlay(z);
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
        ISailorWebViewExt iSailorWebViewExt = this.mWebViewExt;
        if (iSailorWebViewExt != null) {
            iSailorWebViewExt.setWebChromeClientExt(bdSailorWebChromeClientExt);
        }
    }

    public void setWebViewClient(BdSailorWebViewClient bdSailorWebViewClient) {
        this.mWebViewClient = bdSailorWebViewClient;
    }

    public void setWebViewClientExt(BdSailorWebViewClientExt bdSailorWebViewClientExt) {
        ISailorWebViewExt iSailorWebViewExt = this.mWebViewExt;
        if (iSailorWebViewExt != null) {
            iSailorWebViewExt.setWebViewClientExt(bdSailorWebViewClientExt);
        }
    }

    public void setWebViewLayerMargin(int i2, int i3, int i4, int i5) {
        if ((i2 == this.mMarginLeft && i3 == this.mMarginTop && i4 == this.mMarginRight && i5 == this.mMarginBottom) ? false : true) {
            this.mMarginLeft = i2;
            this.mMarginTop = i3;
            this.mMarginRight = i4;
            this.mMarginBottom = i5;
            setWebViewLayerMarginInternal(i2, i3 + this.mOuterTitlebarHeightPix, i4, i5);
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
                f fVar = new f(activity);
                this.mFullscreenContainer = fVar;
                fVar.addView(view, COVER_SCREEN_PARAMS);
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
        WebView webView = this.mCurrentWebView;
        if (webView != null) {
            return webView.startPrerender(str);
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

    public void updateTopControlOffset(int i2) {
        this.mCurrentWebView.updateTopControlOffset(i2);
    }

    public void updateTopControlsState(boolean z, boolean z2, boolean z3) {
        if (this.mEmbeddedTitlebar != null) {
            Log.d("new-titlebar", "updateTopControlsState :" + z);
            this.mCurrentWebView.updateTopControlsState(z, z2, z3);
            if (z3) {
                return;
            }
            if (d.a.h.b.e.b.c()) {
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
