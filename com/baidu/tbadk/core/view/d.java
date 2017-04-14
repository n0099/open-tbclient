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
class d implements View.OnClickListener {
    final /* synthetic */ HeadPendantClickableView aiW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(HeadPendantClickableView headPendantClickableView) {
        this.aiW = headPendantClickableView;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
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
        Context context;
        bi biVar6;
        bi biVar7;
        bi biVar8;
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        bi biVar9;
        Context context2;
        bi biVar10;
        bi biVar11;
        biVar = this.aiW.aiB;
        if (biVar != null) {
            biVar2 = this.aiW.aiB;
            if (biVar2.getAuthor() != null) {
                biVar3 = this.aiW.aiB;
                if (!StringUtils.isNull(biVar3.getAuthor().getName_show())) {
                    biVar4 = this.aiW.aiB;
                    if (!StringUtils.isNull(biVar4.getAuthor().getUserId())) {
                        biVar5 = this.aiW.aiB;
                        if (biVar5.ts() != null) {
                            biVar9 = this.aiW.aiB;
                            if (biVar9.ts().channelId > 0) {
                                MessageManager messageManager = MessageManager.getInstance();
                                context2 = this.aiW.mContext;
                                biVar10 = this.aiW.aiB;
                                long j = biVar10.ts().channelId;
                                biVar11 = this.aiW.aiB;
                                messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(context2, j, biVar11.ts().mCurrentPage)));
                                onClickListener = this.aiW.aiC;
                                if (onClickListener == null) {
                                    onClickListener2 = this.aiW.aiC;
                                    onClickListener2.onClick(view);
                                    return;
                                }
                                return;
                            }
                        }
                        MessageManager messageManager2 = MessageManager.getInstance();
                        context = this.aiW.mContext;
                        biVar6 = this.aiW.aiB;
                        String userId = biVar6.getAuthor().getUserId();
                        biVar7 = this.aiW.aiB;
                        String name_show = biVar7.getAuthor().getName_show();
                        biVar8 = this.aiW.aiB;
                        messageManager2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, userId, name_show, biVar8.st(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                        onClickListener = this.aiW.aiC;
                        if (onClickListener == null) {
                        }
                    }
                }
            }
        }
    }
}
