package com.baidu.adp.lib.c;

import android.content.SharedPreferences;
import com.baidu.adp.base.BdBaseApplication;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class e {
    private static e jZ = null;
    private HashMap<String, d> kb;

    private e() {
        this.kb = null;
        this.kb = new HashMap<>();
    }

    public static synchronized e cS() {
        e eVar;
        synchronized (e.class) {
            if (jZ == null) {
                jZ = new e();
            }
            eVar = jZ;
        }
        return eVar;
    }

    public void a(c cVar) {
        if (cVar != null && !this.kb.containsKey(cVar.getName())) {
            this.kb.put(cVar.getName(), new d(cVar));
        }
    }

    public void crash(String str) {
        Iterator<d> it = this.kb.values().iterator();
        while (it.hasNext() && !it.next().Y(str)) {
        }
    }

    public boolean d(String str, int i) {
        d dVar;
        if (i >= 0 && (dVar = this.kb.get(str)) != null) {
            return dVar.I(i);
        }
        return false;
    }

    public int Z(String str) {
        d dVar = this.kb.get(str);
        if (dVar != null) {
            return dVar.getType();
        }
        return -1;
    }

    public void clear() {
        if (this.kb != null) {
            SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
            for (d dVar : this.kb.values()) {
                if (dVar != null) {
                    dVar.L(0);
                    edit.putInt(String.valueOf(dVar.getName()) + d.jU, 0);
                    edit.putInt(String.valueOf(dVar.getName()) + d.jV, dVar.getDefaultType());
                }
            }
            edit.commit();
        }
    }

    public void f(Class<?> cls) {
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
