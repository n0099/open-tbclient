package com.baidu.tbadk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.httpNet.ImgHttpClient;
/* loaded from: classes.dex */
public class TiebaSocketReceiver extends BroadcastReceiver {
    private static final String TAG = "TiebaIMReceiver";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
            if (i.fg()) {
                TiebaStatic.imLog("net change", TAG, "succ");
                BdSocketLinkService.setAvailable(true);
                BdSocketLinkService.startService(false, "net succ");
                synchronized (ImgHttpClient.class) {
                    ImgHttpClient.Kp.removeParameter("http.route.default-proxy");
                    ImgHttpClient.Kn = null;
                }
                return;
            }
            TiebaStatic.imLog("net change", TAG, "failed");
            return;
        }
        BdSocketLinkService.startService(false, "calling or boot ");
    }
}
