package b.a.a.a.x.f;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.preference.PreferenceManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import b.a.a.a.r;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.openid.sdk.FunOpenIDSdk;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public static volatile long s;
    public static volatile c t;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f1489a;

    /* renamed from: b  reason: collision with root package name */
    public String f1490b;

    /* renamed from: c  reason: collision with root package name */
    public String f1491c;

    /* renamed from: d  reason: collision with root package name */
    public String f1492d;

    /* renamed from: e  reason: collision with root package name */
    public String f1493e;

    /* renamed from: f  reason: collision with root package name */
    public String f1494f;

    /* renamed from: g  reason: collision with root package name */
    public String f1495g;

    /* renamed from: h  reason: collision with root package name */
    public String f1496h;

    /* renamed from: i  reason: collision with root package name */
    public String f1497i;

    /* renamed from: j  reason: collision with root package name */
    public String f1498j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public String r;

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

    public static c a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            if (t == null) {
                synchronized (c.class) {
                    if (t == null) {
                        t = new c();
                        Context appContext = FunAdSdk.getAppContext();
                        t.p = FunAdSdk.getFunAdConfig().userId;
                        t.o = FunAdSdk.getFunAdConfig().appId;
                        t.n = appContext.getResources().getConfiguration().locale.getLanguage();
                        t.l = FunOpenIDSdk.getAndroidId(appContext);
                        t.c(appContext);
                        c cVar = t;
                        if (cVar != null) {
                            a aVar = new a(cVar);
                            synchronized (a.a.a.a.w.f.f1024c) {
                                a.a.a.a.w.f.f1024c.add(aVar);
                            }
                            aVar.a(a.a.a.a.w.f.f1023b);
                            String imei = FunOpenIDSdk.getImei(appContext);
                            if (!TextUtils.isEmpty(imei)) {
                                t.q = FunOpenIDSdk.getMD5(imei);
                            }
                            String imeiNew = FunOpenIDSdk.getImeiNew(appContext);
                            if (!TextUtils.isEmpty(imeiNew)) {
                                t.r = FunOpenIDSdk.getMD5(imeiNew);
                            }
                            FunOpenIDSdk.getOaid(appContext, new b());
                            if (FunAdSdk.isLogEnabled()) {
                                b.a.a.a.x.d.b(t.toString(), new Object[0]);
                            }
                        } else {
                            throw null;
                        }
                    }
                }
            }
            c cVar2 = t;
            jSONObject.put("app", cVar2.f1489a);
            jSONObject.put("appv", cVar2.f1491c);
            jSONObject.put("appvn", cVar2.f1490b);
            jSONObject.put("net", cVar2.f1492d);
            jSONObject.put("manu", cVar2.f1493e);
            jSONObject.put("model", cVar2.f1494f);
            jSONObject.put("sysv", cVar2.f1495g);
            jSONObject.put("h", cVar2.f1496h);
            jSONObject.put("w", cVar2.f1497i);
            jSONObject.put("locale", cVar2.n);
            jSONObject.put("opcode", cVar2.f1498j);
            jSONObject.put("tk", cVar2.k);
            jSONObject.put("sdkvn", "3.6.4.4-TB");
            jSONObject.put("sdkv", 3644);
            jSONObject.put("anid", cVar2.l);
            jSONObject.put("lic", cVar2.o);
            jSONObject.put("plat", "a");
            jSONObject.put("oaid", cVar2.m);
            jSONObject.put(DpStatConstants.KEY_USER_ID, cVar2.p);
            jSONObject.put("iid", cVar2.q);
            jSONObject.put("iidn", cVar2.r);
            jSONObject.put("cfgv", s);
            return cVar2;
        }
        return (c) invokeL.objValue;
    }

    public static JSONObject b(String str, JSONObject jSONObject, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{str, jSONObject, Long.valueOf(j2)})) == null) {
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
        return (JSONObject) invokeCommon.objValue;
    }

    public static void d(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, jSONObject) == null) {
            c a2 = a(jSONObject);
            long currentTimeMillis = System.currentTimeMillis();
            String str = a2.k + a2.f1489a + a2.f1490b + a2.n + currentTimeMillis + "c643144089d135c383c4c87f1df87a9d4ccc1c0f70cee0a5f78fd32d475f1a49";
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(str.getBytes());
                byte[] digest = messageDigest.digest();
                int length = digest.length;
                StringBuffer stringBuffer = new StringBuffer(length * 2);
                int i2 = length + 0;
                for (int i3 = 0; i3 < i2; i3++) {
                    byte b2 = digest[i3];
                    char[] cArr = b.a.a.a.x.e.f1487a;
                    char c2 = cArr[(b2 & 240) >> 4];
                    char c3 = cArr[b2 & 15];
                    stringBuffer.append(c2);
                    stringBuffer.append(c3);
                }
                str = stringBuffer.toString();
            } catch (NoSuchAlgorithmException e2) {
                b.a.a.a.x.d.c(e2);
            }
            jSONObject.put("ts", currentTimeMillis);
            jSONObject.put("vc", str);
        }
    }

    public final void c(Context context) {
        DisplayMetrics displayMetrics;
        String substring;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            PackageManager packageManager = context.getPackageManager();
            this.f1489a = context.getPackageName();
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
                this.f1489a = packageInfo.packageName;
                this.f1490b = packageInfo.versionName;
                this.f1491c = String.valueOf(packageInfo.versionCode);
            } catch (PackageManager.NameNotFoundException unused) {
            }
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                String networkOperator = telephonyManager.getNetworkOperator();
                if (!TextUtils.isEmpty(networkOperator)) {
                    this.f1498j = networkOperator;
                }
            }
            this.f1493e = Build.MANUFACTURER;
            this.f1494f = Build.MODEL;
            this.f1495g = String.valueOf(Build.VERSION.SDK_INT);
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager == null) {
                displayMetrics = context.getResources().getDisplayMetrics();
            } else {
                Display defaultDisplay = windowManager.getDefaultDisplay();
                DisplayMetrics displayMetrics2 = new DisplayMetrics();
                defaultDisplay.getMetrics(displayMetrics2);
                displayMetrics = displayMetrics2;
            }
            this.f1496h = String.valueOf(displayMetrics.heightPixels);
            this.f1497i = String.valueOf(displayMetrics.widthPixels);
            if (TextUtils.isEmpty(r.f1150a)) {
                SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(FunAdSdk.getAppContext());
                String string = defaultSharedPreferences.getString("u_tok", "");
                if (TextUtils.isEmpty(string)) {
                    string = UUID.randomUUID().toString();
                    try {
                        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                        messageDigest.update(string.getBytes(Charset.forName("UTF-8")));
                        substring = Base64.encodeToString(messageDigest.digest(), 2);
                    } catch (Throwable unused2) {
                        if (string.length() >= 24) {
                            substring = string.substring(0, 24);
                        }
                    }
                    string = substring;
                    defaultSharedPreferences.edit().putString("u_tok", string).apply();
                }
                r.f1150a = string;
            }
            this.k = r.f1150a;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "HostAppInfo{packageName='" + this.f1489a + ExtendedMessageFormat.QUOTE + ", versionName='" + this.f1490b + ExtendedMessageFormat.QUOTE + ", versionCode='" + this.f1491c + ExtendedMessageFormat.QUOTE + ", networkTypeName='" + this.f1492d + ExtendedMessageFormat.QUOTE + ", manufacturer='" + this.f1493e + ExtendedMessageFormat.QUOTE + ", model='" + this.f1494f + ExtendedMessageFormat.QUOTE + ", osVersion='" + this.f1495g + ExtendedMessageFormat.QUOTE + ", h='" + this.f1496h + ExtendedMessageFormat.QUOTE + ", w='" + this.f1497i + ExtendedMessageFormat.QUOTE + ", opcode='" + this.f1498j + ExtendedMessageFormat.QUOTE + ", token='" + this.k + ExtendedMessageFormat.QUOTE + ", anid='" + this.l + ExtendedMessageFormat.QUOTE + ", oaid='" + this.m + ExtendedMessageFormat.QUOTE + ", locale='" + this.n + ExtendedMessageFormat.QUOTE + ", lic='" + this.o + ExtendedMessageFormat.QUOTE + ", userId='" + this.p + ExtendedMessageFormat.QUOTE + ", imei='" + this.q + ExtendedMessageFormat.QUOTE + ", imeiNew='" + this.r + ExtendedMessageFormat.QUOTE + ", cfgv='" + s + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
