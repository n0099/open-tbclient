package com.baidu.adp.lib.debug.b;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
/* loaded from: classes.dex */
class n extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j f413a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(j jVar) {
        this.f413a = jVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            switch (message.what) {
                case 0:
                    this.f413a.m.setText("fps:" + com.baidu.adp.lib.debug.b.a());
                    break;
                case 1:
                    this.f413a.n.setText("mem:" + com.baidu.adp.lib.debug.b.b());
                    break;
                case 2:
                    this.f413a.o.setText("cpu:" + com.baidu.adp.lib.debug.b.c());
                    break;
                case 3:
                    this.f413a.p.setText("gc:" + com.baidu.adp.lib.debug.b.d());
                    break;
                case 4:
                    this.f413a.q.setText("strictMode:" + com.baidu.adp.lib.debug.b.e());
                    break;
                case 5:
                    Log.i("Monitor", "battery run");
                    this.f413a.r.setText("battery:" + com.baidu.adp.lib.debug.b.f());
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
