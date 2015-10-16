package com;

import com.baidu.cloudsdk.social.share.uiwithlayout.SwitchButton;
/* loaded from: classes.dex */
public class ai implements Runnable {
    final /* synthetic */ boolean a;
    final /* synthetic */ SwitchButton dsv;

    public ai(SwitchButton switchButton, boolean z) {
        this.dsv = switchButton;
        this.a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.dsv.setChecked(this.a);
    }
}
