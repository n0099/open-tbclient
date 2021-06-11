package a.a.a.a.y.f;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Process;
import android.preference.PreferenceManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.baidu.common.param.CommonUrlParamManager;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.bumptech.glide.manager.DefaultConnectivityMonitorFactory;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.openid.sdk.FunOpenIDSdk;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static String f1372a;

    /* renamed from: b  reason: collision with root package name */
    public static String f1373b;

    /* renamed from: c  reason: collision with root package name */
    public static String f1374c;

    /* renamed from: d  reason: collision with root package name */
    public static String f1375d;

    /* renamed from: e  reason: collision with root package name */
    public static String f1376e;

    /* renamed from: f  reason: collision with root package name */
    public static String f1377f;

    /* renamed from: g  reason: collision with root package name */
    public static String f1378g;

    /* renamed from: h  reason: collision with root package name */
    public static String f1379h;

    /* renamed from: i  reason: collision with root package name */
    public static String f1380i;
    public static String j;
    public static String k;
    public static String l;
    public static String m;
    public static c n;
    public static String o;
    public static String p;
    public static String q;
    public static String r;
    public static String s;
    public static long t;
    public static BroadcastReceiver u;

    public c(Context context) {
        o = context.getResources().getConfiguration().locale.getLanguage();
    }

    public static JSONObject a(String str, JSONObject jSONObject, long j2) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            a(jSONObject2);
            jSONObject2.put("key", str);
            jSONObject2.put("content", jSONObject);
            jSONObject2.put("occur_t", j2);
            jSONObject2.put("retry_i", 0);
        } catch (JSONException unused) {
        }
        return jSONObject2;
    }

    public static void a(Context context, Intent intent) {
        if (intent == null || context.checkPermission(DefaultConnectivityMonitorFactory.NETWORK_PERMISSION, Process.myPid(), Process.myUid()) != 0) {
            f1375d = "unknow";
            return;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            f1375d = "unknow";
            return;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        a.a.a.a.y.d.a("activeNetworkInfo:" + activeNetworkInfo, new Object[0]);
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting()) {
            f1375d = "unknow";
            return;
        }
        String subtypeName = activeNetworkInfo.getSubtypeName();
        if (TextUtils.isEmpty(subtypeName)) {
            f1375d = activeNetworkInfo.getTypeName();
        } else {
            f1375d = subtypeName;
        }
    }

    public static void a(JSONObject jSONObject) {
        DisplayMetrics displayMetrics;
        if (n == null) {
            synchronized (c.class) {
                Context appContext = FunAdSdk.getAppContext();
                q = FunAdSdk.getFunAdConfig().userId;
                p = FunAdSdk.getFunAdConfig().appId;
                n = new c(appContext);
                l = FunOpenIDSdk.getAndroidId(appContext);
                PackageManager packageManager = appContext.getPackageManager();
                f1372a = appContext.getPackageName();
                try {
                    PackageInfo packageInfo = packageManager.getPackageInfo(appContext.getPackageName(), 0);
                    f1372a = packageInfo.packageName;
                    f1373b = packageInfo.versionName;
                    f1374c = String.valueOf(packageInfo.versionCode);
                } catch (PackageManager.NameNotFoundException unused) {
                }
                TelephonyManager telephonyManager = (TelephonyManager) appContext.getSystemService("phone");
                if (telephonyManager != null) {
                    String networkOperator = telephonyManager.getNetworkOperator();
                    if (!TextUtils.isEmpty(networkOperator)) {
                        j = networkOperator;
                    }
                }
                f1376e = Build.MANUFACTURER;
                f1377f = Build.MODEL;
                f1378g = String.valueOf(Build.VERSION.SDK_INT);
                WindowManager windowManager = (WindowManager) appContext.getSystemService("window");
                if (windowManager == null) {
                    displayMetrics = appContext.getResources().getDisplayMetrics();
                } else {
                    Display defaultDisplay = windowManager.getDefaultDisplay();
                    DisplayMetrics displayMetrics2 = new DisplayMetrics();
                    defaultDisplay.getMetrics(displayMetrics2);
                    displayMetrics = displayMetrics2;
                }
                f1379h = String.valueOf(displayMetrics.heightPixels);
                f1380i = String.valueOf(displayMetrics.widthPixels);
                if (TextUtils.isEmpty(a.a.a.a.a.f998a)) {
                    SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(FunAdSdk.getAppContext());
                    String string = defaultSharedPreferences.getString("u_tok", "");
                    if (TextUtils.isEmpty(string)) {
                        String uuid = UUID.randomUUID().toString();
                        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                        messageDigest.update(uuid.getBytes(Charset.forName("UTF-8")));
                        string = Base64.encodeToString(messageDigest.digest(), 2);
                        defaultSharedPreferences.edit().putString("u_tok", string).apply();
                    }
                    a.a.a.a.a.f998a = string;
                }
                k = a.a.a.a.a.f998a;
                if (u == null) {
                    b bVar = new b();
                    u = bVar;
                    a(appContext, appContext.registerReceiver(bVar, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE")));
                }
                String imei = FunOpenIDSdk.getImei(appContext);
                if (!TextUtils.isEmpty(imei)) {
                    r = FunOpenIDSdk.getMD5(imei);
                }
                String imeiNew = FunOpenIDSdk.getImeiNew(appContext);
                if (!TextUtils.isEmpty(imeiNew)) {
                    s = FunOpenIDSdk.getMD5(imeiNew);
                }
                FunOpenIDSdk.getOaid(appContext, new a());
                if (FunAdSdk.isLogEnabled()) {
                    a.a.a.a.y.d.a("HostAppInfo:>>>>\nw\t:%s\nh\t:%s\nmodel\t:%s\nmanu\t:%s\nsysv\t:%s\nlocale\t:%s\nopcode\t:%s\nnet\t:%s\nsdkvn\t:%s\nsdkv\t:%d\nappv\t:%s\nappvn\t:%s\nanid\t:%s\nlic\t:%s\napp\t:%s\nplat\t:%s\noaid\t:%s\ntk\t:%s\nuserId:\t:%s\nimei:\t%s\nimeiNew:\t%s\ncfgv:\t%d\n", f1379h, f1380i, f1377f, f1376e, f1378g, o, j, f1375d, "3.5.0.2-TB", 3502, f1374c, f1373b, l, p, f1372a, "a", m, k, q, r, s, Long.valueOf(t));
                }
            }
        }
        jSONObject.put("app", f1372a);
        jSONObject.put("appv", f1374c);
        jSONObject.put("appvn", f1373b);
        jSONObject.put("net", f1375d);
        jSONObject.put("manu", f1376e);
        jSONObject.put("model", f1377f);
        jSONObject.put("sysv", f1378g);
        jSONObject.put("h", f1379h);
        jSONObject.put("w", f1380i);
        jSONObject.put("locale", o);
        jSONObject.put("opcode", j);
        jSONObject.put("tk", k);
        jSONObject.put("sdkvn", "3.5.0.2-TB");
        jSONObject.put("sdkv", 3502);
        jSONObject.put("anid", l);
        jSONObject.put("lic", p);
        jSONObject.put("plat", "a");
        jSONObject.put("oaid", m);
        jSONObject.put(DpStatConstants.KEY_USER_ID, q);
        jSONObject.put(CommonUrlParamManager.PARAM_IID, r);
        jSONObject.put("iidn", s);
        jSONObject.put("cfgv", t);
    }

    public static void b(JSONObject jSONObject) {
        a(jSONObject);
        long currentTimeMillis = System.currentTimeMillis();
        String str = k + f1372a + f1373b + o + currentTimeMillis + "c643144089d135c383c4c87f1df87a9d4ccc1c0f70cee0a5f78fd32d475f1a49";
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            int length = digest.length;
            StringBuffer stringBuffer = new StringBuffer(length * 2);
            int i2 = length + 0;
            for (int i3 = 0; i3 < i2; i3++) {
                byte b2 = digest[i3];
                char[] cArr = a.a.a.a.y.e.f1371a;
                char c2 = cArr[(b2 & 240) >> 4];
                char c3 = cArr[b2 & 15];
                stringBuffer.append(c2);
                stringBuffer.append(c3);
            }
            str = stringBuffer.toString();
        } catch (NoSuchAlgorithmException e2) {
            a.a.a.a.y.d.a(e2);
        }
        jSONObject.put("ts", currentTimeMillis);
        jSONObject.put("vc", str);
    }
}
