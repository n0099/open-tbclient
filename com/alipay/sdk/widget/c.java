package com.alipay.sdk.widget;

import android.os.Handler;
import com.alipay.sdk.widget.a;
/* loaded from: classes.dex */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f2024a;

    public c(a aVar) {
        this.f2024a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        a.AlertDialogC0018a alertDialogC0018a;
        a.AlertDialogC0018a alertDialogC0018a2;
        Handler handler;
        a.AlertDialogC0018a alertDialogC0018a3;
        alertDialogC0018a = this.f2024a.f2018e;
        if (alertDialogC0018a != null) {
            alertDialogC0018a2 = this.f2024a.f2018e;
            if (alertDialogC0018a2.isShowing()) {
                try {
                    handler = this.f2024a.l;
                    handler.removeMessages(1);
                    alertDialogC0018a3 = this.f2024a.f2018e;
                    alertDialogC0018a3.dismiss();
                } catch (Exception e2) {
                    com.alipay.sdk.util.c.a(e2);
                }
            }
        }
    }
}
