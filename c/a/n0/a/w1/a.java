package c.a.n0.a.w1;

import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.x1.c.f;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<String, Boolean> a;

    /* renamed from: b  reason: collision with root package name */
    public static final Map<String, Boolean> f6972b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.n0.a.w1.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0512a implements c.a.n0.a.p2.g1.c<f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.p2.g1.c f6973b;

        public C0512a(String str, c.a.n0.a.p2.g1.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, cVar};
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
            this.f6973b = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                boolean z = true;
                z = (fVar == null || fVar.f7640d || fVar.j != 1) ? false : false;
                a.a.put(this.a, Boolean.valueOf(z));
                this.f6973b.onCallback(Boolean.valueOf(z));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1225916602, "Lc/a/n0/a/w1/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1225916602, "Lc/a/n0/a/w1/a;");
                return;
            }
        }
        a = new ConcurrentHashMap();
        f6972b = new ConcurrentHashMap();
    }

    public static void b(c.a.n0.a.p2.g1.c<Boolean> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, cVar) == null) {
            String appId = c.a.n0.a.t1.d.J().getAppId();
            Boolean bool = a.get(appId);
            if (bool != null) {
                cVar.onCallback(bool);
            } else {
                c.a.n0.a.t1.d.J().r().d0().e("mapp_custom_screenshot_image", new C0512a(appId, cVar));
            }
        }
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            Boolean bool = f6972b.get(c.a.n0.a.t1.d.J().getAppId());
            if (bool != null) {
                return bool.booleanValue();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            f6972b.clear();
            a.clear();
        }
    }

    public static void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65541, null, z) == null) {
            f6972b.put(c.a.n0.a.t1.d.J().getAppId(), Boolean.valueOf(z));
        }
    }
}
