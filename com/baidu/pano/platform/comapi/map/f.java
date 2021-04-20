package com.baidu.pano.platform.comapi.map;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes2.dex */
public class f extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e f9052a;

    public f(e eVar) {
        this.f9052a = eVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i = message.what;
        if (i == 1001) {
            this.f9052a.a(-message.arg1, -message.arg2);
        } else if (i == 1002) {
            int i2 = message.arg1;
            float f2 = i2;
            if (f2 > 60.0f || f2 < 20.0f) {
                this.f9052a.k();
            } else {
                this.f9052a.a(i2);
            }
        }
    }
}
