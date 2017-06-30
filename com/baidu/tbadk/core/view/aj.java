package com.baidu.tbadk.core.view;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class aj extends CustomMessageListener {
    final /* synthetic */ ah amg;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aj(ah ahVar, int i) {
        super(i);
        this.amg = ahVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        this.amg.alN.setBackgroundColor(com.baidu.tbadk.core.util.ak.vj().cJ(TbadkCoreApplication.m9getInst().getSkinType()));
    }
}
