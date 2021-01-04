package com.baidu.browser.sailor.feature.upload;

import android.content.Intent;
import com.baidu.n.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class a implements a.InterfaceC0277a {
    final /* synthetic */ BdUploadHandler agT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BdUploadHandler bdUploadHandler) {
        this.agT = bdUploadHandler;
    }

    @Override // com.baidu.n.a.a.InterfaceC0277a
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
                createCameraIntentAfterCheckPermission = this.agT.createCameraIntentAfterCheckPermission();
                this.agT.mCanHandleResult = true;
                this.agT.startActivityForResult(createCameraIntentAfterCheckPermission, 11);
            }
            com.baidu.browser.core.permission.a.sW().bq(4099);
        }
    }
}
