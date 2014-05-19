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
            com.baidu.tbadk.core.log.a.a(UtilHelper.getNetStatusInfo(context));
            if (UtilHelper.isNetOk()) {
                TiebaStatic.imLog("net change", "TiebaIMReceiver", "succ");
                com.baidu.adp.framework.c.c.a().a(false, "net succ");
                return;
            }
            TiebaStatic.imLog("net change", "TiebaIMReceiver", "failed");
            return;
        }
        com.baidu.adp.framework.c.c.a().a(false, "calling or boot ");
    }
}
