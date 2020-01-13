package com.baidu.browser.sailor.feature.upload;

import android.app.Activity;
import android.content.Intent;
import com.baidu.k.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public final class b implements a.InterfaceC0072a {
    final /* synthetic */ BdUploadHandler IG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BdUploadHandler bdUploadHandler) {
        this.IG = bdUploadHandler;
    }

    @Override // com.baidu.k.a.a.InterfaceC0072a
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
                this.IG.mCanHandleResult = true;
                activity = this.IG.mActivity;
                createCamcorderIntent = this.IG.createCamcorderIntent();
                activity.startActivityForResult(createCamcorderIntent, 11);
            }
            com.baidu.browser.core.permission.a.mm().aF(4099);
        }
    }
}
