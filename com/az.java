package com;

import android.content.DialogInterface;
import com.baidu.cloudsdk.social.share.handler.CloudBatchShareHandler;
/* loaded from: classes.dex */
public class az implements DialogInterface.OnDismissListener {
    final /* synthetic */ CloudBatchShareHandler edG;

    public az(CloudBatchShareHandler cloudBatchShareHandler) {
        this.edG = cloudBatchShareHandler;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.edG.mShareDialog != null) {
            this.edG.mShareDialog = null;
        }
    }
}
