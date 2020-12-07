package com.baidu.browser.sailor.feature.upload;

import android.content.Intent;
import com.baidu.n.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes12.dex */
public final class a implements a.InterfaceC0276a {
    final /* synthetic */ BdUploadHandler agt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BdUploadHandler bdUploadHandler) {
        this.agt = bdUploadHandler;
    }

    @Override // com.baidu.n.a.a.InterfaceC0276a
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
                createCameraIntentAfterCheckPermission = this.agt.createCameraIntentAfterCheckPermission();
                this.agt.mCanHandleResult = true;
                this.agt.startActivityForResult(createCameraIntentAfterCheckPermission, 11);
            }
            com.baidu.browser.core.permission.a.ty().bq(4099);
        }
    }
}
