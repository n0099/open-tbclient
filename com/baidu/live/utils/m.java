package com.baidu.live.utils;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.ae;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes2.dex */
public class m {
    private static Map<Long, Long> azs = new HashMap();
    private static Map<Long, Set<Long>> azt = new HashMap();

    public static Long J(long j) {
        if (azs.containsKey(Long.valueOf(j))) {
            return azs.get(Long.valueOf(j));
        }
        return 0L;
    }

    public static void f(long j, long j2) {
        azs.put(Long.valueOf(j), Long.valueOf(j2));
    }

    public static boolean g(long j, long j2) {
        Set<Long> set;
        if (azt.containsKey(Long.valueOf(j)) && (set = azt.get(Long.valueOf(j))) != null) {
            return set.contains(Long.valueOf(j2));
        }
        return false;
    }

    public static void h(long j, long j2) {
        if (!azt.containsKey(Long.valueOf(j))) {
            HashSet hashSet = new HashSet();
            hashSet.add(Long.valueOf(j2));
            azt.put(Long.valueOf(j), hashSet);
            return;
        }
        Set<Long> set = azt.get(Long.valueOf(j));
        if (set != null) {
            set.add(Long.valueOf(j2));
            return;
        }
        HashSet hashSet2 = new HashSet();
        hashSet2.add(Long.valueOf(j2));
        azt.put(Long.valueOf(j), hashSet2);
    }

    public static void yJ() {
        azt.clear();
    }

    public static void i(long j, long j2) {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_ENTER_EFFECT_BUY_PROP);
        httpMessage.addParam("uid", j + "");
        httpMessage.addParam("live_id", j2 + "");
        httpMessage.addParam("latest_event_id", J(j2) + "");
        httpMessage.addParam("current_time", (System.currentTimeMillis() / 1000) + "");
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public static void a(ae aeVar, AlaLiveInfoData alaLiveInfoData) {
        switch (aeVar.eventType) {
            case 1001:
                o.g(alaLiveInfoData.feed_id, alaLiveInfoData.live_id);
                return;
            default:
                return;
        }
    }
}
