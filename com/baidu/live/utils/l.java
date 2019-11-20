package com.baidu.live.utils;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.x;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes6.dex */
public class l {
    private static Map<Long, Long> aqY = new HashMap();
    private static Map<Long, Set<Long>> aqZ = new HashMap();

    public static Long H(long j) {
        if (aqY.containsKey(Long.valueOf(j))) {
            return aqY.get(Long.valueOf(j));
        }
        return 0L;
    }

    public static void f(long j, long j2) {
        aqY.put(Long.valueOf(j), Long.valueOf(j2));
    }

    public static boolean g(long j, long j2) {
        Set<Long> set;
        if (aqZ.containsKey(Long.valueOf(j)) && (set = aqZ.get(Long.valueOf(j))) != null) {
            return set.contains(Long.valueOf(j2));
        }
        return false;
    }

    public static void h(long j, long j2) {
        if (!aqZ.containsKey(Long.valueOf(j))) {
            HashSet hashSet = new HashSet();
            hashSet.add(Long.valueOf(j2));
            aqZ.put(Long.valueOf(j), hashSet);
            return;
        }
        Set<Long> set = aqZ.get(Long.valueOf(j));
        if (set != null) {
            set.add(Long.valueOf(j2));
            return;
        }
        HashSet hashSet2 = new HashSet();
        hashSet2.add(Long.valueOf(j2));
        aqZ.put(Long.valueOf(j), hashSet2);
    }

    public static void wt() {
        aqZ.clear();
    }

    public static void i(long j, long j2) {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_ENTER_EFFECT_BUY_PROP);
        httpMessage.addParam("uid", j + "");
        httpMessage.addParam("live_id", j2 + "");
        httpMessage.addParam("latest_event_id", H(j2) + "");
        httpMessage.addParam("current_time", (System.currentTimeMillis() / 1000) + "");
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public static void a(x xVar, AlaLiveInfoData alaLiveInfoData) {
        switch (xVar.eventType) {
            case 1001:
                m.i(alaLiveInfoData.feed_id, alaLiveInfoData.live_id);
                return;
            default:
                return;
        }
    }
}
