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
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public C0683a f10343b;

    /* renamed from: c  reason: collision with root package name */
    public c f10344c;

    /* renamed from: d  reason: collision with root package name */
    public b f10345d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f10346e;

    /* renamed from: c.a.r0.b.p.f.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0683a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f10347b;

        /* renamed from: c  reason: collision with root package name */
        public int f10348c;

        /* renamed from: d  reason: collision with root package name */
        public int f10349d;

        /* renamed from: e  reason: collision with root package name */
        public String f10350e;

        /* renamed from: f  reason: collision with root package name */
        public String f10351f;

        /* renamed from: g  reason: collision with root package name */
        public int f10352g;

        /* renamed from: h  reason: collision with root package name */
        public int f10353h;

        /* renamed from: i  reason: collision with root package name */
        public String f10354i;

        public C0683a() {
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
        public int f10355b;

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
        public double f10356b;

        /* renamed from: c  reason: collision with root package name */
        public double f10357c;

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
        C0683a c0683a = new C0683a();
        c cVar = new c();
        b bVar = new b();
        String f0 = e.f0();
        String str = "";
        this.a = TextUtils.isEmpty(f0) ? "" : f0;
        this.f10343b = c0683a;
        this.f10344c = cVar;
        this.f10345d = bVar;
        this.f10346e = jSONObject;
        String r = q0.r();
        c0683a.a = "0".equals(r) ? "" : r;
        String a = a();
        c0683a.f10347b = "0".equals(a) ? "" : a;
        c0683a.f10348c = 2;
        c0683a.f10349d = c.a.r0.b.p.f.c.a.e(context) ? 3 : 2;
        String i4 = c.a.r0.a.d0.c.i();
        c0683a.f10350e = "NUL".equals(i4) ? "" : i4;
        String g2 = c.a.r0.a.d0.c.g();
        c0683a.f10351f = "NUL".equals(g2) ? "" : g2;
        c0683a.f10352g = n0.n(context);
        c0683a.f10353h = n0.o(context);
        String b2 = b();
        if (!TextUtils.isEmpty(b2) && !"02:00:00:00:00:00".equals(b2)) {
            str = b2;
        }
        c0683a.f10354i = str;
        bVar.a = c.a.r0.b.p.f.c.a.c();
        bVar.f10355b = c.a.r0.b.p.f.c.a.d(context);
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String a = c.a.r0.f.a.b.c.f10475b.a(AppRuntime.getAppContext());
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
                jSONObject2.put("deviceid", this.f10343b.a);
                jSONObject2.put("androidid", this.f10343b.f10347b);
                jSONObject2.put("os_type", this.f10343b.f10348c);
                jSONObject2.put(HttpConstants.DEVICE_TYPE, this.f10343b.f10349d);
                jSONObject2.put("device_vendor", this.f10343b.f10350e);
                jSONObject2.put("device_model", this.f10343b.f10351f);
                jSONObject2.put("screen_height", this.f10343b.f10352g);
                jSONObject2.put("screen_width", this.f10343b.f10353h);
                jSONObject2.put("mac", this.f10343b.f10354i);
                jSONObject.put("device", jSONObject2);
                jSONObject3.put("coord_type", this.f10344c.a);
                jSONObject3.put("latitude", this.f10344c.f10356b);
                jSONObject3.put("longitude", this.f10344c.f10357c);
                jSONObject.put(TableDefine.DB_TABLE_USERINFO, jSONObject3);
                jSONObject4.put("network", this.f10345d.a);
                jSONObject4.put("operator", this.f10345d.f10355b);
                jSONObject.put("network", jSONObject4);
                jSONObject.put("data", this.f10346e);
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
