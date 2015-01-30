package com.baidu.tbadk.core.view;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.SapiFastRegActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentAction;
/* loaded from: classes.dex */
class n implements View.OnClickListener {
    final /* synthetic */ l MH;
    private final /* synthetic */ TbPageContext MI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(l lVar, TbPageContext tbPageContext) {
        this.MH = lVar;
        this.MI = tbPageContext;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SapiFastRegActivityConfig sapiFastRegActivityConfig = new SapiFastRegActivityConfig(this.MI.getPageActivity());
        sapiFastRegActivityConfig.setRequestCode(22002);
        sapiFastRegActivityConfig.setIntentAction(IntentAction.ActivityForResult);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, sapiFastRegActivityConfig));
    }
}
