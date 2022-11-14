package com.baidu.browser.sailor;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.view.KeyEvent;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.util.CommonParam;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.browser.core.INoProGuard;
import com.baidu.browser.sailor.feature.a;
import com.baidu.browser.sailor.platform.BdSailorPlatform;
import com.baidu.browser.sailor.platform.nativeability.BdGeoLocationInfo;
import com.baidu.browser.sailor.webkit.loader.BdWebkitManager;
import com.baidu.browser.sailor.webkit.loader.IWebkitLoaderListener;
import com.baidu.browser.sailor.webkit.update.BdZeusUpdate;
import com.baidu.tieba.uw;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.GlobalConstants;
import com.baidu.webkit.internal.blink.EngineManager;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
import com.baidu.webkit.internal.monitor.SessionMonitorEngine;
import com.baidu.webkit.internal.utils.NetWorkUtils;
import com.baidu.webkit.sdk.ICronetListenerInterface;
import com.baidu.webkit.sdk.INetProbeInterface;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
import com.baidu.webkit.sdk.WebViewDatabase;
import com.baidu.webkit.sdk.WebViewFactory;
import com.baidu.webkit.sdk.dumper.CrashCallback;
import com.baidu.webkit.sdk.dumper.ZwDebug;
import com.baidu.webkit.sdk.location.ZeusGeoLocationInfo;
import com.baidu.webkit.sdk.performance.ZeusPerformanceTiming;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class BdSailor implements INoProGuard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String LOG_TAG = "BdSailor";
    public static BdSailor sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public BdSailorClient mClient;
    public BdSailorWebView mCurSailorWebView;
    public boolean mIsInit;
    public BdSailorSettings mSettings;
    public HashMap<String, Object> mStaticWebSettings;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1136340801, "Lcom/baidu/browser/sailor/BdSailor;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1136340801, "Lcom/baidu/browser/sailor/BdSailor;");
        }
    }

    public BdSailor() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mIsInit = false;
        Log.d(LOG_TAG, "BdSailor::BdSailor");
        this.mClient = new BdSailorClient();
    }

    public static void addForceInitListener(WebKitFactory.IForceInitZeusListener iForceInitZeusListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, iForceInitZeusListener) == null) {
            WebKitFactory.addListener(iForceInitZeusListener);
        }
    }

    public static void crashIntentionally(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65539, null, i) == null) {
            Log.d("CRASHPAD", "bdsailor.crashIntentionally type:".concat(String.valueOf(i)));
            if (i == 4) {
                ZwDebug.crashIntentionally(2);
            } else if (i != 5) {
                Log.d("CRASHPAD", "bdsailor.crashIntentionally default type:".concat(String.valueOf(i)));
            } else {
                ZwDebug.crashIntentionally(3);
            }
        }
    }

    private void enableFeatureInternal(String str) {
        a featureByName;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str) == null) || TextUtils.isEmpty(str) || (featureByName = BdSailorPlatform.getInstance().getFeatureByName(str)) == null) {
            return;
        }
        featureByName.enable();
    }

    public static synchronized BdSailor getInstance() {
        InterceptResult invokeV;
        BdSailor bdSailor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            synchronized (BdSailor.class) {
                if (sInstance == null) {
                    sInstance = new BdSailor();
                }
                bdSailor = sInstance;
            }
            return bdSailor;
        }
        return (BdSailor) invokeV.objValue;
    }

    public static void initCookieSyncManager(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, context) == null) {
            BdSailorPlatform.initCookieSyncManager(context);
        }
    }

    private void notifyUserPrivacyConfirmedInner() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65543, this) == null) && BdSailorPlatform.getInstance().isNeedUpdateKernel() && getAppContext() != null) {
            Log.i(EngineManager.LOG_TAG, "start check zeus update after notifyUserPrivacyConfirmInner");
            getAppContext();
            BdZeusUpdate.a().c(getAppContext());
        }
    }

    private void setSailorFeatureListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
        }
    }

    public void OnAppEnterBackground() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Log.i("huqin-ps2-app", "OnAppEnterBackground");
            SessionMonitorEngine.getInstance().OnAppEnterBackground();
        }
    }

    public void OnAppEnterForeground() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Log.i("huqin-ps2-app", "OnAppEnterForeground");
            SessionMonitorEngine.getInstance().OnAppEnterForeground();
        }
    }

    public void addListener(IWebkitLoaderListener iWebkitLoaderListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iWebkitLoaderListener) == null) {
            BdSailorPlatform.getWebkitManager().addListener(iWebkitLoaderListener);
        }
    }

    public boolean checkZeusForceInit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? isWebkitInit() && WebKitFactory.isForceInitT7() : invokeV.booleanValue;
    }

    public void clearCache(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048580, this, z) == null) && isWebkitInit()) {
            BdSailorPlatform.getInstance().clearCache(z);
        }
    }

    public void clearPasswords(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, context) == null) && isWebkitInit()) {
            WebViewDatabase webViewDatabase = WebViewDatabase.getInstance(context);
            webViewDatabase.clearUsernamePassword();
            webViewDatabase.clearHttpAuthUsernamePassword();
        }
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            Log.d(LOG_TAG, "BdSailor::destroy");
            BdSailorPlatform.destroy();
            sInstance = null;
        }
    }

    public void disableFeature(String str) {
        a featureByName;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            WebViewFactory.getProvider().disableFeature(str);
            if (TextUtils.isEmpty(str) || (featureByName = BdSailorPlatform.getInstance().getFeatureByName(str)) == null) {
                return;
            }
            featureByName.disable();
        }
    }

    public void enableFeature(String str) {
        a featureByName;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            WebViewFactory.getProvider().enableFeature(str);
            if (TextUtils.isEmpty(str) || (featureByName = BdSailorPlatform.getInstance().getFeatureByName(str)) == null) {
                return;
            }
            featureByName.enable();
        }
    }

    public void exitFeature(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
        }
    }

    public Context getAppContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? BdSailorPlatform.getInstance().getAppContext() : (Context) invokeV.objValue;
    }

    public String getCookie(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) ? BdSailorPlatform.getInstance().getCookie(str) : (String) invokeL.objValue;
    }

    public BdSailorWebView getCurSailorWebView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mCurSailorWebView : (BdSailorWebView) invokeV.objValue;
    }

    public List<String> getCurrentPagePictureList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (getCurSailorWebView() == null || getCurSailorWebView().getWebViewExt() == null) {
                return null;
            }
            return getCurSailorWebView().getWebViewExt().getPictureUrlListExt();
        }
        return (List) invokeV.objValue;
    }

    public String getSDKVersionName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? WebKitFactory.getSdkVersionName() : (String) invokeV.objValue;
    }

    public BdSailorClient getSailorClient() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            BdSailorClient bdSailorClient = this.mClient;
            if (bdSailorClient == null) {
                Log.e(LOG_TAG, "SailorClient can not be NULL!");
                return new BdSailorClient();
            }
            return bdSailorClient;
        }
        return (BdSailorClient) invokeV.objValue;
    }

    @Nullable
    public ISailorCronetListenerInterface getSailorCronetListenerInterface() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            ICronetListenerInterface cronetListenerInterface = WebViewFactory.getCronetListenerInterface();
            if (cronetListenerInterface == null || !(cronetListenerInterface instanceof ISailorCronetListenerInterface)) {
                return null;
            }
            return (ISailorCronetListenerInterface) cronetListenerInterface;
        }
        return (ISailorCronetListenerInterface) invokeV.objValue;
    }

    @Nullable
    public ISailorNetProbeInterface getSailorNetProbeInterface() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            INetProbeInterface netProbeInterface = WebViewFactory.getNetProbeInterface();
            if (netProbeInterface == null || !(netProbeInterface instanceof ISailorNetProbeInterface)) {
                return null;
            }
            return (ISailorNetProbeInterface) netProbeInterface;
        }
        return (ISailorNetProbeInterface) invokeV.objValue;
    }

    public synchronized BdSailorSettings getSailorSettings() {
        InterceptResult invokeV;
        BdSailorSettings bdSailorSettings;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            synchronized (this) {
                if (this.mSettings == null) {
                    this.mSettings = new BdSailorSettings();
                }
                bdSailorSettings = this.mSettings;
            }
            return bdSailorSettings;
        }
        return (BdSailorSettings) invokeV.objValue;
    }

    public uw getStatic() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            BdSailorPlatform.getInstance();
            return BdSailorPlatform.getStatic();
        }
        return (uw) invokeV.objValue;
    }

    public String getZeusVersionName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? WebKitFactory.getZeusVersionName() : (String) invokeV.objValue;
    }

    public boolean hasPictureInCurrentPage(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, str)) == null) {
            List<String> currentPagePictureList = getCurrentPagePictureList();
            if (currentPagePictureList != null) {
                return currentPagePictureList.contains(str);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean init(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048598, this, context, str)) == null) {
            if (!this.mIsInit) {
                Log.d(LOG_TAG, "BdSailor::init");
                if (context == null) {
                    throw new RuntimeException("BdSailor::init aContext must not be null.");
                }
                boolean init = BdSailorPlatform.getInstance().init(context.getApplicationContext(), str);
                enableFeatureInternal(BdSailorConfig.SAILOR_BASE_SSL);
                enableFeatureInternal(BdSailorConfig.SAILOR_BASE_UPLOAD);
                enableFeatureInternal(BdSailorConfig.SAILOR_EXT_LIGHT_APP);
                setSailorFeatureListener();
                this.mIsInit = init;
            }
            return this.mIsInit;
        }
        return invokeLL.booleanValue;
    }

    public boolean init(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048599, this, context, str, str2)) == null) {
            boolean init = init(context, str);
            if (TextUtils.isEmpty(str2)) {
                str2 = CommonParam.getCUID(BdSailorPlatform.getInstance().getAppContext());
            }
            WebKitFactory.setCUIDString(str2);
            return init;
        }
        return invokeLLL.booleanValue;
    }

    @Deprecated
    public int initAdBlock() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return -1;
        }
        return invokeV.intValue;
    }

    public void initWebkit(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048601, this, str, z) == null) {
            initWebkit(str, z, (Class<? extends CrashCallback>) null);
        }
    }

    public void initWebkit(String str, boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{str, Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            if ((1 == i || 2 == i) && z) {
                WebKitFactory.forceInitT7(i);
            }
            initWebkit(str, z);
        }
    }

    public void initWebkit(String str, boolean z, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{str, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)}) == null) {
            WebKitFactory.setHttpCacheMbSize(i2);
            initWebkit(str, z, i);
        }
    }

    public void initWebkit(String str, boolean z, Class<? extends CrashCallback> cls) {
        StringBuilder sb;
        String zeusInitTiming;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048604, this, new Object[]{str, Boolean.valueOf(z), cls}) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            boolean z2 = BdWebkitManager.a.a == BdSailorPlatform.getWebkitManager().getWebkitType();
            ZeusPerformanceTiming.Stage stage = ZeusPerformanceTiming.Stage.Start;
            if (z2) {
                ZeusPerformanceTiming.record(stage, ZeusPerformanceTiming.KEY_INIT_SYS_WEBKIT);
            } else {
                ZeusPerformanceTiming.record(stage, ZeusPerformanceTiming.KEY_INIT_WEBKIT);
            }
            BdSailorPlatform.getInstance().initWebkit(str, z, cls);
            if (z2) {
                ZeusPerformanceTiming.record(ZeusPerformanceTiming.Stage.End, ZeusPerformanceTiming.KEY_INIT_SYS_WEBKIT);
                sb = new StringBuilder("initWebkit = ");
                sb.append(System.currentTimeMillis() - currentTimeMillis);
                sb.append(" ");
                zeusInitTiming = ZeusPerformanceTiming.getSysInitTiming();
            } else {
                ZeusPerformanceTiming.record(ZeusPerformanceTiming.Stage.End, ZeusPerformanceTiming.KEY_INIT_WEBKIT);
                sb = new StringBuilder("initWebkit = ");
                sb.append(System.currentTimeMillis() - currentTimeMillis);
                sb.append(" ");
                zeusInitTiming = ZeusPerformanceTiming.getZeusInitTiming();
            }
            sb.append(zeusInitTiming);
            android.util.Log.i(GlobalConstants.LOG_PER_TAG, sb.toString());
        }
    }

    public void installZeusFromDownload(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
            BdSailorPlatform.getWebkitManager().installZeusFromDownload(str);
        }
    }

    public boolean isFeatureEnable(String str) {
        InterceptResult invokeL;
        a featureByName;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, str)) == null) {
            if (TextUtils.isEmpty(str) || (featureByName = BdSailorPlatform.getInstance().getFeatureByName(str)) == null) {
                return false;
            }
            return featureByName.isEnable();
        }
        return invokeL.booleanValue;
    }

    public boolean isInit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.mIsInit : invokeV.booleanValue;
    }

    public boolean isWebkitInit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.mIsInit && BdSailorPlatform.getInstance().isWebkitInit() : invokeV.booleanValue;
    }

    public boolean isZeusForceInited() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? isWebkitInit() && WebKitFactory.isForceInitT7() && WebViewFactory.isForceZeusProviderInited() : invokeV.booleanValue;
    }

    public void notifyUserPrivacyConfirmIfNeeded(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048610, this, z) == null) || WebKitFactory.isUserPrivacyEnabled() == z) {
            return;
        }
        if (z) {
            notifyUserPrivacyConfirmedInner();
        }
        WebKitFactory.notifyUserPrivacyConfirmIfNeeded(z);
    }

    public void onAccountLoginSuccess(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, str) == null) {
        }
    }

    public void onActivityDestory(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, activity) == null) {
            Log.d(LOG_TAG, "BdSailor::onActivityDestory");
            BdSailorPlatform.getInstance().onActivityDestory(activity);
        }
    }

    public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048613, this, new Object[]{activity, Integer.valueOf(i), Integer.valueOf(i2), intent}) == null) {
            BdSailorPlatform.getInstance().onActivityResult(activity, i, i2, intent);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048614, this, i, keyEvent)) == null) {
            if (getCurSailorWebView() != null) {
                getCurSailorWebView().onKeyDown(i, keyEvent);
                return false;
            }
            return false;
        }
        return invokeIL.booleanValue;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048615, this, i, keyEvent)) == null) {
            if (getCurSailorWebView() != null) {
                getCurSailorWebView().onKeyUp(i, keyEvent);
                return false;
            }
            return false;
        }
        return invokeIL.booleanValue;
    }

    public void onLowMemory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
        }
    }

    public void onNetworkChanged(NetworkInfo networkInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, networkInfo) == null) {
            if (networkInfo != null && networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                BdSailorPlatform.getInstance().onReceivedNetworkType(networkInfo.getType());
            }
            NetWorkUtils.onNetWorkChanged(getAppContext(), networkInfo);
        }
    }

    public void onVideoGetUrl(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048618, this, str, str2) == null) {
        }
    }

    public void onWindowSwitched(BdSailorWebView bdSailorWebView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, bdSailorWebView) == null) {
        }
    }

    public void openUrlInBrowser(Activity activity, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048620, this, activity, str) == null) {
        }
    }

    public void pause() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048621, this) == null) && WebKitFactory.isUserPrivacyEnabled() && isInit()) {
            WebSettingsGlobalBlink.notifyPause();
            Log.d(LOG_TAG, "BdSailor::pause");
            BdSailorPlatform.getInstance().pause();
        }
    }

    public void removeForceInitListener(WebKitFactory.IForceInitZeusListener iForceInitZeusListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, iForceInitZeusListener) == null) {
            WebKitFactory.removeListener(iForceInitZeusListener);
        }
    }

    public void removeListener(IWebkitLoaderListener iWebkitLoaderListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, iWebkitLoaderListener) == null) {
            BdSailorPlatform.getWebkitManager().removeListener(iWebkitLoaderListener);
        }
    }

    public void requestFocusNodeHref(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048624, this, i) == null) {
        }
    }

    public void resume() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048625, this) == null) && WebKitFactory.isUserPrivacyEnabled() && isInit()) {
            WebSettingsGlobalBlink.notifyResume();
            Log.d(LOG_TAG, "BdSailor::resume");
            BdSailorPlatform.getInstance().resume();
        }
    }

    public void setCuid(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048626, this, str) == null) || TextUtils.isEmpty(str) || TextUtils.equals(str, WebKitFactory.getCUIDString())) {
            return;
        }
        WebKitFactory.setCUIDString(str);
    }

    public void setCurrentSailorWebView(BdSailorWebView bdSailorWebView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, bdSailorWebView) == null) {
            this.mCurSailorWebView = bdSailorWebView;
        }
    }

    public void setLocation(BdGeoLocationInfo bdGeoLocationInfo, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048628, this, bdGeoLocationInfo, z) == null) {
            ZeusGeoLocationInfo zeusGeoLocationInfo = new ZeusGeoLocationInfo();
            zeusGeoLocationInfo.setLatitude(bdGeoLocationInfo.getLatitude());
            zeusGeoLocationInfo.setLongitude(bdGeoLocationInfo.getLongitude());
            zeusGeoLocationInfo.setRadius(bdGeoLocationInfo.getRadius());
            zeusGeoLocationInfo.setTime(bdGeoLocationInfo.getTime());
            zeusGeoLocationInfo.setProvince(bdGeoLocationInfo.getProvince());
            zeusGeoLocationInfo.setDistrict(bdGeoLocationInfo.getDistrict());
            zeusGeoLocationInfo.setStreet(bdGeoLocationInfo.getStreet());
            zeusGeoLocationInfo.setStreetNumber(bdGeoLocationInfo.getStreetNumber());
            zeusGeoLocationInfo.setCityCode(bdGeoLocationInfo.getCityCode());
            WebKitFactory.setLocation(zeusGeoLocationInfo, z);
        }
    }

    public void setSailorAbTestInterface(ISailorAbTestInterface iSailorAbTestInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, iSailorAbTestInterface) == null) {
            WebViewFactory.setAbTestInterface(iSailorAbTestInterface);
        }
    }

    public void setSailorClient(BdSailorClient bdSailorClient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, bdSailorClient) == null) {
            this.mClient = bdSailorClient;
            WebKitFactory.setWebKitClient(bdSailorClient);
            setSailorFeatureListener();
            BdSailorPlatform.getStatic().a = this.mClient;
        }
    }

    public void setSailorCronetListenerInterface(ICronetListenerInterface iCronetListenerInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, iCronetListenerInterface) == null) {
            Log.i(LOG_TAG, "setSailorCronetListenerInterface");
            WebViewFactory.setCronetListenerInterface(iCronetListenerInterface);
        }
    }

    public void setSailorNetProbeInterface(ISailorNetProbeInterface iSailorNetProbeInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, iSailorNetProbeInterface) == null) {
            Log.i(LOG_TAG, "setSailorNetProbeInterface");
            WebViewFactory.setNetProbeInterface(iSailorNetProbeInterface);
        }
    }

    public void setSailorPMSDownloadInterface(ISailorPMSDownloadInterface iSailorPMSDownloadInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, iSailorPMSDownloadInterface) == null) {
            WebViewFactory.setPMSDownloadInterface(iSailorPMSDownloadInterface);
        }
    }

    public void setSailorUploadInterface(ISailorUploadInterface iSailorUploadInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, iSailorUploadInterface) == null) {
            WebViewFactory.setUploadInterface(iSailorUploadInterface);
        }
    }

    public void setWebkitEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048635, this, z) == null) {
            if (z) {
                BdSailorPlatform.getWebkitManager().enableBdWebkit();
            } else {
                BdSailorPlatform.getWebkitManager().disableBdWebkit();
            }
        }
    }

    public void startCaptureCurrentPageContent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048636, this) == null) {
            getCurSailorWebView().getWebViewExt().startCaptureContentExt();
        }
    }

    public void startCheckUpdate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048637, this) == null) {
            BdSailorPlatform.getInstance().startCheckUpdate();
        }
    }

    public void syncCookie(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048638, this, str, str2) == null) {
            BdSailorPlatform.getInstance().sync2Cookie(str, str2);
        }
    }

    @Deprecated
    public void updateAdBlock() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048639, this) == null) {
        }
    }
}
