package com.baidu.platform.comapi.walknavi.g;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f4346a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(a aVar) {
        this.f4346a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        Handler handler2;
        Message obtain = Message.obtain();
        obtain.what = 1;
        handler = this.f4346a.Q;
        if (handler != null) {
            handler2 = this.f4346a.Q;
            handler2.dispatchMessage(obtain);
        }
    }
}
