package com.baidu.live.business.util;

import com.baidu.live.business.model.data.LiveGrParams;
import com.baidu.tieba.q70;
import com.baidu.tieba.t70;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class GrParasmUtil {
    public static Map<String, LiveGrParams> grParamsMap = new HashMap();
    public static List<String> uploadFeedList = new ArrayList();

    public static void clear(List<String> list) {
        if (!grParamsMap.isEmpty() && !q70.c(list)) {
            Iterator<Map.Entry<String, LiveGrParams>> it = grParamsMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, LiveGrParams> next = it.next();
                if (next != null && list.contains(next.getKey())) {
                    it.remove();
                }
            }
        }
    }

    public static String genUploadJson() {
        JSONObject json;
        if (grParamsMap.isEmpty()) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        for (Map.Entry<String, LiveGrParams> entry : grParamsMap.entrySet()) {
            if (entry != null) {
                String key = entry.getKey();
                LiveGrParams value = entry.getValue();
                if (value != null && (json = value.toJson()) != null) {
                    jSONArray.put(json);
                    uploadFeedList.add(key);
                }
            }
        }
        return jSONArray.toString();
    }

    public static void logGrParam(String str, boolean z, boolean z2) {
        LiveGrParams liveGrParams;
        if (t70.a(str)) {
            return;
        }
        if (grParamsMap.containsKey(str)) {
            liveGrParams = grParamsMap.get(str);
        } else {
            liveGrParams = new LiveGrParams();
            grParamsMap.put(str, liveGrParams);
        }
        liveGrParams.id = str;
        if (z2) {
            liveGrParams.clk = 1;
            liveGrParams.clkTs = System.currentTimeMillis() / 1000;
        }
        if (z) {
            liveGrParams.show = 1;
            liveGrParams.showTs = System.currentTimeMillis() / 1000;
        }
    }
}
