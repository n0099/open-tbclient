package c.a.o0.i0.c;

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
/* loaded from: classes2.dex */
public interface a {
    public static final C0812a a = C0812a.a;

    /* renamed from: c.a.o0.i0.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0812a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ C0812a a;

        /* renamed from: b  reason: collision with root package name */
        public static final ServiceReference f10328b;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-757309719, "Lc/a/o0/i0/c/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-757309719, "Lc/a/o0/i0/c/a$a;");
                    return;
                }
            }
            a = new C0812a();
            f10328b = new ServiceReference("Frs", "FrsService");
        }

        public C0812a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public final ServiceReference a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f10328b : (ServiceReference) invokeV.objValue;
        }
    }

    void a(TbPageContext<?> tbPageContext, long j);

    void b(Context context, Frs$From frs$From, Long l, String str);

    void c(Long l, String str);
}
