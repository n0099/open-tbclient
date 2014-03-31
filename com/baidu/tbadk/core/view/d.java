package com.baidu.tbadk.core.view;

import android.app.Activity;
import android.view.View;
import com.baidu.tbadk.core.b.al;
import com.baidu.tbadk.core.frameworkData.IntentAction;
/* loaded from: classes.dex */
final class d implements View.OnClickListener {
    final /* synthetic */ b a;
    private final /* synthetic */ Activity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar, Activity activity) {
        this.a = bVar;
        this.b = activity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        al alVar = new al(this.b);
        alVar.a(22002);
        alVar.a(IntentAction.ActivityForResult);
        com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001001, alVar));
    }
}
