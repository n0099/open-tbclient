package com.baidu.live.liveroom.e;

import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes11.dex */
public class h {
    private static Boolean brF;

    public static boolean isDebug() {
        if (brF != null) {
            return brF.booleanValue();
        }
        brF = false;
        HashMap hashMap = new HashMap();
        hashMap.put("isDebugBuildType", false);
        Map<String, Object> process = ExtraParamsManager.getInstance().buildParamsExtra().process(hashMap);
        if (process != null && process.containsKey("isDebugBuildType")) {
            brF = Boolean.valueOf(((Boolean) process.get("isDebugBuildType")).booleanValue());
        }
        return brF.booleanValue();
    }
}
