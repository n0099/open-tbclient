package com.baidu.tbadk.core.view.userLike;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends CustomMessageListener {
    final /* synthetic */ c ahl;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(c cVar, int i) {
        super(i);
        this.ahl = cVar;
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
            if (this.ahl.ahe != null && !StringUtils.isNull(this.ahl.ahe.getUserId()) && data != null && this.ahl.ahe.getUserId().equals(data.toUid)) {
                if (!data.vJ) {
                    tbPageContext = this.ahl.FY;
                    tbPageContext.showToast(updateAttentionMessage.getData().errorString);
                    return;
                }
                int fansNum = this.ahl.ahe.getFansNum();
                if (data.isAttention && !this.ahl.ahe.getIsLike()) {
                    fansNum++;
                } else if (!data.isAttention && this.ahl.ahe.getIsLike()) {
                    fansNum--;
                }
                this.ahl.ahe.setIsLike(data.isAttention);
                this.ahl.ahe.setIsFromNetWork(false);
                this.ahl.ahe.setFansNum(fansNum);
                bVar = this.ahl.ahf;
                if (bVar != null) {
                    bVar2 = this.ahl.ahf;
                    bVar2.dr(fansNum);
                    bVar3 = this.ahl.ahf;
                    bVar3.aP(data.isAttention);
                }
            }
        }
    }
}
