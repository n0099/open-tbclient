package com.baidu.tbadk.core.view;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
/* loaded from: classes.dex */
class i implements View.OnClickListener {
    private final /* synthetic */ TbPageContext Nn;
    final /* synthetic */ h XL;
    private final /* synthetic */ int XM;
    private final /* synthetic */ String XN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, TbPageContext tbPageContext, int i, String str) {
        this.XL = hVar;
        this.Nn = tbPageContext;
        this.XM = i;
        this.XN = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LoginActivityConfig(this.Nn.getPageActivity(), this.XM, this.XN, 11003)));
    }
}
