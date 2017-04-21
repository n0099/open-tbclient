package com.baidu.tbadk.core.view.userLike;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends CustomMessageListener {
    final /* synthetic */ c amV;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(c cVar, int i) {
        super(i);
        this.amV = cVar;
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
            if (this.amV.amO != null && !StringUtils.isNull(this.amV.amO.getUserId()) && data != null && this.amV.amO.getUserId().equals(data.toUid)) {
                if (!data.CB) {
                    tbPageContext = this.amV.ajU;
                    tbPageContext.showToast(updateAttentionMessage.getData().errorString);
                    return;
                }
                int fansNum = this.amV.amO.getFansNum();
                if (data.isAttention && !this.amV.amO.getIsLike()) {
                    fansNum++;
                } else if (!data.isAttention && this.amV.amO.getIsLike()) {
                    fansNum--;
                }
                this.amV.amO.setIsLike(data.isAttention);
                this.amV.amO.setIsFromNetWork(false);
                this.amV.amO.setFansNum(fansNum);
                bVar = this.amV.amP;
                if (bVar != null) {
                    bVar2 = this.amV.amP;
                    bVar2.dq(fansNum);
                    bVar3 = this.amV.amP;
                    bVar3.aQ(data.isAttention);
                }
            }
        }
    }
}
