package com.baidu.mobads.production;

import android.content.Context;
import com.baidu.mobads.interfaces.utils.IXAdPackageUtils;
import java.util.Timer;
import java.util.TimerTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class m extends TimerTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IXAdPackageUtils f3466a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Context f3467b;
    final /* synthetic */ String c;
    final /* synthetic */ Timer d;
    final /* synthetic */ l e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, IXAdPackageUtils iXAdPackageUtils, Context context, String str, Timer timer) {
        this.e = lVar;
        this.f3466a = iXAdPackageUtils;
        this.f3467b = context;
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
        i = this.e.o;
        i2 = this.e.p;
        if (i >= i2) {
            i3 = this.e.o;
            i4 = this.e.q;
            if (i3 < i4) {
                if (!this.f3466a.isForeground(this.f3467b, this.c) && this.f3466a.isForeground(this.f3467b, this.f3467b.getPackageName())) {
                    this.d.cancel();
                    IXAdPackageUtils iXAdPackageUtils = this.f3466a;
                    Context context = this.f3467b;
                    i5 = this.e.o;
                    iXAdPackageUtils.sendDialerIsSuccess(context, false, i5, this.c);
                }
            } else {
                this.d.cancel();
                this.f3466a.sendDialerIsSuccess(this.f3467b, true, 0, this.c);
            }
        }
        l.d(this.e);
    }
}
