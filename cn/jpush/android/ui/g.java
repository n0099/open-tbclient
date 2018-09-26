package cn.jpush.android.ui;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
final class g extends Handler {
    private final WeakReference<PushActivity> a;

    public g(PushActivity pushActivity) {
        this.a = new WeakReference<>(pushActivity);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        cn.jpush.android.data.b bVar = (cn.jpush.android.data.b) message.obj;
        PushActivity pushActivity = this.a.get();
        if (pushActivity == null) {
            return;
        }
        switch (message.what) {
            case 1:
                pushActivity.setRequestedOrientation(1);
                PushActivity.a(pushActivity, bVar);
                return;
            case 2:
                pushActivity.b();
                return;
            default:
                return;
        }
    }
}
