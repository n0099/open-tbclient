package com.baidu.adp.widget;

import android.os.Handler;
import android.os.Message;
import com.baidu.location.LocationClientOption;
/* loaded from: classes.dex */
class r extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ q f609a;

    private r(q qVar) {
        this.f609a = qVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case LocationClientOption.MIN_SCAN_SPAN /* 1000 */:
                q.a(this.f609a);
                return;
            default:
                return;
        }
    }
}
