package com.baidu.tbadk.core.view;
/* loaded from: classes.dex */
class ab implements Runnable {
    final /* synthetic */ z agJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(z zVar) {
        this.agJ = zVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.agJ.agz != null) {
            this.agJ.agz.start();
        }
    }
}
