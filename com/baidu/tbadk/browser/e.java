package com.baidu.tbadk.browser;

import android.content.DialogInterface;
import com.baidu.tbadk.core.util.bk;
/* loaded from: classes.dex */
final class e implements DialogInterface.OnClickListener {
    final /* synthetic */ c a;
    private final /* synthetic */ bk b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, bk bkVar) {
        this.a = cVar;
        this.b = bkVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.b != null) {
            this.b.a();
        }
    }
}
