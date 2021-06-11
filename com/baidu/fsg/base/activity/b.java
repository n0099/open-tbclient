package com.baidu.fsg.base.activity;
/* loaded from: classes2.dex */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f5109a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f5110b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f5111c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ BeanActivity f5112d;

    public b(BeanActivity beanActivity, int i2, int i3, String str) {
        this.f5112d = beanActivity;
        this.f5109a = i2;
        this.f5110b = i3;
        this.f5111c = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        BeanActivity beanActivity = this.f5112d;
        if (beanActivity.mAct != null) {
            beanActivity.handleFailure(this.f5109a, this.f5110b, this.f5111c);
        }
    }
}
