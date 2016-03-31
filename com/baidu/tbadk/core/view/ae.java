package com.baidu.tbadk.core.view;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class ae extends CustomMessageListener {
    final /* synthetic */ ThreadCommentAndPraiseInfoLayout ahB;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ae(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout, int i) {
        super(i);
        this.ahB = threadCommentAndPraiseInfoLayout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tbadk.core.data.as asVar;
        com.baidu.tbadk.core.data.as asVar2;
        com.baidu.tbadk.core.data.as asVar3;
        com.baidu.tbadk.core.data.as asVar4;
        com.baidu.tbadk.core.data.as asVar5;
        com.baidu.tbadk.core.data.as asVar6;
        com.baidu.tbadk.core.data.as asVar7;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.as)) {
            asVar = this.ahB.aeC;
            if (asVar != null) {
                asVar2 = this.ahB.aeC;
                if (asVar2 != null) {
                    asVar3 = this.ahB.aeC;
                    if (asVar3.getId() != null) {
                        com.baidu.tbadk.core.data.as asVar8 = (com.baidu.tbadk.core.data.as) customResponsedMessage.getData();
                        if (!TextUtils.isEmpty(asVar8.getId()) && asVar8.getPraise() != null) {
                            String id = asVar8.getId();
                            asVar4 = this.ahB.aeC;
                            if (id.equals(asVar4.getId())) {
                                asVar5 = this.ahB.aeC;
                                if (asVar5.getPraise() != null) {
                                    asVar7 = this.ahB.aeC;
                                    asVar7.getPraise().setNum(asVar8.getPraise().getNum());
                                }
                                ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = this.ahB;
                                asVar6 = this.ahB.aeC;
                                threadCommentAndPraiseInfoLayout.a(asVar6);
                            }
                        }
                    }
                }
            }
        }
    }
}
