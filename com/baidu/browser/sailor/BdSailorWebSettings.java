package com.baidu.browser.sailor;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.browser.core.INoProGuard;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebSettings;
import com.baidu.webkit.sdk.WebViewFactory;
import com.baidu.webkit.sdk.WebViewFactoryProvider;
import com.baidu.webkit.sdk.dumper.ZeusLogRecorder;
import com.baidu.webkit.sdk.jschecker.BdJsCheckPolicy;
/* loaded from: classes3.dex */
public class BdSailorWebSettings implements INoProGuard {
    public static /* synthetic */ Interceptable $ic;
    public static boolean lastNightModeEnabled;
    public static BdJsCheckPolicy sDefaultJsCheckPolicy;
    public transient /* synthetic */ FieldHolder $fh;
    public WebSettings mWebSettings;

    /* loaded from: classes3.dex */
    public class BdSailorWebSettingsExt implements ISailorWebSettingsExt {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String ENABLE_LOG_RECORD = "enable_log_record";
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdSailorWebSettings this$0;

        public BdSailorWebSettingsExt(BdSailorWebSettings bdSailorWebSettings) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdSailorWebSettings};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = bdSailorWebSettings;
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public boolean getAdBlockEnabledExt() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.this$0.mWebSettings.getADblockEnabled() : invokeV.booleanValue;
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public boolean getCustomFocusEnabledExt() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.this$0.mWebSettings.getCustomFocusEnabled() : invokeV.booleanValue;
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public boolean getEnableFileSchemaOnPrivate() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.this$0.mWebSettings.getEnableFileSchemaOnPrivate() : invokeV.booleanValue;
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public boolean getEnableVSyncOpt() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.this$0.mWebSettings.getEnableVSyncOpt() : invokeV.booleanValue;
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public synchronized float getFastFlingDampFactorExt() {
            InterceptResult invokeV;
            float fastFlingDampFactor;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                synchronized (this) {
                    fastFlingDampFactor = this.this$0.mWebSettings.getFastFlingDampFactor();
                }
                return fastFlingDampFactor;
            }
            return invokeV.floatValue;
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public synchronized WebSettings.FlingAlgorithm getFlingAlgorithmExt() {
            InterceptResult invokeV;
            WebSettings.FlingAlgorithm flingAlgorithm;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                synchronized (this) {
                    flingAlgorithm = this.this$0.mWebSettings.getFlingAlgorithm();
                }
                return flingAlgorithm;
            }
            return (WebSettings.FlingAlgorithm) invokeV.objValue;
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public boolean getHookH5NavigationEnabled() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.this$0.mWebSettings.getHookH5NavigationEnabled() : invokeV.booleanValue;
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public boolean getHtml5VideoEnabledExt() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.this$0.mWebSettings.getHtml5VideoEnabled() : invokeV.booleanValue;
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public boolean getMagicFilterEnabledExt() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.this$0.mWebSettings.getMagicFilterEnabledExt() : invokeV.booleanValue;
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public boolean getNightModeEnabledExt() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.this$0.mWebSettings.getNightModeEnabled() : invokeV.booleanValue;
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public synchronized boolean getPauseAudioEnabledExt() {
            InterceptResult invokeV;
            boolean pauseAudioEnabled;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                synchronized (this) {
                    pauseAudioEnabled = this.this$0.mWebSettings.getPauseAudioEnabled();
                }
                return pauseAudioEnabled;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public synchronized boolean getPlayVideoInFullScreenModeExt() {
            InterceptResult invokeV;
            boolean playVideoInFullScreenMode;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                synchronized (this) {
                    playVideoInFullScreenMode = this.this$0.mWebSettings.getPlayVideoInFullScreenMode();
                }
                return playVideoInFullScreenMode;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public boolean getPrerenderEnabledExt() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.this$0.mWebSettings.getPrerenderEnabled() : invokeV.booleanValue;
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public boolean getShowUnderLineExt() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public synchronized boolean getUrlSecurityCheckEnabledExt() {
            InterceptResult invokeV;
            boolean urlSecurityCheckEnabled;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                synchronized (this) {
                    urlSecurityCheckEnabled = this.this$0.mWebSettings.getUrlSecurityCheckEnabled();
                }
                return urlSecurityCheckEnabled;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public synchronized boolean getUseGLRenderingExt() {
            InterceptResult invokeV;
            boolean useGLRendering;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                synchronized (this) {
                    useGLRendering = this.this$0.mWebSettings.getUseGLRendering();
                }
                return useGLRendering;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public boolean getUseScaleStoreExt() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.this$0.mWebSettings.getUseScaleStore() : invokeV.booleanValue;
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public boolean getUserSelectEnabled() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.this$0.mWebSettings.getUserSelectEnabled() : invokeV.booleanValue;
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public boolean isFullScreenMode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.this$0.mWebSettings.isFullScreenMode() : invokeV.booleanValue;
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public boolean isLPLoadingAnimationEnable() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.this$0.mWebSettings.isLPLoadingAnimationEnable() : invokeV.booleanValue;
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public boolean isLoadingAnimationEnable() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.this$0.mWebSettings.isLoadingAnimationEnable() : invokeV.booleanValue;
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public boolean isSkeletonEnable() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.this$0.mWebSettings.getSkeletonViewEnable() : invokeV.booleanValue;
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public synchronized void setAdBlockEnabledExt(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
                synchronized (this) {
                    this.this$0.mWebSettings.setADblockEnabled(z);
                }
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public void setAntiHackInfoEnabledExt(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
                this.this$0.mWebSettings.setAntiHackInfoEnabled(z);
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public void setCustomFocusEnabledExt(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
                this.this$0.mWebSettings.setCustomFocusEnabled(z);
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public void setEnableFileSchemaOnPrivate(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
                this.this$0.mWebSettings.setEnableFileSchemaOnPrivate(z);
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public void setEnableLPLoadingAnimation(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
                this.this$0.mWebSettings.setEnableLPLoadingAnimation(z);
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public void setEnableLoadingAnimation(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
                this.this$0.mWebSettings.setEnableLoadingAnimation(z);
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public void setEnableSkeletonView(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
                this.this$0.mWebSettings.setSkeletonViewEnable(z);
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public void setEnableVSyncOpt(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
                this.this$0.mWebSettings.setEnableVSyncOpt(z);
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public synchronized void setFastFlingDampFactorExt(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048606, this, f) == null) {
                synchronized (this) {
                    this.this$0.mWebSettings.setFastFlingDampFactor(f);
                }
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public synchronized void setFeatureDatabasePathExt(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048607, this, str) == null) {
                synchronized (this) {
                    this.this$0.mWebSettings.setFeatureDatabasePath(str);
                }
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public void setFeedNewsFirstScreenOptEnabledEX(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
                this.this$0.mWebSettings.setFeedNewsFirstScreenOptEnabled(z);
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public synchronized void setFlingAlgorithmExt(WebSettings.FlingAlgorithm flingAlgorithm) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048609, this, flingAlgorithm) == null) {
                synchronized (this) {
                    this.this$0.mWebSettings.setFlingAlgorithm(flingAlgorithm);
                }
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public void setFullScreenMode(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
                this.this$0.mWebSettings.setFullScreenMode(z);
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public void setHookH5NavigationEnabled(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048611, this, z) == null) {
                this.this$0.mWebSettings.setHookH5NavigationEnabled(z);
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public void setHtml5VideoEnabledExt(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048612, this, z) == null) {
                this.this$0.mWebSettings.setHtml5VideoEnabled(z);
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public void setImageMaxWidthExt(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048613, this, i) == null) {
                this.this$0.mWebSettings.setImageMaxWidth(i);
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public synchronized void setImagesEnabledExt(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
                synchronized (this) {
                    this.this$0.mWebSettings.setImagesEnabled(z);
                }
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public void setMagicFilterEnabledExt(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
                this.this$0.mWebSettings.setMagicFilterEnabledExt(z);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:29:0x0071, code lost:
            if (com.baidu.browser.sailor.BdSailorWebSettings.lastNightModeEnabled == r5) goto L32;
         */
        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void setNightModeEnabledExt(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048616, this, z) == null) {
                this.this$0.mWebSettings.setNightModeEnabled(z);
                if (WebSettingsGlobalBlink.GetCloudSettingsValue(ENABLE_LOG_RECORD) == null || !WebSettingsGlobalBlink.GetCloudSettingsValue(ENABLE_LOG_RECORD).equals("true")) {
                    return;
                }
                Log.i("zwsettings.setNightMode", z + " " + BdSailorWebSettings.lastNightModeEnabled);
                if (!z || BdSailorWebSettings.lastNightModeEnabled == z) {
                    synchronized (BdSailorWebSettings.class) {
                        if (z) {
                        }
                        boolean unused = BdSailorWebSettings.lastNightModeEnabled = z;
                    }
                    return;
                }
                synchronized (BdSailorWebSettings.class) {
                    if (z) {
                        if (BdSailorWebSettings.lastNightModeEnabled != z) {
                            boolean unused2 = BdSailorWebSettings.lastNightModeEnabled = z;
                        }
                    }
                }
                try {
                    ZeusLogRecorder.getInstance().initAndUpload();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public synchronized void setPageFreezeDisableExt(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048617, this, z) == null) {
                synchronized (this) {
                    this.this$0.mWebSettings.setPageFreezeDisable(z);
                }
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public synchronized void setPauseAudioEnabledExt(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048618, this, z) == null) {
                synchronized (this) {
                    this.this$0.mWebSettings.setPauseAudioEnabled(z);
                }
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public synchronized void setPlayVideoInFullScreenModeExt(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048619, this, z) == null) {
                synchronized (this) {
                    this.this$0.mWebSettings.setPlayVideoInFullScreenMode(z);
                }
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public void setPrerenderEnabledExt(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048620, this, z) == null) {
                this.this$0.mWebSettings.setPrerenderEnabled(z);
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public void setSafePageEnabledExt(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048621, this, z) == null) {
                this.this$0.mWebSettings.setSafePageEnabled(z);
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public void setShouldDispatchBeforeunloadEX(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048622, this, z) == null) {
                this.this$0.mWebSettings.setShouldDispatchBeforeunload(z);
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public void setShowUnderLineExt(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048623, this, z) == null) {
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public void setShrinksStandaloneImagesToFitExt(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048624, this, z) == null) {
                this.this$0.mWebSettings.setShrinksStandaloneImagesToFit(z);
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public synchronized void setUrlSecurityCheckEnabledExt(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048625, this, z) == null) {
                synchronized (this) {
                    this.this$0.mWebSettings.setUrlSecurityCheckEnabled(z);
                }
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public synchronized void setUseGLRenderingExt(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048626, this, z) == null) {
                synchronized (this) {
                    this.this$0.mWebSettings.setUseGLRendering(z);
                }
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public void setUseScaleStoreExt(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048627, this, z) == null) {
                this.this$0.mWebSettings.setUseScaleStore(z);
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public void setUserSelectEnabled(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048628, this, z) == null) {
                this.this$0.mWebSettings.setUserSelectEnabled(z);
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public void setWiseSearchFirstScreenOptTypeEX(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048629, this, i) == null) {
                this.this$0.mWebSettings.setWiseSearchFirstScreenOptType(i);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1322228576, "Lcom/baidu/browser/sailor/BdSailorWebSettings;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1322228576, "Lcom/baidu/browser/sailor/BdSailorWebSettings;");
        }
    }

    public BdSailorWebSettings(WebSettings webSettings) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {webSettings};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mWebSettings = webSettings;
    }

    public static void clearNetworkFlowExt() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
        }
    }

    public static synchronized void clearSavingBytesExt() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, null) == null) {
            synchronized (BdSailorWebSettings.class) {
            }
        }
    }

    public static BdJsCheckPolicy getDefaultJsCheckPolicy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    Object staticWebSeting = WebViewFactory.getProvider().getStaticWebSeting(WebViewFactoryProvider.SETTING_JS_CHECK_POLICY);
                    if (staticWebSeting instanceof BdJsCheckPolicy) {
                        return (BdJsCheckPolicy) staticWebSeting;
                    }
                    return null;
                }
            } catch (UnsatisfiedLinkError e) {
                e.printStackTrace();
            } catch (Throwable th) {
                Log.e(Log.LOG_TAG, "setDefaultEnableJsPromptSailor error:".concat(String.valueOf(th)));
            }
            return null;
        }
        return (BdJsCheckPolicy) invokeV.objValue;
    }

    public static boolean getEnableOverSeasExt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean getEnableProxyExt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean getEnableSpdyExt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    return ((Boolean) WebViewFactory.getProvider().getStaticWebSeting(WebViewFactoryProvider.SETTING_SPDY)).booleanValue();
                }
                return false;
            } catch (UnsatisfiedLinkError e) {
                e.printStackTrace();
                return false;
            } catch (Throwable th) {
                Log.e(Log.LOG_TAG, "getEnableSpdyExt error:".concat(String.valueOf(th)));
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean getGifOneFrameEnabledExt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    return ((Boolean) WebViewFactory.getProvider().getStaticWebSeting(WebViewFactoryProvider.SETTING_GIF_FIRST_FRAME)).booleanValue();
                }
                return false;
            } catch (UnsatisfiedLinkError e) {
                e.printStackTrace();
                return false;
            } catch (Throwable th) {
                Log.e(Log.LOG_TAG, "getGifOneFrameEnabledExt error:".concat(String.valueOf(th)));
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static int getNetworkFlowExt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public static boolean getSaveNetworkTrafficExt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public static int getSavingBytesExt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public static boolean getSpdyNPNEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean isNA2WebEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    return ((Boolean) WebViewFactory.getProvider().getStaticWebSeting(WebViewFactoryProvider.SETTING_NA2_WEB_ENABLE)).booleanValue();
                }
                return false;
            } catch (UnsatisfiedLinkError e) {
                e.printStackTrace();
                return false;
            } catch (Throwable th) {
                Log.e(Log.LOG_TAG, "getEnableSpdyExt error:".concat(String.valueOf(th)));
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static void setDefaultEnableJsPromptSailor(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65553, null, z) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    WebViewFactory.getProvider().setStaticWebSeting(WebViewFactoryProvider.SETTING_ENABLE_JS_PROMPT, Boolean.valueOf(z));
                }
            } catch (UnsatisfiedLinkError e) {
                e.printStackTrace();
            } catch (Throwable th) {
                Log.e(Log.LOG_TAG, "setDefaultEnableJsPromptSailor error:".concat(String.valueOf(th)));
            }
        }
    }

    public static void setDefaultJsCheckPolicySailor(BdJsCheckPolicy bdJsCheckPolicy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, null, bdJsCheckPolicy) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    WebViewFactory.getProvider().setStaticWebSeting(WebViewFactoryProvider.SETTING_JS_CHECK_POLICY, bdJsCheckPolicy);
                }
            } catch (UnsatisfiedLinkError e) {
                e.printStackTrace();
            } catch (Throwable th) {
                Log.e(Log.LOG_TAG, "setDefaultEnableJsPromptSailor error:".concat(String.valueOf(th)));
            }
        }
    }

    public static void setEnableNA2Web(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65555, null, z) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    WebViewFactory.getProvider().setStaticWebSeting(WebViewFactoryProvider.SETTING_NA2_WEB_ENABLE, Boolean.valueOf(z));
                }
            } catch (UnsatisfiedLinkError e) {
                e.printStackTrace();
            } catch (Throwable th) {
                Log.e(Log.LOG_TAG, "setDefaultEnableJsPromptSailor error:".concat(String.valueOf(th)));
            }
        }
    }

    public static void setEnableOverSeasProxyExt(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65556, null, z) == null) {
        }
    }

    public static void setEnableProxyExt(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65557, null, z) == null) {
        }
    }

    public static void setEnableSpdyExt(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65558, null, z) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    WebViewFactory.getProvider().setStaticWebSeting(WebViewFactoryProvider.SETTING_SPDY, Boolean.valueOf(z));
                }
            } catch (UnsatisfiedLinkError e) {
                e.printStackTrace();
            } catch (Throwable th) {
                Log.e(Log.LOG_TAG, "setEnableSpdyExt error:".concat(String.valueOf(th)));
            }
        }
    }

    public static void setGifOneFrameEnabledExt(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65559, null, z) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    WebViewFactory.getProvider().setStaticWebSeting(WebViewFactoryProvider.SETTING_GIF_FIRST_FRAME, Boolean.valueOf(z));
                }
            } catch (UnsatisfiedLinkError e) {
                e.printStackTrace();
            } catch (Throwable th) {
                Log.e(Log.LOG_TAG, "setGifOneFrameEnabledExt error:".concat(String.valueOf(th)));
            }
        }
    }

    public static void setHijackEnv(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65560, null, z) == null) {
        }
    }

    public static void setNavigationInterceptionEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65561, null, z) == null) {
        }
    }

    public static void setSaveNetworkTrafficExt(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65562, null, z) == null) {
        }
    }

    public static void setSpdyNPNEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65563, null, z) == null) {
        }
    }

    public boolean enableSmoothTransition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            WebSettings webSettings = this.mWebSettings;
            if (webSettings != null) {
                return webSettings.enableSmoothTransition();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean getAllowContentAccess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mWebSettings.getAllowFileAccess() : invokeV.booleanValue;
    }

    public boolean getAllowFileAccess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mWebSettings.getAllowFileAccess() : invokeV.booleanValue;
    }

    public boolean getAllowFileAccessFromFileURLs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mWebSettings.getAllowFileAccessFromFileURLs() : invokeV.booleanValue;
    }

    public boolean getAllowUniversalAccessFromFileURLs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mWebSettings.getAllowUniversalAccessFromFileURLs() : invokeV.booleanValue;
    }

    public synchronized boolean getBlockNetworkImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                if (this.mWebSettings != null) {
                    return this.mWebSettings.getBlockNetworkImage();
                }
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public synchronized boolean getBlockNetworkLoads() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this) {
                if (this.mWebSettings != null) {
                    return this.mWebSettings.getBlockNetworkLoads();
                }
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public boolean getBuiltInZoomControls() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            WebSettings webSettings = this.mWebSettings;
            if (webSettings != null) {
                return webSettings.getBuiltInZoomControls();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public int getCacheMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mWebSettings.getCacheMode() : invokeV.intValue;
    }

    public synchronized String getCursiveFontFamily() {
        InterceptResult invokeV;
        String cursiveFontFamily;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            synchronized (this) {
                cursiveFontFamily = this.mWebSettings.getCursiveFontFamily();
            }
            return cursiveFontFamily;
        }
        return (String) invokeV.objValue;
    }

    public synchronized boolean getDatabaseEnabled() {
        InterceptResult invokeV;
        boolean databaseEnabled;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            synchronized (this) {
                databaseEnabled = this.mWebSettings.getDatabaseEnabled();
            }
            return databaseEnabled;
        }
        return invokeV.booleanValue;
    }

    public synchronized String getDatabasePath() {
        InterceptResult invokeV;
        String databasePath;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            synchronized (this) {
                databasePath = this.mWebSettings.getDatabasePath();
            }
            return databasePath;
        }
        return (String) invokeV.objValue;
    }

    public synchronized int getDefaultFixedFontSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            synchronized (this) {
                if (this.mWebSettings != null) {
                    return this.mWebSettings.getDefaultFixedFontSize();
                }
                return 1;
            }
        }
        return invokeV.intValue;
    }

    public synchronized int getDefaultFontSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            synchronized (this) {
                if (this.mWebSettings != null) {
                    return this.mWebSettings.getDefaultFontSize();
                }
                return 1;
            }
        }
        return invokeV.intValue;
    }

    public synchronized String getDefaultTextEncodingName() {
        InterceptResult invokeV;
        String defaultTextEncodingName;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            synchronized (this) {
                defaultTextEncodingName = this.mWebSettings.getDefaultTextEncodingName();
            }
            return defaultTextEncodingName;
        }
        return (String) invokeV.objValue;
    }

    public WebSettings.ZoomDensity getDefaultZoom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? WebSettings.ZoomDensity.MEDIUM : (WebSettings.ZoomDensity) invokeV.objValue;
    }

    public int getDisabledActionModeMenuItems() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            WebSettings webSettings = this.mWebSettings;
            if (webSettings != null) {
                return webSettings.getDisabledActionModeMenuItems();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean getDisplayZoomControls() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            WebSettings webSettings = this.mWebSettings;
            if (webSettings != null) {
                return webSettings.getDisplayZoomControls();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public synchronized boolean getDomStorageEnabled() {
        InterceptResult invokeV;
        boolean domStorageEnabled;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            synchronized (this) {
                domStorageEnabled = this.mWebSettings.getDomStorageEnabled();
            }
            return domStorageEnabled;
        }
        return invokeV.booleanValue;
    }

    public boolean getEnableJsPromptSailor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.mWebSettings.getEnableJsPrompt() : invokeV.booleanValue;
    }

    public synchronized String getFantasyFontFamily() {
        InterceptResult invokeV;
        String fantasyFontFamily;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            synchronized (this) {
                fantasyFontFamily = this.mWebSettings.getFantasyFontFamily();
            }
            return fantasyFontFamily;
        }
        return (String) invokeV.objValue;
    }

    public synchronized String getFixedFontFamily() {
        InterceptResult invokeV;
        String fixedFontFamily;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            synchronized (this) {
                fixedFontFamily = this.mWebSettings.getFixedFontFamily();
            }
            return fixedFontFamily;
        }
        return (String) invokeV.objValue;
    }

    public synchronized boolean getJavaScriptCanOpenWindowsAutomatically() {
        InterceptResult invokeV;
        boolean javaScriptCanOpenWindowsAutomatically;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            synchronized (this) {
                javaScriptCanOpenWindowsAutomatically = this.mWebSettings.getJavaScriptCanOpenWindowsAutomatically();
            }
            return javaScriptCanOpenWindowsAutomatically;
        }
        return invokeV.booleanValue;
    }

    public synchronized boolean getJavaScriptEnabled() {
        InterceptResult invokeV;
        boolean javaScriptEnabled;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            synchronized (this) {
                javaScriptEnabled = this.mWebSettings.getJavaScriptEnabled();
            }
            return javaScriptEnabled;
        }
        return invokeV.booleanValue;
    }

    public synchronized WebSettings.LayoutAlgorithm getLayoutAlgorithm() {
        InterceptResult invokeV;
        WebSettings.LayoutAlgorithm layoutAlgorithm;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            synchronized (this) {
                layoutAlgorithm = this.mWebSettings.getLayoutAlgorithm();
            }
            return layoutAlgorithm;
        }
        return (WebSettings.LayoutAlgorithm) invokeV.objValue;
    }

    public boolean getLightTouchEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.mWebSettings.getLightTouchEnabled() : invokeV.booleanValue;
    }

    public boolean getLoadWithOverviewMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.mWebSettings.getLoadsImagesAutomatically() : invokeV.booleanValue;
    }

    public synchronized boolean getLoadsImagesAutomatically() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            synchronized (this) {
                if (this.mWebSettings != null) {
                    return this.mWebSettings.getLoadsImagesAutomatically();
                }
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public boolean getMediaPlaybackRequiresUserGesture() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            WebSettings webSettings = this.mWebSettings;
            if (webSettings != null) {
                return webSettings.getMediaPlaybackRequiresUserGesture();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public synchronized int getMinimumFontSize() {
        InterceptResult invokeV;
        int minimumFontSize;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            synchronized (this) {
                minimumFontSize = this.mWebSettings.getMinimumFontSize();
            }
            return minimumFontSize;
        }
        return invokeV.intValue;
    }

    public synchronized int getMinimumLogicalFontSize() {
        InterceptResult invokeV;
        int minimumLogicalFontSize;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            synchronized (this) {
                minimumLogicalFontSize = this.mWebSettings.getMinimumLogicalFontSize();
            }
            return minimumLogicalFontSize;
        }
        return invokeV.intValue;
    }

    public int getMixedContentMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            WebSettings webSettings = this.mWebSettings;
            if (webSettings != null) {
                return webSettings.getMixedContentMode();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public synchronized String getSansSerifFontFamily() {
        InterceptResult invokeV;
        String sansSerifFontFamily;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            synchronized (this) {
                sansSerifFontFamily = this.mWebSettings.getSansSerifFontFamily();
            }
            return sansSerifFontFamily;
        }
        return (String) invokeV.objValue;
    }

    public boolean getSaveFormData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.mWebSettings.getSaveFormData() : invokeV.booleanValue;
    }

    public boolean getSavePassword() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.mWebSettings.getSavePassword() : invokeV.booleanValue;
    }

    public synchronized String getSerifFontFamily() {
        InterceptResult invokeV;
        String serifFontFamily;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            synchronized (this) {
                serifFontFamily = this.mWebSettings.getSerifFontFamily();
            }
            return serifFontFamily;
        }
        return (String) invokeV.objValue;
    }

    public synchronized String getStandardFontFamily() {
        InterceptResult invokeV;
        String standardFontFamily;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            synchronized (this) {
                standardFontFamily = this.mWebSettings.getStandardFontFamily();
            }
            return standardFontFamily;
        }
        return (String) invokeV.objValue;
    }

    public synchronized int getTextZoom() {
        InterceptResult invokeV;
        int textZoom;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            synchronized (this) {
                textZoom = this.mWebSettings.getTextZoom();
            }
            return textZoom;
        }
        return invokeV.intValue;
    }

    public synchronized boolean getUseWideViewPort() {
        InterceptResult invokeV;
        boolean useWideViewPort;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            synchronized (this) {
                useWideViewPort = this.mWebSettings.getUseWideViewPort();
            }
            return useWideViewPort;
        }
        return invokeV.booleanValue;
    }

    public synchronized String getUserAgentString() {
        InterceptResult invokeV;
        String userAgentString;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            synchronized (this) {
                userAgentString = this.mWebSettings.getUserAgentString();
            }
            return userAgentString;
        }
        return (String) invokeV.objValue;
    }

    public String getWebViewFrameNameSailor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.mWebSettings.getWebViewFrameName() : (String) invokeV.objValue;
    }

    public boolean isGestrueBackForwardEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            WebSettings webSettings = this.mWebSettings;
            if (webSettings != null) {
                return webSettings.getBackForwardAnimationEnable();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isGestrueBackForwardEnabledInternal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            WebSettings webSettings = this.mWebSettings;
            if (webSettings != null) {
                return webSettings.getBackForwardAnimationEnableInternal();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void setAllowContentAccess(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z) == null) {
            this.mWebSettings.setAllowFileAccess(z);
        }
    }

    public void setAllowFileAccess(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048620, this, z) == null) {
            this.mWebSettings.setAllowFileAccess(z);
        }
    }

    public void setAllowFileAccessFromFileURLs(boolean z) {
        WebSettings webSettings;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048621, this, z) == null) || (webSettings = this.mWebSettings) == null) {
            return;
        }
        webSettings.setAllowFileAccess(z);
    }

    public void setAllowUniversalAccessFromFileURLs(boolean z) {
        WebSettings webSettings;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048622, this, z) == null) || (webSettings = this.mWebSettings) == null) {
            return;
        }
        webSettings.setAllowUniversalAccessFromFileURLs(z);
    }

    public synchronized void setAppCacheEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048623, this, z) == null) {
            synchronized (this) {
                this.mWebSettings.setAppCacheEnabled(z);
            }
        }
    }

    public synchronized void setAppCacheMaxSize(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048624, this, j) == null) {
            synchronized (this) {
                this.mWebSettings.setAppCacheMaxSize(j);
            }
        }
    }

    public synchronized void setAppCachePath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, str) == null) {
            synchronized (this) {
                this.mWebSettings.setAppCachePath(str);
            }
        }
    }

    public void setBackForwardGesture(boolean z) {
        WebSettings webSettings;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048626, this, z) == null) || (webSettings = this.mWebSettings) == null) {
            return;
        }
        webSettings.setBackForwardAnimationEnable(z);
    }

    public void setBackForwardGestureInternal(boolean z) {
        WebSettings webSettings;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048627, this, z) == null) || (webSettings = this.mWebSettings) == null) {
            return;
        }
        webSettings.setBackForwardAnimationEnableInternal(z);
    }

    public synchronized void setBlockNetworkImage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048628, this, z) == null) {
            synchronized (this) {
                if (this.mWebSettings != null) {
                    this.mWebSettings.setBlockNetworkImage(z);
                }
            }
        }
    }

    public synchronized void setBlockNetworkLoads(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048629, this, z) == null) {
            synchronized (this) {
                if (this.mWebSettings != null) {
                    this.mWebSettings.setBlockNetworkLoads(z);
                }
            }
        }
    }

    public void setBuiltInZoomControls(boolean z) {
        WebSettings webSettings;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048630, this, z) == null) || (webSettings = this.mWebSettings) == null) {
            return;
        }
        webSettings.setBuiltInZoomControls(z);
    }

    public void setCacheMode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048631, this, i) == null) {
            this.mWebSettings.setCacheMode(i);
        }
    }

    @Deprecated
    public synchronized void setCodeCacheSetting(WebSettings.CodeCacheSetting codeCacheSetting) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, codeCacheSetting) == null) {
            synchronized (this) {
                this.mWebSettings.setCodeCacheSetting(codeCacheSetting);
            }
        }
    }

    public synchronized void setCursiveFontFamily(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, str) == null) {
            synchronized (this) {
                this.mWebSettings.setCursiveFontFamily(str);
            }
        }
    }

    public synchronized void setDatabaseEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048634, this, z) == null) {
            synchronized (this) {
                this.mWebSettings.setDatabaseEnabled(z);
            }
        }
    }

    public synchronized void setDatabasePath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, str) == null) {
            synchronized (this) {
                this.mWebSettings.setDatabasePath(str);
            }
        }
    }

    public synchronized void setDefaultFixedFontSize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048636, this, i) == null) {
            synchronized (this) {
                if (this.mWebSettings != null) {
                    this.mWebSettings.setDefaultFontSize(i);
                }
            }
        }
    }

    public synchronized void setDefaultFontSize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048637, this, i) == null) {
            synchronized (this) {
                this.mWebSettings.setDefaultFontSize(i);
            }
        }
    }

    public synchronized void setDefaultTextEncodingName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, str) == null) {
            synchronized (this) {
                this.mWebSettings.setDefaultTextEncodingName(str);
            }
        }
    }

    public void setDefaultZoom(WebSettings.ZoomDensity zoomDensity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, zoomDensity) == null) {
            this.mWebSettings.setDefaultZoom(zoomDensity);
        }
    }

    public void setDisabledActionModeMenuItems(int i) {
        WebSettings webSettings;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048640, this, i) == null) || (webSettings = this.mWebSettings) == null) {
            return;
        }
        webSettings.setDisabledActionModeMenuItems(i);
    }

    public void setDisplayZoomControls(boolean z) {
        WebSettings webSettings;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048641, this, z) == null) || (webSettings = this.mWebSettings) == null) {
            return;
        }
        webSettings.setDisplayZoomControls(z);
    }

    public synchronized void setDomStorageEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048642, this, z) == null) {
            synchronized (this) {
                this.mWebSettings.setDomStorageEnabled(z);
            }
        }
    }

    public void setEnableJsPromptSailor(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048643, this, z) == null) {
            this.mWebSettings.setEnableJsPrompt(z);
        }
    }

    public void setEnableSmoothTransition(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048644, this, z) == null) {
            this.mWebSettings.setEnableSmoothTransition(z);
        }
    }

    public synchronized void setFantasyFontFamily(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048645, this, str) == null) {
            synchronized (this) {
                this.mWebSettings.setFantasyFontFamily(str);
            }
        }
    }

    public synchronized void setFixedFontFamily(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, str) == null) {
            synchronized (this) {
                this.mWebSettings.setFixedFontFamily(str);
            }
        }
    }

    public synchronized void setGeolocationDatabasePath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048647, this, str) == null) {
            synchronized (this) {
                this.mWebSettings.setGeolocationDatabasePath(str);
            }
        }
    }

    public void setGeolocationEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048648, this, z) == null) {
            this.mWebSettings.setGeolocationEnabled(z);
        }
    }

    public synchronized void setJavaScriptCanOpenWindowsAutomatically(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048649, this, z) == null) {
            synchronized (this) {
                this.mWebSettings.setJavaScriptCanOpenWindowsAutomatically(z);
            }
        }
    }

    public synchronized void setJavaScriptEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048650, this, z) == null) {
            synchronized (this) {
                if (this.mWebSettings != null) {
                    this.mWebSettings.setJavaScriptEnabled(z);
                }
            }
        }
    }

    public void setJsCallFullscreenEnable(boolean z) {
        WebSettings webSettings;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048651, this, z) == null) || (webSettings = this.mWebSettings) == null) {
            return;
        }
        webSettings.setJsCallFullscreenEnable(z);
    }

    public synchronized void setLayoutAlgorithm(WebSettings.LayoutAlgorithm layoutAlgorithm) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048652, this, layoutAlgorithm) == null) {
            synchronized (this) {
                this.mWebSettings.setLayoutAlgorithm(layoutAlgorithm);
            }
        }
    }

    public void setLightTouchEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048653, this, z) == null) {
            this.mWebSettings.setLightTouchEnabled(z);
        }
    }

    public void setLoadWithOverviewMode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048654, this, z) == null) {
            this.mWebSettings.setLoadWithOverviewMode(z);
        }
    }

    public synchronized void setLoadsImagesAutomatically(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048655, this, z) == null) {
            synchronized (this) {
                if (this.mWebSettings != null) {
                    this.mWebSettings.setLoadsImagesAutomatically(z);
                }
            }
        }
    }

    public void setMediaPlaybackRequiresUserGesture(boolean z) {
        WebSettings webSettings;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048656, this, z) == null) || (webSettings = this.mWebSettings) == null) {
            return;
        }
        webSettings.setMediaPlaybackRequiresUserGesture(z);
    }

    public synchronized void setMinimumFontSize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048657, this, i) == null) {
            synchronized (this) {
                this.mWebSettings.setMinimumFontSize(i);
            }
        }
    }

    public synchronized void setMinimumLogicalFontSize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048658, this, i) == null) {
            synchronized (this) {
                this.mWebSettings.setMinimumLogicalFontSize(i);
            }
        }
    }

    public void setMixedContentMode(int i) {
        WebSettings webSettings;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048659, this, i) == null) || (webSettings = this.mWebSettings) == null) {
            return;
        }
        webSettings.setMixedContentMode(i);
    }

    public void setNeedInitialFocus(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048660, this, z) == null) {
            this.mWebSettings.setNeedInitialFocus(z);
        }
    }

    public synchronized void setPageCacheCapacity(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048661, this, i) == null) {
            synchronized (this) {
                this.mWebSettings.setPageCacheCapacity(i);
            }
        }
    }

    public synchronized void setPluginState(WebSettings.PluginState pluginState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048662, this, pluginState) == null) {
            synchronized (this) {
                this.mWebSettings.setPluginState(pluginState);
            }
        }
    }

    public synchronized void setPrivateBrowsingEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048663, this, z) == null) {
            synchronized (this) {
                this.mWebSettings.setPrivateBrowsingEnabled(z);
            }
        }
    }

    public synchronized void setRenderPriority(WebSettings.RenderPriority renderPriority) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048664, this, renderPriority) == null) {
            synchronized (this) {
                this.mWebSettings.setRenderPriority(renderPriority);
            }
        }
    }

    public synchronized void setSansSerifFontFamily(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048665, this, str) == null) {
            synchronized (this) {
                this.mWebSettings.setSansSerifFontFamily(str);
            }
        }
    }

    public void setSaveFormData(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048666, this, z) == null) {
            this.mWebSettings.setSaveFormData(z);
        }
    }

    public void setSavePassword(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048667, this, z) == null) {
            this.mWebSettings.setSavePassword(z);
        }
    }

    public synchronized void setSerifFontFamily(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048668, this, str) == null) {
            synchronized (this) {
                this.mWebSettings.setSerifFontFamily(str);
            }
        }
    }

    public synchronized void setStandardFontFamily(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048669, this, str) == null) {
            synchronized (this) {
                this.mWebSettings.setStandardFontFamily(str);
            }
        }
    }

    public synchronized void setSupportMultipleWindows(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048670, this, z) == null) {
            synchronized (this) {
                this.mWebSettings.setSupportMultipleWindows(z);
            }
        }
    }

    public void setSupportZoom(boolean z) {
        WebSettings webSettings;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048671, this, z) == null) || (webSettings = this.mWebSettings) == null) {
            return;
        }
        webSettings.setSupportZoom(z);
    }

    public synchronized void setTextZoom(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048672, this, i) == null) {
            synchronized (this) {
                this.mWebSettings.setTextZoom(i);
            }
        }
    }

    public synchronized void setUseWideViewPort(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048673, this, z) == null) {
            synchronized (this) {
                this.mWebSettings.setUseWideViewPort(z);
            }
        }
    }

    public synchronized void setUserAgentString(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048674, this, str) == null) {
            synchronized (this) {
                this.mWebSettings.setUserAgentString(str);
            }
        }
    }

    public void setWebSettings(WebSettings webSettings) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048675, this, webSettings) == null) || webSettings == null) {
            return;
        }
        this.mWebSettings = webSettings;
    }

    public void setWebViewFrameNameSailor(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048676, this, str) == null) {
            this.mWebSettings.setWebViewFrameName(str);
        }
    }

    public void setZeusMutedEnable(boolean z) {
        WebSettings webSettings;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048677, this, z) == null) || (webSettings = this.mWebSettings) == null) {
            return;
        }
        webSettings.setZeusMutedEnable(z);
    }

    public synchronized boolean supportMultipleWindows() {
        InterceptResult invokeV;
        boolean supportMultipleWindows;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048678, this)) == null) {
            synchronized (this) {
                supportMultipleWindows = this.mWebSettings.supportMultipleWindows();
            }
            return supportMultipleWindows;
        }
        return invokeV.booleanValue;
    }

    public boolean supportZoom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048679, this)) == null) {
            WebSettings webSettings = this.mWebSettings;
            if (webSettings != null) {
                return webSettings.supportZoom();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public synchronized boolean useCodeCacheSetting(WebSettings.CodeCacheSetting codeCacheSetting) {
        InterceptResult invokeL;
        boolean useCodeCacheSetting;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048680, this, codeCacheSetting)) == null) {
            synchronized (this) {
                useCodeCacheSetting = this.mWebSettings.useCodeCacheSetting(codeCacheSetting);
            }
            return useCodeCacheSetting;
        }
        return invokeL.booleanValue;
    }
}
