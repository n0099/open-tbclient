package com.baidu.live.utils;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.af;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes3.dex */
public class m {
    private static Map<Long, Long> aDI = new HashMap();
    private static Map<Long, Set<Long>> aDJ = new HashMap();

    public static Long N(long j) {
        if (aDI.containsKey(Long.valueOf(j))) {
            return aDI.get(Long.valueOf(j));
        }
        return 0L;
    }

    public static void f(long j, long j2) {
        aDI.put(Long.valueOf(j), Long.valueOf(j2));
    }

    public static boolean g(long j, long j2) {
        Set<Long> set;
        if (aDJ.containsKey(Long.valueOf(j)) && (set = aDJ.get(Long.valueOf(j))) != null) {
            return set.contains(Long.valueOf(j2));
        }
        return false;
    }

    public static void h(long j, long j2) {
        if (!aDJ.containsKey(Long.valueOf(j))) {
            HashSet hashSet = new HashSet();
            hashSet.add(Long.valueOf(j2));
            aDJ.put(Long.valueOf(j), hashSet);
            return;
        }
        Set<Long> set = aDJ.get(Long.valueOf(j));
        if (set != null) {
            set.add(Long.valueOf(j2));
            return;
        }
        HashSet hashSet2 = new HashSet();
        hashSet2.add(Long.valueOf(j2));
        aDJ.put(Long.valueOf(j), hashSet2);
    }

    public static void Ba() {
        aDJ.clear();
    }

    public static void i(long j, long j2) {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_ENTER_EFFECT_BUY_PROP);
        httpMessage.addParam("uid", j + "");
        httpMessage.addParam("live_id", j2 + "");
        httpMessage.addParam("latest_event_id", N(j2) + "");
        httpMessage.addParam("current_time", (System.currentTimeMillis() / 1000) + "");
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public static void a(af afVar, AlaLiveInfoData alaLiveInfoData) {
        switch (afVar.eventType) {
            case 1001:
                o.g(alaLiveInfoData.feed_id, alaLiveInfoData.live_id);
                return;
            default:
                return;
        }
    }
}
