package com.baidu.location.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.gesture.GestureAR;
import com.baidu.lbsapi.auth.LBSAuthManager;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.LocationClientOption;
import com.baidu.mobstat.Config;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static String q = "BDLocConfigManager";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public int b;
    public double c;
    public int d;
    public int e;
    public double f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public double[] m;
    public int n;
    public int o;
    public int p;
    public SharedPreferences r;
    public long s;
    public String t;
    public C0097a u;
    public boolean v;
    public String w;
    public String x;
    public String y;

    /* renamed from: com.baidu.location.b.a$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: com.baidu.location.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0097a extends com.baidu.location.e.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public boolean b;
        public final /* synthetic */ a c;

        public C0097a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = aVar;
            this.a = null;
            this.b = false;
            this.j = new HashMap();
        }

        @Override // com.baidu.location.e.f
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.h = 2;
                String encode = Jni.encode(this.a);
                this.a = null;
                this.j.put("qt", "conf");
                this.j.put("req", encode);
            }
        }

        public void a(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || this.b) {
                return;
            }
            this.b = true;
            this.a = str;
            b(com.baidu.location.e.d.d);
        }

        @Override // com.baidu.location.e.f
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                if (z && this.i != null) {
                    try {
                        new JSONObject(this.i);
                        if (this.c.r != null) {
                            SharedPreferences.Editor edit = this.c.r.edit();
                            String encodeToString = Base64.encodeToString(com.baidu.location.e.k.a(this.i.getBytes()), 0);
                            edit.putString(a.q + "_newConfig", encodeToString);
                            edit.apply();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                Map<String, Object> map = this.j;
                if (map != null) {
                    map.clear();
                }
                this.b = false;
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final a a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(819643285, "Lcom/baidu/location/b/a$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(819643285, "Lcom/baidu/location/b/a$b;");
                    return;
                }
            }
            a = new a(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1037723283, "Lcom/baidu/location/b/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1037723283, "Lcom/baidu/location/b/a;");
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.r = null;
        this.a = false;
        this.b = 16;
        this.s = 300L;
        this.c = 0.75d;
        this.d = 0;
        this.e = 1;
        this.f = -0.10000000149011612d;
        this.g = 0;
        this.h = 1;
        this.i = 1;
        this.j = 10;
        this.k = 3;
        this.l = 40;
        this.n = 1;
        this.o = 0;
        this.p = 1;
        this.t = null;
        this.u = null;
        this.v = false;
        this.w = null;
        this.x = null;
        this.y = null;
    }

    public /* synthetic */ a(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? b.a : (a) invokeV.objValue;
    }

    private void a(LocationClientOption locationClientOption) {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, locationClientOption) == null) {
            String str = "&ver=" + com.baidu.location.e.k.x + "&usr=" + c() + "&app=" + this.w + "&prod=" + locationClientOption.prodName + "&newwf=1";
            String str2 = Build.VERSION.RELEASE;
            if (str2 != null && str2.length() > 6) {
                str2 = str2.substring(0, 6);
            }
            String str3 = str + "&sv=" + str2;
            String c = com.baidu.location.e.k.c("ro.miui.ui.version.name");
            if (!TextUtils.isEmpty(c)) {
                str3 = str3 + "&miui=" + c;
            }
            String j = com.baidu.location.e.k.j();
            if (!TextUtils.isEmpty(j)) {
                str3 = str3 + "&mtk=" + j;
            }
            if (!TextUtils.isEmpty(this.r.getString(q + "_loc", null))) {
                try {
                    str3 = str3 + "&loc=" + new String(Base64.decode(string, 0), "UTF-8");
                } catch (Exception unused) {
                }
            }
            if (this.u == null) {
                this.u = new C0097a(this);
            }
            this.u.a(str3);
        }
    }

    private void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, str) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("is_check_Per") && jSONObject.getInt("is_check_Per") > 0) {
                    this.a = true;
                }
                if (jSONObject.has("wfnum")) {
                    this.b = jSONObject.getInt("wfnum");
                }
                if (jSONObject.has("freq")) {
                    this.s = jSONObject.getLong("freq");
                }
                if (jSONObject.has("wfsm")) {
                    this.c = jSONObject.getDouble("wfsm");
                }
                if (jSONObject.has("idmoc")) {
                    this.d = jSONObject.getInt("idmoc");
                }
                if (jSONObject.has("gnmcrm")) {
                    this.f = jSONObject.getDouble("gnmcrm");
                }
                if (jSONObject.has("gnmcon")) {
                    this.g = jSONObject.getInt("gnmcon");
                }
                if (jSONObject.has("lpcs")) {
                    this.e = jSONObject.getInt("lpcs");
                }
                if (jSONObject.has("iupl")) {
                    this.h = jSONObject.getInt("iupl");
                }
                if (jSONObject.has("opetco")) {
                    this.i = jSONObject.getInt("opetco");
                }
                if (jSONObject.has(Config.EXCEPTION_CRASH_TYPE)) {
                    this.j = jSONObject.getInt(Config.EXCEPTION_CRASH_TYPE);
                }
                if (jSONObject.has("suci")) {
                    this.k = jSONObject.getInt("suci");
                }
                if (jSONObject.has("smn")) {
                    this.l = jSONObject.getInt("smn");
                }
                if (jSONObject.has("bcar")) {
                    a(jSONObject);
                }
                if (jSONObject.has("ums")) {
                    this.n = jSONObject.getInt("ums");
                }
                if (jSONObject.has("hpdts")) {
                    this.o = jSONObject.getInt("hpdts");
                }
                if (jSONObject.has("oldts")) {
                    this.p = jSONObject.getInt("oldts");
                }
                this.t = str;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            return "v9.363|" + this.x + "|" + Build.MODEL + "&cu=" + this.x + "&mb=" + Build.MODEL;
        }
        return (String) invokeV.objValue;
    }

    public synchronized void a(double d, double d2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Double.valueOf(d), Double.valueOf(d2), str}) == null) {
            synchronized (this) {
                if (this.y == null && str != null) {
                    try {
                        if (str.equals("bd09") || str.equals("wgs84mc")) {
                            double[] coorEncrypt = Jni.coorEncrypt(d2, d, BDLocation.BDLOCATION_BD09_TO_GCJ02);
                            double d3 = coorEncrypt[1];
                            double d4 = coorEncrypt[0];
                            d = d3;
                            d2 = d4;
                        }
                        String format = String.format(Locale.US, "%.5f|%.5f", Double.valueOf(d2), Double.valueOf(d));
                        this.y = format;
                        String encodeToString = Base64.encodeToString(format.getBytes("UTF-8"), 0);
                        if (encodeToString != null && this.r != null) {
                            SharedPreferences.Editor edit = this.r.edit();
                            edit.putString(q + "_loc", encodeToString);
                            edit.apply();
                        }
                    } catch (Exception unused) {
                        this.y = null;
                    }
                }
            }
        }
    }

    public synchronized void a(Context context, LocationClientOption locationClientOption, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, locationClientOption, str) == null) {
            synchronized (this) {
                if (!this.v && context != null) {
                    this.v = true;
                    if (locationClientOption == null) {
                        locationClientOption = new LocationClientOption();
                    }
                    this.w = context.getPackageName();
                    this.x = LBSAuthManager.getInstance(context).getCUID();
                    if (this.r == null) {
                        this.r = context.getSharedPreferences(q + "BDLocConfig", 0);
                    }
                    if (this.r != null) {
                        SharedPreferences sharedPreferences = this.r;
                        long j = sharedPreferences.getLong(q + "_lastCheckTime", 0L);
                        SharedPreferences sharedPreferences2 = this.r;
                        String string = sharedPreferences2.getString(q + "_config", "");
                        SharedPreferences sharedPreferences3 = this.r;
                        String string2 = sharedPreferences3.getString(q + "_newConfig", "");
                        if (!TextUtils.isEmpty(string2)) {
                            a(new String(com.baidu.location.e.k.b(Base64.decode(string2, 0))));
                        } else if (!TextUtils.isEmpty(string)) {
                            a(string);
                            SharedPreferences.Editor edit = this.r.edit();
                            edit.remove(q + "_config");
                            edit.apply();
                        }
                        if (Math.abs((System.currentTimeMillis() / 1000) - j) > this.s) {
                            SharedPreferences.Editor edit2 = this.r.edit();
                            edit2.putLong(q + "_lastCheckTime", System.currentTimeMillis() / 1000);
                            edit2.apply();
                            a(locationClientOption);
                        }
                    }
                }
            }
        }
    }

    public void a(JSONObject jSONObject) {
        JSONArray jSONArray;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        double[] dArr = this.m;
        if (dArr != null && dArr.length > 0) {
            this.m = null;
        }
        try {
            if (!jSONObject.has("bcar") || (jSONArray = jSONObject.getJSONArray("bcar")) == null || jSONArray.length() <= 0) {
                return;
            }
            if (this.m == null) {
                this.m = new double[jSONArray.length() * 4];
            }
            int i = 0;
            int i2 = 0;
            while (i < jSONArray.length()) {
                int i3 = i2 + 1;
                this.m[i2] = jSONArray.getJSONObject(i).getDouble(GestureAR.SDK_TO_LUA_GESTURE_RESULT_X1);
                int i4 = i3 + 1;
                this.m[i3] = jSONArray.getJSONObject(i).getDouble(GestureAR.SDK_TO_LUA_GESTURE_RESULT_Y1);
                int i5 = i4 + 1;
                this.m[i4] = jSONArray.getJSONObject(i).getDouble(GestureAR.SDK_TO_LUA_GESTURE_RESULT_X2);
                int i6 = i5 + 1;
                this.m[i5] = jSONArray.getJSONObject(i).getDouble(GestureAR.SDK_TO_LUA_GESTURE_RESULT_Y2);
                i++;
                i2 = i6;
            }
        } catch (Exception unused) {
        }
    }
}
