package com.baidu.tbadk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
public class TiebaSocketReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
            com.baidu.tbadk.core.log.a.a(UtilHelper.d(context));
            if (UtilHelper.a()) {
                TiebaStatic.b("net change", "TiebaIMReceiver", "succ");
                com.baidu.adp.framework.e.c.a();
                com.baidu.adp.framework.e.c.a(false, "net succ");
                return;
            }
            TiebaStatic.b("net change", "TiebaIMReceiver", "failed");
            return;
        }
        com.baidu.adp.framework.e.c.a();
        com.baidu.adp.framework.e.c.a(false, "calling or boot ");
    }
}
