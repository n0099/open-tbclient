package cn.jiguang.service;

import android.content.Intent;
import cn.jpush.android.service.PushService;
/* loaded from: classes3.dex */
public final class a implements Runnable {
    private final int b;
    private final Intent c;
    private final PushService mQ;

    public a(PushService pushService, int i, Intent intent) {
        this.mQ = pushService;
        this.b = i;
        this.c = intent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.b) {
            case 1:
                this.mQ.runCreate();
                return;
            case 2:
                this.mQ.runStart(this.c);
                return;
            case 3:
                this.mQ.runDestroy();
                return;
            default:
                return;
        }
    }
}
