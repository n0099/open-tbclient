package com.baidu.browser.sailor.feature.upload;

import android.content.Intent;
import com.baidu.h.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public final class a implements a.InterfaceC0127a {
    final /* synthetic */ BdUploadHandler adk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BdUploadHandler bdUploadHandler) {
        this.adk = bdUploadHandler;
    }

    @Override // com.baidu.h.a.a.InterfaceC0127a
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
                createCameraIntentAfterCheckPermission = this.adk.createCameraIntentAfterCheckPermission();
                this.adk.mCanHandleResult = true;
                this.adk.startActivityForResult(createCameraIntentAfterCheckPermission, 11);
            }
            com.baidu.browser.core.permission.a.rB().bb(4099);
        }
    }
}
