package com.baidu.tbadk.core.view;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
/* loaded from: classes.dex */
class m implements View.OnClickListener {
    final /* synthetic */ l ME;
    private final /* synthetic */ TbPageContext MF;
    private final /* synthetic */ int MG;
    private final /* synthetic */ String MH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, TbPageContext tbPageContext, int i, String str) {
        this.ME = lVar;
        this.MF = tbPageContext;
        this.MG = i;
        this.MH = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LoginActivityConfig(this.MF.getPageActivity(), this.MG, this.MH, 11003)));
    }
}
