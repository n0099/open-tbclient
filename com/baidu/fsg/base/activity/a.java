package com.baidu.fsg.base.activity;
/* loaded from: classes2.dex */
public class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f5305a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f5306b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f5307c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f5308d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ BeanActivity f5309e;

    public a(BeanActivity beanActivity, int i2, Object obj, String str, String str2) {
        this.f5309e = beanActivity;
        this.f5305a = i2;
        this.f5306b = obj;
        this.f5307c = str;
        this.f5308d = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        BeanActivity beanActivity = this.f5309e;
        if (beanActivity.mAct != null) {
            beanActivity.handleResponse(this.f5305a, this.f5306b, this.f5307c);
            this.f5309e.handleResponse(this.f5305a, this.f5306b, this.f5307c, this.f5308d);
        }
    }
}
