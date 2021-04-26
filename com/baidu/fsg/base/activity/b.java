package com.baidu.fsg.base.activity;
/* loaded from: classes2.dex */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f5312a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f5313b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f5314c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ BeanActivity f5315d;

    public b(BeanActivity beanActivity, int i2, int i3, String str) {
        this.f5315d = beanActivity;
        this.f5312a = i2;
        this.f5313b = i3;
        this.f5314c = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        BeanActivity beanActivity = this.f5315d;
        if (beanActivity.mAct != null) {
            beanActivity.handleFailure(this.f5312a, this.f5313b, this.f5314c);
        }
    }
}
