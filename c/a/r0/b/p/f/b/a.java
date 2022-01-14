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
    public C0674a f10201b;

    /* renamed from: c  reason: collision with root package name */
    public c f10202c;

    /* renamed from: d  reason: collision with root package name */
    public b f10203d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f10204e;

    /* renamed from: c.a.r0.b.p.f.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0674a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f10205b;

        /* renamed from: c  reason: collision with root package name */
        public int f10206c;

        /* renamed from: d  reason: collision with root package name */
        public int f10207d;

        /* renamed from: e  reason: collision with root package name */
        public String f10208e;

        /* renamed from: f  reason: collision with root package name */
        public String f10209f;

        /* renamed from: g  reason: collision with root package name */
        public int f10210g;

        /* renamed from: h  reason: collision with root package name */
        public int f10211h;

        /* renamed from: i  reason: collision with root package name */
        public String f10212i;

        public C0674a() {
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
        public int f10213b;

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
        public double f10214b;

        /* renamed from: c  reason: collision with root package name */
        public double f10215c;

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
        C0674a c0674a = new C0674a();
        c cVar = new c();
        b bVar = new b();
        String f0 = e.f0();
        String str = "";
        this.a = TextUtils.isEmpty(f0) ? "" : f0;
        this.f10201b = c0674a;
        this.f10202c = cVar;
        this.f10203d = bVar;
        this.f10204e = jSONObject;
        String r = q0.r();
        c0674a.a = "0".equals(r) ? "" : r;
        String a = a();
        c0674a.f10205b = "0".equals(a) ? "" : a;
        c0674a.f10206c = 2;
        c0674a.f10207d = c.a.r0.b.p.f.c.a.e(context) ? 3 : 2;
        String i4 = c.a.r0.a.d0.c.i();
        c0674a.f10208e = "NUL".equals(i4) ? "" : i4;
        String g2 = c.a.r0.a.d0.c.g();
        c0674a.f10209f = "NUL".equals(g2) ? "" : g2;
        c0674a.f10210g = n0.n(context);
        c0674a.f10211h = n0.o(context);
        String b2 = b();
        if (!TextUtils.isEmpty(b2) && !"02:00:00:00:00:00".equals(b2)) {
            str = b2;
        }
        c0674a.f10212i = str;
        bVar.a = c.a.r0.b.p.f.c.a.c();
        bVar.f10213b = c.a.r0.b.p.f.c.a.d(context);
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String a = c.a.r0.f.a.b.c.f10333b.a(AppRuntime.getAppContext());
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
                jSONObject2.put("deviceid", this.f10201b.a);
                jSONObject2.put("androidid", this.f10201b.f10205b);
                jSONObject2.put("os_type", this.f10201b.f10206c);
                jSONObject2.put(HttpConstants.DEVICE_TYPE, this.f10201b.f10207d);
                jSONObject2.put("device_vendor", this.f10201b.f10208e);
                jSONObject2.put("device_model", this.f10201b.f10209f);
                jSONObject2.put("screen_height", this.f10201b.f10210g);
                jSONObject2.put("screen_width", this.f10201b.f10211h);
                jSONObject2.put("mac", this.f10201b.f10212i);
                jSONObject.put("device", jSONObject2);
                jSONObject3.put("coord_type", this.f10202c.a);
                jSONObject3.put("latitude", this.f10202c.f10214b);
                jSONObject3.put("longitude", this.f10202c.f10215c);
                jSONObject.put(TableDefine.DB_TABLE_USERINFO, jSONObject3);
                jSONObject4.put("network", this.f10203d.a);
                jSONObject4.put("operator", this.f10203d.f10213b);
                jSONObject.put("network", jSONObject4);
                jSONObject.put("data", this.f10204e);
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
