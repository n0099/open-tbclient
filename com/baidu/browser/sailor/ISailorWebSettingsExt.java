package com.baidu.browser.sailor;

import com.baidu.browser.core.INoProGuard;
import com.baidu.webkit.sdk.WebSettings;
/* loaded from: classes12.dex */
public interface ISailorWebSettingsExt extends INoProGuard {
    boolean getAdBlockEnabledExt();

    boolean getCustomFocusEnabledExt();

    boolean getEnableFileSchemaOnPrivate();

    boolean getEnableVSyncOpt();

    float getFastFlingDampFactorExt();

    WebSettings.FlingAlgorithm getFlingAlgorithmExt();

    boolean getHookH5NavigationEnabled();

    boolean getHtml5VideoEnabledExt();

    boolean getMagicFilterEnabledExt();

    boolean getNightModeEnabledExt();

    boolean getPauseAudioEnabledExt();

    boolean getPlayVideoInFullScreenModeExt();

    boolean getPrerenderEnabledExt();

    boolean getShowUnderLineExt();

    boolean getUrlSecurityCheckEnabledExt();

    boolean getUseGLRenderingExt();

    boolean getUseScaleStoreExt();

    boolean getUserSelectEnabled();

    boolean isFullScreenMode();

    boolean isLPLoadingAnimationEnable();

    boolean isLoadingAnimationEnable();

    boolean isSkeletonEnable();

    void setAdBlockEnabledExt(boolean z);

    void setAntiHackInfoEnabledExt(boolean z);

    void setCustomFocusEnabledExt(boolean z);

    void setEnableFileSchemaOnPrivate(boolean z);

    void setEnableLPLoadingAnimation(boolean z);

    void setEnableLoadingAnimation(boolean z);

    void setEnableSkeletonView(boolean z);

    void setEnableVSyncOpt(boolean z);

    void setFastFlingDampFactorExt(float f);

    void setFeatureDatabasePathExt(String str);

    void setFeedNewsFirstScreenOptEnabledEX(boolean z);

    void setFlingAlgorithmExt(WebSettings.FlingAlgorithm flingAlgorithm);

    void setFullScreenMode(boolean z);

    void setHookH5NavigationEnabled(boolean z);

    void setHtml5VideoEnabledExt(boolean z);

    void setImageMaxWidthExt(int i);

    void setImagesEnabledExt(boolean z);

    void setMagicFilterEnabledExt(boolean z);

    void setNightModeEnabledExt(boolean z);

    void setPageFreezeDisableExt(boolean z);

    void setPauseAudioEnabledExt(boolean z);

    void setPlayVideoInFullScreenModeExt(boolean z);

    void setPrerenderEnabledExt(boolean z);

    void setSafePageEnabledExt(boolean z);

    void setShouldDispatchBeforeunloadEX(boolean z);

    void setShowUnderLineExt(boolean z);

    void setShrinksStandaloneImagesToFitExt(boolean z);

    void setUrlSecurityCheckEnabledExt(boolean z);

    void setUseGLRenderingExt(boolean z);

    void setUseScaleStoreExt(boolean z);

    void setUserSelectEnabled(boolean z);

    void setWiseSearchFirstScreenOptTypeEX(int i);
}
