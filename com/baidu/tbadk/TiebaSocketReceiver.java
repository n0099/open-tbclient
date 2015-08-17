package com.baidu.tbadk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.util.httpNet.f;
/* loaded from: classes.dex */
public class TiebaSocketReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
            if (i.iO()) {
                BdSocketLinkService.setAvailable(true);
                BdSocketLinkService.startService(false, "net succ");
                synchronized (f.class) {
                    f.abV.removeParameter("http.route.default-proxy");
                    f.abT = null;
                }
                return;
            }
            return;
        }
        BdSocketLinkService.startService(false, "calling or boot ");
    }
}
