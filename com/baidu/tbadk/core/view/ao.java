package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class ao implements View.OnClickListener {
    final /* synthetic */ UserIconLayout aig;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(UserIconLayout userIconLayout) {
        this.aig = userIconLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bk bkVar;
        bk bkVar2;
        bk bkVar3;
        bk bkVar4;
        bk bkVar5;
        Context context;
        bk bkVar6;
        bk bkVar7;
        bk bkVar8;
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        bkVar = this.aig.aeu;
        if (bkVar != null) {
            bkVar2 = this.aig.aeu;
            if (bkVar2.getAuthor() != null) {
                bkVar3 = this.aig.aeu;
                if (!StringUtils.isNull(bkVar3.getAuthor().getName_show())) {
                    bkVar4 = this.aig.aeu;
                    if (!StringUtils.isNull(bkVar4.getAuthor().getUserId())) {
                        bkVar5 = this.aig.aeu;
                        if (bkVar5.getForum_name() != null) {
                            MessageManager messageManager = MessageManager.getInstance();
                            context = this.aig.mContext;
                            bkVar6 = this.aig.aeu;
                            String userId = bkVar6.getAuthor().getUserId();
                            bkVar7 = this.aig.aeu;
                            String name_show = bkVar7.getAuthor().getName_show();
                            bkVar8 = this.aig.aeu;
                            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, userId, name_show, bkVar8.getForum_name(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                            onClickListener = this.aig.ahZ;
                            if (onClickListener != null) {
                                onClickListener2 = this.aig.ahZ;
                                onClickListener2.onClick(view);
                            }
                        }
                    }
                }
            }
        }
    }
}
