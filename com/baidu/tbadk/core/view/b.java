package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ ClickableHeaderImageView aeD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ClickableHeaderImageView clickableHeaderImageView) {
        this.aeD = clickableHeaderImageView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.c.a aVar;
        bk bkVar;
        bk bkVar2;
        bk bkVar3;
        bk bkVar4;
        bk bkVar5;
        Context context;
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        com.baidu.tbadk.c.a aVar2;
        aVar = this.aeD.aeC;
        if (aVar != null) {
            aVar2 = this.aeD.aeC;
            if (aVar2.w(view)) {
                return;
            }
        }
        bkVar = this.aeD.aeu;
        if (bkVar != null) {
            bkVar2 = this.aeD.aeu;
            if (bkVar2.getAuthor() != null) {
                bkVar3 = this.aeD.aeu;
                if (!StringUtils.isNull(bkVar3.getAuthor().getName_show())) {
                    bkVar4 = this.aeD.aeu;
                    if (!StringUtils.isNull(bkVar4.getAuthor().getUserId())) {
                        bkVar5 = this.aeD.aeu;
                        long c = com.baidu.adp.lib.h.b.c(bkVar5.getAuthor().getUserId(), 0L);
                        boolean z = c == com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                        MessageManager messageManager = MessageManager.getInstance();
                        context = this.aeD.mContext;
                        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(context).createNormalConfig(c, z)));
                        onClickListener = this.aeD.aev;
                        if (onClickListener != null) {
                            onClickListener2 = this.aeD.aev;
                            onClickListener2.onClick(view);
                        }
                    }
                }
            }
        }
    }
}
