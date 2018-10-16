package cn.jiguang.d.i;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.text.TextUtils;
import cn.jiguang.api.SdkType;
import cn.jiguang.d.d.aa;
import cn.jiguang.g.i;
import com.baidu.fsg.base.BaiduRimConstants;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.atomData.EmotionDetailActivityConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class e extends a {
    private boolean e = false;
    private String f = null;
    private Class<?> g = null;
    private String h = null;

    private cn.jiguang.d.d.a a(Context context, PackageManager packageManager, String str, String str2) {
        boolean z = false;
        if (packageManager == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            int checkPermission = packageManager.checkPermission(str + ".permission.JPUSH_MESSAGE", str);
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 128);
            if (applicationInfo != null && applicationInfo.metaData != null) {
                String string = applicationInfo.metaData.getString("JPUSH_APPKEY");
                Intent intent = new Intent();
                intent.setClassName(str, this.h);
                List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
                if (queryIntentServices != null && queryIntentServices.size() != 0) {
                    z = true;
                }
                if (checkPermission == 0 && z && !TextUtils.isEmpty(string) && string.length() == 24) {
                    cn.jiguang.d.d.a aVar = new cn.jiguang.d.d.a(str, str2, applicationInfo.targetSdkVersion);
                    ComponentInfo a = cn.jiguang.g.a.a(context, str, this.g);
                    if (a != null && (a instanceof ProviderInfo)) {
                        ProviderInfo providerInfo = (ProviderInfo) a;
                        if (providerInfo.exported && providerInfo.enabled && providerInfo.authority != null && TextUtils.equals(str + ".DownloadProvider", providerInfo.authority)) {
                            aVar.d = providerInfo.authority;
                        }
                    }
                    return aVar;
                }
            }
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    private static String a(String str, String str2) {
        return i.b(System.currentTimeMillis() + str + str2);
    }

    private static JSONObject a(int i, String str, String str2, String str3, boolean z) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        if (str3 == null) {
            str3 = "";
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("awake_type", i);
            jSONObject.put(EmotionDetailActivityConfig.EMOTION_FROM_PACKAGE, str);
            jSONObject.put("from_uid", str2);
            jSONObject.put("awake_sequence", str3);
            jSONObject.put("app_alive", z);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void d(Context context, String str, JSONObject jSONObject) {
        JSONObject I;
        JSONObject a = aa.a(context, jSONObject, str);
        synchronized ("wakeup_cache.json") {
            I = aa.I(context, "wakeup_cache.json");
        }
        if (I == null) {
            I = new JSONObject();
        }
        JSONArray optJSONArray = I.optJSONArray("content");
        if (optJSONArray == null) {
            optJSONArray = new JSONArray();
        }
        try {
            optJSONArray.put(a);
            I.put("content", optJSONArray);
            synchronized ("wakeup_cache.json") {
                aa.b(context, "wakeup_cache.json", I);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public final void a(Context context, int i, boolean z, String str, String str2, String str3) {
        try {
            d(context, "android_awake_target", a(i, str, str2, str3, z));
        } catch (Throwable th) {
        }
    }

    public final void a(boolean z) {
        this.e = z;
    }

    @Override // cn.jiguang.d.i.a
    protected final boolean a() {
        if (TextUtils.isEmpty(this.h) && this.g == null) {
            return false;
        }
        return this.e;
    }

    @Override // cn.jiguang.d.i.a
    protected final boolean a(Context context) {
        if (context == null) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        long ab = cn.jiguang.d.a.d.ab(context);
        return -1 == ab || Math.abs(currentTimeMillis - ab) > this.a;
    }

    public final JSONObject b(String str, ArrayList<d> arrayList) {
        if (arrayList.size() == 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<d> it = arrayList.iterator();
        while (it.hasNext()) {
            d next = it.next();
            try {
                JSONObject jSONObject = new JSONObject();
                String packageName = next.cj().getPackageName();
                Object a = a(this.b, packageName);
                jSONObject.put("target_package", packageName);
                jSONObject.put("awake_sequence", a);
                JSONArray jSONArray2 = new JSONArray();
                HashMap<Integer, Boolean> b = next.b();
                for (Integer num : b.keySet()) {
                    int intValue = num.intValue();
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("awake_type", intValue);
                    jSONObject2.put("success", b.get(Integer.valueOf(intValue)));
                    jSONArray2.put(jSONObject2);
                }
                jSONObject.put("awake", jSONArray2);
                jSONArray.put(jSONObject);
            } catch (Throwable th) {
            }
        }
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("package", str);
            jSONObject3.put(BaiduRimConstants.ACTION_TARGET, jSONArray);
            jSONObject3.put(Config.DEVICE_PART, Build.MODEL);
            jSONObject3.put("os", Build.VERSION.RELEASE);
            return jSONObject3;
        } catch (JSONException e) {
            e.printStackTrace();
            return jSONObject3;
        }
    }

    @Override // cn.jiguang.d.i.a
    protected final void b(Context context) {
        cn.jiguang.d.a.d.a(context, System.currentTimeMillis() / 1000);
    }

    @Override // cn.jiguang.d.i.a
    protected final ArrayList<cn.jiguang.d.d.a> c(Context context) {
        PackageManager packageManager;
        List<ResolveInfo> queryIntentServices;
        cn.jiguang.d.d.a a;
        if (context == null) {
            return null;
        }
        ArrayList<cn.jiguang.d.d.a> arrayList = new ArrayList<>();
        try {
            packageManager = context.getPackageManager();
            Intent intent = new Intent();
            intent.setAction(this.f);
            queryIntentServices = packageManager.queryIntentServices(intent, 0);
        } catch (Throwable th) {
            cn.jiguang.e.c.a("WakeUpJiGuangSdkManager", "filterAllDaemonService error:" + th.getMessage());
        }
        if (queryIntentServices == null || queryIntentServices.size() == 0) {
            return null;
        }
        for (int i = 0; i < queryIntentServices.size(); i++) {
            ServiceInfo serviceInfo = queryIntentServices.get(i).serviceInfo;
            String str = serviceInfo.name;
            String str2 = serviceInfo.packageName;
            if (str != null && str2 != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && serviceInfo.exported && serviceInfo.enabled && !context.getPackageName().equals(str2) && (a = a(context, packageManager, str2, str)) != null) {
                arrayList.add(a);
            }
        }
        return arrayList;
    }

    @Override // cn.jiguang.d.i.a
    protected final void c(Context context, String str, JSONObject jSONObject) {
        JSONObject I;
        if (jSONObject == null) {
            return;
        }
        JSONObject a = aa.a(context, jSONObject, str);
        synchronized ("wakeup_cache.json") {
            I = aa.I(context, "wakeup_cache.json");
        }
        if (I == null) {
            I = new JSONObject();
        }
        JSONArray optJSONArray = I.optJSONArray("content");
        if (optJSONArray == null) {
            optJSONArray = new JSONArray();
        }
        optJSONArray.put(a);
        cn.jiguang.api.e.a(context, optJSONArray, SdkType.JCORE.name());
        synchronized ("wakeup_cache.json") {
            aa.b(context, "wakeup_cache.json", null);
        }
    }

    public final void c(String str) {
        this.f = str;
    }

    @Override // cn.jiguang.d.i.a
    public final void d(Context context) {
        JSONObject b;
        HashMap hashMap = new HashMap();
        String packageName = context.getPackageName();
        long j = this.c;
        hashMap.put(EmotionDetailActivityConfig.EMOTION_FROM_PACKAGE, packageName);
        hashMap.put("from_uid", String.valueOf(j));
        hashMap.put("need_report", "true");
        ArrayList<cn.jiguang.d.d.a> c = c(context);
        if (c == null || c.isEmpty()) {
            return;
        }
        ArrayList<d> arrayList = new ArrayList<>();
        int size = c.size();
        for (int i = 0; i < size; i++) {
            cn.jiguang.d.d.a aVar = c.get(i);
            hashMap.put("awake_sequence", a(this.b, aVar.a));
            int i2 = 2;
            i2 = (Build.VERSION.SDK_INT < 26 || aVar.c < 26) ? 3 : 3;
            if (!TextUtils.isEmpty(aVar.d)) {
                i2 |= 4;
            }
            d a = c.a(context, 1, i2, aVar, hashMap);
            if (a != null) {
                arrayList.add(a);
            }
        }
        if (!c.a(context) || (b = b(packageName, arrayList)) == null) {
            return;
        }
        c(context, "android_awake", b);
    }

    public final void d(String str) {
        this.h = str;
    }

    public final void e(Class<?> cls) {
        this.g = cls;
    }
}
