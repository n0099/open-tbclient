package com.baidu.tbadk.core.view;

import android.content.Context;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.view.UserLikeButton;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq extends CustomMessageListener {
    final /* synthetic */ UserLikeButton aey;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aq(UserLikeButton userLikeButton, int i) {
        super(i);
        this.aey = userLikeButton;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        az azVar;
        az azVar2;
        az azVar3;
        az azVar4;
        Context context;
        az azVar5;
        az azVar6;
        az azVar7;
        int fansNum;
        az azVar8;
        az azVar9;
        UserLikeButton.a aVar;
        UserLikeButton.a aVar2;
        az azVar10;
        az azVar11;
        az azVar12;
        if (customResponsedMessage instanceof UpdateAttentionMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            azVar = this.aey.aas;
            if (azVar != null) {
                azVar2 = this.aey.aas;
                if (azVar2.getAuthor() != null) {
                    azVar3 = this.aey.aas;
                    if (!StringUtils.isNull(azVar3.getAuthor().getUserId()) && updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                        String str = updateAttentionMessage.getData().toUid;
                        azVar4 = this.aey.aas;
                        if (str.equals(azVar4.getAuthor().getUserId())) {
                            if (!updateAttentionMessage.getData().tb) {
                                context = this.aey.mContext;
                                com.baidu.adp.lib.util.k.showToast(context, updateAttentionMessage.getData().errorString);
                                return;
                            }
                            if (updateAttentionMessage.getData().ahd) {
                                azVar10 = this.aey.aas;
                                azVar10.getAuthor().getGodUserData().setFollowed(1);
                                azVar11 = this.aey.aas;
                                azVar11.getAuthor().setHadConcerned(true);
                                azVar12 = this.aey.aas;
                                fansNum = azVar12.getAuthor().getFansNum() + 1;
                            } else {
                                azVar5 = this.aey.aas;
                                azVar5.getAuthor().getGodUserData().setFollowed(0);
                                azVar6 = this.aey.aas;
                                azVar6.getAuthor().setHadConcerned(false);
                                azVar7 = this.aey.aas;
                                fansNum = azVar7.getAuthor().getFansNum() - 1;
                            }
                            azVar8 = this.aey.aas;
                            azVar8.getAuthor().getGodUserData().setIsFromNetWork(false);
                            azVar9 = this.aey.aas;
                            azVar9.getAuthor().setFansNum(fansNum);
                            aVar = this.aey.aer;
                            if (aVar != null) {
                                aVar2 = this.aey.aer;
                                aVar2.cY(fansNum);
                            }
                            this.aey.aG(false);
                        }
                    }
                }
            }
        }
    }
}
