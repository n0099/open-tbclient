package com.baidu.fsg.base.activity;
/* loaded from: classes16.dex */
class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f1452a;
    final /* synthetic */ int b;
    final /* synthetic */ String c;
    final /* synthetic */ BeanActivity d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BeanActivity beanActivity, int i, int i2, String str) {
        this.d = beanActivity;
        this.f1452a = i;
        this.b = i2;
        this.c = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.d.mAct != null) {
            this.d.handleFailure(this.f1452a, this.b, this.c);
        }
    }
}
