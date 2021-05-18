package com.baidu.fsg.base.activity;
/* loaded from: classes2.dex */
public class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f5159a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f5160b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f5161c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f5162d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ BeanActivity f5163e;

    public a(BeanActivity beanActivity, int i2, Object obj, String str, String str2) {
        this.f5163e = beanActivity;
        this.f5159a = i2;
        this.f5160b = obj;
        this.f5161c = str;
        this.f5162d = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        BeanActivity beanActivity = this.f5163e;
        if (beanActivity.mAct != null) {
            beanActivity.handleResponse(this.f5159a, this.f5160b, this.f5161c);
            this.f5163e.handleResponse(this.f5159a, this.f5160b, this.f5161c, this.f5162d);
        }
    }
}
