package com.baidu.tbadk.core.view.userLike;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends CustomMessageListener {
    final /* synthetic */ c anW;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(c cVar, int i) {
        super(i);
        this.anW = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        b bVar;
        b bVar2;
        b bVar3;
        TbPageContext tbPageContext;
        if (customResponsedMessage instanceof UpdateAttentionMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            UpdateAttentionMessage.a data = updateAttentionMessage.getData();
            if (this.anW.anP != null && !StringUtils.isNull(this.anW.anP.getUserId()) && data != null && this.anW.anP.getUserId().equals(data.toUid)) {
                if (!data.CB) {
                    tbPageContext = this.anW.ajP;
                    tbPageContext.showToast(updateAttentionMessage.getData().errorString);
                    return;
                }
                int fansNum = this.anW.anP.getFansNum();
                if (data.isAttention && !this.anW.anP.getIsLike()) {
                    fansNum++;
                } else if (!data.isAttention && this.anW.anP.getIsLike()) {
                    fansNum--;
                }
                this.anW.anP.setIsLike(data.isAttention);
                this.anW.anP.setIsFromNetWork(false);
                this.anW.anP.setFansNum(fansNum);
                bVar = this.anW.anQ;
                if (bVar != null) {
                    bVar2 = this.anW.anQ;
                    bVar2.dr(fansNum);
                    bVar3 = this.anW.anQ;
                    bVar3.aP(data.isAttention);
                }
            }
        }
    }
}
