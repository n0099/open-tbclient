package b.a.p0.g.c.d;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.v2.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.gamecenter.appmanager.download.AppDownloadNetworkStateReceiver;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class e extends b.a.p0.a.v1.a.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public String f10091f;

    /* renamed from: g  reason: collision with root package name */
    public String f10092g;

    /* renamed from: h  reason: collision with root package name */
    public JSONObject f10093h;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONObject f10094e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f10095f;

        public a(e eVar, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10095f = eVar;
            this.f10094e = jSONObject;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // java.lang.Runnable
        public void run() {
            char c2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.g.c.a.n().G(this.f10095f.f10093h);
                String str = this.f10095f.f10091f;
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
                        this.f10095f.w(this.f10094e);
                        return;
                    case 1:
                        this.f10095f.t(this.f10094e);
                        return;
                    case 2:
                        this.f10095f.s();
                        return;
                    case 3:
                        this.f10095f.r(this.f10094e);
                        return;
                    case 4:
                        this.f10095f.v(this.f10094e);
                        return;
                    case 5:
                        this.f10095f.p(this.f10094e);
                        return;
                    case 6:
                        this.f10095f.u();
                        return;
                    case 7:
                        this.f10095f.q();
                        return;
                    default:
                        this.f10095f.setResult(new b.a.p0.g.c.g.a(31009, "invalid operation"));
                        return;
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements b.a.p0.g.c.f.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f10096a;

        public b(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10096a = eVar;
        }

        @Override // b.a.p0.g.c.f.b
        public void a(b.a.p0.g.c.g.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                this.f10096a.setResult(bVar);
            }
        }
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResult(b.a.p0.g.c.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, bVar) == null) {
            this.f8460d.clear();
            if (bVar != null) {
                this.f8460d.putString("functionType", bVar.a());
                this.f8460d.putString("resultData", bVar.b());
                this.f8460d.putInt("resultStatus", bVar.c());
                if (bVar.d()) {
                    if (!TextUtils.equals(this.f10091f, "startDownload")) {
                        b.a.p0.g.c.i.c.a(this.f10092g, this.f10091f, "success", null, new b.a.p0.g.c.i.a(this.f10093h));
                    }
                } else {
                    b.a.p0.g.c.i.c.a(this.f10092g, this.f10091f, com.baidu.pass.biometrics.face.liveness.b.a.g0, String.valueOf(bVar.c()), new b.a.p0.g.c.i.a(this.f10093h));
                }
            }
            c();
        }
    }

    @Override // b.a.p0.a.v1.a.a.a
    public void b(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            this.f10091f = bundle.getString(AppDownloadNetworkStateReceiver.KEY_OPERATION, "");
            this.f10093h = w.d(bundle.getString("ubc_params", ""));
            JSONObject d2 = w.d(bundle.getString("data", ""));
            this.f10092g = d2.optString("packageName");
            b.a.p0.g.c.c.b.f10058d.execute(new a(this, d2));
        }
    }

    public final void p(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
            b.a.p0.g.c.a.n().m(jSONObject, new b(this));
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            b.a.p0.g.c.a.n().u();
        }
    }

    public final void r(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jSONObject) == null) {
            b.a.p0.g.c.a.n().v(jSONObject, new b(this));
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            b.a.p0.g.c.a.n().w(new b(this));
        }
    }

    public final void t(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jSONObject) == null) {
            b.a.p0.g.c.a.n().x(jSONObject, new b(this));
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            b.a.p0.g.c.a.n().D();
        }
    }

    public final void v(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, jSONObject) == null) {
            b.a.p0.g.c.a.n().E(jSONObject, new b(this));
        }
    }

    public final void w(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject) == null) {
            b.a.p0.g.c.a.n().H(jSONObject.optString("url"), jSONObject.optString("packageName"), jSONObject.optString("apkId"), new b(this));
        }
    }
}
