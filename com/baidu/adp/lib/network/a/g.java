package com.baidu.adp.lib.network.a;

import android.os.Handler;
import android.os.Message;
import com.baidu.location.LocationClientOption;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class g extends Handler {
    final /* synthetic */ f a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.a = fVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        Handler handler;
        int i;
        int i2;
        int[] iArr;
        int i3;
        int[] iArr2;
        int[] iArr3;
        int i4;
        Handler handler2;
        Handler handler3;
        int[] iArr4;
        int i5;
        super.handleMessage(message);
        switch (message.what) {
            case 1:
                handler = this.a.d;
                handler.removeMessages(1);
                StringBuilder sb = new StringBuilder("this is reconn time:");
                i = this.a.b;
                com.baidu.adp.lib.util.e.d(sb.append(i).toString());
                a.a(true, "time to reconnStragety");
                f fVar = this.a;
                i2 = fVar.b;
                fVar.b = i2 + 1;
                iArr = this.a.c;
                if (iArr != null) {
                    i3 = this.a.b;
                    iArr2 = this.a.c;
                    if (i3 < iArr2.length) {
                        StringBuilder sb2 = new StringBuilder("Next will be delay:");
                        iArr3 = this.a.c;
                        i4 = this.a.b;
                        com.baidu.adp.lib.util.e.d(sb2.append(iArr3[i4]).toString());
                        handler2 = this.a.d;
                        handler3 = this.a.d;
                        Message obtainMessage = handler3.obtainMessage(1);
                        iArr4 = this.a.c;
                        i5 = this.a.b;
                        handler2.sendMessageDelayed(obtainMessage, iArr4[i5] * LocationClientOption.MIN_SCAN_SPAN);
                        return;
                    }
                }
                this.a.b();
                return;
            default:
                return;
        }
    }
}
