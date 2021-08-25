package c.a.o0.e.g;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.o0.a.k;
import c.a.o0.a.p.d.d1;
import c.a.o0.a.v2.r0;
import c.a.o0.a.v2.y;
import c.a.o0.a.z1.b.e.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Service
/* loaded from: classes.dex */
public class e implements d1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.a.o0.a.w2.j.b f10368a;

    /* loaded from: classes.dex */
    public class a implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f10369a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f10370b;

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
            this.f10369a = swanAppActivity;
            this.f10370b = str;
        }

        @Override // c.a.o0.a.z1.b.e.b.a
        public void a(c.a.o0.a.z1.b.e.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                c.a.o0.a.i1.d.e.a.d(bVar.c(), this.f10369a, this.f10370b);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends c.a.o0.a.t0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f10371a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f10372b;

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
            this.f10372b = eVar;
            this.f10371a = swanAppActivity;
        }

        @Override // c.a.o0.a.t0.a, c.a.o0.a.t0.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f10372b.f10368a.j();
                this.f10371a.unregisterCallback(this);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(562888208, "Lc/a/o0/e/g/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(562888208, "Lc/a/o0/e/g/e;");
                return;
            }
        }
        boolean z = k.f7049a;
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

    @Override // c.a.o0.a.p.d.d1
    public void a(NgWebView ngWebView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ngWebView) == null) {
            ngWebView.doSelectionCancel();
        }
    }

    @Override // c.a.o0.a.p.d.d1
    public void b(NgWebView ngWebView, String str) {
        SwanAppActivity x;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ngWebView, str) == null) || (x = c.a.o0.a.a2.d.g().x()) == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f10368a = new c.a.o0.a.w2.j.b(ngWebView.covertToView());
        int[] g2 = g(x);
        int[] h2 = h(x);
        for (int i2 = 0; i2 < g2.length; i2++) {
            this.f10368a.e(g2[i2], h2[i2]);
        }
        this.f10368a.r(new a(this, x, str));
        this.f10368a.t();
        x.registerCallback(new b(this, x));
    }

    @Override // c.a.o0.a.p.d.d1
    public void c(NgWebView ngWebView, int i2, int i3, int i4, int i5, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{ngWebView, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), str, Boolean.valueOf(z)}) == null) {
            ngWebView.updateAndShowPopupWindow(i4, i5, i2, i3, str, true);
            if (z) {
                i("show", null, null);
            }
        }
    }

    @Override // c.a.o0.a.p.d.d1
    public void d(String str, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, context) == null) {
        }
    }

    @Override // c.a.o0.a.p.d.d1
    public void e(String str, Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, str, context) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        r0.b(context).c(str);
        i(PrefetchEvent.STATE_CLICK, "copy", null);
    }

    public int[] g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) {
            int[] iArr = {7, 6, 5, 8};
            if (y.a(context, "android.permission.SET_WALLPAPER")) {
                return iArr;
            }
            int[] iArr2 = new int[3];
            System.arraycopy(iArr, 0, iArr2, 0, 3);
            return iArr2;
        }
        return (int[]) invokeL.objValue;
    }

    public int[] h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, context)) == null) {
            int[] iArr = {c.a.o0.e.e.swan_app_img_menu_load_image, c.a.o0.e.e.swan_app_img_menu_save_image, c.a.o0.e.e.swan_app_img_menu_share_image, c.a.o0.e.e.swan_app_img_menu_set_wallpaper};
            if (y.a(context, "android.permission.SET_WALLPAPER")) {
                return iArr;
            }
            int[] iArr2 = new int[3];
            System.arraycopy(iArr, 0, iArr2, 0, 3);
            return iArr2;
        }
        return (int[]) invokeL.objValue;
    }

    public void i(@NonNull String str, @Nullable String str2, @Nullable String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, str, str2, str3) == null) {
            c.a.o0.a.j2.p.e eVar = new c.a.o0.a.j2.p.e();
            eVar.f7035a = "tool";
            eVar.f7040f = c.a.o0.a.a2.d.g().getAppId();
            eVar.f7037c = "miniapp";
            eVar.f7041g = "text";
            eVar.f7036b = str;
            eVar.f7039e = str2;
            if (!TextUtils.isEmpty(str3)) {
                eVar.a("query", str3);
            }
            c.a.o0.a.j2.k.u("810", eVar);
        }
    }
}
