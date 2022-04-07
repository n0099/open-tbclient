package com.baidu.browser.sailor;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.browser.core.INoProGuard;
import com.baidu.browser.sailor.platform.BdSailorPlatform;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebSettings;
import com.baidu.webkit.sdk.WebViewFactory;
import com.baidu.webkit.sdk.WebViewFactoryProvider;
/* loaded from: classes.dex */
public final class BdSailorSettings implements INoProGuard {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mAdBlockEnable;
    public boolean mDebugEnable;
    public String mEmulatedUA;
    public boolean mImageViewer;
    public boolean mIsAllowTransCode;
    public boolean mIsAllowTransLang;
    public boolean mIsGifFirstFrameOnly;
    public boolean mNightMode;
    public boolean mOpenEyeShieldMode;
    public boolean mOpenOverSeasProxy;
    public boolean mOpenSpdy;
    public String mSafeCheck;
    public boolean mSailorMonitorEnable;
    public boolean mSaveFlow;
    public boolean mUaEmulate;
    public boolean mUrlSecureCheck;

    public BdSailorSettings() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mIsAllowTransCode = false;
        this.mIsAllowTransLang = true;
        this.mAdBlockEnable = false;
        this.mSaveFlow = true;
        this.mImageViewer = true;
        this.mUrlSecureCheck = true;
        this.mSailorMonitorEnable = true;
    }

    private boolean getStaticWebSeting(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, str)) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    return ((Boolean) WebViewFactory.getProvider().getStaticWebSeting(str)).booleanValue();
                }
                return false;
            } catch (UnsatisfiedLinkError e) {
                e.printStackTrace();
                return false;
            } catch (Throwable th) {
                Log.e(Log.LOG_TAG, "getStaticWebSeting error:".concat(String.valueOf(th)));
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    private void setStaticWebSeting(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65538, this, str, z) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    WebViewFactory.getProvider().setStaticWebSeting(str, Boolean.valueOf(z));
                }
            } catch (UnsatisfiedLinkError e) {
                e.printStackTrace();
            } catch (Throwable th) {
                Log.e(Log.LOG_TAG, "setDefaultEnableJsPromptSailor error:".concat(String.valueOf(th)));
            }
        }
    }

    public final String getEmulatedUA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                return WebViewFactory.hasProvider() ? (String) WebViewFactory.getProvider().getStaticWebSeting(WebViewFactoryProvider.SETTING_UA_EMULATE) : "";
            } catch (UnsatisfiedLinkError e) {
                e.printStackTrace();
                return "";
            } catch (Throwable th) {
                Log.e(Log.LOG_TAG, "getStaticWebSeting error:".concat(String.valueOf(th)));
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public final boolean getOpenEyeShieldMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mOpenEyeShieldMode : invokeV.booleanValue;
    }

    public final String getSafeCheck() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mSafeCheck : (String) invokeV.objValue;
    }

    public final boolean getSailorMonitorEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? getStaticWebSeting(WebViewFactoryProvider.SETTING_MONITOR) : invokeV.booleanValue;
    }

    public final boolean isAdBlockEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? getStaticWebSeting(WebViewFactoryProvider.SETTING_AD_BLOCK) : invokeV.booleanValue;
    }

    public final boolean isAllowTransCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mIsAllowTransCode : invokeV.booleanValue;
    }

    public final boolean isAllowTransLang() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mIsAllowTransLang : invokeV.booleanValue;
    }

    public final boolean isDebugEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? getStaticWebSeting("Debug") : invokeV.booleanValue;
    }

    public final boolean isGifFirstFrameOnly() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? getStaticWebSeting(WebViewFactoryProvider.SETTING_GIF_FIRST_FRAME) : invokeV.booleanValue;
    }

    public final boolean isJavaScriptEnabledOnFileScheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? getStaticWebSeting(WebViewFactoryProvider.SETTING_JS_ENABLE_ON_FILE_SCHEMA) : invokeV.booleanValue;
    }

    public final boolean isNightTheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mNightMode : invokeV.booleanValue;
    }

    public final boolean isOpenOverSeasProxy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mOpenOverSeasProxy : invokeV.booleanValue;
    }

    public final boolean isOpenSpdy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? getStaticWebSeting(WebViewFactoryProvider.SETTING_SPDY) : invokeV.booleanValue;
    }

    public final boolean isPageFreezeDisable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? getStaticWebSeting(WebViewFactoryProvider.SETTING_PAGE_FREEZE) : invokeV.booleanValue;
    }

    public final boolean isSaveFlow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? getStaticWebSeting(WebViewFactoryProvider.SETTING_SAVE_FLOW) : invokeV.booleanValue;
    }

    public final boolean isUaEmulateOn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? getStaticWebSeting(WebViewFactoryProvider.SETTING_UA_EMULATE) : invokeV.booleanValue;
    }

    public final boolean isUrlSecureCheck() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? getStaticWebSeting(WebViewFactoryProvider.SETTING_URL_SAFE_CHECK) : invokeV.booleanValue;
    }

    public final void setAdBlockEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            setStaticWebSeting(WebViewFactoryProvider.SETTING_AD_BLOCK, z);
        }
    }

    public final void setAllowTransCode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.mIsAllowTransCode = z;
        }
    }

    public final void setAllowTransLang(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.mIsAllowTransLang = z;
        }
    }

    public final void setDebugEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            setStaticWebSeting("Debug", z);
        }
    }

    public final void setEmulatedUA(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.mEmulatedUA = str;
        }
    }

    @Deprecated
    public final void setFixWebViewSecurityHoles(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            setStaticWebSeting(WebViewFactoryProvider.SETTING_FIX_WEBVIEW_HOLES, z);
        }
    }

    public final void setGifFirstFrameOnly(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            setStaticWebSeting(WebViewFactoryProvider.SETTING_GIF_FIRST_FRAME, z);
        }
    }

    public final void setJavaScriptEnabledOnFileScheme(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            setStaticWebSeting(WebViewFactoryProvider.SETTING_JS_ENABLE_ON_FILE_SCHEMA, z);
        }
    }

    public final void setNightTheme(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            setStaticWebSeting(WebViewFactoryProvider.SETTING_NIGHT_THEME, z);
            this.mNightMode = z;
            BdSailorPlatform.getInstance().setNightMode(z);
        }
    }

    public final void setNoPicMode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            setStaticWebSeting(WebViewFactoryProvider.SETTING_NO_IMAGE_MODE, z);
        }
    }

    public final void setOpenEyeShieldMode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            this.mOpenEyeShieldMode = z;
            setStaticWebSeting(WebViewFactoryProvider.SETTING_EYE_SHIELD_MODE, z);
        }
    }

    public final void setOpenOverSeasProxy(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            this.mOpenOverSeasProxy = z;
        }
    }

    public final void setOpenSpdy(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            setStaticWebSeting(WebViewFactoryProvider.SETTING_SPDY, z);
        }
    }

    public final void setProxyType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            WebSettings.ProxyType proxyType = WebSettings.ProxyType.NO_PROXY;
            if (this.mOpenSpdy) {
                proxyType = this.mOpenOverSeasProxy ? WebSettings.ProxyType.SPDYANDOVERSEAS_PROXY : WebSettings.ProxyType.SPDY_PROXY;
            } else if (this.mOpenOverSeasProxy) {
                proxyType = WebSettings.ProxyType.OVERSEAS_PROXY;
            }
            try {
                if (WebViewFactory.hasProvider()) {
                    WebViewFactory.getProvider().setStaticWebSeting(WebViewFactoryProvider.SETTING_PROXY_TYPE, new Integer(proxyType.ordinal()));
                }
            } catch (UnsatisfiedLinkError e) {
                e.printStackTrace();
            } catch (Throwable th) {
                Log.e(Log.LOG_TAG, "setDefaultEnableJsPromptSailor error:".concat(String.valueOf(th)));
            }
        }
    }

    public final void setSafeCheck(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, str) == null) {
            this.mSafeCheck = str;
        }
    }

    public final void setSailorMonitorEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
            setStaticWebSeting(WebViewFactoryProvider.SETTING_MONITOR, z);
        }
    }

    public final void setSaveFlow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z) == null) {
            int networkType = BdSailorPlatform.getInstance().getNetworkType();
            z = (networkType == 1 || -1 == networkType) ? false : false;
            this.mSaveFlow = z;
            setStaticWebSeting(WebViewFactoryProvider.SETTING_SAVE_FLOW, z);
        }
    }

    public final void setUaEmulateOn(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
            this.mUaEmulate = z;
        }
    }

    public final void setUrlSecureCheck(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z) == null) {
            setStaticWebSeting(WebViewFactoryProvider.SETTING_URL_SAFE_CHECK, z);
        }
    }
}
