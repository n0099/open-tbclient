package c.a.p0.b.p.i.b;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.p0.a.a2.e;
import c.a.p0.a.v2.n0;
import c.a.p0.a.v2.q0;
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
    public String f10291a;

    /* renamed from: b  reason: collision with root package name */
    public C0508a f10292b;

    /* renamed from: c  reason: collision with root package name */
    public c f10293c;

    /* renamed from: d  reason: collision with root package name */
    public b f10294d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f10295e;

    /* renamed from: c.a.p0.b.p.i.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0508a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f10296a;

        /* renamed from: b  reason: collision with root package name */
        public String f10297b;

        /* renamed from: c  reason: collision with root package name */
        public int f10298c;

        /* renamed from: d  reason: collision with root package name */
        public int f10299d;

        /* renamed from: e  reason: collision with root package name */
        public String f10300e;

        /* renamed from: f  reason: collision with root package name */
        public String f10301f;

        /* renamed from: g  reason: collision with root package name */
        public int f10302g;

        /* renamed from: h  reason: collision with root package name */
        public int f10303h;

        /* renamed from: i  reason: collision with root package name */
        public String f10304i;

        public C0508a() {
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
        public int f10305a;

        /* renamed from: b  reason: collision with root package name */
        public int f10306b;

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
        public int f10307a;

        /* renamed from: b  reason: collision with root package name */
        public double f10308b;

        /* renamed from: c  reason: collision with root package name */
        public double f10309c;

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
        C0508a c0508a = new C0508a();
        c cVar = new c();
        b bVar = new b();
        String V = e.V();
        String str = "";
        this.f10291a = TextUtils.isEmpty(V) ? "" : V;
        this.f10292b = c0508a;
        this.f10293c = cVar;
        this.f10294d = bVar;
        this.f10295e = jSONObject;
        String r = q0.r();
        c0508a.f10296a = "0".equals(r) ? "" : r;
        String a2 = a();
        c0508a.f10297b = "0".equals(a2) ? "" : a2;
        c0508a.f10298c = 2;
        c0508a.f10299d = c.a.p0.b.p.i.c.a.e(context) ? 3 : 2;
        String i4 = c.a.p0.a.d0.c.i();
        c0508a.f10300e = "NUL".equals(i4) ? "" : i4;
        String g2 = c.a.p0.a.d0.c.g();
        c0508a.f10301f = "NUL".equals(g2) ? "" : g2;
        c0508a.f10302g = n0.n(context);
        c0508a.f10303h = n0.o(context);
        String b2 = b();
        if (!TextUtils.isEmpty(b2) && !"02:00:00:00:00:00".equals(b2)) {
            str = b2;
        }
        c0508a.f10304i = str;
        bVar.f10305a = c.a.p0.b.p.i.c.a.c();
        bVar.f10306b = c.a.p0.b.p.i.c.a.d(context);
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
                jSONObject.put("app_id", this.f10291a);
                jSONObject2.put(DeviceUtils.KEY_OLD_NAME_STRING, this.f10292b.f10296a);
                jSONObject2.put("androidid", this.f10292b.f10297b);
                jSONObject2.put("os_type", this.f10292b.f10298c);
                jSONObject2.put(HttpConstants.DEVICE_TYPE, this.f10292b.f10299d);
                jSONObject2.put("device_vendor", this.f10292b.f10300e);
                jSONObject2.put("device_model", this.f10292b.f10301f);
                jSONObject2.put("screen_height", this.f10292b.f10302g);
                jSONObject2.put("screen_width", this.f10292b.f10303h);
                jSONObject2.put("mac", this.f10292b.f10304i);
                jSONObject.put("device", jSONObject2);
                jSONObject3.put("coord_type", this.f10293c.f10307a);
                jSONObject3.put("latitude", this.f10293c.f10308b);
                jSONObject3.put("longitude", this.f10293c.f10309c);
                jSONObject.put(TableDefine.DB_TABLE_USERINFO, jSONObject3);
                jSONObject4.put("network", this.f10294d.f10305a);
                jSONObject4.put("operator", this.f10294d.f10306b);
                jSONObject.put("network", jSONObject4);
                jSONObject.put("data", this.f10295e);
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
