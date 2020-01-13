package com.baidu.mobads.production;

import android.content.Context;
import com.baidu.mobads.interfaces.utils.IXAdPackageUtils;
import java.util.Timer;
import java.util.TimerTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class r extends TimerTask {
    final /* synthetic */ IXAdPackageUtils a;
    final /* synthetic */ Context b;
    final /* synthetic */ String c;
    final /* synthetic */ Timer d;
    final /* synthetic */ String e;
    final /* synthetic */ q f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar, IXAdPackageUtils iXAdPackageUtils, Context context, String str, Timer timer, String str2) {
        this.f = qVar;
        this.a = iXAdPackageUtils;
        this.b = context;
        this.c = str;
        this.d = timer;
        this.e = str2;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        i = this.f.g;
        i2 = this.f.h;
        if (i >= i2) {
            i3 = this.f.g;
            i4 = this.f.i;
            if (i3 < i4) {
                if (!this.a.isForeground(this.b, this.c)) {
                    this.d.cancel();
                    IXAdPackageUtils iXAdPackageUtils = this.a;
                    Context context = this.b;
                    i5 = this.f.g;
                    iXAdPackageUtils.sendAPOIsSuccess(context, false, i5, this.e, this.c);
                }
            } else {
                this.d.cancel();
                this.a.sendAPOIsSuccess(this.b, true, 0, this.e, this.c);
            }
        }
        q.d(this.f);
    }
}
