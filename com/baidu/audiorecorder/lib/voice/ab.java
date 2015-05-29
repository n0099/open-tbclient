package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
/* loaded from: classes.dex */
class ab extends Handler {
    final /* synthetic */ u Ls;

    private ab(u uVar) {
        this.Ls = uVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ab(u uVar, ab abVar) {
        this(uVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == 1) {
            if (u.a(this.Ls) < 360.0f) {
                long uptimeMillis = SystemClock.uptimeMillis();
                u.a(this.Ls, uptimeMillis);
                u.b(this.Ls, uptimeMillis + 200);
                u uVar = this.Ls;
                u.a(uVar, u.a(uVar) + ((((float) (uptimeMillis - u.b(this.Ls))) / 1000.0f) * u.c(this.Ls)));
                sendEmptyMessageAtTime(1, u.d(this.Ls));
                u uVar2 = this.Ls;
                u.a(uVar2, u.e(uVar2) + 1);
            } else {
                u.a(this.Ls, 360.0f);
                u.a(this.Ls, 0);
            }
            u.b(this.Ls, u.e(this.Ls) % 6);
            this.Ls.invalidate();
        }
    }
}
