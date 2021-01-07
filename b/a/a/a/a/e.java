package b.a.a.a.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.telephony.CellLocation;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
/* loaded from: classes4.dex */
final class e extends Handler {
    private /* synthetic */ c Am;

    /* renamed from: a  reason: collision with root package name */
    private byte[] f1062a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private e(c cVar, Looper looper) {
        super(looper);
        this.Am = cVar;
        this.f1062a = new byte[0];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ e(c cVar, Looper looper, byte b2) {
        this(cVar, looper);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        CellLocation cellLocation;
        SignalStrength signalStrength;
        TelephonyManager telephonyManager;
        Handler handler;
        super.handleMessage(message);
        if (this.Am.f1055b) {
            try {
                switch (message.what) {
                    case 1:
                        handler = this.Am.j;
                        if (handler != null) {
                            sendEmptyMessageDelayed(1, 30000L);
                        }
                        this.Am.Ak.onCellLocationChanged(c.F(this.Am.Bm.f1082a));
                        return;
                    case 2:
                        cellLocation = this.Am.Ah;
                        signalStrength = this.Am.Ai;
                        if (cellLocation != null) {
                            telephonyManager = this.Am.d;
                            z a2 = z.a(telephonyManager, cellLocation, signalStrength);
                            synchronized (this.f1062a) {
                                if (a2 != null) {
                                    a2.a(c.b(this.Am.Bm.f1082a));
                                    this.Am.a((ac) a2);
                                }
                            }
                            return;
                        }
                        return;
                    default:
                        return;
                }
            } catch (Throwable th) {
            }
        }
    }
}
