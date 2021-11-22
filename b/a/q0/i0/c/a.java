package b.a.q0.i0.c;

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
/* loaded from: classes4.dex */
public interface a {

    /* renamed from: a  reason: collision with root package name */
    public static final C0700a f13386a = C0700a.f13388b;

    /* renamed from: b.a.q0.i0.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C0700a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final ServiceReference f13387a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ C0700a f13388b;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(11389896, "Lb/a/q0/i0/c/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(11389896, "Lb/a/q0/i0/c/a$a;");
                    return;
                }
            }
            f13388b = new C0700a();
            f13387a = new ServiceReference("Frs", "FrsService");
        }

        public C0700a() {
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f13387a : (ServiceReference) invokeV.objValue;
        }
    }

    void a(TbPageContext<?> tbPageContext, long j);

    void b(Context context, Frs$From frs$From, Long l, String str);

    void c(Long l, String str);
}
