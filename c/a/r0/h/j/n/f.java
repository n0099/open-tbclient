package c.a.r0.h.j.n;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.z2.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.swan.gamecenter.appmanager.download.AppDownloadNetworkStateReceiver;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class f extends c.a.r0.a.y1.a.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public String f10642f;

    /* renamed from: g  reason: collision with root package name */
    public JSONObject f10643g;

    /* renamed from: h  reason: collision with root package name */
    public i f10644h;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONObject f10645e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f10646f;

        public a(f fVar, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10646f = fVar;
            this.f10645e = jSONObject;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // java.lang.Runnable
        public void run() {
            char c2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                e.t().I(this.f10646f.f10643g);
                String str = this.f10646f.f10642f;
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
                            c2 = 4;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -451216226:
                        if (str.equals("pauseDownload")) {
                            c2 = 2;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -234424485:
                        if (str.equals("open_manual")) {
                            c2 = 7;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 184711125:
                        if (str.equals("resumeDownload")) {
                            c2 = 3;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 900412038:
                        if (str.equals("installApp")) {
                            c2 = 5;
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
                    case 1921860518:
                        if (str.equals("startDownloadFile")) {
                            c2 = '\b';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1944785703:
                        if (str.equals("checkPackageExpired")) {
                            c2 = 6;
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
                        this.f10646f.w(this.f10645e);
                        return;
                    case 1:
                        this.f10646f.u(this.f10645e);
                        return;
                    case 2:
                        this.f10646f.t(this.f10645e);
                        return;
                    case 3:
                        this.f10646f.v(this.f10645e);
                        return;
                    case 4:
                        this.f10646f.p(this.f10645e);
                        return;
                    case 5:
                        this.f10646f.q(this.f10645e);
                        return;
                    case 6:
                        this.f10646f.s(this.f10645e);
                        return;
                    case 7:
                        this.f10646f.r(this.f10645e);
                        return;
                    case '\b':
                        this.f10646f.x(this.f10645e);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public f() {
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

    @Override // c.a.r0.a.y1.a.a.a
    public void b(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            this.f10642f = bundle.getString(AppDownloadNetworkStateReceiver.KEY_OPERATION, "");
            this.f10643g = w.d(bundle.getString("ubc_params", ""));
            JSONObject d2 = w.d(bundle.getString("data", ""));
            if (this.f10644h == null) {
                this.f10644h = new i(this);
            }
            e.t().H(this.f10644h);
            e.m.execute(new a(this, d2));
        }
    }

    public final void p(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
            e.t().s(jSONObject.optString("key_download_package_name"));
        }
    }

    public final void q(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
            String optString = jSONObject.optString("key_download_url");
            String optString2 = jSONObject.optString("key_download_package_name");
            String optString3 = jSONObject.optString("download_params");
            c.a.r0.h.j.r.b.n().h("manualInstall", new c.a.r0.h.j.r.a(this.f10643g), optString2, optString3, optString);
            e.t().L(optString, optString2, optString3);
        }
    }

    public final void r(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jSONObject) == null) {
            e.t().x(jSONObject.optString("key_download_url"), jSONObject.optString("key_download_package_name"));
        }
    }

    public final void s(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, jSONObject) == null) {
            e.t().p(jSONObject.optString("key_download_url"), jSONObject.optString("key_download_package_name"), jSONObject.optLong(GameGuideConfigInfo.KEY_PACKAGE_EXPIRE, 0L));
        }
    }

    public final void t(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jSONObject) == null) {
            e.t().y(jSONObject.optString("key_download_package_name"));
        }
    }

    public final void u(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, jSONObject) == null) {
            e.t().z(jSONObject.optString("key_download_package_name"));
        }
    }

    public final void v(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, jSONObject) == null) {
            e.t().G(jSONObject.optString("key_download_url"), jSONObject.optString("key_download_package_name"), jSONObject.optString("download_params"));
        }
    }

    public final void w(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject) == null) {
            e.t().J(jSONObject.optString("key_download_url"), jSONObject.optString("key_download_package_name"), jSONObject.optString("download_params"));
        }
    }

    public final void x(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, jSONObject) == null) {
            e.t().K(jSONObject.optString("key_download_url"), jSONObject.optString(c.a.r0.h.j.m.c.f10600b), jSONObject.optString(c.a.r0.h.j.m.c.f10601c));
        }
    }
}
