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
/* loaded from: classes.dex */
class ao implements View.OnClickListener {
    final /* synthetic */ UserIconLayout adQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(UserIconLayout userIconLayout) {
        this.adQ = userIconLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ax axVar;
        ax axVar2;
        ax axVar3;
        ax axVar4;
        ax axVar5;
        Context context;
        ax axVar6;
        ax axVar7;
        ax axVar8;
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        axVar = this.adQ.aab;
        if (axVar != null) {
            axVar2 = this.adQ.aab;
            if (axVar2.getAuthor() != null) {
                axVar3 = this.adQ.aab;
                if (!StringUtils.isNull(axVar3.getAuthor().getName_show())) {
                    axVar4 = this.adQ.aab;
                    if (!StringUtils.isNull(axVar4.getAuthor().getUserId())) {
                        axVar5 = this.adQ.aab;
                        if (axVar5.qQ() != null) {
                            MessageManager messageManager = MessageManager.getInstance();
                            context = this.adQ.mContext;
                            axVar6 = this.adQ.aab;
                            String userId = axVar6.getAuthor().getUserId();
                            axVar7 = this.adQ.aab;
                            String name_show = axVar7.getAuthor().getName_show();
                            axVar8 = this.adQ.aab;
                            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, userId, name_show, axVar8.qQ(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                            onClickListener = this.adQ.adK;
                            if (onClickListener != null) {
                                onClickListener2 = this.adQ.adK;
                                onClickListener2.onClick(view);
                            }
                        }
                    }
                }
            }
        }
    }
}
