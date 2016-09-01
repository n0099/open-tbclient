package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ ClickableHeaderImageView adU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ClickableHeaderImageView clickableHeaderImageView) {
        this.adU = clickableHeaderImageView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.c.a aVar;
        bg bgVar;
        bg bgVar2;
        bg bgVar3;
        bg bgVar4;
        bg bgVar5;
        Context context;
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        com.baidu.tbadk.c.a aVar2;
        aVar = this.adU.adT;
        if (aVar != null) {
            aVar2 = this.adU.adT;
            if (aVar2.w(view)) {
                return;
            }
        }
        bgVar = this.adU.adL;
        if (bgVar != null) {
            bgVar2 = this.adU.adL;
            if (bgVar2.getAuthor() != null) {
                bgVar3 = this.adU.adL;
                if (!StringUtils.isNull(bgVar3.getAuthor().getName_show())) {
                    bgVar4 = this.adU.adL;
                    if (!StringUtils.isNull(bgVar4.getAuthor().getUserId())) {
                        bgVar5 = this.adU.adL;
                        long c = com.baidu.adp.lib.h.b.c(bgVar5.getAuthor().getUserId(), 0L);
                        boolean z = c == com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                        MessageManager messageManager = MessageManager.getInstance();
                        context = this.adU.mContext;
                        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(context).createNormalConfig(c, z)));
                        onClickListener = this.adU.adM;
                        if (onClickListener != null) {
                            onClickListener2 = this.adU.adM;
                            onClickListener2.onClick(view);
                        }
                    }
                }
            }
        }
    }
}
