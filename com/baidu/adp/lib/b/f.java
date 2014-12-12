package com.baidu.adp.lib.b;

import android.content.SharedPreferences;
import com.baidu.adp.base.BdBaseApplication;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class f {
    private static f ie = null;
    private HashMap<String, e> ig;

    private f() {
        this.ig = null;
        this.ig = new HashMap<>();
    }

    public static synchronized f dc() {
        f fVar;
        synchronized (f.class) {
            if (ie == null) {
                ie = new f();
            }
            fVar = ie;
        }
        return fVar;
    }

    public void a(c cVar) {
        if (cVar != null && !this.ig.containsKey(cVar.getName())) {
            this.ig.put(cVar.getName(), new e(cVar));
        }
    }

    public void crash(String str) {
        Iterator<e> it = this.ig.values().iterator();
        while (it.hasNext() && !it.next().Y(str)) {
        }
    }

    public boolean d(String str, int i) {
        e eVar;
        if (i >= 0 && (eVar = this.ig.get(str)) != null) {
            return eVar.A(i);
        }
        return false;
    }

    public int Z(String str) {
        e eVar = this.ig.get(str);
        if (eVar != null) {
            return eVar.getType();
        }
        return -1;
    }

    public void clear() {
        if (this.ig != null) {
            SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
            for (e eVar : this.ig.values()) {
                if (eVar != null) {
                    eVar.D(0);
                    edit.putInt(String.valueOf(eVar.getName()) + e.hY, 0);
                    edit.putInt(String.valueOf(eVar.getName()) + e.hZ, eVar.getDefaultType());
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
