package com.baidu.android.moplus;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.android.common.util.Util;
/* loaded from: classes.dex */
public class MoPlusReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (TextUtils.isEmpty(action) || action.equals("com.baidu.android.pushservice.action.BIND_SYNC")) {
            return;
        }
        com.baidu.android.moplus.util.b.e(context, false);
        if (com.baidu.android.moplus.util.c.a(context.getApplicationContext()).a() || (context.getPackageName().equals(com.baidu.android.moplus.util.b.d(context)) && com.baidu.android.moplus.util.c.a(context.getApplicationContext()).b(context))) {
            Intent intent2 = new Intent(intent);
            intent2.setClass(context, MoPlusService.class);
            context.getApplicationContext().startService(intent2);
        } else if (Util.hasOtherServiceRuninMyPid(context.getApplicationContext(), MoPlusService.class.getName())) {
        } else {
            Process.killProcess(Process.myPid());
        }
    }
}
