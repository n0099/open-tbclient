package com.baidu.pano.platform.comapi.map;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class f extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f2734a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.f2734a = eVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == 1001) {
            this.f2734a.a(-message.arg1, -message.arg2);
        } else if (message.what == 1002) {
            float f = message.arg1;
            if (f > 60.0f || f < 20.0f) {
                this.f2734a.k();
            } else {
                this.f2734a.a(message.arg1);
            }
        }
    }
}
