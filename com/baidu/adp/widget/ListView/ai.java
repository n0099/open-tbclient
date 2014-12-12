package com.baidu.adp.widget.ListView;
/* loaded from: classes.dex */
class ai implements Runnable {
    final /* synthetic */ ah xz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ah ahVar) {
        this.xz = ahVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.xz.xx != null) {
            aj.a(this.xz.xx);
        }
    }
}
