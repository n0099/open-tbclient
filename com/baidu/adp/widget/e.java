package com.baidu.adp.widget;

import android.os.Handler;
import android.os.Message;
import com.baidu.location.LocationClientOption;
/* loaded from: classes.dex */
class e extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f488a;

    private e(d dVar) {
        this.f488a = dVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ e(d dVar, e eVar) {
        this(dVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case LocationClientOption.MIN_SCAN_SPAN /* 1000 */:
                d.a(this.f488a);
                return;
            default:
                return;
        }
    }
}
