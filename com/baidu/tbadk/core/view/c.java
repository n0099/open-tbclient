package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ ClickableHeaderImageView aag;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ClickableHeaderImageView clickableHeaderImageView) {
        this.aag = clickableHeaderImageView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ax axVar;
        ax axVar2;
        ax axVar3;
        ax axVar4;
        Context context;
        ax axVar5;
        ax axVar6;
        ax axVar7;
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        axVar = this.aag.aab;
        if (axVar != null) {
            axVar2 = this.aag.aab;
            if (axVar2.getAuthor() != null) {
                axVar3 = this.aag.aab;
                if (!StringUtils.isNull(axVar3.getAuthor().getName_show())) {
                    axVar4 = this.aag.aab;
                    if (!StringUtils.isNull(axVar4.getAuthor().getUserId())) {
                        MessageManager messageManager = MessageManager.getInstance();
                        context = this.aag.mContext;
                        axVar5 = this.aag.aab;
                        String userId = axVar5.getAuthor().getUserId();
                        axVar6 = this.aag.aab;
                        String name_show = axVar6.getAuthor().getName_show();
                        axVar7 = this.aag.aab;
                        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, userId, name_show, axVar7.qP(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                        onClickListener = this.aag.aac;
                        if (onClickListener != null) {
                            onClickListener2 = this.aag.aac;
                            onClickListener2.onClick(view);
                        }
                    }
                }
            }
        }
    }
}
