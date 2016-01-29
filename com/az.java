package com;

import android.content.DialogInterface;
import com.baidu.cloudsdk.social.share.handler.CloudBatchShareHandler;
/* loaded from: classes.dex */
public class az implements DialogInterface.OnDismissListener {
    final /* synthetic */ CloudBatchShareHandler eEb;

    public az(CloudBatchShareHandler cloudBatchShareHandler) {
        this.eEb = cloudBatchShareHandler;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.eEb.mShareDialog != null) {
            this.eEb.mShareDialog = null;
        }
    }
}
