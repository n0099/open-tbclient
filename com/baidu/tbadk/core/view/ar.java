package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class ar implements View.OnClickListener {
    final /* synthetic */ UserIconLayout agV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(UserIconLayout userIconLayout) {
        this.agV = userIconLayout;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        bh bhVar;
        bh bhVar2;
        bh bhVar3;
        bh bhVar4;
        bh bhVar5;
        bh bhVar6;
        Context context;
        bh bhVar7;
        bh bhVar8;
        bh bhVar9;
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        bh bhVar10;
        Context context2;
        bh bhVar11;
        bh bhVar12;
        bhVar = this.agV.acX;
        if (bhVar != null) {
            bhVar2 = this.agV.acX;
            if (bhVar2.getAuthor() != null) {
                bhVar3 = this.agV.acX;
                if (!StringUtils.isNull(bhVar3.getAuthor().getName_show())) {
                    bhVar4 = this.agV.acX;
                    if (!StringUtils.isNull(bhVar4.getAuthor().getUserId())) {
                        bhVar5 = this.agV.acX;
                        if (bhVar5.rB() != null) {
                            bhVar6 = this.agV.acX;
                            if (bhVar6.sz() != null) {
                                bhVar10 = this.agV.acX;
                                if (bhVar10.sz().channelId > 0) {
                                    MessageManager messageManager = MessageManager.getInstance();
                                    context2 = this.agV.mContext;
                                    bhVar11 = this.agV.acX;
                                    long j = bhVar11.sz().channelId;
                                    bhVar12 = this.agV.acX;
                                    messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(context2, j, bhVar12.sz().mCurrentPage)));
                                    onClickListener = this.agV.agO;
                                    if (onClickListener == null) {
                                        onClickListener2 = this.agV.agO;
                                        onClickListener2.onClick(view);
                                        return;
                                    }
                                    return;
                                }
                            }
                            MessageManager messageManager2 = MessageManager.getInstance();
                            context = this.agV.mContext;
                            bhVar7 = this.agV.acX;
                            String userId = bhVar7.getAuthor().getUserId();
                            bhVar8 = this.agV.acX;
                            String name_show = bhVar8.getAuthor().getName_show();
                            bhVar9 = this.agV.acX;
                            messageManager2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, userId, name_show, bhVar9.rB(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                            onClickListener = this.agV.agO;
                            if (onClickListener == null) {
                            }
                        }
                    }
                }
            }
        }
    }
}
