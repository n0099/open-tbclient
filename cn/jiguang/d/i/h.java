package cn.jiguang.d.i;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class h extends a {
    private static final Object f = new Object();
    private ConcurrentLinkedQueue<cn.jiguang.d.d.a> mL = new ConcurrentLinkedQueue<>();
    private boolean g = false;
    private AtomicBoolean h = new AtomicBoolean(false);

    private synchronized ArrayList<cn.jiguang.d.d.a> a(Context context, String str) {
        ArrayList<cn.jiguang.d.d.a> arrayList;
        File K = cn.jiguang.d.h.f.K(context, str);
        if (K != null) {
            if (K.exists()) {
                try {
                    arrayList = (ArrayList) cn.jiguang.d.h.f.h(K);
                } catch (Throwable th) {
                    arrayList = null;
                }
            }
        }
        arrayList = null;
        return arrayList;
    }

    private static JSONObject a(String str, ComponentName componentName, boolean z) {
        JSONObject jSONObject = new JSONObject();
        if (componentName == null) {
            return null;
        }
        try {
            jSONObject.put("awake_from", str);
            jSONObject.put("awake_to", componentName.getPackageName());
            jSONObject.put("awake_class", componentName.getClassName());
            jSONObject.put("awake_count", 1);
            jSONObject.put("success", z);
            return jSONObject;
        } catch (Throwable th) {
            return null;
        }
    }

    private synchronized <T> void a(Context context, String str, ArrayList<T> arrayList) {
        File K = cn.jiguang.d.h.f.K(context, str);
        if (K != null && K.exists()) {
            cn.jiguang.d.h.f.a(K, arrayList);
        }
    }

    private void a(Context context, ArrayList<d> arrayList) {
        c(context, "app_awake", e(context, arrayList));
    }

    private static boolean a(d dVar) {
        if (dVar == null) {
            return false;
        }
        HashMap<Integer, Boolean> b = dVar.b();
        if (b == null || b.isEmpty()) {
            return false;
        }
        for (Integer num : b.keySet()) {
            if (b.get(Integer.valueOf(num.intValue())).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    private JSONObject e(Context context, ArrayList<d> arrayList) {
        if (arrayList != null) {
            try {
                if (!arrayList.isEmpty()) {
                    String packageName = context.getApplicationContext().getPackageName();
                    JSONObject jSONObject = new JSONObject();
                    JSONArray jSONArray = new JSONArray();
                    Iterator<d> it = arrayList.iterator();
                    while (it.hasNext()) {
                        d next = it.next();
                        if (next != null) {
                            JSONObject a = a(packageName, next.cj(), a(next));
                            if (a != null) {
                                jSONArray.put(a);
                            }
                        }
                    }
                    jSONObject.put("awake_path", jSONArray);
                    return jSONObject;
                }
            } catch (Throwable th) {
                return null;
            }
        }
        return null;
    }

    private void e(Context context) {
        if (this.g) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.mL);
            a(context, "Jpush_awake_file_list", arrayList);
            this.g = false;
        }
    }

    public final void a(Context context, cn.jiguang.d.d.a aVar) {
        int i = 1;
        try {
            if (!this.mL.contains(aVar)) {
                this.mL.add(aVar);
                this.g = true;
            }
        } catch (Throwable th) {
        }
        e(context);
        if (this.h.get()) {
            return;
        }
        ApplicationInfo M = cn.jiguang.g.a.M(context, aVar.a);
        if (M != null) {
            aVar.c = M.targetSdkVersion;
        }
        if (Build.VERSION.SDK_INT >= 26 && aVar.c >= 26) {
            i = 2;
        }
        ArrayList<d> arrayList = new ArrayList<>();
        d a = c.a(context, 2, i, aVar, null);
        if (a != null) {
            arrayList.add(a);
        }
        a(context, arrayList);
    }

    @Override // cn.jiguang.d.i.a
    protected final boolean a(Context context) {
        if (context == null) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        long ac = cn.jiguang.d.a.d.ac(context);
        return -1 == ac || Math.abs(currentTimeMillis - ac) > this.a;
    }

    @Override // cn.jiguang.d.i.a
    protected final void b(Context context) {
        cn.jiguang.d.a.d.b(context, System.currentTimeMillis() / 1000);
    }

    public final void b(Context context, cn.jiguang.d.d.a aVar) {
        if (this.mL.contains(aVar)) {
            try {
                this.mL.remove(aVar);
                this.g = true;
            } catch (Throwable th) {
            }
        }
        e(context);
    }

    @Override // cn.jiguang.d.i.a
    protected final ArrayList<cn.jiguang.d.d.a> c(Context context) {
        return null;
    }

    @Override // cn.jiguang.d.i.a
    public final void d(Context context) {
        ArrayList<cn.jiguang.d.d.a> a;
        this.h.set(true);
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (this.mL.isEmpty() && (a = a(context, "Jpush_awake_file_list")) != null) {
            this.mL.clear();
            this.mL.addAll(a);
        }
        if (this.mL != null && !this.mL.isEmpty()) {
            ArrayList<d> arrayList = new ArrayList<>();
            Iterator<cn.jiguang.d.d.a> it = this.mL.iterator();
            while (it.hasNext()) {
                cn.jiguang.d.d.a next = it.next();
                d a2 = c.a(context, 2, (Build.VERSION.SDK_INT < 26 || next.c < 26) ? 1 : 2, next, null);
                if (a2 != null) {
                    arrayList.add(a2);
                }
            }
            a(context, arrayList);
        }
        this.h.set(false);
    }
}
