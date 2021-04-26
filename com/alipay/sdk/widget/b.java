package com.alipay.sdk.widget;

import android.os.Handler;
import com.alipay.sdk.widget.a;
/* loaded from: classes.dex */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f2007a;

    public b(a aVar) {
        this.f2007a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        a.AlertDialogC0017a alertDialogC0017a;
        a.AlertDialogC0017a alertDialogC0017a2;
        a.AlertDialogC0017a alertDialogC0017a3;
        Handler handler;
        a.AlertDialogC0017a alertDialogC0017a4;
        boolean z;
        alertDialogC0017a = this.f2007a.f2001e;
        if (alertDialogC0017a == null) {
            a aVar = this.f2007a;
            a aVar2 = this.f2007a;
            aVar.f2001e = new a.AlertDialogC0017a(aVar2.f2002f);
            alertDialogC0017a4 = this.f2007a.f2001e;
            z = this.f2007a.k;
            alertDialogC0017a4.setCancelable(z);
        }
        try {
            alertDialogC0017a2 = this.f2007a.f2001e;
            if (alertDialogC0017a2.isShowing()) {
                return;
            }
            alertDialogC0017a3 = this.f2007a.f2001e;
            alertDialogC0017a3.show();
            handler = this.f2007a.l;
            handler.sendEmptyMessageDelayed(1, 15000L);
        } catch (Exception e2) {
            com.alipay.sdk.util.c.a(e2);
        }
    }
}
