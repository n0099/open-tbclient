package com.baidu.tbadk.core.view;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class ai extends CustomMessageListener {
    final /* synthetic */ ag Zf;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ai(ag agVar, int i) {
        super(i);
        this.Zf = agVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        this.Zf.YV.setBackgroundColor(com.baidu.tbadk.core.util.at.sL().cb(TbadkCoreApplication.m411getInst().getSkinType()));
    }
}
