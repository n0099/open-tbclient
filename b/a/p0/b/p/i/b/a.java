package b.a.p0.b.p.i.b;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import b.a.p0.a.a2.e;
import b.a.p0.a.v2.n0;
import b.a.p0.a.v2.q0;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
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
    public String f9514a;

    /* renamed from: b  reason: collision with root package name */
    public C0503a f9515b;

    /* renamed from: c  reason: collision with root package name */
    public c f9516c;

    /* renamed from: d  reason: collision with root package name */
    public b f9517d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f9518e;

    /* renamed from: b.a.p0.b.p.i.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0503a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f9519a;

        /* renamed from: b  reason: collision with root package name */
        public String f9520b;

        /* renamed from: c  reason: collision with root package name */
        public int f9521c;

        /* renamed from: d  reason: collision with root package name */
        public int f9522d;

        /* renamed from: e  reason: collision with root package name */
        public String f9523e;

        /* renamed from: f  reason: collision with root package name */
        public String f9524f;

        /* renamed from: g  reason: collision with root package name */
        public int f9525g;

        /* renamed from: h  reason: collision with root package name */
        public int f9526h;

        /* renamed from: i  reason: collision with root package name */
        public String f9527i;

        public C0503a() {
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
        public int f9528a;

        /* renamed from: b  reason: collision with root package name */
        public int f9529b;

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
        public int f9530a;

        /* renamed from: b  reason: collision with root package name */
        public double f9531b;

        /* renamed from: c  reason: collision with root package name */
        public double f9532c;

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
        C0503a c0503a = new C0503a();
        c cVar = new c();
        b bVar = new b();
        String U = e.U();
        String str = "";
        this.f9514a = TextUtils.isEmpty(U) ? "" : U;
        this.f9515b = c0503a;
        this.f9516c = cVar;
        this.f9517d = bVar;
        this.f9518e = jSONObject;
        String r = q0.r();
        c0503a.f9519a = "0".equals(r) ? "" : r;
        String a2 = a();
        c0503a.f9520b = "0".equals(a2) ? "" : a2;
        c0503a.f9521c = 2;
        c0503a.f9522d = b.a.p0.b.p.i.c.a.e(context) ? 3 : 2;
        String i4 = b.a.p0.a.d0.c.i();
        c0503a.f9523e = "NUL".equals(i4) ? "" : i4;
        String g2 = b.a.p0.a.d0.c.g();
        c0503a.f9524f = "NUL".equals(g2) ? "" : g2;
        c0503a.f9525g = n0.n(context);
        c0503a.f9526h = n0.o(context);
        String b2 = b();
        if (!TextUtils.isEmpty(b2) && !"02:00:00:00:00:00".equals(b2)) {
            str = b2;
        }
        c0503a.f9527i = str;
        bVar.f9528a = b.a.p0.b.p.i.c.a.c();
        bVar.f9529b = b.a.p0.b.p.i.c.a.d(context);
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
                jSONObject.put("app_id", this.f9514a);
                jSONObject2.put(DeviceUtils.KEY_OLD_NAME_STRING, this.f9515b.f9519a);
                jSONObject2.put("androidid", this.f9515b.f9520b);
                jSONObject2.put("os_type", this.f9515b.f9521c);
                jSONObject2.put("device_type", this.f9515b.f9522d);
                jSONObject2.put("device_vendor", this.f9515b.f9523e);
                jSONObject2.put("device_model", this.f9515b.f9524f);
                jSONObject2.put("screen_height", this.f9515b.f9525g);
                jSONObject2.put("screen_width", this.f9515b.f9526h);
                jSONObject2.put("mac", this.f9515b.f9527i);
                jSONObject.put("device", jSONObject2);
                jSONObject3.put("coord_type", this.f9516c.f9530a);
                jSONObject3.put("latitude", this.f9516c.f9531b);
                jSONObject3.put("longitude", this.f9516c.f9532c);
                jSONObject.put(TableDefine.DB_TABLE_USERINFO, jSONObject3);
                jSONObject4.put("network", this.f9517d.f9528a);
                jSONObject4.put("operator", this.f9517d.f9529b);
                jSONObject.put("network", jSONObject4);
                jSONObject.put("data", this.f9518e);
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
