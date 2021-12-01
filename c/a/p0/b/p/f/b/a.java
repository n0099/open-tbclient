package c.a.p0.b.p.f.b;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.p0.a.d2.e;
import c.a.p0.a.z2.n0;
import c.a.p0.a.z2.q0;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.inner.BaseStatisContent;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public C0581a f9382b;

    /* renamed from: c  reason: collision with root package name */
    public c f9383c;

    /* renamed from: d  reason: collision with root package name */
    public b f9384d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f9385e;

    /* renamed from: c.a.p0.b.p.f.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0581a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f9386b;

        /* renamed from: c  reason: collision with root package name */
        public int f9387c;

        /* renamed from: d  reason: collision with root package name */
        public int f9388d;

        /* renamed from: e  reason: collision with root package name */
        public String f9389e;

        /* renamed from: f  reason: collision with root package name */
        public String f9390f;

        /* renamed from: g  reason: collision with root package name */
        public int f9391g;

        /* renamed from: h  reason: collision with root package name */
        public int f9392h;

        /* renamed from: i  reason: collision with root package name */
        public String f9393i;

        public C0581a() {
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

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f9394b;

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

    /* loaded from: classes5.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public double f9395b;

        /* renamed from: c  reason: collision with root package name */
        public double f9396c;

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
        C0581a c0581a = new C0581a();
        c cVar = new c();
        b bVar = new b();
        String f0 = e.f0();
        String str = "";
        this.a = TextUtils.isEmpty(f0) ? "" : f0;
        this.f9382b = c0581a;
        this.f9383c = cVar;
        this.f9384d = bVar;
        this.f9385e = jSONObject;
        String r = q0.r();
        c0581a.a = "0".equals(r) ? "" : r;
        String a = a();
        c0581a.f9386b = "0".equals(a) ? "" : a;
        c0581a.f9387c = 2;
        c0581a.f9388d = c.a.p0.b.p.f.c.a.e(context) ? 3 : 2;
        String i4 = c.a.p0.a.d0.c.i();
        c0581a.f9389e = "NUL".equals(i4) ? "" : i4;
        String g2 = c.a.p0.a.d0.c.g();
        c0581a.f9390f = "NUL".equals(g2) ? "" : g2;
        c0581a.f9391g = n0.n(context);
        c0581a.f9392h = n0.o(context);
        String b2 = b();
        if (!TextUtils.isEmpty(b2) && !"02:00:00:00:00:00".equals(b2)) {
            str = b2;
        }
        c0581a.f9393i = str;
        bVar.a = c.a.p0.b.p.f.c.a.c();
        bVar.f9394b = c.a.p0.b.p.f.c.a.d(context);
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String a = c.a.p0.f.a.b.c.f9517b.a(AppRuntime.getAppContext());
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
                jSONObject2.put("deviceid", this.f9382b.a);
                jSONObject2.put("androidid", this.f9382b.f9386b);
                jSONObject2.put("os_type", this.f9382b.f9387c);
                jSONObject2.put("device_type", this.f9382b.f9388d);
                jSONObject2.put("device_vendor", this.f9382b.f9389e);
                jSONObject2.put("device_model", this.f9382b.f9390f);
                jSONObject2.put("screen_height", this.f9382b.f9391g);
                jSONObject2.put("screen_width", this.f9382b.f9392h);
                jSONObject2.put(BaseStatisContent.MAC, this.f9382b.f9393i);
                jSONObject.put("device", jSONObject2);
                jSONObject3.put("coord_type", this.f9383c.a);
                jSONObject3.put("latitude", this.f9383c.f9395b);
                jSONObject3.put("longitude", this.f9383c.f9396c);
                jSONObject.put(TableDefine.DB_TABLE_USERINFO, jSONObject3);
                jSONObject4.put("network", this.f9384d.a);
                jSONObject4.put("operator", this.f9384d.f9394b);
                jSONObject.put("network", jSONObject4);
                jSONObject.put("data", this.f9385e);
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
