package c.a.n0.j.c0;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import c.a.n0.a.p2.q0;
import c.a.n0.a.s1.b.b.h;
import c.a.n0.a.t1.d;
import c.a.n0.a.t1.e;
import c.a.n0.a.v0.e.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f8669b;
    public transient /* synthetic */ FieldHolder $fh;
    public h a;

    /* renamed from: c.a.n0.j.c0.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0699a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppActivity a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f8670b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.o.b.a f8671c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.v0.e.b f8672d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f8673e;

        public RunnableC0699a(a aVar, SwanAppActivity swanAppActivity, String str, c.a.n0.a.o.b.a aVar2, c.a.n0.a.v0.e.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, swanAppActivity, str, aVar2, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8673e = aVar;
            this.a = swanAppActivity;
            this.f8670b = str;
            this.f8671c = aVar2;
            this.f8672d = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8673e.f(this.a, this.f8670b, this.f8671c, this.f8672d);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.a.o.b.a a;

        public b(a aVar, c.a.n0.a.o.b.a aVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, aVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                c.a.n0.j.n0.c.call(this.a, true, new c.a.n0.j.c0.c(false));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.a.o.b.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.v0.e.b f8674b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f8675c;

        public c(a aVar, c.a.n0.a.o.b.a aVar2, c.a.n0.a.v0.e.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, aVar2, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8675c = aVar;
            this.a = aVar2;
            this.f8674b = bVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                c.a.n0.j.n0.c.call(this.a, true, new c.a.n0.j.c0.c(true));
                this.f8675c.e(this.f8674b);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(605014928, "Lc/a/n0/j/c0/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(605014928, "Lc/a/n0/j/c0/a;");
                return;
            }
        }
        f8669b = c.a.n0.a.a.a;
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

    public final void c(c.a.n0.a.o.b.a aVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, aVar, str) == null) {
            c.a.n0.j.d.c.b bVar = new c.a.n0.j.d.c.b();
            bVar.errMsg = str;
            c.a.n0.j.n0.c.call(aVar, false, bVar);
        }
    }

    public void d(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jsObject) == null) {
            c.a.n0.a.o.b.a F = c.a.n0.a.o.b.a.F(jsObject);
            if (F == null) {
                F = new c.a.n0.a.o.b.a();
            }
            c.a.n0.a.o.b.a aVar = F;
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
                B = x.getString(R.string.obfuscated_res_0x7f0f0177);
            }
            q0.e0(new RunnableC0699a(this, x, B, aVar, V));
        }
    }

    public final void e(@NonNull c.a.n0.a.v0.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            String H = bVar.H();
            String h1 = c.a.n0.a.v0.e.c.h1(bVar.H(), bVar.T(), bVar.G());
            Bundle bundle = new Bundle();
            bundle.putString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, H);
            bundle.putString("scheme", h1);
            bundle.putInt("target", SwanAppProcessInfo.current().index);
            if (f8669b) {
                Log.d("SwanGameReloadApi", "reload-appid:" + bVar.H());
            }
            c.a.n0.a.o1.c.e.a.P().V(bundle, c.a.n0.j.c0.b.class);
        }
    }

    public final void f(@NonNull Activity activity, @NonNull String str, @NonNull c.a.n0.a.o.b.a aVar, @NonNull c.a.n0.a.v0.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, activity, str, aVar, bVar) == null) {
            h hVar = this.a;
            if (hVar != null && hVar.isShowing()) {
                c(aVar, "reload failed, the reload dialog has been displayed.");
                return;
            }
            h.a aVar2 = new h.a(activity);
            aVar2.U(R.string.obfuscated_res_0x7f0f0178);
            aVar2.x(str);
            aVar2.a();
            aVar2.n(new c.a.n0.a.q2.h.a());
            aVar2.m(false);
            aVar2.B(R.string.obfuscated_res_0x7f0f0107, new b(this, aVar));
            aVar2.O(R.string.obfuscated_res_0x7f0f0197, new c(this, aVar, bVar));
            this.a = aVar2.X();
        }
    }
}
