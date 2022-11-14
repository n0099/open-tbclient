package com.baidu.live;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.feedpage.interfaces.IHKLiveFeedPageInvoke;
import com.baidu.live.feedpage.interfaces.ILiveFeedPageInvoke;
import com.baidu.searchbox.live.interfaces.net.INetWork;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tieba.lb0;
import com.baidu.tieba.vc0;
import com.baidu.tieba.yv9;
import com.baidu.tieba.zb0;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class LiveFeedPageSdk {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FOLLOW_VIDEO = "follow_video";
    public static final String HK_START_LIVE = "baiduhaokan://video/yylive/router?url=yymobile%3a%2f%2fMobileLive%2fPreViewPage%3fneedLogin%3d1";
    public static final String HOST_BAIDU = "baidu";
    public static final String HOST_HAOKAN = "haokan";
    public static final String HOST_LIVE_TAB = "live_tab";
    public static final String HOST_QUANMIN = "quanmin";
    public static final String HOST_TIEBA = "tieba";
    public static final String IMMERSION = "immersion";
    public static final String LIVE_SDK_VERSION = "6.4.5";
    public static final long REFRESH_TIME = 180000;
    public static final String UI_MODE_DARK = "dark";
    public static final String UI_MODE_DAY = "day";
    public static final String UI_MODE_NIGHT = "night";
    public static final String VIDEO_BAR = "video_bar";
    public static boolean liveFeedDebug;
    public static LiveFeedPageSdk sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public IHKLiveFeedPageInvoke hkLiveFeedPageInvoke;
    public boolean isInit;
    public ILiveFeedPageInvoke liveFeedPageInvoke;
    public Context mAppContext;
    public String mHost;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1671392719, "Lcom/baidu/live/LiveFeedPageSdk;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1671392719, "Lcom/baidu/live/LiveFeedPageSdk;");
        }
    }

    /* loaded from: classes2.dex */
    public static class Holder {
        public static /* synthetic */ Interceptable $ic;
        public static final LiveFeedPageSdk INSTANCE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1237300023, "Lcom/baidu/live/LiveFeedPageSdk$Holder;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1237300023, "Lcom/baidu/live/LiveFeedPageSdk$Holder;");
                    return;
                }
            }
            INSTANCE = new LiveFeedPageSdk();
        }

        public Holder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    public LiveFeedPageSdk() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static LiveFeedPageSdk getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (sInstance == null) {
                sInstance = Holder.INSTANCE;
            }
            return sInstance;
        }
        return (LiveFeedPageSdk) invokeV.objValue;
    }

    public Context getApplication() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mAppContext;
        }
        return (Context) invokeV.objValue;
    }

    public String getDefaultStartLiveScheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (HOST_HAOKAN.equals(getHost())) {
                return HK_START_LIVE;
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public IHKLiveFeedPageInvoke getHKInvoker() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.hkLiveFeedPageInvoke;
        }
        return (IHKLiveFeedPageInvoke) invokeV.objValue;
    }

    public String getHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mHost;
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    public ILiveFeedPageInvoke getInvoker() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.liveFeedPageInvoke;
        }
        return (ILiveFeedPageInvoke) invokeV.objValue;
    }

    public boolean isInit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.isInit;
        }
        return invokeV.booleanValue;
    }

    public void setInit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.isInit = true;
        }
    }

    public static void liveLog(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            liveLog("LiveFeedPageSdk", str);
        }
    }

    public String getYYHDID(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, context)) == null) {
            return yv9.a(context);
        }
        return (String) invokeL.objValue;
    }

    public void initInvoke(ILiveFeedPageInvoke iLiveFeedPageInvoke) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, iLiveFeedPageInvoke) == null) {
            this.liveFeedPageInvoke = iLiveFeedPageInvoke;
        }
    }

    public void initNetWork(INetWork iNetWork) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, iNetWork) == null) {
            zb0.b(iNetWork);
        }
    }

    public void setContext(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, context) == null) && context != null && this.mAppContext == null) {
            this.mAppContext = context.getApplicationContext();
        }
    }

    public void setHKInvoker(IHKLiveFeedPageInvoke iHKLiveFeedPageInvoke) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, iHKLiveFeedPageInvoke) == null) {
            this.hkLiveFeedPageInvoke = iHKLiveFeedPageInvoke;
        }
    }

    public void startLiveSearchActivity(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, context) == null) && lb0.a() != null) {
            lb0.a().a(context, "");
        }
    }

    public void updateUiMode(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            vc0.f().u(str);
        }
    }

    public static void liveLog(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2) == null) && liveFeedDebug) {
            Log.i(str, str2);
        }
    }

    public void initHostInfo(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, str2) == null) {
            this.mHost = str;
            vc0.f().s(str, str2);
        }
    }

    public String getBdId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (getInvoker() != null) {
                String uk = getInvoker().getUK();
                if (!TextUtils.isEmpty(uk) && !"0".equals(uk)) {
                    return uk;
                }
                return getInvoker().getCuid();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public void starLivePageActivity(Context context, String str, String str2, String str3, String str4, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{context, str, str2, str3, str4, Boolean.valueOf(z)}) == null) && context != null) {
            Intent intent = new Intent(context, LiveFeedPageActivity.class);
            intent.putExtra("source", str);
            intent.putExtra("scheme_next", str2);
            intent.putExtra("tab_extend_subtype", str3);
            intent.putExtra("tab_extend_thirdtype", str4);
            intent.putExtra("tab_extend_scroll_to_tab", z);
            if (!(context instanceof Activity)) {
                intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
            }
            context.startActivity(intent);
        }
    }
}
