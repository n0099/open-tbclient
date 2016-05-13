package com;

import android.content.DialogInterface;
import com.baidu.cloudsdk.social.share.handler.CloudBatchShareHandler;
/* loaded from: classes.dex */
public class az implements DialogInterface.OnDismissListener {
    final /* synthetic */ CloudBatchShareHandler fka;

    public az(CloudBatchShareHandler cloudBatchShareHandler) {
        this.fka = cloudBatchShareHandler;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.fka.mShareDialog != null) {
            this.fka.mShareDialog = null;
        }
    }
}
