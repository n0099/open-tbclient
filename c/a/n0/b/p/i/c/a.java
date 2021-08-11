package c.a.n0.b.p.i.c;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.a2.e;
import c.a.n0.a.j2.c;
import c.a.n0.a.k;
import c.a.n0.b.p.i.b.a;
import c.a.n0.b.p.i.b.b;
import com.baidu.location.BDLocation;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.swan.apps.impl.nalib.encrypt.EncryptConstant;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f10031a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1503835551, "Lc/a/n0/b/p/i/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1503835551, "Lc/a/n0/b/p/i/c/a;");
                return;
            }
        }
        f10031a = k.f6803a;
    }

    @Nullable
    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            try {
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                cipher.init(1, new SecretKeySpec((EncryptConstant.getPartRecommendAesKey() + "rtad@mic").getBytes(), "AES"), new IvParameterSpec((EncryptConstant.getPartRecommendAesIv() + "21248000").getBytes()));
                return Base64.encodeToString(cipher.doFinal(str.getBytes("utf-8")), 2);
            } catch (Exception e2) {
                e2.printStackTrace();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("info", "encrypt request param fail with exception : " + e2.getMessage());
                } catch (JSONException e3) {
                    if (f10031a) {
                        e3.printStackTrace();
                    }
                }
                f(jSONObject.toString());
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static void b(c.a.n0.b.p.i.b.a aVar, b bVar) {
        char c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, aVar, bVar) == null) || aVar == null || bVar == null) {
            return;
        }
        String str = TextUtils.isEmpty(bVar.f10028a) ? "unknown" : bVar.f10028a;
        switch (str.hashCode()) {
            case -1395470197:
                if (str.equals("bd09ll")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case 3017163:
                if (str.equals(BDLocation.BDLOCATION_GCJ02_TO_BD09)) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case 98175376:
                if (str.equals("gcj02")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 113079775:
                if (str.equals(CoordinateType.WGS84)) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        int i2 = c2 != 0 ? c2 != 1 ? c2 != 2 ? c2 != 3 ? -1 : 3 : 2 : 1 : 0;
        a.c cVar = aVar.f10011c;
        cVar.f10025a = i2;
        cVar.f10026b = bVar.f10029b;
        cVar.f10027c = bVar.f10030c;
    }

    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            String e2 = SwanAppNetworkUtils.e();
            if ("wifi".equals(e2)) {
                return 1;
            }
            if ("2g".equals(e2)) {
                return 2;
            }
            if ("3g".equals(e2)) {
                return 3;
            }
            return "4g".equals(e2) ? 4 : 0;
        }
        return invokeV.intValue;
    }

    public static int d(Context context) {
        InterceptResult invokeL;
        TelephonyManager telephonyManager;
        String simOperator;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (context == null || (telephonyManager = (TelephonyManager) context.getSystemService("phone")) == null || (simOperator = telephonyManager.getSimOperator()) == null) {
                return 0;
            }
            if ("46000".equals(simOperator) || "46002".equals(simOperator) || "46007".equals(simOperator)) {
                return 1;
            }
            if ("46001".equals(simOperator)) {
                return 3;
            }
            return "46003".equals(simOperator) ? 2 : 0;
        }
        return invokeL.intValue;
    }

    public static boolean e(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) ? (context.getResources().getConfiguration().screenLayout & 15) >= 3 : invokeL.booleanValue;
    }

    public static void f(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (f10031a) {
            String str2 = "reportInfoWhenResponseIsNull: " + str;
        }
        c.b bVar = new c.b(10003);
        bVar.i(str);
        bVar.h(e.V());
        bVar.m();
    }
}
