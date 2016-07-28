package com.baidu.adp.lib.c;

import android.content.SharedPreferences;
import com.baidu.adp.base.BdBaseApplication;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class e {
    private static e kD = null;
    private HashMap<String, d> kE;

    private e() {
        this.kE = null;
        this.kE = new HashMap<>();
    }

    public static synchronized e cS() {
        e eVar;
        synchronized (e.class) {
            if (kD == null) {
                kD = new e();
            }
            eVar = kD;
        }
        return eVar;
    }

    public void a(c cVar) {
        if (cVar != null && !this.kE.containsKey(cVar.getName())) {
            this.kE.put(cVar.getName(), new d(cVar));
        }
    }

    public void crash(String str) {
        Iterator<d> it = this.kE.values().iterator();
        while (it.hasNext() && !it.next().aa(str)) {
        }
    }

    public boolean d(String str, int i) {
        d dVar;
        if (i >= 0 && (dVar = this.kE.get(str)) != null) {
            return dVar.L(i);
        }
        return false;
    }

    public int ab(String str) {
        d dVar = this.kE.get(str);
        if (dVar != null) {
            return dVar.getType();
        }
        return -1;
    }

    public void clear() {
        if (this.kE != null) {
            SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
            for (d dVar : this.kE.values()) {
                if (dVar != null) {
                    dVar.O(0);
                    edit.putInt(String.valueOf(dVar.getName()) + d.kx, 0);
                    edit.putInt(String.valueOf(dVar.getName()) + d.ky, dVar.getDefaultType());
                }
            }
            edit.commit();
        }
    }

    public void n(Class<?> cls) {
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
