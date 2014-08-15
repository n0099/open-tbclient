package com.baidu.tbadk.browser;

import android.content.Context;
import android.content.DialogInterface;
/* loaded from: classes.dex */
class f implements DialogInterface.OnClickListener {
    final /* synthetic */ e a;
    private final /* synthetic */ Context b;
    private final /* synthetic */ String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, Context context, String str) {
        this.a = eVar;
        this.b = context;
        this.c = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        a.a(this.b, this.c);
    }
}
