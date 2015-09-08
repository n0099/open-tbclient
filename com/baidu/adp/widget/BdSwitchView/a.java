package com.baidu.adp.widget.BdSwitchView;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ BdSwitchView Fb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BdSwitchView bdSwitchView) {
        this.Fb = bdSwitchView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Fb.mC();
    }
}
