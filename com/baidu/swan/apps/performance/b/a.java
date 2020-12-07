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
/* loaded from: classes25.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final File doY = AppRuntime.getAppContext().getExternalCacheDir();

    public static void aQ(List<UbcFlowEvent> list) {
        e aJV;
        Map<String, String> stringToMap;
        if (com.baidu.swan.apps.ad.a.a.aHu() && (aJV = e.aJV()) != null && (stringToMap = ai.stringToMap(ai.getParams(aJV.aJY().aBg()))) != null && TextUtils.equals(stringToMap.get("_SwanStartupPerf_"), "1")) {
            ArrayList<UbcFlowEvent> arrayList = new ArrayList(list);
            JSONArray jSONArray = new JSONArray();
            for (UbcFlowEvent ubcFlowEvent : arrayList) {
                if (!ubcFlowEvent.aGm()) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("id", ubcFlowEvent.id);
                        jSONObject.put("time", ubcFlowEvent.aGk());
                        jSONObject.put("value", ubcFlowEvent.value());
                        jSONArray.put(jSONObject);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
            File file = new File(doY, "swan_perf");
            if (!file.exists()) {
                file.mkdirs();
            }
            com.baidu.swan.c.d.saveFile(jSONArray.toString(), new File(file, String.format(Locale.getDefault(), "perf_%s.json", Long.valueOf(System.currentTimeMillis() / 1000))));
        }
    }
}
