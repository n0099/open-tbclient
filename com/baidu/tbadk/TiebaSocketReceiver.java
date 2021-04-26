package com.baidu.tbadk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.httpNet.ImgHttpClient;
import d.a.c.e.p.j;
import d.a.i0.c0.a;
import org.apache.http.conn.params.ConnRoutePNames;
/* loaded from: classes3.dex */
public class TiebaSocketReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
            if (Build.VERSION.SDK_INT >= 24 || !j.z()) {
                return;
            }
            a.b(0, 0, 0, 1, 6);
            BdSocketLinkService.setAvailable(true);
            BdSocketLinkService.startService(false, "net succ");
            synchronized (ImgHttpClient.class) {
                ImgHttpClient.mHttpParams.removeParameter(ConnRoutePNames.DEFAULT_PROXY);
                ImgHttpClient.proxyHost = null;
            }
        } else if ("com.baidu.android.pushservice.action.BIND_SYNC".equals(intent.getAction())) {
            if (!j.z() || BdSocketLinkService.isOpen()) {
                TiebaStatic.eventStat(context, "baidupushservice_activate_tieba", "socket", 1, "iscon", 0);
                return;
            }
            a.b(0, 0, 0, 1, 7);
            BdSocketLinkService.startService(false, "frombaidupushservice");
            TiebaStatic.eventStat(context, "baidupushservice_activate_tieba", "socket", 1, "iscon", 1);
        } else {
            BdSocketLinkService.startService(false, "calling or boot ");
        }
    }
}
