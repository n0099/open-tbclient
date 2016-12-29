package com.baidu.adp.lib.c;

import android.content.SharedPreferences;
import com.baidu.adp.base.BdBaseApplication;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class e {
    private static e mW = null;
    private HashMap<String, d> mZ;

    private e() {
        this.mZ = null;
        this.mZ = new HashMap<>();
    }

    public static synchronized e dN() {
        e eVar;
        synchronized (e.class) {
            if (mW == null) {
                mW = new e();
            }
            eVar = mW;
        }
        return eVar;
    }

    public void a(c cVar) {
        if (cVar != null && !this.mZ.containsKey(cVar.getName())) {
            this.mZ.put(cVar.getName(), new d(cVar));
        }
    }

    public void crash(String str) {
        Iterator<d> it = this.mZ.values().iterator();
        while (it.hasNext() && !it.next().ab(str)) {
        }
    }

    public boolean d(String str, int i) {
        d dVar;
        if (i >= 0 && (dVar = this.mZ.get(str)) != null) {
            return dVar.Z(i);
        }
        return false;
    }

    public int ac(String str) {
        d dVar = this.mZ.get(str);
        if (dVar != null) {
            return dVar.getType();
        }
        return -1;
    }

    public void clear() {
        if (this.mZ != null) {
            SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
            for (d dVar : this.mZ.values()) {
                if (dVar != null) {
                    dVar.ac(0);
                    edit.putInt(String.valueOf(dVar.getName()) + d.mQ, 0);
                    edit.putInt(String.valueOf(dVar.getName()) + d.mS, dVar.getDefaultType());
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
