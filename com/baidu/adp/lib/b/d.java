package com.baidu.adp.lib.b;

import android.content.SharedPreferences;
import com.baidu.adp.base.BdBaseApplication;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class d {
    private static d nT = null;
    private HashMap<String, c> nU;

    private d() {
        this.nU = null;
        this.nU = new HashMap<>();
    }

    public static synchronized d ft() {
        d dVar;
        synchronized (d.class) {
            if (nT == null) {
                nT = new d();
            }
            dVar = nT;
        }
        return dVar;
    }

    public void a(b bVar) {
        if (bVar != null && !this.nU.containsKey(bVar.getName())) {
            this.nU.put(bVar.getName(), new c(bVar));
        }
    }

    public void crash(String str) {
        Iterator<c> it = this.nU.values().iterator();
        while (it.hasNext() && !it.next().ae(str)) {
        }
    }

    public boolean c(String str, int i) {
        c cVar;
        if (i >= 0 && (cVar = this.nU.get(str)) != null) {
            return cVar.D(i);
        }
        return false;
    }

    public int af(String str) {
        c cVar = this.nU.get(str);
        if (cVar != null) {
            return cVar.getType();
        }
        return -1;
    }

    public void clear() {
        if (this.nU != null) {
            SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
            for (c cVar : this.nU.values()) {
                if (cVar != null) {
                    cVar.G(0);
                    edit.putInt(cVar.getName() + c.nO, 0);
                    edit.putInt(cVar.getName() + c.nP, cVar.fj());
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

    public void i(HashMap<String, Integer> hashMap) {
        if (hashMap != null && hashMap.size() > 0) {
            for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
                c(entry.getKey(), entry.getValue().intValue());
            }
        }
    }
}
