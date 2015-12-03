package com.baidu.tbadk.core.view;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ak;
/* loaded from: classes.dex */
class u extends CustomMessageListener {
    final /* synthetic */ s afJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(s sVar, int i) {
        super(i);
        this.afJ = sVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        this.afJ.afz.setBackgroundColor(ak.uZ().cz(TbadkCoreApplication.m411getInst().getSkinType()));
    }
}
