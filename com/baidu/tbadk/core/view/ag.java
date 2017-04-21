package com.baidu.tbadk.core.view;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class ag extends CustomMessageListener {
    final /* synthetic */ ae alG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ag(ae aeVar, int i) {
        super(i);
        this.alG = aeVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        this.alG.alo.setBackgroundColor(com.baidu.tbadk.core.util.ai.vJ().cJ(TbadkCoreApplication.m9getInst().getSkinType()));
    }
}
