package com.baidu.searchbox.common.security;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.common.security.ioc.HostAbilityRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.NetworkInterface;
import java.util.Enumeration;
/* loaded from: classes2.dex */
public class HardwareProxy {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String MAC_NULL = "";
    public static volatile boolean hasInvoked;
    public static String mac;
    public transient /* synthetic */ FieldHolder $fh;

    public HardwareProxy() {
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

    public static String byte2MacString(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bArr)) == null) {
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
        return (String) invokeL.objValue;
    }

    public static DeviceIdBag getHardwareAddress(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) ? getHardwareAddress(context, false) : (DeviceIdBag) invokeL.objValue;
    }

    public static String getMacByNetwork() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            try {
                Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                while (networkInterfaces.hasMoreElements()) {
                    NetworkInterface nextElement = networkInterfaces.nextElement();
                    if (nextElement.getName().equalsIgnoreCase("wlan0")) {
                        byte[] hardwareAddress = nextElement.getHardwareAddress();
                        String byte2MacString = hardwareAddress != null ? byte2MacString(hardwareAddress) : null;
                        return TextUtils.isEmpty(byte2MacString) ? "" : byte2MacString;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public static DeviceIdBag getHardwareAddress(Context context, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65539, null, context, z)) == null) {
            DeviceIdBag deviceIdBag = new DeviceIdBag();
            if (!HostAbilityRuntime.getHostAbility().hasAgreedPrivacyPolicy()) {
                deviceIdBag.errorCode = -3;
                return deviceIdBag;
            }
            if (TextUtils.isEmpty(mac) && !hasInvoked) {
                if (z || HostAbilityRuntime.getHostAbility().isForeground()) {
                    String macByNetwork = getMacByNetwork();
                    mac = macByNetwork;
                    r1 = TextUtils.isEmpty(macByNetwork) ? 2 : 0;
                    hasInvoked = true;
                } else {
                    r1 = -1;
                }
            } else if (!hasInvoked || !TextUtils.isEmpty(mac)) {
                r1 = 1;
            }
            deviceIdBag.deviceId = mac;
            deviceIdBag.errorCode = r1;
            return deviceIdBag;
        }
        return (DeviceIdBag) invokeLZ.objValue;
    }
}
