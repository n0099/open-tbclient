package com.baidu.swan.apps.performance.b;

import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.aq.ah;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.e.d;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final File cse = AppRuntime.getAppContext().getExternalCacheDir();

    public static void ak(List<UbcFlowEvent> list) {
        e aoG;
        Map<String, String> stringToMap;
        if (com.baidu.swan.apps.af.a.a.amu() && (aoG = e.aoG()) != null && (stringToMap = ah.stringToMap(ah.getParams(aoG.aoJ().agM()))) != null && TextUtils.equals(stringToMap.get("_SwanStartupPerf_"), "1")) {
            ArrayList<UbcFlowEvent> arrayList = new ArrayList(list);
            JSONArray jSONArray = new JSONArray();
            for (UbcFlowEvent ubcFlowEvent : arrayList) {
                if (!ubcFlowEvent.alD()) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("id", ubcFlowEvent.id);
                        jSONObject.put("time", ubcFlowEvent.alB());
                        jSONObject.put("value", ubcFlowEvent.value());
                        jSONArray.put(jSONObject);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
            File file = new File(cse, "swan_perf");
            if (!file.exists()) {
                file.mkdirs();
            }
            d.saveFile(jSONArray.toString(), new File(file, String.format(Locale.getDefault(), "perf_%s.json", Long.valueOf(System.currentTimeMillis() / 1000))));
        }
    }
}
