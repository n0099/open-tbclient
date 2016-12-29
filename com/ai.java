package com;

import com.baidu.cloudsdk.social.share.uiwithlayout.SwitchButton;
/* loaded from: classes.dex */
public class ai implements Runnable {
    final /* synthetic */ boolean a;
    final /* synthetic */ SwitchButton fFt;

    public ai(SwitchButton switchButton, boolean z) {
        this.fFt = switchButton;
        this.a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.fFt.setChecked(this.a);
    }
}
