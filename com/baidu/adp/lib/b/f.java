package com.baidu.adp.lib.b;

import android.content.SharedPreferences;
import com.baidu.adp.base.BdBaseApplication;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class f {
    private static f hW = null;
    private HashMap<String, e> hX;

    private f() {
        this.hX = null;
        this.hX = new HashMap<>();
    }

    public static synchronized f db() {
        f fVar;
        synchronized (f.class) {
            if (hW == null) {
                hW = new f();
            }
            fVar = hW;
        }
        return fVar;
    }

    public void a(c cVar) {
        if (cVar != null && !this.hX.containsKey(cVar.getName())) {
            this.hX.put(cVar.getName(), new e(cVar));
        }
    }

    public void crash(String str) {
        Iterator<e> it = this.hX.values().iterator();
        while (it.hasNext() && !it.next().T(str)) {
        }
    }

    public boolean c(String str, int i) {
        e eVar;
        if (i >= 0 && (eVar = this.hX.get(str)) != null) {
            return eVar.s(i);
        }
        return false;
    }

    public int U(String str) {
        e eVar = this.hX.get(str);
        if (eVar != null) {
            return eVar.getType();
        }
        return -1;
    }

    public void clear() {
        if (this.hX != null) {
            SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
            for (e eVar : this.hX.values()) {
                if (eVar != null) {
                    eVar.v(0);
                    edit.putInt(String.valueOf(eVar.getName()) + e.hR, 0);
                    edit.putInt(String.valueOf(eVar.getName()) + e.hS, eVar.getDefaultType());
                }
            }
            edit.commit();
        }
    }

    public void d(Class<?> cls) {
        try {
            cls.newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e2) {
            e2.printStackTrace();
        }
    }

    public void a(HashMap<String, Integer> hashMap) {
        if (hashMap != null && hashMap.size() > 0) {
            for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
                c(entry.getKey(), entry.getValue().intValue());
            }
        }
    }
}
