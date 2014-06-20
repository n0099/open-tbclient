package com.baidu.android.moplus;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class MoPlusReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (TextUtils.isEmpty(action) || action.equals("com.baidu.android.pushservice.action.BIND_SYNC")) {
            return;
        }
        if (action.equals("android.net.conn.CONNECTIVITY_CHANGE") && com.baidu.android.moplus.util.a.b(context, com.baidu.android.moplus.util.a.k(context)) && com.baidu.android.systemmonitor.util.b.a(context)) {
            new com.baidu.android.a.a(context).a();
        }
        com.baidu.android.moplus.util.a.e(context, false);
        if (com.baidu.android.moplus.util.d.a(context.getApplicationContext()).a() || (context.getPackageName().equals(com.baidu.android.moplus.util.a.d(context)) && com.baidu.android.moplus.util.d.a(context.getApplicationContext()).b(context))) {
            Intent intent2 = new Intent(intent);
            intent2.setClass(context, MoPlusService.class);
            context.getApplicationContext().startService(intent2);
        } else if (com.baidu.android.nebula.a.f.a(context.getApplicationContext(), MoPlusService.class.getName())) {
        } else {
            Process.killProcess(Process.myPid());
        }
    }
}
