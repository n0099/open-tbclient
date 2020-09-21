package com.baidu.ar.statistic;

import android.text.TextUtils;
import com.baidu.ala.dumixar.utils.LuaMessageHelper;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes10.dex */
public class p {
    private static com.baidu.ar.lua.c we;
    private static final List<String> wf = Arrays.asList(StatisticConstants.EVENT_FILTER_ADJUST, StatisticConstants.EVENT_FILTER_SWITCH, StatisticConstants.EVENT_BEAUTIFY_ADJUST);

    public static void b(com.baidu.ar.lua.b bVar) {
        we = new com.baidu.ar.lua.c() { // from class: com.baidu.ar.statistic.p.1
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
                arrayList.add(Integer.valueOf((int) ARPMessageType.MSG_TYPE_LUA_SDK_BRIDGE));
                return arrayList;
            }
        };
        bVar.c(we);
    }

    public static void c(com.baidu.ar.lua.b bVar) {
        if (we != null) {
            if (bVar != null) {
                bVar.d(we);
            }
            we = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void n(HashMap<String, Object> hashMap) {
        if (hashMap != null && hashMap.containsKey(LuaMessageHelper.KEY_EVENT_NAME) && hashMap.containsKey("event_id") && "statistic_lua_event".equals((String) hashMap.get(LuaMessageHelper.KEY_EVENT_NAME))) {
            String str = (String) hashMap.get("event_id");
            Object obj = hashMap.get("event_map");
            if (obj == null || !(obj instanceof Map)) {
                StatisticApi.onEvent(str);
            } else {
                StatisticApi.onEvent(str, (Map) obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
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
            if (wf.contains(str2)) {
                StatisticApi.onEventDebounce(str2, 200L, hashMap2);
            } else {
                StatisticApi.onEvent(str2, hashMap2);
            }
        }
    }
}
