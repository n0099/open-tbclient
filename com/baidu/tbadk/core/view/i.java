package com.baidu.tbadk.core.view;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
/* loaded from: classes.dex */
class i implements View.OnClickListener {
    private final /* synthetic */ TbPageContext Np;
    final /* synthetic */ h XN;
    private final /* synthetic */ int XO;
    private final /* synthetic */ String XP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, TbPageContext tbPageContext, int i, String str) {
        this.XN = hVar;
        this.Np = tbPageContext;
        this.XO = i;
        this.XP = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LoginActivityConfig(this.Np.getPageActivity(), this.XO, this.XP, 11003)));
    }
}
