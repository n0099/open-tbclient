package com.baidu.live.liveroom.e;

import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class h {
    private static Boolean bgV;

    public static boolean isDebug() {
        if (bgV != null) {
            return bgV.booleanValue();
        }
        bgV = false;
        HashMap hashMap = new HashMap();
        hashMap.put("debug_LivePlayerDebugEnable", false);
        Map<String, Object> process = ExtraParamsManager.getInstance().buildParamsExtra().process(hashMap);
        if (process.containsKey("debug_LivePlayerDebugEnable")) {
            bgV = Boolean.valueOf(((Boolean) process.get("debug_LivePlayerDebugEnable")).booleanValue());
        }
        return bgV.booleanValue();
    }
}
