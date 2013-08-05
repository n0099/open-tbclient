package android.support.v4.app;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ n f286a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.f286a = nVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                if (this.f286a.mStopped) {
                    this.f286a.doReallyStop(false);
                    return;
                }
                return;
            case 2:
                this.f286a.onResumeFragments();
                this.f286a.mFragments.e();
                return;
            default:
                super.handleMessage(message);
                return;
        }
    }
}
