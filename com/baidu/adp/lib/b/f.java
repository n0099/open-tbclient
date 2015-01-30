package com.baidu.adp.lib.b;

import android.content.SharedPreferences;
import com.baidu.adp.base.BdBaseApplication;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class f {
    private static f ih = null;
    private HashMap<String, e> ii;

    private f() {
        this.ii = null;
        this.ii = new HashMap<>();
    }

    public static synchronized f da() {
        f fVar;
        synchronized (f.class) {
            if (ih == null) {
                ih = new f();
            }
            fVar = ih;
        }
        return fVar;
    }

    public void a(c cVar) {
        if (cVar != null && !this.ii.containsKey(cVar.getName())) {
            this.ii.put(cVar.getName(), new e(cVar));
        }
    }

    public void crash(String str) {
        Iterator<e> it = this.ii.values().iterator();
        while (it.hasNext() && !it.next().Y(str)) {
        }
    }

    public boolean d(String str, int i) {
        e eVar;
        if (i >= 0 && (eVar = this.ii.get(str)) != null) {
            return eVar.F(i);
        }
        return false;
    }

    public int Z(String str) {
        e eVar = this.ii.get(str);
        if (eVar != null) {
            return eVar.getType();
        }
        return -1;
    }

    public void clear() {
        if (this.ii != null) {
            SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
            for (e eVar : this.ii.values()) {
                if (eVar != null) {
                    eVar.I(0);
                    edit.putInt(String.valueOf(eVar.getName()) + e.ia, 0);
                    edit.putInt(String.valueOf(eVar.getName()) + e.ib, eVar.getDefaultType());
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
