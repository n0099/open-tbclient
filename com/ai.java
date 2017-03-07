package com;

import com.baidu.cloudsdk.social.share.uiwithlayout.SwitchButton;
/* loaded from: classes.dex */
public class ai implements Runnable {
    final /* synthetic */ boolean a;
    final /* synthetic */ SwitchButton fSh;

    public ai(SwitchButton switchButton, boolean z) {
        this.fSh = switchButton;
        this.a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.fSh.setChecked(this.a);
    }
}
