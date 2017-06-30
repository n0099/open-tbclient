package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class ap implements View.OnClickListener {
    final /* synthetic */ ThreadCommentAndPraiseInfoLayoutNew amU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(ThreadCommentAndPraiseInfoLayoutNew threadCommentAndPraiseInfoLayoutNew) {
        this.amU = threadCommentAndPraiseInfoLayoutNew;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        bm bmVar;
        bm bmVar2;
        bm bmVar3;
        bm bmVar4;
        bm bmVar5;
        bm bmVar6;
        Context context;
        bm bmVar7;
        bm bmVar8;
        bm bmVar9;
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        bm bmVar10;
        Context context2;
        bm bmVar11;
        bm bmVar12;
        bmVar = this.amU.aiu;
        if (bmVar != null) {
            bmVar2 = this.amU.aiu;
            if (bmVar2.getAuthor() != null) {
                bmVar3 = this.amU.aiu;
                if (!StringUtils.isNull(bmVar3.getAuthor().getName_show())) {
                    bmVar4 = this.amU.aiu;
                    if (!StringUtils.isNull(bmVar4.getAuthor().getUserId())) {
                        bmVar5 = this.amU.aiu;
                        if (bmVar5.rw() != null) {
                            bmVar6 = this.amU.aiu;
                            if (bmVar6.sv() != null) {
                                bmVar10 = this.amU.aiu;
                                if (bmVar10.sv().channelId > 0) {
                                    MessageManager messageManager = MessageManager.getInstance();
                                    context2 = this.amU.mContext;
                                    bmVar11 = this.amU.aiu;
                                    long j = bmVar11.sv().channelId;
                                    bmVar12 = this.amU.aiu;
                                    messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(context2, j, bmVar12.sv().mCurrentPage)));
                                    onClickListener = this.amU.amS;
                                    if (onClickListener == null) {
                                        onClickListener2 = this.amU.amS;
                                        onClickListener2.onClick(view);
                                        return;
                                    }
                                    return;
                                }
                            }
                            MessageManager messageManager2 = MessageManager.getInstance();
                            context = this.amU.mContext;
                            bmVar7 = this.amU.aiu;
                            String userId = bmVar7.getAuthor().getUserId();
                            bmVar8 = this.amU.aiu;
                            String name_show = bmVar8.getAuthor().getName_show();
                            bmVar9 = this.amU.aiu;
                            messageManager2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, userId, name_show, bmVar9.rw(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                            onClickListener = this.amU.amS;
                            if (onClickListener == null) {
                            }
                        }
                    }
                }
            }
        }
    }
}
