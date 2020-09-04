package com.baidu.browser.sailor.feature.upload;

import android.app.Activity;
import android.content.Intent;
import com.baidu.m.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes19.dex */
public final class b implements a.InterfaceC0210a {
    final /* synthetic */ BdUploadHandler aeI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BdUploadHandler bdUploadHandler) {
        this.aeI = bdUploadHandler;
    }

    @Override // com.baidu.m.a.a.InterfaceC0210a
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
                this.aeI.mCanHandleResult = true;
                activity = this.aeI.mActivity;
                createCamcorderIntent = this.aeI.createCamcorderIntent();
                activity.startActivityForResult(createCamcorderIntent, 11);
            }
            com.baidu.browser.core.permission.a.tq().bi(4099);
        }
    }
}
