package com.baidu.tbadk.core.view;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class af extends CustomMessageListener {
    final /* synthetic */ ad afZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public af(ad adVar, int i) {
        super(i);
        this.afZ = adVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        this.afZ.afG.setBackgroundColor(com.baidu.tbadk.core.util.ah.uP().cK(TbadkCoreApplication.m9getInst().getSkinType()));
    }
}
