package a.a.a.a.y;

import android.content.SharedPreferences;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.fun.ad.sdk.FunAdSdk;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final SharedPreferences f1371a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1836995981, "La/a/a/a/y/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1836995981, "La/a/a/a/y/b;");
                return;
            }
        }
        f1371a = FunAdSdk.getAppContext().getSharedPreferences("fun_ad_sdk", 0);
    }

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? f1371a.getInt("key_rpt_fai_c", 0) : invokeV.intValue;
    }

    public static void a(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(AdIconUtil.AD_TEXT_ID, null, str, i2) == null) {
            f1371a.edit().putInt(str, i2).apply();
        }
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? f1371a.getInt("key_rpt_req_c", 0) : invokeV.intValue;
    }

    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? f1371a.getInt("key_rpt_suc_c", 0) : invokeV.intValue;
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            synchronized ("key_rpt_req_c") {
                a("key_rpt_req_c", b() + 1);
            }
        }
    }

    public static int a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return f1371a.getInt("key_sid_c_pre_" + str, 0);
        }
        return invokeL.intValue;
    }

    public static void a(long j, int i2, int i3, a.a.a.a.v.a aVar) {
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i3), aVar}) == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                objectOutputStream.writeInt(aVar.f1352a);
                aVar.a(objectOutputStream);
                objectOutputStream.flush();
                bArr = byteArrayOutputStream.toByteArray();
            } catch (IOException unused) {
                bArr = null;
            }
            String encodeToString = bArr != null ? Base64.encodeToString(bArr, 0) : null;
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(encodeToString == null ? -1 : encodeToString.length());
            d.c("sspsUTF len:%d", objArr);
            f1371a.edit().putLong("key_config_v", j).putInt("key_config_interval", i2).putInt("key_V", i3).putString("key_adcfg", encodeToString).apply();
        }
    }

    public static void a(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(65539, null, i2, i3, i4, i5) == null) {
            synchronized ("key_rpt_req_c") {
                int b2 = b();
                int c2 = c();
                int i6 = f1371a.getInt("key_rpt_mis_c", 0);
                f1371a.edit().putInt("key_rpt_req_c", b2 - i2).putInt("key_rpt_fai_c", a() - i3).putInt("key_rpt_suc_c", c2 - i4).putInt("key_rpt_mis_c", i6 - i5).apply();
            }
        }
    }
}
