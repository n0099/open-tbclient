package cn.jpush.android.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes3.dex */
public class TagAliasReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            cn.jpush.android.d.f.c("TagAliasReceiver", "TagAliasOperator onReceive intent is null");
            return;
        }
        long longExtra = intent.getLongExtra("tagalias_seqid", -1L);
        int intExtra = intent.getIntExtra("tagalias_errorcode", 0);
        if (longExtra != -1) {
            f.a().a(context.getApplicationContext(), longExtra, intExtra, intent);
        }
    }
}
