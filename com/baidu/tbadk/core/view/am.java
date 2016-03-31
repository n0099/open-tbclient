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
class am implements View.OnClickListener {
    final /* synthetic */ UserIconLayout ahU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(UserIconLayout userIconLayout) {
        this.ahU = userIconLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.as asVar;
        com.baidu.tbadk.core.data.as asVar2;
        com.baidu.tbadk.core.data.as asVar3;
        com.baidu.tbadk.core.data.as asVar4;
        com.baidu.tbadk.core.data.as asVar5;
        Context context;
        com.baidu.tbadk.core.data.as asVar6;
        com.baidu.tbadk.core.data.as asVar7;
        com.baidu.tbadk.core.data.as asVar8;
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        asVar = this.ahU.aeC;
        if (asVar != null) {
            asVar2 = this.ahU.aeC;
            if (asVar2.getAuthor() != null) {
                asVar3 = this.ahU.aeC;
                if (!StringUtils.isNull(asVar3.getAuthor().getName_show())) {
                    asVar4 = this.ahU.aeC;
                    if (!StringUtils.isNull(asVar4.getAuthor().getUserId())) {
                        asVar5 = this.ahU.aeC;
                        if (asVar5.tr() != null) {
                            MessageManager messageManager = MessageManager.getInstance();
                            context = this.ahU.mContext;
                            asVar6 = this.ahU.aeC;
                            String userId = asVar6.getAuthor().getUserId();
                            asVar7 = this.ahU.aeC;
                            String name_show = asVar7.getAuthor().getName_show();
                            asVar8 = this.ahU.aeC;
                            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, userId, name_show, asVar8.tr(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                            onClickListener = this.ahU.ahQ;
                            if (onClickListener != null) {
                                onClickListener2 = this.ahU.ahQ;
                                onClickListener2.onClick(view);
                            }
                        }
                    }
                }
            }
        }
    }
}
