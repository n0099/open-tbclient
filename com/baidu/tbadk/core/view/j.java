package com.baidu.tbadk.core.view;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
/* loaded from: classes.dex */
class j implements View.OnClickListener {
    private final /* synthetic */ TbPageContext NC;
    final /* synthetic */ i YA;
    private final /* synthetic */ int YB;
    private final /* synthetic */ String YC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar, TbPageContext tbPageContext, int i, String str) {
        this.YA = iVar;
        this.NC = tbPageContext;
        this.YB = i;
        this.YC = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbadkCoreApplication.m411getInst().login(null, new CustomMessage<>(2002001, new LoginActivityConfig(this.NC.getPageActivity(), this.YB, this.YC, 11003)));
    }
}
