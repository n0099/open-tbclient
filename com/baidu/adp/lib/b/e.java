package com.baidu.adp.lib.b;

import android.content.SharedPreferences;
import com.baidu.adp.base.BdBaseApplication;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class e {
    private static e tK = null;
    private HashMap<String, d> tL;

    private e() {
        this.tL = null;
        this.tL = new HashMap<>();
    }

    public static synchronized e gv() {
        e eVar;
        synchronized (e.class) {
            if (tK == null) {
                tK = new e();
            }
            eVar = tK;
        }
        return eVar;
    }

    public void a(c cVar) {
        if (cVar != null && !this.tL.containsKey(cVar.getName())) {
            this.tL.put(cVar.getName(), new d(cVar));
        }
    }

    public void crash(String str) {
        Iterator<d> it = this.tL.values().iterator();
        while (it.hasNext() && !it.next().ae(str)) {
        }
    }

    public boolean d(String str, int i) {
        d dVar;
        if (i >= 0 && (dVar = this.tL.get(str)) != null) {
            return dVar.J(i);
        }
        return false;
    }

    public int af(String str) {
        d dVar = this.tL.get(str);
        if (dVar != null) {
            return dVar.getType();
        }
        return -1;
    }

    public void clear() {
        if (this.tL != null) {
            SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
            for (d dVar : this.tL.values()) {
                if (dVar != null) {
                    dVar.M(0);
                    edit.putInt(String.valueOf(dVar.getName()) + d.tF, 0);
                    edit.putInt(String.valueOf(dVar.getName()) + d.tG, dVar.getDefaultType());
                }
            }
            edit.commit();
        }
    }

    public void e(Class<?> cls) {
        try {
            cls.newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e2) {
            e2.printStackTrace();
        }
    }

    public void c(HashMap<String, Integer> hashMap) {
        if (hashMap != null && hashMap.size() > 0) {
            for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
                d(entry.getKey(), entry.getValue().intValue());
            }
        }
    }
}
