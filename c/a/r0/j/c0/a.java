package c.a.r0.j.c0;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.r0.a.d2.d;
import c.a.r0.a.d2.e;
import c.a.r0.a.f1.e.b;
import c.a.r0.a.k;
import c.a.r0.a.z2.q0;
import c.a.r0.h.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.res.widget.dialog.SwanAppAlertDialog;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f11051b;
    public transient /* synthetic */ FieldHolder $fh;
    public SwanAppAlertDialog a;

    /* renamed from: c.a.r0.j.c0.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class RunnableC0749a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f11052e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f11053f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.y.b.a f11054g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.f1.e.b f11055h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a f11056i;

        public RunnableC0749a(a aVar, SwanAppActivity swanAppActivity, String str, c.a.r0.a.y.b.a aVar2, c.a.r0.a.f1.e.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, swanAppActivity, str, aVar2, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11056i = aVar;
            this.f11052e = swanAppActivity;
            this.f11053f = str;
            this.f11054g = aVar2;
            this.f11055h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f11056i.f(this.f11052e, this.f11053f, this.f11054g, this.f11055h);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.y.b.a f11057e;

        public b(a aVar, c.a.r0.a.y.b.a aVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, aVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11057e = aVar2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                c.a.r0.j.n0.c.call(this.f11057e, true, new c.a.r0.j.c0.c(false));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.y.b.a f11058e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.f1.e.b f11059f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f11060g;

        public c(a aVar, c.a.r0.a.y.b.a aVar2, c.a.r0.a.f1.e.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, aVar2, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11060g = aVar;
            this.f11058e = aVar2;
            this.f11059f = bVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                c.a.r0.j.n0.c.call(this.f11058e, true, new c.a.r0.j.c0.c(true));
                this.f11060g.e(this.f11059f);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-181039092, "Lc/a/r0/j/c0/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-181039092, "Lc/a/r0/j/c0/a;");
                return;
            }
        }
        f11051b = k.a;
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

    public final void c(c.a.r0.a.y.b.a aVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, aVar, str) == null) {
            c.a.r0.j.d.c.b bVar = new c.a.r0.j.d.c.b();
            bVar.errMsg = str;
            c.a.r0.j.n0.c.call(aVar, false, bVar);
        }
    }

    public void d(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jsObject) == null) {
            c.a.r0.a.y.b.a F = c.a.r0.a.y.b.a.F(jsObject);
            if (F == null) {
                F = new c.a.r0.a.y.b.a();
            }
            c.a.r0.a.y.b.a aVar = F;
            e r = d.J().r();
            if (!r.H()) {
                c(aVar, "reload failed, api internal error.");
                return;
            }
            SwanAppActivity x = r.x();
            b.a V = r.V();
            if (x == null) {
                c(aVar, "reload failed, api internal error.");
                return;
            }
            String B = aVar.B("content");
            if (TextUtils.isEmpty(B)) {
                B = x.getString(g.aiapps_game_reload_dialog_content);
            }
            q0.e0(new RunnableC0749a(this, x, B, aVar, V));
        }
    }

    public final void e(@NonNull c.a.r0.a.f1.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            String H = bVar.H();
            String h1 = c.a.r0.a.f1.e.c.h1(bVar.H(), bVar.T(), bVar.G());
            Bundle bundle = new Bundle();
            bundle.putString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, H);
            bundle.putString("scheme", h1);
            bundle.putInt("target", SwanAppProcessInfo.current().index);
            if (f11051b) {
                String str = "reload-appid:" + bVar.H();
            }
            c.a.r0.a.y1.c.e.a.P().V(bundle, c.a.r0.j.c0.b.class);
        }
    }

    public final void f(@NonNull Activity activity, @NonNull String str, @NonNull c.a.r0.a.y.b.a aVar, @NonNull c.a.r0.a.f1.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, activity, str, aVar, bVar) == null) {
            SwanAppAlertDialog swanAppAlertDialog = this.a;
            if (swanAppAlertDialog != null && swanAppAlertDialog.isShowing()) {
                c(aVar, "reload failed, the reload dialog has been displayed.");
                return;
            }
            SwanAppAlertDialog.a aVar2 = new SwanAppAlertDialog.a(activity);
            aVar2.U(g.aiapps_game_reload_dialog_title);
            aVar2.x(str);
            aVar2.a();
            aVar2.n(new c.a.r0.a.a3.h.a());
            aVar2.m(false);
            aVar2.B(g.aiapps_cancel, new b(this, aVar));
            aVar2.O(g.aiapps_ok, new c(this, aVar, bVar));
            this.a = aVar2.X();
        }
    }
}
