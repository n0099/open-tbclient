package c.a.g0.b.f;

import android.content.Context;
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
public class c implements c.a.k0.a.h.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.k0.a.h.b a;

    /* renamed from: b  reason: collision with root package name */
    public String f3471b;

    /* renamed from: c  reason: collision with root package name */
    public final Context f3472c;

    /* renamed from: d  reason: collision with root package name */
    public final c.a.g0.b.c f3473d;

    /* renamed from: e  reason: collision with root package name */
    public b.InterfaceC0022b f3474e;

    /* renamed from: f  reason: collision with root package name */
    public int f3475f;

    /* renamed from: g  reason: collision with root package name */
    public int f3476g;

    /* renamed from: h  reason: collision with root package name */
    public g f3477h;

    /* renamed from: i  reason: collision with root package name */
    public final c.a.g0.b.b f3478i;

    /* loaded from: classes.dex */
    public class a implements c.a.g0.b.b {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // c.a.g0.b.b
        public void a(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                if (this.a.f3474e != null) {
                    this.a.f3474e.onFailed();
                } else if (this.a.f3473d != null) {
                    this.a.f3473d.c(th == null ? "unKnow" : th.getMessage());
                }
            }
        }

        @Override // c.a.g0.b.b
        public void b(@NonNull g gVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar) == null) || c.a.b.f().i()) {
                return;
            }
            int e2 = e.e(gVar);
            if (e2 == 0) {
                this.a.f3477h = gVar;
                c.a.k0.a.h.b a = new c.a.k0.a.a().a(this.a.f3472c, d.a(gVar));
                if (a == null) {
                    return;
                }
                this.a.a = a;
                if (this.a.f3473d != null) {
                    c.a.g0.b.d dVar = new c.a.g0.b.d(a, this.a.f3473d.g(), gVar);
                    dVar.l(this.a.f3473d);
                    a.c(dVar);
                    a.a(dVar);
                    dVar.k(this.a);
                    this.a.i(!gVar.i());
                    this.a.l(!gVar.g());
                    this.a.f3473d.e(this.a);
                }
                if (this.a.f3474e != null) {
                    this.a.f3474e.onSuccess();
                    return;
                }
                return;
            }
            if (this.a.f3474e != null) {
                this.a.f3474e.onFailed();
            } else if (this.a.f3473d != null) {
                c.a.g0.b.c cVar = this.a.f3473d;
                cVar.c("query 后物料效验失败: " + e2);
            }
            BaseVM.h(e2);
        }
    }

    public c(Context context, String str, c.a.k0.a.c cVar, c.a.g0.b.c cVar2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, cVar, cVar2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        LoadState loadState = LoadState.INIT;
        this.f3478i = new a(this);
        this.f3472c = context;
        this.f3471b = str;
        this.f3473d = cVar2;
    }

    @Override // c.a.k0.a.h.d
    public JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (this.f3477h != null) {
                    jSONObject.put("source", this.f3477h.D);
                    jSONObject.put(QuickPersistConfigConst.KEY_SPLASH_SORT, this.f3477h.E);
                }
                jSONObject.put(TiebaStatic.Params.AD_TYPE, this.f3475f);
                jSONObject.put("full_type", this.f3476g);
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
                k(e.l());
            } else {
                new c.a.g0.b.a().j(this.f3471b, this.f3478i);
            }
        }
    }

    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f3475f = i2;
        }
    }

    public void j(c.a.k0.a.h.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.a = bVar;
        }
    }

    public void k(g gVar) {
        c.a.k0.a.b a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, gVar) == null) {
            if (gVar != null) {
                this.f3477h = gVar;
                c.a.k0.a.h.b a3 = new c.a.k0.a.a().a(this.f3472c, d.a(gVar));
                if (a3 == null) {
                    if (c.a.g0.a.b.a.a.get().a()) {
                        String str = "创建 AdContainer 失败，params: " + a2.a();
                        return;
                    }
                    return;
                }
                this.a = a3;
                c.a.g0.b.c cVar = this.f3473d;
                if (cVar != null) {
                    c.a.g0.b.d dVar = new c.a.g0.b.d(a3, cVar.g(), gVar);
                    dVar.l(this.f3473d);
                    a3.c(dVar);
                    a3.a(dVar);
                    dVar.k(this);
                    i(!gVar.i());
                    l(!gVar.g());
                    this.f3473d.e(this);
                }
                b.InterfaceC0022b interfaceC0022b = this.f3474e;
                if (interfaceC0022b != null) {
                    interfaceC0022b.onSuccess();
                    return;
                }
                return;
            }
            b.InterfaceC0022b interfaceC0022b2 = this.f3474e;
            if (interfaceC0022b2 != null) {
                interfaceC0022b2.onFailed();
                return;
            }
            c.a.g0.b.c cVar2 = this.f3473d;
            if (cVar2 != null) {
                cVar2.c("本地物料null");
            }
        }
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f3476g = i2;
        }
    }

    public void m(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, viewGroup) == null) {
            c.a.k0.a.h.b bVar = this.a;
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
