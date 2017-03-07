package com;

import android.content.DialogInterface;
import com.baidu.cloudsdk.social.share.handler.CloudBatchShareHandler;
/* loaded from: classes.dex */
public class az implements DialogInterface.OnDismissListener {
    final /* synthetic */ CloudBatchShareHandler gdH;

    public az(CloudBatchShareHandler cloudBatchShareHandler) {
        this.gdH = cloudBatchShareHandler;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.gdH.mShareDialog != null) {
            this.gdH.mShareDialog = null;
        }
    }
}
