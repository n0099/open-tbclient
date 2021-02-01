package com.baidu.browser.sailor.feature.upload;

import android.content.Intent;
import com.baidu.l.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class a implements a.InterfaceC0148a {
    final /* synthetic */ BdUploadHandler afT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BdUploadHandler bdUploadHandler) {
        this.afT = bdUploadHandler;
    }

    @Override // com.baidu.l.a.a.InterfaceC0148a
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
                createCameraIntentAfterCheckPermission = this.afT.createCameraIntentAfterCheckPermission();
                this.afT.mCanHandleResult = true;
                this.afT.startActivityForResult(createCameraIntentAfterCheckPermission, 11);
            }
            com.baidu.browser.core.permission.a.sI().bo(4099);
        }
    }
}
