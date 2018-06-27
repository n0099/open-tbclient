package com.baidu.location.c;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class i extends Handler {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(a aVar) {
        this.a = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                try {
                    this.a.f();
                    return;
                } catch (Exception e) {
                    return;
                }
            case 2:
                try {
                    this.a.g();
                    return;
                } catch (Exception e2) {
                    return;
                }
            default:
                return;
        }
    }
}
