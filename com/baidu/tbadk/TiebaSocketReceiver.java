package com.baidu.tbadk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.a.f;
import com.baidu.tbadk.lcs.a;
import org.apache.http.conn.params.ConnRoutePNames;
/* loaded from: classes.dex */
public class TiebaSocketReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
            if (j.kV()) {
                a.b(0, 0, 0, 1, 6);
                BdSocketLinkService.setAvailable(true);
                BdSocketLinkService.startService(false, "net succ");
                synchronized (f.class) {
                    f.aDH.removeParameter(ConnRoutePNames.DEFAULT_PROXY);
                    f.aDF = null;
                }
            }
        } else if ("com.baidu.android.pushservice.action.BIND_SYNC".equals(intent.getAction())) {
            if (j.kV() && !BdSocketLinkService.isOpen()) {
                a.b(0, 0, 0, 1, 7);
                BdSocketLinkService.startService(false, "frombaidupushservice");
                TiebaStatic.eventStat(context, "baidupushservice_activate_tieba", "socket", 1, "iscon", 1);
                return;
            }
            TiebaStatic.eventStat(context, "baidupushservice_activate_tieba", "socket", 1, "iscon", 0);
        } else {
            BdSocketLinkService.startService(false, "calling or boot ");
        }
    }
}
