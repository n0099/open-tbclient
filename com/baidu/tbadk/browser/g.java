package com.baidu.tbadk.browser;

import android.content.DialogInterface;
import com.baidu.tbadk.core.util.bk;
/* loaded from: classes.dex */
class g implements DialogInterface.OnClickListener {
    final /* synthetic */ e a;
    private final /* synthetic */ bk b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar, bk bkVar) {
        this.a = eVar;
        this.b = bkVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.b != null) {
            this.b.a();
        }
    }
}
