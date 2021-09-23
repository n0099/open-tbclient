package c.a.p0.r;

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
/* loaded from: classes3.dex */
public class r {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public a f12358a;

    /* renamed from: b  reason: collision with root package name */
    public b f12359b;

    /* renamed from: c  reason: collision with root package name */
    public String f12360c;

    /* renamed from: d  reason: collision with root package name */
    public String f12361d;

    /* renamed from: e  reason: collision with root package name */
    public String f12362e;

    /* renamed from: f  reason: collision with root package name */
    public String f12363f;

    /* renamed from: g  reason: collision with root package name */
    public String f12364g;

    /* renamed from: h  reason: collision with root package name */
    public String f12365h;

    /* renamed from: i  reason: collision with root package name */
    public String f12366i;

    /* renamed from: j  reason: collision with root package name */
    public String f12367j;
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

    /* loaded from: classes3.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f12368a;

        /* renamed from: b  reason: collision with root package name */
        public String f12369b;

        /* renamed from: c  reason: collision with root package name */
        public String f12370c;

        /* renamed from: d  reason: collision with root package name */
        public String f12371d;

        /* renamed from: e  reason: collision with root package name */
        public int f12372e;

        /* renamed from: f  reason: collision with root package name */
        public String f12373f;

        /* renamed from: g  reason: collision with root package name */
        public String f12374g;

        /* renamed from: h  reason: collision with root package name */
        public int f12375h;

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
            this.f12368a = "Android";
            this.f12369b = Build.VERSION.RELEASE;
            this.f12370c = Build.MANUFACTURER;
            this.f12372e = Build.VERSION.SDK_INT;
            this.f12373f = Build.MODEL;
            Context appContext = AppRuntime.getAppContext();
            WindowManager windowManager = (WindowManager) appContext.getSystemService("window");
            this.f12374g = windowManager.getDefaultDisplay().getWidth() + "_" + windowManager.getDefaultDisplay().getHeight();
            this.f12375h = appContext.getResources().getDisplayMetrics().densityDpi;
        }
    }

    /* loaded from: classes3.dex */
    public final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f12376a;

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
            this.f12376a = e.h().v(AppRuntime.getAppContext());
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
        this.f12358a = new a(this);
        this.f12359b = new b(this);
        this.f12366i = c.a.p0.s.a.c();
        this.o = "";
        Context appContext = AppRuntime.getAppContext();
        try {
            PackageInfo packageInfo = appContext.getPackageManager().getPackageInfo(appContext.getPackageName(), 0);
            this.f12360c = packageInfo.versionName;
            this.f12362e = packageInfo.packageName;
        } catch (PackageManager.NameNotFoundException unused) {
        }
        TelephonyManager telephonyManager = (TelephonyManager) AppRuntime.getAppContext().getSystemService("phone");
        if (telephonyManager != null && (Build.VERSION.SDK_INT < 23 || appContext.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0)) {
            this.f12367j = telephonyManager.getSimOperator();
        }
        this.f12363f = e.h().getDeviceId(appContext);
        this.f12364g = e.h().p(appContext);
        this.f12365h = e.h().a();
        this.n = e.h().b();
        this.q = e.h().t();
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
            if (e.h() == null) {
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
            l h2 = e.h();
            String str = "";
            if (jSONObject == null || h2 == null) {
                return "";
            }
            try {
                if (h2.l() == 0) {
                    str = "swan";
                } else if (h2.l() == 1) {
                    str = SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("smartAppId", h2.getAppId());
                jSONObject2.putOpt("smartAppVersion", h2.getAppVersion());
                jSONObject2.putOpt("swanCoreVersion", h2.n());
                jSONObject2.putOpt("swanNativeVersion", h2.b());
                jSONObject2.putOpt("swanType", str);
                jSONObject.putOpt(DI.APP_INFO_NAME, jSONObject2);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("source", h2.k());
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
                jSONObject2.putOpt("os", this.f12358a.f12368a);
                jSONObject2.putOpt("osversion", this.f12358a.f12369b);
                jSONObject2.putOpt("model", this.f12358a.f12373f);
                jSONObject2.putOpt("deviceType", this.f12358a.f12371d);
                jSONObject2.putOpt("sdk", this.f12358a.f12372e + "");
                jSONObject2.putOpt("brand", this.f12358a.f12370c);
                jSONObject2.putOpt("screen", this.f12358a.f12374g);
                jSONObject2.putOpt("density", this.f12358a.f12375h + "");
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.putOpt("passId", this.f12359b.f12376a);
                jSONObject.putOpt("userInfo", jSONObject3);
                jSONObject.putOpt(ConstantHelper.LOG_OS, jSONObject2);
                jSONObject.putOpt("appVersion", this.f12360c);
                jSONObject.putOpt("appBranch", this.f12361d);
                jSONObject.putOpt("appPackageName", this.f12362e);
                jSONObject.putOpt("cuid", this.f12363f);
                jSONObject.putOpt("uuid", this.f12364g);
                jSONObject.putOpt("hostName", this.f12365h);
                jSONObject.putOpt("net", this.f12366i);
                jSONObject.putOpt("operator", this.f12367j);
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
