package com.baidu.tbadk.core.view;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.SapiFastRegActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentAction;
/* loaded from: classes.dex */
class f implements View.OnClickListener {
    final /* synthetic */ d Hq;
    private final /* synthetic */ Activity Hr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar, Activity activity) {
        this.Hq = dVar;
        this.Hr = activity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SapiFastRegActivityConfig sapiFastRegActivityConfig = new SapiFastRegActivityConfig(this.Hr);
        sapiFastRegActivityConfig.setRequestCode(22002);
        sapiFastRegActivityConfig.setIntentAction(IntentAction.ActivityForResult);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, sapiFastRegActivityConfig));
    }
}
