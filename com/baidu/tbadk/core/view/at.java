package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class at implements View.OnClickListener {
    final /* synthetic */ UserIconLayout amF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(UserIconLayout userIconLayout) {
        this.amF = userIconLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bi biVar;
        bi biVar2;
        bi biVar3;
        Context context;
        bi biVar4;
        bi biVar5;
        biVar = this.amF.aiB;
        if (biVar != null) {
            biVar2 = this.amF.aiB;
            if (biVar2.ts() != null) {
                biVar3 = this.amF.aiB;
                if (biVar3.ts().channelId > 0) {
                    MessageManager messageManager = MessageManager.getInstance();
                    context = this.amF.mContext;
                    biVar4 = this.amF.aiB;
                    long j = biVar4.ts().channelId;
                    biVar5 = this.amF.aiB;
                    messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(context, j, biVar5.ts().mCurrentPage)));
                }
            }
        }
    }
}
