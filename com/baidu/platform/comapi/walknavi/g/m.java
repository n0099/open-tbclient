package com.baidu.platform.comapi.walknavi.g;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f4566a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(a aVar) {
        this.f4566a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        Handler handler2;
        Message obtain = Message.obtain();
        obtain.what = 1;
        handler = this.f4566a.G;
        if (handler != null) {
            handler2 = this.f4566a.G;
            handler2.dispatchMessage(obtain);
        }
    }
}
