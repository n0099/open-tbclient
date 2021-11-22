package b.a.p0.u;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.WindowManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.pass.face.platform.common.ConstantHelper;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class r {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public a f12258a;

    /* renamed from: b  reason: collision with root package name */
    public b f12259b;

    /* renamed from: c  reason: collision with root package name */
    public String f12260c;

    /* renamed from: d  reason: collision with root package name */
    public String f12261d;

    /* renamed from: e  reason: collision with root package name */
    public String f12262e;

    /* renamed from: f  reason: collision with root package name */
    public String f12263f;

    /* renamed from: g  reason: collision with root package name */
    public String f12264g;

    /* renamed from: h  reason: collision with root package name */
    public String f12265h;

    /* renamed from: i  reason: collision with root package name */
    public String f12266i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public String r;
    public String s;
    public String t;
    public String u;

    /* loaded from: classes4.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f12267a;

        /* renamed from: b  reason: collision with root package name */
        public String f12268b;

        /* renamed from: c  reason: collision with root package name */
        public String f12269c;

        /* renamed from: d  reason: collision with root package name */
        public String f12270d;

        /* renamed from: e  reason: collision with root package name */
        public int f12271e;

        /* renamed from: f  reason: collision with root package name */
        public String f12272f;

        /* renamed from: g  reason: collision with root package name */
        public String f12273g;

        /* renamed from: h  reason: collision with root package name */
        public int f12274h;

        public a(r rVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12267a = "Android";
            this.f12268b = Build.VERSION.RELEASE;
            this.f12269c = Build.MANUFACTURER;
            this.f12271e = Build.VERSION.SDK_INT;
            this.f12272f = Build.MODEL;
            Context appContext = AppRuntime.getAppContext();
            WindowManager windowManager = (WindowManager) appContext.getSystemService("window");
            this.f12273g = windowManager.getDefaultDisplay().getWidth() + "_" + windowManager.getDefaultDisplay().getHeight();
            this.f12274h = appContext.getResources().getDisplayMetrics().densityDpi;
        }
    }

    /* loaded from: classes4.dex */
    public final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f12275a;

        public b(r rVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12275a = e.g().v(AppRuntime.getAppContext());
        }
    }

    public r(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f12258a = new a(this);
        this.f12259b = new b(this);
        this.f12266i = b.a.p0.v.a.c();
        this.o = "";
        Context appContext = AppRuntime.getAppContext();
        try {
            PackageInfo packageInfo = appContext.getPackageManager().getPackageInfo(appContext.getPackageName(), 0);
            this.f12260c = packageInfo.versionName;
            this.f12262e = packageInfo.packageName;
        } catch (PackageManager.NameNotFoundException unused) {
        }
        TelephonyManager telephonyManager = (TelephonyManager) AppRuntime.getAppContext().getSystemService("phone");
        if (telephonyManager != null && (Build.VERSION.SDK_INT < 23 || appContext.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0)) {
            this.j = telephonyManager.getSimOperator();
        }
        this.f12263f = e.g().getDeviceId(appContext);
        this.f12264g = e.g().p(appContext);
        this.f12265h = e.g().a();
        this.n = e.g().b();
        this.q = e.g().t();
        this.r = str;
    }

    public static void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, jSONObject) == null) {
            JSONObject e2 = new r(jSONObject.optString("bizId")).e();
            Iterator<String> keys = e2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!jSONObject.has(next)) {
                    try {
                        jSONObject.putOpt(next, e2.opt(next));
                    } catch (JSONException unused) {
                    }
                }
            }
        }
    }

    public static String b(String str) {
        InterceptResult invokeL;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (e.g() == null) {
                return str;
            }
            try {
                if (TextUtils.isEmpty(str)) {
                    jSONObject = new JSONObject();
                } else {
                    jSONObject = new JSONObject(str);
                }
                return c(jSONObject);
            } catch (JSONException unused) {
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String c(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONObject)) == null) {
            l g2 = e.g();
            String str = "";
            if (jSONObject == null || g2 == null) {
                return "";
            }
            try {
                if (g2.l() == 0) {
                    str = "swan";
                } else if (g2.l() == 1) {
                    str = SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("smartAppId", g2.getAppId());
                jSONObject2.putOpt("smartAppVersion", g2.getAppVersion());
                jSONObject2.putOpt("swanCoreVersion", g2.n());
                jSONObject2.putOpt("swanNativeVersion", g2.b());
                jSONObject2.putOpt("swanType", str);
                jSONObject.putOpt(DI.APP_INFO_NAME, jSONObject2);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("source", g2.k());
                jSONObject.put("propagation", jSONObject3);
                return jSONObject.toString();
            } catch (JSONException unused) {
                return jSONObject.toString();
            }
        }
        return (String) invokeL.objValue;
    }

    public static void d(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONArray) == null) || jSONArray == null || jSONArray.length() < 1) {
            return;
        }
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                JSONObject jSONObject2 = jSONObject.getJSONObject("content");
                JSONObject jSONObject3 = jSONObject2.getJSONObject(DI.APP_INFO_NAME);
                Iterator<String> keys = jSONObject3.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject.putOpt(next, jSONObject3.optString(next));
                }
                jSONObject2.remove(DI.APP_INFO_NAME);
            } catch (JSONException unused) {
            }
        }
    }

    public JSONObject e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("os", this.f12258a.f12267a);
                jSONObject2.putOpt("osversion", this.f12258a.f12268b);
                jSONObject2.putOpt("model", this.f12258a.f12272f);
                jSONObject2.putOpt("deviceType", this.f12258a.f12270d);
                jSONObject2.putOpt("sdk", this.f12258a.f12271e + "");
                jSONObject2.putOpt("brand", this.f12258a.f12269c);
                jSONObject2.putOpt("screen", this.f12258a.f12273g);
                jSONObject2.putOpt("density", this.f12258a.f12274h + "");
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.putOpt("passId", this.f12259b.f12275a);
                jSONObject.putOpt("userInfo", jSONObject3);
                jSONObject.putOpt(ConstantHelper.LOG_OS, jSONObject2);
                jSONObject.putOpt("appVersion", this.f12260c);
                jSONObject.putOpt("appBranch", this.f12261d);
                jSONObject.putOpt("appPackageName", this.f12262e);
                jSONObject.putOpt("cuid", this.f12263f);
                jSONObject.putOpt("uuid", this.f12264g);
                jSONObject.putOpt("hostName", this.f12265h);
                jSONObject.putOpt("net", this.f12266i);
                jSONObject.putOpt("operator", this.j);
                jSONObject.putOpt("smartAppId", this.k);
                jSONObject.putOpt("smartAppVersion", this.l);
                jSONObject.putOpt("swanCoreVersion", this.m);
                jSONObject.putOpt("swanNativeVersion", this.n);
                jSONObject.putOpt("swanType", this.o);
                jSONObject.putOpt("swanId", this.p);
                jSONObject.putOpt("bizId", this.r);
                jSONObject.putOpt("eventType", this.s);
                jSONObject.putOpt("eventName", this.t);
                jSONObject.putOpt("content", this.u);
                if (!TextUtils.isEmpty(this.q)) {
                    jSONObject.putOpt("appClientId", this.q);
                }
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
