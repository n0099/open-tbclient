package com.baidu.fsg.base.activity;
/* loaded from: classes.dex */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f5147a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f5148b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f5149c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ BeanActivity f5150d;

    public b(BeanActivity beanActivity, int i, int i2, String str) {
        this.f5150d = beanActivity;
        this.f5147a = i;
        this.f5148b = i2;
        this.f5149c = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        BeanActivity beanActivity = this.f5150d;
        if (beanActivity.mAct != null) {
            beanActivity.handleFailure(this.f5147a, this.f5148b, this.f5149c);
        }
    }
}
