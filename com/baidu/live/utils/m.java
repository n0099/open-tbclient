package com.baidu.live.utils;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.ai;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes3.dex */
public class m {
    private static Map<Long, Long> aXP = new HashMap();
    private static Map<Long, Set<Long>> aXQ = new HashMap();

    public static Long ap(long j) {
        if (aXP.containsKey(Long.valueOf(j))) {
            return aXP.get(Long.valueOf(j));
        }
        return 0L;
    }

    public static void g(long j, long j2) {
        aXP.put(Long.valueOf(j), Long.valueOf(j2));
    }

    public static boolean h(long j, long j2) {
        Set<Long> set;
        if (aXQ.containsKey(Long.valueOf(j)) && (set = aXQ.get(Long.valueOf(j))) != null) {
            return set.contains(Long.valueOf(j2));
        }
        return false;
    }

    public static void i(long j, long j2) {
        if (!aXQ.containsKey(Long.valueOf(j))) {
            HashSet hashSet = new HashSet();
            hashSet.add(Long.valueOf(j2));
            aXQ.put(Long.valueOf(j), hashSet);
            return;
        }
        Set<Long> set = aXQ.get(Long.valueOf(j));
        if (set != null) {
            set.add(Long.valueOf(j2));
            return;
        }
        HashSet hashSet2 = new HashSet();
        hashSet2.add(Long.valueOf(j2));
        aXQ.put(Long.valueOf(j), hashSet2);
    }

    public static void Gg() {
        aXQ.clear();
    }

    public static void j(long j, long j2) {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_ENTER_EFFECT_BUY_PROP);
        httpMessage.addParam("uid", j + "");
        httpMessage.addParam("live_id", j2 + "");
        httpMessage.addParam("latest_event_id", ap(j2) + "");
        httpMessage.addParam("current_time", (System.currentTimeMillis() / 1000) + "");
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public static void a(ai aiVar, AlaLiveInfoData alaLiveInfoData) {
        switch (aiVar.eventType) {
            case 1001:
                o.g(alaLiveInfoData.feed_id, alaLiveInfoData.live_id);
                return;
            default:
                return;
        }
    }
}
