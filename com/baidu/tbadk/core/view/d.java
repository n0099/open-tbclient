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
class d implements View.OnClickListener {
    final /* synthetic */ HeadPendantClickableView aiT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(HeadPendantClickableView headPendantClickableView) {
        this.aiT = headPendantClickableView;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
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
        Context context;
        bm bmVar6;
        bm bmVar7;
        bm bmVar8;
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        bm bmVar9;
        Context context2;
        bm bmVar10;
        bm bmVar11;
        if (this.aiT.aiw == null || !this.aiT.aiw.s(view)) {
            bmVar = this.aiT.aiu;
            if (bmVar != null) {
                bmVar2 = this.aiT.aiu;
                if (bmVar2.getAuthor() != null) {
                    bmVar3 = this.aiT.aiu;
                    if (!StringUtils.isNull(bmVar3.getAuthor().getName_show())) {
                        bmVar4 = this.aiT.aiu;
                        if (!StringUtils.isNull(bmVar4.getAuthor().getUserId())) {
                            bmVar5 = this.aiT.aiu;
                            if (bmVar5.sv() != null) {
                                bmVar9 = this.aiT.aiu;
                                if (bmVar9.sv().channelId > 0) {
                                    MessageManager messageManager = MessageManager.getInstance();
                                    context2 = this.aiT.mContext;
                                    bmVar10 = this.aiT.aiu;
                                    long j = bmVar10.sv().channelId;
                                    bmVar11 = this.aiT.aiu;
                                    messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(context2, j, bmVar11.sv().mCurrentPage)));
                                    onClickListener = this.aiT.aiv;
                                    if (onClickListener == null) {
                                        onClickListener2 = this.aiT.aiv;
                                        onClickListener2.onClick(view);
                                        return;
                                    }
                                    return;
                                }
                            }
                            MessageManager messageManager2 = MessageManager.getInstance();
                            context = this.aiT.mContext;
                            bmVar6 = this.aiT.aiu;
                            String userId = bmVar6.getAuthor().getUserId();
                            bmVar7 = this.aiT.aiu;
                            String name_show = bmVar7.getAuthor().getName_show();
                            bmVar8 = this.aiT.aiu;
                            messageManager2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, userId, name_show, bmVar8.rw(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                            onClickListener = this.aiT.aiv;
                            if (onClickListener == null) {
                            }
                        }
                    }
                }
            }
        }
    }
}
