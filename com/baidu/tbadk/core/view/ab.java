package com.baidu.tbadk.core.view;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class ab extends CustomMessageListener {
    final /* synthetic */ z afj;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ab(z zVar, int i) {
        super(i);
        this.afj = zVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        this.afj.aeZ.setBackgroundColor(com.baidu.tbadk.core.util.ae.uq().cl(TbadkCoreApplication.m411getInst().getSkinType()));
    }
}
