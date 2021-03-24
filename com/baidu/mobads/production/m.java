package com.baidu.mobads.production;

import android.content.Context;
import com.baidu.mobads.interfaces.utils.IXAdPackageUtils;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes2.dex */
public class m extends TimerTask {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IXAdPackageUtils f8493a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f8494b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f8495c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Timer f8496d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ l f8497e;

    public m(l lVar, IXAdPackageUtils iXAdPackageUtils, Context context, String str, Timer timer) {
        this.f8497e = lVar;
        this.f8493a = iXAdPackageUtils;
        this.f8494b = context;
        this.f8495c = str;
        this.f8496d = timer;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        i = this.f8497e.o;
        i2 = this.f8497e.p;
        if (i >= i2) {
            i3 = this.f8497e.o;
            i4 = this.f8497e.q;
            if (i3 < i4) {
                if (!this.f8493a.isForeground(this.f8494b, this.f8495c)) {
                    IXAdPackageUtils iXAdPackageUtils = this.f8493a;
                    Context context = this.f8494b;
                    if (iXAdPackageUtils.isForeground(context, context.getPackageName())) {
                        this.f8496d.cancel();
                        IXAdPackageUtils iXAdPackageUtils2 = this.f8493a;
                        Context context2 = this.f8494b;
                        i5 = this.f8497e.o;
                        iXAdPackageUtils2.sendDialerIsSuccess(context2, false, i5, this.f8495c);
                    }
                }
            } else {
                this.f8496d.cancel();
                this.f8493a.sendDialerIsSuccess(this.f8494b, true, 0, this.f8495c);
            }
        }
        l.d(this.f8497e);
    }
}
