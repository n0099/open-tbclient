package b.a.p0.h.b0;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import b.a.p0.a.a2.d;
import b.a.p0.a.a2.e;
import b.a.p0.a.f1.e.b;
import b.a.p0.a.k;
import b.a.p0.a.v2.q0;
import b.a.p0.f.g;
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
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f10226b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SwanAppAlertDialog f10227a;

    /* renamed from: b.a.p0.h.b0.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC0552a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f10228e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f10229f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.y.b.a f10230g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.f1.e.b f10231h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a f10232i;

        public RunnableC0552a(a aVar, SwanAppActivity swanAppActivity, String str, b.a.p0.a.y.b.a aVar2, b.a.p0.a.f1.e.b bVar) {
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
            this.f10232i = aVar;
            this.f10228e = swanAppActivity;
            this.f10229f = str;
            this.f10230g = aVar2;
            this.f10231h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f10232i.f(this.f10228e, this.f10229f, this.f10230g, this.f10231h);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.y.b.a f10233e;

        public b(a aVar, b.a.p0.a.y.b.a aVar2) {
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
            this.f10233e = aVar2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                b.a.p0.h.m0.c.call(this.f10233e, true, new b.a.p0.h.b0.c(false));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.y.b.a f10234e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.f1.e.b f10235f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f10236g;

        public c(a aVar, b.a.p0.a.y.b.a aVar2, b.a.p0.a.f1.e.b bVar) {
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
            this.f10236g = aVar;
            this.f10234e = aVar2;
            this.f10235f = bVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                b.a.p0.h.m0.c.call(this.f10234e, true, new b.a.p0.h.b0.c(true));
                this.f10236g.e(this.f10235f);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1058384340, "Lb/a/p0/h/b0/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1058384340, "Lb/a/p0/h/b0/a;");
                return;
            }
        }
        f10226b = k.f6397a;
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

    public final void c(b.a.p0.a.y.b.a aVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, aVar, str) == null) {
            b.a.p0.h.d.c.b bVar = new b.a.p0.h.d.c.b();
            bVar.errMsg = str;
            b.a.p0.h.m0.c.call(aVar, false, bVar);
        }
    }

    public void d(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jsObject) == null) {
            b.a.p0.a.y.b.a F = b.a.p0.a.y.b.a.F(jsObject);
            if (F == null) {
                F = new b.a.p0.a.y.b.a();
            }
            b.a.p0.a.y.b.a aVar = F;
            e r = d.g().r();
            if (!r.e()) {
                c(aVar, "reload failed, api internal error.");
                return;
            }
            SwanAppActivity x = r.x();
            b.a K = r.K();
            if (x == null) {
                c(aVar, "reload failed, api internal error.");
                return;
            }
            String B = aVar.B("content");
            if (TextUtils.isEmpty(B)) {
                B = x.getString(g.aiapps_game_reload_dialog_content);
            }
            q0.b0(new RunnableC0552a(this, x, B, aVar, K));
        }
    }

    public final void e(@NonNull b.a.p0.a.f1.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            String G = bVar.G();
            String d1 = b.a.p0.a.f1.e.c.d1(bVar.G(), bVar.S(), bVar.F());
            Bundle bundle = new Bundle();
            bundle.putString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, G);
            bundle.putString("scheme", d1);
            bundle.putInt("target", SwanAppProcessInfo.current().index);
            if (f10226b) {
                String str = "reload-appid:" + bVar.G();
            }
            b.a.p0.a.v1.c.e.a.E().K(bundle, b.a.p0.h.b0.b.class);
        }
    }

    public final void f(@NonNull Activity activity, @NonNull String str, @NonNull b.a.p0.a.y.b.a aVar, @NonNull b.a.p0.a.f1.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, activity, str, aVar, bVar) == null) {
            SwanAppAlertDialog swanAppAlertDialog = this.f10227a;
            if (swanAppAlertDialog != null && swanAppAlertDialog.isShowing()) {
                c(aVar, "reload failed, the reload dialog has been displayed.");
                return;
            }
            SwanAppAlertDialog.a aVar2 = new SwanAppAlertDialog.a(activity);
            aVar2.U(g.aiapps_game_reload_dialog_title);
            aVar2.x(str);
            aVar2.a();
            aVar2.n(new b.a.p0.a.w2.h.a());
            aVar2.m(false);
            aVar2.B(g.aiapps_cancel, new b(this, aVar));
            aVar2.O(g.aiapps_ok, new c(this, aVar, bVar));
            this.f10227a = aVar2.X();
        }
    }
}
