package com.baidu.platform.comapi.walknavi.g;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f4343a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(a aVar) {
        this.f4343a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        Handler handler2;
        Message obtain = Message.obtain();
        obtain.what = 1;
        handler = this.f4343a.Q;
        if (handler != null) {
            handler2 = this.f4343a.Q;
            handler2.dispatchMessage(obtain);
        }
    }
}
