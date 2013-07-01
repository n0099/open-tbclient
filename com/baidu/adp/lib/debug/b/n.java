package com.baidu.adp.lib.debug.b;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
/* loaded from: classes.dex */
class n extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j f166a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(j jVar) {
        this.f166a = jVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            switch (message.what) {
                case 0:
                    this.f166a.m.setText("fps:" + com.baidu.adp.lib.debug.b.a());
                    break;
                case 1:
                    this.f166a.n.setText("mem:" + com.baidu.adp.lib.debug.b.b());
                    break;
                case 2:
                    this.f166a.o.setText("cpu:" + com.baidu.adp.lib.debug.b.c());
                    break;
                case 3:
                    this.f166a.p.setText("gc:" + com.baidu.adp.lib.debug.b.d());
                    break;
                case 4:
                    this.f166a.q.setText("strictMode:" + com.baidu.adp.lib.debug.b.e());
                    break;
                case 5:
                    Log.i("Monitor", "battery run");
                    this.f166a.r.setText("battery:" + com.baidu.adp.lib.debug.b.f());
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
