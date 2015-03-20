package com.baidu.tbadk.core.view;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.RegisterActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentAction;
/* loaded from: classes.dex */
class j implements View.OnClickListener {
    private final /* synthetic */ TbPageContext Nn;
    final /* synthetic */ h XL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar, TbPageContext tbPageContext) {
        this.XL = hVar;
        this.Nn = tbPageContext;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        RegisterActivityConfig registerActivityConfig = new RegisterActivityConfig(this.Nn.getPageActivity());
        registerActivityConfig.setRequestCode(22002);
        registerActivityConfig.setIntentAction(IntentAction.ActivityForResult);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, registerActivityConfig));
    }
}
