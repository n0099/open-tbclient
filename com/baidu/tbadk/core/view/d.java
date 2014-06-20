package com.baidu.tbadk.core.view;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.aw;
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
        aw awVar = new aw(this.b);
        awVar.setRequestCode(22002);
        awVar.setIntentAction(IntentAction.ActivityForResult);
        MessageManager.getInstance().sendMessage(new CustomMessage(2003001, awVar));
    }
}
