package com.baidu.searchbox.common.security;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.common.security.ioc.HostAbilityRuntime;
import com.baidu.tbadk.core.util.ApiReplaceUtil;
import java.net.NetworkInterface;
import java.util.Enumeration;
/* loaded from: classes3.dex */
public class HardwareProxy {
    public static final String MAC_NULL = "";
    public static volatile boolean hasInvoked;
    public static String mac;

    public static String byte2MacString(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            sb.append(String.format("%02x:", Byte.valueOf(bArr[i])));
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public static DeviceIdBag getHardwareAddress(Context context) {
        return getHardwareAddress(context, false);
    }

    public static DeviceIdBag getHardwareAddress(Context context, boolean z) {
        DeviceIdBag deviceIdBag = new DeviceIdBag();
        if (!HostAbilityRuntime.getHostAbility().hasAgreedPrivacyPolicy()) {
            deviceIdBag.errorCode = -3;
            return deviceIdBag;
        }
        int i = 2;
        if (TextUtils.isEmpty(mac) && !hasInvoked) {
            if (!z && !HostAbilityRuntime.getHostAbility().isForeground()) {
                i = -1;
            } else {
                String macByNetwork = getMacByNetwork();
                mac = macByNetwork;
                if (!TextUtils.isEmpty(macByNetwork)) {
                    i = 0;
                }
                hasInvoked = true;
            }
        } else if (!hasInvoked || !TextUtils.isEmpty(mac)) {
            i = 1;
        }
        deviceIdBag.deviceId = mac;
        deviceIdBag.errorCode = i;
        return deviceIdBag;
    }

    public static String getMacByNetwork() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface nextElement = networkInterfaces.nextElement();
                if (nextElement.getName().equalsIgnoreCase("wlan0")) {
                    byte[] hardwareAddress = ApiReplaceUtil.getHardwareAddress(nextElement);
                    String str = null;
                    if (hardwareAddress != null) {
                        str = byte2MacString(hardwareAddress);
                    }
                    if (TextUtils.isEmpty(str)) {
                        return "";
                    }
                    return str;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return "";
    }
}
