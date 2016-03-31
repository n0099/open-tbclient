package com.baidu.adp.framework.client.socket;

import android.text.TextUtils;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.Plugin;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class k {
    public static void a(String str, int i, long j, int i2, String str2, int i3, String str3) {
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
            linkedList.add(Plugin.SO_LIB_DIR_NAME);
            linkedList.add(str);
            if (i != 0) {
                linkedList.add(IntentConfig.CMD);
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
            com.baidu.adp.lib.stats.a.hz().a("socket", j, i2 == 0 ? null : String.valueOf(i2 & 4294967295L), linkedList.toArray());
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public static void a(String str, int i, int i2, String str2, int i3, String str3) {
        a(str, i, -1L, i2, str2, i3, str3);
    }

    public static void eI() {
        try {
            com.baidu.adp.lib.stats.a.hz().c("socket", "url", com.baidu.adp.lib.webSocket.h.jR().getUrl(), "dns_cost", Long.valueOf(com.baidu.adp.lib.webSocket.h.jR().jO()), TiebaStatic.CON_COST, Long.valueOf(com.baidu.adp.lib.webSocket.h.jR().jY()), "remote_ip", com.baidu.adp.lib.webSocket.h.jR().jN(), "local_dns", com.baidu.adp.lib.webSocket.h.jR().jx(), "local_dns_bak", com.baidu.adp.lib.webSocket.h.jR().jy(), "net", com.baidu.adp.lib.stats.a.hz().hL());
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
        a(str, i3, j, i, str2, i2, str3);
    }
}
