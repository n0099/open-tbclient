package com.baidu.adp.lib.c;

import android.content.SharedPreferences;
import com.baidu.adp.base.BdBaseApplication;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class e {
    private static e mV = null;
    private HashMap<String, d> mW;

    private e() {
        this.mW = null;
        this.mW = new HashMap<>();
    }

    public static synchronized e dN() {
        e eVar;
        synchronized (e.class) {
            if (mV == null) {
                mV = new e();
            }
            eVar = mV;
        }
        return eVar;
    }

    public void a(c cVar) {
        if (cVar != null && !this.mW.containsKey(cVar.getName())) {
            this.mW.put(cVar.getName(), new d(cVar));
        }
    }

    public void crash(String str) {
        Iterator<d> it = this.mW.values().iterator();
        while (it.hasNext() && !it.next().ab(str)) {
        }
    }

    public boolean d(String str, int i) {
        d dVar;
        if (i >= 0 && (dVar = this.mW.get(str)) != null) {
            return dVar.Y(i);
        }
        return false;
    }

    public int ac(String str) {
        d dVar = this.mW.get(str);
        if (dVar != null) {
            return dVar.getType();
        }
        return -1;
    }

    public void clear() {
        if (this.mW != null) {
            SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
            for (d dVar : this.mW.values()) {
                if (dVar != null) {
                    dVar.ab(0);
                    edit.putInt(String.valueOf(dVar.getName()) + d.mP, 0);
                    edit.putInt(String.valueOf(dVar.getName()) + d.mQ, dVar.getDefaultType());
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
