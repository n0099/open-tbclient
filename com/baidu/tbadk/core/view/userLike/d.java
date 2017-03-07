package com.baidu.tbadk.core.view.userLike;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends CustomMessageListener {
    final /* synthetic */ c amH;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(c cVar, int i) {
        super(i);
        this.amH = cVar;
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
            if (this.amH.amA != null && !StringUtils.isNull(this.amH.amA.getUserId()) && data != null && this.amH.amA.getUserId().equals(data.toUid)) {
                if (!data.CX) {
                    tbPageContext = this.amH.ajF;
                    tbPageContext.showToast(updateAttentionMessage.getData().errorString);
                    return;
                }
                int fansNum = this.amH.amA.getFansNum();
                if (data.isAttention && !this.amH.amA.getIsLike()) {
                    fansNum++;
                } else if (!data.isAttention && this.amH.amA.getIsLike()) {
                    fansNum--;
                }
                this.amH.amA.setIsLike(data.isAttention);
                this.amH.amA.setIsFromNetWork(false);
                this.amH.amA.setFansNum(fansNum);
                bVar = this.amH.amB;
                if (bVar != null) {
                    bVar2 = this.amH.amB;
                    bVar2.dn(fansNum);
                    bVar3 = this.amH.amB;
                    bVar3.aO(data.isAttention);
                }
            }
        }
    }
}
