package com.baidu.fsg.base.activity;
/* loaded from: classes6.dex */
class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f1925a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ int f1926b;
    final /* synthetic */ String c;
    final /* synthetic */ BeanActivity d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BeanActivity beanActivity, int i, int i2, String str) {
        this.d = beanActivity;
        this.f1925a = i;
        this.f1926b = i2;
        this.c = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.d.mAct != null) {
            this.d.handleFailure(this.f1925a, this.f1926b, this.c);
        }
    }
}
