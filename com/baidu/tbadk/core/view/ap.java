package com.baidu.tbadk.core.view;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.view.UserLikeButton;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap extends CustomMessageListener {
    final /* synthetic */ UserLikeButton ahP;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ap(UserLikeButton userLikeButton, int i) {
        super(i);
        this.ahP = userLikeButton;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        bi biVar;
        bi biVar2;
        bi biVar3;
        bi biVar4;
        Context context;
        bi biVar5;
        bi biVar6;
        bi biVar7;
        int fansNum;
        bi biVar8;
        bi biVar9;
        UserLikeButton.a aVar;
        Message<?> message;
        BdUniqueId bdUniqueId;
        Context context2;
        UserLikeButton.a aVar2;
        bi biVar10;
        bi biVar11;
        bi biVar12;
        if (customResponsedMessage instanceof UpdateAttentionMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            biVar = this.ahP.adW;
            if (biVar != null) {
                biVar2 = this.ahP.adW;
                if (biVar2.getAuthor() != null) {
                    biVar3 = this.ahP.adW;
                    if (!StringUtils.isNull(biVar3.getAuthor().getUserId()) && updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                        String str = updateAttentionMessage.getData().toUid;
                        biVar4 = this.ahP.adW;
                        if (str.equals(biVar4.getAuthor().getUserId())) {
                            if (!updateAttentionMessage.getData().vS) {
                                context = this.ahP.mContext;
                                com.baidu.adp.lib.util.k.showToast(context, updateAttentionMessage.getData().errorString);
                                return;
                            }
                            if (updateAttentionMessage.getData().akC) {
                                biVar10 = this.ahP.adW;
                                biVar10.getAuthor().getGodUserData().setFollowed(1);
                                biVar11 = this.ahP.adW;
                                biVar11.getAuthor().setHadConcerned(true);
                                biVar12 = this.ahP.adW;
                                fansNum = biVar12.getAuthor().getFansNum() + 1;
                            } else {
                                biVar5 = this.ahP.adW;
                                biVar5.getAuthor().getGodUserData().setFollowed(0);
                                biVar6 = this.ahP.adW;
                                biVar6.getAuthor().setHadConcerned(false);
                                biVar7 = this.ahP.adW;
                                fansNum = biVar7.getAuthor().getFansNum() - 1;
                            }
                            biVar8 = this.ahP.adW;
                            biVar8.getAuthor().getGodUserData().setIsFromNetWork(false);
                            biVar9 = this.ahP.adW;
                            biVar9.getAuthor().setFansNum(fansNum);
                            aVar = this.ahP.ahI;
                            if (aVar != null) {
                                aVar2 = this.ahP.ahI;
                                aVar2.dm(fansNum);
                            }
                            this.ahP.aK(false);
                            if (updateAttentionMessage.getData().akE && !StringUtils.isNull(updateAttentionMessage.getData().showMsg, true) && updateAttentionMessage.getData().akC && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null) {
                                BdUniqueId tag = message.getTag();
                                bdUniqueId = this.ahP.ahL;
                                if (tag.equals(bdUniqueId)) {
                                    context2 = this.ahP.mContext;
                                    com.baidu.adp.lib.util.k.showToast(context2, updateAttentionMessage.getData().showMsg);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
