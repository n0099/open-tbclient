package c.a.n0.h.b0;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.n0.a.a2.d;
import c.a.n0.a.a2.e;
import c.a.n0.a.f1.e.b;
import c.a.n0.a.k;
import c.a.n0.a.v2.q0;
import c.a.n0.f.g;
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
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f10741b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SwanAppAlertDialog f10742a;

    /* renamed from: c.a.n0.h.b0.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0547a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f10743e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f10744f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.y.b.a f10745g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.f1.e.b f10746h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a f10747i;

        public RunnableC0547a(a aVar, SwanAppActivity swanAppActivity, String str, c.a.n0.a.y.b.a aVar2, c.a.n0.a.f1.e.b bVar) {
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
            this.f10747i = aVar;
            this.f10743e = swanAppActivity;
            this.f10744f = str;
            this.f10745g = aVar2;
            this.f10746h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f10747i.f(this.f10743e, this.f10744f, this.f10745g, this.f10746h);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.y.b.a f10748e;

        public b(a aVar, c.a.n0.a.y.b.a aVar2) {
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
            this.f10748e = aVar2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                c.a.n0.h.m0.c.a(this.f10748e, true, new c.a.n0.h.b0.c(false));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.y.b.a f10749e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.f1.e.b f10750f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f10751g;

        public c(a aVar, c.a.n0.a.y.b.a aVar2, c.a.n0.a.f1.e.b bVar) {
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
            this.f10751g = aVar;
            this.f10749e = aVar2;
            this.f10750f = bVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                c.a.n0.h.m0.c.a(this.f10749e, true, new c.a.n0.h.b0.c(true));
                this.f10751g.e(this.f10750f);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1170915955, "Lc/a/n0/h/b0/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1170915955, "Lc/a/n0/h/b0/a;");
                return;
            }
        }
        f10741b = k.f6803a;
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

    public final void c(c.a.n0.a.y.b.a aVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, aVar, str) == null) {
            c.a.n0.h.d.c.b bVar = new c.a.n0.h.d.c.b();
            bVar.errMsg = str;
            c.a.n0.h.m0.c.a(aVar, false, bVar);
        }
    }

    public void d(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jsObject) == null) {
            c.a.n0.a.y.b.a G = c.a.n0.a.y.b.a.G(jsObject);
            if (G == null) {
                G = new c.a.n0.a.y.b.a();
            }
            c.a.n0.a.y.b.a aVar = G;
            e r = d.g().r();
            if (!r.e()) {
                c(aVar, "reload failed, api internal error.");
                return;
            }
            SwanAppActivity x = r.x();
            b.a L = r.L();
            if (x == null) {
                c(aVar, "reload failed, api internal error.");
                return;
            }
            String C = aVar.C("content");
            if (TextUtils.isEmpty(C)) {
                C = x.getString(g.aiapps_game_reload_dialog_content);
            }
            q0.b0(new RunnableC0547a(this, x, C, aVar, L));
        }
    }

    public final void e(@NonNull c.a.n0.a.f1.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            String H = bVar.H();
            String e1 = c.a.n0.a.f1.e.c.e1(bVar.H(), bVar.T(), bVar.G());
            Bundle bundle = new Bundle();
            bundle.putString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, H);
            bundle.putString("scheme", e1);
            bundle.putInt("target", SwanAppProcessInfo.current().index);
            if (f10741b) {
                String str = "reload-appid:" + bVar.H();
            }
            c.a.n0.a.v1.c.e.a.E().K(bundle, c.a.n0.h.b0.b.class);
        }
    }

    public final void f(@NonNull Activity activity, @NonNull String str, @NonNull c.a.n0.a.y.b.a aVar, @NonNull c.a.n0.a.f1.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, activity, str, aVar, bVar) == null) {
            SwanAppAlertDialog swanAppAlertDialog = this.f10742a;
            if (swanAppAlertDialog != null && swanAppAlertDialog.isShowing()) {
                c(aVar, "reload failed, the reload dialog has been displayed.");
                return;
            }
            SwanAppAlertDialog.a aVar2 = new SwanAppAlertDialog.a(activity);
            aVar2.U(g.aiapps_game_reload_dialog_title);
            aVar2.x(str);
            aVar2.a();
            aVar2.n(new c.a.n0.a.w2.h.a());
            aVar2.m(false);
            aVar2.B(g.aiapps_cancel, new b(this, aVar));
            aVar2.O(g.aiapps_ok, new c(this, aVar, bVar));
            this.f10742a = aVar2.X();
        }
    }
}
