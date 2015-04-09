package com.baidu.tbadk.browser;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PluginDetailActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ TbPageContext Np;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(TbPageContext tbPageContext) {
        this.Np = tbPageContext;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PluginDetailActivityConfig(this.Np.getPageActivity(), PluginCenter.NAME_XIU8)));
        aVar.dismiss();
    }
}
