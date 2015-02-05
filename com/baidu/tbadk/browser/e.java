package com.baidu.tbadk.browser;

import android.content.DialogInterface;
import com.baidu.tbadk.core.util.bq;
/* loaded from: classes.dex */
class e implements DialogInterface.OnClickListener {
    final /* synthetic */ c Bd;
    private final /* synthetic */ bq Bf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, bq bqVar) {
        this.Bd = cVar;
        this.Bf = bqVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.Bf != null) {
            this.Bf.onCancel();
        }
    }
}
