package com;

import com.baidu.cloudsdk.social.share.uiwithlayout.SwitchButton;
/* loaded from: classes.dex */
public class ai implements Runnable {
    final /* synthetic */ boolean a;
    final /* synthetic */ SwitchButton cWW;

    public ai(SwitchButton switchButton, boolean z) {
        this.cWW = switchButton;
        this.a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cWW.setChecked(this.a);
    }
}
