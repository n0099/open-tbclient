package com.baidu.fsg.base.activity;
/* loaded from: classes6.dex */
class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f1924a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ int f1925b;
    final /* synthetic */ String c;
    final /* synthetic */ BeanActivity d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BeanActivity beanActivity, int i, int i2, String str) {
        this.d = beanActivity;
        this.f1924a = i;
        this.f1925b = i2;
        this.c = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.d.mAct != null) {
            this.d.handleFailure(this.f1924a, this.f1925b, this.c);
        }
    }
}
