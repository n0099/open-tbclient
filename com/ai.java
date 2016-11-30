package com;

import com.baidu.cloudsdk.social.share.uiwithlayout.SwitchButton;
/* loaded from: classes.dex */
public class ai implements Runnable {
    final /* synthetic */ boolean a;
    final /* synthetic */ SwitchButton grY;

    public ai(SwitchButton switchButton, boolean z) {
        this.grY = switchButton;
        this.a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.grY.setChecked(this.a);
    }
}
