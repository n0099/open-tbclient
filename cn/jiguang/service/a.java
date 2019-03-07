package cn.jiguang.service;

import android.content.Intent;
import cn.jpush.android.service.PushService;
/* loaded from: classes3.dex */
public final class a implements Runnable {
    private final int b;
    private final Intent c;
    private final PushService mP;

    public a(PushService pushService, int i, Intent intent) {
        this.mP = pushService;
        this.b = i;
        this.c = intent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.b) {
            case 1:
                this.mP.runCreate();
                return;
            case 2:
                this.mP.runStart(this.c);
                return;
            case 3:
                this.mP.runDestroy();
                return;
            default:
                return;
        }
    }
}
