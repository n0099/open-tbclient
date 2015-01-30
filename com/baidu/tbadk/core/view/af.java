package com.baidu.tbadk.core.view;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.CaptureActivityConfig;
/* loaded from: classes.dex */
class af implements View.OnClickListener {
    final /* synthetic */ ae NR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ae aeVar) {
        this.NR = aeVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity activity;
        activity = this.NR.mCurrentActivity;
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CaptureActivityConfig(activity, 16003)));
    }
}
