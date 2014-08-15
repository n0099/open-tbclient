package com.baidu.tbadk.core.view;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.bq;
import com.baidu.tbadk.core.frameworkData.IntentAction;
/* loaded from: classes.dex */
class e implements View.OnClickListener {
    final /* synthetic */ c a;
    private final /* synthetic */ Activity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, Activity activity) {
        this.a = cVar;
        this.b = activity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bq bqVar = new bq(this.b);
        bqVar.setRequestCode(22002);
        bqVar.setIntentAction(IntentAction.ActivityForResult);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, bqVar));
    }
}
