package c.a.f0.b.f;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import c.a.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.prologue.business.data.BaseVM;
import com.baidu.sdk.container.interfaces.LoadState;
import com.baidu.searchbox.config.QuickPersistConfigConst;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c implements c.a.i0.a.h.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.i0.a.h.b a;

    /* renamed from: b  reason: collision with root package name */
    public String f2916b;

    /* renamed from: c  reason: collision with root package name */
    public final Context f2917c;

    /* renamed from: d  reason: collision with root package name */
    public final c.a.f0.b.c f2918d;

    /* renamed from: e  reason: collision with root package name */
    public b.InterfaceC0083b f2919e;

    /* renamed from: f  reason: collision with root package name */
    public int f2920f;

    /* renamed from: g  reason: collision with root package name */
    public int f2921g;

    /* renamed from: h  reason: collision with root package name */
    public g f2922h;
    public int i;
    public final c.a.f0.b.b j;

    /* loaded from: classes.dex */
    public class a implements c.a.f0.b.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // c.a.f0.b.b
        public void a(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                if (this.a.f2919e != null) {
                    this.a.f2919e.onFailed();
                } else if (this.a.f2918d != null) {
                    this.a.f2918d.c(th == null ? "unKnow" : th.getMessage());
                }
            }
        }

        @Override // c.a.f0.b.b
        public void b(@NonNull g gVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar) == null) || c.a.b.f().i()) {
                return;
            }
            int f2 = e.f(gVar, this.a.i);
            if (f2 == 0) {
                this.a.f2922h = gVar;
                c.a.i0.a.h.b a = new c.a.i0.a.a().a(this.a.f2917c, d.a(gVar));
                if (a == null) {
                    return;
                }
                this.a.a = a;
                if (this.a.f2918d != null) {
                    c.a.f0.b.d dVar = new c.a.f0.b.d(a, this.a.f2918d.h(), gVar);
                    dVar.l(this.a.f2918d);
                    a.c(dVar);
                    a.a(dVar);
                    dVar.k(this.a);
                    this.a.i(!gVar.i());
                    this.a.l(!gVar.g());
                    this.a.f2918d.f(this.a);
                }
                if (this.a.f2919e != null) {
                    this.a.f2919e.onSuccess();
                    return;
                }
                return;
            }
            if (this.a.f2919e != null) {
                this.a.f2919e.onFailed();
            } else if (this.a.f2918d != null) {
                c.a.f0.b.c cVar = this.a.f2918d;
                cVar.c("query 后物料效验失败: " + f2);
            }
            BaseVM.h(f2);
        }
    }

    public c(Context context, String str, c.a.i0.a.c cVar, c.a.f0.b.c cVar2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, cVar, cVar2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        LoadState loadState = LoadState.INIT;
        this.i = 0;
        this.j = new a(this);
        this.f2917c = context;
        this.f2916b = str;
        this.f2918d = cVar2;
        if (cVar == null || cVar.a() == null || !cVar.a().containsKey("launch_type")) {
            return;
        }
        try {
            this.i = Integer.parseInt(cVar.a().get("launch_type"));
        } catch (NumberFormatException unused) {
            this.i = 0;
        }
    }

    @Override // c.a.i0.a.h.d
    public JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (this.f2922h != null) {
                    jSONObject.put("source", this.f2922h.D);
                    jSONObject.put(QuickPersistConfigConst.KEY_SPLASH_SORT, this.f2922h.E);
                }
                jSONObject.put(TiebaStatic.Params.AD_TYPE, this.f2920f);
                jSONObject.put("full_type", this.f2921g);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a == null) {
            return;
        }
        this.a = null;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (!c.a.b.f().h()) {
                k(e.n(this.i));
            } else {
                new c.a.f0.b.a().j(this.f2916b, this.j);
            }
        }
    }

    public void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.f2920f = i;
        }
    }

    public void j(c.a.i0.a.h.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.a = bVar;
        }
    }

    public void k(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, gVar) == null) {
            if (gVar != null) {
                this.f2922h = gVar;
                c.a.i0.a.b a2 = d.a(gVar);
                c.a.i0.a.h.b a3 = new c.a.i0.a.a().a(this.f2917c, a2);
                if (a3 == null) {
                    if (c.a.f0.a.b.a.a.get().a()) {
                        Log.e("PrologueAd", "创建 AdContainer 失败，params: " + a2.a());
                        return;
                    }
                    return;
                }
                this.a = a3;
                c.a.f0.b.c cVar = this.f2918d;
                if (cVar != null) {
                    c.a.f0.b.d dVar = new c.a.f0.b.d(a3, cVar.h(), gVar);
                    dVar.l(this.f2918d);
                    a3.c(dVar);
                    a3.a(dVar);
                    dVar.k(this);
                    i(!gVar.i());
                    l(!gVar.g());
                    this.f2918d.f(this);
                }
                b.InterfaceC0083b interfaceC0083b = this.f2919e;
                if (interfaceC0083b != null) {
                    interfaceC0083b.onSuccess();
                    return;
                }
                return;
            }
            b.InterfaceC0083b interfaceC0083b2 = this.f2919e;
            if (interfaceC0083b2 != null) {
                interfaceC0083b2.onFailed();
                return;
            }
            c.a.f0.b.c cVar2 = this.f2918d;
            if (cVar2 != null) {
                cVar2.c("本地物料null");
            }
        }
    }

    public void l(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.f2921g = i;
        }
    }

    public void m(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, viewGroup) == null) {
            c.a.i0.a.h.b bVar = this.a;
            if (viewGroup != null && bVar != null) {
                bVar.load();
                View adView = bVar.getAdView();
                if (adView != null && adView.getParent() == null) {
                    viewGroup.addView(adView);
                    return;
                } else {
                    g();
                    return;
                }
            }
            g();
        }
    }
}
