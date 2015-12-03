package com.baidu.adp.lib.c;

import android.content.SharedPreferences;
import com.baidu.adp.base.BdBaseApplication;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class e {
    private static e tQ = null;
    private HashMap<String, d> tR;

    private e() {
        this.tR = null;
        this.tR = new HashMap<>();
    }

    public static synchronized e gw() {
        e eVar;
        synchronized (e.class) {
            if (tQ == null) {
                tQ = new e();
            }
            eVar = tQ;
        }
        return eVar;
    }

    public void a(c cVar) {
        if (cVar != null && !this.tR.containsKey(cVar.getName())) {
            this.tR.put(cVar.getName(), new d(cVar));
        }
    }

    public void crash(String str) {
        Iterator<d> it = this.tR.values().iterator();
        while (it.hasNext() && !it.next().ai(str)) {
        }
    }

    public boolean d(String str, int i) {
        d dVar;
        if (i >= 0 && (dVar = this.tR.get(str)) != null) {
            return dVar.K(i);
        }
        return false;
    }

    public int aj(String str) {
        d dVar = this.tR.get(str);
        if (dVar != null) {
            return dVar.getType();
        }
        return -1;
    }

    public void clear() {
        if (this.tR != null) {
            SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
            for (d dVar : this.tR.values()) {
                if (dVar != null) {
                    dVar.N(0);
                    edit.putInt(String.valueOf(dVar.getName()) + d.tL, 0);
                    edit.putInt(String.valueOf(dVar.getName()) + d.tM, dVar.getDefaultType());
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
