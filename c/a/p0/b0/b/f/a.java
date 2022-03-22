package c.a.p0.b0.b.f;

import android.content.Intent;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.d.m.i;
import c.a.d.m.k;
import c.a.n0.a.f.d.n0;
import c.a.o0.p0.d;
import c.a.o0.p0.e;
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
/* loaded from: classes2.dex */
public class a implements n0 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f12441b;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-889417272, "Lc/a/p0/b0/b/f/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-889417272, "Lc/a/p0/b0/b/f/a;");
                return;
            }
        }
        f12441b = c.a.n0.a.a.a;
    }

    public a() {
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

    @Override // c.a.n0.a.f.d.n0
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if (f12441b) {
                Log.e("DefaultSwanAppLifecycle", "onAppBackground");
            }
            long m = c.a.o0.r.j0.b.k().m("smart_app_tid", 0L);
            String q = c.a.o0.r.j0.b.k().q("smart_app_id", "");
            String q2 = c.a.o0.r.j0.b.k().q("smart_app_name", "");
            if (this.a == 0 || m == 0) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis() - this.a;
            d dVar = new d();
            dVar.y(currentTimeMillis);
            dVar.s(g());
            dVar.C(m);
            dVar.i = q;
            dVar.j = q2;
            dVar.x(h());
            e.b().j(true);
            e.b().k(TbadkApplication.getInst().getApplicationContext(), dVar, i());
            c.a.o0.r.j0.b.k().x("smart_app_tid", 0L);
        }
    }

    @Override // c.a.n0.a.f.d.n0
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    @Override // c.a.n0.a.f.d.n0
    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            if (f12441b) {
                Log.e("DefaultSwanAppLifecycle", "onAppForeground" + c.a.n0.a.t1.e.L().f6344b);
            }
            File file = new File(i.b("libBaiduMapSDK_map_v5_4_4.so"));
            if (file.exists() && file.isFile() && BdBaseApplication.getInst().getResHashMap().get("libBaiduMapSDK_map_v5_4_4.so") == null && k.a(BdBaseApplication.getInst().getContext(), i.a("libBaiduMapSDK_map_v5_4_4.so"))) {
                BdBaseApplication.getInst().getResHashMap().put("libBaiduMapSDK_map_v5_4_4.so", i.a("libBaiduMapSDK_map_v5_4_4.so"));
            }
            this.a = System.currentTimeMillis();
        }
    }

    @Override // c.a.n0.a.f.d.n0
    public void d(@NonNull SwanAppActivity swanAppActivity, int i, @Nullable c.a.n0.a.v0.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, swanAppActivity, i, bVar) == null) {
            if (f12441b) {
                Log.e("DefaultSwanAppLifecycle", "onAppExit");
            }
            if (c.a.o0.r.j0.b.k().h("key_ai_app_guide_display", true)) {
                Intent intent = new Intent(swanAppActivity, DealIntentService.class);
                intent.putExtra(DealIntentService.KEY_CLASS, 38);
                swanAppActivity.startService(intent);
            }
        }
    }

    @Override // c.a.n0.a.f.d.n0
    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
        }
    }

    @Override // c.a.n0.a.f.d.n0
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

    public c.a.o0.p0.b i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return null;
        }
        return (c.a.o0.p0.b) invokeV.objValue;
    }
}
