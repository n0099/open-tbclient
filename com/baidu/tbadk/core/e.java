package com.baidu.tbadk.core;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends CustomMessageListener {
    final /* synthetic */ BaseFragmentActivity RG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(BaseFragmentActivity baseFragmentActivity, int i) {
        super(i);
        this.RG = baseFragmentActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        c cVar;
        c cVar2;
        com.baidu.tbadk.core.view.k kVar;
        com.baidu.tbadk.core.view.k kVar2;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005017) {
            cVar = this.RG.mLayoutMode;
            if (cVar != null) {
                cVar2 = this.RG.mLayoutMode;
                cVar2.b(null);
                kVar = this.RG.mKeyboardAdjust;
                if (kVar != null) {
                    kVar2 = this.RG.mKeyboardAdjust;
                    kVar2.de(TbadkCoreApplication.m9getInst().getSkinType());
                }
                this.RG.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
            }
        }
    }
}
