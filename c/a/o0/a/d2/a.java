package c.a.o0.a.d2;

import androidx.core.view.InputDeviceCompat;
import c.a.o0.a.e2.c.f;
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
    public static final Map<String, Boolean> f5119a;

    /* renamed from: b  reason: collision with root package name */
    public static final Map<String, Boolean> f5120b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.o0.a.d2.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0144a implements c.a.o0.a.v2.e1.b<f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f5121e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.v2.e1.b f5122f;

        public C0144a(String str, c.a.o0.a.v2.e1.b bVar) {
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
            this.f5121e = str;
            this.f5122f = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                boolean z = true;
                z = (fVar == null || fVar.f5513d || fVar.f5519j != 1) ? false : false;
                a.f5119a.put(this.f5121e, Boolean.valueOf(z));
                this.f5122f.onCallback(Boolean.valueOf(z));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1011885989, "Lc/a/o0/a/d2/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1011885989, "Lc/a/o0/a/d2/a;");
                return;
            }
        }
        f5119a = new ConcurrentHashMap();
        f5120b = new ConcurrentHashMap();
    }

    public static void b(c.a.o0.a.v2.e1.b<Boolean> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, bVar) == null) {
            String appId = c.a.o0.a.a2.d.g().getAppId();
            Boolean bool = f5119a.get(appId);
            if (bool != null) {
                bVar.onCallback(bool);
            } else {
                c.a.o0.a.a2.d.g().r().T().e("mapp_custom_screenshot_image", new C0144a(appId, bVar));
            }
        }
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            Boolean bool = f5120b.get(c.a.o0.a.a2.d.g().getAppId());
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
            f5120b.clear();
            f5119a.clear();
        }
    }

    public static void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(AdIconUtil.AD_TEXT_ID, null, z) == null) {
            f5120b.put(c.a.o0.a.a2.d.g().getAppId(), Boolean.valueOf(z));
        }
    }
}
