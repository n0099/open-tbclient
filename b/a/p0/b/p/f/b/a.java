package b.a.p0.b.p.f.b;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import b.a.p0.a.d2.e;
import b.a.p0.a.z2.n0;
import b.a.p0.a.z2.q0;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
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
    public String f10087a;

    /* renamed from: b  reason: collision with root package name */
    public C0525a f10088b;

    /* renamed from: c  reason: collision with root package name */
    public c f10089c;

    /* renamed from: d  reason: collision with root package name */
    public b f10090d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f10091e;

    /* renamed from: b.a.p0.b.p.f.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0525a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f10092a;

        /* renamed from: b  reason: collision with root package name */
        public String f10093b;

        /* renamed from: c  reason: collision with root package name */
        public int f10094c;

        /* renamed from: d  reason: collision with root package name */
        public int f10095d;

        /* renamed from: e  reason: collision with root package name */
        public String f10096e;

        /* renamed from: f  reason: collision with root package name */
        public String f10097f;

        /* renamed from: g  reason: collision with root package name */
        public int f10098g;

        /* renamed from: h  reason: collision with root package name */
        public int f10099h;

        /* renamed from: i  reason: collision with root package name */
        public String f10100i;

        public C0525a() {
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
        public int f10101a;

        /* renamed from: b  reason: collision with root package name */
        public int f10102b;

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
        public int f10103a;

        /* renamed from: b  reason: collision with root package name */
        public double f10104b;

        /* renamed from: c  reason: collision with root package name */
        public double f10105c;

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
        C0525a c0525a = new C0525a();
        c cVar = new c();
        b bVar = new b();
        String f0 = e.f0();
        String str = "";
        this.f10087a = TextUtils.isEmpty(f0) ? "" : f0;
        this.f10088b = c0525a;
        this.f10089c = cVar;
        this.f10090d = bVar;
        this.f10091e = jSONObject;
        String r = q0.r();
        c0525a.f10092a = "0".equals(r) ? "" : r;
        String a2 = a();
        c0525a.f10093b = "0".equals(a2) ? "" : a2;
        c0525a.f10094c = 2;
        c0525a.f10095d = b.a.p0.b.p.f.c.a.e(context) ? 3 : 2;
        String i4 = b.a.p0.a.d0.c.i();
        c0525a.f10096e = "NUL".equals(i4) ? "" : i4;
        String g2 = b.a.p0.a.d0.c.g();
        c0525a.f10097f = "NUL".equals(g2) ? "" : g2;
        c0525a.f10098g = n0.n(context);
        c0525a.f10099h = n0.o(context);
        String b2 = b();
        if (!TextUtils.isEmpty(b2) && !"02:00:00:00:00:00".equals(b2)) {
            str = b2;
        }
        c0525a.f10100i = str;
        bVar.f10101a = b.a.p0.b.p.f.c.a.c();
        bVar.f10102b = b.a.p0.b.p.f.c.a.d(context);
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String a2 = b.a.p0.f.a.b.c.f10262b.a(AppRuntime.getAppContext());
            return TextUtils.isEmpty(a2) ? "0" : a2;
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
                jSONObject.put("app_id", this.f10087a);
                jSONObject2.put(DeviceUtils.KEY_OLD_NAME_STRING, this.f10088b.f10092a);
                jSONObject2.put("androidid", this.f10088b.f10093b);
                jSONObject2.put("os_type", this.f10088b.f10094c);
                jSONObject2.put("device_type", this.f10088b.f10095d);
                jSONObject2.put("device_vendor", this.f10088b.f10096e);
                jSONObject2.put("device_model", this.f10088b.f10097f);
                jSONObject2.put("screen_height", this.f10088b.f10098g);
                jSONObject2.put("screen_width", this.f10088b.f10099h);
                jSONObject2.put("mac", this.f10088b.f10100i);
                jSONObject.put("device", jSONObject2);
                jSONObject3.put("coord_type", this.f10089c.f10103a);
                jSONObject3.put("latitude", this.f10089c.f10104b);
                jSONObject3.put("longitude", this.f10089c.f10105c);
                jSONObject.put(TableDefine.DB_TABLE_USERINFO, jSONObject3);
                jSONObject4.put("network", this.f10090d.f10101a);
                jSONObject4.put("operator", this.f10090d.f10102b);
                jSONObject.put("network", jSONObject4);
                jSONObject.put("data", this.f10091e);
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
