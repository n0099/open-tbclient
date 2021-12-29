package com.baidu.browser.sailor;

import android.graphics.Bitmap;
import android.widget.ZoomButtonsController;
import com.baidu.browser.core.INoProGuard;
import com.baidu.webkit.sdk.WebView;
import java.util.List;
import java.util.Map;
/* loaded from: classes10.dex */
public interface ISailorWebViewExt extends INoProGuard {
    void addNoStatePrefetch(String str, String str2);

    boolean canGoToPreloadNextExt();

    void cancelCurrentNoStatePrefetch();

    void changeWapPreloadUrlStyleExt(int i2, String str);

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
    void hideMagnifierExt(int i2, int i3);

    boolean isDestroyedExt();

    boolean isDrawSelectionPointerExt();

    boolean isExtendSelectionExt();

    boolean isFixWebViewSecurityHolesExt();

    boolean isForegroundExt();

    boolean isMobileSiteExt();

    boolean isNeedImpactScriptExt();

    boolean isShiftPressedModeExt();

    boolean isTextSelectingModeExt();

    boolean isWapAllowScaleExt();

    void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5, boolean z);

    void loadUrl(String str, Map<String, String> map, boolean z);

    void mediaPlayerStatusChangedExt(int i2, float f2, float f3);

    void mediaPlayerTimeChangedExt(float f2, float f3);

    @Deprecated
    void moveMagnifierExt(int i2, int i3);

    boolean notifyNativeExitFullScreenIfNeededExt(int i2);

    void onPauseAll();

    void onResumeAll();

    void onSearchKeyword(String str, String str2);

    void onShowCommentPanel(String str, String str2);

    void onShowValidateComponent(String str, String str2);

    void pauseExt(boolean z);

    void pauseMediaExt();

    void resetLoadingAnimation();

    void resumeExt(boolean z);

    void resumeMediaExt();

    boolean savePageAsLocalFilesExt(String str, String str2, WebView.SaveAsType saveAsType);

    boolean setBackgroundNightColorExt(int i2);

    void setBeginScaleExt();

    boolean setBigPluginTextNightColorExt(int i2);

    boolean setBorderNightColorExt(int i2);

    boolean setDefaultLinkTextNightColorExt(int i2);

    void setDefaultViewSizeExt(int i2, int i3);

    void setDrawSelectionPointerExt(boolean z);

    void setEndScaleExt();

    void setExtendSelectionExt(boolean z);

    void setFixWebViewSecurityHolesExt(boolean z);

    boolean setImageNightColorExt(int i2);

    boolean setLinkTextNightColorExt(int i2);

    void setNeedImpactScriptExt(boolean z);

    boolean setNightModeColorStyleExt(int i2);

    boolean setPreviewZoomScaleExt(float f2);

    void setShiftPressedModeExt(boolean z);

    void setSubjectScrollToOnloadExt(int i2);

    void setTextFieldTextExt(String str);

    void setTextFieldTextExt(String str, boolean z);

    boolean setTextNightColorExt(int i2);

    void setTextSelectingModeExt(boolean z);

    boolean setVisitedLinkNightColorExt(int i2);

    void setWebChromeClientExt(BdSailorWebChromeClientExt bdSailorWebChromeClientExt);

    void setWebViewClientExt(BdSailorWebViewClientExt bdSailorWebViewClientExt);

    void setWebViewStateExt(WebView.WebViewState webViewState);

    @Deprecated
    void setWebViewTypeExt(WebView.WebViewType webViewType);

    void showMagnifierExt(int i2, int i3, int i4, int i5, boolean z);

    void startCaptureContentExt();

    void startLoadingAnimation();

    void startLoadingAnimation(String str);

    boolean startPreviewZoomScaleExt();

    void updatePictureUrlListExt();
}
