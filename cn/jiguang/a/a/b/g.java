package cn.jiguang.a.a.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.baiduarsdk.ArBridge;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class g extends Handler {
    final /* synthetic */ f kf;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(f fVar, Looper looper) {
        super(looper);
        this.kf = fVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        c cVar;
        c cVar2;
        boolean z;
        switch (message.what) {
            case 1000:
                z = this.kf.k;
                if (z) {
                    return;
                }
                this.kf.k = true;
                f.b(this.kf);
                f.c(this.kf);
                return;
            case 1001:
            case 1003:
            case 1004:
            case ArBridge.MessageType.MSG_TYPE_RESUME_MUSIC /* 1005 */:
                cVar = this.kf.kd;
                if (cVar != null) {
                    cVar2 = this.kf.kd;
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
