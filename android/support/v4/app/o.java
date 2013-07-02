package android.support.v4.app;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends Handler {
    final /* synthetic */ n a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.a = nVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                if (this.a.mStopped) {
                    this.a.doReallyStop(false);
                    return;
                }
                return;
            case 2:
                this.a.onResumeFragments();
                this.a.mFragments.e();
                return;
            default:
                super.handleMessage(message);
                return;
        }
    }
}
