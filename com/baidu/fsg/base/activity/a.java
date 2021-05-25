package com.baidu.fsg.base.activity;
/* loaded from: classes2.dex */
public class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f5059a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f5060b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f5061c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f5062d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ BeanActivity f5063e;

    public a(BeanActivity beanActivity, int i2, Object obj, String str, String str2) {
        this.f5063e = beanActivity;
        this.f5059a = i2;
        this.f5060b = obj;
        this.f5061c = str;
        this.f5062d = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        BeanActivity beanActivity = this.f5063e;
        if (beanActivity.mAct != null) {
            beanActivity.handleResponse(this.f5059a, this.f5060b, this.f5061c);
            this.f5063e.handleResponse(this.f5059a, this.f5060b, this.f5061c, this.f5062d);
        }
    }
}
