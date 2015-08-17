package com.baidu.tbadk.core.view;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.RegisterActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentAction;
/* loaded from: classes.dex */
class h implements View.OnClickListener {
    private final /* synthetic */ TbPageContext Sn;
    final /* synthetic */ f adx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f fVar, TbPageContext tbPageContext) {
        this.adx = fVar;
        this.Sn = tbPageContext;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        RegisterActivityConfig registerActivityConfig = new RegisterActivityConfig(this.Sn.getPageActivity());
        registerActivityConfig.setRequestCode(22002);
        registerActivityConfig.setIntentAction(IntentAction.ActivityForResult);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, registerActivityConfig));
    }
}
