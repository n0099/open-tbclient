package cn.jiguang.g;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import cn.jiguang.d.d.aa;
import com.baidu.mobstat.Config;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class d {
    private static cn.jiguang.a.a.c.h P(Context context, String str) {
        try {
            PackageInfo c = c(context, str);
            if (c == null) {
                return null;
            }
            String charSequence = c.applicationInfo.loadLabel(context.getPackageManager()).toString();
            cn.jiguang.a.a.c.h hVar = new cn.jiguang.a.a.c.h();
            hVar.a = cn.jiguang.a.a.c.k.a(charSequence, 30);
            hVar.b = c.packageName;
            hVar.d = c.versionCode;
            hVar.c = c.versionName;
            hVar.e = a(c.applicationInfo);
            return hVar;
        } catch (Throwable th) {
            return null;
        }
    }

    public static ApplicationInfo Q(Context context, String str) {
        try {
            return context.getPackageManager().getApplicationInfo(str, 0);
        } catch (Throwable th) {
            return null;
        }
    }

    public static int a(ApplicationInfo applicationInfo) {
        int i = -1;
        if (applicationInfo != null) {
            try {
                if ((applicationInfo.flags & 1) != 0) {
                    i = (applicationInfo.flags & 128) != 0 ? 2 : 1;
                } else {
                    String str = applicationInfo.sourceDir;
                    if (!TextUtils.isEmpty(str)) {
                        i = str.startsWith("/system/") ? 3 : !applicationInfo.sourceDir.contains(applicationInfo.packageName) ? 3 : 0;
                    }
                }
            } catch (Throwable th) {
            }
        }
        return i;
    }

    private static List<e> a(int i) {
        String str;
        boolean z;
        String str2;
        String str3;
        ArrayList<String> e = a.e(new String[]{"ps"});
        ArrayList arrayList = new ArrayList();
        if (e == null || e.isEmpty()) {
            return arrayList;
        }
        HashSet hashSet = new HashSet();
        Map<String, Integer> a = e.a(e.remove(0));
        for (String str4 : e) {
            e b = e.b(str4, a);
            if (b != null) {
                if (i == 3 || !b.a()) {
                    if (!"ps".equals(b.a)) {
                        arrayList.add(b);
                    }
                } else if (b.b()) {
                    str3 = b.c;
                    hashSet.add(str3);
                }
            }
        }
        if (i != 1 || hashSet.isEmpty()) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        boolean z2 = false;
        while (!z2) {
            Iterator it = arrayList.iterator();
            z2 = true;
            while (it.hasNext()) {
                e eVar = (e) it.next();
                str = eVar.d;
                if (hashSet.contains(str)) {
                    arrayList2.add(eVar);
                    str2 = eVar.c;
                    hashSet.add(str2);
                    it.remove();
                    z = false;
                } else {
                    z = z2;
                }
                z2 = z;
            }
        }
        return arrayList2;
    }

    private static List<cn.jiguang.a.a.c.h> a(Context context) {
        HashMap hashMap = new HashMap();
        for (e eVar : a(1)) {
            cn.jiguang.a.a.c.h P = P(context, eVar.a);
            if (P != null) {
                hashMap.put(P.b, P);
            }
        }
        return new ArrayList(hashMap.values());
    }

    private static JSONArray a(List<cn.jiguang.a.a.c.h> list) {
        JSONArray jSONArray = new JSONArray();
        for (cn.jiguang.a.a.c.h hVar : list) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("name", hVar.a);
                jSONObject.put("pkg", i.a(hVar.b, 128));
                jSONObject.put("ver_name", hVar.c);
                jSONObject.put("ver_code", hVar.d);
                jSONObject.put("install_type", hVar.e);
                jSONArray.put(jSONObject);
            } catch (Throwable th) {
            }
        }
        return jSONArray;
    }

    private static List<cn.jiguang.a.a.c.h> b(Context context) {
        ArrayList arrayList = new ArrayList();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningAppProcesses();
        HashSet hashSet = new HashSet();
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            String[] strArr = runningAppProcessInfo.pkgList;
            if (strArr != null && strArr.length > 0) {
                Collections.addAll(hashSet, strArr);
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            cn.jiguang.a.a.c.h P = P(context, (String) it.next());
            if (P != null) {
                arrayList.add(P);
            }
        }
        return arrayList;
    }

    public static void b(Context context, int i, int i2) {
        JSONArray jSONArray;
        if (i2 > 0) {
            try {
                List<e> a = a(i2);
                jSONArray = new JSONArray();
                for (e eVar : a) {
                    JSONObject a2 = eVar.a(128);
                    if (a2 != null) {
                        jSONArray.put(a2);
                    }
                }
            } catch (Throwable th) {
                return;
            }
        } else {
            jSONArray = null;
        }
        JSONArray a3 = i > 0 ? a(Build.VERSION.SDK_INT < 21 ? b(context) : a(context)) : null;
        JSONObject jSONObject = new JSONObject();
        if (a3 != null && a3.length() > 0) {
            jSONObject.put("app", a3);
        }
        if (jSONArray != null && jSONArray.length() > 0) {
            jSONObject.put("process", jSONArray);
        }
        if (jSONObject.length() > 0) {
            aa.a(context, jSONObject, "app_running");
            aa.a(context, jSONObject);
        }
    }

    private static PackageInfo c(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0);
        } catch (Throwable th) {
            try {
                int indexOf = str.indexOf(Config.TRACE_TODAY_VISIT_SPLIT);
                if (indexOf > 0) {
                    return context.getPackageManager().getPackageInfo(str.substring(0, indexOf), 0);
                }
                return null;
            } catch (Throwable th2) {
                return null;
            }
        }
    }
}
