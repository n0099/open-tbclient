package com.baidu.adp.lib.featureSwitch;

import android.content.SharedPreferences;
import com.baidu.adp.base.BdBaseApplication;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class SwitchManager {
    private static SwitchManager sSwitchManager = null;
    private HashMap<String, Integer> mBaseSwitchs = null;
    private HashMap<String, c> mSwitchs;

    private SwitchManager() {
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
        if (bVar != null && !this.mSwitchs.containsKey(bVar.getName())) {
            this.mSwitchs.put(bVar.getName(), new c(bVar));
        }
    }

    public b removeSwitchData(String str) {
        c remove = this.mSwitchs.remove(str);
        if (remove != null) {
            return remove.fF();
        }
        return null;
    }

    public void crash(String str) {
        Iterator<c> it = this.mSwitchs.values().iterator();
        while (it.hasNext() && !it.next().aj(str)) {
        }
    }

    public boolean turn(String str, int i) {
        c cVar;
        if (i >= 0 && (cVar = this.mSwitchs.get(str)) != null) {
            return cVar.H(i);
        }
        return false;
    }

    public int findType(String str) {
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
                    cVar.K(0);
                    edit.putInt(cVar.getName() + c.qi, 0);
                    edit.putInt(cVar.getName() + c.qj, cVar.getDefaultType());
                }
            }
            edit.commit();
        }
    }

    public void registerSwitch(Class<?> cls) {
        try {
            cls.newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e2) {
            e2.printStackTrace();
        }
    }

    public void refreshSwitchManager(HashMap<String, Integer> hashMap) {
        this.mBaseSwitchs = hashMap;
        if (hashMap != null && hashMap.size() > 0) {
            for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
                turn(entry.getKey(), entry.getValue().intValue());
            }
        }
    }

    public HashMap<String, Integer> getBaseSwitchs() {
        return this.mBaseSwitchs;
    }
}
