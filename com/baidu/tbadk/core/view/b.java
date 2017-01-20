package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ ClickableHeaderImageView adh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ClickableHeaderImageView clickableHeaderImageView) {
        this.adh = clickableHeaderImageView;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        com.baidu.tbadk.c.a aVar;
        bh bhVar;
        bh bhVar2;
        bh bhVar3;
        bh bhVar4;
        bh bhVar5;
        bh bhVar6;
        Context context;
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        bh bhVar7;
        Context context2;
        bh bhVar8;
        bh bhVar9;
        com.baidu.tbadk.c.a aVar2;
        aVar = this.adh.adg;
        if (aVar != null) {
            aVar2 = this.adh.adg;
            if (aVar2.u(view)) {
                return;
            }
        }
        bhVar = this.adh.acX;
        if (bhVar != null) {
            bhVar2 = this.adh.acX;
            if (bhVar2.getAuthor() != null) {
                bhVar3 = this.adh.acX;
                if (!StringUtils.isNull(bhVar3.getAuthor().getName_show())) {
                    bhVar4 = this.adh.acX;
                    if (!StringUtils.isNull(bhVar4.getAuthor().getUserId())) {
                        bhVar5 = this.adh.acX;
                        long c = com.baidu.adp.lib.g.b.c(bhVar5.getAuthor().getUserId(), 0L);
                        boolean z = c == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                        bhVar6 = this.adh.acX;
                        if (bhVar6.sz() != null) {
                            bhVar7 = this.adh.acX;
                            if (bhVar7.sz().channelId > 0) {
                                MessageManager messageManager = MessageManager.getInstance();
                                context2 = this.adh.mContext;
                                bhVar8 = this.adh.acX;
                                long j = bhVar8.sz().channelId;
                                bhVar9 = this.adh.acX;
                                messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(context2, j, bhVar9.sz().mCurrentPage)));
                                onClickListener = this.adh.acY;
                                if (onClickListener == null) {
                                    onClickListener2 = this.adh.acY;
                                    onClickListener2.onClick(view);
                                    return;
                                }
                                return;
                            }
                        }
                        MessageManager messageManager2 = MessageManager.getInstance();
                        context = this.adh.mContext;
                        messageManager2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(context).createNormalConfig(c, z)));
                        onClickListener = this.adh.acY;
                        if (onClickListener == null) {
                        }
                    }
                }
            }
        }
    }
}
