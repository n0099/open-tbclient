package com.baidu.browser.sailor.feature.upload;

import android.content.Intent;
import com.baidu.l.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes14.dex */
public final class a implements a.InterfaceC0154a {
    final /* synthetic */ BdUploadHandler ahm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BdUploadHandler bdUploadHandler) {
        this.ahm = bdUploadHandler;
    }

    @Override // com.baidu.l.a.a.InterfaceC0154a
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
                createCameraIntentAfterCheckPermission = this.ahm.createCameraIntentAfterCheckPermission();
                this.ahm.mCanHandleResult = true;
                this.ahm.startActivityForResult(createCameraIntentAfterCheckPermission, 11);
            }
            com.baidu.browser.core.permission.a.sI().bp(4099);
        }
    }
}
