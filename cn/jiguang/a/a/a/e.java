package cn.jiguang.a.a.a;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes3.dex */
final class e implements Handler.Callback {
    final /* synthetic */ d ks;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.ks = dVar;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        if (message == null || message.what != 1) {
            return false;
        }
        Thread thread = (Thread) message.obj;
        if (thread != null) {
            thread.interrupt();
        }
        if (message.getData() != null) {
            message.getData().getString("ip");
            return false;
        }
        return false;
    }
}
