package com.baidu.tbadk.core;

import android.content.res.Resources;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends CustomMessageListener {
    final /* synthetic */ BaseFragmentActivity NX;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(BaseFragmentActivity baseFragmentActivity, int i) {
        super(i);
        this.NX = baseFragmentActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        c cVar;
        c cVar2;
        com.baidu.tbadk.core.view.k kVar;
        com.baidu.tbadk.core.view.k kVar2;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005017) {
            cVar = this.NX.mLayoutMode;
            if (cVar != null) {
                cVar2 = this.NX.mLayoutMode;
                cVar2.b((Resources) null);
                kVar = this.NX.mKeyboardAdjust;
                if (kVar != null) {
                    kVar2 = this.NX.mKeyboardAdjust;
                    kVar2.dc(TbadkCoreApplication.m9getInst().getSkinType());
                }
                this.NX.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
            }
        }
    }
}
