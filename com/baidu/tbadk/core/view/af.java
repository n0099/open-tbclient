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
class af implements View.OnClickListener {
    final /* synthetic */ UserIconLayout ahP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(UserIconLayout userIconLayout) {
        this.ahP = userIconLayout;
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
        ahVar = this.ahP.afg;
        if (ahVar != null) {
            ahVar2 = this.ahP.afg;
            if (ahVar2.getAuthor() != null) {
                ahVar3 = this.ahP.afg;
                if (!StringUtils.isNull(ahVar3.getAuthor().getName_show())) {
                    ahVar4 = this.ahP.afg;
                    if (!StringUtils.isNull(ahVar4.getAuthor().getUserId())) {
                        ahVar5 = this.ahP.afg;
                        if (ahVar5.tn() != null) {
                            MessageManager messageManager = MessageManager.getInstance();
                            context = this.ahP.mContext;
                            ahVar6 = this.ahP.afg;
                            String userId = ahVar6.getAuthor().getUserId();
                            ahVar7 = this.ahP.afg;
                            String name_show = ahVar7.getAuthor().getName_show();
                            ahVar8 = this.ahP.afg;
                            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, userId, name_show, ahVar8.tn(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                            onClickListener = this.ahP.ahL;
                            if (onClickListener != null) {
                                onClickListener2 = this.ahP.ahL;
                                onClickListener2.onClick(view);
                            }
                        }
                    }
                }
            }
        }
    }
}
