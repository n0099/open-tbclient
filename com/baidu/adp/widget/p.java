package com.baidu.adp.widget;

import android.os.Handler;
import android.os.Message;
import com.baidu.location.LocationClientOption;
/* loaded from: classes.dex */
class p extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ o f601a;

    private p(o oVar) {
        this.f601a = oVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case LocationClientOption.MIN_SCAN_SPAN /* 1000 */:
                o.a(this.f601a);
                return;
            default:
                return;
        }
    }
}
