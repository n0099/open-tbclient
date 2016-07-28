package com.baidu.tbadk.core.view;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.be;
/* loaded from: classes.dex */
class ag extends CustomMessageListener {
    final /* synthetic */ ThreadCommentAndPraiseInfoLayout aeG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ag(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout, int i) {
        super(i);
        this.aeG = threadCommentAndPraiseInfoLayout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        be beVar;
        be beVar2;
        be beVar3;
        be beVar4;
        be beVar5;
        be beVar6;
        be beVar7;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof be)) {
            beVar = this.aeG.abb;
            if (beVar != null) {
                beVar2 = this.aeG.abb;
                if (beVar2 != null) {
                    beVar3 = this.aeG.abb;
                    if (beVar3.getId() != null) {
                        be beVar8 = (be) customResponsedMessage.getData();
                        if (!TextUtils.isEmpty(beVar8.getId()) && beVar8.qp() != null) {
                            String id = beVar8.getId();
                            beVar4 = this.aeG.abb;
                            if (id.equals(beVar4.getId())) {
                                beVar5 = this.aeG.abb;
                                if (beVar5.qp() != null) {
                                    beVar7 = this.aeG.abb;
                                    beVar7.qp().setNum(beVar8.qp().getNum());
                                }
                                ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = this.aeG;
                                beVar6 = this.aeG.abb;
                                threadCommentAndPraiseInfoLayout.a(beVar6);
                            }
                        }
                    }
                }
            }
        }
    }
}
