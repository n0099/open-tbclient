package com.baidu.crabsdk.lite.a;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
/* loaded from: classes3.dex */
public final class g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static String f4705a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1349355056, "Lcom/baidu/crabsdk/lite/a/g;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1349355056, "Lcom/baidu/crabsdk/lite/a/g;");
        }
    }

    public static String a(String str, Context context) {
        InterceptResult invokeLL;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, context)) == null) {
            HashMap<String, Object> hashMap = com.baidu.crabsdk.lite.a.f4688a.get(str);
            if ((hashMap == null || (obj = hashMap.get("sdk_imei")) == null) ? true : ((Boolean) obj).booleanValue()) {
                String str2 = f4705a;
                if (str2 != null) {
                    return str2;
                }
                try {
                    f4705a = b(((TelephonyManager) context.getSystemService("phone")).getDeviceId() + ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getMacAddress() + Settings.Secure.getString(context.getContentResolver(), IAdRequestParam.ANDROID_ID));
                } catch (Exception e2) {
                    com.baidu.crabsdk.lite.b.a.c(str, "getCUID fail," + e2);
                    f4705a = "N/A";
                }
                return f4705a;
            }
            return "N/A";
        }
        return (String) invokeLL.objValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        byte b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            MessageDigest messageDigest = null;
            try {
                messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.reset();
                messageDigest.update(str.getBytes("UTF-8"));
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            } catch (NoSuchAlgorithmException unused) {
                System.out.println("NoSuchAlgorithmException caught!");
            }
            byte[] digest = messageDigest.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (int i2 = 0; i2 < digest.length; i2++) {
                if (Integer.toHexString(digest[i2] & 255).length() == 1) {
                    stringBuffer.append("0");
                    b2 = digest[i2];
                } else {
                    b2 = digest[i2];
                }
                stringBuffer.append(Integer.toHexString(b2 & 255));
            }
            return stringBuffer.toString();
        }
        return (String) invokeL.objValue;
    }
}
