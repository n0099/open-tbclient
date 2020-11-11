package com.baidu.live.liveroom.e;

import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class h {
    private static Boolean bnA;

    public static boolean isDebug() {
        if (bnA != null) {
            return bnA.booleanValue();
        }
        bnA = false;
        HashMap hashMap = new HashMap();
        hashMap.put("isDebugBuildType", false);
        Map<String, Object> process = ExtraParamsManager.getInstance().buildParamsExtra().process(hashMap);
        if (process != null && process.containsKey("isDebugBuildType")) {
            bnA = Boolean.valueOf(((Boolean) process.get("isDebugBuildType")).booleanValue());
        }
        return bnA.booleanValue();
    }
}
