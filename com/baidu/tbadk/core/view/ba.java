package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class ba implements View.OnClickListener {
    final /* synthetic */ UserIconLayout amK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(UserIconLayout userIconLayout) {
        this.amK = userIconLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bk bkVar;
        bk bkVar2;
        bk bkVar3;
        Context context;
        bk bkVar4;
        bk bkVar5;
        bkVar = this.amK.ahV;
        if (bkVar != null) {
            bkVar2 = this.amK.ahV;
            if (bkVar2.sC() != null) {
                bkVar3 = this.amK.ahV;
                if (bkVar3.sC().channelId > 0) {
                    MessageManager messageManager = MessageManager.getInstance();
                    context = this.amK.mContext;
                    bkVar4 = this.amK.ahV;
                    long j = bkVar4.sC().channelId;
                    bkVar5 = this.amK.ahV;
                    messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(context, j, bkVar5.sC().mCurrentPage)));
                }
            }
        }
    }
}
