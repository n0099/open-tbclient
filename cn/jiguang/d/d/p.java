package cn.jiguang.d.d;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class p extends Handler {
    final /* synthetic */ Context a;
    final /* synthetic */ o mj;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(o oVar, Looper looper, Context context) {
        super(looper);
        this.mj = oVar;
        this.a = context;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        switch (message.what) {
            case 8000:
                this.mj.d(this.a);
                return;
            default:
                return;
        }
    }
}
