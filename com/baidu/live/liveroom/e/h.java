package com.baidu.live.liveroom.e;

import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public class h {
    private static Boolean btf;

    public static boolean isDebug() {
        if (btf != null) {
            return btf.booleanValue();
        }
        btf = false;
        HashMap hashMap = new HashMap();
        hashMap.put("isDebugBuildType", false);
        Map<String, Object> process = ExtraParamsManager.getInstance().buildParamsExtra().process(hashMap);
        if (process != null && process.containsKey("isDebugBuildType")) {
            btf = Boolean.valueOf(((Boolean) process.get("isDebugBuildType")).booleanValue());
        }
        return btf.booleanValue();
    }
}
