package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ ClickableHeaderImageView afi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ClickableHeaderImageView clickableHeaderImageView) {
        this.afi = clickableHeaderImageView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.ah ahVar;
        com.baidu.tbadk.core.data.ah ahVar2;
        com.baidu.tbadk.core.data.ah ahVar3;
        com.baidu.tbadk.core.data.ah ahVar4;
        com.baidu.tbadk.core.data.ah ahVar5;
        Context context;
        com.baidu.tbadk.core.data.ah ahVar6;
        com.baidu.tbadk.core.data.ah ahVar7;
        com.baidu.tbadk.core.data.ah ahVar8;
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        ahVar = this.afi.afg;
        if (ahVar != null) {
            ahVar2 = this.afi.afg;
            if (ahVar2.getAuthor() != null) {
                ahVar3 = this.afi.afg;
                if (!StringUtils.isNull(ahVar3.getAuthor().getName_show())) {
                    ahVar4 = this.afi.afg;
                    if (!StringUtils.isNull(ahVar4.getAuthor().getUserId())) {
                        ahVar5 = this.afi.afg;
                        if (ahVar5.tn() != null) {
                            MessageManager messageManager = MessageManager.getInstance();
                            context = this.afi.mContext;
                            ahVar6 = this.afi.afg;
                            String userId = ahVar6.getAuthor().getUserId();
                            ahVar7 = this.afi.afg;
                            String name_show = ahVar7.getAuthor().getName_show();
                            ahVar8 = this.afi.afg;
                            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, userId, name_show, ahVar8.tn(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                            onClickListener = this.afi.afh;
                            if (onClickListener != null) {
                                onClickListener2 = this.afi.afh;
                                onClickListener2.onClick(view);
                            }
                        }
                    }
                }
            }
        }
    }
}
