package com.baidu.tbadk.browser;

import android.content.Context;
import android.content.DialogInterface;
/* loaded from: classes.dex */
final class d implements DialogInterface.OnClickListener {
    final /* synthetic */ c a;
    private final /* synthetic */ Context b;
    private final /* synthetic */ String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, Context context, String str) {
        this.a = cVar;
        this.b = context;
        this.c = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        a.a(this.b, this.c);
    }
}
