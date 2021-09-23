package c.a.f0.b.g;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.prologue.service.network.Als;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static String f3390b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final h f3391a;

    public b(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f3391a = hVar;
    }

    public static void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65537, null, i2) == null) {
            g(i2, "");
        }
    }

    public static void g(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65538, null, i2, str) == null) {
            String f2 = c.a.f0.a.c.j.f("empty_ext_info", "");
            if (TextUtils.isEmpty(f2)) {
                return;
            }
            Als.c cVar = new Als.c(Als.Type.SHOW);
            cVar.l(Als.Page.NA_SPLASH);
            cVar.f(String.valueOf(i2));
            cVar.m(f2);
            if (!TextUtils.isEmpty(str)) {
                cVar.g(str);
            }
            Als.e(cVar);
        }
    }

    public static void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            f3390b = "";
        }
    }

    public static void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) {
            f3390b = str;
        }
    }

    public void a(@NonNull Als.Area area, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, area, str) == null) {
            c(area, str);
            i();
        }
    }

    public void b(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
            h(jSONObject);
            j();
        }
    }

    public void c(@NonNull Als.Area area, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, area, str) == null) {
            Als.c cVar = new Als.c(Als.Type.CLICK);
            cVar.l(Als.Page.NA_SPLASH);
            cVar.m(this.f3391a.f3417d);
            cVar.e(area);
            if (!TextUtils.isEmpty(str)) {
                cVar.h(str);
            }
            Als.e(cVar);
        }
    }

    public void d(String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048579, this, str, j2) == null) {
            Als.c cVar = new Als.c(Als.Type.CLOSE);
            cVar.l(Als.Page.NA_SPLASH);
            cVar.m(this.f3391a.f3417d);
            cVar.g(String.valueOf(j2));
            if (c.a.f0.a.b.a.f3338a.get().A()) {
                cVar.f("1");
            } else {
                cVar.f("0");
            }
            cVar.h(str);
            Als.e(cVar);
        }
    }

    public void e(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            Als.c cVar = new Als.c(Als.Type.DISCARD);
            cVar.l(Als.Page.NA_SPLASH);
            cVar.m(this.f3391a.f3417d);
            cVar.f("10");
            cVar.g(str);
            cVar.h(str2);
            Als.e(cVar);
        }
    }

    public void h(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jSONObject) == null) {
            Als.c cVar = new Als.c(Als.Type.SHOW);
            cVar.l(Als.Page.NA_SPLASH);
            cVar.m(this.f3391a.f3417d);
            if (jSONObject != null) {
                if (jSONObject.has("adRenderCostTime")) {
                    cVar.g(jSONObject.optString("adRenderCostTime"));
                }
                if (jSONObject.has("adLoadCostTime")) {
                    cVar.k(jSONObject.optString("adLoadCostTime"));
                }
                if (jSONObject.has("adShowScene")) {
                    cVar.f(jSONObject.optString("adShowScene"));
                }
                if (jSONObject.has("adSplashType")) {
                    cVar.h(jSONObject.optString("adSplashType"));
                }
            }
            Als.e(cVar);
        }
    }

    public void i() {
        String[] strArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (strArr = this.f3391a.q) == null) {
            return;
        }
        for (String str : strArr) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                c.a.f0.d.a.h.a(new JSONObject(str).optString("url").replace("__GESTURE__", String.valueOf(f3390b)));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void j() {
        String[] strArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (strArr = this.f3391a.p) == null) {
            return;
        }
        for (String str : strArr) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                c.a.f0.d.a.h.a(new JSONObject(str).optString("url"));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }
}
