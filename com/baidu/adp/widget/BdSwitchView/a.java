package com.baidu.adp.widget.BdSwitchView;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ BdSwitchView zi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BdSwitchView bdSwitchView) {
        this.zi = bdSwitchView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.zi.jx();
    }
}
