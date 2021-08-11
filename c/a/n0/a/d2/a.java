package c.a.n0.a.d2;

import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.e2.c.f;
import com.baidu.mobads.container.util.AdIconUtil;
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

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, Boolean> f4873a;

    /* renamed from: b  reason: collision with root package name */
    public static final Map<String, Boolean> f4874b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.n0.a.d2.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0136a implements c.a.n0.a.v2.e1.b<f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f4875e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.v2.e1.b f4876f;

        public C0136a(String str, c.a.n0.a.v2.e1.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4875e = str;
            this.f4876f = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                boolean z = true;
                z = (fVar == null || fVar.f5267d || fVar.f5273j != 1) ? false : false;
                a.f4873a.put(this.f4875e, Boolean.valueOf(z));
                this.f4876f.onCallback(Boolean.valueOf(z));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1208399494, "Lc/a/n0/a/d2/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1208399494, "Lc/a/n0/a/d2/a;");
                return;
            }
        }
        f4873a = new ConcurrentHashMap();
        f4874b = new ConcurrentHashMap();
    }

    public static void b(c.a.n0.a.v2.e1.b<Boolean> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, bVar) == null) {
            String appId = c.a.n0.a.a2.d.g().getAppId();
            Boolean bool = f4873a.get(appId);
            if (bool != null) {
                bVar.onCallback(bool);
            } else {
                c.a.n0.a.a2.d.g().r().T().e("mapp_custom_screenshot_image", new C0136a(appId, bVar));
            }
        }
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            Boolean bool = f4874b.get(c.a.n0.a.a2.d.g().getAppId());
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
            f4874b.clear();
            f4873a.clear();
        }
    }

    public static void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(AdIconUtil.AD_TEXT_ID, null, z) == null) {
            f4874b.put(c.a.n0.a.a2.d.g().getAppId(), Boolean.valueOf(z));
        }
    }
}
