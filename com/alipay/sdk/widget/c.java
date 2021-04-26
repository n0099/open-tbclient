package com.alipay.sdk.widget;

import android.os.Handler;
import com.alipay.sdk.widget.a;
/* loaded from: classes.dex */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f2008a;

    public c(a aVar) {
        this.f2008a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        a.AlertDialogC0017a alertDialogC0017a;
        a.AlertDialogC0017a alertDialogC0017a2;
        Handler handler;
        a.AlertDialogC0017a alertDialogC0017a3;
        alertDialogC0017a = this.f2008a.f2001e;
        if (alertDialogC0017a != null) {
            alertDialogC0017a2 = this.f2008a.f2001e;
            if (alertDialogC0017a2.isShowing()) {
                try {
                    handler = this.f2008a.l;
                    handler.removeMessages(1);
                    alertDialogC0017a3 = this.f2008a.f2001e;
                    alertDialogC0017a3.dismiss();
                } catch (Exception e2) {
                    com.alipay.sdk.util.c.a(e2);
                }
            }
        }
    }
}
