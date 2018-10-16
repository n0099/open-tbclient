package com.baidu.fsg.base.activity;
/* loaded from: classes6.dex */
class b implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ int b;
    final /* synthetic */ String c;
    final /* synthetic */ BeanActivity d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BeanActivity beanActivity, int i, int i2, String str) {
        this.d = beanActivity;
        this.a = i;
        this.b = i2;
        this.c = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.d.mAct != null) {
            this.d.handleFailure(this.a, this.b, this.c);
        }
    }
}
