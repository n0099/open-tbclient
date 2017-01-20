package com.baidu.tbadk.core.view;

import android.content.Context;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u extends CustomMessageListener {
    final /* synthetic */ o aeH;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(o oVar, int i) {
        super(i);
        this.aeH = oVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        TbPageContext tbPageContext;
        com.baidu.tieba.d.a aVar;
        com.baidu.tieba.d.a aVar2;
        com.baidu.tieba.d.a aVar3;
        Context context;
        com.baidu.tieba.d.a aVar4;
        com.baidu.tieba.d.a aVar5;
        com.baidu.tieba.d.a aVar6;
        com.baidu.tieba.d.a aVar7;
        if (customResponsedMessage != null || customResponsedMessage.getData() == null || (customResponsedMessage.getData() instanceof Boolean)) {
            if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                aVar6 = this.aeH.aeA;
                if (aVar6 != null) {
                    aVar7 = this.aeH.aeA;
                    aVar7.Tg();
                    return;
                }
                return;
            }
            o oVar = this.aeH;
            tbPageContext = this.aeH.FY;
            oVar.aeA = new com.baidu.tieba.d.a(tbPageContext, this.aeH);
            aVar = this.aeH.aeA;
            aVar.ha(12);
            aVar2 = this.aeH.aeA;
            aVar2.gY(5000);
            aVar3 = this.aeH.aeA;
            context = this.aeH.mContext;
            aVar3.e(context.getResources().getString(r.l.recommend_frs_neg_feedback_tip), "show_neg_feedback_guide_tips", true);
            aVar4 = this.aeH.aeA;
            if (!aVar4.Th()) {
                aVar5 = this.aeH.aeA;
                aVar5.Tg();
            }
        }
    }
}
