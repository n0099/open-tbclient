package b.a.a.a.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.telephony.CellInfo;
import java.util.List;
/* loaded from: classes3.dex */
final class i extends Handler {
    private /* synthetic */ g As;

    /* renamed from: a  reason: collision with root package name */
    private byte[] f1062a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private i(g gVar, Looper looper) {
        super(looper);
        this.As = gVar;
        this.f1062a = new byte[0];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ i(g gVar, Looper looper, byte b2) {
        this(gVar, looper);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        super.handleMessage(message);
        if (this.As.f1054b) {
            try {
                switch (message.what) {
                    case 1:
                        if (this.As.g != null) {
                            sendEmptyMessageDelayed(1, 30000L);
                        }
                        if (this.As.An != null) {
                            List<CellInfo> list = null;
                            try {
                                list = this.As.An.getAllCellInfo();
                            } catch (Throwable th) {
                            }
                            this.As.Aq.onCellInfoChanged(list);
                            return;
                        }
                        return;
                    case 2:
                        z zVar = this.As.Ao;
                        synchronized (this.f1062a) {
                            if (zVar != null) {
                                this.As.a(zVar);
                            }
                        }
                        return;
                    default:
                        return;
                }
            } catch (Throwable th2) {
            }
        }
    }
}
