package com;

import android.content.DialogInterface;
import com.baidu.cloudsdk.social.share.handler.CloudBatchShareHandler;
/* loaded from: classes.dex */
public class az implements DialogInterface.OnDismissListener {
    final /* synthetic */ CloudBatchShareHandler fIK;

    public az(CloudBatchShareHandler cloudBatchShareHandler) {
        this.fIK = cloudBatchShareHandler;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.fIK.mShareDialog != null) {
            this.fIK.mShareDialog = null;
        }
    }
}
