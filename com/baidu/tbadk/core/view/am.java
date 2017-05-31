package com.baidu.tbadk.core.view;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.bl;
/* loaded from: classes.dex */
class am extends CustomMessageListener {
    final /* synthetic */ ThreadCommentAndPraiseInfoLayout alU;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public am(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout, int i) {
        super(i);
        this.alU = threadCommentAndPraiseInfoLayout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        bl blVar;
        bl blVar2;
        bl blVar3;
        bl blVar4;
        bl blVar5;
        bl blVar6;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bl)) {
            blVar = this.alU.ahM;
            if (blVar != null) {
                blVar2 = this.alU.ahM;
                if (blVar2.getId() != null) {
                    bl blVar7 = (bl) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(blVar7.getId()) && blVar7.rk() != null) {
                        String id = blVar7.getId();
                        blVar3 = this.alU.ahM;
                        if (id.equals(blVar3.getId())) {
                            blVar4 = this.alU.ahM;
                            if (blVar4.rk() != null) {
                                blVar6 = this.alU.ahM;
                                blVar6.rk().setNum(blVar7.rk().getNum());
                            }
                            ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = this.alU;
                            blVar5 = this.alU.ahM;
                            threadCommentAndPraiseInfoLayout.f(blVar5);
                        }
                    }
                }
            }
        }
    }
}
