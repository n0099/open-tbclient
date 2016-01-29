package com.baidu.adp.lib.c;

import android.content.SharedPreferences;
import com.baidu.adp.base.BdBaseApplication;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class e {
    private static e ub = null;
    private HashMap<String, d> uc;

    private e() {
        this.uc = null;
        this.uc = new HashMap<>();
    }

    public static synchronized e gE() {
        e eVar;
        synchronized (e.class) {
            if (ub == null) {
                ub = new e();
            }
            eVar = ub;
        }
        return eVar;
    }

    public void a(c cVar) {
        if (cVar != null && !this.uc.containsKey(cVar.getName())) {
            this.uc.put(cVar.getName(), new d(cVar));
        }
    }

    public void crash(String str) {
        Iterator<d> it = this.uc.values().iterator();
        while (it.hasNext() && !it.next().ah(str)) {
        }
    }

    public boolean d(String str, int i) {
        d dVar;
        if (i >= 0 && (dVar = this.uc.get(str)) != null) {
            return dVar.V(i);
        }
        return false;
    }

    public int ai(String str) {
        d dVar = this.uc.get(str);
        if (dVar != null) {
            return dVar.getType();
        }
        return -1;
    }

    public void clear() {
        if (this.uc != null) {
            SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
            for (d dVar : this.uc.values()) {
                if (dVar != null) {
                    dVar.Y(0);
                    edit.putInt(String.valueOf(dVar.getName()) + d.tW, 0);
                    edit.putInt(String.valueOf(dVar.getName()) + d.tX, dVar.getDefaultType());
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
