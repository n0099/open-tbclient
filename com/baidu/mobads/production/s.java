package com.baidu.mobads.production;

import android.content.Context;
import com.baidu.mobads.interfaces.utils.IXAdPackageUtils;
import java.util.Timer;
import java.util.TimerTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class s extends TimerTask {
    final /* synthetic */ IXAdPackageUtils a;
    final /* synthetic */ Context b;
    final /* synthetic */ String c;
    final /* synthetic */ Timer d;
    final /* synthetic */ q e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(q qVar, IXAdPackageUtils iXAdPackageUtils, Context context, String str, Timer timer) {
        this.e = qVar;
        this.a = iXAdPackageUtils;
        this.b = context;
        this.c = str;
        this.d = timer;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        i = this.e.j;
        i2 = this.e.k;
        if (i >= i2) {
            i3 = this.e.j;
            i4 = this.e.l;
            if (i3 < i4) {
                if (!this.a.isForeground(this.b, this.c) && this.a.isForeground(this.b, this.b.getPackageName())) {
                    this.d.cancel();
                    IXAdPackageUtils iXAdPackageUtils = this.a;
                    Context context = this.b;
                    i5 = this.e.j;
                    iXAdPackageUtils.sendDialerIsSuccess(context, false, i5, this.c);
                }
            } else {
                this.d.cancel();
                this.a.sendDialerIsSuccess(this.b, true, 0, this.c);
            }
        }
        q.h(this.e);
    }
}
