package c.a.p0.b.g.f.b;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.p0.a.p2.n0;
import c.a.p0.a.p2.q0;
import c.a.p0.a.t1.e;
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
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public C0639a f9668b;

    /* renamed from: c  reason: collision with root package name */
    public c f9669c;

    /* renamed from: d  reason: collision with root package name */
    public b f9670d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f9671e;

    /* renamed from: c.a.p0.b.g.f.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0639a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f9672b;

        /* renamed from: c  reason: collision with root package name */
        public int f9673c;

        /* renamed from: d  reason: collision with root package name */
        public int f9674d;

        /* renamed from: e  reason: collision with root package name */
        public String f9675e;

        /* renamed from: f  reason: collision with root package name */
        public String f9676f;

        /* renamed from: g  reason: collision with root package name */
        public int f9677g;

        /* renamed from: h  reason: collision with root package name */
        public int f9678h;

        /* renamed from: i  reason: collision with root package name */
        public String f9679i;

        public C0639a() {
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

    /* loaded from: classes.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f9680b;

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

    /* loaded from: classes.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public double f9681b;

        /* renamed from: c  reason: collision with root package name */
        public double f9682c;

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
        C0639a c0639a = new C0639a();
        c cVar = new c();
        b bVar = new b();
        String f0 = e.f0();
        String str = "";
        this.a = TextUtils.isEmpty(f0) ? "" : f0;
        this.f9668b = c0639a;
        this.f9669c = cVar;
        this.f9670d = bVar;
        this.f9671e = jSONObject;
        String r = q0.r();
        c0639a.a = "0".equals(r) ? "" : r;
        String a = a();
        c0639a.f9672b = "0".equals(a) ? "" : a;
        c0639a.f9673c = 2;
        c0639a.f9674d = c.a.p0.b.g.f.c.a.e(context) ? 3 : 2;
        String i4 = c.a.p0.a.t.c.i();
        c0639a.f9675e = "NUL".equals(i4) ? "" : i4;
        String g2 = c.a.p0.a.t.c.g();
        c0639a.f9676f = "NUL".equals(g2) ? "" : g2;
        c0639a.f9677g = n0.n(context);
        c0639a.f9678h = n0.o(context);
        String b2 = b();
        if (!TextUtils.isEmpty(b2) && !"02:00:00:00:00:00".equals(b2)) {
            str = b2;
        }
        c0639a.f9679i = str;
        bVar.a = c.a.p0.b.g.f.c.a.c();
        bVar.f9680b = c.a.p0.b.g.f.c.a.d(context);
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String a = c.a.p0.f.a.b.c.f9800b.a(AppRuntime.getAppContext());
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
                jSONObject2.put("deviceid", this.f9668b.a);
                jSONObject2.put("androidid", this.f9668b.f9672b);
                jSONObject2.put("os_type", this.f9668b.f9673c);
                jSONObject2.put(HttpConstants.DEVICE_TYPE, this.f9668b.f9674d);
                jSONObject2.put("device_vendor", this.f9668b.f9675e);
                jSONObject2.put("device_model", this.f9668b.f9676f);
                jSONObject2.put("screen_height", this.f9668b.f9677g);
                jSONObject2.put("screen_width", this.f9668b.f9678h);
                jSONObject2.put("mac", this.f9668b.f9679i);
                jSONObject.put("device", jSONObject2);
                jSONObject3.put("coord_type", this.f9669c.a);
                jSONObject3.put("latitude", this.f9669c.f9681b);
                jSONObject3.put("longitude", this.f9669c.f9682c);
                jSONObject.put(TableDefine.DB_TABLE_USERINFO, jSONObject3);
                jSONObject4.put("network", this.f9670d.a);
                jSONObject4.put("operator", this.f9670d.f9680b);
                jSONObject.put("network", jSONObject4);
                jSONObject.put("data", this.f9671e);
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
