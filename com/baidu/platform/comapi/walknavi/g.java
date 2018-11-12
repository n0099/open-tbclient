package com.baidu.platform.comapi.walknavi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.telephony.TelephonyManager;
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class g extends BroadcastReceiver {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar) {
        this.a = bVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("state");
        if (TelephonyManager.EXTRA_STATE_RINGING.equals(stringExtra)) {
            a(context);
        } else if (TelephonyManager.EXTRA_STATE_OFFHOOK.equals(stringExtra)) {
            a(context);
        } else if (TelephonyManager.EXTRA_STATE_IDLE.equals(stringExtra)) {
            b(context);
        }
    }

    private void a(Context context) {
        Context context2;
        Context context3;
        context2 = this.a.x;
        int a = com.baidu.platform.comapi.wnplatform.o.g.a(context2);
        if (a != 0) {
            com.baidu.platform.comapi.walknavi.b.a.a = a;
            context3 = this.a.x;
            com.baidu.platform.comapi.wnplatform.o.g.a(context3, 0);
        }
    }

    private void b(Context context) {
        Handler handler;
        handler = this.a.y;
        handler.postDelayed(new h(this), SystemScreenshotManager.DELAY_TIME);
    }
}
