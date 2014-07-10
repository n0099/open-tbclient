package com.baidu.tbadk.core.view;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.bi;
import com.baidu.tbadk.core.frameworkData.IntentAction;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ b a;
    private final /* synthetic */ Activity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar, Activity activity) {
        this.a = bVar;
        this.b = activity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bi biVar = new bi(this.b);
        biVar.setRequestCode(22002);
        biVar.setIntentAction(IntentAction.ActivityForResult);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, biVar));
    }
}
