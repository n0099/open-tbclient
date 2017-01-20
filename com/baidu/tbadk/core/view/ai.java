package com.baidu.tbadk.core.view;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.bh;
/* loaded from: classes.dex */
class ai extends CustomMessageListener {
    final /* synthetic */ ThreadCommentAndPraiseInfoLayout agx;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ai(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout, int i) {
        super(i);
        this.agx = threadCommentAndPraiseInfoLayout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        bh bhVar;
        bh bhVar2;
        bh bhVar3;
        bh bhVar4;
        bh bhVar5;
        bh bhVar6;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bh)) {
            bhVar = this.agx.acX;
            if (bhVar != null) {
                bhVar2 = this.agx.acX;
                if (bhVar2.getId() != null) {
                    bh bhVar7 = (bh) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(bhVar7.getId()) && bhVar7.rn() != null) {
                        String id = bhVar7.getId();
                        bhVar3 = this.agx.acX;
                        if (id.equals(bhVar3.getId())) {
                            bhVar4 = this.agx.acX;
                            if (bhVar4.rn() != null) {
                                bhVar6 = this.agx.acX;
                                bhVar6.rn().setNum(bhVar7.rn().getNum());
                            }
                            ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = this.agx;
                            bhVar5 = this.agx.acX;
                            threadCommentAndPraiseInfoLayout.f(bhVar5);
                        }
                    }
                }
            }
        }
    }
}
