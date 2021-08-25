package c.a.o0.b.p.i.b;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.o0.a.a2.e;
import c.a.o0.a.v2.n0;
import c.a.o0.a.v2.q0;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.util.DeviceUtils;
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

    /* renamed from: a  reason: collision with root package name */
    public String f10255a;

    /* renamed from: b  reason: collision with root package name */
    public C0506a f10256b;

    /* renamed from: c  reason: collision with root package name */
    public c f10257c;

    /* renamed from: d  reason: collision with root package name */
    public b f10258d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f10259e;

    /* renamed from: c.a.o0.b.p.i.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0506a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f10260a;

        /* renamed from: b  reason: collision with root package name */
        public String f10261b;

        /* renamed from: c  reason: collision with root package name */
        public int f10262c;

        /* renamed from: d  reason: collision with root package name */
        public int f10263d;

        /* renamed from: e  reason: collision with root package name */
        public String f10264e;

        /* renamed from: f  reason: collision with root package name */
        public String f10265f;

        /* renamed from: g  reason: collision with root package name */
        public int f10266g;

        /* renamed from: h  reason: collision with root package name */
        public int f10267h;

        /* renamed from: i  reason: collision with root package name */
        public String f10268i;

        public C0506a() {
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

        /* renamed from: a  reason: collision with root package name */
        public int f10269a;

        /* renamed from: b  reason: collision with root package name */
        public int f10270b;

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

        /* renamed from: a  reason: collision with root package name */
        public int f10271a;

        /* renamed from: b  reason: collision with root package name */
        public double f10272b;

        /* renamed from: c  reason: collision with root package name */
        public double f10273c;

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
        C0506a c0506a = new C0506a();
        c cVar = new c();
        b bVar = new b();
        String V = e.V();
        String str = "";
        this.f10255a = TextUtils.isEmpty(V) ? "" : V;
        this.f10256b = c0506a;
        this.f10257c = cVar;
        this.f10258d = bVar;
        this.f10259e = jSONObject;
        String r = q0.r();
        c0506a.f10260a = "0".equals(r) ? "" : r;
        String a2 = a();
        c0506a.f10261b = "0".equals(a2) ? "" : a2;
        c0506a.f10262c = 2;
        c0506a.f10263d = c.a.o0.b.p.i.c.a.e(context) ? 3 : 2;
        String i4 = c.a.o0.a.d0.c.i();
        c0506a.f10264e = "NUL".equals(i4) ? "" : i4;
        String g2 = c.a.o0.a.d0.c.g();
        c0506a.f10265f = "NUL".equals(g2) ? "" : g2;
        c0506a.f10266g = n0.n(context);
        c0506a.f10267h = n0.o(context);
        String b2 = b();
        if (!TextUtils.isEmpty(b2) && !"02:00:00:00:00:00".equals(b2)) {
            str = b2;
        }
        c0506a.f10268i = str;
        bVar.f10269a = c.a.o0.b.p.i.c.a.c();
        bVar.f10270b = c.a.o0.b.p.i.c.a.d(context);
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String string = Settings.Secure.getString(AppRuntime.getAppContext().getContentResolver(), IAdRequestParam.ANDROID_ID);
            return TextUtils.isEmpty(string) ? "0" : string;
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
                jSONObject.put("app_id", this.f10255a);
                jSONObject2.put(DeviceUtils.KEY_OLD_NAME_STRING, this.f10256b.f10260a);
                jSONObject2.put("androidid", this.f10256b.f10261b);
                jSONObject2.put("os_type", this.f10256b.f10262c);
                jSONObject2.put(HttpConstants.DEVICE_TYPE, this.f10256b.f10263d);
                jSONObject2.put("device_vendor", this.f10256b.f10264e);
                jSONObject2.put("device_model", this.f10256b.f10265f);
                jSONObject2.put("screen_height", this.f10256b.f10266g);
                jSONObject2.put("screen_width", this.f10256b.f10267h);
                jSONObject2.put("mac", this.f10256b.f10268i);
                jSONObject.put("device", jSONObject2);
                jSONObject3.put("coord_type", this.f10257c.f10271a);
                jSONObject3.put("latitude", this.f10257c.f10272b);
                jSONObject3.put("longitude", this.f10257c.f10273c);
                jSONObject.put(TableDefine.DB_TABLE_USERINFO, jSONObject3);
                jSONObject4.put("network", this.f10258d.f10269a);
                jSONObject4.put("operator", this.f10258d.f10270b);
                jSONObject.put("network", jSONObject4);
                jSONObject.put("data", this.f10259e);
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
