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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.browser.core.INoProGuard;
import com.baidu.browser.sailor.BdSailorWebSettings;
import com.baidu.browser.sailor.BdSailorWebViewClientExt;
import com.baidu.browser.sailor.platform.BdSailorPlatform;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.ETAG;
import com.baidu.webkit.internal.GlobalConstants;
import com.baidu.webkit.internal.monitor.MonitorConstant;
import com.baidu.webkit.internal.monitor.SessionMonitorEngine;
import com.baidu.webkit.internal.utils.NetWorkUtils;
import com.baidu.webkit.sdk.ClientCertRequest;
import com.baidu.webkit.sdk.FirstScreenImageInfomation;
import com.baidu.webkit.sdk.GeolocationPermissions;
import com.baidu.webkit.sdk.HttpAuthHandler;
import com.baidu.webkit.sdk.JsCodeCacheResult;
import com.baidu.webkit.sdk.JsPromptResult;
import com.baidu.webkit.sdk.JsResult;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.PageTransformer;
import com.baidu.webkit.sdk.PermissionRequest;
import com.baidu.webkit.sdk.RenderProcessGoneDetail;
import com.baidu.webkit.sdk.VideoPlayerFactory;
import com.baidu.webkit.sdk.VideoSniffingInfo;
import com.baidu.webkit.sdk.WebAppShortcutDataListener;
import com.baidu.webkit.sdk.WebBackForwardList;
import com.baidu.webkit.sdk.WebBackForwardListClient;
import com.baidu.webkit.sdk.WebChromeClient;
import com.baidu.webkit.sdk.WebHistoryItem;
import com.baidu.webkit.sdk.WebMessageListener;
import com.baidu.webkit.sdk.WebResourceError;
import com.baidu.webkit.sdk.WebResourceRequest;
import com.baidu.webkit.sdk.WebResourceResponse;
import com.baidu.webkit.sdk.WebStorage;
import com.baidu.webkit.sdk.WebView;
import com.baidu.webkit.sdk.WebViewClient;
import com.baidu.webkit.sdk.WebViewDelegate;
import com.baidu.webkit.sdk.abtest.ABTestSDK;
import com.baidu.webkit.sdk.jsapi.IJsAbility;
import com.baidu.webkit.sdk.performance.ZeusPerformanceTiming;
import java.util.List;
import java.util.Map;
/* loaded from: classes10.dex */
public class BdSailorWebView extends FrameLayout implements INoProGuard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final FrameLayout.LayoutParams COVER_SCREEN_PARAMS;
    public static final String JAVASCTIPT_URL = "javascript:";
    public static final String LOG_TAG;
    public static final String SHOW_IMAGE_PREFIX = "imagedisplay:";
    public static boolean sInitFirstWebView;
    public transient /* synthetic */ FieldHolder $fh;
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
    public h mViewDelegate;
    public BdSailorWebChromeClient mWebChromeClient;
    public BdSailorWebSettings mWebSettings;
    public BdSailorWebViewClient mWebViewClient;
    public ISailorWebViewExt mWebViewExt;
    public FrameLayout mWebViewLayer;
    public FrameLayout.LayoutParams mWebViewLayerLp;

    /* loaded from: classes10.dex */
    public class BdSailorWebViewExt implements ISailorWebViewExt {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ISailorWebSettingsExt mSettingsExt;
        public BdSailorWebChromeClientExt mWebChromeClientExt;
        public BdSailorWebViewClientExt mWebViewClientExt;
        public final /* synthetic */ BdSailorWebView this$0;

        public BdSailorWebViewExt(BdSailorWebView bdSailorWebView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdSailorWebView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = bdSailorWebView;
        }

        public /* synthetic */ BdSailorWebViewExt(BdSailorWebView bdSailorWebView, a aVar) {
            this(bdSailorWebView);
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void addNoStatePrefetch(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
                this.this$0.mCurrentWebView.addNoStatePrefetch(str, str2);
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public boolean canGoToPreloadNextExt() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.this$0.mCurrentWebView.canGoPrerender() : invokeV.booleanValue;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void cancelCurrentNoStatePrefetch() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.this$0.mCurrentWebView.cancelCurrentNoStatePrefetch();
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void changeWapPreloadUrlStyleExt(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048579, this, i2, str) == null) {
                this.this$0.mCurrentWebView.changeWapPreloadUrlStyle(i2, str);
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void completeSelectionExt() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.this$0.mCurrentWebView.completeSelection();
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void destroyCanvasCacheBmpExt() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.this$0.mCurrentWebView.destroyCanvasCacheBmp();
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void emulateShiftHeldOnLinkExt() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                this.this$0.mCurrentWebView.emulateShiftHeldOnLink();
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void emulateShiftHeldOnNormalTextExt() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                this.this$0.mCurrentWebView.emulateShiftHeldOnNormalText();
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void ensureRemoveSearchBoxImplExt() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                this.this$0.mCurrentWebView.getSecureProcessor().f();
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void execJavaScriptExt(String str, String... strArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, str, strArr) == null) {
                if (strArr == null || strArr.length == 0) {
                    this.this$0.mCurrentWebView.loadUrl("javascript:(" + str + ")()");
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
                this.this$0.mCurrentWebView.loadUrl(stringBuffer.toString());
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void exitFullScreenModeExt() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
                this.this$0.mCurrentWebView.exitFullScreenMode();
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public int getActionNodesCountExt() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.this$0.mCurrentWebView.getActionNodesCount() : invokeV.intValue;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public float getActualZoomScaleExt() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.this$0.mCurrentWebView.getActualZoomScale() : invokeV.floatValue;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public int getAdCount(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
                return 0;
            }
            return invokeL.intValue;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public int getBackgroundNightColorExt() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public int getBigPluginTextNightColorExt() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public int getBorderNightColorExt() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public Bitmap getCanvasCacheBmpExt() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.this$0.mCurrentWebView.getCanvasCacheBmp() : (Bitmap) invokeV.objValue;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public float getCurrentScaleExt() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.this$0.mCurrentWebView.getCurrentScale() : invokeV.floatValue;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public int getDefaultLinkTextNightColorExt() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public int getEmbeddedTitleBarHeightExt() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
                if (this.this$0.mEmbeddedTitlebar != null) {
                    return this.this$0.mEmbeddedTitlebar.getHeight();
                }
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public int getImageNightColorExt() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public int getLinkTextNightColorExt() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public int getMagicFilterCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public Bitmap getMagnifierBmpExt() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.this$0.mCurrentWebView.getMagnifierBmp() : (Bitmap) invokeV.objValue;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public float getMaxZoomScaleExt() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.this$0.mCurrentWebView.getMaxZoomScale() : invokeV.floatValue;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public float getMinZoomScaleExt() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.this$0.mCurrentWebView.getMinZoomScale() : invokeV.floatValue;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public int getNightModeColorStyleExt() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.this$0.mCurrentWebView.nightModeColorStyle() : invokeV.intValue;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public WebView.WebPageInfoList getPageInfo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.this$0.mCurrentWebView.getPageInfo() : (WebView.WebPageInfoList) invokeV.objValue;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public List<String> getPictureUrlListExt() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
                return null;
            }
            return (List) invokeV.objValue;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public String getSelectionTextExt() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
                try {
                    return (String) c.a.k.a.q.c.a(WebView.class, this, "nativeGetSelection", null, null, "");
                } catch (Exception unused) {
                    return "";
                }
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public ISailorWebSettingsExt getSettingsExt() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
                if (this.mSettingsExt == null) {
                    BdSailorWebSettings settings = this.this$0.getSettings();
                    settings.getClass();
                    this.mSettingsExt = new BdSailorWebSettings.BdSailorWebSettingsExt(settings);
                }
                return this.mSettingsExt;
            }
            return (ISailorWebSettingsExt) invokeV.objValue;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public int getTextNightColorExt() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public int getVisitedLinkNightColorExt() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public BdSailorWebChromeClientExt getWebChromeClientExt() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.mWebChromeClientExt : (BdSailorWebChromeClientExt) invokeV.objValue;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public BdSailorWebViewClientExt getWebViewClientExt() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.mWebViewClientExt : (BdSailorWebViewClientExt) invokeV.objValue;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public ZoomButtonsController getZoomButtonsControllerExt() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
                try {
                    return (ZoomButtonsController) c.a.k.a.q.c.a(WebView.class, this, "getZoomControls", null, null, null);
                } catch (Exception unused) {
                    return null;
                }
            }
            return (ZoomButtonsController) invokeV.objValue;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void hideMagnifierExt(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048613, this, i2, i3) == null) {
                this.this$0.mCurrentWebView.hideMagnifier(i2, i3);
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public boolean isDestroyedExt() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.this$0.mCurrentWebView.isDestroyed() : invokeV.booleanValue;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public boolean isDrawSelectionPointerExt() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
                try {
                    return ((Boolean) c.a.k.a.q.c.a(WebView.class, this, "getDrawSelectionPointer", null, null, Boolean.FALSE)).booleanValue();
                } catch (Exception unused) {
                    return false;
                }
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public boolean isExtendSelectionExt() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public boolean isFixWebViewSecurityHolesExt() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.this$0.mCurrentWebView.getSecureProcessor().a() : invokeV.booleanValue;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public boolean isForegroundExt() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? c.a.k.b.c.b.e(this.this$0) : invokeV.booleanValue;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public boolean isMobileSiteExt() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.this$0.mCurrentWebView.isMobileSite() : invokeV.booleanValue;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public boolean isNeedImpactScriptExt() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.this$0.mCurrentWebView.getSecureProcessor().b() : invokeV.booleanValue;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public boolean isShiftPressedModeExt() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
                try {
                    return ((Boolean) c.a.k.a.q.c.a(WebView.class, this, "getShiftIsPressed", null, null, Boolean.FALSE)).booleanValue();
                } catch (Exception unused) {
                    return false;
                }
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public boolean isTextSelectingModeExt() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.this$0.mCurrentWebView.getSelectingText() : invokeV.booleanValue;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public boolean isWapAllowScaleExt() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.this$0.mCurrentWebView.isWapAllowScale() : invokeV.booleanValue;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048624, this, new Object[]{str, str2, str3, str4, str5, Boolean.valueOf(z)}) == null) {
                this.this$0.mCurrentWebView.loadDataWithBaseURL(str, str2, str3, str4, str5, z);
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void loadUrl(String str, Map<String, String> map, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(1048625, this, str, map, z) == null) {
                this.this$0.mCurrentWebView.loadUrl(str, map, z);
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void mediaPlayerStatusChangedExt(int i2, float f2, float f3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048626, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Float.valueOf(f3)}) == null) {
                this.this$0.mCurrentWebView.mediaPlayerStatusChanged(i2, f2, f3);
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void mediaPlayerTimeChangedExt(float f2, float f3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048627, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
                this.this$0.mCurrentWebView.mediaPlayerTimeChanged(f2, f3);
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void moveMagnifierExt(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048628, this, i2, i3) == null) {
                this.this$0.mCurrentWebView.moveMagnifier(i2, i3);
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public boolean notifyNativeExitFullScreenIfNeededExt(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048629, this, i2)) == null) ? this.this$0.mCurrentWebView.notifyNativeExitFullScreenIfNeeded(i2) : invokeI.booleanValue;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void onPauseAll() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
                this.this$0.mCurrentWebView.onPauseAll();
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void onResumeAll() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
                this.this$0.mCurrentWebView.onResumeAll();
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void onSearchKeyword(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048632, this, str, str2) == null) {
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void onShowCommentPanel(String str, String str2) {
            BdSailorWebChromeClientExt bdSailorWebChromeClientExt;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048633, this, str, str2) == null) || (bdSailorWebChromeClientExt = this.mWebChromeClientExt) == null) {
                return;
            }
            bdSailorWebChromeClientExt.onShowCommentPanel(this.this$0, str, str2);
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void onShowValidateComponent(String str, String str2) {
            BdSailorWebChromeClientExt bdSailorWebChromeClientExt;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048634, this, str, str2) == null) || (bdSailorWebChromeClientExt = this.mWebChromeClientExt) == null) {
                return;
            }
            bdSailorWebChromeClientExt.onShowValidateComponent(this.this$0, str, str2);
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void pauseExt(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048635, this, z) == null) {
                this.this$0.mCurrentWebView.pause(z);
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void pauseMediaExt() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048636, this) == null) {
                this.this$0.mCurrentWebView.pauseMedia();
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void resetLoadingAnimation() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048637, this) == null) {
                this.this$0.mCurrentWebView.resetLoadingAnimation();
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void resumeExt(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048638, this, z) == null) {
                this.this$0.mCurrentWebView.resume(z);
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void resumeMediaExt() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048639, this) == null) {
                this.this$0.mCurrentWebView.resumeMedia();
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public boolean savePageAsLocalFilesExt(String str, String str2, WebView.SaveAsType saveAsType) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048640, this, str, str2, saveAsType)) == null) ? this.this$0.mCurrentWebView.savePageAsLocalFiles(str, str2, saveAsType) : invokeLLL.booleanValue;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public boolean setBackgroundNightColorExt(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048641, this, i2)) == null) {
                return false;
            }
            return invokeI.booleanValue;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void setBeginScaleExt() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048642, this) == null) {
                this.this$0.mCurrentWebView.setBeginScale();
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public boolean setBigPluginTextNightColorExt(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048643, this, i2)) == null) {
                return false;
            }
            return invokeI.booleanValue;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public boolean setBorderNightColorExt(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048644, this, i2)) == null) {
                return false;
            }
            return invokeI.booleanValue;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public boolean setDefaultLinkTextNightColorExt(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048645, this, i2)) == null) {
                return false;
            }
            return invokeI.booleanValue;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void setDefaultViewSizeExt(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048646, this, i2, i3) == null) {
                this.this$0.mCurrentWebView.setDefaultViewSize(i2, i3);
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void setDrawSelectionPointerExt(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048647, this, z) == null) {
                try {
                    c.a.k.a.q.c.a(WebView.class, this, "setDrawSelectionPointer", new Class[]{Boolean.TYPE}, new Object[]{Boolean.valueOf(z)}, Boolean.FALSE);
                } catch (Exception unused) {
                }
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void setEndScaleExt() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048648, this) == null) {
                this.this$0.mCurrentWebView.setEndScale();
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void setExtendSelectionExt(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048649, this, z) == null) {
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void setFixWebViewSecurityHolesExt(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048650, this, z) == null) {
                this.this$0.mCurrentWebView.getSecureProcessor().a(z);
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public boolean setImageNightColorExt(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048651, this, i2)) == null) {
                return false;
            }
            return invokeI.booleanValue;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public boolean setLinkTextNightColorExt(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048652, this, i2)) == null) {
                return false;
            }
            return invokeI.booleanValue;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void setNeedImpactScriptExt(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048653, this, z) == null) {
                this.this$0.mCurrentWebView.getSecureProcessor().b(z);
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public boolean setNightModeColorStyleExt(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048654, this, i2)) == null) {
                return false;
            }
            return invokeI.booleanValue;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public boolean setPreviewZoomScaleExt(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeF = interceptable.invokeF(1048655, this, f2)) == null) ? this.this$0.mCurrentWebView.setPreviewZoomScale(f2) : invokeF.booleanValue;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void setShiftPressedModeExt(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048656, this, z) == null) {
                try {
                    c.a.k.a.q.c.a(WebView.class, this, "setShiftIsPressed", new Class[]{Boolean.TYPE}, new Object[]{Boolean.valueOf(z)}, Boolean.FALSE);
                } catch (Exception unused) {
                }
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void setSubjectScrollToOnloadExt(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048657, this, i2) == null) {
                this.this$0.mCurrentWebView.setSubjectScrollToOnload(i2);
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void setTextFieldTextExt(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048658, this, str) == null) {
                this.this$0.mCurrentWebView.setTextFieldText(str);
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void setTextFieldTextExt(String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048659, this, str, z) == null) {
                if (z) {
                    this.this$0.mCurrentWebView.insertTextFieldText(str);
                } else {
                    this.this$0.mCurrentWebView.setTextFieldText(str);
                }
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public boolean setTextNightColorExt(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048660, this, i2)) == null) {
                return false;
            }
            return invokeI.booleanValue;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void setTextSelectingModeExt(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048661, this, z) == null) {
                this.this$0.mCurrentWebView.setSelectingText(z);
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public boolean setVisitedLinkNightColorExt(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048662, this, i2)) == null) ? this.this$0.mCurrentWebView.setVisitedLinkNightColor(i2) : invokeI.booleanValue;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void setWebChromeClientExt(BdSailorWebChromeClientExt bdSailorWebChromeClientExt) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048663, this, bdSailorWebChromeClientExt) == null) {
                this.mWebChromeClientExt = bdSailorWebChromeClientExt;
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void setWebViewClientExt(BdSailorWebViewClientExt bdSailorWebViewClientExt) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048664, this, bdSailorWebViewClientExt) == null) {
                this.mWebViewClientExt = bdSailorWebViewClientExt;
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void setWebViewStateExt(WebView.WebViewState webViewState) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048665, this, webViewState) == null) {
                this.this$0.mCurrentWebView.setWebViewState(webViewState);
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void setWebViewTypeExt(WebView.WebViewType webViewType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048666, this, webViewType) == null) {
                this.this$0.mCurrentWebView.setWebViewType(webViewType);
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void showMagnifierExt(int i2, int i3, int i4, int i5, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048667, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Boolean.valueOf(z)}) == null) {
                this.this$0.mCurrentWebView.showMagnifier(i2, i3, i4, i5, z);
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void startCaptureContentExt() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048668, this) == null) {
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void startLoadingAnimation() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048669, this) == null) {
                this.this$0.mCurrentWebView.startLoadingAnimation(null);
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void startLoadingAnimation(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048670, this, str) == null) {
                this.this$0.mCurrentWebView.startLoadingAnimation(str);
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public boolean startPreviewZoomScaleExt() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) ? this.this$0.mCurrentWebView.startPreviewZoomScale() : invokeV.booleanValue;
        }

        @Override // com.baidu.browser.sailor.ISailorWebViewExt
        public void updatePictureUrlListExt() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048672, this) == null) {
            }
        }
    }

    /* loaded from: classes10.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BdSailorWebView f33047e;

        public a(BdSailorWebView bdSailorWebView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdSailorWebView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33047e = bdSailorWebView;
        }

        @Override // java.lang.Runnable
        public final void run() {
            FrameLayout frameLayout;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    Context context = this.f33047e.getContext();
                    Activity activity = context instanceof Activity ? (Activity) context : null;
                    if (activity != null) {
                        if (this.f33047e.getCurrentWebView() != null) {
                            this.f33047e.getCurrentWebView().setVisibility(0);
                        }
                        this.f33047e.setFullscreen(activity, false);
                        Window window = activity.getWindow();
                        if (window == null || (frameLayout = (FrameLayout) window.getDecorView()) == null) {
                            return;
                        }
                        if (this.f33047e.mFullscreenContainer != null) {
                            frameLayout.removeView(this.f33047e.mFullscreenContainer);
                            this.f33047e.mFullscreenContainer = null;
                        }
                        this.f33047e.mCustomView = null;
                        if (this.f33047e.mCustomViewCallback != null) {
                            this.f33047e.mCustomViewCallback.onCustomViewHidden();
                        }
                        activity.setRequestedOrientation(this.f33047e.mOriginalOrientation);
                    }
                } catch (Exception e2) {
                    Log.e(BdSailorWebView.LOG_TAG, "Exception happened when hide custom view");
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b extends WebBackForwardListClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WebView a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ BdSailorWebView f33048b;

        public b(BdSailorWebView bdSailorWebView, WebView webView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdSailorWebView, webView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33048b = bdSailorWebView;
            this.a = webView;
        }

        @Override // com.baidu.webkit.sdk.WebBackForwardListClient
        public final void onIndexChanged(WebHistoryItem webHistoryItem, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, webHistoryItem, i2) == null) {
                super.onIndexChanged(webHistoryItem, i2);
            }
        }

        @Override // com.baidu.webkit.sdk.WebBackForwardListClient
        public final void onNewHistoryItem(WebHistoryItem webHistoryItem) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webHistoryItem) == null) || this.f33048b.mWebViewExt.getWebViewClientExt() == null) {
                return;
            }
            this.f33048b.mWebViewExt.getWebViewClientExt().onNewPage(this.f33048b);
        }
    }

    /* loaded from: classes10.dex */
    public class c implements WebView.PictureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdSailorWebView a;

        public c(BdSailorWebView bdSailorWebView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdSailorWebView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdSailorWebView;
        }

        public /* synthetic */ c(BdSailorWebView bdSailorWebView, byte b2) {
            this(bdSailorWebView);
        }

        @Override // com.baidu.webkit.sdk.WebView.PictureListener
        public final void onNewPicture(WebView webView, Picture picture) {
            WebView.PictureListener pictureListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, webView, picture) == null) || (pictureListener = this.a.mPictureListener) == null) {
                return;
            }
            pictureListener.onNewPicture(webView, picture);
        }
    }

    /* loaded from: classes10.dex */
    public class d implements DownloadListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WebView a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ BdSailorWebView f33049b;

        public d(BdSailorWebView bdSailorWebView, WebView webView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdSailorWebView, webView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33049b = bdSailorWebView;
            this.a = webView;
        }

        @Override // android.webkit.DownloadListener
        public final void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, str2, str3, str4, Long.valueOf(j2)}) == null) {
                Log.d("// BdSailorMonitorEngine", "BdDownloadListenerBridge.onDownloadStart l=" + j2 + ", ---> s=" + str + ", --->s1=" + str2 + ", ---> s2=" + str3 + ", --- s3=" + str4);
                if (this.f33049b.mDownloadListener != null) {
                    this.f33049b.mDownloadListener.onDownloadStart(str, str2, str3, str4, j2);
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class e extends WebChromeClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String[] a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ BdSailorWebView f33050b;

        public e(BdSailorWebView bdSailorWebView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdSailorWebView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33050b = bdSailorWebView;
            this.a = new String[]{"mail.163.com", "mail.126.com", "mail.yeah.net", "shouji.163.com"};
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void copyText(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                if (this.f33050b.mWebViewExt.getWebChromeClientExt() != null) {
                    this.f33050b.mWebViewExt.getWebChromeClientExt().copyTextExt(this.f33050b, str);
                } else {
                    super.copyText(webView, str);
                }
            }
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void doTextSearch(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str) == null) {
                super.doTextSearch(webView, str);
                if (this.f33050b.mWebChromeClient != null) {
                    this.f33050b.mWebChromeClient.doTextSearchExt(this.f33050b, str);
                }
            }
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void doTextTranslate(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, webView, str) == null) {
                if (this.f33050b.mWebChromeClient != null) {
                    this.f33050b.mWebChromeClient.doTextTranslateExt(this.f33050b, str);
                } else {
                    super.doTextTranslate(webView, str);
                }
            }
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final Bitmap getDefaultVideoPoster() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f33050b.mWebChromeClient != null ? this.f33050b.mWebChromeClient.getDefaultVideoPoster(this.f33050b) : super.getDefaultVideoPoster() : (Bitmap) invokeV.objValue;
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final View getVideoLoadingProgressView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f33050b.mWebChromeClient != null ? this.f33050b.mWebChromeClient.getVideoLoadingProgressView(this.f33050b) : super.getVideoLoadingProgressView() : (View) invokeV.objValue;
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void getVisitedHistory(ValueCallback<String[]> valueCallback) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, valueCallback) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                if (this.f33050b.mWebChromeClient != null) {
                    this.f33050b.mWebChromeClient.getVisitedHistory(this.f33050b, valueCallback);
                } else {
                    super.getVisitedHistory(valueCallback);
                }
                SessionMonitorEngine.getInstance().onPageKeySectionTimeCost(this.f33050b.getCurrentWebView(), this.f33050b.getUrl(), MonitorConstant.KeySectionType.GET_VISITED_HISTORY.ordinal(), System.currentTimeMillis() - currentTimeMillis);
            }
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void hideMagnifier(WebView webView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048582, this, webView, i2, i3) == null) {
                if (this.f33050b.mWebViewExt.getWebChromeClientExt() != null) {
                    this.f33050b.mWebViewExt.getWebChromeClientExt().hideMagnifierExt(this.f33050b, i2, i3);
                } else {
                    super.hideMagnifier(webView, i2, i3);
                }
                this.f33050b.mIsFunctionLayerShowing = false;
            }
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void hideSelectionActionDialog(WebView webView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, webView) == null) {
                if (this.f33050b.mWebViewExt.getWebChromeClientExt() != null) {
                    this.f33050b.mWebViewExt.getWebChromeClientExt().hideSelectionActionDialogExt(this.f33050b);
                } else {
                    super.hideSelectionActionDialog(webView);
                }
                this.f33050b.mIsFunctionLayerShowing = false;
            }
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void moveMagnifier(WebView webView, int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{webView, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
                if (this.f33050b.mWebViewExt.getWebChromeClientExt() != null) {
                    this.f33050b.mWebViewExt.getWebChromeClientExt().moveMagnifierExt(this.f33050b, i2, i3, i4, i5);
                } else {
                    super.moveMagnifier(webView, i2, i3, i4, i5);
                }
            }
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final boolean needNotifyNativeExitFullScreen() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f33050b.mWebViewExt.getWebChromeClientExt() != null ? this.f33050b.mWebViewExt.getWebChromeClientExt().needNotifyNativeExitFullScreenExt(this.f33050b) : super.needNotifyNativeExitFullScreen() : invokeV.booleanValue;
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void notifyClickWhenLoad() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
                if (this.f33050b.mWebViewExt.getWebChromeClientExt() != null) {
                    this.f33050b.mWebViewExt.getWebChromeClientExt().notifyClickWhenLoadExt(this.f33050b);
                } else {
                    super.notifyClickWhenLoad();
                }
            }
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void notifyClientStatus(WebView webView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048587, this, webView, i2) == null) {
                if (this.f33050b.mWebViewExt.getWebChromeClientExt() != null) {
                    this.f33050b.mWebViewExt.getWebChromeClientExt().notifyClientStatusExt(this.f33050b, i2);
                } else {
                    super.notifyClientStatus(webView, i2);
                }
            }
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void onCloseWindow(WebView webView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, webView) == null) {
                if (this.f33050b.mWebChromeClient != null) {
                    this.f33050b.mWebChromeClient.onCloseWindow(this.f33050b);
                } else {
                    super.onCloseWindow(webView);
                }
            }
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, consoleMessage)) == null) {
                boolean onConsoleMessage = super.onConsoleMessage(consoleMessage);
                return (this.f33050b.mWebChromeClient == null || onConsoleMessage) ? onConsoleMessage : this.f33050b.mWebChromeClient.onConsoleMessage(this.f33050b, consoleMessage);
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{webView, Boolean.valueOf(z), Boolean.valueOf(z2), message})) == null) ? this.f33050b.mWebChromeClient != null ? this.f33050b.mWebChromeClient.onCreateWindow(this.f33050b, z, z2, message) : super.onCreateWindow(webView, z, z2, message) : invokeCommon.booleanValue;
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void onExceededDatabaseQuota(String str, String str2, long j2, long j3, long j4, WebStorage.QuotaUpdater quotaUpdater) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{str, str2, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), quotaUpdater}) == null) {
                super.onExceededDatabaseQuota(str, str2, j2, j3, j4, quotaUpdater);
                if (this.f33050b.mWebChromeClient != null) {
                    this.f33050b.mWebChromeClient.onExceededDatabaseQuota(this.f33050b, str, str2, j2, j3, j4, quotaUpdater);
                }
            }
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void onGeolocationPermissionsHidePrompt() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
                if (this.f33050b.mWebChromeClient != null) {
                    this.f33050b.mWebChromeClient.onGeolocationPermissionsHidePrompt(this.f33050b);
                } else {
                    super.onGeolocationPermissionsHidePrompt();
                }
            }
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048593, this, str, callback) == null) || this.f33050b.mWebChromeClient == null) {
                return;
            }
            this.f33050b.mWebChromeClient.onGeolocationPermissionsShowPrompt(this.f33050b, str, callback);
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void onHideCustomView() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
                if (this.f33050b.mWebChromeClient != null ? this.f33050b.mWebChromeClient.onHideCustomView(this.f33050b) : false) {
                    return;
                }
                this.f33050b.hideCustomView();
            }
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048595, this, webView, str, str2, jsResult)) == null) {
                boolean z = this.f33050b.mWebChromeClient != null && this.f33050b.mWebChromeClient.onJsAlert(this.f33050b, str, str2, jsResult);
                return !z ? super.onJsAlert(webView, str, str2, jsResult) : z;
            }
            return invokeLLLL.booleanValue;
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048596, this, webView, str, str2, jsResult)) == null) {
                if (!TextUtils.isEmpty(str)) {
                    String host = Uri.parse(str).getHost();
                    if (!TextUtils.isEmpty(host)) {
                        for (String str3 : this.a) {
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
                return this.f33050b.mWebChromeClient != null && this.f33050b.mWebChromeClient.onJsBeforeUnload(this.f33050b, str, str2, jsResult);
            }
            return invokeLLLL.booleanValue;
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048597, this, webView, str, str2, jsResult)) == null) ? this.f33050b.mWebChromeClient != null ? this.f33050b.mWebChromeClient.onJsConfirm(this.f33050b, str, str2, jsResult) : super.onJsConfirm(webView, str, str2, jsResult) : invokeLLLL.booleanValue;
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            InterceptResult invokeLLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048598, this, webView, str, str2, str3, jsPromptResult)) == null) {
                if (super.onJsPrompt(webView, str, str2, str3, jsPromptResult)) {
                    return true;
                }
                if (this.f33050b.mWebChromeClient != null) {
                    return this.f33050b.mWebChromeClient.onJsPrompt(this.f33050b, str, str2, str3, jsPromptResult);
                }
                return false;
            }
            return invokeLLLLL.booleanValue;
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final boolean onJsTimeout() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
                if (super.onJsTimeout()) {
                    return true;
                }
                return this.f33050b.mWebChromeClient != null && this.f33050b.mWebChromeClient.onJsTimeout(this.f33050b);
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void onNativeElementEnterFullScreen() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
                if (this.f33050b.mWebViewExt.getWebChromeClientExt() != null) {
                    this.f33050b.mWebViewExt.getWebChromeClientExt().onNativeElementEnterFullScreenExt(this.f33050b);
                } else {
                    super.onNativeElementEnterFullScreen();
                }
            }
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void onNativeElementExitFullScreen() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
                if (this.f33050b.mWebViewExt.getWebChromeClientExt() != null) {
                    this.f33050b.mWebViewExt.getWebChromeClientExt().onNativeElementExitFullScreenExt(this.f33050b);
                } else {
                    super.onNativeElementExitFullScreen();
                }
            }
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void onOffsetsForFullscreenChanged(float f2, float f3, float f4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
                BdSailorWebView bdSailorWebView = this.f33050b;
                bdSailorWebView.setTopControlsHeight(bdSailorWebView.mEmbeddedTitlebarHeightPix, f3 > 0.0f);
                if (this.f33050b.mWebChromeClient != null) {
                    this.f33050b.mWebChromeClient.onOffsetsForFullscreenChanged(this.f33050b, f2, f3, f4);
                } else {
                    super.onOffsetsForFullscreenChanged(f2, f3, f4);
                }
            }
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void onPermissionRequest(PermissionRequest permissionRequest) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048603, this, permissionRequest) == null) {
                if (this.f33050b.mWebChromeClient != null) {
                    this.f33050b.mWebChromeClient.onPermissionRequest(this.f33050b, permissionRequest);
                } else {
                    super.onPermissionRequest(permissionRequest);
                }
            }
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void onPermissionRequestCanceled(PermissionRequest permissionRequest) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048604, this, permissionRequest) == null) {
                if (this.f33050b.mWebChromeClient != null) {
                    this.f33050b.mWebChromeClient.onPermissionRequestCanceled(this.f33050b, permissionRequest);
                } else {
                    super.onPermissionRequestCanceled(permissionRequest);
                }
            }
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void onPrerenderChanged(int i2, WebView.PrerenderStatus prerenderStatus) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048605, this, i2, prerenderStatus) == null) {
                super.onPrerenderChanged(i2, prerenderStatus);
                if (this.f33050b.mWebViewExt.getWebChromeClientExt() != null) {
                    this.f33050b.mWebViewExt.getWebChromeClientExt().onPrerenderChanged(i2, prerenderStatus);
                }
            }
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void onProgressChanged(WebView webView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048606, this, webView, i2) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                super.onProgressChanged(webView, i2);
                if (this.f33050b.mWebChromeClient != null) {
                    this.f33050b.mWebChromeClient.onProgressChanged(this.f33050b, i2);
                }
                if (webView == this.f33050b.mCurrentWebView && i2 == 100) {
                    this.f33050b.mIsPageLoading = false;
                }
                SessionMonitorEngine.getInstance().onPageKeySectionTimeCost(webView, webView.getUrl(), MonitorConstant.KeySectionType.PROGRESSCHANGED.ordinal(), System.currentTimeMillis() - currentTimeMillis);
            }
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void onReachedMaxAppCacheSize(long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048607, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), quotaUpdater}) == null) {
                super.onReachedMaxAppCacheSize(j2, j3, quotaUpdater);
                if (this.f33050b.mWebChromeClient != null) {
                    this.f33050b.mWebChromeClient.onReachedMaxAppCacheSize(this.f33050b, j2, j3, quotaUpdater);
                }
            }
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void onReceivedIcon(WebView webView, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048608, this, webView, bitmap) == null) {
                if (this.f33050b.mWebChromeClient != null) {
                    this.f33050b.mWebChromeClient.onReceivedIcon(this.f33050b, bitmap);
                } else {
                    super.onReceivedIcon(webView, bitmap);
                }
            }
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void onReceivedTitle(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048609, this, webView, str) == null) {
                super.onReceivedTitle(webView, str);
                if (this.f33050b.mWebChromeClient != null) {
                    this.f33050b.mWebChromeClient.onReceivedTitle(this.f33050b, str);
                }
            }
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void onReceivedTouchIconUrl(WebView webView, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(1048610, this, webView, str, z) == null) {
                if (this.f33050b.mWebChromeClient != null) {
                    this.f33050b.mWebChromeClient.onReceivedTouchIconUrl(this.f33050b, str, z);
                } else {
                    super.onReceivedTouchIconUrl(webView, str, z);
                }
            }
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void onRequestFocus(WebView webView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048611, this, webView) == null) {
                if (this.f33050b.mWebChromeClient != null) {
                    this.f33050b.mWebChromeClient.onRequestFocus(this.f33050b);
                } else {
                    super.onRequestFocus(webView);
                }
            }
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void onSetLoadURL(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048612, this, webView, str) == null) {
                super.onSetLoadURL(webView, str);
                if (this.f33050b.mWebViewExt.getWebChromeClientExt() != null) {
                    this.f33050b.mWebViewExt.getWebChromeClientExt().onSetLoadURLExt(this.f33050b, str);
                }
            }
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void onShowCustomView(View view, int i2, WebChromeClient.CustomViewCallback customViewCallback) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048613, this, view, i2, customViewCallback) == null) {
                if (this.f33050b.mWebChromeClient != null ? this.f33050b.mWebChromeClient.onShowCustomView(this.f33050b, view, i2, customViewCallback) : false) {
                    return;
                }
                BdSailorWebView bdSailorWebView = this.f33050b;
                bdSailorWebView.showCustomView(bdSailorWebView.getContext(), view, customViewCallback);
            }
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048614, this, view, customViewCallback) == null) {
                if (this.f33050b.mWebChromeClient != null ? this.f33050b.mWebChromeClient.onShowCustomView(this.f33050b, view, customViewCallback) : false) {
                    return;
                }
                BdSailorWebView bdSailorWebView = this.f33050b;
                bdSailorWebView.showCustomView(bdSailorWebView.getContext(), view, customViewCallback);
            }
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048615, this, webView, valueCallback, fileChooserParams)) == null) ? this.f33050b.mWebChromeClient != null ? this.f33050b.mWebChromeClient.onShowFileChooser(this.f33050b, valueCallback, fileChooserParams) : super.onShowFileChooser(webView, valueCallback, fileChooserParams) : invokeLLL.booleanValue;
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void openFileChooser(ValueCallback<Uri> valueCallback) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048616, this, valueCallback) == null) {
                if (this.f33050b.mWebChromeClient != null) {
                    this.f33050b.mWebChromeClient.openFileChooser(this.f33050b, valueCallback);
                } else {
                    super.openFileChooser(valueCallback);
                }
            }
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void openFileChooser(ValueCallback<Uri> valueCallback, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048617, this, valueCallback, str) == null) {
                if (this.f33050b.mWebChromeClient != null) {
                    this.f33050b.mWebChromeClient.openFileChooser(this.f33050b, valueCallback, str);
                } else {
                    super.openFileChooser(valueCallback, str);
                }
            }
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048618, this, valueCallback, str, str2) == null) {
                if (this.f33050b.mWebChromeClient != null) {
                    this.f33050b.mWebChromeClient.openFileChooser(this.f33050b, valueCallback, str, str2);
                } else {
                    super.openFileChooser(valueCallback, str, str2);
                }
            }
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void performLongClick(WebView webView, int i2, String str, String str2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048619, this, new Object[]{webView, Integer.valueOf(i2), str, str2, Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
                super.performLongClick(webView, i2, str, str2, i3, i4);
                if (BdZeusUtil.isWebkitLoaded() || Build.VERSION.SDK_INT >= 19) {
                    if (this.f33050b.mWebViewExt != null && this.f33050b.mWebViewExt.getWebChromeClientExt() != null) {
                        this.f33050b.mIsFunctionLayerShowing = true;
                        this.f33050b.mWebViewExt.getWebChromeClientExt().performLongClickExt(this.f33050b, i2, str, str2, i3, i4);
                    }
                    if (i2 == 5 || i2 == 8) {
                        this.f33050b.getWebViewExt().updatePictureUrlListExt();
                    }
                }
            }
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void performLongClick(WebView webView, WebView.HitTestResult hitTestResult, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLII(1048620, this, webView, hitTestResult, i2, i3) == null) {
                super.performLongClick(webView, hitTestResult, i2, i3);
                if (BdZeusUtil.isWebkitLoaded() || Build.VERSION.SDK_INT >= 19) {
                    if (this.f33050b.mWebViewExt != null && this.f33050b.mWebViewExt.getWebChromeClientExt() != null) {
                        this.f33050b.mIsFunctionLayerShowing = true;
                        this.f33050b.mWebViewExt.getWebChromeClientExt().performLongClickExt(this.f33050b, hitTestResult, i2, i3);
                    }
                    if (hitTestResult.getType() == 5 || hitTestResult.getType() == 8) {
                        this.f33050b.getWebViewExt().updatePictureUrlListExt();
                    }
                }
            }
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void showMagnifier(WebView webView, int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048621, this, new Object[]{webView, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
                this.f33050b.mIsFunctionLayerShowing = true;
                if (this.f33050b.mWebViewExt.getWebChromeClientExt() != null) {
                    this.f33050b.mWebViewExt.getWebChromeClientExt().showMagnifierExt(this.f33050b, i2, i3, i4, i5);
                } else {
                    super.showMagnifier(webView, i2, i3, i4, i5);
                }
            }
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient
        public final void showSelectionActionDialog(WebView webView, int i2, int i3, int i4, int i5, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048622, this, new Object[]{webView, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), str}) == null) {
                this.f33050b.mIsFunctionLayerShowing = true;
                if (this.f33050b.mWebViewExt.getWebChromeClientExt() != null) {
                    this.f33050b.mWebViewExt.getWebChromeClientExt().showSelectionActionDialogExt(this.f33050b, i2, i3, i4, i5, str);
                } else {
                    super.showSelectionActionDialog(webView, i2, i3, i4, i5, str);
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class f extends WebViewClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String[] a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ BdSailorWebView f33051b;

        public f(BdSailorWebView bdSailorWebView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdSailorWebView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33051b = bdSailorWebView;
            this.a = new String[]{"wtai://", "tel:", UrlSchemaHelper.SCHEMA_TYPE_SMS, "mailto", "smsto:"};
        }

        public /* synthetic */ f(BdSailorWebView bdSailorWebView, byte b2) {
            this(bdSailorWebView);
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void AntiHijackSign(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final boolean canHandleImage(WebView webView, String str, String str2, String str3) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, str2, str3)) == null) {
                boolean z = false;
                if (this.f33051b.mWebViewExt.getWebViewClientExt() != null) {
                    BdSailorWebViewClientExt webViewClientExt = this.f33051b.mWebViewExt.getWebViewClientExt();
                    BdSailorWebView bdSailorWebView = this.f33051b;
                    z = webViewClientExt.shouldHandleImageExt(bdSailorWebView, str, str2, str3, bdSailorWebView.mCurrentWebView == webView);
                    Log.i("WebViewClient", "canHandleImage ret=".concat(String.valueOf(z)));
                }
                if (z) {
                    this.f33051b.stopLoading();
                    return true;
                }
                return super.canHandleImage(webView, str, str2, str3);
            }
            return invokeLLLL.booleanValue;
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final int computeHookH5NavigationStep(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                Log.i("WebViewClient", "BeeFrame computeHookH5NavigationStep: offset=".concat(String.valueOf(i2)));
                return this.f33051b.mWebViewExt.getWebViewClientExt() != null ? this.f33051b.mWebViewExt.getWebViewClientExt().computeHookH5NavigationStep(i2) : super.computeHookH5NavigationStep(i2);
            }
            return invokeI.intValue;
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void doUpdateVisitedHistory(WebView webView, String str, boolean z, boolean z2, boolean z3, boolean z4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{webView, str, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)}) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                super.doUpdateVisitedHistory(webView, str, z, z2, z3, z4);
                if (this.f33051b.mWebViewClient != null) {
                    this.f33051b.mWebViewClient.doUpdateVisitedHistory(this.f33051b, str, z);
                }
                if (this.f33051b.mWebViewExt.getWebViewClientExt() != null) {
                    this.f33051b.mWebViewExt.getWebViewClientExt().doUpdateVisitedHistory(this.f33051b, str, z, z2, z3, z4);
                }
                SessionMonitorEngine.getInstance().onPageKeySectionTimeCost(webView, str, MonitorConstant.KeySectionType.DO_UPDATE_VISITED_HISTORY.ordinal(), System.currentTimeMillis() - currentTimeMillis);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onAbortResourceRequest(WebView webView, String str, String str2, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{webView, str, str2, Long.valueOf(j2)}) == null) || !(webView instanceof WebView) || this.f33051b.isDestroyed() || this.f33051b.mWebViewExt == null || this.f33051b.mWebViewExt.getWebViewClientExt() == null) {
                return;
            }
            this.f33051b.mWebViewExt.getWebViewClientExt().onAbortResourceRequest(this.f33051b, str, str2, j2);
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onCheckHasManifestAndServiceWorker(WebView webView, String str, String str2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{webView, str, str2, Boolean.valueOf(z)}) == null) {
                Log.i("pwa", "onCheckHasManifestAndServiceWorker has=" + z + ",url=" + str);
                if (this.f33051b.mWebViewExt.getWebViewClientExt() != null) {
                    this.f33051b.mWebViewExt.getWebViewClientExt().onCheckHasManifestAndServiceWorker(this.f33051b, str, str2, z);
                } else {
                    super.onCheckHasManifestAndServiceWorker(webView, str, str2, z);
                }
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onDidAsyncWiseSearchStatusChanged(WebView webView, String str, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{webView, str, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                super.onDidAsyncWiseSearchStatusChanged(webView, str, i2, j2);
                if (this.f33051b.mWebViewExt == null || this.f33051b.mWebViewExt.getWebViewClientExt() == null) {
                    return;
                }
                Log.i("WebViewClient", "onDidAsyncWiseSearchStatusChangedExt status : " + i2 + ", aUrl : " + str);
                this.f33051b.mWebViewExt.getWebViewClientExt().onDidAsyncWiseSearchStatusChangedExt(this.f33051b, str, i2, j2);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onDisplaySoftKeyboard(WebView webView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, webView) == null) {
                if (this.f33051b.mWebViewExt.getWebViewClientExt() != null) {
                    this.f33051b.mWebViewExt.getWebViewClientExt().onDisplaySoftKeyboardExt(this.f33051b);
                } else {
                    super.onDisplaySoftKeyboard(webView);
                }
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onFirstContentfulPaint(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, webView, str) == null) || this.f33051b.mWebViewExt == null || this.f33051b.mWebViewExt.getWebViewClientExt() == null) {
                return;
            }
            Log.i("WebViewClient", "FCPCallback onFirstContentfulPaintExt, aUrl : ".concat(String.valueOf(str)));
            this.f33051b.mWebViewExt.getWebViewClientExt().onFirstContentfulPaintExt(this.f33051b, str);
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onFirstImagePaint(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048585, this, webView, str) == null) || this.f33051b.mWebViewExt == null || this.f33051b.mWebViewExt.getWebViewClientExt() == null) {
                return;
            }
            Log.i("WebViewClient", "FIPCallback onFirstImagePaintExt, aUrl : ".concat(String.valueOf(str)));
            this.f33051b.mWebViewExt.getWebViewClientExt().onFirstImagePaintExt(this.f33051b, str);
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onFirstLayoutDid(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048586, this, webView, str) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                this.f33051b.perfLog(webView, "onFirstLayoutDid");
                super.onFirstLayoutDid(webView, str);
                if (this.f33051b.mWebViewExt != null && this.f33051b.mWebViewExt.getWebViewClientExt() != null) {
                    this.f33051b.mWebViewExt.getWebViewClientExt().onFirstLayoutDidExt(this.f33051b, str);
                }
                SessionMonitorEngine.getInstance().onPageKeySectionTimeCost(webView, str, MonitorConstant.KeySectionType.DID_FIRST_LAYOUT.ordinal(), System.currentTimeMillis() - currentTimeMillis);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onFirstPaintDid(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048587, this, webView, str) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                this.f33051b.perfLog(webView, "onFirstPaintDid", "Started");
                super.onFirstPaintDid(webView, str);
                if (this.f33051b.mWebViewExt != null && this.f33051b.mWebViewExt.getWebViewClientExt() != null) {
                    this.f33051b.mWebViewExt.getWebViewClientExt().onFirstPaintDidExt(this.f33051b, str);
                }
                this.f33051b.perfLog(webView, "onFirstPaintDid", "Finished");
                this.f33051b.perfLog(ETAG.KEY_FIRST_PAINT, str);
                SessionMonitorEngine.getInstance().onPageKeySectionTimeCost(webView, str, MonitorConstant.KeySectionType.DID_FIRST_PAINT.ordinal(), System.currentTimeMillis() - currentTimeMillis);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onFirstScreenImagePaintFinished(WebView webView, FirstScreenImageInfomation firstScreenImageInfomation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048588, this, webView, firstScreenImageInfomation) == null) {
                this.f33051b.perfLog(webView, "BdWebViewClientProxy.onFirstScreenImagePaintFinished");
                if (this.f33051b.mWebViewExt == null || this.f33051b.mWebViewExt.getWebViewClientExt() == null) {
                    return;
                }
                this.f33051b.perfLog(webView, "BdWebViewClientProxy.onFirstScreenImagePaintFinished 22");
                this.f33051b.mWebViewExt.getWebViewClientExt().onFirstScreenImagePaintFinished(this.f33051b, firstScreenImageInfomation);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onFirstScreenPaintFinished(WebView webView, String str, int i2, int i3, int i4, int i5, int i6, int i7) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{webView, str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)}) == null) {
                System.currentTimeMillis();
                this.f33051b.perfLog(webView, "onFirstScreenPaintFinished");
                super.onFirstScreenPaintFinished(webView, str, i2, i3, i4, i5, i6, i7);
                BdSailorWebViewClientExt.FirstScreenInfo firstScreenInfo = new BdSailorWebViewClientExt.FirstScreenInfo();
                firstScreenInfo.setDiffDomcompleteAndFspTime(i7);
                if (this.f33051b.mWebViewExt == null || this.f33051b.mWebViewExt.getWebViewClientExt() == null) {
                    return;
                }
                this.f33051b.perfLog(webView, "onFirstScreenPaintFinished 22");
                this.f33051b.mWebViewExt.getWebViewClientExt().onFirstScreenPaintFinishedExt(this.f33051b, str);
                this.f33051b.mWebViewExt.getWebViewClientExt().onFirstScreenPaintFinishedExt(this.f33051b, str, firstScreenInfo);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onFirstTextPaint(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048590, this, webView, str) == null) || this.f33051b.mWebViewExt == null || this.f33051b.mWebViewExt.getWebViewClientExt() == null) {
                return;
            }
            Log.i("WebViewClient", "FTPCallback onFirstTextPaintExt, aUrl : ".concat(String.valueOf(str)));
            this.f33051b.mWebViewExt.getWebViewClientExt().onFirstTextPaintExt(this.f33051b, str);
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onFormResubmission(WebView webView, Message message, Message message2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048591, this, webView, message, message2) == null) {
                if (this.f33051b.mWebViewClient != null) {
                    this.f33051b.mWebViewClient.onFormResubmission(this.f33051b, message, message2);
                } else {
                    super.onFormResubmission(webView, message, message2);
                }
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onFullScreenMode(WebView webView, boolean z, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{webView, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
                if (this.f33051b.mWebViewExt.getWebViewClientExt() != null) {
                    this.f33051b.mWebViewExt.getWebViewClientExt().onFullScreenModeExt(this.f33051b, z, i2, i3);
                } else {
                    super.onFullScreenMode(webView, z, i2, i3);
                }
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onGestureFlingEnded(WebView webView, int i2, int i3) {
            BdSailorWebViewClientExt webViewClientExt;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLII(1048593, this, webView, i2, i3) == null) && webView == this.f33051b.mCurrentWebView && (webViewClientExt = this.f33051b.getWebViewExt().getWebViewClientExt()) != null) {
                webViewClientExt.onGestureFlingEnded(this.f33051b, i2, i3);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onGestureScrollEnded(WebView webView, int i2, int i3) {
            BdSailorWebViewClientExt webViewClientExt;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLII(1048594, this, webView, i2, i3) == null) && webView == this.f33051b.mCurrentWebView && (webViewClientExt = this.f33051b.getWebViewExt().getWebViewClientExt()) != null) {
                webViewClientExt.onGestureScrollEnded(this.f33051b, i2, i3);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onGestureScrollStarted(WebView webView, int i2, int i3) {
            BdSailorWebViewClientExt webViewClientExt;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLII(1048595, this, webView, i2, i3) == null) && webView == this.f33051b.mCurrentWebView && (webViewClientExt = this.f33051b.getWebViewExt().getWebViewClientExt()) != null) {
                webViewClientExt.onGestureScrollStarted(this.f33051b, i2, i3);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final String onGetErrorContent(WebView webView, int i2, String str, String str2) {
            InterceptResult invokeLILL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLILL = interceptable.invokeLILL(1048596, this, webView, i2, str, str2)) == null) {
                String onGetErrorHtmlExt = (!(webView instanceof WebView) || this.f33051b.isDestroyed() || this.f33051b.mWebViewExt == null || this.f33051b.mWebViewExt.getWebViewClientExt() == null) ? null : this.f33051b.mWebViewExt.getWebViewClientExt().onGetErrorHtmlExt(this.f33051b, i2, str, str2);
                return onGetErrorHtmlExt != null ? onGetErrorHtmlExt : BdSailorPlatform.getDefaultErrorPageHtml(webView.getContext());
            }
            return (String) invokeLILL.objValue;
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onGoBackOrForward(WebView webView, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048597, this, webView, i2) == null) && webView == this.f33051b.mCurrentWebView) {
                this.f33051b.goBackOrForward(i2);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onGoBackOrForwardAnimationFinish(WebView webView, int i2) {
            BdSailorWebViewClientExt webViewClientExt;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048598, this, webView, i2) == null) && webView == this.f33051b.mCurrentWebView && (webViewClientExt = this.f33051b.getWebViewExt().getWebViewClientExt()) != null) {
                webViewClientExt.onGoBackOrForwardAnimationFinish(this.f33051b, i2);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onGoBackOrForwardAnimationStart(WebView webView, int i2) {
            BdSailorWebViewClientExt webViewClientExt;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048599, this, webView, i2) == null) && webView == this.f33051b.mCurrentWebView && (webViewClientExt = this.f33051b.getWebViewExt().getWebViewClientExt()) != null) {
                webViewClientExt.onGoBackOrForwardAnimationStart(this.f33051b, i2);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onGotNotResponse(WebView webView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048600, this, webView) == null) {
                if (this.f33051b.mWebViewExt.getWebViewClientExt() != null) {
                    this.f33051b.mWebViewExt.getWebViewClientExt().onGotNotResponse(this.f33051b);
                } else {
                    super.onGotNotResponse(webView);
                }
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onHandleBackForwardBeyondHistory(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
                Log.i("WebViewClient", "BeeFrame onHandleBackForwardBeyondHistory: offset=".concat(String.valueOf(i2)));
                if (this.f33051b.mWebViewExt.getWebViewClientExt() != null) {
                    this.f33051b.mWebViewExt.getWebViewClientExt().onHandleBackForwardBeyondHistory(i2);
                } else {
                    super.onHandleBackForwardBeyondHistory(i2);
                }
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onHasVideo(WebView webView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048602, this, webView) == null) {
                if (this.f33051b.mWebViewExt.getWebViewClientExt() != null) {
                    this.f33051b.mWebViewExt.getWebViewClientExt().onHasVideoExt(this.f33051b);
                } else {
                    super.onHasVideo(webView);
                }
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onHideSoftKeyboard(WebView webView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048603, this, webView) == null) {
                if (this.f33051b.mWebViewExt.getWebViewClientExt() != null) {
                    this.f33051b.mWebViewExt.getWebViewClientExt().onHideSoftKeyboardExt(this.f33051b);
                } else {
                    super.onHideSoftKeyboard(webView);
                }
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onJsCodeCacheFinished(JsCodeCacheResult jsCodeCacheResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048604, this, jsCodeCacheResult) == null) {
                Log.i("WebViewClient", "[zhh] CodeCache. businessId = %s, jsPath = %s, isCacheUsed = %b", jsCodeCacheResult.businessId, jsCodeCacheResult.jsPath, Boolean.valueOf(jsCodeCacheResult.isCacheUsed));
                if (this.f33051b.mWebViewExt.getWebViewClientExt() != null) {
                    this.f33051b.mWebViewExt.getWebViewClientExt().onJsCodeCacheFinished(jsCodeCacheResult);
                } else {
                    super.onJsCodeCacheFinished(jsCodeCacheResult);
                }
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onKeywordExtension(WebView webView, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048605, this, webView, str, str2) == null) {
                if (this.f33051b.mWebViewExt.getWebViewClientExt() != null ? this.f33051b.mWebViewExt.getWebViewClientExt().onKeywordExtensionExt(this.f33051b, str, str2) : false) {
                    return;
                }
                super.onKeywordExtension(webView, str, str2);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onLoadResource(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048606, this, webView, str) == null) {
                if (this.f33051b.mWebViewClient != null) {
                    this.f33051b.mWebViewClient.onLoadResource(this.f33051b, str);
                } else {
                    super.onLoadResource(webView, str);
                }
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onMagicFilterHideElement(WebView webView, String str, int i2, int i3, int i4, int i5, int i6) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048607, this, new Object[]{webView, str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) {
                super.onMagicFilterHideElement(webView, str, i2, i3, i4, i5, i6);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onMainResourceHttpcodeDid(WebView webView, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048608, this, webView, i2, str) == null) {
                super.onMainResourceHttpcodeDid(webView, i2, str);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onMainResourceResponseDid(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048609, this, webView, str) == null) {
                super.onMainResourceResponseDid(webView, str);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onNavigationAnimationFinish(WebView webView, boolean z, boolean z2) {
            BdSailorWebViewClientExt webViewClientExt;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048610, this, new Object[]{webView, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && webView == this.f33051b.mCurrentWebView && (webViewClientExt = this.f33051b.getWebViewExt().getWebViewClientExt()) != null) {
                webViewClientExt.onNavigationAnimationFinish(this.f33051b, z, z2);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onNavigationAnimationStart(WebView webView, boolean z) {
            BdSailorWebViewClientExt webViewClientExt;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048611, this, webView, z) == null) && webView == this.f33051b.mCurrentWebView && (webViewClientExt = this.f33051b.getWebViewExt().getWebViewClientExt()) != null) {
                webViewClientExt.onNavigationAnimationStart(this.f33051b, z);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onNewHistoryItem(WebView webView, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048612, this, webView, str, i2) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                if (this.f33051b.mWebViewExt != null && this.f33051b.mWebViewExt.getWebViewClientExt() != null) {
                    this.f33051b.mWebViewExt.getWebViewClientExt().onNewPage(this.f33051b);
                }
                SessionMonitorEngine.getInstance().onPageKeySectionTimeCost(webView, str, MonitorConstant.KeySectionType.NEW_HISTORY_ITEM.ordinal(), System.currentTimeMillis() - currentTimeMillis);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onNotifyVideoInfo(VideoSniffingInfo videoSniffingInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048613, this, videoSniffingInfo) == null) {
                Log.i("parse-video", "BdSailorWebView onNotifyVideoInfo video info:  url= " + videoSniffingInfo.GetSourceUrl() + " cookies= " + videoSniffingInfo.GetCookie() + " userAgent= " + videoSniffingInfo.GetUserAgent() + " referrer= " + videoSniffingInfo.GetReferrer() + " poster url= " + videoSniffingInfo.GetPosterImageUrl() + " page title= " + videoSniffingInfo.GetPageTitle() + " page url= " + videoSniffingInfo.GetPageUrl());
                if (this.f33051b.mWebViewExt.getWebViewClientExt() != null) {
                    this.f33051b.mWebViewExt.getWebViewClientExt().onNotifyVideoInfo(videoSniffingInfo);
                } else {
                    super.onNotifyVideoInfo(videoSniffingInfo);
                }
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onPageCanBeScaled(WebView webView, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048614, this, webView, z) == null) {
                if (this.f33051b.mWebViewExt == null || this.f33051b.mWebViewExt.getWebViewClientExt() == null) {
                    super.onPageCanBeScaled(webView, z);
                } else {
                    this.f33051b.mWebViewExt.getWebViewClientExt().onPageCanBeScaledExt(this.f33051b, z);
                }
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onPageCommitVisible(WebView webView, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(1048615, this, webView, str, z) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                super.onPageCommitVisible(webView, str, z);
                if (this.f33051b.mWebViewClient != null) {
                    this.f33051b.mWebViewClient.onPageCommitVisible(this.f33051b, str);
                }
                SessionMonitorEngine.getInstance().onPageKeySectionTimeCost(webView, str, MonitorConstant.KeySectionType.PAGE_COMMIT_VISIBLE.ordinal(), System.currentTimeMillis() - currentTimeMillis);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048616, this, webView, str) == null) {
                this.f33051b.perfLog(webView, "onPageFinished");
                long currentTimeMillis = System.currentTimeMillis();
                super.onPageFinished(webView, str);
                if (this.f33051b.mWebViewClient != null) {
                    this.f33051b.mWebViewClient.onPageFinished(this.f33051b, str);
                }
                if (webView == this.f33051b.mCurrentWebView) {
                    this.f33051b.mIsPageLoading = false;
                }
                SessionMonitorEngine.getInstance().onPageKeySectionTimeCost(webView, str, MonitorConstant.KeySectionType.PAGEFINISH.ordinal(), System.currentTimeMillis() - currentTimeMillis);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048617, this, webView, str, bitmap) == null) {
                this.f33051b.perfLog(webView, "onPageStarted");
                long currentTimeMillis = System.currentTimeMillis();
                super.onPageStarted(webView, str, bitmap);
                if (this.f33051b.mWebViewClient != null) {
                    this.f33051b.mWebViewClient.onPageStarted(this.f33051b, str, bitmap);
                }
                SessionMonitorEngine.getInstance().onPageKeySectionTimeCost(webView, str, MonitorConstant.KeySectionType.PAGESTART.ordinal(), System.currentTimeMillis() - currentTimeMillis);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onPageSwitching(WebView webView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048618, this, webView) == null) {
                if (this.f33051b.isAutoShowTitlebar()) {
                    this.f33051b.showEmbeddedTitleBar(false);
                }
                super.onPageSwitching(webView);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onPausePlugin() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
                if (this.f33051b.mWebViewExt.getWebViewClientExt() != null) {
                    this.f33051b.mWebViewExt.getWebViewClientExt().onPausePluginExt(this.f33051b);
                } else {
                    super.onPausePlugin();
                }
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onPlayPlugin() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
                if (this.f33051b.mWebViewExt.getWebViewClientExt() != null) {
                    this.f33051b.mWebViewExt.getWebViewClientExt().onPlayPluginExt(this.f33051b);
                } else {
                    super.onPlayPlugin();
                }
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onPreloadUrlFound(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048621, this, webView, str) == null) {
                super.onPreloadUrlFound(webView, str);
                if (this.f33051b.mWebViewExt == null || this.f33051b.mWebViewExt.getWebViewClientExt() == null) {
                    super.onPreloadUrlFound(webView, str);
                } else {
                    this.f33051b.mWebViewExt.getWebViewClientExt().onPreloadUrlFoundExt(this.f33051b, str);
                }
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onProceededAfterSslError(WebView webView, SslError sslError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048622, this, webView, sslError) == null) {
                if (this.f33051b.mWebViewExt.getWebViewClientExt() != null) {
                    this.f33051b.mWebViewExt.getWebViewClientExt().onProceededAfterSslErrorExt(this.f33051b, sslError);
                } else {
                    super.onProceededAfterSslError(webView, sslError);
                }
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final String onProcessWebSearchUrl(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048623, this, webView, str)) == null) ? (this.f33051b.mWebViewExt == null || this.f33051b.mWebViewExt.getWebViewClientExt() == null) ? super.onProcessWebSearchUrl(webView, str) : this.f33051b.mWebViewExt.getWebViewClientExt().onProcessWebSearchUrl(this.f33051b, str) : (String) invokeLL.objValue;
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onReceivedClientCertRequest(WebView webView, ClientCertRequest clientCertRequest) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048624, this, webView, clientCertRequest) == null) {
                if (this.f33051b.mWebViewClient != null) {
                    this.f33051b.mWebViewClient.onReceivedClientCertRequest(this.f33051b, clientCertRequest);
                } else {
                    super.onReceivedClientCertRequest(webView, clientCertRequest);
                }
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onReceivedError(WebView webView, int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048625, this, webView, i2, str, str2) == null) {
                super.onReceivedError(webView, i2, str, str2);
                if (this.f33051b.mWebViewClient != null) {
                    this.f33051b.mWebViewClient.onReceivedError(this.f33051b, i2, str, str2);
                }
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048626, this, webView, webResourceRequest, webResourceError) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                if (this.f33051b.mWebViewClient != null) {
                    if (webResourceRequest.isForMainFrame() && (webResourceRequest.getUrl().toString().startsWith("http://") || webResourceRequest.getUrl().toString().startsWith("https://"))) {
                        this.f33051b.mWebViewClient.onReceivedError(this.f33051b, webResourceError.getErrorCode(), webResourceError.getDescription().toString(), webResourceRequest.getUrl().toString());
                    }
                    this.f33051b.mWebViewClient.onReceivedError(this.f33051b, webResourceRequest, webResourceError);
                }
                SessionMonitorEngine.getInstance().onPageKeySectionTimeCost(webView, webView.getUrl(), MonitorConstant.KeySectionType.RECEIVED_ERROR.ordinal(), System.currentTimeMillis() - currentTimeMillis);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048627, this, webView, httpAuthHandler, str, str2) == null) {
                if (this.f33051b.mWebViewClient != null) {
                    this.f33051b.mWebViewClient.onReceivedHttpAuthRequest(this.f33051b, httpAuthHandler, str, str2);
                } else {
                    super.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
                }
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048628, this, webView, webResourceRequest, webResourceResponse) == null) {
                if (this.f33051b.mWebViewClient != null) {
                    this.f33051b.mWebViewClient.onReceivedHttpError(this.f33051b, webResourceRequest, webResourceResponse);
                } else {
                    super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                }
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048629, this, webView, str, str2, str3) == null) {
                if (this.f33051b.mWebViewClient != null) {
                    this.f33051b.mWebViewClient.onReceivedLoginRequest(this.f33051b, str, str2, str3);
                } else {
                    super.onReceivedLoginRequest(webView, str, str2, str3);
                }
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048630, this, webView, sslErrorHandler, sslError) == null) {
                com.baidu.browser.sailor.feature.a featureByName = BdSailorPlatform.getInstance().getFeatureByName(BdSailorConfig.SAILOR_BASE_SSL);
                if (featureByName != null && featureByName.isEnable()) {
                    super.onReceivedSslError(webView, sslErrorHandler, sslError);
                } else if (this.f33051b.mWebViewClient != null) {
                    this.f33051b.mWebViewClient.onReceivedSslError(this.f33051b, sslErrorHandler, sslError);
                }
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048631, this, webView, renderProcessGoneDetail)) == null) ? this.f33051b.mWebViewClient != null ? this.f33051b.mWebViewClient.onRenderProcessGone(this.f33051b, renderProcessGoneDetail) : super.onRenderProcessGone(webView, renderProcessGoneDetail) : invokeLL.booleanValue;
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onResourceLoaded(WebView webView, String str, long j2, String str2, String str3, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048632, this, new Object[]{webView, str, Long.valueOf(j2), str2, str3, Integer.valueOf(i2)}) == null) {
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onRestoreFromCache(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048633, this, webView, str) == null) {
                if (this.f33051b.mWebViewExt.getWebViewClientExt() == null) {
                    super.onRestoreFromCache(webView, str);
                    return;
                }
                this.f33051b.mWebViewExt.getWebViewClientExt().onRestoreFromPageCacheDid(this.f33051b, str);
                this.f33051b.mWebViewExt.getWebViewClientExt().onRestoreFromCache(this.f33051b, str);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onRestoreFromPageCacheDid(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048634, this, webView, str) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                if (this.f33051b.mWebViewExt.getWebViewClientExt() != null) {
                    this.f33051b.mWebViewExt.getWebViewClientExt().onRestoreFromPageCacheDid(this.f33051b, str);
                } else {
                    super.onRestoreFromPageCacheDid(webView, str);
                }
                SessionMonitorEngine.getInstance().onPageKeySectionTimeCost(webView, str, MonitorConstant.KeySectionType.RESTORE_FROM_CACHE.ordinal(), System.currentTimeMillis() - currentTimeMillis);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onResumePlugin() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048635, this) == null) {
                if (this.f33051b.mWebViewExt.getWebViewClientExt() != null) {
                    this.f33051b.mWebViewExt.getWebViewClientExt().onResumePluginExt(this.f33051b);
                } else {
                    super.onResumePlugin();
                }
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onScaleChanged(WebView webView, float f2, float f3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048636, this, new Object[]{webView, Float.valueOf(f2), Float.valueOf(f3)}) == null) {
                if (this.f33051b.mWebViewClient != null) {
                    this.f33051b.mWebViewClient.onScaleChanged(this.f33051b, f2, f3);
                } else {
                    super.onScaleChanged(webView, f2, f3);
                }
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onSearchLandingPageClicked(WebView webView, String str, String str2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048637, this, new Object[]{webView, str, str2, Long.valueOf(j2)}) == null) {
                super.onSearchLandingPageClicked(webView, str, str2, j2);
                if (this.f33051b.mWebViewExt == null || this.f33051b.mWebViewExt.getWebViewClientExt() == null) {
                    return;
                }
                this.f33051b.mWebViewExt.getWebViewClientExt().onSearchLandingPageClicked(this.f33051b, str, str2, j2);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onSecurityCheckResult(WebView webView, String str, WebViewClient.SecurityInfo securityInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048638, this, webView, str, securityInfo) == null) {
                if (this.f33051b.mWebViewExt.getWebViewClientExt() != null) {
                    this.f33051b.mWebViewExt.getWebViewClientExt().onSecurityCheckResultExt(this.f33051b, str, securityInfo);
                }
                super.onSecurityCheckResult(webView, str, securityInfo);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onStartFirstNavigation(WebView webView, String str, boolean z, boolean z2, boolean z3) {
            BdSailorWebViewClientExt webViewClientExt;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048639, this, new Object[]{webView, str, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) && webView == this.f33051b.mCurrentWebView && (webViewClientExt = this.f33051b.getWebViewExt().getWebViewClientExt()) != null) {
                webViewClientExt.onStartFirstNavigation(this.f33051b, str, z, z2, z3);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final boolean onSubFrameBeforeRequest(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048640, this, webView, str)) == null) {
                if (!(webView instanceof WebView) || this.f33051b.isDestroyed() || this.f33051b.mWebViewExt == null || this.f33051b.mWebViewExt.getWebViewClientExt() == null) {
                    return false;
                }
                return this.f33051b.mWebViewExt.getWebViewClientExt().onSubFrameBeforeRequest(this.f33051b, str);
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onSubjectsCollected(WebView webView, boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048641, this, new Object[]{webView, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
                if (this.f33051b.mWebViewExt.getWebViewClientExt() != null) {
                    this.f33051b.mWebViewExt.getWebViewClientExt().onSubjectsCollectedExt(this.f33051b, z, i2);
                } else {
                    super.onSubjectsCollected(webView, z, i2);
                }
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final boolean onSupportsForceZoomScale(WebView webView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048642, this, webView)) == null) ? this.f33051b.mWebViewExt.getWebViewClientExt() != null ? this.f33051b.mWebViewExt.getWebViewClientExt().onSupportsForceZoomScale(this.f33051b) : super.onSupportsForceZoomScale(webView) : invokeL.booleanValue;
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final boolean onTextCopied(WebView webView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048643, this, webView)) == null) {
                if (this.f33051b.mWebViewExt.getWebViewClientExt() != null) {
                    this.f33051b.mWebViewExt.getWebViewClientExt().onTextCopiedExt(this.f33051b);
                }
                return super.onTextCopied(webView);
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048644, this, webView, keyEvent) == null) {
                if (this.f33051b.mWebViewClient != null) {
                    this.f33051b.mWebViewClient.onUnhandledKeyEvent(this.f33051b, keyEvent);
                } else {
                    super.onUnhandledKeyEvent(webView, keyEvent);
                }
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void onUpdateTextFieldNextPreStatus(WebView webView, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048645, this, new Object[]{webView, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || this.f33051b.mWebViewExt.getWebViewClientExt() == null) {
                return;
            }
            this.f33051b.mWebViewExt.getWebViewClientExt().onUpdateTextFieldNextPreStatus(this.f33051b, z, z2);
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048646, this, webView, webResourceRequest)) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                WebResourceResponse shouldInterceptRequest = this.f33051b.mWebViewClient != null ? this.f33051b.mWebViewClient.shouldInterceptRequest(this.f33051b, webResourceRequest) : null;
                if (shouldInterceptRequest == null) {
                    shouldInterceptRequest = shouldInterceptRequest(webView, webResourceRequest.getUrl().toString());
                }
                SessionMonitorEngine.getInstance().onPageKeySectionTimeCost(webView, webResourceRequest.getUrl().toString(), MonitorConstant.KeySectionType.SHOULD_INTERCEPT_REQUEST.ordinal(), System.currentTimeMillis() - currentTimeMillis);
                return shouldInterceptRequest;
            }
            return (WebResourceResponse) invokeLL.objValue;
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048647, this, webView, str)) == null) {
                WebResourceResponse shouldInterceptRequest = super.shouldInterceptRequest(webView, str);
                return (shouldInterceptRequest == null && this.f33051b.mWebViewClient != null) ? this.f33051b.mWebViewClient.shouldInterceptRequest(this.f33051b, str) : shouldInterceptRequest;
            }
            return (WebResourceResponse) invokeLL.objValue;
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final boolean shouldKeywordExtension(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048648, this, webView, str)) == null) ? this.f33051b.mWebViewExt.getWebViewClientExt() != null ? this.f33051b.mWebViewExt.getWebViewClientExt().shouldKeywordExtensionExt(this.f33051b, str) : super.shouldKeywordExtension(webView, str) : invokeLL.booleanValue;
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final boolean shouldOpenFlash(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048649, this, webView, str)) == null) {
                if (this.f33051b.mWebViewExt.getWebViewClientExt() != null) {
                    this.f33051b.mWebViewExt.getWebViewClientExt().shouldOpenFlashExt(this.f33051b, str);
                }
                return super.shouldOpenFlash(webView, str);
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048650, this, webView, keyEvent)) == null) ? this.f33051b.mWebViewClient != null ? this.f33051b.mWebViewClient.shouldOverrideKeyEvent(this.f33051b, keyEvent) : super.shouldOverrideKeyEvent(webView, keyEvent) : invokeLL.booleanValue;
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final boolean shouldOverrideSpecialUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048651, this, webView, str)) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                boolean shouldOverrideUrlLoading = this.f33051b.mWebViewClient != null ? this.f33051b.mWebViewClient.shouldOverrideUrlLoading(this.f33051b, str) : false;
                SessionMonitorEngine.getInstance().onPageKeySectionTimeCost(webView, str, MonitorConstant.KeySectionType.SHOULD_SPECIAL_LOADING.ordinal(), System.currentTimeMillis() - currentTimeMillis);
                return shouldOverrideUrlLoading;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048652, this, webView, webResourceRequest)) == null) {
                this.f33051b.perfLog(webView, "shouldOverrideUrlLoading");
                long currentTimeMillis = System.currentTimeMillis();
                String uri = webResourceRequest.getUrl().toString();
                webView.getSecureProcessor().a(uri);
                int i2 = 0;
                boolean shouldOverrideUrlLoading = this.f33051b.mWebViewClient != null ? this.f33051b.mWebViewClient.shouldOverrideUrlLoading(this.f33051b, webResourceRequest) : false;
                if (!shouldOverrideUrlLoading) {
                    shouldOverrideUrlLoading = super.shouldOverrideUrlLoading(webView, webResourceRequest);
                }
                if (!shouldOverrideUrlLoading) {
                    shouldOverrideUrlLoading = shouldOverrideUrlLoading(webView, uri);
                }
                if (shouldOverrideUrlLoading && !TextUtils.isEmpty(uri)) {
                    String[] strArr = this.a;
                    int length = strArr.length;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        } else if (uri.startsWith(strArr[i2])) {
                            Log.d("// BdSailorMonitorEngine", "BdWebViewClientProxy.shouldoverridetel handled by external-->onTelRequest ,url=".concat(String.valueOf(uri)));
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
                SessionMonitorEngine.getInstance().onPageKeySectionTimeCost(webView, uri, MonitorConstant.KeySectionType.SHOULD_OVERRIDE_URL_LOADING.ordinal(), System.currentTimeMillis() - currentTimeMillis);
                return shouldOverrideUrlLoading;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048653, this, webView, str)) == null) {
                boolean shouldOverrideUrlLoading = this.f33051b.mWebViewClient != null ? this.f33051b.mWebViewClient.shouldOverrideUrlLoading(this.f33051b, str) : false;
                return !shouldOverrideUrlLoading ? super.shouldOverrideUrlLoading(webView, str) : shouldOverrideUrlLoading;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.webkit.sdk.WebViewClient
        public final void shouldPageRollBack(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048654, this, webView, str) == null) {
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class g extends FrameLayout {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            setBackgroundColor(context.getResources().getColor(context.getResources().getIdentifier("sailor_common_black", "color", context.getPackageName())));
        }

        @Override // android.view.View
        public final boolean onTouchEvent(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes10.dex */
    public class h extends WebViewDelegate {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdSailorWebView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(BdSailorWebView bdSailorWebView, WebView webView) {
            super(webView);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdSailorWebView, webView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((WebView) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdSailorWebView;
        }

        @Override // com.baidu.webkit.sdk.WebViewDelegate
        public final boolean canGoBack() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a.canGoBack() : invokeV.booleanValue;
        }

        @Override // com.baidu.webkit.sdk.WebViewDelegate
        public final boolean canGoBackOrForward(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? this.a.canGoBackOrForward(i2) : invokeI.booleanValue;
        }

        @Override // com.baidu.webkit.sdk.WebViewDelegate
        public final boolean canGoForward() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a.canGoForward() : invokeV.booleanValue;
        }

        @Override // com.baidu.webkit.sdk.WebViewDelegate
        public final View getCurrentTitleBar() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a.getCurrentTitleBar() : (View) invokeV.objValue;
        }

        @Override // com.baidu.webkit.sdk.WebViewDelegate
        public final View getEmbeddedTitlebar() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a.getEmbeddedTitlebar() : (View) invokeV.objValue;
        }

        @Override // com.baidu.webkit.sdk.WebViewDelegate
        public final View getLandingPageTitleBar() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a.getLandingPageTitleBar() : (View) invokeV.objValue;
        }

        @Override // com.baidu.webkit.sdk.WebViewDelegate
        public final View getSearchResultTitleBar() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.a.getSearchResultTitleBar() : (View) invokeV.objValue;
        }

        @Override // com.baidu.webkit.sdk.WebViewDelegate
        public final int getTitlebarHeight() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.a.getTitlebarHeight() : invokeV.intValue;
        }

        @Override // com.baidu.webkit.sdk.WebViewDelegate
        public final void goBack() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                this.a.goBack();
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewDelegate
        public final void goBackOrForward(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
                this.a.goBackOrForward(i2);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewDelegate
        public final void goForward() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
                this.a.goForward();
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewDelegate
        public final boolean isTitlebarCanShow() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.a.isTitlebarCanShow() : invokeV.booleanValue;
        }

        @Override // com.baidu.webkit.sdk.WebViewDelegate
        public final boolean isTitlebarShowing() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.a.isTitlebarShowing() : invokeV.booleanValue;
        }

        @Override // com.baidu.webkit.sdk.WebViewDelegate
        public final void onOverScrolled(int i2, int i3, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                this.a.onOverScrolled(i2, i3, z, z2);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewDelegate
        public final void onScrollChanged(int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIII(1048590, this, i2, i3, i4, i5) == null) {
                this.a.onScrollChanged(i2, i3, i4, i5);
            }
        }

        @Override // com.baidu.webkit.sdk.WebViewDelegate
        public final boolean onTouchEvent(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, motionEvent)) == null) ? this.a.onTouchEvent(motionEvent) : invokeL.booleanValue;
        }

        @Override // com.baidu.webkit.sdk.WebViewDelegate
        public final void setCurrentTitleBar(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
                this.a.setCurrentTitleBar(z);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(206572126, "Lcom/baidu/browser/sailor/BdSailorWebView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(206572126, "Lcom/baidu/browser/sailor/BdSailorWebView;");
                return;
            }
        }
        LOG_TAG = BdSailorWebView.class.getSimpleName();
        COVER_SCREEN_PARAMS = new FrameLayout.LayoutParams(-1, -1);
        sInitFirstWebView = true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdSailorWebView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mCurrentWebView = new WebView(context);
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdSailorWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mCurrentWebView = new WebView(context, attributeSet);
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdSailorWebView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.mCurrentWebView = new WebView(context, attributeSet, i2);
        init();
    }

    public static void addToWebCache(String str, Map<String, String> map, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65559, null, str, map, z) == null) {
            WebView.addToWebCache(str, map, z);
        }
    }

    public static void addToWebCache(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65560, null, str, z) == null) {
            WebView.addToWebCache(str, z);
        }
    }

    public static void addToWebCache(String str, boolean z, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65561, null, new Object[]{str, Boolean.valueOf(z), map}) == null) {
            WebView.addToWebCache(str, z, map);
        }
    }

    public static void addToWebCache(String str, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65562, null, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            WebView.addToWebCache(str, z, z2);
        }
    }

    public static void addToWebCache(String str, boolean z, boolean z2, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65563, null, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2), map}) == null) {
            WebView.addToWebCache(str, z, z2, map);
        }
    }

    private void addWebView(WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65564, this, webView) == null) {
            addWebView(webView, -1);
        }
    }

    private void addWebView(WebView webView, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65565, this, webView, i2) == null) && webView.getParent() == null) {
            h hVar = new h(this, webView);
            this.mViewDelegate = hVar;
            webView.setViewDelegate(hVar);
            if (c.a.k.b.c.b.c() && BdZeusUtil.isWebkitLoaded()) {
                return;
            }
            getWebViewContainer().addView(webView, i2, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    private void bringStatusBarToFront() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65566, this) == null) || !c.a.k.b.c.b.c() || (view = this.mStatusBar) == null || indexOfChild(view) < 0) {
            return;
        }
        bringChildToFront(this.mStatusBar);
    }

    public static void cancelPreload(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65567, null, str) == null) {
        }
    }

    private void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65568, this) == null) {
            checkInit();
            this.mWebSettings = new BdSailorWebSettings(this.mCurrentWebView.getSettings());
            this.mWebViewExt = new BdSailorWebViewExt(this, null);
            this.mWebViewLayer = new FrameLayout(this.mCurrentWebView.getContext());
            this.mWebViewLayerLp = new FrameLayout.LayoutParams(-1, -1);
            if (!c.a.k.b.c.b.c() || !BdZeusUtil.isWebkitLoaded()) {
                addView(this.mWebViewLayer, this.mWebViewLayerLp);
            }
            initWebView(this.mCurrentWebView);
            addWebView(this.mCurrentWebView);
            setFocusableInTouchMode(true);
            if (BdSailor.getInstance().getSailorClient() != null) {
                BdSailor.getInstance().getSailorClient().updateSearchUrlProtocol(getContext(), true);
            }
            this.mCurrentWebView.setWebViewPagerContainer(this);
            Log.i(LOG_TAG, "setNetworkAvailable1");
            if (!ABTestSDK.isZeusNetworkChangeNotifierEnabled()) {
                Log.i(LOG_TAG, "setNetworkAvailable2");
                setNetworkAvailable(NetWorkUtils.getIsOnline());
            }
            if (sInitFirstWebView) {
                Log.i(GlobalConstants.LOG_PER_TAG, " timing = \n" + ZeusPerformanceTiming.getWebViewInitTiming());
                sInitFirstWebView = false;
            }
            ZeusPerformanceTiming.recordWebkitInitStatistics(1);
        }
    }

    private void initWebView(WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65569, this, webView) == null) {
            webView.setWebChromeClient(new e(this));
            webView.setWebViewClient(new f(this, (byte) 0));
            webView.setPictureListener(new c(this, (byte) 0));
            webView.setDownloadListener(new d(this, webView));
            webView.setWebBackForwardListClient(new b(this, webView));
            webView.setVideoPlayerFactory(this.mVideoFactory);
        }
    }

    public static boolean isInWebCache(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65570, null, str)) == null) ? WebView.isInWebCache(str) : invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void perfLog(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65571, this, webView, str) == null) {
            perfLog(webView, str, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void perfLog(WebView webView, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65572, this, webView, str, str2) == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void perfLog(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65573, this, str, str2) == null) {
        }
    }

    public static void removeFromWebCache(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65574, null, str) == null) {
            WebView.removeFromWebCache(str);
        }
    }

    private void removeWebView(WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65575, this, webView) == null) {
            try {
                if (c.a.k.b.c.b.c() && BdZeusUtil.isWebkitLoaded()) {
                    webView.getWebViewPager().removeView(webView);
                } else {
                    getWebViewContainer().removeView(webView);
                }
            } catch (Exception unused) {
            }
        }
    }

    private void setSearchBarTopMargin() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65576, this) == null) && c.a.k.b.c.b.c()) {
            setViewTopMargin(this.mSearchResultTitleBar, this.mStatusBarHeight);
            setViewTopMargin(this.mLandingPageTitleBar, this.mStatusBarHeight);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTopControlsHeight(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65577, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            this.mCurrentWebView.setTopControlsHeight(i2, z);
        }
    }

    private void setViewSize(View view, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(65578, this, view, i2, i3) == null) || view == null) {
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
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65579, this, view, i2) == null) || view == null) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(65580, this, i2, i3, i4, i5) == null) {
            this.mWebViewLayerLp.setMargins(i2, i3, i4, i5);
            this.mWebViewLayer.setLayoutParams(this.mWebViewLayerLp);
            onWebViewLayerMarginChanged(i2, i3, i4, i5);
            this.mWebViewLayer.invalidate();
            this.mCurrentWebView.setWebViewMargin(i2, i3, i4, i5);
        }
    }

    public void addJavascriptInterface(Object obj, String str) {
        WebView webView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, obj, str) == null) || (webView = this.mCurrentWebView) == null) {
            return;
        }
        webView.addJavascriptInterface(obj, str);
    }

    public void addJavascriptInterfaceExt(IJsAbility iJsAbility, String str) {
        WebView webView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iJsAbility, str) == null) || (webView = this.mCurrentWebView) == null) {
            return;
        }
        webView.addJavascriptInterfaceExt(iJsAbility, str);
    }

    public void addWebMessageListener(WebMessageListener webMessageListener, String str, String[] strArr) {
        WebView webView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webMessageListener, str, strArr) == null) || (webView = this.mCurrentWebView) == null) {
            return;
        }
        webView.addWebMessageListener(webMessageListener, str, strArr);
    }

    public boolean canGoBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mCurrentWebView.canGoBack() : invokeV.booleanValue;
    }

    public boolean canGoBackOrForward(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? this.mCurrentWebView.canGoBackOrForward(i2) : invokeI.booleanValue;
    }

    public boolean canGoForward() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mCurrentWebView.canGoForward() : invokeV.booleanValue;
    }

    public boolean canZoomIn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mCurrentWebView.canZoomIn() : invokeV.booleanValue;
    }

    public boolean canZoomOut() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mCurrentWebView.canZoomOut() : invokeV.booleanValue;
    }

    public Bitmap captureBitmap() {
        InterceptResult invokeV;
        Bitmap captureBitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
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
        return (Bitmap) invokeV.objValue;
    }

    public Bitmap captureBitmap(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048585, this, i2, i3)) == null) ? this.mCurrentWebView.captureBitmap(i2, i3) : (Bitmap) invokeII.objValue;
    }

    public Picture capturePicture() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mCurrentWebView.capturePicture() : (Picture) invokeV.objValue;
    }

    public void checkInit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (!BdSailor.getInstance().isInit()) {
                throw new RuntimeException("Must Call BdSailor.init(Context aContext, String aWorkspace) first!");
            }
            if (!BdSailorPlatform.getInstance().isWebkitInit()) {
                throw new RuntimeException("Must Call BdSailor.initWebkit(String aAppId, boolean aIsZeusIntegrate) first!");
            }
        }
    }

    public void clearCache(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.mCurrentWebView.clearCache(z);
        }
    }

    public void clearFormData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.mCurrentWebView.clearFormData();
        }
    }

    public void clearHistory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.mCurrentWebView.clearHistory();
        }
    }

    public void clearMatches() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.mCurrentWebView.clearMatches();
        }
    }

    public void clearSslPreferences() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.mCurrentWebView.clearSslPreferences();
        }
    }

    public void clearView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.mCurrentWebView.clearView();
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.mCurrentWebView.computeScroll();
        }
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.mCurrentWebView.computeVerticalScrollRange() : invokeV.intValue;
    }

    public BdSailorWebBackForwardList copyBackForwardList() {
        WebBackForwardList copyBackForwardList;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
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
        return (BdSailorWebBackForwardList) invokeV.objValue;
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            setDownloadListener(null);
            setEmbeddedTitleBar(null);
            this.mCurrentWebView.destroy();
        }
    }

    public void disableFeature(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
        }
    }

    public void disableMedia() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.mCurrentWebView.disableMedia();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, keyEvent)) == null) ? this.mCurrentWebView.dispatchKeyEvent(keyEvent) : invokeL.booleanValue;
    }

    public void doRealGoBack() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && canGoBack()) {
            this.mCurrentWebView.goBack();
            if (this.mWebViewExt.getWebViewClientExt() != null) {
                this.mWebViewExt.getWebViewClientExt().onPageBackOrForwardExt(this, -1);
            }
        }
    }

    public void doRealGoForward() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && canGoForward()) {
            this.mCurrentWebView.goForward();
            if (this.mWebViewExt.getWebViewClientExt() != null) {
                this.mWebViewExt.getWebViewClientExt().onPageBackOrForwardExt(this, 1);
            }
        }
    }

    public void documentHasImages(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, message) == null) {
            this.mCurrentWebView.documentHasImages(message);
        }
    }

    public void dumpInfo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
        }
    }

    public void emulateShiftHeld() {
        WebView webView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048605, this) == null) || (webView = this.mCurrentWebView) == null) {
            return;
        }
        webView.emulateShiftHeld();
    }

    public void enableFeature(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, str) == null) {
        }
    }

    public void enableMedia() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            this.mCurrentWebView.enableMedia();
        }
    }

    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        WebView webView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048608, this, str, valueCallback) == null) || (webView = this.mCurrentWebView) == null) {
            return;
        }
        webView.evaluateJavascript(str, valueCallback);
    }

    public void evaluateJavascriptMethod(String str, String str2, String str3, ValueCallback<String> valueCallback) {
        WebView webView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048609, this, str, str2, str3, valueCallback) == null) || (webView = this.mCurrentWebView) == null) {
            return;
        }
        webView.evaluateJavascriptMethod(str, str2, str3, valueCallback);
    }

    public int findAll(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, str)) == null) ? this.mCurrentWebView.findAll(str) : invokeL.intValue;
    }

    public void findAllAsync(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, str) == null) {
            this.mCurrentWebView.findAllAsync(str);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public View findFocus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            WebView webView = this.mCurrentWebView;
            return webView != null ? webView.findFocus() : super.findFocus();
        }
        return (View) invokeV.objValue;
    }

    public void findNext(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z) == null) {
            this.mCurrentWebView.findNext(z);
        }
    }

    public void flingScroll(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048614, this, i2, i3) == null) {
            this.mCurrentWebView.flingScroll(i2, i3);
        }
    }

    public void freeMemory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            this.mCurrentWebView.freeMemory();
        }
    }

    public SslCertificate getCertificate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.mCurrentWebView.getCertificate() : (SslCertificate) invokeV.objValue;
    }

    public int getContentHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.mCurrentWebView.getContentHeight() : invokeV.intValue;
    }

    public int getContentWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.mCurrentWebView.getContentWidth() : invokeV.intValue;
    }

    public View getCurrentTitleBar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.mCurrentTitleBar : (View) invokeV.objValue;
    }

    public WebView getCurrentWebView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.mCurrentWebView : (WebView) invokeV.objValue;
    }

    public ISailorDownloadListener getDownloadListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.mDownloadListener : (ISailorDownloadListener) invokeV.objValue;
    }

    public View getEmbeddedTitlebar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.mEmbeddedTitlebar : (View) invokeV.objValue;
    }

    public Bitmap getFavicon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.mCurrentWebView.getFavicon() : (Bitmap) invokeV.objValue;
    }

    public ViewGroup getFunctionLayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            if (this.mFunctionViewLayer == null) {
                FrameLayout frameLayout = new FrameLayout(getContext());
                this.mFunctionViewLayer = frameLayout;
                addView(frameLayout);
            }
            return this.mFunctionViewLayer;
        }
        return (ViewGroup) invokeV.objValue;
    }

    @Override // android.view.View
    public Handler getHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            WebView webView = this.mCurrentWebView;
            return webView != null ? webView.getHandler() : super.getHandler();
        }
        return (Handler) invokeV.objValue;
    }

    public WebView.HitTestResult getHitTestResult() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? this.mCurrentWebView.getHitTestResult() : (WebView.HitTestResult) invokeV.objValue;
    }

    public String[] getHttpAuthUsernamePassword(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048627, this, str, str2)) == null) ? this.mCurrentWebView.getHttpAuthUsernamePassword(str, str2) : (String[]) invokeLL.objValue;
    }

    public View getLandingPageTitleBar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? this.mLandingPageTitleBar : (View) invokeV.objValue;
    }

    public String getOriginalUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? this.mCurrentWebView.getOriginalUrl() : (String) invokeV.objValue;
    }

    public int getOuterTitlebarHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? this.mOuterTitlebarHeightPix : invokeV.intValue;
    }

    public int getProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? this.mCurrentWebView.getProgress() : invokeV.intValue;
    }

    public boolean getRendererPriorityWaivedWhenNotVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            WebView webView = this.mCurrentWebView;
            if (webView != null) {
                return webView.getRendererPriorityWaivedWhenNotVisible();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public int getRendererRequestedPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            WebView webView = this.mCurrentWebView;
            if (webView != null) {
                return webView.getRendererRequestedPriority();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public float getScale() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) ? this.mCurrentWebView.getScale() : invokeV.floatValue;
    }

    public View getSearchResultTitleBar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) ? this.mSearchResultTitleBar : (View) invokeV.objValue;
    }

    public BdSailorWebSettings getSettings() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) ? this.mWebSettings : (BdSailorWebSettings) invokeV.objValue;
    }

    public ISailorWebSettingsExt getSettingsExt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) ? this.mWebViewExt.getSettingsExt() : (ISailorWebSettingsExt) invokeV.objValue;
    }

    public View getStatusBar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) ? this.mStatusBar : (View) invokeV.objValue;
    }

    public int getStatusBarHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) ? this.mStatusBarHeight : invokeV.intValue;
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) ? this.mCurrentWebView.getTitle() : (String) invokeV.objValue;
    }

    public int getTitlebarHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) ? this.mEmbeddedTitlebarHeightPix : invokeV.intValue;
    }

    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            WebView webView = this.mCurrentWebView;
            if (webView != null) {
                return webView.getUrl();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public void getWebAppShortcutData(WebAppShortcutDataListener webAppShortcutDataListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, webAppShortcutDataListener) == null) {
            Log.i("pwa", "bdsailorwebvew.getWebAppShortcutData");
            this.mCurrentWebView.getWebAppShortcutData(webAppShortcutDataListener);
        }
    }

    public void getWebAppShortcutData(WebAppShortcutDataListener webAppShortcutDataListener, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048644, this, webAppShortcutDataListener, z) == null) {
            Log.i("pwa", "bdsailorwebvew.getWebAppShortcutData");
            this.mCurrentWebView.getWebAppShortcutData(webAppShortcutDataListener, z);
        }
    }

    public BdSailorWebChromeClient getWebChromeClient() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) ? this.mWebChromeClient : (BdSailorWebChromeClient) invokeV.objValue;
    }

    public int[] getWebScrollXY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) {
            try {
                return new int[]{this.mCurrentWebView.getWebView().getScrollX(), this.mCurrentWebView.getWebView().getScrollY()};
            } catch (NullPointerException e2) {
                Log.printStackTrace(e2);
                return new int[]{0, 0};
            }
        }
        return (int[]) invokeV.objValue;
    }

    public BdSailorWebViewClient getWebViewClient() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) ? this.mWebViewClient : (BdSailorWebViewClient) invokeV.objValue;
    }

    public FrameLayout getWebViewContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) ? this.mWebViewLayer : (FrameLayout) invokeV.objValue;
    }

    public ISailorWebViewExt getWebViewExt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) ? this.mWebViewExt : (ISailorWebViewExt) invokeV.objValue;
    }

    public Looper getWebViewLooper() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) {
            WebView webView = this.mCurrentWebView;
            return webView != null ? webView.getWebViewLooper() : Looper.myLooper();
        }
        return (Looper) invokeV.objValue;
    }

    public void goBack() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048651, this) == null) && canGoBack()) {
            Log.d("bfanim", "BdSailorWebView.Back");
            doRealGoBack();
        }
    }

    public void goBackOrForward(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048652, this, i2) == null) && i2 != 0 && canGoBackOrForward(i2)) {
            this.mCurrentWebView.goBackOrForward(i2);
            if (this.mWebViewExt.getWebViewClientExt() != null) {
                this.mWebViewExt.getWebViewClientExt().onPageBackOrForwardExt(this, i2);
            }
        }
    }

    public void goForward() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048653, this) == null) && canGoForward()) {
            doRealGoForward();
        }
    }

    public void goNextOrPreTextField(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048654, this, z) == null) {
        }
    }

    public boolean hasCustomView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) ? this.mCustomView != null : invokeV.booleanValue;
    }

    @SuppressLint({"all"})
    public void hideCustomView() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048656, this) == null) || this.mCustomView == null) {
            return;
        }
        try {
            getCurrentWebView().getHandler().post(new a(this));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void hideEmbeddedTitleBar(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048657, this, z) == null) || this.mEmbeddedTitlebar == null || this.mLockEmbeddedTitlebar) {
            return;
        }
        this.mCanHideTitlebar = true;
        updateTopControlsState(true, false, z);
        updateTopControlsState(this.mCanHideTitlebar, this.mCanShowTitlebar, z);
    }

    public void invokeZoomPicker() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048658, this) == null) {
            this.mCurrentWebView.invokeZoomPicker();
        }
    }

    public boolean isAutoShowTitlebar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) ? this.mCurrentWebView.isAutoShowTitlebar() : invokeV.booleanValue;
    }

    public boolean isDestroyed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) ? this.mCurrentWebView.isDestroyed() : invokeV.booleanValue;
    }

    public boolean isFeatureEnable(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048661, this, str)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View
    public boolean isFocused() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) {
            WebView webView = this.mCurrentWebView;
            return webView != null ? webView.isFocused() : super.isFocused();
        }
        return invokeV.booleanValue;
    }

    public boolean isPageLoading() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) ? this.mIsPageLoading : invokeV.booleanValue;
    }

    public boolean isPrivateBrowsingEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) ? this.mCurrentWebView.isPrivateBrowsingEnabled() : invokeV.booleanValue;
    }

    public boolean isTitlebarCanHide() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) ? this.mCanHideTitlebar : invokeV.booleanValue;
    }

    public boolean isTitlebarCanShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048666, this)) == null) ? this.mCanShowTitlebar : invokeV.booleanValue;
    }

    public boolean isTitlebarLock() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048667, this)) == null) ? this.mLockEmbeddedTitlebar : invokeV.booleanValue;
    }

    public boolean isTitlebarShowing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) {
            View view = this.mEmbeddedTitlebar;
            return view != null && view.getTranslationY() == 0.0f;
        }
        return invokeV.booleanValue;
    }

    public void loadData(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048669, this, str, str2, str3) == null) {
            this.mCurrentWebView.loadData(str, str2, str3);
        }
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048670, this, str, str2, str3, str4, str5) == null) {
            this.mCurrentWebView.loadDataWithBaseURL(str, str2, str3, str4, str5);
        }
    }

    public void loadImageInPage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048671, this, str) == null) {
            this.mCurrentWebView.loadUrl(SHOW_IMAGE_PREFIX.concat(String.valueOf(str)));
        }
    }

    public void loadUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048672, this, str) == null) {
            if (str == null || !str.startsWith("javascript:")) {
                perfLog(this.mCurrentWebView, "sailor-loadUrl", "url = ".concat(String.valueOf(str)));
                perfLog("load", str);
            }
            this.mCurrentWebView.loadUrl(str);
        }
    }

    public void loadUrl(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048673, this, str, map) == null) {
            if (str.startsWith("javascript:")) {
                this.mCurrentWebView.loadUrl(str);
                return;
            }
            perfLog(this.mCurrentWebView, "sailor-loadUrl", "url = ".concat(String.valueOf(str)));
            perfLog("load", str);
            this.mCurrentWebView.loadUrl(str, map);
        }
    }

    public void lockEmbeddedTitlebar(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048674, this, z) == null) {
            this.mLockEmbeddedTitlebar = z;
        }
    }

    public void notifyPageActive(String str, WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048675, this, str, webView) == null) {
            notifyPageActive(str, webView, false);
        }
    }

    public void notifyPageActive(String str, WebView webView, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048676, this, str, webView, z) == null) {
            Log.i("huqin-multiwebview", "BdSailorWebView notifyPageActive, webView = " + webView + ", url = " + str + ", isOpen = " + z);
            if (!z) {
                webView.setCurrentSourceIdByIdentifier();
            }
            SessionMonitorEngine.getInstance().notifyPageActive(str, webView, z);
            this.mCurrentWebView.onPageSwapFromWebview(webView, str, true);
        }
    }

    public void notifyPageLeave(String str, WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048677, this, str, webView) == null) {
            Log.i("huqin-multiwebview", "BdSailorWebView notifyPageLeave, webView = " + webView + ", url = " + str);
            SessionMonitorEngine.getInstance().notifyPageLeave(str, webView);
            this.mCurrentWebView.onPageSwapFromWebview(webView, str, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048678, this) == null) {
            super.onAttachedToWindow();
            if (c.a.k.b.c.b.e(this)) {
                BdSailor.getInstance().setCurrentSailorWebView(this);
            }
        }
    }

    @Override // android.view.View
    public boolean onCheckIsTextEditor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048679, this)) == null) {
            WebView webView = this.mCurrentWebView;
            if (webView != null) {
                return webView.onCheckIsTextEditor();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048680, this) == null) {
            super.onDetachedFromWindow();
            if (BdSailor.getInstance().getCurSailorWebView() == this) {
                BdSailor.getInstance().setCurrentSailorWebView(null);
            }
        }
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048681, this, i2, keyEvent)) == null) {
            if (hasCustomView()) {
                hideCustomView();
                return true;
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // android.view.View
    public void onOverScrolled(int i2, int i3, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048682, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.mCurrentWebView.onOverScrolledSuper(i2, i3, z, z2);
        }
    }

    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048683, this) == null) {
            this.mCurrentWebView.onPause();
        }
    }

    public void onReinputErrorUrl() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048684, this) == null) {
        }
    }

    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048685, this) == null) {
            this.mCurrentWebView.onResume();
        }
    }

    @Override // android.view.View
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048686, this, i2, i3, i4, i5) == null) {
            this.mCurrentWebView.onScrollChangedSuper(i2, i3, i4, i5);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048687, this, motionEvent)) == null) {
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
        return invokeL.booleanValue;
    }

    public void onWebViewLayerMarginChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048688, this, i2, i3, i4, i5) == null) {
        }
    }

    public boolean overlayHorizontalScrollbar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048689, this)) == null) ? this.mCurrentWebView.overlayHorizontalScrollbar() : invokeV.booleanValue;
    }

    public boolean overlayVerticalScrollbar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048690, this)) == null) ? this.mCurrentWebView.overlayVerticalScrollbar() : invokeV.booleanValue;
    }

    public boolean pageDown(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048691, this, z)) == null) ? this.mCurrentWebView.pageDown(z) : invokeZ.booleanValue;
    }

    public boolean pageUp(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048692, this, z)) == null) ? this.mCurrentWebView.pageUp(z) : invokeZ.booleanValue;
    }

    public void pauseMedia() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048693, this) == null) {
            this.mCurrentWebView.pauseMedia();
        }
    }

    public void pauseTimers() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048694, this) == null) {
            this.mCurrentWebView.pauseTimers();
        }
    }

    @Override // android.view.View
    public boolean performLongClick() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048695, this)) == null) ? this.mCurrentWebView.performLongClick() : invokeV.booleanValue;
    }

    public void postUrl(String str, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048696, this, str, bArr) == null) {
            this.mCurrentWebView.postUrl(str, bArr);
        }
    }

    public void reinjectJavascriptInterface() {
        WebView webView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048697, this) == null) || (webView = this.mCurrentWebView) == null) {
            return;
        }
        webView.reinjectJavascriptInterface();
    }

    public void reload() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048698, this) == null) {
            this.mCurrentWebView.stopLoading();
            this.mCurrentWebView.reload();
            this.mIsPageLoading = false;
        }
    }

    public void removeJavascriptInterface(String str) {
        WebView webView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048699, this, str) == null) || (webView = this.mCurrentWebView) == null) {
            return;
        }
        webView.removeJavascriptInterface(str);
    }

    public void removeJavascriptInterfaceExt(String str) {
        WebView webView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048700, this, str) == null) || (webView = this.mCurrentWebView) == null) {
            return;
        }
        webView.removeJavascriptInterfaceExt(str);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048701, this, view, rect, z)) == null) ? this.mCurrentWebView.requestChildRectangleOnScreen(view, rect, z) : invokeLLZ.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int i2, Rect rect) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048702, this, i2, rect)) == null) ? this.mCurrentWebView.requestFocus(i2, rect) : invokeIL.booleanValue;
    }

    public void requestFocusNodeHref(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048703, this, message) == null) {
            WebView webView = this.mCurrentWebView;
            if (webView != null) {
                webView.requestFocusNodeHref(message);
            } else {
                Log.e("current webview is null.");
            }
        }
    }

    public void requestImageRef(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048704, this, message) == null) {
            this.mCurrentWebView.requestImageRef(message);
        }
    }

    public void resetWebViewLayerMargin() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048705, this) == null) {
            setWebViewLayerMargin(0, 0, 0, 0);
        }
    }

    public BdSailorWebBackForwardList restoreState(Bundle bundle) {
        InterceptResult invokeL;
        WebBackForwardList restoreState;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048706, this, bundle)) == null) {
            if (bundle == null || (restoreState = this.mCurrentWebView.restoreState(bundle)) == null) {
                return null;
            }
            return new BdSailorWebBackForwardList(restoreState);
        }
        return (BdSailorWebBackForwardList) invokeL.objValue;
    }

    public void resumeMedia() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048707, this) == null) {
            this.mCurrentWebView.resumeMedia();
        }
    }

    public void resumeTimers() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048708, this) == null) {
            this.mCurrentWebView.resumeTimers();
        }
    }

    public void runWithThreadProtect(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048709, this, runnable) == null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                runnable.run();
            } else {
                this.mCurrentWebView.post(runnable);
            }
        }
    }

    public void savePassword(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048710, this, str, str2, str3) == null) {
            this.mCurrentWebView.savePassword(str, str2, str3);
        }
    }

    public BdSailorWebBackForwardList saveState(Bundle bundle) {
        InterceptResult invokeL;
        WebBackForwardList saveState;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048711, this, bundle)) == null) {
            if (bundle == null || (saveState = this.mCurrentWebView.saveState(bundle)) == null) {
                return null;
            }
            return new BdSailorWebBackForwardList(saveState);
        }
        return (BdSailorWebBackForwardList) invokeL.objValue;
    }

    public void saveWebArchive(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048712, this, str) == null) {
            this.mCurrentWebView.saveWebArchive(str);
        }
    }

    public void saveWebArchive(String str, boolean z, ValueCallback<String> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048713, this, new Object[]{str, Boolean.valueOf(z), valueCallback}) == null) {
            this.mCurrentWebView.saveWebArchive(str, z, valueCallback);
        }
    }

    public void setAutoShowTitlebar(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048714, this, z) == null) {
            this.mCurrentWebView.setAutoShowTitlebar(z);
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048715, this, i2) == null) {
            this.mSnapBgColor = i2;
            WebView webView = this.mCurrentWebView;
            if (webView != null) {
                webView.setBackgroundColor(i2);
            } else {
                super.setBackgroundColor(i2);
            }
        }
    }

    public void setCertificate(SslCertificate sslCertificate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048716, this, sslCertificate) == null) {
            this.mCurrentWebView.setCertificate(sslCertificate);
        }
    }

    public void setCurrentTitleBar(boolean z) {
        View view;
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048717, this, z) == null) || (view = this.mSearchResultTitleBar) == null || (view2 = this.mLandingPageTitleBar) == null) {
            return;
        }
        if (!z) {
            view = view2;
        }
        this.mCurrentTitleBar = view;
        this.mSearchResultTitleBar.setVisibility(z ? 0 : 8);
        this.mLandingPageTitleBar.setVisibility(z ? 8 : 0);
        this.mEmbeddedTitlebar = this.mCurrentTitleBar;
    }

    public void setDownloadListener(ISailorDownloadListener iSailorDownloadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048718, this, iSailorDownloadListener) == null) {
            this.mDownloadListener = iSailorDownloadListener;
        }
    }

    public void setDualTitleBars(View view, View view2, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(1048719, this, view, view2, i2, i3) == null) {
            setDualTitleBars(view, view2, i2, i3, true, true);
        }
    }

    public void setDualTitleBars(View view, View view2, int i2, int i3, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048720, this, new Object[]{view, view2, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.mSearchResultTitleBar = view;
            if (view != null) {
                view.setContentDescription("searchbar");
            }
            this.mLandingPageTitleBar = view2;
            if (view2 != null) {
                view2.setContentDescription("landingbar");
            }
            View view3 = i3 == 0 ? this.mSearchResultTitleBar : this.mLandingPageTitleBar;
            this.mCurrentTitleBar = view3;
            setNewTitlebar(view3, i2, z, z2);
            setSearchBarTopMargin();
            bringStatusBarToFront();
            this.mCurrentWebView.addEmbeddedTitleBarFinished();
        }
    }

    public void setEmbeddedTitleBar(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048721, this, view) == null) {
            setEmbeddedTitleBar(view, 0);
        }
    }

    public void setEmbeddedTitleBar(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048722, this, view, i2) == null) {
            if (!c.a.k.b.c.b.c()) {
                setNewTitlebar(view, i2, true, true);
            } else if (view == null) {
                setNewTitlebar(view, i2, true, true);
            } else {
                this.mSearchResultTitleBar = view;
                this.mCurrentTitleBar = view;
                this.mEmbeddedTitlebar = view;
                this.mEmbeddedTitlebarHeightPix = c.a.k.a.q.e.a(i2);
            }
        }
    }

    public void setFindListener(WebView.FindListener findListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048723, this, findListener) == null) {
            this.mCurrentWebView.setFindListener(findListener);
        }
    }

    public void setFullscreen(Activity activity, boolean z) {
        Window window;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048724, this, activity, z) == null) || activity == null || (window = activity.getWindow()) == null) {
            return;
        }
        window.setFlags(!z ? 0 : 1024, 1024);
    }

    public void setHorizontalScrollbarOverlay(boolean z) {
        WebView webView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048725, this, z) == null) || (webView = this.mCurrentWebView) == null) {
            return;
        }
        webView.setHorizontalScrollbarOverlay(z);
    }

    public void setHttpAuthUsernamePassword(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048726, this, str, str2, str3, str4) == null) {
            this.mCurrentWebView.setHttpAuthUsernamePassword(str, str2, str3, str4);
        }
    }

    public void setInitialScale(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048727, this, i2) == null) {
            this.mCurrentWebView.setInitialScale(i2);
        }
    }

    @Override // android.view.View
    public void setLayerType(int i2, Paint paint) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048728, this, i2, paint) == null) {
            WebView webView = this.mCurrentWebView;
            if (webView != null) {
                webView.setLayerType(i2, paint);
            } else {
                super.setLayerType(i2, paint);
            }
        }
    }

    public void setMapTrackballToArrowKeys(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048729, this, z) == null) {
            this.mCurrentWebView.setMapTrackballToArrowKeys(z);
        }
    }

    public void setNetworkAvailable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048730, this, z) == null) {
            this.mCurrentWebView.setNetworkAvailable(z);
        }
    }

    public void setNewTitlebar(View view, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048731, this, new Object[]{view, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            setNewTitlebar(view, i2, z, z);
        }
    }

    public void setNewTitlebar(View view, int i2, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048732, this, new Object[]{view, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
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
            this.mEmbeddedTitlebarHeightPix = c.a.k.a.q.e.a(i2);
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
                if (c.a.k.b.c.b.c()) {
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
    }

    public void setOuterTitlebarHeight(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048733, this, i2) == null) && BdZeusUtil.isWebkitLoaded() && !c.a.k.b.c.b.c()) {
            this.mOuterTitlebarHeightPix = i2;
            setWebViewLayerMarginInternal(this.mMarginLeft, this.mMarginTop + i2, this.mMarginRight, this.mMarginBottom);
        }
    }

    @Override // android.view.View
    public void setOverScrollMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048734, this, i2) == null) {
            WebView webView = this.mCurrentWebView;
            if (webView != null) {
                webView.setOverScrollMode(i2);
            } else {
                super.setOverScrollMode(i2);
            }
        }
    }

    public void setPageTransformer(boolean z, PageTransformer pageTransformer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048735, this, z, pageTransformer) == null) {
            this.mCurrentWebView.setPageTransformer(z, pageTransformer);
        }
    }

    public void setPictureListener(WebView.PictureListener pictureListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048736, this, pictureListener) == null) {
            this.mPictureListener = pictureListener;
        }
    }

    public void setRendererPriorityPolicy(int i2, boolean z) {
        WebView webView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048737, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || (webView = this.mCurrentWebView) == null) {
            return;
        }
        webView.setRendererPriorityPolicy(i2, z);
    }

    public void setSailorWebViewSize(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048738, this, i2, i3) == null) {
            setViewSize(this.mWebViewLayer, i2, i3);
            setViewSize(this.mCurrentWebView, i2, i3);
            this.mCurrentWebView.setWebViewPagerSize(i2, i3);
        }
    }

    @Override // android.view.View
    public void setScrollBarStyle(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048739, this, i2) == null) {
            this.mCurrentWebView.setScrollBarStyle(i2);
        }
    }

    public void setStatusBar(View view, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048740, this, view, i2) == null) && c.a.k.b.c.b.c()) {
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
        WebView webView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048741, this, z) == null) || (webView = this.mCurrentWebView) == null) {
            return;
        }
        webView.setVerticalScrollbarOverlay(z);
    }

    public void setVideoPlayerFactory(VideoPlayerFactory videoPlayerFactory) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048742, this, videoPlayerFactory) == null) {
            this.mVideoFactory = videoPlayerFactory;
            this.mCurrentWebView.setVideoPlayerFactory(videoPlayerFactory);
        }
    }

    public void setWebBackForwardListClient(WebBackForwardListClient webBackForwardListClient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048743, this, webBackForwardListClient) == null) {
            this.mCurrentWebView.setWebBackForwardListClient(webBackForwardListClient);
        }
    }

    public void setWebChromeClient(BdSailorWebChromeClient bdSailorWebChromeClient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048744, this, bdSailorWebChromeClient) == null) {
            this.mWebChromeClient = bdSailorWebChromeClient;
        }
    }

    public void setWebChromeClientExt(BdSailorWebChromeClientExt bdSailorWebChromeClientExt) {
        ISailorWebViewExt iSailorWebViewExt;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048745, this, bdSailorWebChromeClientExt) == null) || (iSailorWebViewExt = this.mWebViewExt) == null) {
            return;
        }
        iSailorWebViewExt.setWebChromeClientExt(bdSailorWebChromeClientExt);
    }

    public void setWebViewClient(BdSailorWebViewClient bdSailorWebViewClient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048746, this, bdSailorWebViewClient) == null) {
            this.mWebViewClient = bdSailorWebViewClient;
        }
    }

    public void setWebViewClientExt(BdSailorWebViewClientExt bdSailorWebViewClientExt) {
        ISailorWebViewExt iSailorWebViewExt;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048747, this, bdSailorWebViewClientExt) == null) || (iSailorWebViewExt = this.mWebViewExt) == null) {
            return;
        }
        iSailorWebViewExt.setWebViewClientExt(bdSailorWebViewClientExt);
    }

    public void setWebViewLayerMargin(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048748, this, i2, i3, i4, i5) == null) {
            if ((i2 == this.mMarginLeft && i3 == this.mMarginTop && i4 == this.mMarginRight && i5 == this.mMarginBottom) ? false : true) {
                this.mMarginLeft = i2;
                this.mMarginTop = i3;
                this.mMarginRight = i4;
                this.mMarginBottom = i5;
                setWebViewLayerMarginInternal(i2, i3 + this.mOuterTitlebarHeightPix, i4, i5);
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048749, this)) == null) ? this.mCurrentWebView.shouldDelayChildPressedState() : invokeV.booleanValue;
    }

    public void showCustomView(Context context, View view, WebChromeClient.CustomViewCallback customViewCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048750, this, context, view, customViewCallback) == null) {
            Activity activity = context instanceof Activity ? (Activity) context : null;
            if (activity != null) {
                if (this.mCustomView != null) {
                    customViewCallback.onCustomViewHidden();
                    return;
                }
                this.mOriginalOrientation = activity.getRequestedOrientation();
                if (activity.getWindow() != null) {
                    FrameLayout frameLayout = (FrameLayout) activity.getWindow().getDecorView();
                    g gVar = new g(activity);
                    this.mFullscreenContainer = gVar;
                    gVar.addView(view, COVER_SCREEN_PARAMS);
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
    }

    public void showEmbeddedTitleBar(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048751, this, z) == null) || this.mEmbeddedTitlebar == null || this.mLockEmbeddedTitlebar) {
            return;
        }
        this.mCanShowTitlebar = true;
        updateTopControlsState(false, false, z);
        updateTopControlsState(this.mCanHideTitlebar, this.mCanShowTitlebar, z);
    }

    public boolean showFindDialog(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048752, this, str, z)) == null) ? this.mCurrentWebView.showFindDialog(str, z) : invokeLZ.booleanValue;
    }

    public int startPrerender(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048753, this, str)) == null) {
            WebView webView = this.mCurrentWebView;
            if (webView != null) {
                return webView.startPrerender(str);
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public void stopLoading() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048754, this) == null) || isDestroyed()) {
            return;
        }
        this.mCurrentWebView.stopLoading();
        this.mIsPageLoading = false;
    }

    public void suspendScheduledTasks(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048755, this, str) == null) || isDestroyed()) {
            return;
        }
        this.mCurrentWebView.suspendScheduledTasks(str);
    }

    public void switchTitleBar(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048756, this, z) == null) {
            this.mCurrentWebView.switchTitleBar(z);
        }
    }

    public void updateEmbeddedTitleBar(boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048757, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) || this.mEmbeddedTitlebar == null) {
            return;
        }
        this.mCanHideTitlebar = z;
        this.mCanShowTitlebar = z2;
        updateTopControlsState(z, z2, z3);
    }

    public void updateTopControlOffset(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048758, this, i2) == null) {
            this.mCurrentWebView.updateTopControlOffset(i2);
        }
    }

    public void updateTopControlsState(boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048759, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) || this.mEmbeddedTitlebar == null) {
            return;
        }
        Log.d("new-titlebar", "updateTopControlsState :".concat(String.valueOf(z)));
        this.mCurrentWebView.updateTopControlsState(z, z2, z3);
        if (z3) {
            return;
        }
        if (c.a.k.b.c.b.c()) {
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

    public boolean zoomIn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048760, this)) == null) ? this.mCurrentWebView.zoomIn() : invokeV.booleanValue;
    }

    public boolean zoomOut() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048761, this)) == null) ? this.mCurrentWebView.zoomOut() : invokeV.booleanValue;
    }
}
