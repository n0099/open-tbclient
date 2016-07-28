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
/* loaded from: classes.dex */
class ao implements View.OnClickListener {
    final /* synthetic */ UserIconLayout afc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(UserIconLayout userIconLayout) {
        this.afc = userIconLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        be beVar;
        be beVar2;
        be beVar3;
        be beVar4;
        be beVar5;
        Context context;
        be beVar6;
        be beVar7;
        be beVar8;
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        beVar = this.afc.abb;
        if (beVar != null) {
            beVar2 = this.afc.abb;
            if (beVar2.getAuthor() != null) {
                beVar3 = this.afc.abb;
                if (!StringUtils.isNull(beVar3.getAuthor().getName_show())) {
                    beVar4 = this.afc.abb;
                    if (!StringUtils.isNull(beVar4.getAuthor().getUserId())) {
                        beVar5 = this.afc.abb;
                        if (beVar5.getForum_name() != null) {
                            MessageManager messageManager = MessageManager.getInstance();
                            context = this.afc.mContext;
                            beVar6 = this.afc.abb;
                            String userId = beVar6.getAuthor().getUserId();
                            beVar7 = this.afc.abb;
                            String name_show = beVar7.getAuthor().getName_show();
                            beVar8 = this.afc.abb;
                            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, userId, name_show, beVar8.getForum_name(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                            onClickListener = this.afc.aeW;
                            if (onClickListener != null) {
                                onClickListener2 = this.afc.aeW;
                                onClickListener2.onClick(view);
                            }
                        }
                    }
                }
            }
        }
    }
}
