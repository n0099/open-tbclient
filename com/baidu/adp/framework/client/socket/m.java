package com.baidu.adp.framework.client.socket;

import android.text.TextUtils;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class m {
    public static void a(String str, int i, int i2, String str2, int i3, String str3) {
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
                linkedList.add(com.baidu.tbadk.core.frameworkData.a.CMD);
                linkedList.add(Integer.valueOf(i));
            }
            if (i2 != 0) {
                linkedList.add("seqID");
                linkedList.add(Integer.valueOf(i2));
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
            com.baidu.adp.lib.stats.f.c().b("socket", linkedList.toArray());
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public static void a() {
        try {
            com.baidu.adp.lib.stats.f.c().b("socket", "url", com.baidu.adp.lib.webSocket.m.a().o(), "dns_cost", Long.valueOf(com.baidu.adp.lib.webSocket.m.a().j()), TiebaStatic.CON_COST, Long.valueOf(com.baidu.adp.lib.webSocket.m.a().l()), "remote_ip", com.baidu.adp.lib.webSocket.m.a().k(), "local_dns", com.baidu.adp.lib.webSocket.m.a().m(), "local_dns_bak", com.baidu.adp.lib.webSocket.m.a().n(), "net", com.baidu.adp.lib.stats.f.c().e());
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public static void a(String str, Message<?> message, int i, String str2, String str3) {
        a(str, message != null ? message.getCmd() : 0, i, str2, 0, str3);
    }

    public static void a(String str, Message<?> message, int i, String str2, int i2, String str3) {
        int i3 = 0;
        if (message != null) {
            i3 = message.getCmd();
        }
        a(str, i3, i, str2, i2, str3);
    }
}
