package com.baidu.searchbox.live.imp;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.security.DeviceIdBag;
import com.baidu.searchbox.common.security.DeviceInfoManager;
import com.baidu.searchbox.live.interfaces.service.LiveUserSecurityDeviceInfoService;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0016J\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0016J\u0014\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0016J\u0014\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0016J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0016¨\u0006\u0011"}, d2 = {"Lcom/baidu/searchbox/live/imp/LiveUserSecurityDeviceInfoServiceImpl;", "Lcom/baidu/searchbox/live/interfaces/service/LiveUserSecurityDeviceInfoService;", "()V", "getAndroidId", "", "context", "Landroid/content/Context;", "purpose", "getHarmonyVersion", "getIMEI", "getMacAddress", "getManufacturer", "getModel", "getOAID", "getOperator", "getOsVersion", "Companion", "alaLiveSDK_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class LiveUserSecurityDeviceInfoServiceImpl implements LiveUserSecurityDeviceInfoService {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Companion Companion;
    public static final String scene = "live";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2100418227, "Lcom/baidu/searchbox/live/imp/LiveUserSecurityDeviceInfoServiceImpl;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2100418227, "Lcom/baidu/searchbox/live/imp/LiveUserSecurityDeviceInfoServiceImpl;");
                return;
            }
        }
        Companion = new Companion(null);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/live/imp/LiveUserSecurityDeviceInfoServiceImpl$Companion;", "", "()V", "scene", "", "alaLiveSDK_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes2.dex */
    public final class Companion {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
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

    public LiveUserSecurityDeviceInfoServiceImpl() {
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

    @Override // com.baidu.searchbox.live.interfaces.service.LiveUserSecurityDeviceInfoService
    public String getAndroidId(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, str)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            DeviceInfoManager deviceInfoManager = DeviceInfoManager.INSTANCE;
            if (str == null) {
                str = "";
            }
            DeviceIdBag androidId = deviceInfoManager.getAndroidId(context, "live", str);
            if (androidId == null) {
                return null;
            }
            return androidId.deviceId;
        }
        return (String) invokeLL.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.LiveUserSecurityDeviceInfoService
    public String getHarmonyVersion(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            DeviceInfoManager deviceInfoManager = DeviceInfoManager.INSTANCE;
            if (str == null) {
                str = "";
            }
            DeviceIdBag harmonyVersion = deviceInfoManager.getHarmonyVersion(context, "live", str);
            if (harmonyVersion == null) {
                return null;
            }
            return harmonyVersion.deviceId;
        }
        return (String) invokeLL.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.LiveUserSecurityDeviceInfoService
    public String getIMEI(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, str)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            DeviceInfoManager deviceInfoManager = DeviceInfoManager.INSTANCE;
            if (str == null) {
                str = "";
            }
            DeviceIdBag imei = deviceInfoManager.getIMEI(context, "live", str);
            if (imei == null) {
                return null;
            }
            return imei.deviceId;
        }
        return (String) invokeLL.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.LiveUserSecurityDeviceInfoService
    public String getMacAddress(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, context, str)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            DeviceInfoManager deviceInfoManager = DeviceInfoManager.INSTANCE;
            if (str == null) {
                str = "";
            }
            DeviceIdBag macAddress = deviceInfoManager.getMacAddress(context, "live", str);
            if (macAddress == null) {
                return null;
            }
            return macAddress.deviceId;
        }
        return (String) invokeLL.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.LiveUserSecurityDeviceInfoService
    public String getOperator(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, context, str)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            DeviceInfoManager deviceInfoManager = DeviceInfoManager.INSTANCE;
            if (str == null) {
                str = "";
            }
            DeviceIdBag operator = deviceInfoManager.getOperator(context, "live", str);
            if (operator == null) {
                return null;
            }
            return operator.deviceId;
        }
        return (String) invokeLL.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.LiveUserSecurityDeviceInfoService
    public String getManufacturer(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            DeviceInfoManager deviceInfoManager = DeviceInfoManager.INSTANCE;
            if (str == null) {
                str = "";
            }
            DeviceIdBag manufacturer = deviceInfoManager.getManufacturer("live", str);
            if (manufacturer == null) {
                return null;
            }
            return manufacturer.deviceId;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.LiveUserSecurityDeviceInfoService
    public String getModel(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            DeviceInfoManager deviceInfoManager = DeviceInfoManager.INSTANCE;
            if (str == null) {
                str = "";
            }
            DeviceIdBag model = deviceInfoManager.getModel("live", str);
            if (model == null) {
                return null;
            }
            return model.deviceId;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.LiveUserSecurityDeviceInfoService
    public String getOAID(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            DeviceInfoManager deviceInfoManager = DeviceInfoManager.INSTANCE;
            if (str == null) {
                str = "";
            }
            DeviceIdBag oaid = deviceInfoManager.getOAID("live", str);
            if (oaid == null) {
                return null;
            }
            return oaid.deviceId;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.LiveUserSecurityDeviceInfoService
    public String getOsVersion(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            DeviceInfoManager deviceInfoManager = DeviceInfoManager.INSTANCE;
            if (str == null) {
                str = "";
            }
            DeviceIdBag osVersion = deviceInfoManager.getOsVersion("live", str);
            if (osVersion == null) {
                return null;
            }
            return osVersion.deviceId;
        }
        return (String) invokeL.objValue;
    }
}
