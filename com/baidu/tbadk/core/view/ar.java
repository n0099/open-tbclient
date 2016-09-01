package com.baidu.tbadk.core.view;

import android.content.Context;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.view.UserLikeButton;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar extends CustomMessageListener {
    final /* synthetic */ UserLikeButton aih;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ar(UserLikeButton userLikeButton, int i) {
        super(i);
        this.aih = userLikeButton;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        bg bgVar;
        bg bgVar2;
        bg bgVar3;
        bg bgVar4;
        Context context;
        bg bgVar5;
        bg bgVar6;
        bg bgVar7;
        int fansNum;
        bg bgVar8;
        bg bgVar9;
        UserLikeButton.a aVar;
        UserLikeButton.a aVar2;
        bg bgVar10;
        bg bgVar11;
        bg bgVar12;
        if (customResponsedMessage instanceof UpdateAttentionMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            bgVar = this.aih.adL;
            if (bgVar != null) {
                bgVar2 = this.aih.adL;
                if (bgVar2.getAuthor() != null) {
                    bgVar3 = this.aih.adL;
                    if (!StringUtils.isNull(bgVar3.getAuthor().getUserId()) && updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                        String str = updateAttentionMessage.getData().toUid;
                        bgVar4 = this.aih.adL;
                        if (str.equals(bgVar4.getAuthor().getUserId())) {
                            if (!updateAttentionMessage.getData().vS) {
                                context = this.aih.mContext;
                                com.baidu.adp.lib.util.k.showToast(context, updateAttentionMessage.getData().errorString);
                                return;
                            }
                            if (updateAttentionMessage.getData().akW) {
                                bgVar10 = this.aih.adL;
                                bgVar10.getAuthor().getGodUserData().setFollowed(1);
                                bgVar11 = this.aih.adL;
                                bgVar11.getAuthor().setHadConcerned(true);
                                bgVar12 = this.aih.adL;
                                fansNum = bgVar12.getAuthor().getFansNum() + 1;
                            } else {
                                bgVar5 = this.aih.adL;
                                bgVar5.getAuthor().getGodUserData().setFollowed(0);
                                bgVar6 = this.aih.adL;
                                bgVar6.getAuthor().setHadConcerned(false);
                                bgVar7 = this.aih.adL;
                                fansNum = bgVar7.getAuthor().getFansNum() - 1;
                            }
                            bgVar8 = this.aih.adL;
                            bgVar8.getAuthor().getGodUserData().setIsFromNetWork(false);
                            bgVar9 = this.aih.adL;
                            bgVar9.getAuthor().setFansNum(fansNum);
                            aVar = this.aih.aia;
                            if (aVar != null) {
                                aVar2 = this.aih.aia;
                                aVar2.dm(fansNum);
                            }
                            this.aih.aK(false);
                        }
                    }
                }
            }
        }
    }
}
