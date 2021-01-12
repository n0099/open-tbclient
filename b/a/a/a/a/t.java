package b.a.a.a.a;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import com.tencent.map.geoloclite.tsa.TencentLiteLocationListener;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class t extends Handler {
    private /* synthetic */ p AR;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(p pVar, Looper looper) {
        super(looper);
        this.AR = pVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        byte[] bArr;
        TencentLiteLocationListener tencentLiteLocationListener;
        ad adVar;
        ad adVar2;
        int i;
        SparseArray sparseArray;
        int i2;
        ad adVar3;
        long j;
        long j2;
        long j3;
        ad adVar4;
        int i3;
        SparseArray sparseArray2;
        int i4;
        bArr = this.AR.f1070b;
        synchronized (bArr) {
            tencentLiteLocationListener = this.AR.Aw;
        }
        if (tencentLiteLocationListener == null) {
            return;
        }
        switch (message.what) {
            case 1001:
                adVar3 = this.AR.AP;
                if (adVar3 != null) {
                    j3 = this.AR.x;
                    if (j3 > 0 && tencentLiteLocationListener != null) {
                        adVar4 = this.AR.AP;
                        i3 = this.AR.z;
                        sparseArray2 = p.Au;
                        i4 = this.AR.z;
                        tencentLiteLocationListener.onLocationChanged(adVar4, i3, (String) sparseArray2.get(i4));
                    }
                }
                j = this.AR.x;
                if (j > 0) {
                    j2 = this.AR.x;
                    sendEmptyMessageDelayed(1001, j2);
                    return;
                }
                return;
            case 1002:
                adVar = this.AR.AP;
                if (adVar == null || tencentLiteLocationListener == null) {
                    return;
                }
                adVar2 = this.AR.AP;
                i = this.AR.z;
                sparseArray = p.Au;
                i2 = this.AR.z;
                tencentLiteLocationListener.onLocationChanged(adVar2, i, (String) sparseArray.get(i2));
                return;
            case 1003:
                Bundle data = message.getData();
                if (data != null) {
                    String string = data.getString("name");
                    int i5 = data.getInt("status");
                    String string2 = data.getString("desc");
                    if (tencentLiteLocationListener == null || string == null || string2 == null) {
                        return;
                    }
                    tencentLiteLocationListener.onStatusUpdate(string, i5, string2);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
