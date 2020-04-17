package com.baidu.adp.framework.client.socket;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.webkit.internal.ETAG;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class i {
    public static void debug(String str, int i, long j, int i2, String str2, int i3, String str3) {
        StringBuilder sb = new StringBuilder(50);
        if (i != 0 && i2 != 0) {
            sb.append("cmd = ");
            sb.append(i);
            sb.append("\t");
            sb.append("sequence = ");
            sb.append(i2);
            sb.append("\t");
        }
        sb.append(str3);
        try {
            LinkedList linkedList = new LinkedList();
            linkedList.add("lib");
            linkedList.add(str);
            if (i != 0) {
                linkedList.add("cmd");
                linkedList.add(Integer.valueOf(i));
            }
            if (!TextUtils.isEmpty(str2)) {
                linkedList.add("act");
                linkedList.add(str2);
            }
            if (i3 != 0) {
                linkedList.add("result");
                linkedList.add(Integer.valueOf(i3));
            }
            if (!TextUtils.isEmpty(str3)) {
                linkedList.add("comment");
                linkedList.add(str3);
            }
            BdStatisticsManager.getInstance().newDebug("socket", j, i2 == 0 ? null : String.valueOf(i2 & 4294967295L), linkedList.toArray());
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public static void debug(String str, int i, int i2, String str2, int i3, String str3) {
        debug(str, i, -1L, i2, str2, i3, str3);
    }

    public static void debugWebSocketInfo() {
        try {
            BdStatisticsManager.getInstance().debug("socket", "url", com.baidu.adp.lib.webSocket.h.mF().getUrl(), "dns_cost", Long.valueOf(com.baidu.adp.lib.webSocket.h.mF().mC()), "con_cost", Long.valueOf(com.baidu.adp.lib.webSocket.h.mF().mK()), "remote_ip", com.baidu.adp.lib.webSocket.h.mF().mB(), ETAG.KEY_LOCAL_DNS, com.baidu.adp.lib.webSocket.h.mF().getLocalDns(), "local_dns_bak", com.baidu.adp.lib.webSocket.h.mF().getLocalDnsBak(), "net", BdStatisticsManager.getInstance().getCurNetworkType());
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public static void perfWebSocketConTime() {
        try {
            com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem(BdStatsConstant.StatsType.PERFORMANCE);
            statsItem.append("action", "imconn");
            statsItem.append("con_cost", String.valueOf(com.baidu.adp.lib.webSocket.h.mF().mK()));
            statsItem.append("nettype", com.baidu.adp.lib.stats.d.getNetType(BdBaseApplication.getInst()));
            BdStatisticsManager.getInstance().performance("im", statsItem);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public static void a(String str, Message<?> message, int i, String str2, int i2, String str3) {
        int i3 = 0;
        long j = 0;
        if (message != null) {
            i3 = message.getCmd();
            j = message.getClientLogID();
        }
        debug(str, i3, j, i, str2, i2, str3);
    }
}
