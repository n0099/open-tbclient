package com.baidu.fsg.base.activity;
/* loaded from: classes2.dex */
public class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f5102a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f5103b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f5104c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f5105d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ BeanActivity f5106e;

    public a(BeanActivity beanActivity, int i2, Object obj, String str, String str2) {
        this.f5106e = beanActivity;
        this.f5102a = i2;
        this.f5103b = obj;
        this.f5104c = str;
        this.f5105d = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        BeanActivity beanActivity = this.f5106e;
        if (beanActivity.mAct != null) {
            beanActivity.handleResponse(this.f5102a, this.f5103b, this.f5104c);
            this.f5106e.handleResponse(this.f5102a, this.f5103b, this.f5104c, this.f5105d);
        }
    }
}
