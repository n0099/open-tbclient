package com;

import android.content.DialogInterface;
import com.baidu.cloudsdk.social.share.handler.CloudBatchShareHandler;
/* loaded from: classes.dex */
public class az implements DialogInterface.OnDismissListener {
    final /* synthetic */ CloudBatchShareHandler gvP;

    public az(CloudBatchShareHandler cloudBatchShareHandler) {
        this.gvP = cloudBatchShareHandler;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.gvP.mShareDialog != null) {
            this.gvP.mShareDialog = null;
        }
    }
}
