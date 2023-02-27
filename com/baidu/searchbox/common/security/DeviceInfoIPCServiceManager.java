package com.baidu.searchbox.common.security;

import com.baidu.pyramid.runtime.multiprocess.IPCServiceManager;
import com.baidu.searchbox.common.security.IDeviceInfoService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/baidu/searchbox/common/security/DeviceInfoIPCServiceManager;", "", "()V", "Companion", "lib-security-framework_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DeviceInfoIPCServiceManager {
    public static final Companion Companion = new Companion(null);
    public static final String IPC_SERVICE_NAME = "device_info";
    public static IDeviceInfoService sDeviceInfoService;

    @JvmStatic
    public static final void addIPCService() {
        Companion.addIPCService();
    }

    @JvmStatic
    public static final IDeviceInfoService getIPCService() {
        return Companion.getIPCService();
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u00020\tH\u0007J\n\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0002¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/common/security/DeviceInfoIPCServiceManager$Companion;", "", "()V", "IPC_SERVICE_NAME", "", "sDeviceInfoService", "Lcom/baidu/searchbox/common/security/IDeviceInfoService;", "getSDeviceInfoService$annotations", "addIPCService", "", "getIPCService", "lib-security-framework_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getSDeviceInfoService$annotations() {
        }

        public Companion() {
        }

        @JvmStatic
        public final void addIPCService() {
            IPCServiceManager.c(DeviceInfoIPCServiceManager.IPC_SERVICE_NAME, new IDeviceInfoService.Stub() { // from class: com.baidu.searchbox.common.security.DeviceInfoIPCServiceManager$Companion$addIPCService$ipcService$1
                @Override // com.baidu.searchbox.common.security.IDeviceInfoService
                public DeviceIdBag getAndroidId(String scene, String purpose) {
                    Intrinsics.checkNotNullParameter(scene, "scene");
                    Intrinsics.checkNotNullParameter(purpose, "purpose");
                    DeviceInfoManager deviceInfoManager = DeviceInfoManager.INSTANCE;
                    return deviceInfoManager.getAndroidId(deviceInfoManager.getContext$lib_security_framework_release(), scene, purpose);
                }

                @Override // com.baidu.searchbox.common.security.IDeviceInfoService
                public DeviceIdBag getHarmonyVersion(String scene, String purpose) {
                    Intrinsics.checkNotNullParameter(scene, "scene");
                    Intrinsics.checkNotNullParameter(purpose, "purpose");
                    DeviceInfoManager deviceInfoManager = DeviceInfoManager.INSTANCE;
                    return deviceInfoManager.getHarmonyVersion(deviceInfoManager.getContext$lib_security_framework_release(), scene, purpose);
                }

                @Override // com.baidu.searchbox.common.security.IDeviceInfoService
                public DeviceIdBag getMacAddress(String scene, String purpose) {
                    Intrinsics.checkNotNullParameter(scene, "scene");
                    Intrinsics.checkNotNullParameter(purpose, "purpose");
                    DeviceInfoManager deviceInfoManager = DeviceInfoManager.INSTANCE;
                    return deviceInfoManager.getMacAddress(deviceInfoManager.getContext$lib_security_framework_release(), scene, purpose);
                }

                @Override // com.baidu.searchbox.common.security.IDeviceInfoService
                public DeviceIdBag getManufacturer(String scene, String purpose) {
                    Intrinsics.checkNotNullParameter(scene, "scene");
                    Intrinsics.checkNotNullParameter(purpose, "purpose");
                    return DeviceInfoManager.INSTANCE.getManufacturer(scene, purpose);
                }

                @Override // com.baidu.searchbox.common.security.IDeviceInfoService
                public DeviceIdBag getModel(String scene, String purpose) {
                    Intrinsics.checkNotNullParameter(scene, "scene");
                    Intrinsics.checkNotNullParameter(purpose, "purpose");
                    return DeviceInfoManager.INSTANCE.getModel(scene, purpose);
                }

                @Override // com.baidu.searchbox.common.security.IDeviceInfoService
                public DeviceIdBag getOAID(String scene, String purpose) {
                    Intrinsics.checkNotNullParameter(scene, "scene");
                    Intrinsics.checkNotNullParameter(purpose, "purpose");
                    return DeviceInfoManager.INSTANCE.getOAID(scene, purpose);
                }

                @Override // com.baidu.searchbox.common.security.IDeviceInfoService
                public DeviceIdBag getOsVersion(String scene, String purpose) {
                    Intrinsics.checkNotNullParameter(scene, "scene");
                    Intrinsics.checkNotNullParameter(purpose, "purpose");
                    return DeviceInfoManager.INSTANCE.getOsVersion(scene, purpose);
                }

                @Override // com.baidu.searchbox.common.security.IDeviceInfoService
                public DeviceIdBagMap getDeviceInfos(String scene, String purpose, int i, boolean z) {
                    Intrinsics.checkNotNullParameter(scene, "scene");
                    Intrinsics.checkNotNullParameter(purpose, "purpose");
                    DeviceInfoManager deviceInfoManager = DeviceInfoManager.INSTANCE;
                    return deviceInfoManager.getDeviceInfo(deviceInfoManager.getContext$lib_security_framework_release(), scene, purpose, i, z);
                }

                @Override // com.baidu.searchbox.common.security.IDeviceInfoService
                public DeviceIdBag getIMEI(String scene, String purpose, boolean z) {
                    Intrinsics.checkNotNullParameter(scene, "scene");
                    Intrinsics.checkNotNullParameter(purpose, "purpose");
                    DeviceInfoManager deviceInfoManager = DeviceInfoManager.INSTANCE;
                    return deviceInfoManager.getIMEI(deviceInfoManager.getContext$lib_security_framework_release(), scene, purpose, z);
                }

                @Override // com.baidu.searchbox.common.security.IDeviceInfoService
                public DeviceIdBag getOperator(String scene, String purpose, boolean z) {
                    Intrinsics.checkNotNullParameter(scene, "scene");
                    Intrinsics.checkNotNullParameter(purpose, "purpose");
                    DeviceInfoManager deviceInfoManager = DeviceInfoManager.INSTANCE;
                    return deviceInfoManager.getOperator(deviceInfoManager.getContext$lib_security_framework_release(), scene, purpose, z);
                }
            }, false);
        }

        @JvmStatic
        public final IDeviceInfoService getIPCService() {
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
    }
}
