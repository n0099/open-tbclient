package c.a.n0.b.g.f.b;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.n0.a.p2.n0;
import c.a.n0.a.p2.q0;
import c.a.n0.a.t1.e;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public C0631a f8092b;

    /* renamed from: c  reason: collision with root package name */
    public c f8093c;

    /* renamed from: d  reason: collision with root package name */
    public b f8094d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f8095e;

    /* renamed from: c.a.n0.b.g.f.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0631a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f8096b;

        /* renamed from: c  reason: collision with root package name */
        public int f8097c;

        /* renamed from: d  reason: collision with root package name */
        public int f8098d;

        /* renamed from: e  reason: collision with root package name */
        public String f8099e;

        /* renamed from: f  reason: collision with root package name */
        public String f8100f;

        /* renamed from: g  reason: collision with root package name */
        public int f8101g;

        /* renamed from: h  reason: collision with root package name */
        public int f8102h;
        public String i;

        public C0631a() {
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
    }

    /* loaded from: classes.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f8103b;

        public b() {
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
    }

    /* loaded from: classes.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public double f8104b;

        /* renamed from: c  reason: collision with root package name */
        public double f8105c;

        public c() {
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
    }

    public a(@NonNull Context context, @NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, jSONObject};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        C0631a c0631a = new C0631a();
        c cVar = new c();
        b bVar = new b();
        String f0 = e.f0();
        String str = "";
        this.a = TextUtils.isEmpty(f0) ? "" : f0;
        this.f8092b = c0631a;
        this.f8093c = cVar;
        this.f8094d = bVar;
        this.f8095e = jSONObject;
        String r = q0.r();
        c0631a.a = "0".equals(r) ? "" : r;
        String a = a();
        c0631a.f8096b = "0".equals(a) ? "" : a;
        c0631a.f8097c = 2;
        c0631a.f8098d = c.a.n0.b.g.f.c.a.e(context) ? 3 : 2;
        String i3 = c.a.n0.a.t.c.i();
        c0631a.f8099e = "NUL".equals(i3) ? "" : i3;
        String g2 = c.a.n0.a.t.c.g();
        c0631a.f8100f = "NUL".equals(g2) ? "" : g2;
        c0631a.f8101g = n0.n(context);
        c0631a.f8102h = n0.o(context);
        String b2 = b();
        if (!TextUtils.isEmpty(b2) && !Config.DEF_MAC_ID.equals(b2)) {
            str = b2;
        }
        c0631a.i = str;
        bVar.a = c.a.n0.b.g.f.c.a.c();
        bVar.f8103b = c.a.n0.b.g.f.c.a.d(context);
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String a = c.a.n0.f.a.b.c.f8208b.a(AppRuntime.getAppContext());
            return TextUtils.isEmpty(a) ? "0" : a;
        }
        return (String) invokeV.objValue;
    }

    public String b() {
        String str;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            try {
                str = ((WifiManager) AppRuntime.getAppContext().getApplicationContext().getSystemService("wifi")).getConnectionInfo().getMacAddress();
            } catch (Exception unused) {
                str = null;
            }
            return TextUtils.isEmpty(str) ? "" : str;
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public JSONObject c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            JSONObject jSONObject4 = new JSONObject();
            try {
                jSONObject.put("app_id", this.a);
                jSONObject2.put("deviceid", this.f8092b.a);
                jSONObject2.put("androidid", this.f8092b.f8096b);
                jSONObject2.put("os_type", this.f8092b.f8097c);
                jSONObject2.put(HttpConstants.DEVICE_TYPE, this.f8092b.f8098d);
                jSONObject2.put("device_vendor", this.f8092b.f8099e);
                jSONObject2.put("device_model", this.f8092b.f8100f);
                jSONObject2.put("screen_height", this.f8092b.f8101g);
                jSONObject2.put("screen_width", this.f8092b.f8102h);
                jSONObject2.put("mac", this.f8092b.i);
                jSONObject.put(Config.DEVICE_PART, jSONObject2);
                jSONObject3.put("coord_type", this.f8093c.a);
                jSONObject3.put("latitude", this.f8093c.f8104b);
                jSONObject3.put("longitude", this.f8093c.f8105c);
                jSONObject.put(TableDefine.DB_TABLE_USERINFO, jSONObject3);
                jSONObject4.put("network", this.f8094d.a);
                jSONObject4.put("operator", this.f8094d.f8103b);
                jSONObject.put("network", jSONObject4);
                jSONObject.put("data", this.f8095e);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? c().toString() : (String) invokeV.objValue;
    }
}
