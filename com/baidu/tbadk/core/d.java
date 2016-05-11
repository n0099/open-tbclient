package com.baidu.tbadk.core;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends CustomMessageListener {
    final /* synthetic */ BaseFragmentActivity LK;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(BaseFragmentActivity baseFragmentActivity, int i) {
        super(i);
        this.LK = baseFragmentActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        c cVar;
        c cVar2;
        com.baidu.tbadk.core.view.k kVar;
        com.baidu.tbadk.core.view.k kVar2;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005017) {
            cVar = this.LK.mLayoutMode;
            if (cVar != null) {
                cVar2 = this.LK.mLayoutMode;
                cVar2.b(null);
                kVar = this.LK.mKeyboardAdjust;
                if (kVar != null) {
                    kVar2 = this.LK.mKeyboardAdjust;
                    kVar2.cN(TbadkCoreApplication.m11getInst().getSkinType());
                }
                this.LK.onChangeSkinType(TbadkCoreApplication.m11getInst().getSkinType());
            }
        }
    }
}
