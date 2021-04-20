package com.alipay.sdk.widget;

import android.os.Handler;
import com.alipay.sdk.widget.a;
/* loaded from: classes.dex */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f2048a;

    public b(a aVar) {
        this.f2048a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        a.AlertDialogC0017a alertDialogC0017a;
        a.AlertDialogC0017a alertDialogC0017a2;
        a.AlertDialogC0017a alertDialogC0017a3;
        Handler handler;
        a.AlertDialogC0017a alertDialogC0017a4;
        boolean z;
        alertDialogC0017a = this.f2048a.f2043e;
        if (alertDialogC0017a == null) {
            a aVar = this.f2048a;
            a aVar2 = this.f2048a;
            aVar.f2043e = new a.AlertDialogC0017a(aVar2.f2044f);
            alertDialogC0017a4 = this.f2048a.f2043e;
            z = this.f2048a.k;
            alertDialogC0017a4.setCancelable(z);
        }
        try {
            alertDialogC0017a2 = this.f2048a.f2043e;
            if (alertDialogC0017a2.isShowing()) {
                return;
            }
            alertDialogC0017a3 = this.f2048a.f2043e;
            alertDialogC0017a3.show();
            handler = this.f2048a.l;
            handler.sendEmptyMessageDelayed(1, 15000L);
        } catch (Exception e2) {
            com.alipay.sdk.util.c.a(e2);
        }
    }
}
