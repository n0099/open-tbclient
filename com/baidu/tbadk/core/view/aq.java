package com.baidu.tbadk.core.view;

import android.content.Context;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.view.UserLikeButton;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq extends CustomMessageListener {
    final /* synthetic */ UserLikeButton adX;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aq(UserLikeButton userLikeButton, int i) {
        super(i);
        this.adX = userLikeButton;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ax axVar;
        ax axVar2;
        ax axVar3;
        ax axVar4;
        Context context;
        ax axVar5;
        ax axVar6;
        int fansNum;
        ax axVar7;
        ax axVar8;
        UserLikeButton.a aVar;
        UserLikeButton.a aVar2;
        ax axVar9;
        ax axVar10;
        if (customResponsedMessage instanceof UpdateAttentionMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            axVar = this.adX.aab;
            if (axVar != null) {
                axVar2 = this.adX.aab;
                if (axVar2.getAuthor() != null) {
                    axVar3 = this.adX.aab;
                    if (!StringUtils.isNull(axVar3.getAuthor().getUserId()) && updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                        String str = updateAttentionMessage.getData().toUid;
                        axVar4 = this.adX.aab;
                        if (str.equals(axVar4.getAuthor().getUserId())) {
                            if (!updateAttentionMessage.getData().sZ) {
                                context = this.adX.mContext;
                                com.baidu.adp.lib.util.k.showToast(context, updateAttentionMessage.getData().errorString);
                                return;
                            }
                            if (updateAttentionMessage.getData().agz) {
                                axVar9 = this.adX.aab;
                                axVar9.getAuthor().getGodUserData().setFollowed(1);
                                axVar10 = this.adX.aab;
                                fansNum = axVar10.getAuthor().getFansNum() + 1;
                            } else {
                                axVar5 = this.adX.aab;
                                axVar5.getAuthor().getGodUserData().setFollowed(0);
                                axVar6 = this.adX.aab;
                                fansNum = axVar6.getAuthor().getFansNum() - 1;
                            }
                            axVar7 = this.adX.aab;
                            axVar7.getAuthor().getGodUserData().setIsFromNetWork(false);
                            axVar8 = this.adX.aab;
                            axVar8.getAuthor().setFansNum(fansNum);
                            aVar = this.adX.adT;
                            if (aVar != null) {
                                aVar2 = this.adX.adT;
                                aVar2.cW(fansNum);
                            }
                            this.adX.aI(false);
                        }
                    }
                }
            }
        }
    }
}
