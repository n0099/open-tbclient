package com.baidu.fsg.base.activity;
/* loaded from: classes.dex */
public class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f5140a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f5141b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f5142c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f5143d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ BeanActivity f5144e;

    public a(BeanActivity beanActivity, int i, Object obj, String str, String str2) {
        this.f5144e = beanActivity;
        this.f5140a = i;
        this.f5141b = obj;
        this.f5142c = str;
        this.f5143d = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        BeanActivity beanActivity = this.f5144e;
        if (beanActivity.mAct != null) {
            beanActivity.handleResponse(this.f5140a, this.f5141b, this.f5142c);
            this.f5144e.handleResponse(this.f5140a, this.f5141b, this.f5142c, this.f5143d);
        }
    }
}
