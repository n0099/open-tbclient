package c.a.r0.a.g2;

import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.h2.c.f;
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
    public static final Map<String, Boolean> f6403b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.r0.a.g2.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0355a implements c.a.r0.a.z2.g1.c<f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f6404e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.z2.g1.c f6405f;

        public C0355a(String str, c.a.r0.a.z2.g1.c cVar) {
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
            this.f6404e = str;
            this.f6405f = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                boolean z = true;
                z = (fVar == null || fVar.f7267d || fVar.f7273j != 1) ? false : false;
                a.a.put(this.f6404e, Boolean.valueOf(z));
                this.f6405f.onCallback(Boolean.valueOf(z));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(425116037, "Lc/a/r0/a/g2/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(425116037, "Lc/a/r0/a/g2/a;");
                return;
            }
        }
        a = new ConcurrentHashMap();
        f6403b = new ConcurrentHashMap();
    }

    public static void b(c.a.r0.a.z2.g1.c<Boolean> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, cVar) == null) {
            String appId = c.a.r0.a.d2.d.J().getAppId();
            Boolean bool = a.get(appId);
            if (bool != null) {
                cVar.onCallback(bool);
            } else {
                c.a.r0.a.d2.d.J().r().d0().e("mapp_custom_screenshot_image", new C0355a(appId, cVar));
            }
        }
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            Boolean bool = f6403b.get(c.a.r0.a.d2.d.J().getAppId());
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
            f6403b.clear();
            a.clear();
        }
    }

    public static void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65541, null, z) == null) {
            f6403b.put(c.a.r0.a.d2.d.J().getAppId(), Boolean.valueOf(z));
        }
    }
}
