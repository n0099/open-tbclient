package com.baidu.tbadk.core.view;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ax;
import com.baidu.tbadk.core.frameworkData.IntentAction;
/* loaded from: classes.dex */
class d implements View.OnClickListener {
    final /* synthetic */ b a;
    private final /* synthetic */ Activity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar, Activity activity) {
        this.a = bVar;
        this.b = activity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ax axVar = new ax(this.b);
        axVar.setRequestCode(22002);
        axVar.setIntentAction(IntentAction.ActivityForResult);
        MessageManager.getInstance().sendMessage(new CustomMessage(2003001, axVar));
    }
}
