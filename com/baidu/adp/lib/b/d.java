package com.baidu.adp.lib.b;

import android.content.SharedPreferences;
import com.baidu.adp.base.BdBaseApplication;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class d {
    private static d Bz = null;
    private HashMap<String, c> mSwitchs;

    private d() {
        this.mSwitchs = null;
        this.mSwitchs = new HashMap<>();
    }

    public static synchronized d iQ() {
        d dVar;
        synchronized (d.class) {
            if (Bz == null) {
                Bz = new d();
            }
            dVar = Bz;
        }
        return dVar;
    }

    public void a(b bVar) {
        if (bVar != null && !this.mSwitchs.containsKey(bVar.getName())) {
            this.mSwitchs.put(bVar.getName(), new c(bVar));
        }
    }

    public void crash(String str) {
        Iterator<c> it = this.mSwitchs.values().iterator();
        while (it.hasNext() && !it.next().aN(str)) {
        }
    }

    public boolean i(String str, int i) {
        c cVar;
        if (i >= 0 && (cVar = this.mSwitchs.get(str)) != null) {
            return cVar.Z(i);
        }
        return false;
    }

    public int aO(String str) {
        c cVar = this.mSwitchs.get(str);
        if (cVar != null) {
            return cVar.getType();
        }
        return -1;
    }

    public void clear() {
        if (this.mSwitchs != null) {
            SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
            for (c cVar : this.mSwitchs.values()) {
                if (cVar != null) {
                    cVar.ac(0);
                    edit.putInt(cVar.getName() + c.Bu, 0);
                    edit.putInt(cVar.getName() + c.Bv, cVar.iH());
                }
            }
            edit.commit();
        }
    }

    public void i(Class<?> cls) {
        try {
            cls.newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e2) {
            e2.printStackTrace();
        }
    }

    public void j(HashMap<String, Integer> hashMap) {
        if (hashMap != null && hashMap.size() > 0) {
            for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
                i(entry.getKey(), entry.getValue().intValue());
            }
        }
    }
}
