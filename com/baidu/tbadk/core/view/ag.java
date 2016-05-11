package com.baidu.tbadk.core.view;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.ax;
/* loaded from: classes.dex */
class ag extends CustomMessageListener {
    final /* synthetic */ ThreadCommentAndPraiseInfoLayout adu;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ag(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout, int i) {
        super(i);
        this.adu = threadCommentAndPraiseInfoLayout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ax axVar;
        ax axVar2;
        ax axVar3;
        ax axVar4;
        ax axVar5;
        ax axVar6;
        ax axVar7;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ax)) {
            axVar = this.adu.aab;
            if (axVar != null) {
                axVar2 = this.adu.aab;
                if (axVar2 != null) {
                    axVar3 = this.adu.aab;
                    if (axVar3.getId() != null) {
                        ax axVar8 = (ax) customResponsedMessage.getData();
                        if (!TextUtils.isEmpty(axVar8.getId()) && axVar8.getPraise() != null) {
                            String id = axVar8.getId();
                            axVar4 = this.adu.aab;
                            if (id.equals(axVar4.getId())) {
                                axVar5 = this.adu.aab;
                                if (axVar5.getPraise() != null) {
                                    axVar7 = this.adu.aab;
                                    axVar7.getPraise().setNum(axVar8.getPraise().getNum());
                                }
                                ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = this.adu;
                                axVar6 = this.adu.aab;
                                threadCommentAndPraiseInfoLayout.a(axVar6);
                            }
                        }
                    }
                }
            }
        }
    }
}
