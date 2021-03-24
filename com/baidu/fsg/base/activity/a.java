package com.baidu.fsg.base.activity;
/* loaded from: classes2.dex */
public class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f5139a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f5140b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f5141c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f5142d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ BeanActivity f5143e;

    public a(BeanActivity beanActivity, int i, Object obj, String str, String str2) {
        this.f5143e = beanActivity;
        this.f5139a = i;
        this.f5140b = obj;
        this.f5141c = str;
        this.f5142d = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        BeanActivity beanActivity = this.f5143e;
        if (beanActivity.mAct != null) {
            beanActivity.handleResponse(this.f5139a, this.f5140b, this.f5141c);
            this.f5143e.handleResponse(this.f5139a, this.f5140b, this.f5141c, this.f5142d);
        }
    }
}
