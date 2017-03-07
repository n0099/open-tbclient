package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class at implements View.OnClickListener {
    final /* synthetic */ UserIconLayout amr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(UserIconLayout userIconLayout) {
        this.amr = userIconLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bj bjVar;
        bj bjVar2;
        bj bjVar3;
        Context context;
        bj bjVar4;
        bj bjVar5;
        bjVar = this.amr.ain;
        if (bjVar != null) {
            bjVar2 = this.amr.ain;
            if (bjVar2.sU() != null) {
                bjVar3 = this.amr.ain;
                if (bjVar3.sU().channelId > 0) {
                    MessageManager messageManager = MessageManager.getInstance();
                    context = this.amr.mContext;
                    bjVar4 = this.amr.ain;
                    long j = bjVar4.sU().channelId;
                    bjVar5 = this.amr.ain;
                    messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(context, j, bjVar5.sU().mCurrentPage)));
                }
            }
        }
    }
}
