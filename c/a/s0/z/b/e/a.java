package c.a.s0.z.b.e;

import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.d.k.i;
import c.a.d.k.j;
import c.a.q0.a.k;
import c.a.q0.a.p.d.n0;
import c.a.r0.p0.d;
import c.a.r0.p0.e;
import com.baidu.adp.base.BdBaseApplication;
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
import java.io.File;
import java.util.ArrayList;
import java.util.List;
@Singleton
@Service
/* loaded from: classes9.dex */
public class a implements n0 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f26256b;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1027025102, "Lc/a/s0/z/b/e/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1027025102, "Lc/a/s0/z/b/e/a;");
                return;
            }
        }
        f26256b = k.a;
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

    @Override // c.a.q0.a.p.d.n0
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            boolean z = f26256b;
            long l = c.a.r0.s.g0.b.j().l("smart_app_tid", 0L);
            String p = c.a.r0.s.g0.b.j().p("smart_app_id", "");
            String p2 = c.a.r0.s.g0.b.j().p("smart_app_name", "");
            if (this.a == 0 || l == 0) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis() - this.a;
            d dVar = new d();
            dVar.y(currentTimeMillis);
            dVar.s(g());
            dVar.C(l);
            dVar.f12802i = p;
            dVar.f12803j = p2;
            dVar.x(h());
            e.b().j(true);
            e.b().k(TbadkApplication.getInst().getApplicationContext(), dVar, i());
            c.a.r0.s.g0.b.j().w("smart_app_tid", 0L);
        }
    }

    @Override // c.a.q0.a.p.d.n0
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    @Override // c.a.q0.a.p.d.n0
    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            if (f26256b) {
                String str2 = "onAppForeground" + c.a.q0.a.d2.e.L().f4925f;
            }
            File file = new File(i.b("libBaiduMapSDK_map_v5_4_4.so"));
            if (file.exists() && file.isFile() && BdBaseApplication.getInst().getResHashMap().get("libBaiduMapSDK_map_v5_4_4.so") == null && j.a(BdBaseApplication.getInst().getContext(), i.a("libBaiduMapSDK_map_v5_4_4.so"))) {
                BdBaseApplication.getInst().getResHashMap().put("libBaiduMapSDK_map_v5_4_4.so", i.a("libBaiduMapSDK_map_v5_4_4.so"));
            }
            this.a = System.currentTimeMillis();
        }
    }

    @Override // c.a.q0.a.p.d.n0
    public void d(@NonNull SwanAppActivity swanAppActivity, int i2, @Nullable c.a.q0.a.f1.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, swanAppActivity, i2, bVar) == null) {
            boolean z = f26256b;
            if (c.a.r0.s.g0.b.j().g("key_ai_app_guide_display", true)) {
                c.a.r0.s.g0.b.j().t("key_ai_app_guide_display", false);
                Intent intent = new Intent(swanAppActivity, DealIntentService.class);
                intent.putExtra(DealIntentService.KEY_CLASS, 38);
                swanAppActivity.startService(intent);
            }
        }
    }

    @Override // c.a.q0.a.p.d.n0
    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
        }
    }

    @Override // c.a.q0.a.p.d.n0
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

    public c.a.r0.p0.b i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return null;
        }
        return (c.a.r0.p0.b) invokeV.objValue;
    }
}
