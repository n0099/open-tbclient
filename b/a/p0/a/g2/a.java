package b.a.p0.a.g2;

import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.h2.c.f;
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
    public static final Map<String, Boolean> f5309a;

    /* renamed from: b  reason: collision with root package name */
    public static final Map<String, Boolean> f5310b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b.a.p0.a.g2.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0197a implements b.a.p0.a.z2.g1.c<f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f5311e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.z2.g1.c f5312f;

        public C0197a(String str, b.a.p0.a.z2.g1.c cVar) {
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
            this.f5311e = str;
            this.f5312f = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                boolean z = true;
                z = (fVar == null || fVar.f6385d || fVar.j != 1) ? false : false;
                a.f5309a.put(this.f5311e, Boolean.valueOf(z));
                this.f5312f.onCallback(Boolean.valueOf(z));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1323701672, "Lb/a/p0/a/g2/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1323701672, "Lb/a/p0/a/g2/a;");
                return;
            }
        }
        f5309a = new ConcurrentHashMap();
        f5310b = new ConcurrentHashMap();
    }

    public static void b(b.a.p0.a.z2.g1.c<Boolean> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, cVar) == null) {
            String appId = b.a.p0.a.d2.d.J().getAppId();
            Boolean bool = f5309a.get(appId);
            if (bool != null) {
                cVar.onCallback(bool);
            } else {
                b.a.p0.a.d2.d.J().r().d0().e("mapp_custom_screenshot_image", new C0197a(appId, cVar));
            }
        }
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            Boolean bool = f5310b.get(b.a.p0.a.d2.d.J().getAppId());
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
            f5310b.clear();
            f5309a.clear();
        }
    }

    public static void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(AdIconUtil.AD_TEXT_ID, null, z) == null) {
            f5310b.put(b.a.p0.a.d2.d.J().getAppId(), Boolean.valueOf(z));
        }
    }
}
