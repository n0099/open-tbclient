package com.baidu.tbadk.core.view;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
/* loaded from: classes.dex */
class m implements View.OnClickListener {
    final /* synthetic */ l MH;
    private final /* synthetic */ TbPageContext MI;
    private final /* synthetic */ int MJ;
    private final /* synthetic */ String MK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, TbPageContext tbPageContext, int i, String str) {
        this.MH = lVar;
        this.MI = tbPageContext;
        this.MJ = i;
        this.MK = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LoginActivityConfig(this.MI.getPageActivity(), this.MJ, this.MK, 11003)));
    }
}
