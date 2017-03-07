package com.baidu.adp.lib.b;

import android.content.SharedPreferences;
import com.baidu.adp.base.BdBaseApplication;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class e {
    private static e uI = null;
    private HashMap<String, d> mSwitchs;

    private e() {
        this.mSwitchs = null;
        this.mSwitchs = new HashMap<>();
    }

    public static synchronized e eT() {
        e eVar;
        synchronized (e.class) {
            if (uI == null) {
                uI = new e();
            }
            eVar = uI;
        }
        return eVar;
    }

    public void a(c cVar) {
        if (cVar != null && !this.mSwitchs.containsKey(cVar.getName())) {
            this.mSwitchs.put(cVar.getName(), new d(cVar));
        }
    }

    public void crash(String str) {
        Iterator<d> it = this.mSwitchs.values().iterator();
        while (it.hasNext() && !it.next().aa(str)) {
        }
    }

    public boolean d(String str, int i) {
        d dVar;
        if (i >= 0 && (dVar = this.mSwitchs.get(str)) != null) {
            return dVar.Z(i);
        }
        return false;
    }

    public int ab(String str) {
        d dVar = this.mSwitchs.get(str);
        if (dVar != null) {
            return dVar.getType();
        }
        return -1;
    }

    public void clear() {
        if (this.mSwitchs != null) {
            SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
            for (d dVar : this.mSwitchs.values()) {
                if (dVar != null) {
                    dVar.ac(0);
                    edit.putInt(String.valueOf(dVar.getName()) + d.uD, 0);
                    edit.putInt(String.valueOf(dVar.getName()) + d.uE, dVar.getDefaultType());
                }
            }
            edit.commit();
        }
    }

    public void m(Class<?> cls) {
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
