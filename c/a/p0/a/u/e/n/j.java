package c.a.p0.a.u.e.n;

import android.annotation.SuppressLint;
import android.util.Pair;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import c.a.p0.a.z2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.view.SwanAppActionBar;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class j extends c.a.p0.a.u.e.n.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f8412e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8413f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ j f8414g;

        public a(j jVar, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, Integer.valueOf(i2), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8414g = jVar;
            this.f8412e = i2;
            this.f8413f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                View b2 = c.a.p0.a.c2.b.a.b();
                LinearLayout d2 = c.a.p0.a.c2.b.a.d();
                int i2 = this.f8412e;
                if (i2 == -90) {
                    if (b2 != null) {
                        b2.setVisibility(8);
                    }
                    if (d2 != null) {
                        d2.setVisibility(8);
                    }
                    c.a.p0.a.c2.b.a.g();
                    c.a.p0.a.c2.b.a.m(true);
                    j.D(8);
                } else if (i2 == 0) {
                    if (d2 != null) {
                        d2.setVisibility(8);
                    }
                    j.C();
                } else if (i2 != 90) {
                    c.a.p0.a.c2.b.a.o();
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
                    c.a.p0.a.c2.b.a.g();
                    c.a.p0.a.c2.b.a.m(true);
                    j.D(0);
                }
                l.e().u(this.f8412e);
                this.f8414g.d(this.f8413f, new c.a.p0.a.u.h.b(0));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(@NonNull c.a.p0.a.u.c.b bVar) {
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
                super((c.a.p0.a.u.c.b) newInitContext.callArgs[0]);
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
            SwanAppActivity activity = c.a.p0.a.g1.f.U().getActivity();
            if (c.a.p0.a.z2.f.d(activity)) {
                activity.setRequestedOrientation(1);
            }
            c.a.p0.a.h0.g.f H = c.a.p0.a.g1.f.U().H();
            if (H != null) {
                H.S3(true);
                H.q2();
            }
        }
    }

    public static void D(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, null, i2) == null) {
            if (c.a.p0.a.g1.f.U().H() != null) {
                c.a.p0.a.g1.f.U().H().S3(false);
            }
            SwanAppActivity activity = c.a.p0.a.g1.f.U().getActivity();
            if (c.a.p0.a.z2.f.d(activity)) {
                activity.setRequestedOrientation(i2);
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
            SwanAppActivity activity = c.a.p0.a.g1.f.U().getActivity();
            c.a.p0.a.h0.g.f H = c.a.p0.a.g1.f.U().H();
            if (c.a.p0.a.z2.f.d(activity)) {
                activity.setRequestedOrientation(1);
            }
            if (!c.a.p0.a.c2.b.a.i(c.a.p0.a.c2.b.a.e(activity))) {
                c.a.p0.a.c2.b.a.m(false);
            }
            if (activity.getWindow() != null) {
                activity.getWindow().clearFlags(1024);
                activity.getWindow().clearFlags(2048);
            }
            if (H != null) {
                H.S3(false);
                H.q2();
                c.a.p0.a.a3.d.b J1 = H.J1();
                if (J1 != null) {
                    int i2 = J1.d().f4253b;
                    View b2 = c.a.p0.a.c2.b.a.b();
                    if (b2 != null) {
                        b2.findViewById(c.a.p0.a.f.ai_apps_title_bar).setBackgroundColor(i2);
                    }
                }
                SwanAppActionBar L1 = H.L1();
                L1.setActionBarFrontColor(L1.getCenterTitleView().getCurrentTextColor(), false);
            }
        }
    }

    public final void A(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
            q0.a0(new a(this, i2, str));
        }
    }

    public final int B(boolean z, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)})) == null) {
            if (z) {
                return i2;
            }
            return -1;
        }
        return invokeCommon.intValue;
    }

    public c.a.p0.a.u.h.b F(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#setFullScreen", false);
            Pair<c.a.p0.a.u.h.b, JSONObject> s = s(str);
            c.a.p0.a.u.h.b bVar = (c.a.p0.a.u.h.b) s.first;
            if (bVar.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                A(B(jSONObject.optBoolean("fullScreen"), jSONObject.optInt("direction")), jSONObject.optString("cb"));
                return c.a.p0.a.u.h.b.f();
            }
            return bVar;
        }
        return (c.a.p0.a.u.h.b) invokeL.objValue;
    }

    @Override // c.a.p0.a.u.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "RequestFullScreenApi" : (String) invokeV.objValue;
    }
}
