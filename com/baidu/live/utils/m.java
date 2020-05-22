package com.baidu.live.utils;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.am;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes3.dex */
public class m {
    private static Map<Long, Long> bfk = new HashMap();
    private static Map<Long, Set<Long>> bfl = new HashMap();

    public static Long au(long j) {
        if (bfk.containsKey(Long.valueOf(j))) {
            return bfk.get(Long.valueOf(j));
        }
        return 0L;
    }

    public static void h(long j, long j2) {
        bfk.put(Long.valueOf(j), Long.valueOf(j2));
    }

    public static boolean i(long j, long j2) {
        Set<Long> set;
        if (bfl.containsKey(Long.valueOf(j)) && (set = bfl.get(Long.valueOf(j))) != null) {
            return set.contains(Long.valueOf(j2));
        }
        return false;
    }

    public static void j(long j, long j2) {
        if (!bfl.containsKey(Long.valueOf(j))) {
            HashSet hashSet = new HashSet();
            hashSet.add(Long.valueOf(j2));
            bfl.put(Long.valueOf(j), hashSet);
            return;
        }
        Set<Long> set = bfl.get(Long.valueOf(j));
        if (set != null) {
            set.add(Long.valueOf(j2));
            return;
        }
        HashSet hashSet2 = new HashSet();
        hashSet2.add(Long.valueOf(j2));
        bfl.put(Long.valueOf(j), hashSet2);
    }

    public static void HZ() {
        bfl.clear();
    }

    public static void k(long j, long j2) {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_ENTER_EFFECT_BUY_PROP);
        httpMessage.addParam("uid", j + "");
        httpMessage.addParam("live_id", j2 + "");
        httpMessage.addParam("latest_event_id", au(j2) + "");
        httpMessage.addParam("current_time", (System.currentTimeMillis() / 1000) + "");
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public static void a(am amVar, AlaLiveInfoData alaLiveInfoData, boolean z) {
        switch (amVar.eventType) {
            case 1001:
                o.a(alaLiveInfoData.feed_id, alaLiveInfoData.live_id, z, false);
                return;
            default:
                return;
        }
    }
}
