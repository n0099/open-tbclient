package c.a.s0.b.p.f.b;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.s0.a.d2.e;
import c.a.s0.a.z2.n0;
import c.a.s0.a.z2.q0;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public C0694a f10443b;

    /* renamed from: c  reason: collision with root package name */
    public c f10444c;

    /* renamed from: d  reason: collision with root package name */
    public b f10445d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f10446e;

    /* renamed from: c.a.s0.b.p.f.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0694a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f10447b;

        /* renamed from: c  reason: collision with root package name */
        public int f10448c;

        /* renamed from: d  reason: collision with root package name */
        public int f10449d;

        /* renamed from: e  reason: collision with root package name */
        public String f10450e;

        /* renamed from: f  reason: collision with root package name */
        public String f10451f;

        /* renamed from: g  reason: collision with root package name */
        public int f10452g;

        /* renamed from: h  reason: collision with root package name */
        public int f10453h;

        /* renamed from: i  reason: collision with root package name */
        public String f10454i;

        public C0694a() {
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
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f10455b;

        public b() {
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
    }

    /* loaded from: classes6.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public double f10456b;

        /* renamed from: c  reason: collision with root package name */
        public double f10457c;

        public c() {
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
    }

    public a(@NonNull Context context, @NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, jSONObject};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        C0694a c0694a = new C0694a();
        c cVar = new c();
        b bVar = new b();
        String f0 = e.f0();
        String str = "";
        this.a = TextUtils.isEmpty(f0) ? "" : f0;
        this.f10443b = c0694a;
        this.f10444c = cVar;
        this.f10445d = bVar;
        this.f10446e = jSONObject;
        String r = q0.r();
        c0694a.a = "0".equals(r) ? "" : r;
        String a = a();
        c0694a.f10447b = "0".equals(a) ? "" : a;
        c0694a.f10448c = 2;
        c0694a.f10449d = c.a.s0.b.p.f.c.a.e(context) ? 3 : 2;
        String i4 = c.a.s0.a.d0.c.i();
        c0694a.f10450e = "NUL".equals(i4) ? "" : i4;
        String g2 = c.a.s0.a.d0.c.g();
        c0694a.f10451f = "NUL".equals(g2) ? "" : g2;
        c0694a.f10452g = n0.n(context);
        c0694a.f10453h = n0.o(context);
        String b2 = b();
        if (!TextUtils.isEmpty(b2) && !"02:00:00:00:00:00".equals(b2)) {
            str = b2;
        }
        c0694a.f10454i = str;
        bVar.a = c.a.s0.b.p.f.c.a.c();
        bVar.f10455b = c.a.s0.b.p.f.c.a.d(context);
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String a = c.a.s0.f.a.b.c.f10575b.a(AppRuntime.getAppContext());
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
                jSONObject2.put("deviceid", this.f10443b.a);
                jSONObject2.put("androidid", this.f10443b.f10447b);
                jSONObject2.put("os_type", this.f10443b.f10448c);
                jSONObject2.put(HttpConstants.DEVICE_TYPE, this.f10443b.f10449d);
                jSONObject2.put("device_vendor", this.f10443b.f10450e);
                jSONObject2.put("device_model", this.f10443b.f10451f);
                jSONObject2.put("screen_height", this.f10443b.f10452g);
                jSONObject2.put("screen_width", this.f10443b.f10453h);
                jSONObject2.put("mac", this.f10443b.f10454i);
                jSONObject.put("device", jSONObject2);
                jSONObject3.put("coord_type", this.f10444c.a);
                jSONObject3.put("latitude", this.f10444c.f10456b);
                jSONObject3.put("longitude", this.f10444c.f10457c);
                jSONObject.put(TableDefine.DB_TABLE_USERINFO, jSONObject3);
                jSONObject4.put("network", this.f10445d.a);
                jSONObject4.put("operator", this.f10445d.f10455b);
                jSONObject.put("network", jSONObject4);
                jSONObject.put("data", this.f10446e);
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
