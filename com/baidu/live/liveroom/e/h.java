package com.baidu.live.liveroom.e;

import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes11.dex */
public class h {
    private static Boolean bsQ;

    public static boolean isDebug() {
        if (bsQ != null) {
            return bsQ.booleanValue();
        }
        bsQ = false;
        HashMap hashMap = new HashMap();
        hashMap.put("isDebugBuildType", false);
        Map<String, Object> process = ExtraParamsManager.getInstance().buildParamsExtra().process(hashMap);
        if (process != null && process.containsKey("isDebugBuildType")) {
            bsQ = Boolean.valueOf(((Boolean) process.get("isDebugBuildType")).booleanValue());
        }
        return bsQ.booleanValue();
    }
}
