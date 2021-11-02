package b.a.r0.v.b.e;

import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.k;
import b.a.p0.a.p.d.k0;
import b.a.q0.o0.d;
import b.a.q0.o0.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
@Singleton
@Service
/* loaded from: classes5.dex */
public class a implements k0 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f24168b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f24169a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(881067700, "Lb/a/r0/v/b/e/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(881067700, "Lb/a/r0/v/b/e/a;");
                return;
            }
        }
        f24168b = k.f6397a;
    }

    public a() {
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

    @Override // b.a.p0.a.p.d.k0
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            boolean z = f24168b;
            long l = b.a.q0.s.e0.b.j().l("smart_app_tid", 0L);
            String p = b.a.q0.s.e0.b.j().p("smart_app_id", "");
            String p2 = b.a.q0.s.e0.b.j().p("smart_app_name", "");
            if (this.f24169a == 0 || l == 0) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis() - this.f24169a;
            d dVar = new d();
            dVar.y(currentTimeMillis);
            dVar.s(g());
            dVar.C(l);
            dVar.f12787i = p;
            dVar.j = p2;
            dVar.x(h());
            e.b().j(true);
            e.b().k(TbadkApplication.getInst().getApplicationContext(), dVar, i());
            b.a.q0.s.e0.b.j().w("smart_app_tid", 0L);
        }
    }

    @Override // b.a.p0.a.p.d.k0
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    @Override // b.a.p0.a.p.d.k0
    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            if (f24168b) {
                String str2 = "onAppForeground" + b.a.p0.a.a2.e.i().f3961f;
            }
            this.f24169a = System.currentTimeMillis();
        }
    }

    @Override // b.a.p0.a.p.d.k0
    public void d(@NonNull SwanAppActivity swanAppActivity, int i2, @Nullable b.a.p0.a.f1.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, swanAppActivity, i2, bVar) == null) {
            boolean z = f24168b;
            if (b.a.q0.s.e0.b.j().g("key_ai_app_guide_display", true)) {
                b.a.q0.s.e0.b.j().t("key_ai_app_guide_display", false);
                Intent intent = new Intent(swanAppActivity, DealIntentService.class);
                intent.putExtra(DealIntentService.KEY_CLASS, 38);
                swanAppActivity.startService(intent);
            }
        }
    }

    @Override // b.a.p0.a.p.d.k0
    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
        }
    }

    @Override // b.a.p0.a.p.d.k0
    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
        }
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "a061" : (String) invokeV.objValue;
    }

    public List<String> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("a001");
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public b.a.q0.o0.b i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return null;
        }
        return (b.a.q0.o0.b) invokeV.objValue;
    }
}
