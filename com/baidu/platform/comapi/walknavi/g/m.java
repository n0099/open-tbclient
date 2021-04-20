package com.baidu.platform.comapi.walknavi.g;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes2.dex */
public class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f9698a;

    public m(a aVar) {
        this.f9698a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        Handler handler2;
        Message obtain = Message.obtain();
        obtain.what = 1;
        handler = this.f9698a.Q;
        if (handler != null) {
            handler2 = this.f9698a.Q;
            handler2.dispatchMessage(obtain);
        }
    }
}
