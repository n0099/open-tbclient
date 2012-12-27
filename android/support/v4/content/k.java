package android.support.v4.content;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends Handler {
    private k() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ k(f fVar) {
        this();
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        j jVar = (j) message.obj;
        switch (message.what) {
            case 1:
                jVar.a.e(jVar.b[0]);
                return;
            case 2:
                jVar.a.b(jVar.b);
                return;
            default:
                return;
        }
    }
}
