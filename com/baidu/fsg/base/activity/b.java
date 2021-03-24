package com.baidu.fsg.base.activity;
/* loaded from: classes2.dex */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f5146a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f5147b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f5148c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ BeanActivity f5149d;

    public b(BeanActivity beanActivity, int i, int i2, String str) {
        this.f5149d = beanActivity;
        this.f5146a = i;
        this.f5147b = i2;
        this.f5148c = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        BeanActivity beanActivity = this.f5149d;
        if (beanActivity.mAct != null) {
            beanActivity.handleFailure(this.f5146a, this.f5147b, this.f5148c);
        }
    }
}
