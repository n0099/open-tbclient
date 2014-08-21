package com.baidu.tbadk.core.view;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.br;
import com.baidu.tbadk.core.frameworkData.IntentAction;
/* loaded from: classes.dex */
class f implements View.OnClickListener {
    final /* synthetic */ d a;
    private final /* synthetic */ Activity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar, Activity activity) {
        this.a = dVar;
        this.b = activity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        br brVar = new br(this.b);
        brVar.setRequestCode(22002);
        brVar.setIntentAction(IntentAction.ActivityForResult);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, brVar));
    }
}
