package c.a.n0.b.p.i.b;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.n0.a.a2.e;
import c.a.n0.a.v2.n0;
import c.a.n0.a.v2.q0;
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
    public String f10009a;

    /* renamed from: b  reason: collision with root package name */
    public C0498a f10010b;

    /* renamed from: c  reason: collision with root package name */
    public c f10011c;

    /* renamed from: d  reason: collision with root package name */
    public b f10012d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f10013e;

    /* renamed from: c.a.n0.b.p.i.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0498a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f10014a;

        /* renamed from: b  reason: collision with root package name */
        public String f10015b;

        /* renamed from: c  reason: collision with root package name */
        public int f10016c;

        /* renamed from: d  reason: collision with root package name */
        public int f10017d;

        /* renamed from: e  reason: collision with root package name */
        public String f10018e;

        /* renamed from: f  reason: collision with root package name */
        public String f10019f;

        /* renamed from: g  reason: collision with root package name */
        public int f10020g;

        /* renamed from: h  reason: collision with root package name */
        public int f10021h;

        /* renamed from: i  reason: collision with root package name */
        public String f10022i;

        public C0498a() {
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
        public int f10023a;

        /* renamed from: b  reason: collision with root package name */
        public int f10024b;

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
        public int f10025a;

        /* renamed from: b  reason: collision with root package name */
        public double f10026b;

        /* renamed from: c  reason: collision with root package name */
        public double f10027c;

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
        C0498a c0498a = new C0498a();
        c cVar = new c();
        b bVar = new b();
        String V = e.V();
        String str = "";
        this.f10009a = TextUtils.isEmpty(V) ? "" : V;
        this.f10010b = c0498a;
        this.f10011c = cVar;
        this.f10012d = bVar;
        this.f10013e = jSONObject;
        String r = q0.r();
        c0498a.f10014a = "0".equals(r) ? "" : r;
        String a2 = a();
        c0498a.f10015b = "0".equals(a2) ? "" : a2;
        c0498a.f10016c = 2;
        c0498a.f10017d = c.a.n0.b.p.i.c.a.e(context) ? 3 : 2;
        String i4 = c.a.n0.a.d0.c.i();
        c0498a.f10018e = "NUL".equals(i4) ? "" : i4;
        String g2 = c.a.n0.a.d0.c.g();
        c0498a.f10019f = "NUL".equals(g2) ? "" : g2;
        c0498a.f10020g = n0.n(context);
        c0498a.f10021h = n0.o(context);
        String b2 = b();
        if (!TextUtils.isEmpty(b2) && !"02:00:00:00:00:00".equals(b2)) {
            str = b2;
        }
        c0498a.f10022i = str;
        bVar.f10023a = c.a.n0.b.p.i.c.a.c();
        bVar.f10024b = c.a.n0.b.p.i.c.a.d(context);
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
                jSONObject.put("app_id", this.f10009a);
                jSONObject2.put(DeviceUtils.KEY_OLD_NAME_STRING, this.f10010b.f10014a);
                jSONObject2.put("androidid", this.f10010b.f10015b);
                jSONObject2.put("os_type", this.f10010b.f10016c);
                jSONObject2.put(HttpConstants.DEVICE_TYPE, this.f10010b.f10017d);
                jSONObject2.put("device_vendor", this.f10010b.f10018e);
                jSONObject2.put("device_model", this.f10010b.f10019f);
                jSONObject2.put("screen_height", this.f10010b.f10020g);
                jSONObject2.put("screen_width", this.f10010b.f10021h);
                jSONObject2.put("mac", this.f10010b.f10022i);
                jSONObject.put("device", jSONObject2);
                jSONObject3.put("coord_type", this.f10011c.f10025a);
                jSONObject3.put("latitude", this.f10011c.f10026b);
                jSONObject3.put("longitude", this.f10011c.f10027c);
                jSONObject.put(TableDefine.DB_TABLE_USERINFO, jSONObject3);
                jSONObject4.put("network", this.f10012d.f10023a);
                jSONObject4.put("operator", this.f10012d.f10024b);
                jSONObject.put("network", jSONObject4);
                jSONObject.put("data", this.f10013e);
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
