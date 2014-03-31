package com.baidu.tbadk.core.view;

import android.app.Activity;
import android.view.View;
import com.baidu.tbadk.core.b.y;
/* loaded from: classes.dex */
final class c implements View.OnClickListener {
    final /* synthetic */ b a;
    private final /* synthetic */ Activity b;
    private final /* synthetic */ int c;
    private final /* synthetic */ String d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, Activity activity, int i, String str) {
        this.a = bVar;
        this.b = activity;
        this.c = i;
        this.d = str;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001001, new y(this.b, this.c, this.d, 11003)));
    }
}
