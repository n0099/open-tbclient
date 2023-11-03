package com.baidu.ar.statistic;

import android.text.TextUtils;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class p {
    public static com.baidu.ar.lua.c wS;
    public static final List<String> wT = Arrays.asList(StatisticConstants.EVENT_FILTER_ADJUST, StatisticConstants.EVENT_FILTER_SWITCH, StatisticConstants.EVENT_BEAUTIFY_ADJUST);

    public static void b(com.baidu.ar.lua.b bVar) {
        com.baidu.ar.lua.c cVar = new com.baidu.ar.lua.c() { // from class: com.baidu.ar.statistic.p.1
            @Override // com.baidu.ar.lua.c
            public void a(int i, int i2, HashMap<String, Object> hashMap) {
                if (i == 1801) {
                    p.o(hashMap);
                } else if (i == 1901) {
                    p.n(hashMap);
                }
            }

            @Override // com.baidu.ar.lua.c
            public List<Integer> n() {
                ArrayList arrayList = new ArrayList();
                arrayList.add(Integer.valueOf((int) ARPMessageType.MSG_TYPE_STATISTICS));
                arrayList.add(1901);
                return arrayList;
            }
        };
        wS = cVar;
        bVar.c(cVar);
    }

    public static void c(com.baidu.ar.lua.b bVar) {
        com.baidu.ar.lua.c cVar = wS;
        if (cVar != null) {
            if (bVar != null) {
                bVar.d(cVar);
            }
            wS = null;
        }
    }

    public static void n(HashMap<String, Object> hashMap) {
        if (hashMap != null && hashMap.containsKey("event_name") && hashMap.containsKey("event_id") && "statistic_lua_event".equals((String) hashMap.get("event_name"))) {
            String str = (String) hashMap.get("event_id");
            Object obj = hashMap.get("event_map");
            if (obj == null || !(obj instanceof Map)) {
                StatisticApi.onEvent(str);
            } else {
                StatisticApi.onEvent(str, (Map) obj);
            }
        }
    }

    public static void o(HashMap<String, Object> hashMap) {
        if (hashMap != null) {
            String str = (String) hashMap.get("id");
            String str2 = (String) hashMap.get("type");
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            HashMap hashMap2 = new HashMap();
            if (hashMap.size() > 1) {
                for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
                    if (entry.getValue() != null) {
                        hashMap2.put(entry.getKey(), entry.getValue().toString());
                    }
                }
                hashMap2.remove("type");
                if (hashMap2.containsKey("id")) {
                    hashMap2.remove("id");
                    hashMap2.put("event_param", str);
                }
            }
            if (wT.contains(str2)) {
                StatisticApi.onEventDebounce(str2, 200L, hashMap2);
            } else {
                StatisticApi.onEvent(str2, hashMap2);
            }
        }
    }
}
