package com;

import android.content.DialogInterface;
import com.baidu.cloudsdk.social.share.handler.CloudBatchShareHandler;
/* loaded from: classes.dex */
public class az implements DialogInterface.OnDismissListener {
    final /* synthetic */ CloudBatchShareHandler dxQ;

    public az(CloudBatchShareHandler cloudBatchShareHandler) {
        this.dxQ = cloudBatchShareHandler;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.dxQ.mShareDialog != null) {
            this.dxQ.mShareDialog = null;
        }
    }
}
