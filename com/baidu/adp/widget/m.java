package com.baidu.adp.widget;

import android.os.Handler;
import android.os.Message;
import com.baidu.location.LocationClientOption;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class m extends Handler {
    final /* synthetic */ l a;

    private m(l lVar) {
        this.a = lVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ m(l lVar, byte b) {
        this(lVar);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        switch (message.what) {
            case LocationClientOption.MIN_SCAN_SPAN /* 1000 */:
                l.a(this.a);
                return;
            default:
                return;
        }
    }
}
