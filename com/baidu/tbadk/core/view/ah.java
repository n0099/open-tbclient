package com.baidu.tbadk.core.view;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.bg;
/* loaded from: classes.dex */
class ah extends CustomMessageListener {
    final /* synthetic */ ThreadCommentAndPraiseInfoLayout ahk;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ah(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout, int i) {
        super(i);
        this.ahk = threadCommentAndPraiseInfoLayout;
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
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bg)) {
            bgVar = this.ahk.adN;
            if (bgVar != null) {
                bgVar2 = this.ahk.adN;
                if (bgVar2.getId() != null) {
                    bg bgVar7 = (bg) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(bgVar7.getId()) && bgVar7.rv() != null) {
                        String id = bgVar7.getId();
                        bgVar3 = this.ahk.adN;
                        if (id.equals(bgVar3.getId())) {
                            bgVar4 = this.ahk.adN;
                            if (bgVar4.rv() != null) {
                                bgVar6 = this.ahk.adN;
                                bgVar6.rv().setNum(bgVar7.rv().getNum());
                            }
                            ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = this.ahk;
                            bgVar5 = this.ahk.adN;
                            threadCommentAndPraiseInfoLayout.f(bgVar5);
                        }
                    }
                }
            }
        }
    }
}
