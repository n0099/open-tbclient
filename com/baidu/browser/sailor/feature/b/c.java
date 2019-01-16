package com.baidu.browser.sailor.feature.b;

import android.content.Intent;
import com.baidu.e.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class c implements a.InterfaceC0073a {
    final /* synthetic */ b Wh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.Wh = bVar;
    }

    @Override // com.baidu.e.a.a.InterfaceC0073a
    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Intent qG;
        if (i == 4099) {
            boolean z = iArr.length != 0;
            for (int i2 : iArr) {
                if (i2 == -1) {
                    z = false;
                }
            }
            if (z) {
                qG = this.Wh.qG();
                this.Wh.Wg = true;
                this.Wh.a(qG, 11);
            }
            com.baidu.browser.core.permission.a.qp().bB(4099);
        }
    }
}
