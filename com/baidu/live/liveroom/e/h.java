package com.baidu.live.liveroom.e;

import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class h {
    private static Boolean bmg;

    public static boolean isDebug() {
        if (bmg != null) {
            return bmg.booleanValue();
        }
        bmg = false;
        HashMap hashMap = new HashMap();
        hashMap.put("isDebugBuildType", false);
        Map<String, Object> process = ExtraParamsManager.getInstance().buildParamsExtra().process(hashMap);
        if (process != null && process.containsKey("isDebugBuildType")) {
            bmg = Boolean.valueOf(((Boolean) process.get("isDebugBuildType")).booleanValue());
        }
        return bmg.booleanValue();
    }
}
