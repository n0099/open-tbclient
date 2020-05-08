package com.baidu.browser.sailor.feature.upload;

import android.content.Intent;
import com.baidu.h.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public final class a implements a.InterfaceC0121a {
    final /* synthetic */ BdUploadHandler acn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BdUploadHandler bdUploadHandler) {
        this.acn = bdUploadHandler;
    }

    @Override // com.baidu.h.a.a.InterfaceC0121a
    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Intent createCameraIntentAfterCheckPermission;
        if (i == 4099) {
            boolean z = iArr.length != 0;
            for (int i2 : iArr) {
                if (i2 == -1) {
                    z = false;
                }
            }
            if (z) {
                createCameraIntentAfterCheckPermission = this.acn.createCameraIntentAfterCheckPermission();
                this.acn.mCanHandleResult = true;
                this.acn.startActivityForResult(createCameraIntentAfterCheckPermission, 11);
            }
            com.baidu.browser.core.permission.a.rd().aU(4099);
        }
    }
}
