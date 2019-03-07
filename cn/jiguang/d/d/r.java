package cn.jiguang.d.d;

import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class r {
    public static q a(File file, Set<String> set) {
        q e = e(file);
        if (e != null) {
            e.b(cn.jiguang.d.h.h.a(e.ca(), set));
        }
        return e;
    }

    public static List<q> a(List<q> list, File file) {
        if (list.isEmpty()) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (q qVar : list) {
            File c = qVar.c();
            if (cn.jiguang.d.h.h.h(qVar.ca())) {
                cn.jiguang.d.h.f.a(c);
            } else {
                if (qVar.g()) {
                    cn.jiguang.d.h.h.a(qVar.ca(), qVar.e());
                    qVar.b(false);
                }
                if (qVar.f()) {
                    cn.jiguang.d.h.f.b(qVar.c(), qVar.ca().toString());
                    qVar.b();
                }
                if (!file.equals(c.getParentFile())) {
                    qVar.c().getAbsolutePath();
                    File file2 = new File(file.getAbsolutePath() + File.separator + c.getName());
                    qVar.c().renameTo(file2);
                    qVar.a(file2);
                }
                qVar.a(false);
                arrayList.add(qVar);
            }
        }
        return arrayList;
    }

    public static void a(List<q> list, int i) {
        if (list.isEmpty()) {
            return;
        }
        HashMap hashMap = new HashMap();
        for (q qVar : list) {
            JSONObject e = qVar.e();
            if (!cn.jiguang.d.h.h.h(e)) {
                String jSONObject = e.toString();
                List list2 = (List) hashMap.get(jSONObject);
                if (list2 == null) {
                    list2 = new ArrayList();
                    hashMap.put(jSONObject, list2);
                }
                list2.add(qVar);
            }
        }
        for (List list3 : hashMap.values()) {
            int i2 = 0;
            int i3 = 1;
            while (true) {
                int i4 = i3;
                int i5 = i2;
                if (i4 < list3.size()) {
                    i2 = !a((q) list3.get(i5), (q) list3.get(i4), 40960) ? i4 : i5;
                    i3 = i4 + 1;
                }
            }
        }
    }

    private static boolean a(q qVar, q qVar2, int i) {
        boolean z = false;
        if (qVar.a() + qVar2.a() <= i) {
            try {
                JSONArray jSONArray = qVar.ca().getJSONArray("content");
                JSONArray jSONArray2 = qVar2.ca().getJSONArray("content");
                int i2 = 0;
                while (i2 < jSONArray2.length()) {
                    jSONArray.put(jSONArray2.getJSONObject(i2));
                    i2++;
                    z = true;
                }
            } catch (Throwable th) {
            }
            if (z) {
                qVar.a(true);
                qVar2.a((JSONObject) null);
                qVar2.a(true);
            }
        }
        return z;
    }

    public static q e(File file) {
        String g = cn.jiguang.d.h.f.g(file);
        if (TextUtils.isEmpty(g)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(g);
            jSONObject.getJSONArray("content");
            return new q(file, jSONObject);
        } catch (JSONException e) {
            return null;
        }
    }
}
