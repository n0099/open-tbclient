package com.alipay.sdk.widget;

import android.os.Handler;
import com.alipay.sdk.widget.a;
/* loaded from: classes.dex */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f2023a;

    public b(a aVar) {
        this.f2023a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        a.AlertDialogC0018a alertDialogC0018a;
        a.AlertDialogC0018a alertDialogC0018a2;
        a.AlertDialogC0018a alertDialogC0018a3;
        Handler handler;
        a.AlertDialogC0018a alertDialogC0018a4;
        boolean z;
        alertDialogC0018a = this.f2023a.f2018e;
        if (alertDialogC0018a == null) {
            a aVar = this.f2023a;
            a aVar2 = this.f2023a;
            aVar.f2018e = new a.AlertDialogC0018a(aVar2.f2019f);
            alertDialogC0018a4 = this.f2023a.f2018e;
            z = this.f2023a.k;
            alertDialogC0018a4.setCancelable(z);
        }
        try {
            alertDialogC0018a2 = this.f2023a.f2018e;
            if (alertDialogC0018a2.isShowing()) {
                return;
            }
            alertDialogC0018a3 = this.f2023a.f2018e;
            alertDialogC0018a3.show();
            handler = this.f2023a.l;
            handler.sendEmptyMessageDelayed(1, 15000L);
        } catch (Exception e2) {
            com.alipay.sdk.util.c.a(e2);
        }
    }
}
