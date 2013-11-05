package com.baidu.adp.lib.debug.b;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
/* loaded from: classes.dex */
class n extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j f475a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(j jVar) {
        this.f475a = jVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            switch (message.what) {
                case 0:
                    this.f475a.n.setText("fps:" + com.baidu.adp.lib.debug.b.a());
                    break;
                case 1:
                    this.f475a.o.setText("mem:" + com.baidu.adp.lib.debug.b.b());
                    break;
                case 2:
                    this.f475a.p.setText("cpu:" + com.baidu.adp.lib.debug.b.c());
                    break;
                case 3:
                    this.f475a.q.setText("gc:" + com.baidu.adp.lib.debug.b.d());
                    break;
                case 4:
                    this.f475a.r.setText("strictMode:" + com.baidu.adp.lib.debug.b.e());
                    break;
                case 5:
                    Log.i("Monitor", "battery run");
                    this.f475a.s.setText("battery:" + com.baidu.adp.lib.debug.b.i());
                    break;
                case 6:
                    this.f475a.v.setText("-T:" + com.baidu.adp.lib.debug.b.f().a() + "kb");
                    this.f475a.t.setText("-S:" + com.baidu.adp.lib.debug.b.f().c() + "kb");
                    this.f475a.u.setText("-R:" + com.baidu.adp.lib.debug.b.f().b() + "kb");
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
