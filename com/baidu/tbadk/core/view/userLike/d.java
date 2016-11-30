package com.baidu.tbadk.core.view.userLike;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends CustomMessageListener {
    final /* synthetic */ c aiw;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(c cVar, int i) {
        super(i);
        this.aiw = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        a aVar;
        a aVar2;
        a aVar3;
        a aVar4;
        a aVar5;
        a aVar6;
        a aVar7;
        a aVar8;
        b bVar;
        b bVar2;
        b bVar3;
        a aVar9;
        TbPageContext tbPageContext;
        if (customResponsedMessage instanceof UpdateAttentionMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            UpdateAttentionMessage.a data = updateAttentionMessage.getData();
            aVar = this.aiw.aip;
            if (aVar != null) {
                aVar2 = this.aiw.aip;
                if (!StringUtils.isNull(aVar2.getUserId()) && data != null) {
                    aVar3 = this.aiw.aip;
                    if (aVar3.getUserId().equals(data.toUid)) {
                        if (data.vS) {
                            aVar4 = this.aiw.aip;
                            int fansNum = aVar4.getFansNum();
                            if (data.alx) {
                                aVar9 = this.aiw.aip;
                                if (!aVar9.getIsLike()) {
                                    fansNum++;
                                    aVar6 = this.aiw.aip;
                                    aVar6.setIsLike(data.alx);
                                    aVar7 = this.aiw.aip;
                                    aVar7.setIsFromNetWork(false);
                                    aVar8 = this.aiw.aip;
                                    aVar8.setFansNum(fansNum);
                                    bVar = this.aiw.aiq;
                                    if (bVar == null) {
                                        bVar2 = this.aiw.aiq;
                                        bVar2.mo12do(fansNum);
                                        bVar3 = this.aiw.aiq;
                                        bVar3.aO(data.alx);
                                        return;
                                    }
                                    return;
                                }
                            }
                            if (!data.alx) {
                                aVar5 = this.aiw.aip;
                                if (aVar5.getIsLike()) {
                                    fansNum--;
                                }
                            }
                            aVar6 = this.aiw.aip;
                            aVar6.setIsLike(data.alx);
                            aVar7 = this.aiw.aip;
                            aVar7.setIsFromNetWork(false);
                            aVar8 = this.aiw.aip;
                            aVar8.setFansNum(fansNum);
                            bVar = this.aiw.aiq;
                            if (bVar == null) {
                            }
                        } else {
                            tbPageContext = this.aiw.GO;
                            tbPageContext.showToast(updateAttentionMessage.getData().errorString);
                        }
                    }
                }
            }
        }
    }
}
