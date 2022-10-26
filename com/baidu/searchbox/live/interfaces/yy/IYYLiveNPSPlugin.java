package com.baidu.searchbox.live.interfaces.yy;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.interfaces.callback.ILiveDiskClearCacheCallback;
import com.baidu.searchbox.live.interfaces.callback.ILiveFileSizeCallback;
import com.baidu.searchbox.live.interfaces.callback.LiveLoadStatusCallback;
import com.baidu.searchbox.live.interfaces.entry.ILiveYYMixEntry;
import com.baidu.searchbox.live.interfaces.payment.IPaymentLogDelegate;
import com.baidu.searchbox.live.interfaces.payment.IPaymentStateCallback;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes2.dex */
public interface IYYLiveNPSPlugin {
    public static final String YY_ENV_CREATE_LIVE = "create_live";
    public static final String YY_ENV_ENTRANCE_PRE_INSTALL = "entrance_pre_install";
    public static final String YY_ENV_MINILIB_INIT = "minilib_init";
    public static final String YY_ENV_MINILIB_PRE_INIT = "minilib_pre_init";

    void cancelLoad();

    void cancelStartYYLiveActivity();

    @Deprecated
    void clearLiveResourceSize(Context context);

    void dispatchHostEvent(Context context, String str, Map map);

    void dispatchYYLiveRouter(Context context, String str);

    void dispatchYYRawLiveRouter(Context context, String str);

    @Deprecated
    void getLiveResourceSize(Context context, ILiveFileSizeCallback iLiveFileSizeCallback);

    ILiveYYMixEntry getLiveYYMixEntry();

    boolean isAvailable();

    boolean isEnvReady(String str);

    boolean isLoaded();

    void loadPlugin(Context context, LiveLoadStatusCallback liveLoadStatusCallback);

    void onDiskClearCacheChange(long j, int i, int i2, ILiveDiskClearCacheCallback iLiveDiskClearCacheCallback);

    void prepareYYEnv(String str, YYEnvResultCallback yYEnvResultCallback);

    void startPayment(Context context, IPaymentStateCallback iPaymentStateCallback, IPaymentLogDelegate iPaymentLogDelegate, String str, Long l, Boolean bool, Map map, Map map2);

    void startYYActivity(Context context);

    void startYYCustomerServiceActivity(Context context, String str);

    void startYYFeedbackActivity(Context context, String str);

    void startYYLiveActivity(Context context, String str);

    void updateStatInfo(YYStatInfo yYStatInfo);

    /* loaded from: classes2.dex */
    public class Empty implements IYYLiveNPSPlugin {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.searchbox.live.interfaces.yy.IYYLiveNPSPlugin
        public void cancelLoad() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.baidu.searchbox.live.interfaces.yy.IYYLiveNPSPlugin
        public void cancelStartYYLiveActivity() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // com.baidu.searchbox.live.interfaces.yy.IYYLiveNPSPlugin
        public void clearLiveResourceSize(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            }
        }

        @Override // com.baidu.searchbox.live.interfaces.yy.IYYLiveNPSPlugin
        public void dispatchHostEvent(Context context, String str, Map map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, context, str, map) == null) {
            }
        }

        @Override // com.baidu.searchbox.live.interfaces.yy.IYYLiveNPSPlugin
        public void dispatchYYLiveRouter(Context context, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, context, str) == null) {
            }
        }

        @Override // com.baidu.searchbox.live.interfaces.yy.IYYLiveNPSPlugin
        public void dispatchYYRawLiveRouter(Context context, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, context, str) == null) {
            }
        }

        @Override // com.baidu.searchbox.live.interfaces.yy.IYYLiveNPSPlugin
        public void getLiveResourceSize(Context context, ILiveFileSizeCallback iLiveFileSizeCallback) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, context, iLiveFileSizeCallback) == null) {
            }
        }

        @Override // com.baidu.searchbox.live.interfaces.yy.IYYLiveNPSPlugin
        public ILiveYYMixEntry getLiveYYMixEntry() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return null;
            }
            return (ILiveYYMixEntry) invokeV.objValue;
        }

        @Override // com.baidu.searchbox.live.interfaces.yy.IYYLiveNPSPlugin
        public boolean isAvailable() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.searchbox.live.interfaces.yy.IYYLiveNPSPlugin
        public boolean isEnvReady(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.searchbox.live.interfaces.yy.IYYLiveNPSPlugin
        public boolean isLoaded() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.searchbox.live.interfaces.yy.IYYLiveNPSPlugin
        public void loadPlugin(Context context, LiveLoadStatusCallback liveLoadStatusCallback) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048587, this, context, liveLoadStatusCallback) == null) {
            }
        }

        @Override // com.baidu.searchbox.live.interfaces.yy.IYYLiveNPSPlugin
        public void onDiskClearCacheChange(long j, int i, int i2, ILiveDiskClearCacheCallback iLiveDiskClearCacheCallback) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), iLiveDiskClearCacheCallback}) == null) {
            }
        }

        @Override // com.baidu.searchbox.live.interfaces.yy.IYYLiveNPSPlugin
        public void prepareYYEnv(String str, YYEnvResultCallback yYEnvResultCallback) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048589, this, str, yYEnvResultCallback) == null) {
            }
        }

        @Override // com.baidu.searchbox.live.interfaces.yy.IYYLiveNPSPlugin
        public void startPayment(Context context, IPaymentStateCallback iPaymentStateCallback, IPaymentLogDelegate iPaymentLogDelegate, String str, Long l, Boolean bool, Map map, Map map2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{context, iPaymentStateCallback, iPaymentLogDelegate, str, l, bool, map, map2}) == null) {
            }
        }

        @Override // com.baidu.searchbox.live.interfaces.yy.IYYLiveNPSPlugin
        public void startYYActivity(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048591, this, context) == null) {
            }
        }

        @Override // com.baidu.searchbox.live.interfaces.yy.IYYLiveNPSPlugin
        public void startYYCustomerServiceActivity(Context context, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048592, this, context, str) == null) {
            }
        }

        @Override // com.baidu.searchbox.live.interfaces.yy.IYYLiveNPSPlugin
        public void startYYFeedbackActivity(Context context, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048593, this, context, str) == null) {
            }
        }

        @Override // com.baidu.searchbox.live.interfaces.yy.IYYLiveNPSPlugin
        public void startYYLiveActivity(Context context, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048594, this, context, str) == null) {
            }
        }

        @Override // com.baidu.searchbox.live.interfaces.yy.IYYLiveNPSPlugin
        public void updateStatInfo(YYStatInfo yYStatInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048595, this, yYStatInfo) == null) {
            }
        }

        public Empty() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }
}
