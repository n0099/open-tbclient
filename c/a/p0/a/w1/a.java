package c.a.p0.a.w1;

import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.x1.c.f;
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
    public static final Map<String, Boolean> f8236b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.p0.a.w1.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0520a implements c.a.p0.a.p2.g1.c<f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8237e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.p2.g1.c f8238f;

        public C0520a(String str, c.a.p0.a.p2.g1.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8237e = str;
            this.f8238f = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                boolean z = true;
                z = (fVar == null || fVar.f9100d || fVar.f9106j != 1) ? false : false;
                a.a.put(this.f8237e, Boolean.valueOf(z));
                this.f8238f.onCallback(Boolean.valueOf(z));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(832889592, "Lc/a/p0/a/w1/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(832889592, "Lc/a/p0/a/w1/a;");
                return;
            }
        }
        a = new ConcurrentHashMap();
        f8236b = new ConcurrentHashMap();
    }

    public static void b(c.a.p0.a.p2.g1.c<Boolean> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, cVar) == null) {
            String appId = c.a.p0.a.t1.d.J().getAppId();
            Boolean bool = a.get(appId);
            if (bool != null) {
                cVar.onCallback(bool);
            } else {
                c.a.p0.a.t1.d.J().r().d0().e("mapp_custom_screenshot_image", new C0520a(appId, cVar));
            }
        }
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            Boolean bool = f8236b.get(c.a.p0.a.t1.d.J().getAppId());
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
            f8236b.clear();
            a.clear();
        }
    }

    public static void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65541, null, z) == null) {
            f8236b.put(c.a.p0.a.t1.d.J().getAppId(), Boolean.valueOf(z));
        }
    }
}
