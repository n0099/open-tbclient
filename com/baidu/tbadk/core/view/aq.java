package com.baidu.tbadk.core.view;

import android.content.Context;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.view.UserLikeButton;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq extends CustomMessageListener {
    final /* synthetic */ UserLikeButton afm;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aq(UserLikeButton userLikeButton, int i) {
        super(i);
        this.afm = userLikeButton;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        be beVar;
        be beVar2;
        be beVar3;
        be beVar4;
        Context context;
        be beVar5;
        be beVar6;
        be beVar7;
        int fansNum;
        be beVar8;
        be beVar9;
        UserLikeButton.a aVar;
        UserLikeButton.a aVar2;
        be beVar10;
        be beVar11;
        be beVar12;
        if (customResponsedMessage instanceof UpdateAttentionMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            beVar = this.afm.abb;
            if (beVar != null) {
                beVar2 = this.afm.abb;
                if (beVar2.getAuthor() != null) {
                    beVar3 = this.afm.abb;
                    if (!StringUtils.isNull(beVar3.getAuthor().getUserId()) && updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                        String str = updateAttentionMessage.getData().toUid;
                        beVar4 = this.afm.abb;
                        if (str.equals(beVar4.getAuthor().getUserId())) {
                            if (!updateAttentionMessage.getData().tF) {
                                context = this.afm.mContext;
                                com.baidu.adp.lib.util.k.showToast(context, updateAttentionMessage.getData().errorString);
                                return;
                            }
                            if (updateAttentionMessage.getData().ahS) {
                                beVar10 = this.afm.abb;
                                beVar10.getAuthor().getGodUserData().setFollowed(1);
                                beVar11 = this.afm.abb;
                                beVar11.getAuthor().setHadConcerned(true);
                                beVar12 = this.afm.abb;
                                fansNum = beVar12.getAuthor().getFansNum() + 1;
                            } else {
                                beVar5 = this.afm.abb;
                                beVar5.getAuthor().getGodUserData().setFollowed(0);
                                beVar6 = this.afm.abb;
                                beVar6.getAuthor().setHadConcerned(false);
                                beVar7 = this.afm.abb;
                                fansNum = beVar7.getAuthor().getFansNum() - 1;
                            }
                            beVar8 = this.afm.abb;
                            beVar8.getAuthor().getGodUserData().setIsFromNetWork(false);
                            beVar9 = this.afm.abb;
                            beVar9.getAuthor().setFansNum(fansNum);
                            aVar = this.afm.aff;
                            if (aVar != null) {
                                aVar2 = this.afm.aff;
                                aVar2.cY(fansNum);
                            }
                            this.afm.aJ(false);
                        }
                    }
                }
            }
        }
    }
}
