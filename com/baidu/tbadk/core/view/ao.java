package com.baidu.tbadk.core.view;

import android.content.Context;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.view.UserLikeButton;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao extends CustomMessageListener {
    final /* synthetic */ UserLikeButton aia;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ao(UserLikeButton userLikeButton, int i) {
        super(i);
        this.aia = userLikeButton;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tbadk.core.data.as asVar;
        com.baidu.tbadk.core.data.as asVar2;
        com.baidu.tbadk.core.data.as asVar3;
        com.baidu.tbadk.core.data.as asVar4;
        Context context;
        com.baidu.tbadk.core.data.as asVar5;
        com.baidu.tbadk.core.data.as asVar6;
        int fansNum;
        com.baidu.tbadk.core.data.as asVar7;
        UserLikeButton.a aVar;
        UserLikeButton.a aVar2;
        com.baidu.tbadk.core.data.as asVar8;
        com.baidu.tbadk.core.data.as asVar9;
        if (customResponsedMessage instanceof UpdateAttentionMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            asVar = this.aia.aeC;
            if (asVar != null) {
                asVar2 = this.aia.aeC;
                if (asVar2.getAuthor() != null) {
                    asVar3 = this.aia.aeC;
                    if (!StringUtils.isNull(asVar3.getAuthor().getUserId()) && updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                        String str = updateAttentionMessage.getData().toUid;
                        asVar4 = this.aia.aeC;
                        if (str.equals(asVar4.getAuthor().getUserId())) {
                            if (!updateAttentionMessage.getData().CK) {
                                context = this.aia.mContext;
                                com.baidu.adp.lib.util.k.showToast(context, updateAttentionMessage.getData().errorString);
                                return;
                            }
                            if (updateAttentionMessage.getData().akM) {
                                asVar8 = this.aia.aeC;
                                asVar8.getAuthor().getGodUserData().setFollowed(1);
                                asVar9 = this.aia.aeC;
                                fansNum = asVar9.getAuthor().getFansNum() + 1;
                            } else {
                                asVar5 = this.aia.aeC;
                                asVar5.getAuthor().getGodUserData().setFollowed(0);
                                asVar6 = this.aia.aeC;
                                fansNum = asVar6.getAuthor().getFansNum() - 1;
                            }
                            asVar7 = this.aia.aeC;
                            asVar7.getAuthor().setFansNum(fansNum);
                            aVar = this.aia.ahX;
                            if (aVar != null) {
                                aVar2 = this.aia.ahX;
                                aVar2.dp(fansNum);
                            }
                            this.aia.aD(false);
                        }
                    }
                }
            }
        }
    }
}
