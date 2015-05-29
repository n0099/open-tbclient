package com.baidu.adp.lib.b;

import android.content.SharedPreferences;
import com.baidu.adp.base.BdBaseApplication;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class f {
    private static f tN = null;
    private HashMap<String, e> tO;

    private f() {
        this.tO = null;
        this.tO = new HashMap<>();
    }

    public static synchronized f gD() {
        f fVar;
        synchronized (f.class) {
            if (tN == null) {
                tN = new f();
            }
            fVar = tN;
        }
        return fVar;
    }

    public void a(c cVar) {
        if (cVar != null && !this.tO.containsKey(cVar.getName())) {
            this.tO.put(cVar.getName(), new e(cVar));
        }
    }

    public void crash(String str) {
        Iterator<e> it = this.tO.values().iterator();
        while (it.hasNext() && !it.next().ah(str)) {
        }
    }

    public boolean d(String str, int i) {
        e eVar;
        if (i >= 0 && (eVar = this.tO.get(str)) != null) {
            return eVar.H(i);
        }
        return false;
    }

    public int ai(String str) {
        e eVar = this.tO.get(str);
        if (eVar != null) {
            return eVar.getType();
        }
        return -1;
    }

    public void clear() {
        if (this.tO != null) {
            SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
            for (e eVar : this.tO.values()) {
                if (eVar != null) {
                    eVar.K(0);
                    edit.putInt(String.valueOf(eVar.getName()) + e.tI, 0);
                    edit.putInt(String.valueOf(eVar.getName()) + e.tJ, eVar.getDefaultType());
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
