package com.baidu.browser.sailor.feature.upload;

import android.app.Activity;
import android.content.Intent;
import com.baidu.m.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class b implements a.InterfaceC0248a {
    final /* synthetic */ BdUploadHandler afx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BdUploadHandler bdUploadHandler) {
        this.afx = bdUploadHandler;
    }

    @Override // com.baidu.m.a.a.InterfaceC0248a
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
                this.afx.mCanHandleResult = true;
                activity = this.afx.mActivity;
                createCamcorderIntent = this.afx.createCamcorderIntent();
                activity.startActivityForResult(createCamcorderIntent, 11);
            }
            com.baidu.browser.core.permission.a.tv().bm(4099);
        }
    }
}
