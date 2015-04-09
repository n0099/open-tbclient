package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
/* loaded from: classes.dex */
class ab extends Handler {
    final /* synthetic */ u LA;

    private ab(u uVar) {
        this.LA = uVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ab(u uVar, ab abVar) {
        this(uVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == 1) {
            if (u.a(this.LA) < 360.0f) {
                long uptimeMillis = SystemClock.uptimeMillis();
                u.a(this.LA, uptimeMillis);
                u.b(this.LA, uptimeMillis + 200);
                u uVar = this.LA;
                u.a(uVar, u.a(uVar) + ((((float) (uptimeMillis - u.b(this.LA))) / 1000.0f) * u.c(this.LA)));
                sendEmptyMessageAtTime(1, u.d(this.LA));
                u uVar2 = this.LA;
                u.a(uVar2, u.e(uVar2) + 1);
            } else {
                u.a(this.LA, 360.0f);
                u.a(this.LA, 0);
            }
            u.b(this.LA, u.e(this.LA) % 6);
            this.LA.invalidate();
        }
    }
}
