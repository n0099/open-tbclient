package com.baidu.tbadk.core.view;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class x extends CustomMessageListener {
    final /* synthetic */ ThreadCommentAndPraiseInfoLayout ahw;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout, int i) {
        super(i);
        this.ahw = threadCommentAndPraiseInfoLayout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tbadk.core.data.ah ahVar;
        com.baidu.tbadk.core.data.ah ahVar2;
        com.baidu.tbadk.core.data.ah ahVar3;
        com.baidu.tbadk.core.data.ah ahVar4;
        com.baidu.tbadk.core.data.ah ahVar5;
        com.baidu.tbadk.core.data.ah ahVar6;
        com.baidu.tbadk.core.data.ah ahVar7;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.ah)) {
            ahVar = this.ahw.afg;
            if (ahVar != null) {
                ahVar2 = this.ahw.afg;
                if (ahVar2 != null) {
                    ahVar3 = this.ahw.afg;
                    if (ahVar3.getId() != null) {
                        com.baidu.tbadk.core.data.ah ahVar8 = (com.baidu.tbadk.core.data.ah) customResponsedMessage.getData();
                        if (!TextUtils.isEmpty(ahVar8.getId()) && ahVar8.getPraise() != null) {
                            String id = ahVar8.getId();
                            ahVar4 = this.ahw.afg;
                            if (id.equals(ahVar4.getId())) {
                                ahVar5 = this.ahw.afg;
                                if (ahVar5.getPraise() != null) {
                                    ahVar7 = this.ahw.afg;
                                    ahVar7.getPraise().setNum(ahVar8.getPraise().getNum());
                                }
                                ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = this.ahw;
                                ahVar6 = this.ahw.afg;
                                threadCommentAndPraiseInfoLayout.a(ahVar6);
                            }
                        }
                    }
                }
            }
        }
    }
}
