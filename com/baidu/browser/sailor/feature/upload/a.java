package com.baidu.browser.sailor.feature.upload;

import android.content.Intent;
import com.baidu.m.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class a implements a.InterfaceC0248a {
    final /* synthetic */ BdUploadHandler afx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BdUploadHandler bdUploadHandler) {
        this.afx = bdUploadHandler;
    }

    @Override // com.baidu.m.a.a.InterfaceC0248a
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
                createCameraIntentAfterCheckPermission = this.afx.createCameraIntentAfterCheckPermission();
                this.afx.mCanHandleResult = true;
                this.afx.startActivityForResult(createCameraIntentAfterCheckPermission, 11);
            }
            com.baidu.browser.core.permission.a.tv().bm(4099);
        }
    }
}
