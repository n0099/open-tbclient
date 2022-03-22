package c.a.t0.a.f;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
/* loaded from: classes3.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f21372b;

    /* renamed from: c  reason: collision with root package name */
    public static StringBuffer f21373c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.t0.a.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1586a extends c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f21374b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f21375c;

        public C1586a(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.f21374b = str2;
            this.f21375c = str3;
        }

        @Override // c.a.t0.a.f.c
        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                StringBuffer stringBuffer = new StringBuffer();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss:SSS");
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+08"));
                stringBuffer.append(simpleDateFormat.format(new Date()));
                stringBuffer.append("\t");
                stringBuffer.append(this.a);
                stringBuffer.append("\t");
                stringBuffer.append(this.f21374b);
                stringBuffer.append("\t");
                stringBuffer.append(this.f21375c);
                f.d(stringBuffer.toString(), com.baidu.ubs.analytics.d.a.f37803c, a.f21373c.toString());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1003966, "Lc/a/t0/a/f/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1003966, "Lc/a/t0/a/f/a;");
                return;
            }
        }
        f21373c = new StringBuffer();
        if (c.a.t0.a.c.h() != null) {
            a = !com.baidu.ubs.analytics.d.a.a();
            f21372b = true;
            f21373c.append("ABsdkLog-");
            f21373c.append(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
            f21373c.append("_");
            try {
                f21373c.append(c(c.a.t0.a.e.i.g(c.a.t0.a.c.h().getContext()).getBytes("UTF-8")));
            } catch (UnsupportedEncodingException e2) {
                i.d(e2);
            } catch (Exception e3) {
                i.d(e3);
            }
            f21373c.append(".log");
        }
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            if (a) {
                Log.w("BaiDuUbs", str);
            }
            d("w", "BaiDuUbs", str);
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            if (a) {
                Log.e("BaiDuUbs", str);
            }
            d("e", "BaiDuUbs", str);
        }
    }

    public static String c(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bArr)) == null) {
            StringBuilder sb = new StringBuilder("");
            if (bArr == null || bArr.length <= 0) {
                return null;
            }
            for (byte b2 : bArr) {
                String hexString = Integer.toHexString(b2 & 255);
                if (hexString.length() < 2) {
                    sb.append(0);
                }
                sb.append(hexString);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static void d(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2, str3) == null) && f21372b) {
            b.a(new C1586a(str, str2, str3));
        }
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? f21373c.toString() : (String) invokeV.objValue;
    }
}
