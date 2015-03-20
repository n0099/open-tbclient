package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
/* loaded from: classes.dex */
class ab extends Handler {
    final /* synthetic */ u Ly;

    private ab(u uVar) {
        this.Ly = uVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ab(u uVar, ab abVar) {
        this(uVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == 1) {
            if (u.a(this.Ly) < 360.0f) {
                long uptimeMillis = SystemClock.uptimeMillis();
                u.a(this.Ly, uptimeMillis);
                u.b(this.Ly, uptimeMillis + 200);
                u uVar = this.Ly;
                u.a(uVar, u.a(uVar) + ((((float) (uptimeMillis - u.b(this.Ly))) / 1000.0f) * u.c(this.Ly)));
                sendEmptyMessageAtTime(1, u.d(this.Ly));
                u uVar2 = this.Ly;
                u.a(uVar2, u.e(uVar2) + 1);
            } else {
                u.a(this.Ly, 360.0f);
                u.a(this.Ly, 0);
            }
            u.b(this.Ly, u.e(this.Ly) % 6);
            this.Ly.invalidate();
        }
    }
}
