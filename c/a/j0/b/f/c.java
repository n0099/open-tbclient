package c.a.j0.b.f;

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
public class c implements c.a.n0.a.h.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.n0.a.h.b a;

    /* renamed from: b  reason: collision with root package name */
    public String f4273b;

    /* renamed from: c  reason: collision with root package name */
    public final Context f4274c;

    /* renamed from: d  reason: collision with root package name */
    public final c.a.j0.b.c f4275d;

    /* renamed from: e  reason: collision with root package name */
    public b.InterfaceC0009b f4276e;

    /* renamed from: f  reason: collision with root package name */
    public int f4277f;

    /* renamed from: g  reason: collision with root package name */
    public int f4278g;

    /* renamed from: h  reason: collision with root package name */
    public g f4279h;

    /* renamed from: i  reason: collision with root package name */
    public final c.a.j0.b.b f4280i;

    /* loaded from: classes.dex */
    public class a implements c.a.j0.b.b {
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

        @Override // c.a.j0.b.b
        public void a(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                if (this.a.f4276e != null) {
                    this.a.f4276e.onFailed();
                } else if (this.a.f4275d != null) {
                    this.a.f4275d.c(th == null ? "unKnow" : th.getMessage());
                }
            }
        }

        @Override // c.a.j0.b.b
        public void b(@NonNull g gVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar) == null) || c.a.b.f().i()) {
                return;
            }
            int e2 = e.e(gVar);
            if (e2 == 0) {
                this.a.f4279h = gVar;
                c.a.n0.a.h.b a = new c.a.n0.a.a().a(this.a.f4274c, d.a(gVar));
                if (a == null) {
                    return;
                }
                this.a.a = a;
                if (this.a.f4275d != null) {
                    c.a.j0.b.d dVar = new c.a.j0.b.d(a, this.a.f4275d.g(), gVar);
                    dVar.l(this.a.f4275d);
                    a.c(dVar);
                    a.a(dVar);
                    dVar.k(this.a);
                    this.a.i(!gVar.i());
                    this.a.l(!gVar.g());
                    this.a.f4275d.e(this.a);
                }
                if (this.a.f4276e != null) {
                    this.a.f4276e.onSuccess();
                    return;
                }
                return;
            }
            if (this.a.f4276e != null) {
                this.a.f4276e.onFailed();
            } else if (this.a.f4275d != null) {
                c.a.j0.b.c cVar = this.a.f4275d;
                cVar.c("query 后物料效验失败: " + e2);
            }
            BaseVM.h(e2);
        }
    }

    public c(Context context, String str, c.a.n0.a.c cVar, c.a.j0.b.c cVar2) {
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
        this.f4280i = new a(this);
        this.f4274c = context;
        this.f4273b = str;
        this.f4275d = cVar2;
    }

    @Override // c.a.n0.a.h.d
    public JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (this.f4279h != null) {
                    jSONObject.put("source", this.f4279h.D);
                    jSONObject.put(QuickPersistConfigConst.KEY_SPLASH_SORT, this.f4279h.E);
                }
                jSONObject.put(TiebaStatic.Params.AD_TYPE, this.f4277f);
                jSONObject.put("full_type", this.f4278g);
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
                new c.a.j0.b.a().j(this.f4273b, this.f4280i);
            }
        }
    }

    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f4277f = i2;
        }
    }

    public void j(c.a.n0.a.h.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.a = bVar;
        }
    }

    public void k(g gVar) {
        c.a.n0.a.b a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, gVar) == null) {
            if (gVar != null) {
                this.f4279h = gVar;
                c.a.n0.a.h.b a3 = new c.a.n0.a.a().a(this.f4274c, d.a(gVar));
                if (a3 == null) {
                    if (c.a.j0.a.b.a.a.get().a()) {
                        String str = "创建 AdContainer 失败，params: " + a2.a();
                        return;
                    }
                    return;
                }
                this.a = a3;
                c.a.j0.b.c cVar = this.f4275d;
                if (cVar != null) {
                    c.a.j0.b.d dVar = new c.a.j0.b.d(a3, cVar.g(), gVar);
                    dVar.l(this.f4275d);
                    a3.c(dVar);
                    a3.a(dVar);
                    dVar.k(this);
                    i(!gVar.i());
                    l(!gVar.g());
                    this.f4275d.e(this);
                }
                b.InterfaceC0009b interfaceC0009b = this.f4276e;
                if (interfaceC0009b != null) {
                    interfaceC0009b.onSuccess();
                    return;
                }
                return;
            }
            b.InterfaceC0009b interfaceC0009b2 = this.f4276e;
            if (interfaceC0009b2 != null) {
                interfaceC0009b2.onFailed();
                return;
            }
            c.a.j0.b.c cVar2 = this.f4275d;
            if (cVar2 != null) {
                cVar2.c("本地物料null");
            }
        }
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f4278g = i2;
        }
    }

    public void m(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, viewGroup) == null) {
            c.a.n0.a.h.b bVar = this.a;
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
