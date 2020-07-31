package com.baidu.browser.sailor;

import android.graphics.Bitmap;
import android.widget.ZoomButtonsController;
import com.baidu.browser.core.INoProGuard;
import com.baidu.browser.sailor.lightapp.BdLightappActionClient;
import com.baidu.browser.sailor.lightapp.BdLightappKernelClient;
import com.baidu.webkit.sdk.WebView;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public interface ISailorWebViewExt extends INoProGuard {
    boolean canGoToPreloadNextExt();

    void changeWapPreloadUrlStyleExt(int i, String str);

    void completeSelectionExt();

    @Deprecated
    void destroyCanvasCacheBmpExt();

    @Deprecated
    void emulateShiftHeldOnLinkExt();

    void emulateShiftHeldOnNormalTextExt();

    void ensureRemoveSearchBoxImplExt();

    void execJavaScriptExt(String str, String... strArr);

    void exitFullScreenModeExt();

    @Deprecated
    int getActionNodesCountExt();

    float getActualZoomScaleExt();

    int getAdCount(String str);

    int getBackgroundNightColorExt();

    int getBigPluginTextNightColorExt();

    int getBorderNightColorExt();

    @Deprecated
    Bitmap getCanvasCacheBmpExt();

    float getCurrentScaleExt();

    int getDefaultLinkTextNightColorExt();

    int getEmbeddedTitleBarHeightExt();

    int getImageNightColorExt();

    int getLinkTextNightColorExt();

    int getMagicFilterCount();

    @Deprecated
    Bitmap getMagnifierBmpExt();

    float getMaxZoomScaleExt();

    float getMinZoomScaleExt();

    int getNightModeColorStyleExt();

    WebView.WebPageInfoList getPageInfo();

    List<String> getPictureUrlListExt();

    String getSelectionTextExt();

    ISailorWebSettingsExt getSettingsExt();

    int getTextNightColorExt();

    int getVisitedLinkNightColorExt();

    BdSailorWebChromeClientExt getWebChromeClientExt();

    BdSailorWebViewClientExt getWebViewClientExt();

    ZoomButtonsController getZoomButtonsControllerExt();

    @Deprecated
    void hideMagnifierExt(int i, int i2);

    void invokeLightappJsReadyEventExt();

    boolean isDestroyedExt();

    boolean isDrawSelectionPointerExt();

    boolean isExtendSelectionExt();

    boolean isFixWebViewSecurityHolesExt();

    boolean isForegroundExt();

    boolean isMobileSiteExt();

    boolean isNeedImpactScriptExt();

    boolean isNeedInvokeLightappJSReadyEventExt();

    boolean isShiftPressedModeExt();

    boolean isTextSelectingModeExt();

    boolean isWapAllowScaleExt();

    void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5, boolean z);

    void loadUrl(String str, Map<String, String> map, boolean z);

    void mediaPlayerStatusChangedExt(int i, float f, float f2);

    void mediaPlayerTimeChangedExt(float f, float f2);

    @Deprecated
    void moveMagnifierExt(int i, int i2);

    boolean notifyNativeExitFullScreenIfNeededExt(int i);

    void onSearchKeyword(String str, String str2);

    void onShowCommentPanel(String str, String str2);

    void onShowValidateComponent(String str, String str2);

    void pauseExt(boolean z);

    void pauseMediaExt();

    void resetLoadingAnimation();

    void resumeExt(boolean z);

    void resumeMediaExt();

    boolean savePageAsLocalFilesExt(String str, String str2, WebView.SaveAsType saveAsType);

    boolean setBackgroundNightColorExt(int i);

    void setBeginScaleExt();

    boolean setBigPluginTextNightColorExt(int i);

    boolean setBorderNightColorExt(int i);

    boolean setDefaultLinkTextNightColorExt(int i);

    void setDefaultViewSizeExt(int i, int i2);

    void setDrawSelectionPointerExt(boolean z);

    void setEndScaleExt();

    void setExtendSelectionExt(boolean z);

    void setFixWebViewSecurityHolesExt(boolean z);

    boolean setImageNightColorExt(int i);

    void setLightappActionClientExt(BdLightappActionClient bdLightappActionClient);

    void setLightappKernalClientExt(BdLightappKernelClient bdLightappKernelClient);

    boolean setLinkTextNightColorExt(int i);

    void setNeedImpactScriptExt(boolean z);

    boolean setNightModeColorStyleExt(int i);

    boolean setPreviewZoomScaleExt(float f);

    void setShiftPressedModeExt(boolean z);

    void setSubjectScrollToOnloadExt(int i);

    void setTextFieldTextExt(String str);

    void setTextFieldTextExt(String str, boolean z);

    boolean setTextNightColorExt(int i);

    void setTextSelectingModeExt(boolean z);

    boolean setVisitedLinkNightColorExt(int i);

    void setWebChromeClientExt(BdSailorWebChromeClientExt bdSailorWebChromeClientExt);

    void setWebViewClientExt(BdSailorWebViewClientExt bdSailorWebViewClientExt);

    void setWebViewStateExt(WebView.WebViewState webViewState);

    @Deprecated
    void setWebViewTypeExt(WebView.WebViewType webViewType);

    void showMagnifierExt(int i, int i2, int i3, int i4, boolean z);

    void startCaptureContentExt();

    void startLoadingAnimation();

    void startLoadingAnimation(String str);

    boolean startPreviewZoomScaleExt();

    void updatePictureUrlListExt();
}
