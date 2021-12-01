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
    public String f3323b;

    /* renamed from: c  reason: collision with root package name */
    public final Context f3324c;

    /* renamed from: d  reason: collision with root package name */
    public final c.a.g0.b.c f3325d;

    /* renamed from: e  reason: collision with root package name */
    public b.InterfaceC0015b f3326e;

    /* renamed from: f  reason: collision with root package name */
    public int f3327f;

    /* renamed from: g  reason: collision with root package name */
    public int f3328g;

    /* renamed from: h  reason: collision with root package name */
    public g f3329h;

    /* renamed from: i  reason: collision with root package name */
    public final c.a.g0.b.b f3330i;

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
                if (this.a.f3326e != null) {
                    this.a.f3326e.onFailed();
                } else if (this.a.f3325d != null) {
                    this.a.f3325d.c(th == null ? "unKnow" : th.getMessage());
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
                this.a.f3329h = gVar;
                c.a.k0.a.h.b a = new c.a.k0.a.a().a(this.a.f3324c, d.a(gVar));
                if (a == null) {
                    return;
                }
                this.a.a = a;
                if (this.a.f3325d != null) {
                    c.a.g0.b.d dVar = new c.a.g0.b.d(a, this.a.f3325d.f(), gVar);
                    dVar.l(this.a.f3325d);
                    a.c(dVar);
                    a.a(dVar);
                    dVar.k(this.a);
                    this.a.i(!gVar.i());
                    this.a.l(!gVar.g());
                    this.a.f3325d.e(this.a);
                }
                if (this.a.f3326e != null) {
                    this.a.f3326e.onSuccess();
                    return;
                }
                return;
            }
            if (this.a.f3326e != null) {
                this.a.f3326e.onFailed();
            } else if (this.a.f3325d != null) {
                c.a.g0.b.c cVar = this.a.f3325d;
                cVar.c("query 后物料效验失败: " + e2);
            }
            BaseVM.g(e2);
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
        this.f3330i = new a(this);
        this.f3324c = context;
        this.f3323b = str;
        this.f3325d = cVar2;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a == null) {
            return;
        }
        this.a = null;
    }

    public JSONObject g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (this.f3329h != null) {
                    jSONObject.put("source", this.f3329h.D);
                    jSONObject.put(QuickPersistConfigConst.KEY_SPLASH_SORT, this.f3329h.E);
                }
                jSONObject.put(TiebaStatic.Params.AD_TYPE, this.f3327f);
                jSONObject.put("full_type", this.f3328g);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (!c.a.b.f().h()) {
                k(e.l());
            } else {
                new c.a.g0.b.a().k(this.f3323b, this.f3330i);
            }
        }
    }

    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f3327f = i2;
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
                this.f3329h = gVar;
                c.a.k0.a.h.b a3 = new c.a.k0.a.a().a(this.f3324c, d.a(gVar));
                if (a3 == null) {
                    if (c.a.g0.a.b.a.a.get().a()) {
                        String str = "创建 AdContainer 失败，params: " + a2.a();
                        return;
                    }
                    return;
                }
                this.a = a3;
                c.a.g0.b.c cVar = this.f3325d;
                if (cVar != null) {
                    c.a.g0.b.d dVar = new c.a.g0.b.d(a3, cVar.f(), gVar);
                    dVar.l(this.f3325d);
                    a3.c(dVar);
                    a3.a(dVar);
                    dVar.k(this);
                    i(!gVar.i());
                    l(!gVar.g());
                    this.f3325d.e(this);
                }
                b.InterfaceC0015b interfaceC0015b = this.f3326e;
                if (interfaceC0015b != null) {
                    interfaceC0015b.onSuccess();
                    return;
                }
                return;
            }
            b.InterfaceC0015b interfaceC0015b2 = this.f3326e;
            if (interfaceC0015b2 != null) {
                interfaceC0015b2.onFailed();
                return;
            }
            c.a.g0.b.c cVar2 = this.f3325d;
            if (cVar2 != null) {
                cVar2.c("本地物料null");
            }
        }
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f3328g = i2;
        }
    }

    public void m(ViewGroup viewGroup) {
        c.a.k0.a.h.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, viewGroup) == null) {
            if (viewGroup != null && (bVar = this.a) != null) {
                bVar.load();
                View adView = this.a.getAdView();
                if (adView != null && adView.getParent() == null) {
                    viewGroup.addView(adView);
                    return;
                } else {
                    f();
                    return;
                }
            }
            f();
        }
    }
}
