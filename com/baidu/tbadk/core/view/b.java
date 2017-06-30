package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ ClickableHeaderImageView aix;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ClickableHeaderImageView clickableHeaderImageView) {
        this.aix = clickableHeaderImageView;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        bm bmVar;
        bm bmVar2;
        bm bmVar3;
        bm bmVar4;
        bm bmVar5;
        bm bmVar6;
        bm bmVar7;
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        bm bmVar8;
        bm bmVar9;
        bm bmVar10;
        if (this.aix.aiw == null || !this.aix.aiw.s(view)) {
            bmVar = this.aix.aiu;
            if (bmVar != null) {
                bmVar2 = this.aix.aiu;
                if (bmVar2.getAuthor() != null) {
                    bmVar3 = this.aix.aiu;
                    if (!StringUtils.isNull(bmVar3.getAuthor().getName_show())) {
                        bmVar4 = this.aix.aiu;
                        if (!StringUtils.isNull(bmVar4.getAuthor().getUserId())) {
                            bmVar5 = this.aix.aiu;
                            long c = com.baidu.adp.lib.g.b.c(bmVar5.getAuthor().getUserId(), 0L);
                            boolean z = c == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                            bmVar6 = this.aix.aiu;
                            if (bmVar6.sv() != null) {
                                bmVar8 = this.aix.aiu;
                                if (bmVar8.sv().channelId > 0) {
                                    MessageManager messageManager = MessageManager.getInstance();
                                    Context context = this.aix.getContext();
                                    bmVar9 = this.aix.aiu;
                                    long j = bmVar9.sv().channelId;
                                    bmVar10 = this.aix.aiu;
                                    messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(context, j, bmVar10.sv().mCurrentPage)));
                                    onClickListener = this.aix.aiv;
                                    if (onClickListener == null) {
                                        onClickListener2 = this.aix.aiv;
                                        onClickListener2.onClick(view);
                                        return;
                                    }
                                    return;
                                }
                            }
                            MessageManager messageManager2 = MessageManager.getInstance();
                            PersonPolymericActivityConfig personPolymericActivityConfig = new PersonPolymericActivityConfig(this.aix.getContext());
                            bmVar7 = this.aix.aiu;
                            messageManager2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, personPolymericActivityConfig.createNormalConfig(c, z, bmVar7.getAuthor().isBigV())));
                            onClickListener = this.aix.aiv;
                            if (onClickListener == null) {
                            }
                        }
                    }
                }
            }
        }
    }
}
