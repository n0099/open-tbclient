package com.baidu.fsg.base.activity;
/* loaded from: classes2.dex */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f5166a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f5167b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f5168c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ BeanActivity f5169d;

    public b(BeanActivity beanActivity, int i2, int i3, String str) {
        this.f5169d = beanActivity;
        this.f5166a = i2;
        this.f5167b = i3;
        this.f5168c = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        BeanActivity beanActivity = this.f5169d;
        if (beanActivity.mAct != null) {
            beanActivity.handleFailure(this.f5166a, this.f5167b, this.f5168c);
        }
    }
}
