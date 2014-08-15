package com.baidu.tbadk.core.view;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.aq;
/* loaded from: classes.dex */
class d implements View.OnClickListener {
    final /* synthetic */ c a;
    private final /* synthetic */ Activity b;
    private final /* synthetic */ int c;
    private final /* synthetic */ String d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, Activity activity, int i, String str) {
        this.a = cVar;
        this.b = activity;
        this.c = i;
        this.d = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new aq(this.b, this.c, this.d, 11003)));
    }
}
