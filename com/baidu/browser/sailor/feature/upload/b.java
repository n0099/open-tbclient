package com.baidu.browser.sailor.feature.upload;

import android.app.Activity;
import android.content.Intent;
import com.baidu.i.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class b implements a.InterfaceC0153a {
    final /* synthetic */ BdUploadHandler ade;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BdUploadHandler bdUploadHandler) {
        this.ade = bdUploadHandler;
    }

    @Override // com.baidu.i.a.a.InterfaceC0153a
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
                this.ade.mCanHandleResult = true;
                activity = this.ade.mActivity;
                createCamcorderIntent = this.ade.createCamcorderIntent();
                activity.startActivityForResult(createCamcorderIntent, 11);
            }
            com.baidu.browser.core.permission.a.rD().bd(4099);
        }
    }
}
