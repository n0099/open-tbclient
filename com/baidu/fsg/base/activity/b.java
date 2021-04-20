package com.baidu.fsg.base.activity;
/* loaded from: classes2.dex */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f5182a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f5183b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f5184c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ BeanActivity f5185d;

    public b(BeanActivity beanActivity, int i, int i2, String str) {
        this.f5185d = beanActivity;
        this.f5182a = i;
        this.f5183b = i2;
        this.f5184c = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        BeanActivity beanActivity = this.f5185d;
        if (beanActivity.mAct != null) {
            beanActivity.handleFailure(this.f5182a, this.f5183b, this.f5184c);
        }
    }
}
