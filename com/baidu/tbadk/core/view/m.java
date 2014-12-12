package com.baidu.tbadk.core.view;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
/* loaded from: classes.dex */
class m implements View.OnClickListener {
    final /* synthetic */ l Ml;
    private final /* synthetic */ TbPageContext Mm;
    private final /* synthetic */ int Mn;
    private final /* synthetic */ String Mo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, TbPageContext tbPageContext, int i, String str) {
        this.Ml = lVar;
        this.Mm = tbPageContext;
        this.Mn = i;
        this.Mo = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LoginActivityConfig(this.Mm.getPageActivity(), this.Mn, this.Mo, 11003)));
    }
}
