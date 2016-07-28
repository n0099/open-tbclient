package com;

import android.content.DialogInterface;
import com.baidu.cloudsdk.social.share.handler.CloudBatchShareHandler;
/* loaded from: classes.dex */
public class az implements DialogInterface.OnDismissListener {
    final /* synthetic */ CloudBatchShareHandler gbM;

    public az(CloudBatchShareHandler cloudBatchShareHandler) {
        this.gbM = cloudBatchShareHandler;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.gbM.mShareDialog != null) {
            this.gbM.mShareDialog = null;
        }
    }
}
