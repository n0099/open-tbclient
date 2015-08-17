package com.baidu.tbadk.core.view;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class g implements View.OnClickListener {
    private final /* synthetic */ TbPageContext Sn;
    final /* synthetic */ f adx;
    private final /* synthetic */ int ady;
    private final /* synthetic */ String adz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar, TbPageContext tbPageContext, int i, String str) {
        this.adx = fVar;
        this.Sn = tbPageContext;
        this.ady = i;
        this.adz = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbadkCoreApplication.m411getInst().login(null, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.Sn.getPageActivity(), this.ady, this.adz, 11003)));
    }
}
