package com.baidu.tbadk.core.view.userLike;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends CustomMessageListener {
    final /* synthetic */ c ana;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(c cVar, int i) {
        super(i);
        this.ana = cVar;
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
            if (this.ana.amT != null && !StringUtils.isNull(this.ana.amT.getUserId()) && data != null && this.ana.amT.getUserId().equals(data.toUid)) {
                if (!data.CB) {
                    tbPageContext = this.ana.ajr;
                    tbPageContext.showToast(updateAttentionMessage.getData().errorString);
                    return;
                }
                int fansNum = this.ana.amT.getFansNum();
                if (data.isAttention && !this.ana.amT.getIsLike()) {
                    fansNum++;
                } else if (!data.isAttention && this.ana.amT.getIsLike()) {
                    fansNum--;
                }
                this.ana.amT.setIsLike(data.isAttention);
                this.ana.amT.setIsFromNetWork(false);
                this.ana.amT.setFansNum(fansNum);
                bVar = this.ana.amU;
                if (bVar != null) {
                    bVar2 = this.ana.amU;
                    bVar2.mo12do(fansNum);
                    bVar3 = this.ana.amU;
                    bVar3.aQ(data.isAttention);
                }
            }
        }
    }
}
