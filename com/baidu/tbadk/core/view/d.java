package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class d implements View.OnClickListener {
    final /* synthetic */ HeadPendantClickableView aiu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(HeadPendantClickableView headPendantClickableView) {
        this.aiu = headPendantClickableView;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        bk bkVar;
        bk bkVar2;
        bk bkVar3;
        bk bkVar4;
        bk bkVar5;
        Context context;
        bk bkVar6;
        bk bkVar7;
        bk bkVar8;
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        bk bkVar9;
        Context context2;
        bk bkVar10;
        bk bkVar11;
        bkVar = this.aiu.ahV;
        if (bkVar != null) {
            bkVar2 = this.aiu.ahV;
            if (bkVar2.getAuthor() != null) {
                bkVar3 = this.aiu.ahV;
                if (!StringUtils.isNull(bkVar3.getAuthor().getName_show())) {
                    bkVar4 = this.aiu.ahV;
                    if (!StringUtils.isNull(bkVar4.getAuthor().getUserId())) {
                        bkVar5 = this.aiu.ahV;
                        if (bkVar5.sC() != null) {
                            bkVar9 = this.aiu.ahV;
                            if (bkVar9.sC().channelId > 0) {
                                MessageManager messageManager = MessageManager.getInstance();
                                context2 = this.aiu.mContext;
                                bkVar10 = this.aiu.ahV;
                                long j = bkVar10.sC().channelId;
                                bkVar11 = this.aiu.ahV;
                                messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(context2, j, bkVar11.sC().mCurrentPage)));
                                onClickListener = this.aiu.ahW;
                                if (onClickListener == null) {
                                    onClickListener2 = this.aiu.ahW;
                                    onClickListener2.onClick(view);
                                    return;
                                }
                                return;
                            }
                        }
                        MessageManager messageManager2 = MessageManager.getInstance();
                        context = this.aiu.mContext;
                        bkVar6 = this.aiu.ahV;
                        String userId = bkVar6.getAuthor().getUserId();
                        bkVar7 = this.aiu.ahV;
                        String name_show = bkVar7.getAuthor().getName_show();
                        bkVar8 = this.aiu.ahV;
                        messageManager2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, userId, name_show, bkVar8.rD(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                        onClickListener = this.aiu.ahW;
                        if (onClickListener == null) {
                        }
                    }
                }
            }
        }
    }
}
