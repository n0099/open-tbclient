package com.baidu.searchbox.common.security;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.multiprocess.IPCServiceManager;
import com.baidu.searchbox.common.security.IDeviceInfoService;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/baidu/searchbox/common/security/DeviceInfoIPCServiceManager;", "", "()V", "Companion", "lib-security-framework_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DeviceInfoIPCServiceManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Companion Companion;
    public static final String IPC_SERVICE_NAME = "device_info";
    public static IDeviceInfoService sDeviceInfoService;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(915427056, "Lcom/baidu/searchbox/common/security/DeviceInfoIPCServiceManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(915427056, "Lcom/baidu/searchbox/common/security/DeviceInfoIPCServiceManager;");
                return;
            }
        }
        Companion = new Companion(null);
    }

    @JvmStatic
    public static final void addIPCService() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            Companion.addIPCService();
        }
    }

    @JvmStatic
    public static final IDeviceInfoService getIPCService() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? Companion.getIPCService() : (IDeviceInfoService) invokeV.objValue;
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u00020\tH\u0007J\n\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0002¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/common/security/DeviceInfoIPCServiceManager$Companion;", "", "()V", "IPC_SERVICE_NAME", "", "sDeviceInfoService", "Lcom/baidu/searchbox/common/security/IDeviceInfoService;", "getSDeviceInfoService$annotations", "addIPCService", "", "getIPCService", "lib-security-framework_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getSDeviceInfoService$annotations() {
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

        @JvmStatic
        public final void addIPCService() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                IPCServiceManager.c(DeviceInfoIPCServiceManager.IPC_SERVICE_NAME, new IDeviceInfoService.Stub() { // from class: com.baidu.searchbox.common.security.DeviceInfoIPCServiceManager$Companion$addIPCService$ipcService$1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                            }
                        }
                    }

                    @Override // com.baidu.searchbox.common.security.IDeviceInfoService
                    public DeviceIdBag getAndroidId(String scene, String purpose) {
                        InterceptResult invokeLL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, scene, purpose)) == null) {
                            Intrinsics.checkNotNullParameter(scene, "scene");
                            Intrinsics.checkNotNullParameter(purpose, "purpose");
                            DeviceInfoManager deviceInfoManager = DeviceInfoManager.INSTANCE;
                            return deviceInfoManager.getAndroidId(deviceInfoManager.getContext$lib_security_framework_release(), scene, purpose);
                        }
                        return (DeviceIdBag) invokeLL.objValue;
                    }

                    @Override // com.baidu.searchbox.common.security.IDeviceInfoService
                    public DeviceIdBag getHarmonyVersion(String scene, String purpose) {
                        InterceptResult invokeLL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, scene, purpose)) == null) {
                            Intrinsics.checkNotNullParameter(scene, "scene");
                            Intrinsics.checkNotNullParameter(purpose, "purpose");
                            DeviceInfoManager deviceInfoManager = DeviceInfoManager.INSTANCE;
                            return deviceInfoManager.getHarmonyVersion(deviceInfoManager.getContext$lib_security_framework_release(), scene, purpose);
                        }
                        return (DeviceIdBag) invokeLL.objValue;
                    }

                    @Override // com.baidu.searchbox.common.security.IDeviceInfoService
                    public DeviceIdBag getMacAddress(String scene, String purpose) {
                        InterceptResult invokeLL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048580, this, scene, purpose)) == null) {
                            Intrinsics.checkNotNullParameter(scene, "scene");
                            Intrinsics.checkNotNullParameter(purpose, "purpose");
                            DeviceInfoManager deviceInfoManager = DeviceInfoManager.INSTANCE;
                            return deviceInfoManager.getMacAddress(deviceInfoManager.getContext$lib_security_framework_release(), scene, purpose);
                        }
                        return (DeviceIdBag) invokeLL.objValue;
                    }

                    @Override // com.baidu.searchbox.common.security.IDeviceInfoService
                    public DeviceIdBag getManufacturer(String scene, String purpose) {
                        InterceptResult invokeLL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048581, this, scene, purpose)) == null) {
                            Intrinsics.checkNotNullParameter(scene, "scene");
                            Intrinsics.checkNotNullParameter(purpose, "purpose");
                            return DeviceInfoManager.INSTANCE.getManufacturer(scene, purpose);
                        }
                        return (DeviceIdBag) invokeLL.objValue;
                    }

                    @Override // com.baidu.searchbox.common.security.IDeviceInfoService
                    public DeviceIdBag getModel(String scene, String purpose) {
                        InterceptResult invokeLL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048582, this, scene, purpose)) == null) {
                            Intrinsics.checkNotNullParameter(scene, "scene");
                            Intrinsics.checkNotNullParameter(purpose, "purpose");
                            return DeviceInfoManager.INSTANCE.getModel(scene, purpose);
                        }
                        return (DeviceIdBag) invokeLL.objValue;
                    }

                    @Override // com.baidu.searchbox.common.security.IDeviceInfoService
                    public DeviceIdBag getOAID(String scene, String purpose) {
                        InterceptResult invokeLL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048583, this, scene, purpose)) == null) {
                            Intrinsics.checkNotNullParameter(scene, "scene");
                            Intrinsics.checkNotNullParameter(purpose, "purpose");
                            return DeviceInfoManager.INSTANCE.getOAID(scene, purpose);
                        }
                        return (DeviceIdBag) invokeLL.objValue;
                    }

                    @Override // com.baidu.searchbox.common.security.IDeviceInfoService
                    public DeviceIdBag getOsVersion(String scene, String purpose) {
                        InterceptResult invokeLL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048585, this, scene, purpose)) == null) {
                            Intrinsics.checkNotNullParameter(scene, "scene");
                            Intrinsics.checkNotNullParameter(purpose, "purpose");
                            return DeviceInfoManager.INSTANCE.getOsVersion(scene, purpose);
                        }
                        return (DeviceIdBag) invokeLL.objValue;
                    }

                    @Override // com.baidu.searchbox.common.security.IDeviceInfoService
                    public DeviceIdBagMap getDeviceInfos(String scene, String purpose, int i, boolean z) {
                        InterceptResult invokeCommon;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{scene, purpose, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
                            Intrinsics.checkNotNullParameter(scene, "scene");
                            Intrinsics.checkNotNullParameter(purpose, "purpose");
                            DeviceInfoManager deviceInfoManager = DeviceInfoManager.INSTANCE;
                            return deviceInfoManager.getDeviceInfo(deviceInfoManager.getContext$lib_security_framework_release(), scene, purpose, i, z);
                        }
                        return (DeviceIdBagMap) invokeCommon.objValue;
                    }

                    @Override // com.baidu.searchbox.common.security.IDeviceInfoService
                    public DeviceIdBag getIMEI(String scene, String purpose, boolean z) {
                        InterceptResult invokeLLZ;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeLLZ = interceptable2.invokeLLZ(1048579, this, scene, purpose, z)) == null) {
                            Intrinsics.checkNotNullParameter(scene, "scene");
                            Intrinsics.checkNotNullParameter(purpose, "purpose");
                            DeviceInfoManager deviceInfoManager = DeviceInfoManager.INSTANCE;
                            return deviceInfoManager.getIMEI(deviceInfoManager.getContext$lib_security_framework_release(), scene, purpose, z);
                        }
                        return (DeviceIdBag) invokeLLZ.objValue;
                    }

                    @Override // com.baidu.searchbox.common.security.IDeviceInfoService
                    public DeviceIdBag getOperator(String scene, String purpose, boolean z) {
                        InterceptResult invokeLLZ;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeLLZ = interceptable2.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, scene, purpose, z)) == null) {
                            Intrinsics.checkNotNullParameter(scene, "scene");
                            Intrinsics.checkNotNullParameter(purpose, "purpose");
                            DeviceInfoManager deviceInfoManager = DeviceInfoManager.INSTANCE;
                            return deviceInfoManager.getOperator(deviceInfoManager.getContext$lib_security_framework_release(), scene, purpose, z);
                        }
                        return (DeviceIdBag) invokeLLZ.objValue;
                    }
                }, false);
            }
        }

        @JvmStatic
        public final IDeviceInfoService getIPCService() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (DeviceInfoIPCServiceManager.sDeviceInfoService == null) {
                    synchronized (DeviceInfoManager.class) {
                        if (DeviceInfoIPCServiceManager.sDeviceInfoService == null) {
                            Companion companion = DeviceInfoIPCServiceManager.Companion;
                            DeviceInfoIPCServiceManager.sDeviceInfoService = IDeviceInfoService.Stub.asInterface(IPCServiceManager.f(DeviceInfoIPCServiceManager.IPC_SERVICE_NAME, true));
                        }
                        Unit unit = Unit.INSTANCE;
                    }
                }
                return DeviceInfoIPCServiceManager.sDeviceInfoService;
            }
            return (IDeviceInfoService) invokeV.objValue;
        }
    }

    public DeviceInfoIPCServiceManager() {
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
