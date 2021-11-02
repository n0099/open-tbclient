package b.a.p0.a.u.e.g;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import b.a.p0.a.v2.n0;
import b.a.p0.a.v2.q0;
import b.a.p0.a.z1.b.c.a;
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
public class a extends b.a.p0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b.a.p0.a.u.e.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0387a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.z1.b.c.a f8101e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f8102f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f8103g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ boolean f8104h;

        public RunnableC0387a(a aVar, b.a.p0.a.z1.b.c.a aVar2, Context context, String str, boolean z) {
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
            this.f8101e = aVar2;
            this.f8102f = context;
            this.f8103g = str;
            this.f8104h = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            LoadingView loadingView;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                View d2 = this.f8101e.d();
                if (d2 instanceof LoadingView) {
                    loadingView = (LoadingView) d2;
                } else {
                    loadingView = new LoadingView(this.f8102f);
                    FrameLayout frameLayout = new FrameLayout(this.f8102f);
                    frameLayout.setPadding(0, 0, 0, n0.g(160.0f));
                    frameLayout.addView(loadingView);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 17;
                    this.f8101e.k(frameLayout, layoutParams);
                }
                if (!TextUtils.isEmpty(this.f8103g)) {
                    loadingView.setMsg(this.f8103g);
                }
                this.f8101e.h(this.f8104h);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.h0.g.d f8105e;

        public b(a aVar, b.a.p0.a.h0.g.d dVar) {
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
            this.f8105e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.a.p0.a.z1.b.c.a floatLayer;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (floatLayer = ((a.InterfaceC0478a) this.f8105e).getFloatLayer()) != null && (floatLayer.d() instanceof FrameLayout) && (((FrameLayout) floatLayer.d()).getChildAt(0) instanceof LoadingView)) {
                floatLayer.f();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull b.a.p0.a.u.c.b bVar) {
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
                super((b.a.p0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void q(@NonNull b.a.p0.a.z1.b.c.a aVar, @NonNull Context context, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{aVar, context, str, Boolean.valueOf(z)}) == null) {
            q0.b0(new RunnableC0387a(this, aVar, context, str, z));
        }
    }

    public b.a.p0.a.u.h.b r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Context context = getContext();
            if (!(context instanceof SwanAppActivity)) {
                if (b.a.p0.a.u.c.d.f8000c) {
                    b.a.p0.a.e0.d.b("Api-LoadingView", "context not support");
                }
                return new b.a.p0.a.u.h.b(1001, "context not support");
            }
            b.a.p0.a.h0.g.g swanAppFragmentManager = ((SwanAppActivity) context).getSwanAppFragmentManager();
            if (swanAppFragmentManager == null) {
                if (b.a.p0.a.u.c.d.f8000c) {
                    b.a.p0.a.e0.d.b("Api-LoadingView", "none fragmentManger");
                }
                return new b.a.p0.a.u.h.b(1001, "none fragmentManger");
            }
            b.a.p0.a.h0.g.d m = swanAppFragmentManager.m();
            if (!(m instanceof a.InterfaceC0478a)) {
                if (b.a.p0.a.u.c.d.f8000c) {
                    b.a.p0.a.e0.d.b("Api-LoadingView", "fragment not support");
                }
                return new b.a.p0.a.u.h.b(1001, "fragment not support");
            } else if (m.getContext() == null) {
                if (b.a.p0.a.u.c.d.f8000c) {
                    b.a.p0.a.e0.d.b("Api-LoadingView", "fragment has detached");
                }
                return new b.a.p0.a.u.h.b(1001, "fragment has detached");
            } else {
                q0.b0(new b(this, m));
                b.a.p0.a.e0.d.g("Api-LoadingView", "hide loading success");
                return new b.a.p0.a.u.h.b(0);
            }
        }
        return (b.a.p0.a.u.h.b) invokeV.objValue;
    }

    public b.a.p0.a.u.h.b s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            boolean z = b.a.p0.a.u.c.d.f8000c;
            if (k()) {
                b.a.p0.a.e0.d.b("Api-LoadingView", "Api-LoadingView does not supported when app is invisible.");
                return new b.a.p0.a.u.h.b(1001, "Api-LoadingView does not supported when app is invisible.");
            }
            Pair<b.a.p0.a.u.h.b, JSONObject> b2 = b.a.p0.a.u.i.b.b("Api-LoadingView", str);
            b.a.p0.a.u.h.b bVar = (b.a.p0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                if (b.a.p0.a.u.c.d.f8000c) {
                    b.a.p0.a.e0.d.b("Api-LoadingView", "parse fail");
                }
                return bVar;
            }
            JSONObject jSONObject = (JSONObject) b2.second;
            b.a.p0.a.e0.d.g("Api-LoadingView", "handleShowLoading : joParams = \n" + jSONObject);
            String optString = jSONObject.optString("title");
            if (TextUtils.isEmpty(optString)) {
                if (b.a.p0.a.u.c.d.f8000c) {
                    b.a.p0.a.e0.d.b("Api-LoadingView", "none title");
                }
                return new b.a.p0.a.u.h.b(202, "none title");
            }
            boolean optBoolean = jSONObject.optBoolean("mask", false);
            Context context = getContext();
            if (!(context instanceof SwanAppActivity)) {
                if (b.a.p0.a.u.c.d.f8000c) {
                    b.a.p0.a.e0.d.b("Api-LoadingView", "context not support");
                }
                return new b.a.p0.a.u.h.b(1001, "context not support");
            }
            b.a.p0.a.h0.g.g swanAppFragmentManager = ((SwanAppActivity) context).getSwanAppFragmentManager();
            if (swanAppFragmentManager == null) {
                if (b.a.p0.a.u.c.d.f8000c) {
                    b.a.p0.a.e0.d.b("Api-LoadingView", "none fragment");
                }
                return new b.a.p0.a.u.h.b(1001, "none fragment");
            }
            b.a.p0.a.h0.g.d m = swanAppFragmentManager.m();
            if (!(m instanceof a.InterfaceC0478a)) {
                if (b.a.p0.a.u.c.d.f8000c) {
                    b.a.p0.a.e0.d.b("Api-LoadingView", "fragment not support");
                }
                return new b.a.p0.a.u.h.b(1001, "fragment not support");
            }
            b.a.p0.a.z1.b.c.a floatLayer = ((a.InterfaceC0478a) m).getFloatLayer();
            if (floatLayer == null) {
                if (b.a.p0.a.u.c.d.f8000c) {
                    b.a.p0.a.e0.d.b("Api-LoadingView", "can't get floatLayer");
                }
                return new b.a.p0.a.u.h.b(1001, "can't get floatLayer");
            }
            q(floatLayer, context, optString, optBoolean);
            b.a.p0.a.e0.d.g("Api-LoadingView", "show loading success");
            return new b.a.p0.a.u.h.b(0);
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }
}
