package com;

import android.content.DialogInterface;
import com.baidu.cloudsdk.social.share.handler.CloudBatchShareHandler;
/* loaded from: classes.dex */
public class az implements DialogInterface.OnDismissListener {
    final /* synthetic */ CloudBatchShareHandler dvY;

    public az(CloudBatchShareHandler cloudBatchShareHandler) {
        this.dvY = cloudBatchShareHandler;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.dvY.mShareDialog != null) {
            this.dvY.mShareDialog = null;
        }
    }
}
