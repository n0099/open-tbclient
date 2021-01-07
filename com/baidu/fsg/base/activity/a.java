package com.baidu.fsg.base.activity;
/* loaded from: classes6.dex */
class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f1921a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Object f1922b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;
    final /* synthetic */ BeanActivity e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BeanActivity beanActivity, int i, Object obj, String str, String str2) {
        this.e = beanActivity;
        this.f1921a = i;
        this.f1922b = obj;
        this.c = str;
        this.d = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.e.mAct != null) {
            this.e.handleResponse(this.f1921a, this.f1922b, this.c);
            this.e.handleResponse(this.f1921a, this.f1922b, this.c, this.d);
        }
    }
}
