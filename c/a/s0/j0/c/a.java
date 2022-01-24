package c.a.s0.j0.c;

import android.content.Context;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.module.frs.Frs$From;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public interface a {
    public static final C0862a a = C0862a.a;

    /* renamed from: c.a.s0.j0.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0862a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ C0862a a;

        /* renamed from: b  reason: collision with root package name */
        public static final ServiceReference f12953b;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2048433306, "Lc/a/s0/j0/c/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2048433306, "Lc/a/s0/j0/c/a$a;");
                    return;
                }
            }
            a = new C0862a();
            f12953b = new ServiceReference("Frs", "FrsService");
        }

        public C0862a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public final ServiceReference a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f12953b : (ServiceReference) invokeV.objValue;
        }
    }

    void a(TbPageContext<?> tbPageContext, long j2);

    void b(Context context, Frs$From frs$From, Long l, String str);

    void c(Long l, String str);
}
