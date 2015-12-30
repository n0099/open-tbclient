package com.baidu.tbadk.core.view;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class x extends CustomMessageListener {
    final /* synthetic */ ThreadCommentAndPraiseInfoLayout agH;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout, int i) {
        super(i);
        this.agH = threadCommentAndPraiseInfoLayout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tbadk.core.data.z zVar;
        com.baidu.tbadk.core.data.z zVar2;
        com.baidu.tbadk.core.data.z zVar3;
        com.baidu.tbadk.core.data.z zVar4;
        com.baidu.tbadk.core.data.z zVar5;
        com.baidu.tbadk.core.data.z zVar6;
        com.baidu.tbadk.core.data.z zVar7;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.z)) {
            zVar = this.agH.aeF;
            if (zVar != null) {
                zVar2 = this.agH.aeF;
                if (zVar2 != null) {
                    zVar3 = this.agH.aeF;
                    if (zVar3.getId() != null) {
                        com.baidu.tbadk.core.data.z zVar8 = (com.baidu.tbadk.core.data.z) customResponsedMessage.getData();
                        if (!TextUtils.isEmpty(zVar8.getId()) && zVar8.getPraise() != null) {
                            String id = zVar8.getId();
                            zVar4 = this.agH.aeF;
                            if (id.equals(zVar4.getId())) {
                                zVar5 = this.agH.aeF;
                                if (zVar5.getPraise() != null) {
                                    zVar7 = this.agH.aeF;
                                    zVar7.getPraise().setNum(zVar8.getPraise().getNum());
                                }
                                ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = this.agH;
                                zVar6 = this.agH.aeF;
                                threadCommentAndPraiseInfoLayout.a(zVar6);
                            }
                        }
                    }
                }
            }
        }
    }
}
