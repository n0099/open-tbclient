package c.a.r0.g.g;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.r0.a.c2.b.e.b;
import c.a.r0.a.k;
import c.a.r0.a.n2.n;
import c.a.r0.a.p.d.j1;
import c.a.r0.a.z2.r0;
import c.a.r0.a.z2.y;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.searchbox.download.center.clearcache.controller.ClearCacheUbcController;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Service
/* loaded from: classes6.dex */
public class e implements j1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.r0.a.a3.j.b a;

    /* loaded from: classes6.dex */
    public class a implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppActivity a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f10479b;

        public a(e eVar, SwanAppActivity swanAppActivity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, swanAppActivity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppActivity;
            this.f10479b = str;
        }

        @Override // c.a.r0.a.c2.b.e.b.a
        public void a(c.a.r0.a.c2.b.e.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                c.a.r0.a.j1.d.e.a.d(bVar.c(), this.a, this.f10479b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends c.a.r0.a.t0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppActivity a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f10480b;

        public b(e eVar, SwanAppActivity swanAppActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, swanAppActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10480b = eVar;
            this.a = swanAppActivity;
        }

        @Override // c.a.r0.a.t0.a, c.a.r0.a.t0.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f10480b.a.j();
                this.a.unregisterCallback(this);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-507249583, "Lc/a/r0/g/g/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-507249583, "Lc/a/r0/g/g/e;");
                return;
            }
        }
        boolean z = k.a;
    }

    public e() {
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

    @Override // c.a.r0.a.p.d.j1
    public void a(NgWebView ngWebView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ngWebView) == null) {
            ngWebView.doSelectionCancel();
        }
    }

    @Override // c.a.r0.a.p.d.j1
    public void b(NgWebView ngWebView, String str) {
        SwanAppActivity x;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ngWebView, str) == null) || (x = c.a.r0.a.d2.d.J().x()) == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.a = new c.a.r0.a.a3.j.b(ngWebView.covertToView());
        int[] g2 = g(x);
        int[] h2 = h(x);
        for (int i2 = 0; i2 < g2.length; i2++) {
            this.a.e(g2[i2], h2[i2]);
        }
        this.a.r(new a(this, x, str));
        this.a.t();
        x.registerCallback(new b(this, x));
    }

    @Override // c.a.r0.a.p.d.j1
    public void c(NgWebView ngWebView, int i2, int i3, int i4, int i5, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{ngWebView, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), str, Boolean.valueOf(z)}) == null) {
            ngWebView.updateAndShowPopupWindow(i4, i5, i2, i3, str, true);
            if (z) {
                i("show", null, null);
            }
        }
    }

    @Override // c.a.r0.a.p.d.j1
    public void d(String str, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, context) == null) {
        }
    }

    @Override // c.a.r0.a.p.d.j1
    public void e(String str, Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, str, context) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        r0.b(context).c(str);
        i("click", "copy", null);
    }

    public int[] g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) {
            int[] iArr = {7, 6, 8};
            if (y.a(context, "android.permission.SET_WALLPAPER")) {
                return iArr;
            }
            int[] iArr2 = new int[2];
            System.arraycopy(iArr, 0, iArr2, 0, 2);
            return iArr2;
        }
        return (int[]) invokeL.objValue;
    }

    public int[] h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, context)) == null) {
            int[] iArr = {c.a.r0.g.e.swan_app_img_menu_load_image, c.a.r0.g.e.swan_app_img_menu_save_image, c.a.r0.g.e.swan_app_img_menu_set_wallpaper};
            if (y.a(context, "android.permission.SET_WALLPAPER")) {
                return iArr;
            }
            int[] iArr2 = new int[2];
            System.arraycopy(iArr, 0, iArr2, 0, 2);
            return iArr2;
        }
        return (int[]) invokeL.objValue;
    }

    public void i(@NonNull String str, @Nullable String str2, @Nullable String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, str, str2, str3) == null) {
            c.a.r0.a.n2.s.e eVar = new c.a.r0.a.n2.s.e();
            eVar.a = ClearCacheUbcController.FROM_VALUE;
            eVar.f8123f = c.a.r0.a.d2.d.J().getAppId();
            eVar.f8120c = "miniapp";
            eVar.f8124g = "text";
            eVar.f8119b = str;
            eVar.f8122e = str2;
            if (!TextUtils.isEmpty(str3)) {
                eVar.a("query", str3);
            }
            n.x("810", eVar);
        }
    }
}
