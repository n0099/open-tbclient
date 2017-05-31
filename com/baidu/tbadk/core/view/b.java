package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ ClickableHeaderImageView ahP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ClickableHeaderImageView clickableHeaderImageView) {
        this.ahP = clickableHeaderImageView;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        bl blVar;
        bl blVar2;
        bl blVar3;
        bl blVar4;
        bl blVar5;
        bl blVar6;
        bl blVar7;
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        bl blVar8;
        bl blVar9;
        bl blVar10;
        if (this.ahP.ahO == null || !this.ahP.ahO.s(view)) {
            blVar = this.ahP.ahM;
            if (blVar != null) {
                blVar2 = this.ahP.ahM;
                if (blVar2.getAuthor() != null) {
                    blVar3 = this.ahP.ahM;
                    if (!StringUtils.isNull(blVar3.getAuthor().getName_show())) {
                        blVar4 = this.ahP.ahM;
                        if (!StringUtils.isNull(blVar4.getAuthor().getUserId())) {
                            blVar5 = this.ahP.ahM;
                            long c = com.baidu.adp.lib.g.b.c(blVar5.getAuthor().getUserId(), 0L);
                            boolean z = c == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                            blVar6 = this.ahP.ahM;
                            if (blVar6.sx() != null) {
                                blVar8 = this.ahP.ahM;
                                if (blVar8.sx().channelId > 0) {
                                    MessageManager messageManager = MessageManager.getInstance();
                                    Context context = this.ahP.getContext();
                                    blVar9 = this.ahP.ahM;
                                    long j = blVar9.sx().channelId;
                                    blVar10 = this.ahP.ahM;
                                    messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(context, j, blVar10.sx().mCurrentPage)));
                                    onClickListener = this.ahP.ahN;
                                    if (onClickListener == null) {
                                        onClickListener2 = this.ahP.ahN;
                                        onClickListener2.onClick(view);
                                        return;
                                    }
                                    return;
                                }
                            }
                            MessageManager messageManager2 = MessageManager.getInstance();
                            PersonPolymericActivityConfig personPolymericActivityConfig = new PersonPolymericActivityConfig(this.ahP.getContext());
                            blVar7 = this.ahP.ahM;
                            messageManager2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, personPolymericActivityConfig.createNormalConfig(c, z, blVar7.getAuthor().isBigV())));
                            onClickListener = this.ahP.ahN;
                            if (onClickListener == null) {
                            }
                        }
                    }
                }
            }
        }
    }
}
