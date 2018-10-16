package com.baidu.searchbox.dns.d.a;

import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.view.container.touch.AiAppsTouchHelper;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {
    private HashMap<String, a> G;

    public b(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("msg", AiAppsTouchHelper.TouchEventName.TOUCH_ERROR);
                String optString2 = jSONObject.optString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA);
                int optInt = jSONObject.optInt("ttl", 60) * 1000;
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                long optLong = jSONObject.optLong("cachetime", System.currentTimeMillis());
                if (optJSONObject != null) {
                    Iterator<String> keys = optJSONObject.keys();
                    this.G = new HashMap<>();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        JSONObject optJSONObject2 = optJSONObject.optJSONObject(next);
                        if (optJSONObject2 != null) {
                            JSONArray optJSONArray = optJSONObject2.optJSONArray("ip");
                            ArrayList arrayList = new ArrayList(optJSONArray.length());
                            for (int i = 0; i < optJSONArray.length(); i++) {
                                arrayList.add(optJSONArray.getString(i));
                            }
                            this.G.put(next, new a(optString, optInt, optString2, optLong, arrayList));
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public Map<String, a> t() {
        if (this.G != null) {
            return Collections.unmodifiableMap(this.G);
        }
        return null;
    }
}
