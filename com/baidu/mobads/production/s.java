package com.baidu.mobads.production;

import android.content.Context;
import com.baidu.mobads.interfaces.utils.IXAdPackageUtils;
import java.util.Timer;
import java.util.TimerTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class s extends TimerTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IXAdPackageUtils f3511a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Context f3512b;
    final /* synthetic */ String c;
    final /* synthetic */ Timer d;
    final /* synthetic */ q e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(q qVar, IXAdPackageUtils iXAdPackageUtils, Context context, String str, Timer timer) {
        this.e = qVar;
        this.f3511a = iXAdPackageUtils;
        this.f3512b = context;
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
                if (!this.f3511a.isForeground(this.f3512b, this.c) && this.f3511a.isForeground(this.f3512b, this.f3512b.getPackageName())) {
                    this.d.cancel();
                    IXAdPackageUtils iXAdPackageUtils = this.f3511a;
                    Context context = this.f3512b;
                    i5 = this.e.j;
                    iXAdPackageUtils.sendDialerIsSuccess(context, false, i5, this.c);
                }
            } else {
                this.d.cancel();
                this.f3511a.sendDialerIsSuccess(this.f3512b, true, 0, this.c);
            }
        }
        q.h(this.e);
    }
}
