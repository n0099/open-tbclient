package com.baidu.tbadk.core;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbadkApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends CustomMessageListener {
    final /* synthetic */ BaseFragmentActivity yG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(BaseFragmentActivity baseFragmentActivity, int i) {
        super(i);
        this.yG = baseFragmentActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        d dVar;
        d dVar2;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005017) {
            dVar = this.yG.mLayoutMode;
            if (dVar != null) {
                dVar2 = this.yG.mLayoutMode;
                dVar2.a(null);
                this.yG.onChangeSkinType(TbadkApplication.m251getInst().getSkinType());
            }
        }
    }
}
