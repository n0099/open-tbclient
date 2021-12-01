package c.a.p0.u;

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
import com.baidu.wallet.base.iddetect.UrlOcrConfig;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class r {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;

    /* renamed from: b  reason: collision with root package name */
    public b f11136b;

    /* renamed from: c  reason: collision with root package name */
    public String f11137c;

    /* renamed from: d  reason: collision with root package name */
    public String f11138d;

    /* renamed from: e  reason: collision with root package name */
    public String f11139e;

    /* renamed from: f  reason: collision with root package name */
    public String f11140f;

    /* renamed from: g  reason: collision with root package name */
    public String f11141g;

    /* renamed from: h  reason: collision with root package name */
    public String f11142h;

    /* renamed from: i  reason: collision with root package name */
    public String f11143i;

    /* renamed from: j  reason: collision with root package name */
    public String f11144j;

    /* renamed from: k  reason: collision with root package name */
    public String f11145k;
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

    /* loaded from: classes5.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f11146b;

        /* renamed from: c  reason: collision with root package name */
        public String f11147c;

        /* renamed from: d  reason: collision with root package name */
        public String f11148d;

        /* renamed from: e  reason: collision with root package name */
        public int f11149e;

        /* renamed from: f  reason: collision with root package name */
        public String f11150f;

        /* renamed from: g  reason: collision with root package name */
        public String f11151g;

        /* renamed from: h  reason: collision with root package name */
        public int f11152h;

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
            this.a = "Android";
            this.f11146b = Build.VERSION.RELEASE;
            this.f11147c = Build.MANUFACTURER;
            this.f11149e = Build.VERSION.SDK_INT;
            this.f11150f = Build.MODEL;
            Context appContext = AppRuntime.getAppContext();
            WindowManager windowManager = (WindowManager) appContext.getSystemService("window");
            this.f11151g = windowManager.getDefaultDisplay().getWidth() + "_" + windowManager.getDefaultDisplay().getHeight();
            this.f11152h = appContext.getResources().getDisplayMetrics().densityDpi;
        }
    }

    /* loaded from: classes5.dex */
    public final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

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
            this.a = e.g().v(AppRuntime.getAppContext());
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
        this.a = new a(this);
        this.f11136b = new b(this);
        this.f11143i = c.a.p0.v.a.c();
        this.o = "";
        Context appContext = AppRuntime.getAppContext();
        try {
            PackageInfo packageInfo = appContext.getPackageManager().getPackageInfo(appContext.getPackageName(), 0);
            this.f11137c = packageInfo.versionName;
            this.f11139e = packageInfo.packageName;
        } catch (PackageManager.NameNotFoundException unused) {
        }
        TelephonyManager telephonyManager = (TelephonyManager) AppRuntime.getAppContext().getSystemService("phone");
        if (telephonyManager != null && (Build.VERSION.SDK_INT < 23 || appContext.checkSelfPermission(com.kuaishou.weapon.un.s.f56838c) == 0)) {
            this.f11144j = telephonyManager.getSimOperator();
        }
        this.f11140f = e.g().getDeviceId(appContext);
        this.f11141g = e.g().p(appContext);
        this.f11142h = e.g().a();
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
                jSONObject2.putOpt(UrlOcrConfig.IdCardKey.OS, this.a.a);
                jSONObject2.putOpt("osversion", this.a.f11146b);
                jSONObject2.putOpt("model", this.a.f11150f);
                jSONObject2.putOpt("deviceType", this.a.f11148d);
                jSONObject2.putOpt("sdk", this.a.f11149e + "");
                jSONObject2.putOpt("brand", this.a.f11147c);
                jSONObject2.putOpt("screen", this.a.f11151g);
                jSONObject2.putOpt("density", this.a.f11152h + "");
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.putOpt("passId", this.f11136b.a);
                jSONObject.putOpt("userInfo", jSONObject3);
                jSONObject.putOpt(ConstantHelper.LOG_OS, jSONObject2);
                jSONObject.putOpt("appVersion", this.f11137c);
                jSONObject.putOpt("appBranch", this.f11138d);
                jSONObject.putOpt("appPackageName", this.f11139e);
                jSONObject.putOpt("cuid", this.f11140f);
                jSONObject.putOpt("uuid", this.f11141g);
                jSONObject.putOpt("hostName", this.f11142h);
                jSONObject.putOpt("net", this.f11143i);
                jSONObject.putOpt("operator", this.f11144j);
                jSONObject.putOpt("smartAppId", this.f11145k);
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
