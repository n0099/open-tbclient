package b.a.f0.b.g;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import b.a.b;
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
public class d implements b.a.j0.a.g.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b.a.j0.a.g.b f2836a;

    /* renamed from: b  reason: collision with root package name */
    public String f2837b;

    /* renamed from: c  reason: collision with root package name */
    public final Context f2838c;

    /* renamed from: d  reason: collision with root package name */
    public final b.a.f0.b.d f2839d;

    /* renamed from: e  reason: collision with root package name */
    public b.InterfaceC0015b f2840e;

    /* renamed from: f  reason: collision with root package name */
    public int f2841f;

    /* renamed from: g  reason: collision with root package name */
    public int f2842g;

    /* renamed from: h  reason: collision with root package name */
    public h f2843h;

    /* renamed from: i  reason: collision with root package name */
    public final b.a.f0.b.c f2844i;

    /* loaded from: classes.dex */
    public class a implements b.a.f0.b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f2845a;

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
            this.f2845a = dVar;
        }

        @Override // b.a.f0.b.c
        public void a(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                if (b.a.f0.a.b.a.f2781a.get().s()) {
                    String str = "onAdFailed: " + th.getMessage();
                }
                if (this.f2845a.f2840e != null) {
                    this.f2845a.f2840e.onFailed();
                } else if (this.f2845a.f2839d != null) {
                    this.f2845a.f2839d.b(th == null ? "unKnow" : th.getMessage());
                }
            }
        }

        @Override // b.a.f0.b.c
        public void b(@NonNull h hVar) {
            b.a.j0.a.b a2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hVar) == null) || b.a.b.f().h()) {
                return;
            }
            int e2 = f.e(hVar);
            if (b.a.f0.a.b.a.f2781a.get().s()) {
                String str = "onAdSuccess, statusCode: " + e2;
            }
            if (e2 == 0) {
                this.f2845a.f2843h = hVar;
                b.a.j0.a.g.b a3 = new b.a.j0.a.a().a(this.f2845a.f2838c, e.a(hVar));
                if (a3 != null) {
                    this.f2845a.f2836a = a3;
                    if (this.f2845a.f2839d != null) {
                        b.a.f0.b.e eVar = new b.a.f0.b.e(a3, this.f2845a.f2839d.e(), hVar);
                        eVar.d(this.f2845a.f2839d);
                        a3.d(eVar);
                        a3.b(eVar);
                        eVar.c(this.f2845a);
                        this.f2845a.i(!hVar.i());
                        this.f2845a.k(!hVar.g());
                        this.f2845a.f2839d.d(this.f2845a);
                    }
                    if (this.f2845a.f2840e != null) {
                        this.f2845a.f2840e.onSuccess();
                        return;
                    }
                    return;
                } else if (b.a.f0.a.b.a.f2781a.get().s()) {
                    String str2 = "创建 AdContainer 失败，params: " + a2.a();
                    return;
                } else {
                    return;
                }
            }
            b.a.f0.a.b.a.f2781a.get().s();
            if (this.f2845a.f2840e != null) {
                this.f2845a.f2840e.onFailed();
            } else if (this.f2845a.f2839d != null) {
                this.f2845a.f2839d.b("query 后物料效验失败: " + e2);
            }
            b.f(e2);
        }
    }

    public d(Context context, String str, RequestParameters requestParameters, b.a.f0.b.d dVar) {
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
        this.f2844i = new a(this);
        this.f2838c = context;
        this.f2837b = str;
        this.f2839d = dVar;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f2836a == null) {
            return;
        }
        this.f2836a = null;
    }

    public JSONObject g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (this.f2843h != null) {
                    jSONObject.put("source", this.f2843h.D);
                    jSONObject.put(QuickPersistConfigConst.KEY_SPLASH_SORT, this.f2843h.E);
                }
                jSONObject.put(TiebaStatic.Params.AD_TYPE, this.f2841f);
                jSONObject.put("full_type", this.f2842g);
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
            new b.a.f0.b.a().j(b.a.f0.a.b.a.f2781a.get(), this.f2837b, this.f2844i);
        }
    }

    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f2841f = i2;
        }
    }

    public void j(b.a.j0.a.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.f2836a = bVar;
        }
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f2842g = i2;
        }
    }

    public void l(ViewGroup viewGroup) {
        b.a.j0.a.g.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, viewGroup) == null) {
            if (viewGroup != null && (bVar = this.f2836a) != null) {
                bVar.a();
                View adView = this.f2836a.getAdView();
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
