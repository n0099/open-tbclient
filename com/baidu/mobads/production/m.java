package com.baidu.mobads.production;

import android.content.Context;
import com.baidu.mobads.interfaces.utils.IXAdPackageUtils;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes2.dex */
public class m extends TimerTask {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IXAdPackageUtils f8494a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f8495b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f8496c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Timer f8497d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ l f8498e;

    public m(l lVar, IXAdPackageUtils iXAdPackageUtils, Context context, String str, Timer timer) {
        this.f8498e = lVar;
        this.f8494a = iXAdPackageUtils;
        this.f8495b = context;
        this.f8496c = str;
        this.f8497d = timer;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        i = this.f8498e.o;
        i2 = this.f8498e.p;
        if (i >= i2) {
            i3 = this.f8498e.o;
            i4 = this.f8498e.q;
            if (i3 < i4) {
                if (!this.f8494a.isForeground(this.f8495b, this.f8496c)) {
                    IXAdPackageUtils iXAdPackageUtils = this.f8494a;
                    Context context = this.f8495b;
                    if (iXAdPackageUtils.isForeground(context, context.getPackageName())) {
                        this.f8497d.cancel();
                        IXAdPackageUtils iXAdPackageUtils2 = this.f8494a;
                        Context context2 = this.f8495b;
                        i5 = this.f8498e.o;
                        iXAdPackageUtils2.sendDialerIsSuccess(context2, false, i5, this.f8496c);
                    }
                }
            } else {
                this.f8497d.cancel();
                this.f8494a.sendDialerIsSuccess(this.f8495b, true, 0, this.f8496c);
            }
        }
        l.d(this.f8498e);
    }
}
