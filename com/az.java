package com;

import android.content.DialogInterface;
import com.baidu.cloudsdk.social.share.handler.CloudBatchShareHandler;
/* loaded from: classes.dex */
public class az implements DialogInterface.OnDismissListener {
    final /* synthetic */ CloudBatchShareHandler dvX;

    public az(CloudBatchShareHandler cloudBatchShareHandler) {
        this.dvX = cloudBatchShareHandler;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.dvX.mShareDialog != null) {
            this.dvX.mShareDialog = null;
        }
    }
}
