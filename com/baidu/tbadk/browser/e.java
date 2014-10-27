package com.baidu.tbadk.browser;

import android.content.DialogInterface;
import com.baidu.tbadk.core.util.bj;
/* loaded from: classes.dex */
class e implements DialogInterface.OnClickListener {
    final /* synthetic */ c xw;
    private final /* synthetic */ bj xz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, bj bjVar) {
        this.xw = cVar;
        this.xz = bjVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.xz != null) {
            this.xz.onCancel();
        }
    }
}
