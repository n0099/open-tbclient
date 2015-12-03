package com;

import android.content.DialogInterface;
import com.baidu.cloudsdk.social.share.handler.CloudBatchShareHandler;
/* loaded from: classes.dex */
public class az implements DialogInterface.OnDismissListener {
    final /* synthetic */ CloudBatchShareHandler dWi;

    public az(CloudBatchShareHandler cloudBatchShareHandler) {
        this.dWi = cloudBatchShareHandler;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.dWi.mShareDialog != null) {
            this.dWi.mShareDialog = null;
        }
    }
}
