package com.baidu.cyberplayer.sdk.ab;

import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.Keep;
import com.baidu.cyberplayer.sdk.context.ICyberMediaAbTest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
@Keep
/* loaded from: classes3.dex */
public class CyberAbTestManager {
    public static Map<String, a> a = new HashMap();

    @Keep
    public static synchronized void collectCyberAllKV(Map<String, String> map) {
        synchronized (CyberAbTestManager.class) {
            for (Map.Entry<String, a> entry : a.entrySet()) {
                a value = entry.getValue();
                if (value != null) {
                    Map<String, String> b = value.b();
                    CyberLog.d("CyberAbTestManager", entry.getKey());
                    for (Map.Entry<String, String> entry2 : b.entrySet()) {
                        CyberLog.d("CyberAbTestManager", "--- key:" + entry2.getKey() + ", value:" + entry2.getValue());
                    }
                    map.putAll(b);
                }
            }
        }
    }

    @Keep
    public static synchronized void collectOriginAbs(Map<String, String> map) {
        synchronized (CyberAbTestManager.class) {
            for (Map.Entry<String, a> entry : a.entrySet()) {
                String key = entry.getKey();
                a value = entry.getValue();
                if (key != null && value != null) {
                    map.put(key, value.a());
                }
            }
        }
    }

    @Keep
    public static a findCyberAbModel(String str) {
        for (Map.Entry<String, a> entry : a.entrySet()) {
            a value = entry.getValue();
            if (value.b().containsKey(str)) {
                return value;
            }
        }
        return null;
    }

    @Keep
    public static synchronized int getAbSwitchInt(String str, int i) {
        synchronized (CyberAbTestManager.class) {
            if (CyberPlayerManager.getCyberMediaContext() == null) {
                return i;
            }
            ICyberMediaAbTest abTestInterface = CyberPlayerManager.getCyberMediaContext().getAbTestInterface();
            if (abTestInterface == null) {
                return i;
            }
            return abTestInterface.getSwitch(str, i);
        }
    }

    @Keep
    public static synchronized String getAbSwitchString(String str, String str2) {
        synchronized (CyberAbTestManager.class) {
            if (CyberPlayerManager.getCyberMediaContext() == null) {
                return str2;
            }
            ICyberMediaAbTest abTestInterface = CyberPlayerManager.getCyberMediaContext().getAbTestInterface();
            if (abTestInterface == null) {
                return str2;
            }
            return abTestInterface.getSwitch(str, str2);
        }
    }

    @Keep
    public static synchronized int getCyberAbValueInt(String str, int i) {
        synchronized (CyberAbTestManager.class) {
            a findCyberAbModel = findCyberAbModel(str);
            if (findCyberAbModel == null) {
                return i;
            }
            return findCyberAbModel.a(str, i);
        }
    }

    @Keep
    public static synchronized String getCyberAbValueString(String str, String str2) {
        synchronized (CyberAbTestManager.class) {
            a findCyberAbModel = findCyberAbModel(str);
            if (findCyberAbModel == null) {
                return str2;
            }
            return findCyberAbModel.a(str, str2);
        }
    }

    @Keep
    public static synchronized int getCyberAbSwitchInt(String str, String str2, int i) {
        synchronized (CyberAbTestManager.class) {
            if (CyberPlayerManager.getCyberMediaContext() == null) {
                return i;
            }
            if (CyberPlayerManager.getCyberMediaContext().getAbTestInterface() == null) {
                return i;
            }
            a aVar = a.get(str);
            if (aVar == null && (aVar = a.a(str)) != null) {
                a.put(str, aVar);
            }
            if (aVar == null) {
                return i;
            }
            return aVar.a(str2, i);
        }
    }

    @Keep
    public static synchronized String getCyberAbSwitchString(String str, String str2, String str3) {
        synchronized (CyberAbTestManager.class) {
            if (CyberPlayerManager.getCyberMediaContext() == null) {
                return str3;
            }
            if (CyberPlayerManager.getCyberMediaContext().getAbTestInterface() == null) {
                return str3;
            }
            a aVar = a.get(str);
            if (aVar == null && (aVar = a.a(str)) != null) {
                a.put(str, aVar);
            }
            if (aVar == null) {
                return str3;
            }
            return aVar.a(str2, str3);
        }
    }

    @Keep
    public static synchronized void parseCyberMediaAllAbs() {
        a a2;
        synchronized (CyberAbTestManager.class) {
            if (CyberPlayerManager.getCyberMediaContext() == null) {
                return;
            }
            ICyberMediaAbTest abTestInterface = CyberPlayerManager.getCyberMediaContext().getAbTestInterface();
            if (abTestInterface == null) {
                return;
            }
            Iterator<String> keys = abTestInterface.getRawSwitch().keys();
            if (keys != null) {
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (next.startsWith(CyberPlayerManager.INSTALL_OPT_ABTEST_SWITCH_START_CODE) && (a2 = a.a(next)) != null) {
                        a.put(next, a2);
                    }
                }
            }
        }
    }
}
