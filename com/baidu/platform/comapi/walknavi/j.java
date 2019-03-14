package com.baidu.platform.comapi.walknavi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.telephony.TelephonyManager;
import com.baidu.sapi2.activity.social.WXLoginActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class j extends BroadcastReceiver {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(b bVar) {
        this.a = bVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra(WXLoginActivity.KEY_BASE_RESP_STATE);
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
        context2 = this.a.y;
        int a = com.baidu.platform.comapi.wnplatform.o.h.a(context2);
        if (a != 0) {
            com.baidu.platform.comapi.walknavi.b.a.a = a;
            context3 = this.a.y;
            com.baidu.platform.comapi.wnplatform.o.h.a(context3, 0);
        }
    }

    private void b(Context context) {
        Handler handler;
        handler = this.a.z;
        handler.postDelayed(new k(this), 2000L);
    }
}
