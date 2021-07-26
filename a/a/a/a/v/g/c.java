package a.a.a.a.v.g;

import a.a.a.a.q;
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
import com.baidu.common.param.CommonUrlParamManager;
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
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public static volatile long s;
    public static volatile c t;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f1404a;

    /* renamed from: b  reason: collision with root package name */
    public String f1405b;

    /* renamed from: c  reason: collision with root package name */
    public String f1406c;

    /* renamed from: d  reason: collision with root package name */
    public String f1407d;

    /* renamed from: e  reason: collision with root package name */
    public String f1408e;

    /* renamed from: f  reason: collision with root package name */
    public String f1409f;

    /* renamed from: g  reason: collision with root package name */
    public String f1410g;

    /* renamed from: h  reason: collision with root package name */
    public String f1411h;

    /* renamed from: i  reason: collision with root package name */
    public String f1412i;
    public String j;
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
                        t.a(appContext);
                        c cVar = t;
                        if (cVar != null) {
                            a aVar = new a(cVar);
                            synchronized (a.a.a.a.v.f.f1402c) {
                                a.a.a.a.v.f.f1402c.add(aVar);
                            }
                            aVar.a(a.a.a.a.v.f.f1401b);
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
                                a.a.a.a.v.d.a(t.toString(), new Object[0]);
                            }
                        } else {
                            throw null;
                        }
                    }
                }
            }
            c cVar2 = t;
            jSONObject.put("app", cVar2.f1404a);
            jSONObject.put("appv", cVar2.f1406c);
            jSONObject.put("appvn", cVar2.f1405b);
            jSONObject.put("net", cVar2.f1407d);
            jSONObject.put("manu", cVar2.f1408e);
            jSONObject.put("model", cVar2.f1409f);
            jSONObject.put("sysv", cVar2.f1410g);
            jSONObject.put("h", cVar2.f1411h);
            jSONObject.put("w", cVar2.f1412i);
            jSONObject.put("locale", cVar2.n);
            jSONObject.put("opcode", cVar2.j);
            jSONObject.put("tk", cVar2.k);
            jSONObject.put("sdkvn", "3.5.3-TB");
            jSONObject.put("sdkv", 353);
            jSONObject.put("anid", cVar2.l);
            jSONObject.put("lic", cVar2.o);
            jSONObject.put("plat", "a");
            jSONObject.put("oaid", cVar2.m);
            jSONObject.put(DpStatConstants.KEY_USER_ID, cVar2.p);
            jSONObject.put(CommonUrlParamManager.PARAM_IID, cVar2.q);
            jSONObject.put("iidn", cVar2.r);
            jSONObject.put("cfgv", s);
            return cVar2;
        }
        return (c) invokeL.objValue;
    }

    public static JSONObject a(String str, JSONObject jSONObject, long j) {
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

    public static void b(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, jSONObject) == null) {
            c a2 = a(jSONObject);
            long currentTimeMillis = System.currentTimeMillis();
            String str = a2.k + a2.f1404a + a2.f1405b + a2.n + currentTimeMillis + "c643144089d135c383c4c87f1df87a9d4ccc1c0f70cee0a5f78fd32d475f1a49";
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(str.getBytes());
                byte[] digest = messageDigest.digest();
                int length = digest.length;
                StringBuffer stringBuffer = new StringBuffer(length * 2);
                int i2 = length + 0;
                for (int i3 = 0; i3 < i2; i3++) {
                    byte b2 = digest[i3];
                    char[] cArr = a.a.a.a.v.e.f1399a;
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

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "HostAppInfo{packageName='" + this.f1404a + "', versionName='" + this.f1405b + "', versionCode='" + this.f1406c + "', networkTypeName='" + this.f1407d + "', manufacturer='" + this.f1408e + "', model='" + this.f1409f + "', osVersion='" + this.f1410g + "', h='" + this.f1411h + "', w='" + this.f1412i + "', opcode='" + this.j + "', token='" + this.k + "', anid='" + this.l + "', oaid='" + this.m + "', locale='" + this.n + "', lic='" + this.o + "', userId='" + this.p + "', imei='" + this.q + "', imeiNew='" + this.r + "', cfgv='" + s + "'}";
        }
        return (String) invokeV.objValue;
    }

    public final void a(Context context) {
        DisplayMetrics displayMetrics;
        String substring;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            PackageManager packageManager = context.getPackageManager();
            this.f1404a = context.getPackageName();
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
                this.f1404a = packageInfo.packageName;
                this.f1405b = packageInfo.versionName;
                this.f1406c = String.valueOf(packageInfo.versionCode);
            } catch (PackageManager.NameNotFoundException unused) {
            }
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                String networkOperator = telephonyManager.getNetworkOperator();
                if (!TextUtils.isEmpty(networkOperator)) {
                    this.j = networkOperator;
                }
            }
            this.f1408e = Build.MANUFACTURER;
            this.f1409f = Build.MODEL;
            this.f1410g = String.valueOf(Build.VERSION.SDK_INT);
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager == null) {
                displayMetrics = context.getResources().getDisplayMetrics();
            } else {
                Display defaultDisplay = windowManager.getDefaultDisplay();
                DisplayMetrics displayMetrics2 = new DisplayMetrics();
                defaultDisplay.getMetrics(displayMetrics2);
                displayMetrics = displayMetrics2;
            }
            this.f1411h = String.valueOf(displayMetrics.heightPixels);
            this.f1412i = String.valueOf(displayMetrics.widthPixels);
            if (TextUtils.isEmpty(q.f1094a)) {
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
                q.f1094a = string;
            }
            this.k = q.f1094a;
        }
    }
}
