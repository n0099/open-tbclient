package com.alipay.sdk.widget;

import android.os.Handler;
import com.alipay.sdk.widget.a;
/* loaded from: classes.dex */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f2020a;

    public b(a aVar) {
        this.f2020a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        a.AlertDialogC0018a alertDialogC0018a;
        a.AlertDialogC0018a alertDialogC0018a2;
        a.AlertDialogC0018a alertDialogC0018a3;
        Handler handler;
        a.AlertDialogC0018a alertDialogC0018a4;
        boolean z;
        alertDialogC0018a = this.f2020a.f2014e;
        if (alertDialogC0018a == null) {
            a aVar = this.f2020a;
            a aVar2 = this.f2020a;
            aVar.f2014e = new a.AlertDialogC0018a(aVar2.f2015f);
            alertDialogC0018a4 = this.f2020a.f2014e;
            z = this.f2020a.k;
            alertDialogC0018a4.setCancelable(z);
        }
        try {
            alertDialogC0018a2 = this.f2020a.f2014e;
            if (alertDialogC0018a2.isShowing()) {
                return;
            }
            alertDialogC0018a3 = this.f2020a.f2014e;
            alertDialogC0018a3.show();
            handler = this.f2020a.l;
            handler.sendEmptyMessageDelayed(1, 15000L);
        } catch (Exception e2) {
            com.alipay.sdk.util.c.a(e2);
        }
    }
}
