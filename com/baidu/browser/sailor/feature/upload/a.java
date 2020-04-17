package com.baidu.browser.sailor.feature.upload;

import android.content.Intent;
import com.baidu.h.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public final class a implements a.InterfaceC0100a {
    final /* synthetic */ BdUploadHandler aci;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BdUploadHandler bdUploadHandler) {
        this.aci = bdUploadHandler;
    }

    @Override // com.baidu.h.a.a.InterfaceC0100a
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
                createCameraIntentAfterCheckPermission = this.aci.createCameraIntentAfterCheckPermission();
                this.aci.mCanHandleResult = true;
                this.aci.startActivityForResult(createCameraIntentAfterCheckPermission, 11);
            }
            com.baidu.browser.core.permission.a.rd().aU(4099);
        }
    }
}
