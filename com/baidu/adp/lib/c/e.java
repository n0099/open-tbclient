package com.baidu.adp.lib.c;

import android.content.SharedPreferences;
import com.baidu.adp.base.BdBaseApplication;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class e {
    private static e uk = null;
    private HashMap<String, d> ul;

    private e() {
        this.ul = null;
        this.ul = new HashMap<>();
    }

    public static synchronized e gE() {
        e eVar;
        synchronized (e.class) {
            if (uk == null) {
                uk = new e();
            }
            eVar = uk;
        }
        return eVar;
    }

    public void a(c cVar) {
        if (cVar != null && !this.ul.containsKey(cVar.getName())) {
            this.ul.put(cVar.getName(), new d(cVar));
        }
    }

    public void crash(String str) {
        Iterator<d> it = this.ul.values().iterator();
        while (it.hasNext() && !it.next().ah(str)) {
        }
    }

    public boolean d(String str, int i) {
        d dVar;
        if (i >= 0 && (dVar = this.ul.get(str)) != null) {
            return dVar.U(i);
        }
        return false;
    }

    public int ai(String str) {
        d dVar = this.ul.get(str);
        if (dVar != null) {
            return dVar.getType();
        }
        return -1;
    }

    public void clear() {
        if (this.ul != null) {
            SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
            for (d dVar : this.ul.values()) {
                if (dVar != null) {
                    dVar.X(0);
                    edit.putInt(String.valueOf(dVar.getName()) + d.uf, 0);
                    edit.putInt(String.valueOf(dVar.getName()) + d.ug, dVar.getDefaultType());
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
