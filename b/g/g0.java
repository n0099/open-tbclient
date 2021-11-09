package b.g;

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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.BuildConfig;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.fun.m0;
import com.fun.openid.sdk.FunOpenIDSdk;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.UUID;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class g0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile long s;
    public static volatile g0 t;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f31148a;

    /* renamed from: b  reason: collision with root package name */
    public String f31149b;

    /* renamed from: c  reason: collision with root package name */
    public String f31150c;

    /* renamed from: d  reason: collision with root package name */
    public String f31151d;

    /* renamed from: e  reason: collision with root package name */
    public String f31152e;

    /* renamed from: f  reason: collision with root package name */
    public String f31153f;

    /* renamed from: g  reason: collision with root package name */
    public String f31154g;

    /* renamed from: h  reason: collision with root package name */
    public String f31155h;

    /* renamed from: i  reason: collision with root package name */
    public String f31156i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public String r;

    public g0() {
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

    public static g0 a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            if (t == null) {
                synchronized (g0.class) {
                    if (t == null) {
                        t = new g0();
                        Context appContext = FunAdSdk.getAppContext();
                        t.p = FunAdSdk.getFunAdConfig().userId;
                        t.o = FunAdSdk.getFunAdConfig().appId;
                        t.n = appContext.getResources().getConfiguration().locale.getLanguage();
                        t.l = FunOpenIDSdk.getAndroidId(appContext);
                        t.c(appContext);
                        g0 g0Var = t;
                        g0Var.getClass();
                        b0 b0Var = new b0(g0Var);
                        HashSet<m0.b> hashSet = com.fun.m0.f62865b;
                        synchronized (hashSet) {
                            hashSet.add(b0Var);
                        }
                        b0Var.a(com.fun.m0.f62864a);
                        String imei = FunOpenIDSdk.getImei(appContext);
                        if (!TextUtils.isEmpty(imei)) {
                            t.q = FunOpenIDSdk.getMD5(imei);
                        }
                        String imeiNew = FunOpenIDSdk.getImeiNew(appContext);
                        if (!TextUtils.isEmpty(imeiNew)) {
                            t.r = FunOpenIDSdk.getMD5(imeiNew);
                        }
                        FunOpenIDSdk.getOaid(appContext, new d0());
                        if (FunAdSdk.isLogEnabled()) {
                            LogPrinter.d(t.toString(), new Object[0]);
                        }
                    }
                }
            }
            g0 g0Var2 = t;
            jSONObject.put("app", g0Var2.f31148a);
            jSONObject.put("appv", g0Var2.f31150c);
            jSONObject.put("appvn", g0Var2.f31149b);
            jSONObject.put("net", g0Var2.f31151d);
            jSONObject.put("manu", g0Var2.f31152e);
            jSONObject.put("model", g0Var2.f31153f);
            jSONObject.put("sysv", g0Var2.f31154g);
            jSONObject.put("h", g0Var2.f31155h);
            jSONObject.put("w", g0Var2.f31156i);
            jSONObject.put("locale", g0Var2.n);
            jSONObject.put("opcode", g0Var2.j);
            jSONObject.put("tk", g0Var2.k);
            jSONObject.put("sdkvn", BuildConfig.VERSION_NAME);
            jSONObject.put("sdkv", BuildConfig.VERSION_CODE);
            jSONObject.put("anid", g0Var2.l);
            jSONObject.put("lic", g0Var2.o);
            jSONObject.put("plat", "a");
            jSONObject.put("oaid", g0Var2.m);
            jSONObject.put(DpStatConstants.KEY_USER_ID, g0Var2.p);
            jSONObject.put("iid", g0Var2.q);
            jSONObject.put("iidn", g0Var2.r);
            jSONObject.put("cfgv", s);
            return g0Var2;
        }
        return (g0) invokeL.objValue;
    }

    public static JSONObject b(String str, JSONObject jSONObject, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{str, jSONObject, Long.valueOf(j)})) == null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                a(jSONObject2);
                jSONObject2.put("key", str);
                jSONObject2.put("content", jSONObject);
                jSONObject2.put("occur_t", j);
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
            g0 a2 = a(jSONObject);
            long currentTimeMillis = System.currentTimeMillis();
            String str = a2.k + a2.f31148a + a2.f31149b + a2.n + currentTimeMillis + "c643144089d135c383c4c87f1df87a9d4ccc1c0f70cee0a5f78fd32d475f1a49";
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(str.getBytes());
                byte[] digest = messageDigest.digest();
                int length = digest.length;
                StringBuffer stringBuffer = new StringBuffer(length * 2);
                int i2 = length + 0;
                for (int i3 = 0; i3 < i2; i3++) {
                    byte b2 = digest[i3];
                    char[] cArr = x.f31276a;
                    char c2 = cArr[(b2 & 240) >> 4];
                    char c3 = cArr[b2 & 15];
                    stringBuffer.append(c2);
                    stringBuffer.append(c3);
                }
                str = stringBuffer.toString();
            } catch (NoSuchAlgorithmException e2) {
                LogPrinter.e(e2);
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
            this.f31148a = context.getPackageName();
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
                this.f31148a = packageInfo.packageName;
                this.f31149b = packageInfo.versionName;
                this.f31150c = String.valueOf(packageInfo.versionCode);
            } catch (PackageManager.NameNotFoundException unused) {
            }
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                String networkOperator = telephonyManager.getNetworkOperator();
                if (!TextUtils.isEmpty(networkOperator)) {
                    this.j = networkOperator;
                }
            }
            this.f31152e = Build.MANUFACTURER;
            this.f31153f = Build.MODEL;
            this.f31154g = String.valueOf(Build.VERSION.SDK_INT);
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager == null) {
                displayMetrics = context.getResources().getDisplayMetrics();
            } else {
                Display defaultDisplay = windowManager.getDefaultDisplay();
                DisplayMetrics displayMetrics2 = new DisplayMetrics();
                defaultDisplay.getMetrics(displayMetrics2);
                displayMetrics = displayMetrics2;
            }
            this.f31155h = String.valueOf(displayMetrics.heightPixels);
            this.f31156i = String.valueOf(displayMetrics.widthPixels);
            if (TextUtils.isEmpty(d.f31128a)) {
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
                d.f31128a = string;
            }
            this.k = d.f31128a;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "HostAppInfo{packageName='" + this.f31148a + ExtendedMessageFormat.QUOTE + ", versionName='" + this.f31149b + ExtendedMessageFormat.QUOTE + ", versionCode='" + this.f31150c + ExtendedMessageFormat.QUOTE + ", networkTypeName='" + this.f31151d + ExtendedMessageFormat.QUOTE + ", manufacturer='" + this.f31152e + ExtendedMessageFormat.QUOTE + ", model='" + this.f31153f + ExtendedMessageFormat.QUOTE + ", osVersion='" + this.f31154g + ExtendedMessageFormat.QUOTE + ", h='" + this.f31155h + ExtendedMessageFormat.QUOTE + ", w='" + this.f31156i + ExtendedMessageFormat.QUOTE + ", opcode='" + this.j + ExtendedMessageFormat.QUOTE + ", token='" + this.k + ExtendedMessageFormat.QUOTE + ", anid='" + this.l + ExtendedMessageFormat.QUOTE + ", oaid='" + this.m + ExtendedMessageFormat.QUOTE + ", locale='" + this.n + ExtendedMessageFormat.QUOTE + ", lic='" + this.o + ExtendedMessageFormat.QUOTE + ", userId='" + this.p + ExtendedMessageFormat.QUOTE + ", imei='" + this.q + ExtendedMessageFormat.QUOTE + ", imeiNew='" + this.r + ExtendedMessageFormat.QUOTE + ", cfgv='" + s + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
