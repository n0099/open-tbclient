package com.baidu.fsg.base.activity;
/* loaded from: classes2.dex */
public class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f5175a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f5176b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f5177c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f5178d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ BeanActivity f5179e;

    public a(BeanActivity beanActivity, int i, Object obj, String str, String str2) {
        this.f5179e = beanActivity;
        this.f5175a = i;
        this.f5176b = obj;
        this.f5177c = str;
        this.f5178d = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        BeanActivity beanActivity = this.f5179e;
        if (beanActivity.mAct != null) {
            beanActivity.handleResponse(this.f5175a, this.f5176b, this.f5177c);
            this.f5179e.handleResponse(this.f5175a, this.f5176b, this.f5177c, this.f5178d);
        }
    }
}
