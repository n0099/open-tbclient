package com.baidu.tbadk.core.view;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class g implements View.OnClickListener {
    private final /* synthetic */ TbPageContext Sk;
    final /* synthetic */ f adH;
    private final /* synthetic */ int adI;
    private final /* synthetic */ String adJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar, TbPageContext tbPageContext, int i, String str) {
        this.adH = fVar;
        this.Sk = tbPageContext;
        this.adI = i;
        this.adJ = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbadkCoreApplication.m411getInst().login(null, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.Sk.getPageActivity(), this.adI, this.adJ, 11003)));
    }
}
