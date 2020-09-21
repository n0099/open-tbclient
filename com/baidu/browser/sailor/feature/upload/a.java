package com.baidu.browser.sailor.feature.upload;

import android.content.Intent;
import com.baidu.m.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class a implements a.InterfaceC0209a {
    final /* synthetic */ BdUploadHandler afa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BdUploadHandler bdUploadHandler) {
        this.afa = bdUploadHandler;
    }

    @Override // com.baidu.m.a.a.InterfaceC0209a
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
                createCameraIntentAfterCheckPermission = this.afa.createCameraIntentAfterCheckPermission();
                this.afa.mCanHandleResult = true;
                this.afa.startActivityForResult(createCameraIntentAfterCheckPermission, 11);
            }
            com.baidu.browser.core.permission.a.tv().bm(4099);
        }
    }
}
