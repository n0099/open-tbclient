package com.baidu.tbadk.core.view;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.RegisterActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentAction;
/* loaded from: classes.dex */
class j implements View.OnClickListener {
    private final /* synthetic */ TbPageContext Np;
    final /* synthetic */ h XN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar, TbPageContext tbPageContext) {
        this.XN = hVar;
        this.Np = tbPageContext;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        RegisterActivityConfig registerActivityConfig = new RegisterActivityConfig(this.Np.getPageActivity());
        registerActivityConfig.setRequestCode(22002);
        registerActivityConfig.setIntentAction(IntentAction.ActivityForResult);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, registerActivityConfig));
    }
}
