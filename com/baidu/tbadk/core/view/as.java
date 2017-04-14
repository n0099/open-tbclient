package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class as implements View.OnClickListener {
    final /* synthetic */ UserIconLayout amF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(UserIconLayout userIconLayout) {
        this.amF = userIconLayout;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        bi biVar;
        bi biVar2;
        bi biVar3;
        bi biVar4;
        bi biVar5;
        bi biVar6;
        Context context;
        bi biVar7;
        bi biVar8;
        bi biVar9;
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        bi biVar10;
        Context context2;
        bi biVar11;
        bi biVar12;
        biVar = this.amF.aiB;
        if (biVar != null) {
            biVar2 = this.amF.aiB;
            if (biVar2.getAuthor() != null) {
                biVar3 = this.amF.aiB;
                if (!StringUtils.isNull(biVar3.getAuthor().getName_show())) {
                    biVar4 = this.amF.aiB;
                    if (!StringUtils.isNull(biVar4.getAuthor().getUserId())) {
                        biVar5 = this.amF.aiB;
                        if (biVar5.st() != null) {
                            biVar6 = this.amF.aiB;
                            if (biVar6.ts() != null) {
                                biVar10 = this.amF.aiB;
                                if (biVar10.ts().channelId > 0) {
                                    MessageManager messageManager = MessageManager.getInstance();
                                    context2 = this.amF.mContext;
                                    biVar11 = this.amF.aiB;
                                    long j = biVar11.ts().channelId;
                                    biVar12 = this.amF.aiB;
                                    messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(context2, j, biVar12.ts().mCurrentPage)));
                                    onClickListener = this.amF.amx;
                                    if (onClickListener == null) {
                                        onClickListener2 = this.amF.amx;
                                        onClickListener2.onClick(view);
                                        return;
                                    }
                                    return;
                                }
                            }
                            MessageManager messageManager2 = MessageManager.getInstance();
                            context = this.amF.mContext;
                            biVar7 = this.amF.aiB;
                            String userId = biVar7.getAuthor().getUserId();
                            biVar8 = this.amF.aiB;
                            String name_show = biVar8.getAuthor().getName_show();
                            biVar9 = this.amF.aiB;
                            messageManager2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, userId, name_show, biVar9.st(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                            onClickListener = this.amF.amx;
                            if (onClickListener == null) {
                            }
                        }
                    }
                }
            }
        }
    }
}
