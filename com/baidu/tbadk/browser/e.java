package com.baidu.tbadk.browser;

import android.content.DialogInterface;
import com.baidu.tbadk.core.util.bq;
/* loaded from: classes.dex */
class e implements DialogInterface.OnClickListener {
    final /* synthetic */ c Bg;
    private final /* synthetic */ bq Bi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, bq bqVar) {
        this.Bg = cVar;
        this.Bi = bqVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.Bi != null) {
            this.Bi.onCancel();
        }
    }
}
