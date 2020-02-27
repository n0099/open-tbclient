package com.baidu.browser.sailor.feature.upload;

import android.content.Intent;
import com.baidu.k.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public final class a implements a.InterfaceC0078a {
    final /* synthetic */ BdUploadHandler Jg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BdUploadHandler bdUploadHandler) {
        this.Jg = bdUploadHandler;
    }

    @Override // com.baidu.k.a.a.InterfaceC0078a
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
                createCameraIntentAfterCheckPermission = this.Jg.createCameraIntentAfterCheckPermission();
                this.Jg.mCanHandleResult = true;
                this.Jg.startActivityForResult(createCameraIntentAfterCheckPermission, 11);
            }
            com.baidu.browser.core.permission.a.mB().aI(4099);
        }
    }
}
