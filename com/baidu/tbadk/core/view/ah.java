package com.baidu.tbadk.core.view;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.bg;
/* loaded from: classes.dex */
class ah extends CustomMessageListener {
    final /* synthetic */ ThreadCommentAndPraiseInfoLayout ahB;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ah(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout, int i) {
        super(i);
        this.ahB = threadCommentAndPraiseInfoLayout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        bg bgVar;
        bg bgVar2;
        bg bgVar3;
        bg bgVar4;
        bg bgVar5;
        bg bgVar6;
        bg bgVar7;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bg)) {
            bgVar = this.ahB.adL;
            if (bgVar != null) {
                bgVar2 = this.ahB.adL;
                if (bgVar2 != null) {
                    bgVar3 = this.ahB.adL;
                    if (bgVar3.getId() != null) {
                        bg bgVar8 = (bg) customResponsedMessage.getData();
                        if (!TextUtils.isEmpty(bgVar8.getId()) && bgVar8.rt() != null) {
                            String id = bgVar8.getId();
                            bgVar4 = this.ahB.adL;
                            if (id.equals(bgVar4.getId())) {
                                bgVar5 = this.ahB.adL;
                                if (bgVar5.rt() != null) {
                                    bgVar7 = this.ahB.adL;
                                    bgVar7.rt().setNum(bgVar8.rt().getNum());
                                }
                                ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = this.ahB;
                                bgVar6 = this.ahB.adL;
                                threadCommentAndPraiseInfoLayout.a(bgVar6);
                            }
                        }
                    }
                }
            }
        }
    }
}
