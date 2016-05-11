package com;

import android.content.DialogInterface;
import com.baidu.cloudsdk.social.share.handler.CloudBatchShareHandler;
/* loaded from: classes.dex */
public class az implements DialogInterface.OnDismissListener {
    final /* synthetic */ CloudBatchShareHandler fkb;

    public az(CloudBatchShareHandler cloudBatchShareHandler) {
        this.fkb = cloudBatchShareHandler;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.fkb.mShareDialog != null) {
            this.fkb.mShareDialog = null;
        }
    }
}
