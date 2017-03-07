package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class as implements View.OnClickListener {
    final /* synthetic */ UserIconLayout amr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(UserIconLayout userIconLayout) {
        this.amr = userIconLayout;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        bj bjVar;
        bj bjVar2;
        bj bjVar3;
        bj bjVar4;
        bj bjVar5;
        bj bjVar6;
        Context context;
        bj bjVar7;
        bj bjVar8;
        bj bjVar9;
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        bj bjVar10;
        Context context2;
        bj bjVar11;
        bj bjVar12;
        bjVar = this.amr.ain;
        if (bjVar != null) {
            bjVar2 = this.amr.ain;
            if (bjVar2.getAuthor() != null) {
                bjVar3 = this.amr.ain;
                if (!StringUtils.isNull(bjVar3.getAuthor().getName_show())) {
                    bjVar4 = this.amr.ain;
                    if (!StringUtils.isNull(bjVar4.getAuthor().getUserId())) {
                        bjVar5 = this.amr.ain;
                        if (bjVar5.rV() != null) {
                            bjVar6 = this.amr.ain;
                            if (bjVar6.sU() != null) {
                                bjVar10 = this.amr.ain;
                                if (bjVar10.sU().channelId > 0) {
                                    MessageManager messageManager = MessageManager.getInstance();
                                    context2 = this.amr.mContext;
                                    bjVar11 = this.amr.ain;
                                    long j = bjVar11.sU().channelId;
                                    bjVar12 = this.amr.ain;
                                    messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(context2, j, bjVar12.sU().mCurrentPage)));
                                    onClickListener = this.amr.amj;
                                    if (onClickListener == null) {
                                        onClickListener2 = this.amr.amj;
                                        onClickListener2.onClick(view);
                                        return;
                                    }
                                    return;
                                }
                            }
                            MessageManager messageManager2 = MessageManager.getInstance();
                            context = this.amr.mContext;
                            bjVar7 = this.amr.ain;
                            String userId = bjVar7.getAuthor().getUserId();
                            bjVar8 = this.amr.ain;
                            String name_show = bjVar8.getAuthor().getName_show();
                            bjVar9 = this.amr.ain;
                            messageManager2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, userId, name_show, bjVar9.rV(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                            onClickListener = this.amr.amj;
                            if (onClickListener == null) {
                            }
                        }
                    }
                }
            }
        }
    }
}
