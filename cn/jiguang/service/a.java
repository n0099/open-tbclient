package cn.jiguang.service;

import android.content.Intent;
import cn.jpush.android.service.PushService;
/* loaded from: classes3.dex */
public final class a implements Runnable {
    private final int b;
    private final Intent c;
    private final PushService md;

    public a(PushService pushService, int i, Intent intent) {
        this.md = pushService;
        this.b = i;
        this.c = intent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.b) {
            case 1:
                this.md.runCreate();
                return;
            case 2:
                this.md.runStart(this.c);
                return;
            case 3:
                this.md.runDestroy();
                return;
            default:
                return;
        }
    }
}
