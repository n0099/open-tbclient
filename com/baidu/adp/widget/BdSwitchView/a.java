package com.baidu.adp.widget.BdSwitchView;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ BdSwitchView Fj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BdSwitchView bdSwitchView) {
        this.Fj = bdSwitchView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Fj.mc();
    }
}
