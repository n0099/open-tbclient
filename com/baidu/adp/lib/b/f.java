package com.baidu.adp.lib.b;

import android.content.SharedPreferences;
import com.baidu.adp.base.BdBaseApplication;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class f {
    private static f tC = null;
    private HashMap<String, e> tD;

    private f() {
        this.tD = null;
        this.tD = new HashMap<>();
    }

    public static synchronized f gz() {
        f fVar;
        synchronized (f.class) {
            if (tC == null) {
                tC = new f();
            }
            fVar = tC;
        }
        return fVar;
    }

    public void a(c cVar) {
        if (cVar != null && !this.tD.containsKey(cVar.getName())) {
            this.tD.put(cVar.getName(), new e(cVar));
        }
    }

    public void crash(String str) {
        Iterator<e> it = this.tD.values().iterator();
        while (it.hasNext() && !it.next().af(str)) {
        }
    }

    public boolean d(String str, int i) {
        e eVar;
        if (i >= 0 && (eVar = this.tD.get(str)) != null) {
            return eVar.G(i);
        }
        return false;
    }

    public int ag(String str) {
        e eVar = this.tD.get(str);
        if (eVar != null) {
            return eVar.getType();
        }
        return -1;
    }

    public void clear() {
        if (this.tD != null) {
            SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
            for (e eVar : this.tD.values()) {
                if (eVar != null) {
                    eVar.J(0);
                    edit.putInt(String.valueOf(eVar.getName()) + e.tx, 0);
                    edit.putInt(String.valueOf(eVar.getName()) + e.ty, eVar.getDefaultType());
                }
            }
            edit.commit();
        }
    }

    public void l(Class<?> cls) {
        try {
            cls.newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e2) {
            e2.printStackTrace();
        }
    }

    public void b(HashMap<String, Integer> hashMap) {
        if (hashMap != null && hashMap.size() > 0) {
            for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
                d(entry.getKey(), entry.getValue().intValue());
            }
        }
    }
}
