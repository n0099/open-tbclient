package c.g;

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
import com.fun.openid.sdk.FunOpenIDSdk;
import com.fun.p0;
import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.UUID;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class m0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile long s;
    public static volatile m0 t;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f28433b;

    /* renamed from: c  reason: collision with root package name */
    public String f28434c;

    /* renamed from: d  reason: collision with root package name */
    public String f28435d;

    /* renamed from: e  reason: collision with root package name */
    public String f28436e;

    /* renamed from: f  reason: collision with root package name */
    public String f28437f;

    /* renamed from: g  reason: collision with root package name */
    public String f28438g;

    /* renamed from: h  reason: collision with root package name */
    public String f28439h;

    /* renamed from: i  reason: collision with root package name */
    public String f28440i;

    /* renamed from: j  reason: collision with root package name */
    public String f28441j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public String r;

    public m0() {
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

    public static m0 a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            if (t == null) {
                synchronized (m0.class) {
                    if (t == null) {
                        t = new m0();
                        Context appContext = FunAdSdk.getAppContext();
                        t.p = FunAdSdk.getFunAdConfig().userId;
                        t.o = FunAdSdk.getFunAdConfig().appId;
                        t.n = appContext.getResources().getConfiguration().locale.getLanguage();
                        t.l = FunOpenIDSdk.getAndroidId(appContext);
                        t.c(appContext);
                        m0 m0Var = t;
                        m0Var.getClass();
                        i0 i0Var = new i0(m0Var);
                        HashSet<p0.b> hashSet = com.fun.p0.f54226b;
                        synchronized (hashSet) {
                            hashSet.add(i0Var);
                        }
                        i0Var.a(com.fun.p0.a);
                        String imei = FunOpenIDSdk.getImei(appContext);
                        if (!TextUtils.isEmpty(imei)) {
                            t.q = FunOpenIDSdk.getMD5(imei);
                        }
                        String imeiNew = FunOpenIDSdk.getImeiNew(appContext);
                        if (!TextUtils.isEmpty(imeiNew)) {
                            t.r = FunOpenIDSdk.getMD5(imeiNew);
                        }
                        FunOpenIDSdk.getOaid(appContext, new k0());
                        if (FunAdSdk.isLogEnabled()) {
                            LogPrinter.d(t.toString(), new Object[0]);
                        }
                    }
                }
            }
            m0 m0Var2 = t;
            jSONObject.put("app", m0Var2.a);
            jSONObject.put("appv", m0Var2.f28434c);
            jSONObject.put("appvn", m0Var2.f28433b);
            jSONObject.put("net", m0Var2.f28435d);
            jSONObject.put("manu", m0Var2.f28436e);
            jSONObject.put("model", m0Var2.f28437f);
            jSONObject.put("sysv", m0Var2.f28438g);
            jSONObject.put("h", m0Var2.f28439h);
            jSONObject.put("w", m0Var2.f28440i);
            jSONObject.put("locale", m0Var2.n);
            jSONObject.put("opcode", m0Var2.f28441j);
            jSONObject.put("tk", m0Var2.k);
            jSONObject.put("sdkvn", BuildConfig.VERSION_NAME);
            jSONObject.put("sdkv", BuildConfig.VERSION_CODE);
            jSONObject.put("anid", m0Var2.l);
            jSONObject.put("lic", m0Var2.o);
            jSONObject.put("plat", "a");
            jSONObject.put("oaid", m0Var2.m);
            jSONObject.put(DpStatConstants.KEY_USER_ID, m0Var2.p);
            jSONObject.put("iid", m0Var2.q);
            jSONObject.put("iidn", m0Var2.r);
            jSONObject.put("cfgv", s);
            return m0Var2;
        }
        return (m0) invokeL.objValue;
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
            m0 a = a(jSONObject);
            long currentTimeMillis = System.currentTimeMillis();
            String str = a.k + a.a + a.f28433b + a.n + currentTimeMillis + "c643144089d135c383c4c87f1df87a9d4ccc1c0f70cee0a5f78fd32d475f1a49";
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(str.getBytes());
                byte[] digest = messageDigest.digest();
                int length = digest.length;
                StringBuffer stringBuffer = new StringBuffer(length * 2);
                int i2 = length + 0;
                for (int i3 = 0; i3 < i2; i3++) {
                    byte b2 = digest[i3];
                    char[] cArr = e0.a;
                    char c2 = cArr[(b2 & 240) >> 4];
                    char c3 = cArr[b2 & 15];
                    stringBuffer.append(c2);
                    stringBuffer.append(c3);
                }
                str = stringBuffer.toString();
            } catch (NoSuchAlgorithmException e2) {
                LogPrinter.e(e2);
            }
            jSONObject.put(TimeDisplaySetting.TIME_DISPLAY_SETTING, currentTimeMillis);
            jSONObject.put("vc", str);
        }
    }

    public final void c(Context context) {
        DisplayMetrics displayMetrics;
        String substring;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            PackageManager packageManager = context.getPackageManager();
            this.a = context.getPackageName();
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
                this.a = packageInfo.packageName;
                this.f28433b = packageInfo.versionName;
                this.f28434c = String.valueOf(packageInfo.versionCode);
            } catch (PackageManager.NameNotFoundException unused) {
            }
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                String networkOperator = telephonyManager.getNetworkOperator();
                if (!TextUtils.isEmpty(networkOperator)) {
                    this.f28441j = networkOperator;
                }
            }
            this.f28436e = Build.MANUFACTURER;
            this.f28437f = Build.MODEL;
            this.f28438g = String.valueOf(Build.VERSION.SDK_INT);
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager == null) {
                displayMetrics = context.getResources().getDisplayMetrics();
            } else {
                Display defaultDisplay = windowManager.getDefaultDisplay();
                DisplayMetrics displayMetrics2 = new DisplayMetrics();
                defaultDisplay.getMetrics(displayMetrics2);
                displayMetrics = displayMetrics2;
            }
            this.f28439h = String.valueOf(displayMetrics.heightPixels);
            this.f28440i = String.valueOf(displayMetrics.widthPixels);
            if (TextUtils.isEmpty(d.a)) {
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
                d.a = string;
            }
            this.k = d.a;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "HostAppInfo{packageName='" + this.a + ExtendedMessageFormat.QUOTE + ", versionName='" + this.f28433b + ExtendedMessageFormat.QUOTE + ", versionCode='" + this.f28434c + ExtendedMessageFormat.QUOTE + ", networkTypeName='" + this.f28435d + ExtendedMessageFormat.QUOTE + ", manufacturer='" + this.f28436e + ExtendedMessageFormat.QUOTE + ", model='" + this.f28437f + ExtendedMessageFormat.QUOTE + ", osVersion='" + this.f28438g + ExtendedMessageFormat.QUOTE + ", h='" + this.f28439h + ExtendedMessageFormat.QUOTE + ", w='" + this.f28440i + ExtendedMessageFormat.QUOTE + ", opcode='" + this.f28441j + ExtendedMessageFormat.QUOTE + ", token='" + this.k + ExtendedMessageFormat.QUOTE + ", anid='" + this.l + ExtendedMessageFormat.QUOTE + ", oaid='" + this.m + ExtendedMessageFormat.QUOTE + ", locale='" + this.n + ExtendedMessageFormat.QUOTE + ", lic='" + this.o + ExtendedMessageFormat.QUOTE + ", userId='" + this.p + ExtendedMessageFormat.QUOTE + ", imei='" + this.q + ExtendedMessageFormat.QUOTE + ", imeiNew='" + this.r + ExtendedMessageFormat.QUOTE + ", cfgv='" + s + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
