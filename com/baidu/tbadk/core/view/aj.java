package com.baidu.tbadk.core.view;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.bi;
/* loaded from: classes.dex */
class aj extends CustomMessageListener {
    final /* synthetic */ ThreadCommentAndPraiseInfoLayout ame;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aj(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout, int i) {
        super(i);
        this.ame = threadCommentAndPraiseInfoLayout;
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
            biVar = this.ame.aiC;
            if (biVar != null) {
                biVar2 = this.ame.aiC;
                if (biVar2.getId() != null) {
                    bi biVar7 = (bi) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(biVar7.getId()) && biVar7.se() != null) {
                        String id = biVar7.getId();
                        biVar3 = this.ame.aiC;
                        if (id.equals(biVar3.getId())) {
                            biVar4 = this.ame.aiC;
                            if (biVar4.se() != null) {
                                biVar6 = this.ame.aiC;
                                biVar6.se().setNum(biVar7.se().getNum());
                            }
                            ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = this.ame;
                            biVar5 = this.ame.aiC;
                            threadCommentAndPraiseInfoLayout.f(biVar5);
                        }
                    }
                }
            }
        }
    }
}
