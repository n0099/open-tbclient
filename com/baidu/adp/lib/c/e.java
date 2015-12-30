package com.baidu.adp.lib.c;

import android.content.SharedPreferences;
import com.baidu.adp.base.BdBaseApplication;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class e {
    private static e tS = null;
    private HashMap<String, d> tT;

    private e() {
        this.tT = null;
        this.tT = new HashMap<>();
    }

    public static synchronized e gw() {
        e eVar;
        synchronized (e.class) {
            if (tS == null) {
                tS = new e();
            }
            eVar = tS;
        }
        return eVar;
    }

    public void a(c cVar) {
        if (cVar != null && !this.tT.containsKey(cVar.getName())) {
            this.tT.put(cVar.getName(), new d(cVar));
        }
    }

    public void crash(String str) {
        Iterator<d> it = this.tT.values().iterator();
        while (it.hasNext() && !it.next().ai(str)) {
        }
    }

    public boolean d(String str, int i) {
        d dVar;
        if (i >= 0 && (dVar = this.tT.get(str)) != null) {
            return dVar.K(i);
        }
        return false;
    }

    public int aj(String str) {
        d dVar = this.tT.get(str);
        if (dVar != null) {
            return dVar.getType();
        }
        return -1;
    }

    public void clear() {
        if (this.tT != null) {
            SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
            for (d dVar : this.tT.values()) {
                if (dVar != null) {
                    dVar.N(0);
                    edit.putInt(String.valueOf(dVar.getName()) + d.tN, 0);
                    edit.putInt(String.valueOf(dVar.getName()) + d.tO, dVar.getDefaultType());
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
