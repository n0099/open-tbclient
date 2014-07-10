package com.baidu.tbadk.browser;

import android.content.DialogInterface;
import com.baidu.tbadk.core.util.bu;
/* loaded from: classes.dex */
class e implements DialogInterface.OnClickListener {
    final /* synthetic */ c a;
    private final /* synthetic */ bu b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, bu buVar) {
        this.a = cVar;
        this.b = buVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.b != null) {
            this.b.a();
        }
    }
}
