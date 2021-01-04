package com.baidu.swan.pms.c.a.b;

import android.util.Log;
import com.baidu.swan.pms.d;
import java.util.Map;
/* loaded from: classes6.dex */
public class a {
    public Integer C(Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            return 100;
        }
        if (map.containsKey("queue_priority")) {
            try {
                int intValue = ((Integer) map.get("queue_priority")).intValue();
                if (intValue == 200 || intValue == 300) {
                    return Integer.valueOf(intValue);
                }
            } catch (Exception e) {
                if (d.DEBUG) {
                    Log.e("PriorityOptionHelper", e.toString());
                    e.printStackTrace();
                }
            }
        }
        return 100;
    }
}
