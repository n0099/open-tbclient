package com.baidu.tbadk.core.view;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class y extends CustomMessageListener {
    final /* synthetic */ w acA;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(w wVar, int i) {
        super(i);
        this.acA = wVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        this.acA.ach.setBackgroundColor(com.baidu.tbadk.core.util.al.tO().cu(TbadkCoreApplication.m11getInst().getSkinType()));
    }
}
