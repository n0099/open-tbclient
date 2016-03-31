package com;

import android.content.DialogInterface;
import com.baidu.cloudsdk.social.share.handler.CloudBatchShareHandler;
/* loaded from: classes.dex */
public class az implements DialogInterface.OnDismissListener {
    final /* synthetic */ CloudBatchShareHandler eXU;

    public az(CloudBatchShareHandler cloudBatchShareHandler) {
        this.eXU = cloudBatchShareHandler;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.eXU.mShareDialog != null) {
            this.eXU.mShareDialog = null;
        }
    }
}
