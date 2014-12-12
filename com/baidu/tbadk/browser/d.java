package com.baidu.tbadk.browser;

import android.content.Context;
import android.content.DialogInterface;
/* loaded from: classes.dex */
class d implements DialogInterface.OnClickListener {
    final /* synthetic */ c Bg;
    private final /* synthetic */ String Bh;
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ String val$url;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, Context context, String str, String str2) {
        this.Bg = cVar;
        this.val$context = context;
        this.Bh = str;
        this.val$url = str2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        a.f(this.val$context, this.Bh, this.val$url);
    }
}
