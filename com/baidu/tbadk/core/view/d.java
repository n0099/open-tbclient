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
class d implements View.OnClickListener {
    final /* synthetic */ HeadPendantClickableView aiI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(HeadPendantClickableView headPendantClickableView) {
        this.aiI = headPendantClickableView;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
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
        Context context;
        bj bjVar6;
        bj bjVar7;
        bj bjVar8;
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        bj bjVar9;
        Context context2;
        bj bjVar10;
        bj bjVar11;
        bjVar = this.aiI.ain;
        if (bjVar != null) {
            bjVar2 = this.aiI.ain;
            if (bjVar2.getAuthor() != null) {
                bjVar3 = this.aiI.ain;
                if (!StringUtils.isNull(bjVar3.getAuthor().getName_show())) {
                    bjVar4 = this.aiI.ain;
                    if (!StringUtils.isNull(bjVar4.getAuthor().getUserId())) {
                        bjVar5 = this.aiI.ain;
                        if (bjVar5.sU() != null) {
                            bjVar9 = this.aiI.ain;
                            if (bjVar9.sU().channelId > 0) {
                                MessageManager messageManager = MessageManager.getInstance();
                                context2 = this.aiI.mContext;
                                bjVar10 = this.aiI.ain;
                                long j = bjVar10.sU().channelId;
                                bjVar11 = this.aiI.ain;
                                messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(context2, j, bjVar11.sU().mCurrentPage)));
                                onClickListener = this.aiI.aio;
                                if (onClickListener == null) {
                                    onClickListener2 = this.aiI.aio;
                                    onClickListener2.onClick(view);
                                    return;
                                }
                                return;
                            }
                        }
                        MessageManager messageManager2 = MessageManager.getInstance();
                        context = this.aiI.mContext;
                        bjVar6 = this.aiI.ain;
                        String userId = bjVar6.getAuthor().getUserId();
                        bjVar7 = this.aiI.ain;
                        String name_show = bjVar7.getAuthor().getName_show();
                        bjVar8 = this.aiI.ain;
                        messageManager2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, userId, name_show, bjVar8.rV(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                        onClickListener = this.aiI.aio;
                        if (onClickListener == null) {
                        }
                    }
                }
            }
        }
    }
}
