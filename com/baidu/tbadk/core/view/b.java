package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ ClickableHeaderImageView aiL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ClickableHeaderImageView clickableHeaderImageView) {
        this.aiL = clickableHeaderImageView;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        com.baidu.tbadk.d.a aVar;
        bi biVar;
        bi biVar2;
        bi biVar3;
        bi biVar4;
        bi biVar5;
        bi biVar6;
        Context context;
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        bi biVar7;
        Context context2;
        bi biVar8;
        bi biVar9;
        com.baidu.tbadk.d.a aVar2;
        aVar = this.aiL.aiK;
        if (aVar != null) {
            aVar2 = this.aiL.aiK;
            if (aVar2.s(view)) {
                return;
            }
        }
        biVar = this.aiL.aiC;
        if (biVar != null) {
            biVar2 = this.aiL.aiC;
            if (biVar2.getAuthor() != null) {
                biVar3 = this.aiL.aiC;
                if (!StringUtils.isNull(biVar3.getAuthor().getName_show())) {
                    biVar4 = this.aiL.aiC;
                    if (!StringUtils.isNull(biVar4.getAuthor().getUserId())) {
                        biVar5 = this.aiL.aiC;
                        long c = com.baidu.adp.lib.g.b.c(biVar5.getAuthor().getUserId(), 0L);
                        boolean z = c == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                        biVar6 = this.aiL.aiC;
                        if (biVar6.ts() != null) {
                            biVar7 = this.aiL.aiC;
                            if (biVar7.ts().channelId > 0) {
                                MessageManager messageManager = MessageManager.getInstance();
                                context2 = this.aiL.mContext;
                                biVar8 = this.aiL.aiC;
                                long j = biVar8.ts().channelId;
                                biVar9 = this.aiL.aiC;
                                messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(context2, j, biVar9.ts().mCurrentPage)));
                                onClickListener = this.aiL.aiD;
                                if (onClickListener == null) {
                                    onClickListener2 = this.aiL.aiD;
                                    onClickListener2.onClick(view);
                                    return;
                                }
                                return;
                            }
                        }
                        MessageManager messageManager2 = MessageManager.getInstance();
                        context = this.aiL.mContext;
                        messageManager2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(context).createNormalConfig(c, z)));
                        onClickListener = this.aiL.aiD;
                        if (onClickListener == null) {
                        }
                    }
                }
            }
        }
    }
}
