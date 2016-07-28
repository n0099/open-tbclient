package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ ClickableHeaderImageView abj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ClickableHeaderImageView clickableHeaderImageView) {
        this.abj = clickableHeaderImageView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        be beVar;
        be beVar2;
        be beVar3;
        be beVar4;
        Context context;
        be beVar5;
        be beVar6;
        be beVar7;
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        beVar = this.abj.abb;
        if (beVar != null) {
            beVar2 = this.abj.abb;
            if (beVar2.getAuthor() != null) {
                beVar3 = this.abj.abb;
                if (!StringUtils.isNull(beVar3.getAuthor().getName_show())) {
                    beVar4 = this.abj.abb;
                    if (!StringUtils.isNull(beVar4.getAuthor().getUserId())) {
                        MessageManager messageManager = MessageManager.getInstance();
                        context = this.abj.mContext;
                        beVar5 = this.abj.abb;
                        String userId = beVar5.getAuthor().getUserId();
                        beVar6 = this.abj.abb;
                        String name_show = beVar6.getAuthor().getName_show();
                        beVar7 = this.abj.abb;
                        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, userId, name_show, beVar7.getForum_name(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                        onClickListener = this.abj.abc;
                        if (onClickListener != null) {
                            onClickListener2 = this.abj.abc;
                            onClickListener2.onClick(view);
                        }
                    }
                }
            }
        }
    }
}
