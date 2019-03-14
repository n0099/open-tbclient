package cn.jiguang.a.a.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class g extends Handler {
    final /* synthetic */ f kN;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(f fVar, Looper looper) {
        super(looper);
        this.kN = fVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        c cVar;
        c cVar2;
        boolean z;
        switch (message.what) {
            case 1000:
                z = this.kN.k;
                if (z) {
                    return;
                }
                this.kN.k = true;
                f.b(this.kN);
                f.c(this.kN);
                return;
            case 1001:
            case 1003:
            case 1004:
            case 1005:
                cVar = this.kN.kL;
                if (cVar != null) {
                    cVar2 = this.kN.kL;
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
