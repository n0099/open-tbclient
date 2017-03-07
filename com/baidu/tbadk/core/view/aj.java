package com.baidu.tbadk.core.view;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.bj;
/* loaded from: classes.dex */
class aj extends CustomMessageListener {
    final /* synthetic */ ThreadCommentAndPraiseInfoLayout alQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aj(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout, int i) {
        super(i);
        this.alQ = threadCommentAndPraiseInfoLayout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        bj bjVar;
        bj bjVar2;
        bj bjVar3;
        bj bjVar4;
        bj bjVar5;
        bj bjVar6;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bj)) {
            bjVar = this.alQ.ain;
            if (bjVar != null) {
                bjVar2 = this.alQ.ain;
                if (bjVar2.getId() != null) {
                    bj bjVar7 = (bj) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(bjVar7.getId()) && bjVar7.rG() != null) {
                        String id = bjVar7.getId();
                        bjVar3 = this.alQ.ain;
                        if (id.equals(bjVar3.getId())) {
                            bjVar4 = this.alQ.ain;
                            if (bjVar4.rG() != null) {
                                bjVar6 = this.alQ.ain;
                                bjVar6.rG().setNum(bjVar7.rG().getNum());
                            }
                            ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = this.alQ;
                            bjVar5 = this.alQ.ain;
                            threadCommentAndPraiseInfoLayout.f(bjVar5);
                        }
                    }
                }
            }
        }
    }
}
