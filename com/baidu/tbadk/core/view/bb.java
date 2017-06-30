package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class bb implements View.OnClickListener {
    final /* synthetic */ UserIconLayout anE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(UserIconLayout userIconLayout) {
        this.anE = userIconLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bm bmVar;
        bm bmVar2;
        bm bmVar3;
        Context context;
        bm bmVar4;
        bm bmVar5;
        bmVar = this.anE.aiu;
        if (bmVar != null) {
            bmVar2 = this.anE.aiu;
            if (bmVar2.sv() != null) {
                bmVar3 = this.anE.aiu;
                if (bmVar3.sv().channelId > 0) {
                    MessageManager messageManager = MessageManager.getInstance();
                    context = this.anE.mContext;
                    bmVar4 = this.anE.aiu;
                    long j = bmVar4.sv().channelId;
                    bmVar5 = this.anE.aiu;
                    messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(context, j, bmVar5.sv().mCurrentPage)));
                }
            }
        }
    }
}
