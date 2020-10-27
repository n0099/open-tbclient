package com.baidu.swan.apps.performance.b;

import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.ap.ai;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.e;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final File ddK = AppRuntime.getAppContext().getExternalCacheDir();

    public static void aG(List<UbcFlowEvent> list) {
        e aEV;
        Map<String, String> stringToMap;
        if (com.baidu.swan.apps.ad.a.a.aCu() && (aEV = e.aEV()) != null && (stringToMap = ai.stringToMap(ai.getParams(aEV.aEY().awf()))) != null && TextUtils.equals(stringToMap.get("_SwanStartupPerf_"), "1")) {
            ArrayList<UbcFlowEvent> arrayList = new ArrayList(list);
            JSONArray jSONArray = new JSONArray();
            for (UbcFlowEvent ubcFlowEvent : arrayList) {
                if (!ubcFlowEvent.aBm()) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("id", ubcFlowEvent.id);
                        jSONObject.put("time", ubcFlowEvent.aBk());
                        jSONObject.put("value", ubcFlowEvent.value());
                        jSONArray.put(jSONObject);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
            File file = new File(ddK, "swan_perf");
            if (!file.exists()) {
                file.mkdirs();
            }
            com.baidu.swan.c.d.saveFile(jSONArray.toString(), new File(file, String.format(Locale.getDefault(), "perf_%s.json", Long.valueOf(System.currentTimeMillis() / 1000))));
        }
    }
}
