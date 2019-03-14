package com.baidu.pano.platform.comapi.map;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class f extends Handler {
    final /* synthetic */ e a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.a = eVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == 1001) {
            this.a.a(-message.arg1, -message.arg2);
        } else if (message.what == 1002) {
            float f = message.arg1;
            if (f > 60.0f || f < 20.0f) {
                this.a.k();
            } else {
                this.a.a(message.arg1);
            }
        }
    }
}
