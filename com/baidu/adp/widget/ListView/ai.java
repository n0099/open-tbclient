package com.baidu.adp.widget.ListView;
/* loaded from: classes.dex */
class ai implements Runnable {
    final /* synthetic */ ah xw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ah ahVar) {
        this.xw = ahVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.xw.xu != null) {
            aj.a(this.xw.xu);
        }
    }
}
