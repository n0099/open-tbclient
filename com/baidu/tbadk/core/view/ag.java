package com.baidu.tbadk.core.view;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.bk;
/* loaded from: classes.dex */
class ag extends CustomMessageListener {
    final /* synthetic */ ThreadCommentAndPraiseInfoLayout ahJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ag(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout, int i) {
        super(i);
        this.ahJ = threadCommentAndPraiseInfoLayout;
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
            bkVar = this.ahJ.aeu;
            if (bkVar != null) {
                bkVar2 = this.ahJ.aeu;
                if (bkVar2.getId() != null) {
                    bk bkVar7 = (bk) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(bkVar7.getId()) && bkVar7.rH() != null) {
                        String id = bkVar7.getId();
                        bkVar3 = this.ahJ.aeu;
                        if (id.equals(bkVar3.getId())) {
                            bkVar4 = this.ahJ.aeu;
                            if (bkVar4.rH() != null) {
                                bkVar6 = this.ahJ.aeu;
                                bkVar6.rH().setNum(bkVar7.rH().getNum());
                            }
                            ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = this.ahJ;
                            bkVar5 = this.ahJ.aeu;
                            threadCommentAndPraiseInfoLayout.b(bkVar5);
                        }
                    }
                }
            }
        }
    }
}
