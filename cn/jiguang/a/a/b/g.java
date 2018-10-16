package cn.jiguang.a.a.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class g extends Handler {
    final /* synthetic */ f kL;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(f fVar, Looper looper) {
        super(looper);
        this.kL = fVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        c cVar;
        c cVar2;
        boolean z;
        switch (message.what) {
            case 1000:
                z = this.kL.k;
                if (z) {
                    return;
                }
                this.kL.k = true;
                f.b(this.kL);
                f.c(this.kL);
                return;
            case 1001:
            case 1003:
            case 1004:
            case 1005:
                cVar = this.kL.kJ;
                if (cVar != null) {
                    cVar2 = this.kL.kJ;
                    cVar2.a(message);
                    return;
                }
                return;
            case 1002:
            default:
                return;
        }
    }
}
