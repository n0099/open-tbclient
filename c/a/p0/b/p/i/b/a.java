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
    public String f10283a;

    /* renamed from: b  reason: collision with root package name */
    public C0508a f10284b;

    /* renamed from: c  reason: collision with root package name */
    public c f10285c;

    /* renamed from: d  reason: collision with root package name */
    public b f10286d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f10287e;

    /* renamed from: c.a.p0.b.p.i.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0508a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f10288a;

        /* renamed from: b  reason: collision with root package name */
        public String f10289b;

        /* renamed from: c  reason: collision with root package name */
        public int f10290c;

        /* renamed from: d  reason: collision with root package name */
        public int f10291d;

        /* renamed from: e  reason: collision with root package name */
        public String f10292e;

        /* renamed from: f  reason: collision with root package name */
        public String f10293f;

        /* renamed from: g  reason: collision with root package name */
        public int f10294g;

        /* renamed from: h  reason: collision with root package name */
        public int f10295h;

        /* renamed from: i  reason: collision with root package name */
        public String f10296i;

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
        public int f10297a;

        /* renamed from: b  reason: collision with root package name */
        public int f10298b;

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
        public int f10299a;

        /* renamed from: b  reason: collision with root package name */
        public double f10300b;

        /* renamed from: c  reason: collision with root package name */
        public double f10301c;

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
        this.f10283a = TextUtils.isEmpty(V) ? "" : V;
        this.f10284b = c0508a;
        this.f10285c = cVar;
        this.f10286d = bVar;
        this.f10287e = jSONObject;
        String r = q0.r();
        c0508a.f10288a = "0".equals(r) ? "" : r;
        String a2 = a();
        c0508a.f10289b = "0".equals(a2) ? "" : a2;
        c0508a.f10290c = 2;
        c0508a.f10291d = c.a.p0.b.p.i.c.a.e(context) ? 3 : 2;
        String i4 = c.a.p0.a.d0.c.i();
        c0508a.f10292e = "NUL".equals(i4) ? "" : i4;
        String g2 = c.a.p0.a.d0.c.g();
        c0508a.f10293f = "NUL".equals(g2) ? "" : g2;
        c0508a.f10294g = n0.n(context);
        c0508a.f10295h = n0.o(context);
        String b2 = b();
        if (!TextUtils.isEmpty(b2) && !"02:00:00:00:00:00".equals(b2)) {
            str = b2;
        }
        c0508a.f10296i = str;
        bVar.f10297a = c.a.p0.b.p.i.c.a.c();
        bVar.f10298b = c.a.p0.b.p.i.c.a.d(context);
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
                jSONObject.put("app_id", this.f10283a);
                jSONObject2.put(DeviceUtils.KEY_OLD_NAME_STRING, this.f10284b.f10288a);
                jSONObject2.put("androidid", this.f10284b.f10289b);
                jSONObject2.put("os_type", this.f10284b.f10290c);
                jSONObject2.put(HttpConstants.DEVICE_TYPE, this.f10284b.f10291d);
                jSONObject2.put("device_vendor", this.f10284b.f10292e);
                jSONObject2.put("device_model", this.f10284b.f10293f);
                jSONObject2.put("screen_height", this.f10284b.f10294g);
                jSONObject2.put("screen_width", this.f10284b.f10295h);
                jSONObject2.put("mac", this.f10284b.f10296i);
                jSONObject.put("device", jSONObject2);
                jSONObject3.put("coord_type", this.f10285c.f10299a);
                jSONObject3.put("latitude", this.f10285c.f10300b);
                jSONObject3.put("longitude", this.f10285c.f10301c);
                jSONObject.put(TableDefine.DB_TABLE_USERINFO, jSONObject3);
                jSONObject4.put("network", this.f10286d.f10297a);
                jSONObject4.put("operator", this.f10286d.f10298b);
                jSONObject.put("network", jSONObject4);
                jSONObject.put("data", this.f10287e);
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
