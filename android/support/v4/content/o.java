package android.support.v4.content;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends Handler {
    private o() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ o(j jVar) {
        this();
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        n nVar = (n) message.obj;
        switch (message.what) {
            case 1:
                nVar.f320a.e(nVar.b[0]);
                return;
            case 2:
                nVar.f320a.b((Object[]) nVar.b);
                return;
            default:
                return;
        }
    }
}
