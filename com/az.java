package com;

import android.content.DialogInterface;
import com.baidu.cloudsdk.social.share.handler.CloudBatchShareHandler;
/* loaded from: classes.dex */
public class az implements DialogInterface.OnDismissListener {
    final /* synthetic */ CloudBatchShareHandler dvx;

    public az(CloudBatchShareHandler cloudBatchShareHandler) {
        this.dvx = cloudBatchShareHandler;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.dvx.mShareDialog != null) {
            this.dvx.mShareDialog = null;
        }
    }
}
