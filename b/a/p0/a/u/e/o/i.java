package b.a.p0.a.u.e.o;

import android.util.Pair;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.v2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class i extends b.a.p0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f8355e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8356f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ i f8357g;

        public a(i iVar, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, Integer.valueOf(i2), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8357g = iVar;
            this.f8355e = i2;
            this.f8356f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                View b2 = b.a.p0.a.z1.b.a.b();
                LinearLayout c2 = b.a.p0.a.z1.b.a.c();
                int i2 = this.f8355e;
                if (i2 == -90) {
                    if (b2 != null) {
                        b2.setVisibility(8);
                    }
                    if (c2 != null) {
                        c2.setVisibility(8);
                    }
                    b.a.p0.a.z1.b.a.f();
                    b.a.p0.a.z1.b.a.k(true);
                    i.u(8);
                } else if (i2 != 90) {
                    b.a.p0.a.z1.b.a.m();
                    if (b2 != null) {
                        b2.setVisibility(0);
                    }
                    if (c2 != null) {
                        c2.setVisibility(0);
                    }
                    i.v();
                } else {
                    if (b2 != null) {
                        b2.setVisibility(8);
                    }
                    if (c2 != null) {
                        c2.setVisibility(8);
                    }
                    b.a.p0.a.z1.b.a.f();
                    b.a.p0.a.z1.b.a.k(true);
                    i.u(0);
                }
                k.e().t(this.f8355e);
                this.f8357g.d(this.f8356f, new b.a.p0.a.u.h.b(0));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(@NonNull b.a.p0.a.u.c.b bVar) {
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

    public static void u(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65539, null, i2) == null) {
            SwanAppActivity activity = b.a.p0.a.g1.f.T().getActivity();
            activity.setRequestedOrientation(i2);
            activity.getWindow().setFlags(1024, 1024);
        }
    }

    public static void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            SwanAppActivity activity = b.a.p0.a.g1.f.T().getActivity();
            activity.setRequestedOrientation(1);
            if (!b.a.p0.a.z1.b.a.g(b.a.p0.a.z1.b.a.d(activity))) {
                b.a.p0.a.z1.b.a.k(false);
            }
            if (activity.getWindow() != null) {
                activity.getWindow().clearFlags(1024);
            }
            if (b.a.p0.a.g1.f.T().H() != null) {
                b.a.p0.a.g1.f.T().H().c2();
            }
        }
    }

    public final void s(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
            q0.X(new a(this, i2, str));
        }
    }

    public final int t(boolean z, int i2) {
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

    public b.a.p0.a.u.h.b w(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            boolean z = b.a.p0.a.u.c.d.f8000c;
            Pair<b.a.p0.a.u.h.b, JSONObject> b2 = b.a.p0.a.u.i.b.b("Api-FullScreenApi", str);
            b.a.p0.a.u.h.b bVar = (b.a.p0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                if (b.a.p0.a.u.c.d.f8000c) {
                    b.a.p0.a.e0.d.b("Api-FullScreenApi", "parse fail");
                }
                return bVar;
            }
            JSONObject jSONObject = (JSONObject) b2.second;
            s(t(jSONObject.optBoolean("fullScreen"), jSONObject.optInt("direction")), jSONObject.optString("cb"));
            return new b.a.p0.a.u.h.b(0);
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }
}
