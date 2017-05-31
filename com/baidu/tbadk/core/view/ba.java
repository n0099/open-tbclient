package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class ba implements View.OnClickListener {
    final /* synthetic */ UserIconLayout amG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(UserIconLayout userIconLayout) {
        this.amG = userIconLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bl blVar;
        bl blVar2;
        bl blVar3;
        Context context;
        bl blVar4;
        bl blVar5;
        blVar = this.amG.ahM;
        if (blVar != null) {
            blVar2 = this.amG.ahM;
            if (blVar2.sx() != null) {
                blVar3 = this.amG.ahM;
                if (blVar3.sx().channelId > 0) {
                    MessageManager messageManager = MessageManager.getInstance();
                    context = this.amG.mContext;
                    blVar4 = this.amG.ahM;
                    long j = blVar4.sx().channelId;
                    blVar5 = this.amG.ahM;
                    messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(context, j, blVar5.sx().mCurrentPage)));
                }
            }
        }
    }
}
