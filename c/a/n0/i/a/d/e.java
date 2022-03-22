package c.a.n0.i.a.d;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.p2.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e extends c.a.n0.a.o1.a.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public String f8512f;

    /* renamed from: g  reason: collision with root package name */
    public String f8513g;

    /* renamed from: h  reason: collision with root package name */
    public JSONObject f8514h;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f8515b;

        public a(e eVar, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8515b = eVar;
            this.a = jSONObject;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // java.lang.Runnable
        public void run() {
            char c2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.i.a.a.n().G(this.f8515b.f8514h);
                String str = this.f8515b.f8512f;
                switch (str.hashCode()) {
                    case -1261560102:
                        if (str.equals("queryStatus")) {
                            c2 = 1;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -625158317:
                        if (str.equals("deleteDownload")) {
                            c2 = 5;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -606050596:
                        if (str.equals("resumeAllDownload")) {
                            c2 = 6;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -534830837:
                        if (str.equals("queryAllStatus")) {
                            c2 = 2;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -451216226:
                        if (str.equals("pauseDownload")) {
                            c2 = 3;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -417021581:
                        if (str.equals("pauseAllDownload")) {
                            c2 = 7;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 184711125:
                        if (str.equals("resumeDownload")) {
                            c2 = 4;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1554935562:
                        if (str.equals("startDownload")) {
                            c2 = 0;
                            break;
                        }
                        c2 = 65535;
                        break;
                    default:
                        c2 = 65535;
                        break;
                }
                switch (c2) {
                    case 0:
                        this.f8515b.w(this.a);
                        return;
                    case 1:
                        this.f8515b.t(this.a);
                        return;
                    case 2:
                        this.f8515b.s();
                        return;
                    case 3:
                        this.f8515b.r(this.a);
                        return;
                    case 4:
                        this.f8515b.v(this.a);
                        return;
                    case 5:
                        this.f8515b.p(this.a);
                        return;
                    case 6:
                        this.f8515b.u();
                        return;
                    case 7:
                        this.f8515b.q();
                        return;
                    default:
                        this.f8515b.setResult(new c.a.n0.i.a.g.a(31009, "invalid operation"));
                        return;
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements c.a.n0.i.a.f.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        public b(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // c.a.n0.i.a.f.b
        public void a(c.a.n0.i.a.g.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                this.a.setResult(bVar);
            }
        }
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResult(c.a.n0.i.a.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, bVar) == null) {
            this.f5585d.clear();
            if (bVar != null) {
                this.f5585d.putString("functionType", bVar.a());
                this.f5585d.putString("resultData", bVar.b());
                this.f5585d.putInt("resultStatus", bVar.c());
                if (bVar.d()) {
                    if (!TextUtils.equals(this.f8512f, "startDownload")) {
                        c.a.n0.i.a.i.c.a(this.f8513g, this.f8512f, "success", null, new c.a.n0.i.a.i.a(this.f8514h));
                    }
                } else {
                    c.a.n0.i.a.i.c.a(this.f8513g, this.f8512f, com.baidu.pass.biometrics.face.liveness.b.a.g0, String.valueOf(bVar.c()), new c.a.n0.i.a.i.a(this.f8514h));
                }
            }
            c();
        }
    }

    @Override // c.a.n0.a.o1.a.a.a
    public void b(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            this.f8512f = bundle.getString("operation", "");
            this.f8514h = w.d(bundle.getString("ubc_params", ""));
            JSONObject d2 = w.d(bundle.getString("data", ""));
            this.f8513g = d2.optString("packageName");
            c.a.n0.i.a.c.b.f8496d.execute(new a(this, d2));
        }
    }

    public final void p(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
            c.a.n0.i.a.a.n().m(jSONObject, new b(this));
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.n0.i.a.a.n().u();
        }
    }

    public final void r(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jSONObject) == null) {
            c.a.n0.i.a.a.n().v(jSONObject, new b(this));
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            c.a.n0.i.a.a.n().w(new b(this));
        }
    }

    public final void t(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jSONObject) == null) {
            c.a.n0.i.a.a.n().x(jSONObject, new b(this));
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            c.a.n0.i.a.a.n().D();
        }
    }

    public final void v(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, jSONObject) == null) {
            c.a.n0.i.a.a.n().E(jSONObject, new b(this));
        }
    }

    public final void w(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject) == null) {
            c.a.n0.i.a.a.n().H(jSONObject.optString("url"), jSONObject.optString("packageName"), jSONObject.optString("apkId"), new b(this));
        }
    }
}
