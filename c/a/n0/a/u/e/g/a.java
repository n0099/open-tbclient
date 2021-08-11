package c.a.n0.a.u.e.g;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import c.a.n0.a.v2.n0;
import c.a.n0.a.v2.q0;
import c.a.n0.a.z1.b.c.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.res.widget.loadingview.LoadingView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends c.a.n0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.n0.a.u.e.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0382a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.z1.b.c.a f8557e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f8558f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f8559g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ boolean f8560h;

        public RunnableC0382a(a aVar, c.a.n0.a.z1.b.c.a aVar2, Context context, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, aVar2, context, str, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8557e = aVar2;
            this.f8558f = context;
            this.f8559g = str;
            this.f8560h = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            LoadingView loadingView;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                View e2 = this.f8557e.e();
                if (e2 instanceof LoadingView) {
                    loadingView = (LoadingView) e2;
                } else {
                    loadingView = new LoadingView(this.f8558f);
                    FrameLayout frameLayout = new FrameLayout(this.f8558f);
                    frameLayout.setPadding(0, 0, 0, n0.g(160.0f));
                    frameLayout.addView(loadingView);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 17;
                    this.f8557e.l(frameLayout, layoutParams);
                }
                if (!TextUtils.isEmpty(this.f8559g)) {
                    loadingView.setMsg(this.f8559g);
                }
                this.f8557e.i(this.f8560h);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.h0.g.d f8561e;

        public b(a aVar, c.a.n0.a.h0.g.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8561e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.a.n0.a.z1.b.c.a floatLayer;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (floatLayer = ((a.InterfaceC0473a) this.f8561e).getFloatLayer()) != null && (floatLayer.e() instanceof FrameLayout) && (((FrameLayout) floatLayer.e()).getChildAt(0) instanceof LoadingView)) {
                floatLayer.g();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull c.a.n0.a.u.c.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((c.a.n0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void r(@NonNull c.a.n0.a.z1.b.c.a aVar, @NonNull Context context, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{aVar, context, str, Boolean.valueOf(z)}) == null) {
            q0.b0(new RunnableC0382a(this, aVar, context, str, z));
        }
    }

    public c.a.n0.a.u.h.b s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Context i2 = i();
            if (!(i2 instanceof SwanAppActivity)) {
                if (c.a.n0.a.u.c.d.f8453c) {
                    c.a.n0.a.e0.d.b("Api-LoadingView", "context not support");
                }
                return new c.a.n0.a.u.h.b(1001, "context not support");
            }
            c.a.n0.a.h0.g.g swanAppFragmentManager = ((SwanAppActivity) i2).getSwanAppFragmentManager();
            if (swanAppFragmentManager == null) {
                if (c.a.n0.a.u.c.d.f8453c) {
                    c.a.n0.a.e0.d.b("Api-LoadingView", "none fragmentManger");
                }
                return new c.a.n0.a.u.h.b(1001, "none fragmentManger");
            }
            c.a.n0.a.h0.g.d m = swanAppFragmentManager.m();
            if (!(m instanceof a.InterfaceC0473a)) {
                if (c.a.n0.a.u.c.d.f8453c) {
                    c.a.n0.a.e0.d.b("Api-LoadingView", "fragment not support");
                }
                return new c.a.n0.a.u.h.b(1001, "fragment not support");
            } else if (m.q() == null) {
                if (c.a.n0.a.u.c.d.f8453c) {
                    c.a.n0.a.e0.d.b("Api-LoadingView", "fragment has detached");
                }
                return new c.a.n0.a.u.h.b(1001, "fragment has detached");
            } else {
                q0.b0(new b(this, m));
                c.a.n0.a.e0.d.g("Api-LoadingView", "hide loading success");
                return new c.a.n0.a.u.h.b(0);
            }
        }
        return (c.a.n0.a.u.h.b) invokeV.objValue;
    }

    public c.a.n0.a.u.h.b t(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            boolean z = c.a.n0.a.u.c.d.f8453c;
            if (l()) {
                c.a.n0.a.e0.d.b("Api-LoadingView", "Api-LoadingView does not supported when app is invisible.");
                return new c.a.n0.a.u.h.b(1001, "Api-LoadingView does not supported when app is invisible.");
            }
            Pair<c.a.n0.a.u.h.b, JSONObject> b2 = c.a.n0.a.u.i.b.b("Api-LoadingView", str);
            c.a.n0.a.u.h.b bVar = (c.a.n0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                if (c.a.n0.a.u.c.d.f8453c) {
                    c.a.n0.a.e0.d.b("Api-LoadingView", "parse fail");
                }
                return bVar;
            }
            JSONObject jSONObject = (JSONObject) b2.second;
            c.a.n0.a.e0.d.g("Api-LoadingView", "handleShowLoading : joParams = \n" + jSONObject);
            String optString = jSONObject.optString("title");
            if (TextUtils.isEmpty(optString)) {
                if (c.a.n0.a.u.c.d.f8453c) {
                    c.a.n0.a.e0.d.b("Api-LoadingView", "none title");
                }
                return new c.a.n0.a.u.h.b(202, "none title");
            }
            boolean optBoolean = jSONObject.optBoolean("mask", false);
            Context i2 = i();
            if (!(i2 instanceof SwanAppActivity)) {
                if (c.a.n0.a.u.c.d.f8453c) {
                    c.a.n0.a.e0.d.b("Api-LoadingView", "context not support");
                }
                return new c.a.n0.a.u.h.b(1001, "context not support");
            }
            c.a.n0.a.h0.g.g swanAppFragmentManager = ((SwanAppActivity) i2).getSwanAppFragmentManager();
            if (swanAppFragmentManager == null) {
                if (c.a.n0.a.u.c.d.f8453c) {
                    c.a.n0.a.e0.d.b("Api-LoadingView", "none fragment");
                }
                return new c.a.n0.a.u.h.b(1001, "none fragment");
            }
            c.a.n0.a.h0.g.d m = swanAppFragmentManager.m();
            if (!(m instanceof a.InterfaceC0473a)) {
                if (c.a.n0.a.u.c.d.f8453c) {
                    c.a.n0.a.e0.d.b("Api-LoadingView", "fragment not support");
                }
                return new c.a.n0.a.u.h.b(1001, "fragment not support");
            }
            c.a.n0.a.z1.b.c.a floatLayer = ((a.InterfaceC0473a) m).getFloatLayer();
            if (floatLayer == null) {
                if (c.a.n0.a.u.c.d.f8453c) {
                    c.a.n0.a.e0.d.b("Api-LoadingView", "can't get floatLayer");
                }
                return new c.a.n0.a.u.h.b(1001, "can't get floatLayer");
            }
            r(floatLayer, i2, optString, optBoolean);
            c.a.n0.a.e0.d.g("Api-LoadingView", "show loading success");
            return new c.a.n0.a.u.h.b(0);
        }
        return (c.a.n0.a.u.h.b) invokeL.objValue;
    }
}
