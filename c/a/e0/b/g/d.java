package c.a.e0.b.g;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import c.a.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.sdk.container.interfaces.LoadState;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d implements c.a.h0.a.g.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.a.h0.a.g.b f3095a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f3096b;

    /* renamed from: c  reason: collision with root package name */
    public final c.a.e0.b.d f3097c;

    /* renamed from: d  reason: collision with root package name */
    public b.InterfaceC0018b f3098d;

    /* renamed from: e  reason: collision with root package name */
    public int f3099e;

    /* renamed from: f  reason: collision with root package name */
    public int f3100f;

    /* renamed from: g  reason: collision with root package name */
    public final c.a.e0.b.c f3101g;

    /* loaded from: classes.dex */
    public class a implements c.a.e0.b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f3102a;

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
            this.f3102a = dVar;
        }

        @Override // c.a.e0.b.c
        public void a(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                if (c.a.e0.a.b.a.f3041a.get().s()) {
                    String str = "onAdFailed: " + th.getMessage();
                }
                if (this.f3102a.f3098d != null) {
                    this.f3102a.f3098d.onFailed();
                } else if (this.f3102a.f3097c != null) {
                    this.f3102a.f3097c.a(th == null ? "unKnow" : th.getMessage());
                }
            }
        }

        @Override // c.a.e0.b.c
        public void b(@NonNull h hVar) {
            c.a.h0.a.b a2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hVar) == null) || c.a.b.f().h()) {
                return;
            }
            int e2 = f.e(hVar);
            if (c.a.e0.a.b.a.f3041a.get().s()) {
                String str = "onAdSuccess, statusCode: " + e2;
            }
            if (e2 == 0) {
                c.a.h0.a.g.b a3 = new c.a.h0.a.a().a(this.f3102a.f3096b, e.a(hVar));
                if (a3 != null) {
                    this.f3102a.f3095a = a3;
                    if (this.f3102a.f3097c != null) {
                        c.a.e0.b.e eVar = new c.a.e0.b.e(a3, this.f3102a.f3097c.d(), hVar);
                        eVar.d(this.f3102a.f3097c);
                        a3.d(eVar);
                        a3.b(eVar);
                        eVar.c(this.f3102a);
                        this.f3102a.h(!hVar.g());
                        this.f3102a.j(!hVar.f());
                        this.f3102a.f3097c.c(this.f3102a);
                    }
                    if (this.f3102a.f3098d != null) {
                        this.f3102a.f3098d.onSuccess();
                        return;
                    }
                    return;
                } else if (c.a.e0.a.b.a.f3041a.get().s()) {
                    String str2 = "创建 AdContainer 失败，params: " + a2.a();
                    return;
                } else {
                    return;
                }
            }
            c.a.e0.a.b.a.f3041a.get().s();
            if (this.f3102a.f3098d != null) {
                this.f3102a.f3098d.onFailed();
            } else if (this.f3102a.f3097c != null) {
                this.f3102a.f3097c.a("query 后物料效验失败: " + e2);
            }
            b.f(e2);
        }
    }

    public d(Context context, String str, RequestParameters requestParameters, c.a.e0.b.d dVar) {
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
        this.f3101g = new a(this);
        this.f3096b = context;
        this.f3097c = dVar;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f3095a == null) {
            return;
        }
        this.f3095a = null;
    }

    public JSONObject f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("place_id", c.a.e0.a.b.a.f3041a.get().l());
                jSONObject.put("source", "gd");
                jSONObject.put(TiebaStatic.Params.AD_TYPE, this.f3099e);
                jSONObject.put("full_type", this.f3100f);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            new c.a.e0.b.a().j(c.a.e0.a.b.a.f3041a.get(), this.f3101g);
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f3099e = i2;
        }
    }

    public void i(c.a.h0.a.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.f3095a = bVar;
        }
    }

    public void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f3100f = i2;
        }
    }

    public void k(ViewGroup viewGroup) {
        c.a.h0.a.g.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, viewGroup) == null) {
            if (viewGroup != null && (bVar = this.f3095a) != null) {
                bVar.a();
                View adView = this.f3095a.getAdView();
                if (adView != null && adView.getParent() == null) {
                    viewGroup.addView(adView);
                    return;
                } else {
                    e();
                    return;
                }
            }
            e();
        }
    }
}
