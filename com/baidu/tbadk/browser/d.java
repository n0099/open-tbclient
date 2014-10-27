package com.baidu.tbadk.browser;

import android.content.Context;
import android.content.DialogInterface;
/* loaded from: classes.dex */
class d implements DialogInterface.OnClickListener {
    private final /* synthetic */ Context val$context;
    final /* synthetic */ c xw;
    private final /* synthetic */ String xx;
    private final /* synthetic */ String xy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, Context context, String str, String str2) {
        this.xw = cVar;
        this.val$context = context;
        this.xx = str;
        this.xy = str2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        a.a(this.val$context, this.xx, this.xy);
    }
}
