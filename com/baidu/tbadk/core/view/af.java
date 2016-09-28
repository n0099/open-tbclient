package com.baidu.tbadk.core.view;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.bi;
/* loaded from: classes.dex */
class af extends CustomMessageListener {
    final /* synthetic */ ThreadCommentAndPraiseInfoLayout ahj;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public af(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout, int i) {
        super(i);
        this.ahj = threadCommentAndPraiseInfoLayout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        bi biVar;
        bi biVar2;
        bi biVar3;
        bi biVar4;
        bi biVar5;
        bi biVar6;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bi)) {
            biVar = this.ahj.adW;
            if (biVar != null) {
                biVar2 = this.ahj.adW;
                if (biVar2.getId() != null) {
                    bi biVar7 = (bi) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(biVar7.getId()) && biVar7.rF() != null) {
                        String id = biVar7.getId();
                        biVar3 = this.ahj.adW;
                        if (id.equals(biVar3.getId())) {
                            biVar4 = this.ahj.adW;
                            if (biVar4.rF() != null) {
                                biVar6 = this.ahj.adW;
                                biVar6.rF().setNum(biVar7.rF().getNum());
                            }
                            ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = this.ahj;
                            biVar5 = this.ahj.adW;
                            threadCommentAndPraiseInfoLayout.a(biVar5);
                        }
                    }
                }
            }
        }
    }
}
