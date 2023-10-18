package com.baidu.searchbox.live.imp;

import android.content.Context;
import com.baidu.searchbox.common.security.DeviceIdBag;
import com.baidu.searchbox.common.security.DeviceInfoManager;
import com.baidu.searchbox.live.interfaces.service.LiveUserSecurityDeviceInfoService;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0016J\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0016J\u0014\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0016J\u0014\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0016J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0016¨\u0006\u0011"}, d2 = {"Lcom/baidu/searchbox/live/imp/LiveUserSecurityDeviceInfoServiceImpl;", "Lcom/baidu/searchbox/live/interfaces/service/LiveUserSecurityDeviceInfoService;", "()V", "getAndroidId", "", "context", "Landroid/content/Context;", "purpose", "getHarmonyVersion", "getIMEI", "getMacAddress", "getManufacturer", "getModel", "getOAID", "getOperator", "getOsVersion", "Companion", "alaLiveSDK_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LiveUserSecurityDeviceInfoServiceImpl implements LiveUserSecurityDeviceInfoService {
    public static final Companion Companion = new Companion(null);
    public static final String scene = "live";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/live/imp/LiveUserSecurityDeviceInfoServiceImpl$Companion;", "", "()V", "scene", "", "alaLiveSDK_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.LiveUserSecurityDeviceInfoService
    public String getAndroidId(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        DeviceInfoManager deviceInfoManager = DeviceInfoManager.INSTANCE;
        if (str == null) {
            str = "";
        }
        DeviceIdBag androidId = deviceInfoManager.getAndroidId(context, "live", str);
        if (androidId != null) {
            return androidId.deviceId;
        }
        return null;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.LiveUserSecurityDeviceInfoService
    public String getHarmonyVersion(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        DeviceInfoManager deviceInfoManager = DeviceInfoManager.INSTANCE;
        if (str == null) {
            str = "";
        }
        DeviceIdBag harmonyVersion = deviceInfoManager.getHarmonyVersion(context, "live", str);
        if (harmonyVersion != null) {
            return harmonyVersion.deviceId;
        }
        return null;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.LiveUserSecurityDeviceInfoService
    public String getIMEI(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        DeviceInfoManager deviceInfoManager = DeviceInfoManager.INSTANCE;
        if (str == null) {
            str = "";
        }
        DeviceIdBag imei = deviceInfoManager.getIMEI(context, "live", str);
        if (imei != null) {
            return imei.deviceId;
        }
        return null;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.LiveUserSecurityDeviceInfoService
    public String getMacAddress(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        DeviceInfoManager deviceInfoManager = DeviceInfoManager.INSTANCE;
        if (str == null) {
            str = "";
        }
        DeviceIdBag macAddress = deviceInfoManager.getMacAddress(context, "live", str);
        if (macAddress != null) {
            return macAddress.deviceId;
        }
        return null;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.LiveUserSecurityDeviceInfoService
    public String getOperator(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        DeviceInfoManager deviceInfoManager = DeviceInfoManager.INSTANCE;
        if (str == null) {
            str = "";
        }
        DeviceIdBag operator = deviceInfoManager.getOperator(context, "live", str);
        if (operator != null) {
            return operator.deviceId;
        }
        return null;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.LiveUserSecurityDeviceInfoService
    public String getManufacturer(String str) {
        DeviceInfoManager deviceInfoManager = DeviceInfoManager.INSTANCE;
        if (str == null) {
            str = "";
        }
        DeviceIdBag manufacturer = deviceInfoManager.getManufacturer("live", str);
        if (manufacturer != null) {
            return manufacturer.deviceId;
        }
        return null;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.LiveUserSecurityDeviceInfoService
    public String getModel(String str) {
        DeviceInfoManager deviceInfoManager = DeviceInfoManager.INSTANCE;
        if (str == null) {
            str = "";
        }
        DeviceIdBag model = deviceInfoManager.getModel("live", str);
        if (model != null) {
            return model.deviceId;
        }
        return null;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.LiveUserSecurityDeviceInfoService
    public String getOAID(String str) {
        DeviceInfoManager deviceInfoManager = DeviceInfoManager.INSTANCE;
        if (str == null) {
            str = "";
        }
        DeviceIdBag oaid = deviceInfoManager.getOAID("live", str);
        if (oaid != null) {
            return oaid.deviceId;
        }
        return null;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.LiveUserSecurityDeviceInfoService
    public String getOsVersion(String str) {
        DeviceInfoManager deviceInfoManager = DeviceInfoManager.INSTANCE;
        if (str == null) {
            str = "";
        }
        DeviceIdBag osVersion = deviceInfoManager.getOsVersion("live", str);
        if (osVersion != null) {
            return osVersion.deviceId;
        }
        return null;
    }
}
