package com;

import android.content.DialogInterface;
import com.baidu.cloudsdk.social.share.handler.CloudBatchShareHandler;
/* loaded from: classes.dex */
public class az implements DialogInterface.OnDismissListener {
    final /* synthetic */ CloudBatchShareHandler fPZ;

    public az(CloudBatchShareHandler cloudBatchShareHandler) {
        this.fPZ = cloudBatchShareHandler;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.fPZ.mShareDialog != null) {
            this.fPZ.mShareDialog = null;
        }
    }
}
