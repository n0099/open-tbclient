package com.baidu.tbadk.core.view;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.az;
/* loaded from: classes.dex */
class ag extends CustomMessageListener {
    final /* synthetic */ ThreadCommentAndPraiseInfoLayout adS;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ag(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout, int i) {
        super(i);
        this.adS = threadCommentAndPraiseInfoLayout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        az azVar;
        az azVar2;
        az azVar3;
        az azVar4;
        az azVar5;
        az azVar6;
        az azVar7;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof az)) {
            azVar = this.adS.aas;
            if (azVar != null) {
                azVar2 = this.adS.aas;
                if (azVar2 != null) {
                    azVar3 = this.adS.aas;
                    if (azVar3.getId() != null) {
                        az azVar8 = (az) customResponsedMessage.getData();
                        if (!TextUtils.isEmpty(azVar8.getId()) && azVar8.getPraise() != null) {
                            String id = azVar8.getId();
                            azVar4 = this.adS.aas;
                            if (id.equals(azVar4.getId())) {
                                azVar5 = this.adS.aas;
                                if (azVar5.getPraise() != null) {
                                    azVar7 = this.adS.aas;
                                    azVar7.getPraise().setNum(azVar8.getPraise().getNum());
                                }
                                ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = this.adS;
                                azVar6 = this.adS.aas;
                                threadCommentAndPraiseInfoLayout.a(azVar6);
                            }
                        }
                    }
                }
            }
        }
    }
}
