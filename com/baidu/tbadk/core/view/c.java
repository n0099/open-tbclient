package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ ClickableHeaderImageView aeH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ClickableHeaderImageView clickableHeaderImageView) {
        this.aeH = clickableHeaderImageView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.as asVar;
        com.baidu.tbadk.core.data.as asVar2;
        com.baidu.tbadk.core.data.as asVar3;
        com.baidu.tbadk.core.data.as asVar4;
        Context context;
        com.baidu.tbadk.core.data.as asVar5;
        com.baidu.tbadk.core.data.as asVar6;
        com.baidu.tbadk.core.data.as asVar7;
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        asVar = this.aeH.aeC;
        if (asVar != null) {
            asVar2 = this.aeH.aeC;
            if (asVar2.getAuthor() != null) {
                asVar3 = this.aeH.aeC;
                if (!StringUtils.isNull(asVar3.getAuthor().getName_show())) {
                    asVar4 = this.aeH.aeC;
                    if (!StringUtils.isNull(asVar4.getAuthor().getUserId())) {
                        MessageManager messageManager = MessageManager.getInstance();
                        context = this.aeH.mContext;
                        asVar5 = this.aeH.aeC;
                        String userId = asVar5.getAuthor().getUserId();
                        asVar6 = this.aeH.aeC;
                        String name_show = asVar6.getAuthor().getName_show();
                        asVar7 = this.aeH.aeC;
                        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, userId, name_show, asVar7.tr(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                        onClickListener = this.aeH.aeD;
                        if (onClickListener != null) {
                            onClickListener2 = this.aeH.aeD;
                            onClickListener2.onClick(view);
                        }
                    }
                }
            }
        }
    }
}
