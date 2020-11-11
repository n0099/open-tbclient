package com.baidu.location.b;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.ar.gesture.GestureAR;
import com.baidu.lbsapi.auth.LBSAuthManager;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.LocationClientOption;
import com.baidu.mobstat.Config;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    private static String o = "BDLocConfigManager";

    /* renamed from: a  reason: collision with root package name */
    public boolean f1863a;
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
    private SharedPreferences p;
    private long q;
    private String r;
    private C0244a s;
    private boolean t;
    private String u;
    private String v;
    private String w;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.location.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0244a extends com.baidu.location.e.f {

        /* renamed from: a  reason: collision with root package name */
        String f1864a = null;
        boolean b = false;

        public C0244a() {
            this.k = new HashMap();
        }

        @Override // com.baidu.location.e.f
        public void a() {
            this.i = 2;
            String encode = Jni.encode(this.f1864a);
            this.f1864a = null;
            this.k.put("qt", "conf");
            this.k.put("req", encode);
        }

        public void a(String str) {
            if (this.b) {
                return;
            }
            this.b = true;
            this.f1864a = str;
            b("https://loc.map.baidu.com/cfgs/loc/commcfgs");
        }

        @Override // com.baidu.location.e.f
        public void a(boolean z) {
            if (z && this.j != null) {
                try {
                    if (new JSONObject(this.j) != null && a.this.p != null) {
                        SharedPreferences.Editor edit = a.this.p.edit();
                        edit.putString(a.o + "_config", this.j);
                        edit.commit();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (this.k != null) {
                this.k.clear();
            }
            this.b = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f1865a = new a();
    }

    private a() {
        this.p = null;
        this.f1863a = false;
        this.b = 16;
        this.q = 300L;
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
        this.r = null;
        this.s = null;
        this.t = false;
        this.u = null;
        this.v = null;
        this.w = null;
    }

    public static a a() {
        return b.f1865a;
    }

    private String a(Context context) {
        int myPid = Process.myPid();
        String str = "";
        try {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningAppProcesses();
            if (runningAppProcesses != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    str = runningAppProcessInfo.pid == myPid ? runningAppProcessInfo.processName : str;
                }
            }
        } catch (Exception e) {
        }
        return str;
    }

    private void a(LocationClientOption locationClientOption) {
        String string;
        String str = "&ver=" + com.baidu.location.e.l.y + "&usr=" + c() + "&app=" + this.u + "&prod=" + locationClientOption.prodName + "&newwf=1";
        String str2 = Build.VERSION.RELEASE;
        if (str2 != null && str2.length() > 6) {
            str2 = str2.substring(0, 6);
        }
        String str3 = str + "&sv=" + str2;
        String b2 = com.baidu.location.e.l.b("ro.miui.ui.version.name");
        if (!TextUtils.isEmpty(b2)) {
            str3 = str3 + "&miui=" + b2;
        }
        String m = com.baidu.location.e.l.m();
        if (!TextUtils.isEmpty(m)) {
            str3 = str3 + "&mtk=" + m;
        }
        if (!TextUtils.isEmpty(this.p.getString(o + "_loc", null))) {
            try {
                str3 = str3 + "&loc=" + new String(Base64.decode(string, 0), "UTF-8");
            } catch (Exception e) {
            }
        }
        if (this.s == null) {
            this.s = new C0244a();
        }
        this.s.a(str3);
    }

    private void a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("is_check_Per") && jSONObject.getInt("is_check_Per") > 0) {
                this.f1863a = true;
            }
            if (jSONObject.has("wfnum")) {
                this.b = jSONObject.getInt("wfnum");
            }
            if (jSONObject.has("freq")) {
                this.q = jSONObject.getLong("freq");
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
            this.r = str;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String c() {
        return "v9.02|" + this.v + "|" + Build.MODEL + "&cu=" + this.v + "&mb=" + Build.MODEL;
    }

    public synchronized void a(double d, double d2, String str) {
        if (this.w == null && str != null) {
            try {
                if (str.equals(BDLocation.BDLOCATION_GCJ02_TO_BD09) || str.equals("wgs84mc")) {
                    double[] coorEncrypt = Jni.coorEncrypt(d2, d, BDLocation.BDLOCATION_BD09_TO_GCJ02);
                    d = coorEncrypt[1];
                    d2 = coorEncrypt[0];
                }
                this.w = String.format(Locale.US, "%.5f|%.5f", Double.valueOf(d2), Double.valueOf(d));
                String encodeToString = Base64.encodeToString(this.w.getBytes("UTF-8"), 0);
                if (encodeToString != null && this.p != null) {
                    SharedPreferences.Editor edit = this.p.edit();
                    edit.putString(o + "_loc", encodeToString);
                    edit.commit();
                }
            } catch (Exception e) {
                this.w = null;
            }
        }
    }

    public synchronized void a(Context context, LocationClientOption locationClientOption) {
        if (!this.t && context != null) {
            this.t = true;
            if (locationClientOption == null) {
                locationClientOption = new LocationClientOption();
            }
            o += PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + a(context);
            this.u = context.getPackageName();
            this.v = LBSAuthManager.getInstance(context).getCUID();
            if (this.p == null) {
                this.p = context.getSharedPreferences(o + "BDLocConfig", 0);
            }
            if (this.p != null) {
                long j = this.p.getLong(o + "_lastCheckTime", 0L);
                String string = this.p.getString(o + "_config", "");
                if (!TextUtils.isEmpty(string)) {
                    a(string);
                }
                if (Math.abs((System.currentTimeMillis() / 1000) - j) > this.q) {
                    SharedPreferences.Editor edit = this.p.edit();
                    edit.putLong(o + "_lastCheckTime", System.currentTimeMillis() / 1000);
                    edit.commit();
                    a(locationClientOption);
                }
            }
        }
    }

    public void a(JSONObject jSONObject) {
        JSONArray jSONArray;
        int i = 0;
        if (jSONObject != null) {
            if (this.m != null && this.m.length > 0) {
                this.m = null;
            }
            try {
                if (!jSONObject.has("bcar") || (jSONArray = jSONObject.getJSONArray("bcar")) == null || jSONArray.length() <= 0) {
                    return;
                }
                if (this.m == null) {
                    this.m = new double[jSONArray.length() * 4];
                }
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    int i3 = i + 1;
                    this.m[i] = jSONArray.getJSONObject(i2).getDouble(GestureAR.SDK_TO_LUA_GESTURE_RESULT_X1);
                    int i4 = i3 + 1;
                    this.m[i3] = jSONArray.getJSONObject(i2).getDouble(GestureAR.SDK_TO_LUA_GESTURE_RESULT_Y1);
                    int i5 = i4 + 1;
                    this.m[i4] = jSONArray.getJSONObject(i2).getDouble(GestureAR.SDK_TO_LUA_GESTURE_RESULT_X2);
                    i = i5 + 1;
                    this.m[i5] = jSONArray.getJSONObject(i2).getDouble(GestureAR.SDK_TO_LUA_GESTURE_RESULT_Y2);
                }
            } catch (Exception e) {
            }
        }
    }
}
