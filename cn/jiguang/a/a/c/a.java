package cn.jiguang.a.a.c;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.d.d.aa;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class a extends Thread {
    private static final Object c = new Object();
    private static final Object d = new Object();
    private String a;
    private Context b;

    public a(Context context, String str) {
        this.b = context;
        this.a = str;
    }

    public static String a(Context context) {
        return cn.jiguang.d.h.f.g(cn.jiguang.d.h.f.K(context, "appPackageNames_v2"));
    }

    public static void a(Context context, ArrayList<h> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= arrayList.size()) {
                a(context, sb.toString());
                return;
            }
            sb.append(arrayList.get(i2).b);
            if (i2 != arrayList.size() - 1) {
                sb.append("&&");
            }
            i = i2 + 1;
        }
    }

    private void a(HashSet<String> hashSet) {
        if (this.b == null || hashSet == null || hashSet.isEmpty()) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        ArrayList<h> g = d.g(this.b, true);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(g);
        Iterator<h> it = g.iterator();
        while (it.hasNext()) {
            h next = it.next();
            if (hashSet.remove(next.b)) {
                arrayList.remove(next);
            }
            if (!cn.jiguang.g.i.a(this.a) && next.b.equals(this.a)) {
                arrayList.remove(next);
            }
        }
        if (!cn.jiguang.g.i.a(this.a)) {
            hashSet.remove(this.a);
        }
        Iterator<String> it2 = hashSet.iterator();
        while (it2.hasNext()) {
            String next2 = it2.next();
            JSONObject a = cn.jiguang.g.h.a(next2);
            if (a != null) {
                jSONArray.put(a);
            }
            cn.jiguang.d.f.a.a(this.b, next2);
        }
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            h hVar = (h) it3.next();
            JSONObject h = cn.jiguang.g.h.h(hVar.b, hVar.e);
            if (h != null) {
                jSONArray.put(h);
            }
        }
        if (jSONArray.length() > 0) {
            aa.a(this.b, jSONArray);
        }
        if (jSONArray.length() > 0 || !cn.jiguang.g.i.a(this.a)) {
            a(this.b, g);
        }
    }

    private static boolean a(Context context, String str) {
        boolean z = false;
        if (context != null) {
            synchronized (d) {
                File K = cn.jiguang.d.h.f.K(context, "appPackageNames_v2");
                if (K != null) {
                    if (cn.jiguang.d.h.f.b(K, str)) {
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        HashSet<String> hashSet;
        try {
            synchronized (c) {
                if (this.b == null) {
                    return;
                }
                String a = a(this.b);
                if (TextUtils.isEmpty(a)) {
                    return;
                }
                cn.jiguang.d.a.d.a(this.b, "last_check_userapp_status", Long.valueOf(System.currentTimeMillis()));
                if (a == null) {
                    hashSet = null;
                } else {
                    String[] split = a.split("&&");
                    hashSet = new HashSet<>();
                    Collections.addAll(hashSet, split);
                }
                a(hashSet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
