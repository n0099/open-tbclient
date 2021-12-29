package c.a.r0.b.p.f.b;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.r0.a.d2.e;
import c.a.r0.a.z2.n0;
import c.a.r0.a.z2.q0;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.inner.BaseStatisContent;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public C0665a f10426b;

    /* renamed from: c  reason: collision with root package name */
    public c f10427c;

    /* renamed from: d  reason: collision with root package name */
    public b f10428d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f10429e;

    /* renamed from: c.a.r0.b.p.f.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0665a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f10430b;

        /* renamed from: c  reason: collision with root package name */
        public int f10431c;

        /* renamed from: d  reason: collision with root package name */
        public int f10432d;

        /* renamed from: e  reason: collision with root package name */
        public String f10433e;

        /* renamed from: f  reason: collision with root package name */
        public String f10434f;

        /* renamed from: g  reason: collision with root package name */
        public int f10435g;

        /* renamed from: h  reason: collision with root package name */
        public int f10436h;

        /* renamed from: i  reason: collision with root package name */
        public String f10437i;

        public C0665a() {
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
        public int f10438b;

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
        public double f10439b;

        /* renamed from: c  reason: collision with root package name */
        public double f10440c;

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
        C0665a c0665a = new C0665a();
        c cVar = new c();
        b bVar = new b();
        String f0 = e.f0();
        String str = "";
        this.a = TextUtils.isEmpty(f0) ? "" : f0;
        this.f10426b = c0665a;
        this.f10427c = cVar;
        this.f10428d = bVar;
        this.f10429e = jSONObject;
        String r = q0.r();
        c0665a.a = "0".equals(r) ? "" : r;
        String a = a();
        c0665a.f10430b = "0".equals(a) ? "" : a;
        c0665a.f10431c = 2;
        c0665a.f10432d = c.a.r0.b.p.f.c.a.e(context) ? 3 : 2;
        String i4 = c.a.r0.a.d0.c.i();
        c0665a.f10433e = "NUL".equals(i4) ? "" : i4;
        String g2 = c.a.r0.a.d0.c.g();
        c0665a.f10434f = "NUL".equals(g2) ? "" : g2;
        c0665a.f10435g = n0.n(context);
        c0665a.f10436h = n0.o(context);
        String b2 = b();
        if (!TextUtils.isEmpty(b2) && !"02:00:00:00:00:00".equals(b2)) {
            str = b2;
        }
        c0665a.f10437i = str;
        bVar.a = c.a.r0.b.p.f.c.a.c();
        bVar.f10438b = c.a.r0.b.p.f.c.a.d(context);
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String a = c.a.r0.f.a.b.c.f10561b.a(AppRuntime.getAppContext());
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
                jSONObject2.put("deviceid", this.f10426b.a);
                jSONObject2.put("androidid", this.f10426b.f10430b);
                jSONObject2.put("os_type", this.f10426b.f10431c);
                jSONObject2.put(HttpConstants.DEVICE_TYPE, this.f10426b.f10432d);
                jSONObject2.put("device_vendor", this.f10426b.f10433e);
                jSONObject2.put("device_model", this.f10426b.f10434f);
                jSONObject2.put("screen_height", this.f10426b.f10435g);
                jSONObject2.put("screen_width", this.f10426b.f10436h);
                jSONObject2.put(BaseStatisContent.MAC, this.f10426b.f10437i);
                jSONObject.put("device", jSONObject2);
                jSONObject3.put("coord_type", this.f10427c.a);
                jSONObject3.put("latitude", this.f10427c.f10439b);
                jSONObject3.put("longitude", this.f10427c.f10440c);
                jSONObject.put(TableDefine.DB_TABLE_USERINFO, jSONObject3);
                jSONObject4.put("network", this.f10428d.a);
                jSONObject4.put("operator", this.f10428d.f10438b);
                jSONObject.put("network", jSONObject4);
                jSONObject.put("data", this.f10429e);
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
