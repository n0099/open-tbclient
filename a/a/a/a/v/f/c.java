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
import com.baidu.minivideo.plugin.capture.utils.EncryptUtils;
import com.fun.ad.sdk.FunAdSdk;
import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    public static c BP;
    public static BroadcastReceiver BQ;

    /* renamed from: a  reason: collision with root package name */
    public static String f1009a;
    public static String b;
    public static String c;
    public static String d;
    public static String e;
    public static String f;
    public static String g;
    public static String h;
    public static String i;
    public static String j;
    public static String k;
    public static String l;
    public static String m;
    public static String o;
    public static String p;
    public static String q;
    public static String r;
    public static String s;

    public c(Context context) {
        o = context.getResources().getConfiguration().locale.getLanguage();
    }

    public static void a(Context context, Intent intent) {
        if (intent == null || context.checkPermission("android.permission.ACCESS_NETWORK_STATE", Process.myPid(), Process.myUid()) != 0) {
            d = "unknow";
            return;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            d = "unknow";
            return;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        a.a.a.a.v.d.a("activeNetworkInfo:" + activeNetworkInfo, new Object[0]);
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting()) {
            d = "unknow";
            return;
        }
        String subtypeName = activeNetworkInfo.getSubtypeName();
        if (TextUtils.isEmpty(subtypeName)) {
            d = activeNetworkInfo.getTypeName();
        } else {
            d = subtypeName;
        }
    }

    public static void a(JSONObject jSONObject) {
        DisplayMetrics displayMetrics;
        if (BP == null) {
            synchronized (c.class) {
                Context appContext = FunAdSdk.getAppContext();
                q = FunAdSdk.getFunAdConfig().userId;
                p = FunAdSdk.getFunAdConfig().appId;
                BP = new c(appContext);
                l = com.fun.openid.sdk.b.getAndroidId(appContext);
                PackageManager packageManager = appContext.getPackageManager();
                f1009a = appContext.getPackageName();
                try {
                    PackageInfo packageInfo = packageManager.getPackageInfo(appContext.getPackageName(), 0);
                    f1009a = packageInfo.packageName;
                    b = packageInfo.versionName;
                    c = String.valueOf(packageInfo.versionCode);
                } catch (PackageManager.NameNotFoundException e2) {
                }
                TelephonyManager telephonyManager = (TelephonyManager) appContext.getSystemService("phone");
                if (telephonyManager != null) {
                    String networkOperator = telephonyManager.getNetworkOperator();
                    if (!TextUtils.isEmpty(networkOperator)) {
                        j = networkOperator;
                    }
                }
                e = Build.MANUFACTURER;
                f = Build.MODEL;
                g = String.valueOf(Build.VERSION.SDK_INT);
                WindowManager windowManager = (WindowManager) appContext.getSystemService("window");
                if (windowManager == null) {
                    displayMetrics = appContext.getResources().getDisplayMetrics();
                } else {
                    Display defaultDisplay = windowManager.getDefaultDisplay();
                    displayMetrics = new DisplayMetrics();
                    defaultDisplay.getMetrics(displayMetrics);
                }
                h = String.valueOf(displayMetrics.heightPixels);
                i = String.valueOf(displayMetrics.widthPixels);
                if (TextUtils.isEmpty(a.a.a.a.a.f951a)) {
                    SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(FunAdSdk.getAppContext());
                    String string = defaultSharedPreferences.getString("u_tok", "");
                    if (TextUtils.isEmpty(string)) {
                        String uuid = UUID.randomUUID().toString();
                        MessageDigest messageDigest = MessageDigest.getInstance(EncryptUtils.ENCRYPT_MD5);
                        messageDigest.update(uuid.getBytes(Charset.forName("UTF-8")));
                        string = Base64.encodeToString(messageDigest.digest(), 2);
                        defaultSharedPreferences.edit().putString("u_tok", string).apply();
                    }
                    a.a.a.a.a.f951a = string;
                }
                k = a.a.a.a.a.f951a;
                if (BQ == null) {
                    b bVar = new b();
                    BQ = bVar;
                    a(appContext, appContext.registerReceiver(bVar, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE")));
                }
                String imei = com.fun.openid.sdk.b.getImei(appContext);
                if (!TextUtils.isEmpty(imei)) {
                    r = com.fun.openid.sdk.b.getMD5(imei);
                }
                String in = com.fun.openid.sdk.b.in(appContext);
                if (!TextUtils.isEmpty(in)) {
                    s = com.fun.openid.sdk.b.getMD5(in);
                }
                com.fun.openid.sdk.b.a(appContext, new a());
                if (FunAdSdk.isLogEnabled()) {
                    a.a.a.a.v.d.a("HostAppInfo:>>>>\nw\t:%s\nh\t:%s\nmodel\t:%s\nmanu\t:%s\nsysv\t:%s\nlocale\t:%s\nopcode\t:%s\nnet\t:%s\nsdkvn\t:%s\nsdkv\t:%d\nappv\t:%s\nappvn\t:%s\nanid\t:%s\nlic\t:%s\napp\t:%s\nplat\t:%s\noaid\t:%s\ntk\t:%s\nuserId:\t:%s\nimei:\t%s\nimeiNew:\t%s\n", h, i, f, e, g, o, j, d, "3.2.2-TB", 330, c, b, l, p, f1009a, "a", m, k, q, r, s);
                }
            }
        }
        jSONObject.put("app", f1009a);
        jSONObject.put("appv", c);
        jSONObject.put("appvn", b);
        jSONObject.put("net", d);
        jSONObject.put("manu", e);
        jSONObject.put("model", f);
        jSONObject.put("sysv", g);
        jSONObject.put("h", h);
        jSONObject.put("w", i);
        jSONObject.put("locale", o);
        jSONObject.put("opcode", j);
        jSONObject.put("tk", k);
        jSONObject.put("sdkvn", "3.2.2-TB");
        jSONObject.put("sdkv", 330);
        jSONObject.put("anid", l);
        jSONObject.put("lic", p);
        jSONObject.put("plat", "a");
        jSONObject.put("oaid", m);
        jSONObject.put(DpStatConstants.KEY_USER_ID, q);
        jSONObject.put("iid", r);
        jSONObject.put("iidn", s);
        jSONObject.put("cfgv", a.a.a.a.v.b.f1006a.getLong("key_config_v", 0L));
    }

    public static void b(JSONObject jSONObject) {
        a(jSONObject);
        long currentTimeMillis = System.currentTimeMillis();
        String str = k + f1009a + b + o + currentTimeMillis + "c643144089d135c383c4c87f1df87a9d4ccc1c0f70cee0a5f78fd32d475f1a49";
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(EncryptUtils.ENCRYPT_MD5);
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            int length = digest.length;
            StringBuffer stringBuffer = new StringBuffer(length * 2);
            int i2 = length + 0;
            for (int i3 = 0; i3 < i2; i3++) {
                byte b2 = digest[i3];
                char[] cArr = a.a.a.a.v.e.f1008a;
                char c2 = cArr[(b2 & 240) >> 4];
                char c3 = cArr[b2 & 15];
                stringBuffer.append(c2);
                stringBuffer.append(c3);
            }
            str = stringBuffer.toString();
        } catch (NoSuchAlgorithmException e2) {
            a.a.a.a.v.d.a(e2);
        }
        jSONObject.put(TimeDisplaySetting.TIME_DISPLAY_SETTING, currentTimeMillis);
        jSONObject.put("vc", str);
    }
}
