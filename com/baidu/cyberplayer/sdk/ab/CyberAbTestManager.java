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
    public static final String TAG = "CyberAbTestManager";
    public static Map<String, CyberAbTestModel> sCyberAbModels = new HashMap();

    @Keep
    public static synchronized void collectCyberAllKV(Map<String, String> map) {
        synchronized (CyberAbTestManager.class) {
            for (Map.Entry<String, CyberAbTestModel> entry : sCyberAbModels.entrySet()) {
                CyberAbTestModel value = entry.getValue();
                if (value != null) {
                    Map<String, String> allKV = value.getAllKV();
                    CyberLog.d(TAG, entry.getKey());
                    for (Map.Entry<String, String> entry2 : allKV.entrySet()) {
                        CyberLog.d(TAG, "--- key:" + entry2.getKey() + ", value:" + entry2.getValue());
                    }
                    map.putAll(allKV);
                }
            }
        }
    }

    @Keep
    public static synchronized void collectOriginAbs(Map<String, String> map) {
        synchronized (CyberAbTestManager.class) {
            for (Map.Entry<String, CyberAbTestModel> entry : sCyberAbModels.entrySet()) {
                String key = entry.getKey();
                CyberAbTestModel value = entry.getValue();
                if (key != null && value != null) {
                    map.put(key, value.getOriginJson());
                }
            }
        }
    }

    @Keep
    public static CyberAbTestModel findCyberAbModel(String str) {
        for (Map.Entry<String, CyberAbTestModel> entry : sCyberAbModels.entrySet()) {
            CyberAbTestModel value = entry.getValue();
            if (value.getAllKV().containsKey(str)) {
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
            CyberAbTestModel findCyberAbModel = findCyberAbModel(str);
            if (findCyberAbModel == null) {
                return i;
            }
            return findCyberAbModel.getIntValue(str, i);
        }
    }

    @Keep
    public static synchronized String getCyberAbValueString(String str, String str2) {
        synchronized (CyberAbTestManager.class) {
            CyberAbTestModel findCyberAbModel = findCyberAbModel(str);
            if (findCyberAbModel == null) {
                return str2;
            }
            return findCyberAbModel.getStringValue(str, str2);
        }
    }

    @Keep
    public static synchronized void parseCyberMediaAllAbs() {
        CyberAbTestModel createAbModel;
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
                    if (next.startsWith(CyberPlayerManager.INSTALL_OPT_ABTEST_SWITCH_START_CODE) && (createAbModel = CyberAbTestModel.createAbModel(next)) != null) {
                        sCyberAbModels.put(next, createAbModel);
                    }
                }
            }
        }
    }
}
