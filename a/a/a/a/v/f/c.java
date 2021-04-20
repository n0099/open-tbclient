package a.a.a.a.v.f;

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
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.bumptech.glide.manager.DefaultConnectivityMonitorFactory;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.openid.sdk.FunOpenIDSdk;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static String f1349a;

    /* renamed from: b  reason: collision with root package name */
    public static String f1350b;

    /* renamed from: c  reason: collision with root package name */
    public static String f1351c;

    /* renamed from: d  reason: collision with root package name */
    public static String f1352d;

    /* renamed from: e  reason: collision with root package name */
    public static String f1353e;

    /* renamed from: f  reason: collision with root package name */
    public static String f1354f;

    /* renamed from: g  reason: collision with root package name */
    public static String f1355g;

    /* renamed from: h  reason: collision with root package name */
    public static String f1356h;
    public static String i;
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
    public static BroadcastReceiver t;

    public c(Context context) {
        o = context.getResources().getConfiguration().locale.getLanguage();
    }

    public static void a(Context context, Intent intent) {
        if (intent == null || context.checkPermission(DefaultConnectivityMonitorFactory.NETWORK_PERMISSION, Process.myPid(), Process.myUid()) != 0) {
            f1352d = "unknow";
            return;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            f1352d = "unknow";
            return;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        a.a.a.a.v.d.a("activeNetworkInfo:" + activeNetworkInfo, new Object[0]);
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting()) {
            f1352d = "unknow";
            return;
        }
        String subtypeName = activeNetworkInfo.getSubtypeName();
        if (TextUtils.isEmpty(subtypeName)) {
            f1352d = activeNetworkInfo.getTypeName();
        } else {
            f1352d = subtypeName;
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
                f1349a = appContext.getPackageName();
                try {
                    PackageInfo packageInfo = packageManager.getPackageInfo(appContext.getPackageName(), 0);
                    f1349a = packageInfo.packageName;
                    f1350b = packageInfo.versionName;
                    f1351c = String.valueOf(packageInfo.versionCode);
                } catch (PackageManager.NameNotFoundException unused) {
                }
                TelephonyManager telephonyManager = (TelephonyManager) appContext.getSystemService("phone");
                if (telephonyManager != null) {
                    String networkOperator = telephonyManager.getNetworkOperator();
                    if (!TextUtils.isEmpty(networkOperator)) {
                        j = networkOperator;
                    }
                }
                f1353e = Build.MANUFACTURER;
                f1354f = Build.MODEL;
                f1355g = String.valueOf(Build.VERSION.SDK_INT);
                WindowManager windowManager = (WindowManager) appContext.getSystemService("window");
                if (windowManager == null) {
                    displayMetrics = appContext.getResources().getDisplayMetrics();
                } else {
                    Display defaultDisplay = windowManager.getDefaultDisplay();
                    DisplayMetrics displayMetrics2 = new DisplayMetrics();
                    defaultDisplay.getMetrics(displayMetrics2);
                    displayMetrics = displayMetrics2;
                }
                f1356h = String.valueOf(displayMetrics.heightPixels);
                i = String.valueOf(displayMetrics.widthPixels);
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
                if (t == null) {
                    b bVar = new b();
                    t = bVar;
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
                    a.a.a.a.v.d.a("HostAppInfo:>>>>\nw\t:%s\nh\t:%s\nmodel\t:%s\nmanu\t:%s\nsysv\t:%s\nlocale\t:%s\nopcode\t:%s\nnet\t:%s\nsdkvn\t:%s\nsdkv\t:%d\nappv\t:%s\nappvn\t:%s\nanid\t:%s\nlic\t:%s\napp\t:%s\nplat\t:%s\noaid\t:%s\ntk\t:%s\nuserId:\t:%s\nimei:\t%s\nimeiNew:\t%s\n", f1356h, i, f1354f, f1353e, f1355g, o, j, f1352d, "3.2.6-TB", 334, f1351c, f1350b, l, p, f1349a, "a", m, k, q, r, s);
                }
            }
        }
        jSONObject.put("app", f1349a);
        jSONObject.put("appv", f1351c);
        jSONObject.put("appvn", f1350b);
        jSONObject.put("net", f1352d);
        jSONObject.put("manu", f1353e);
        jSONObject.put("model", f1354f);
        jSONObject.put("sysv", f1355g);
        jSONObject.put("h", f1356h);
        jSONObject.put("w", i);
        jSONObject.put("locale", o);
        jSONObject.put("opcode", j);
        jSONObject.put("tk", k);
        jSONObject.put("sdkvn", "3.2.6-TB");
        jSONObject.put("sdkv", 334);
        jSONObject.put("anid", l);
        jSONObject.put("lic", p);
        jSONObject.put("plat", "a");
        jSONObject.put("oaid", m);
        jSONObject.put(DpStatConstants.KEY_USER_ID, q);
        jSONObject.put("iid", r);
        jSONObject.put("iidn", s);
        jSONObject.put("cfgv", a.a.a.a.v.b.f1345a.getLong("key_config_v", 0L));
    }

    public static void b(JSONObject jSONObject) {
        a(jSONObject);
        long currentTimeMillis = System.currentTimeMillis();
        String str = k + f1349a + f1350b + o + currentTimeMillis + "c643144089d135c383c4c87f1df87a9d4ccc1c0f70cee0a5f78fd32d475f1a49";
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            int length = digest.length;
            StringBuffer stringBuffer = new StringBuffer(length * 2);
            int i2 = length + 0;
            for (int i3 = 0; i3 < i2; i3++) {
                byte b2 = digest[i3];
                char[] cArr = a.a.a.a.v.e.f1348a;
                char c2 = cArr[(b2 & 240) >> 4];
                char c3 = cArr[b2 & 15];
                stringBuffer.append(c2);
                stringBuffer.append(c3);
            }
            str = stringBuffer.toString();
        } catch (NoSuchAlgorithmException e2) {
            a.a.a.a.v.d.a(e2);
        }
        jSONObject.put("ts", currentTimeMillis);
        jSONObject.put("vc", str);
    }
}
