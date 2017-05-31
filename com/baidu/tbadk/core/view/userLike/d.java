package com.baidu.tbadk.core.view.userLike;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends CustomMessageListener {
    final /* synthetic */ c amW;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(c cVar, int i) {
        super(i);
        this.amW = cVar;
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
            if (this.amW.amP != null && !StringUtils.isNull(this.amW.amP.getUserId()) && data != null && this.amW.amP.getUserId().equals(data.toUid)) {
                if (!data.CB) {
                    tbPageContext = this.amW.ajh;
                    tbPageContext.showToast(updateAttentionMessage.getData().errorString);
                    return;
                }
                int fansNum = this.amW.amP.getFansNum();
                if (data.isAttention && !this.amW.amP.getIsLike()) {
                    fansNum++;
                } else if (!data.isAttention && this.amW.amP.getIsLike()) {
                    fansNum--;
                }
                this.amW.amP.setIsLike(data.isAttention);
                this.amW.amP.setIsFromNetWork(false);
                this.amW.amP.setFansNum(fansNum);
                bVar = this.amW.amQ;
                if (bVar != null) {
                    bVar2 = this.amW.amQ;
                    bVar2.dp(fansNum);
                    bVar3 = this.amW.amQ;
                    bVar3.aO(data.isAttention);
                }
            }
        }
    }
}
