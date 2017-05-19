package com.baidu.tbadk.core.view;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.bk;
/* loaded from: classes.dex */
class am extends CustomMessageListener {
    final /* synthetic */ ThreadCommentAndPraiseInfoLayout ame;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public am(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout, int i) {
        super(i);
        this.ame = threadCommentAndPraiseInfoLayout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        bk bkVar;
        bk bkVar2;
        bk bkVar3;
        bk bkVar4;
        bk bkVar5;
        bk bkVar6;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bk)) {
            bkVar = this.ame.ahV;
            if (bkVar != null) {
                bkVar2 = this.ame.ahV;
                if (bkVar2.getId() != null) {
                    bk bkVar7 = (bk) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(bkVar7.getId()) && bkVar7.ro() != null) {
                        String id = bkVar7.getId();
                        bkVar3 = this.ame.ahV;
                        if (id.equals(bkVar3.getId())) {
                            bkVar4 = this.ame.ahV;
                            if (bkVar4.ro() != null) {
                                bkVar6 = this.ame.ahV;
                                bkVar6.ro().setNum(bkVar7.ro().getNum());
                            }
                            ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = this.ame;
                            bkVar5 = this.ame.ahV;
                            threadCommentAndPraiseInfoLayout.f(bkVar5);
                        }
                    }
                }
            }
        }
    }
}
