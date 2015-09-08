package com;

import com.baidu.cloudsdk.social.share.uiwithlayout.SwitchButton;
/* loaded from: classes.dex */
public class ai implements Runnable {
    final /* synthetic */ boolean a;
    final /* synthetic */ SwitchButton dfZ;

    public ai(SwitchButton switchButton, boolean z) {
        this.dfZ = switchButton;
        this.a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.dfZ.setChecked(this.a);
    }
}
