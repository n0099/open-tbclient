package cn.jpush.android.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import cn.jiguang.d.d.o;
/* loaded from: classes3.dex */
public class AlarmReceiver extends BroadcastReceiver implements Runnable {
    private static final String TAG = "AlarmReceiver";
    private Context appContext;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.appContext = context.getApplicationContext();
        cn.jiguang.api.e.a("SDK_MAIN", this, new int[0]);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (cn.jiguang.d.a.d(this.appContext)) {
            if (cn.jiguang.d.a.d.i(this.appContext)) {
                cn.jiguang.d.b.a.a(this.appContext, false);
            } else {
                o.a(this.appContext, false);
            }
        }
    }
}
