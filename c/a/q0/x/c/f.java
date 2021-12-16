package c.a.q0.x.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.UUID;
/* loaded from: classes6.dex */
public class f implements b<String> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    public f(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context.getApplicationContext();
    }

    public static byte[] g(byte[]... bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bArr)) == null) {
            int i2 = 0;
            for (byte[] bArr2 : bArr) {
                i2 += bArr2.length;
            }
            byte[] bArr3 = new byte[i2];
            int i3 = 0;
            for (byte[] bArr4 : bArr) {
                System.arraycopy(bArr4, 0, bArr3, i3, bArr4.length);
                i3 += bArr4.length;
            }
            return bArr3;
        }
        return (byte[]) invokeL.objValue;
    }

    @Override // c.a.q0.x.c.b
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final String b() {
        InterceptResult invokeV;
        byte[] g2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            byte[] bytes = d().getBytes(StandardCharsets.UTF_8);
            byte[] bytes2 = "com.baidu.swan".getBytes(StandardCharsets.UTF_8);
            if (Build.VERSION.SDK_INT < 23) {
                g2 = g(bytes2, UUID.randomUUID().toString().getBytes(StandardCharsets.UTF_8), String.valueOf(System.nanoTime()).getBytes(StandardCharsets.UTF_8), bytes);
            } else {
                g2 = g(bytes2, bytes);
            }
            return c.a.q0.x.d.b.b(g2, true);
        }
        return (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.q0.x.c.b
    /* renamed from: c */
    public String get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? b() : (String) invokeV.objValue;
    }

    @SuppressLint({"HardwareIds"})
    public final String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            String a = c.a.q0.f.a.b.c.f9826b.a(this.a);
            if (TextUtils.isEmpty(a)) {
                a = e();
            }
            if (TextUtils.isEmpty(a)) {
                a = UUID.randomUUID().toString();
            }
            return a == null ? "" : a;
        }
        return (String) invokeV.objValue;
    }

    @SuppressLint({"DiscouragedPrivateApi"})
    public final String e() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            try {
                str = (String) Build.class.getField("SERIAL").get(null);
                try {
                    if (TextUtils.isEmpty(str) || TextUtils.equals(str, "unknown")) {
                        Method declaredMethod = Build.class.getDeclaredMethod("getString", String.class);
                        declaredMethod.setAccessible(true);
                        str = (String) declaredMethod.invoke(null, "ro.serialno");
                    }
                    if (TextUtils.isEmpty(str) || TextUtils.equals(str, "unknown")) {
                        str = f("ro.serialno");
                    }
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
                str = null;
            }
            if (TextUtils.isEmpty(str) || TextUtils.equals(str, "unknown")) {
                return null;
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public final String f(String str) {
        InterceptResult invokeL;
        BufferedReader bufferedReader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            BufferedReader bufferedReader2 = null;
            try {
                try {
                    Runtime runtime = Runtime.getRuntime();
                    bufferedReader = new BufferedReader(new InputStreamReader(runtime.exec("getprop " + str).getInputStream()), 256);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (IOException unused) {
            }
            try {
                String readLine = bufferedReader.readLine();
                c.a.q0.x.d.a.a(bufferedReader);
                return readLine == null ? "" : readLine;
            } catch (IOException unused2) {
                bufferedReader2 = bufferedReader;
                c.a.q0.x.d.a.a(bufferedReader2);
                c.a.q0.x.d.a.a(bufferedReader2);
                return "";
            } catch (Throwable th2) {
                th = th2;
                bufferedReader2 = bufferedReader;
                c.a.q0.x.d.a.a(bufferedReader2);
                throw th;
            }
        }
        return (String) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.q0.x.c.b
    /* renamed from: h */
    public void put(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
        }
    }
}
