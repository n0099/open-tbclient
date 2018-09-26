package cn.jiguang.a.a.c;

import android.content.Context;
import android.content.pm.PackageInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class d {
    public static String[] S(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
        } catch (Throwable th) {
            return null;
        }
    }

    public static JSONArray T(Context context) {
        ArrayList<h> g = g(context, true);
        JSONArray jSONArray = new JSONArray();
        try {
            Iterator<h> it = g.iterator();
            while (it.hasNext()) {
                h next = it.next();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("name", next.a);
                jSONObject.put("pkg", next.b);
                jSONObject.put("ver_name", next.c);
                jSONObject.put("ver_code", next.d);
                jSONObject.put("install_type", next.e);
                jSONArray.put(jSONObject);
            }
        } catch (Throwable th) {
        }
        return jSONArray;
    }

    public static ArrayList<h> g(Context context, boolean z) {
        int i = 0;
        ArrayList<h> arrayList = new ArrayList<>();
        try {
            List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(0);
            while (true) {
                int i2 = i;
                if (i2 >= installedPackages.size()) {
                    break;
                }
                try {
                    PackageInfo packageInfo = installedPackages.get(i2);
                    h hVar = new h();
                    hVar.a = packageInfo.applicationInfo.loadLabel(context.getPackageManager()).toString();
                    hVar.b = packageInfo.packageName;
                    hVar.c = packageInfo.versionName;
                    hVar.d = packageInfo.versionCode;
                    hVar.e = cn.jiguang.g.d.a(packageInfo.applicationInfo);
                    arrayList.add(hVar);
                } catch (Throwable th) {
                }
                i = i2 + 1;
            }
        } catch (IndexOutOfBoundsException e) {
        } catch (Throwable th2) {
        }
        return arrayList;
    }
}
