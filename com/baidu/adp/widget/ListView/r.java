package com.baidu.adp.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements Runnable {
    final /* synthetic */ q IC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.IC = qVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.IC.Iz == null) {
            return;
        }
        this.IC.Iz.endAnimation();
    }
}
