package com.baidu.browser.sailor.feature.upload;

import android.content.Intent;
import com.baidu.m.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes19.dex */
public final class a implements a.InterfaceC0210a {
    final /* synthetic */ BdUploadHandler aeG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BdUploadHandler bdUploadHandler) {
        this.aeG = bdUploadHandler;
    }

    @Override // com.baidu.m.a.a.InterfaceC0210a
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
                createCameraIntentAfterCheckPermission = this.aeG.createCameraIntentAfterCheckPermission();
                this.aeG.mCanHandleResult = true;
                this.aeG.startActivityForResult(createCameraIntentAfterCheckPermission, 11);
            }
            com.baidu.browser.core.permission.a.tq().bi(4099);
        }
    }
}
