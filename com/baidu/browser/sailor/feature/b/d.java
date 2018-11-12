package com.baidu.browser.sailor.feature.b;

import android.app.Activity;
import android.content.Intent;
import com.baidu.e.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class d implements a.InterfaceC0073a {
    final /* synthetic */ b VY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.VY = bVar;
    }

    @Override // com.baidu.e.a.a.InterfaceC0073a
    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Activity activity;
        Intent qF;
        if (i == 4099) {
            boolean z = iArr.length != 0;
            for (int i2 : iArr) {
                if (i2 == -1) {
                    z = false;
                }
            }
            if (z) {
                this.VY.VX = true;
                activity = this.VY.mActivity;
                qF = this.VY.qF();
                activity.startActivityForResult(qF, 11);
            }
            com.baidu.browser.core.permission.a.qm().bB(4099);
        }
    }
}
