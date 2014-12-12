package com.baidu.tbadk.browser;

import android.content.DialogInterface;
import com.baidu.tbadk.core.util.bl;
/* loaded from: classes.dex */
class e implements DialogInterface.OnClickListener {
    final /* synthetic */ c Bg;
    private final /* synthetic */ bl Bi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, bl blVar) {
        this.Bg = cVar;
        this.Bi = blVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.Bi != null) {
            this.Bi.onCancel();
        }
    }
}
