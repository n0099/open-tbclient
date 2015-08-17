package com.baidu.adp.lib.b;

import android.content.SharedPreferences;
import com.baidu.adp.base.BdBaseApplication;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class e {
    private static e tM = null;
    private HashMap<String, d> tN;

    private e() {
        this.tN = null;
        this.tN = new HashMap<>();
    }

    public static synchronized e gy() {
        e eVar;
        synchronized (e.class) {
            if (tM == null) {
                tM = new e();
            }
            eVar = tM;
        }
        return eVar;
    }

    public void a(c cVar) {
        if (cVar != null && !this.tN.containsKey(cVar.getName())) {
            this.tN.put(cVar.getName(), new d(cVar));
        }
    }

    public void crash(String str) {
        Iterator<d> it = this.tN.values().iterator();
        while (it.hasNext() && !it.next().ag(str)) {
        }
    }

    public boolean d(String str, int i) {
        d dVar;
        if (i >= 0 && (dVar = this.tN.get(str)) != null) {
            return dVar.J(i);
        }
        return false;
    }

    public int ah(String str) {
        d dVar = this.tN.get(str);
        if (dVar != null) {
            return dVar.getType();
        }
        return -1;
    }

    public void clear() {
        if (this.tN != null) {
            SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
            for (d dVar : this.tN.values()) {
                if (dVar != null) {
                    dVar.M(0);
                    edit.putInt(String.valueOf(dVar.getName()) + d.tH, 0);
                    edit.putInt(String.valueOf(dVar.getName()) + d.tI, dVar.getDefaultType());
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
