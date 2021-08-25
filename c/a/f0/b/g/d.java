package c.a.f0.b.g;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import c.a.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.api.RequestParameters;
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
public class d implements c.a.i0.a.g.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.a.i0.a.g.b f3402a;

    /* renamed from: b  reason: collision with root package name */
    public String f3403b;

    /* renamed from: c  reason: collision with root package name */
    public final Context f3404c;

    /* renamed from: d  reason: collision with root package name */
    public final c.a.f0.b.d f3405d;

    /* renamed from: e  reason: collision with root package name */
    public b.InterfaceC0020b f3406e;

    /* renamed from: f  reason: collision with root package name */
    public int f3407f;

    /* renamed from: g  reason: collision with root package name */
    public int f3408g;

    /* renamed from: h  reason: collision with root package name */
    public h f3409h;

    /* renamed from: i  reason: collision with root package name */
    public final c.a.f0.b.c f3410i;

    /* loaded from: classes.dex */
    public class a implements c.a.f0.b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f3411a;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3411a = dVar;
        }

        @Override // c.a.f0.b.c
        public void a(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                if (c.a.f0.a.b.a.f3346a.get().t()) {
                    String str = "onAdFailed: " + th.getMessage();
                }
                if (this.f3411a.f3406e != null) {
                    this.f3411a.f3406e.onFailed();
                } else if (this.f3411a.f3405d != null) {
                    this.f3411a.f3405d.a(th == null ? "unKnow" : th.getMessage());
                }
            }
        }

        @Override // c.a.f0.b.c
        public void b(@NonNull h hVar) {
            c.a.i0.a.b a2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hVar) == null) || c.a.b.f().h()) {
                return;
            }
            int e2 = f.e(hVar);
            if (c.a.f0.a.b.a.f3346a.get().t()) {
                String str = "onAdSuccess, statusCode: " + e2;
            }
            if (e2 == 0) {
                this.f3411a.f3409h = hVar;
                c.a.i0.a.g.b a3 = new c.a.i0.a.a().a(this.f3411a.f3404c, e.a(hVar));
                if (a3 != null) {
                    this.f3411a.f3402a = a3;
                    if (this.f3411a.f3405d != null) {
                        c.a.f0.b.e eVar = new c.a.f0.b.e(a3, this.f3411a.f3405d.d(), hVar);
                        eVar.d(this.f3411a.f3405d);
                        a3.d(eVar);
                        a3.b(eVar);
                        eVar.c(this.f3411a);
                        this.f3411a.i(!hVar.i());
                        this.f3411a.k(!hVar.g());
                        this.f3411a.f3405d.c(this.f3411a);
                    }
                    if (this.f3411a.f3406e != null) {
                        this.f3411a.f3406e.onSuccess();
                        return;
                    }
                    return;
                } else if (c.a.f0.a.b.a.f3346a.get().t()) {
                    String str2 = "创建 AdContainer 失败，params: " + a2.a();
                    return;
                } else {
                    return;
                }
            }
            c.a.f0.a.b.a.f3346a.get().t();
            if (this.f3411a.f3406e != null) {
                this.f3411a.f3406e.onFailed();
            } else if (this.f3411a.f3405d != null) {
                this.f3411a.f3405d.a("query 后物料效验失败: " + e2);
            }
            b.f(e2);
        }
    }

    public d(Context context, String str, RequestParameters requestParameters, c.a.f0.b.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, requestParameters, dVar};
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
        this.f3410i = new a(this);
        this.f3404c = context;
        this.f3403b = str;
        this.f3405d = dVar;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f3402a == null) {
            return;
        }
        this.f3402a = null;
    }

    public JSONObject g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (this.f3409h != null) {
                    jSONObject.put("source", this.f3409h.D);
                    jSONObject.put(QuickPersistConfigConst.KEY_SPLASH_SORT, this.f3409h.E);
                }
                jSONObject.put(TiebaStatic.Params.AD_TYPE, this.f3407f);
                jSONObject.put("full_type", this.f3408g);
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
            new c.a.f0.b.a().j(c.a.f0.a.b.a.f3346a.get(), this.f3403b, this.f3410i);
        }
    }

    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f3407f = i2;
        }
    }

    public void j(c.a.i0.a.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.f3402a = bVar;
        }
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f3408g = i2;
        }
    }

    public void l(ViewGroup viewGroup) {
        c.a.i0.a.g.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, viewGroup) == null) {
            if (viewGroup != null && (bVar = this.f3402a) != null) {
                bVar.a();
                View adView = this.f3402a.getAdView();
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
