package com.baidu.browser.sailor.feature.upload;

import android.app.Activity;
import android.content.Intent;
import com.baidu.h.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public final class b implements a.InterfaceC0125a {
    final /* synthetic */ BdUploadHandler acF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BdUploadHandler bdUploadHandler) {
        this.acF = bdUploadHandler;
    }

    @Override // com.baidu.h.a.a.InterfaceC0125a
    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Activity activity;
        Intent createCamcorderIntent;
        if (i == 4099) {
            boolean z = iArr.length != 0;
            for (int i2 : iArr) {
                if (i2 == -1) {
                    z = false;
                }
            }
            if (z) {
                this.acF.mCanHandleResult = true;
                activity = this.acF.mActivity;
                createCamcorderIntent = this.acF.createCamcorderIntent();
                activity.startActivityForResult(createCamcorderIntent, 11);
            }
            com.baidu.browser.core.permission.a.rk().aV(4099);
        }
    }
}
