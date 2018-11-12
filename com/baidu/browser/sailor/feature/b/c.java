package com.baidu.browser.sailor.feature.b;

import android.content.Intent;
import com.baidu.e.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class c implements a.InterfaceC0073a {
    final /* synthetic */ b VY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.VY = bVar;
    }

    @Override // com.baidu.e.a.a.InterfaceC0073a
    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Intent qD;
        if (i == 4099) {
            boolean z = iArr.length != 0;
            for (int i2 : iArr) {
                if (i2 == -1) {
                    z = false;
                }
            }
            if (z) {
                qD = this.VY.qD();
                this.VY.VX = true;
                this.VY.a(qD, 11);
            }
            com.baidu.browser.core.permission.a.qm().bB(4099);
        }
    }
}
