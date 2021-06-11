package com.baidu.adp.lib.featureSwitch;

import android.content.SharedPreferences;
import com.baidu.adp.base.BdBaseApplication;
import d.a.c.e.f.b;
import d.a.c.e.f.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class SwitchManager {
    public static SwitchManager sSwitchManager;
    public HashMap<String, Integer> mBaseSwitchs = null;
    public HashMap<String, c> mSwitchs;

    public SwitchManager() {
        this.mSwitchs = null;
        this.mSwitchs = new HashMap<>();
    }

    public static synchronized SwitchManager getInstance() {
        SwitchManager switchManager;
        synchronized (SwitchManager.class) {
            if (sSwitchManager == null) {
                sSwitchManager = new SwitchManager();
            }
            switchManager = sSwitchManager;
        }
        return switchManager;
    }

    public void addSwitchData(b bVar) {
        if (bVar == null || this.mSwitchs.containsKey(bVar.e())) {
            return;
        }
        this.mSwitchs.put(bVar.e(), new c(bVar));
    }

    public void clear() {
        if (this.mSwitchs == null) {
            return;
        }
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
        for (c cVar : this.mSwitchs.values()) {
            if (cVar != null) {
                cVar.i(0);
                edit.putInt(cVar.d() + c.f42224d, 0);
                edit.putInt(cVar.d() + c.f42225e, cVar.c());
            }
        }
        edit.commit();
    }

    public void crash(String str) {
        Iterator<c> it = this.mSwitchs.values().iterator();
        while (it.hasNext() && !it.next().a(str)) {
        }
    }

    public int findType(String str) {
        c cVar = this.mSwitchs.get(str);
        if (cVar != null) {
            return cVar.e();
        }
        return -1;
    }

    public HashMap<String, Integer> getBaseSwitchs() {
        return this.mBaseSwitchs;
    }

    public void refreshSwitchManager(HashMap<String, Integer> hashMap) {
        this.mBaseSwitchs = hashMap;
        if (hashMap == null || hashMap.size() <= 0) {
            return;
        }
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            turn(entry.getKey(), entry.getValue().intValue());
        }
    }

    public void registerSwitch(Class<?> cls) {
        try {
            cls.newInstance();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (InstantiationException e3) {
            e3.printStackTrace();
        }
    }

    public b removeSwitchData(String str) {
        c remove = this.mSwitchs.remove(str);
        if (remove != null) {
            return remove.b();
        }
        return null;
    }

    public boolean turn(String str, int i2) {
        c cVar;
        if (i2 >= 0 && (cVar = this.mSwitchs.get(str)) != null) {
            return cVar.j(i2);
        }
        return false;
    }
}
