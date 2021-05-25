package com.baidu.fsg.base.activity;
/* loaded from: classes2.dex */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f5066a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f5067b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f5068c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ BeanActivity f5069d;

    public b(BeanActivity beanActivity, int i2, int i3, String str) {
        this.f5069d = beanActivity;
        this.f5066a = i2;
        this.f5067b = i3;
        this.f5068c = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        BeanActivity beanActivity = this.f5069d;
        if (beanActivity.mAct != null) {
            beanActivity.handleFailure(this.f5066a, this.f5067b, this.f5068c);
        }
    }
}
