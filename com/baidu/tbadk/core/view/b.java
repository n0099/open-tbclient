package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ ClickableHeaderImageView aie;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ClickableHeaderImageView clickableHeaderImageView) {
        this.aie = clickableHeaderImageView;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        com.baidu.tbadk.d.a aVar;
        bk bkVar;
        bk bkVar2;
        bk bkVar3;
        bk bkVar4;
        bk bkVar5;
        bk bkVar6;
        Context context;
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        bk bkVar7;
        Context context2;
        bk bkVar8;
        bk bkVar9;
        com.baidu.tbadk.d.a aVar2;
        aVar = this.aie.aid;
        if (aVar != null) {
            aVar2 = this.aie.aid;
            if (aVar2.s(view)) {
                return;
            }
        }
        bkVar = this.aie.ahV;
        if (bkVar != null) {
            bkVar2 = this.aie.ahV;
            if (bkVar2.getAuthor() != null) {
                bkVar3 = this.aie.ahV;
                if (!StringUtils.isNull(bkVar3.getAuthor().getName_show())) {
                    bkVar4 = this.aie.ahV;
                    if (!StringUtils.isNull(bkVar4.getAuthor().getUserId())) {
                        bkVar5 = this.aie.ahV;
                        long c = com.baidu.adp.lib.g.b.c(bkVar5.getAuthor().getUserId(), 0L);
                        boolean z = c == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                        bkVar6 = this.aie.ahV;
                        if (bkVar6.sC() != null) {
                            bkVar7 = this.aie.ahV;
                            if (bkVar7.sC().channelId > 0) {
                                MessageManager messageManager = MessageManager.getInstance();
                                context2 = this.aie.mContext;
                                bkVar8 = this.aie.ahV;
                                long j = bkVar8.sC().channelId;
                                bkVar9 = this.aie.ahV;
                                messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(context2, j, bkVar9.sC().mCurrentPage)));
                                onClickListener = this.aie.ahW;
                                if (onClickListener == null) {
                                    onClickListener2 = this.aie.ahW;
                                    onClickListener2.onClick(view);
                                    return;
                                }
                                return;
                            }
                        }
                        MessageManager messageManager2 = MessageManager.getInstance();
                        context = this.aie.mContext;
                        messageManager2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(context).createNormalConfig(c, z)));
                        onClickListener = this.aie.ahW;
                        if (onClickListener == null) {
                        }
                    }
                }
            }
        }
    }
}
