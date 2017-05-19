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
class az implements View.OnClickListener {
    final /* synthetic */ UserIconLayout amK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(UserIconLayout userIconLayout) {
        this.amK = userIconLayout;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
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
        bk bkVar6;
        Context context;
        bk bkVar7;
        bk bkVar8;
        bk bkVar9;
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        bk bkVar10;
        Context context2;
        bk bkVar11;
        bk bkVar12;
        bkVar = this.amK.ahV;
        if (bkVar != null) {
            bkVar2 = this.amK.ahV;
            if (bkVar2.getAuthor() != null) {
                bkVar3 = this.amK.ahV;
                if (!StringUtils.isNull(bkVar3.getAuthor().getName_show())) {
                    bkVar4 = this.amK.ahV;
                    if (!StringUtils.isNull(bkVar4.getAuthor().getUserId())) {
                        bkVar5 = this.amK.ahV;
                        if (bkVar5.rD() != null) {
                            bkVar6 = this.amK.ahV;
                            if (bkVar6.sC() != null) {
                                bkVar10 = this.amK.ahV;
                                if (bkVar10.sC().channelId > 0) {
                                    MessageManager messageManager = MessageManager.getInstance();
                                    context2 = this.amK.mContext;
                                    bkVar11 = this.amK.ahV;
                                    long j = bkVar11.sC().channelId;
                                    bkVar12 = this.amK.ahV;
                                    messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(context2, j, bkVar12.sC().mCurrentPage)));
                                    onClickListener = this.amK.amk;
                                    if (onClickListener == null) {
                                        onClickListener2 = this.amK.amk;
                                        onClickListener2.onClick(view);
                                        return;
                                    }
                                    return;
                                }
                            }
                            MessageManager messageManager2 = MessageManager.getInstance();
                            context = this.amK.mContext;
                            bkVar7 = this.amK.ahV;
                            String userId = bkVar7.getAuthor().getUserId();
                            bkVar8 = this.amK.ahV;
                            String name_show = bkVar8.getAuthor().getName_show();
                            bkVar9 = this.amK.ahV;
                            messageManager2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, userId, name_show, bkVar9.rD(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                            onClickListener = this.amK.amk;
                            if (onClickListener == null) {
                            }
                        }
                    }
                }
            }
        }
    }
}
