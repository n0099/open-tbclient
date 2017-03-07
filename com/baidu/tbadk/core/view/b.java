package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ ClickableHeaderImageView aiw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ClickableHeaderImageView clickableHeaderImageView) {
        this.aiw = clickableHeaderImageView;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        com.baidu.tbadk.c.a aVar;
        bj bjVar;
        bj bjVar2;
        bj bjVar3;
        bj bjVar4;
        bj bjVar5;
        bj bjVar6;
        Context context;
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        bj bjVar7;
        Context context2;
        bj bjVar8;
        bj bjVar9;
        com.baidu.tbadk.c.a aVar2;
        aVar = this.aiw.aiv;
        if (aVar != null) {
            aVar2 = this.aiw.aiv;
            if (aVar2.s(view)) {
                return;
            }
        }
        bjVar = this.aiw.ain;
        if (bjVar != null) {
            bjVar2 = this.aiw.ain;
            if (bjVar2.getAuthor() != null) {
                bjVar3 = this.aiw.ain;
                if (!StringUtils.isNull(bjVar3.getAuthor().getName_show())) {
                    bjVar4 = this.aiw.ain;
                    if (!StringUtils.isNull(bjVar4.getAuthor().getUserId())) {
                        bjVar5 = this.aiw.ain;
                        long c = com.baidu.adp.lib.g.b.c(bjVar5.getAuthor().getUserId(), 0L);
                        boolean z = c == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                        bjVar6 = this.aiw.ain;
                        if (bjVar6.sU() != null) {
                            bjVar7 = this.aiw.ain;
                            if (bjVar7.sU().channelId > 0) {
                                MessageManager messageManager = MessageManager.getInstance();
                                context2 = this.aiw.mContext;
                                bjVar8 = this.aiw.ain;
                                long j = bjVar8.sU().channelId;
                                bjVar9 = this.aiw.ain;
                                messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(context2, j, bjVar9.sU().mCurrentPage)));
                                onClickListener = this.aiw.aio;
                                if (onClickListener == null) {
                                    onClickListener2 = this.aiw.aio;
                                    onClickListener2.onClick(view);
                                    return;
                                }
                                return;
                            }
                        }
                        MessageManager messageManager2 = MessageManager.getInstance();
                        context = this.aiw.mContext;
                        messageManager2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(context).createNormalConfig(c, z)));
                        onClickListener = this.aiw.aio;
                        if (onClickListener == null) {
                        }
                    }
                }
            }
        }
    }
}
