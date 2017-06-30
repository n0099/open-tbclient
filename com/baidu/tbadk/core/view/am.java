package com.baidu.tbadk.core.view;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.bm;
/* loaded from: classes.dex */
class am extends CustomMessageListener {
    final /* synthetic */ ThreadCommentAndPraiseInfoLayout amM;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public am(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout, int i) {
        super(i);
        this.amM = threadCommentAndPraiseInfoLayout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        bm bmVar;
        bm bmVar2;
        bm bmVar3;
        bm bmVar4;
        bm bmVar5;
        bm bmVar6;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bm)) {
            bmVar = this.amM.aiu;
            if (bmVar != null) {
                bmVar2 = this.amM.aiu;
                if (bmVar2.getId() != null) {
                    bm bmVar7 = (bm) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(bmVar7.getId()) && bmVar7.rh() != null) {
                        String id = bmVar7.getId();
                        bmVar3 = this.amM.aiu;
                        if (id.equals(bmVar3.getId())) {
                            bmVar4 = this.amM.aiu;
                            if (bmVar4.rh() != null) {
                                bmVar6 = this.amM.aiu;
                                bmVar6.rh().setNum(bmVar7.rh().getNum());
                            }
                            ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = this.amM;
                            bmVar5 = this.amM.aiu;
                            threadCommentAndPraiseInfoLayout.g(bmVar5);
                        }
                    }
                }
            }
        }
    }
}
