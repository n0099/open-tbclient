package c.a.r0.q.h;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ad.statis.CustomALSHttpMessage;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class a implements c.a.r0.h3.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.r0.q.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class C1126a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static a f24157a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1858819668, "Lc/a/r0/q/h/a$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1858819668, "Lc/a/r0/q/h/a$b;");
                    return;
                }
            }
            f24157a = new a(null);
        }
    }

    public /* synthetic */ a(C1126a c1126a) {
        this();
    }

    public static a g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b.f24157a : (a) invokeV.objValue;
    }

    @Override // c.a.r0.h3.a
    public void a(long j2, String str, String str2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), str, str2, Long.valueOf(j3)}) == null) {
            CustomALSHttpMessage init = new CustomALSHttpMessage().init("1001", "every_log");
            init.addParam("f1", "pagetime");
            init.addParam("f2", str2);
            init.addParam("f3", j2 + "");
            init.addParam("f4", str);
            init.addParam("f5", j3);
            init.send();
        }
    }

    @Override // c.a.r0.h3.a
    public void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            CustomALSHttpMessage init = new CustomALSHttpMessage().init("1001", "every_log");
            init.addParam("f1", "fullvideoshow");
            init.addParam("f2", str2);
            init.addParam("extf", str);
            init.send();
        }
    }

    @Override // c.a.r0.h3.a
    public void c(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            CustomALSHttpMessage init = new CustomALSHttpMessage().init("1001", "every_log");
            init.addParam("f1", "cardclick");
            init.addParam("f2", str2);
            init.addParam("extf", str);
            init.send();
        }
    }

    @Override // c.a.r0.h3.a
    public void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            CustomALSHttpMessage init = new CustomALSHttpMessage().init("1001", "every_log");
            init.addParam("f1", "cardshow");
            init.addParam("f2", str2);
            init.addParam("extf", str);
            init.send();
        }
    }

    @Override // c.a.r0.h3.a
    public void e(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, str, str2, str3) == null) {
            CustomALSHttpMessage init = new CustomALSHttpMessage().init("1001", "every_log");
            init.addParam("f1", "alert_click");
            init.addParam("f2", str);
            init.addParam("f5", str2);
            init.addParam("extf", str3);
            init.send();
        }
    }

    @Override // c.a.r0.h3.a
    public void f(long j2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Long.valueOf(j2), str, str2}) == null) {
            CustomALSHttpMessage init = new CustomALSHttpMessage().init("1001", "every_log");
            init.addParam("f1", "pageshow");
            init.addParam("f2", str2);
            init.addParam("f3", j2 + "");
            init.addParam("f4", str);
            init.send();
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
