package c.a.n0.a.k.e.n;

import android.annotation.SuppressLint;
import android.util.Pair;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import c.a.n0.a.p2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.view.SwanAppActionBar;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class j extends c.a.n0.a.k.e.n.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f5233b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ j f5234c;

        public a(j jVar, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, Integer.valueOf(i), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5234c = jVar;
            this.a = i;
            this.f5233b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                View b2 = c.a.n0.a.s1.b.a.b();
                LinearLayout d2 = c.a.n0.a.s1.b.a.d();
                int i = this.a;
                if (i == -90) {
                    if (b2 != null) {
                        b2.setVisibility(8);
                    }
                    if (d2 != null) {
                        d2.setVisibility(8);
                    }
                    c.a.n0.a.s1.b.a.g();
                    c.a.n0.a.s1.b.a.m(true);
                    j.D(8);
                } else if (i == 0) {
                    if (d2 != null) {
                        d2.setVisibility(8);
                    }
                    j.C();
                } else if (i != 90) {
                    c.a.n0.a.s1.b.a.o();
                    if (b2 != null) {
                        b2.setVisibility(0);
                    }
                    if (d2 != null) {
                        d2.setVisibility(0);
                    }
                    j.E();
                } else {
                    if (b2 != null) {
                        b2.setVisibility(8);
                    }
                    if (d2 != null) {
                        d2.setVisibility(8);
                    }
                    c.a.n0.a.s1.b.a.g();
                    c.a.n0.a.s1.b.a.m(true);
                    j.D(0);
                }
                l.e().u(this.a);
                this.f5234c.d(this.f5233b, new c.a.n0.a.k.h.b(0));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(@NonNull c.a.n0.a.k.c.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((c.a.n0.a.k.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    public static void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            SwanAppActivity activity = c.a.n0.a.w0.f.U().getActivity();
            if (c.a.n0.a.p2.f.d(activity)) {
                activity.setRequestedOrientation(1);
            }
            c.a.n0.a.x.g.f H = c.a.n0.a.w0.f.U().H();
            if (H != null) {
                H.P3(true);
                H.n2();
            }
        }
    }

    public static void D(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, null, i) == null) {
            if (c.a.n0.a.w0.f.U().H() != null) {
                c.a.n0.a.w0.f.U().H().P3(false);
            }
            SwanAppActivity activity = c.a.n0.a.w0.f.U().getActivity();
            if (c.a.n0.a.p2.f.d(activity)) {
                activity.setRequestedOrientation(i);
            }
            if (activity.getWindow() != null) {
                activity.getWindow().clearFlags(2048);
                activity.getWindow().setFlags(1024, 1024);
            }
        }
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    public static void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            SwanAppActivity activity = c.a.n0.a.w0.f.U().getActivity();
            c.a.n0.a.x.g.f H = c.a.n0.a.w0.f.U().H();
            if (c.a.n0.a.p2.f.d(activity)) {
                activity.setRequestedOrientation(1);
            }
            if (!c.a.n0.a.s1.b.a.i(c.a.n0.a.s1.b.a.e(activity))) {
                c.a.n0.a.s1.b.a.m(false);
            }
            if (activity.getWindow() != null) {
                activity.getWindow().clearFlags(1024);
                activity.getWindow().clearFlags(2048);
            }
            if (H != null) {
                H.P3(false);
                H.n2();
                c.a.n0.a.q2.d.b G1 = H.G1();
                if (G1 != null) {
                    int i = G1.d().f6001b;
                    View b2 = c.a.n0.a.s1.b.a.b();
                    if (b2 != null) {
                        b2.findViewById(R.id.obfuscated_res_0x7f09017e).setBackgroundColor(i);
                    }
                }
                SwanAppActionBar I1 = H.I1();
                I1.f(I1.getCenterTitleView().getCurrentTextColor(), false);
            }
        }
    }

    public final void A(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
            q0.a0(new a(this, i, str));
        }
    }

    public final int B(boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            if (z) {
                return i;
            }
            return -1;
        }
        return invokeCommon.intValue;
    }

    public c.a.n0.a.k.h.b F(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#setFullScreen", false);
            Pair<c.a.n0.a.k.h.b, JSONObject> s = s(str);
            c.a.n0.a.k.h.b bVar = (c.a.n0.a.k.h.b) s.first;
            if (bVar.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                A(B(jSONObject.optBoolean("fullScreen"), jSONObject.optInt("direction")), jSONObject.optString("cb"));
                return c.a.n0.a.k.h.b.f();
            }
            return bVar;
        }
        return (c.a.n0.a.k.h.b) invokeL.objValue;
    }

    @Override // c.a.n0.a.k.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "RequestFullScreenApi" : (String) invokeV.objValue;
    }
}
