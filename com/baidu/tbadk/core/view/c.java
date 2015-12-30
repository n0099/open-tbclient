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
    final /* synthetic */ ClickableHeaderImageView aeH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ClickableHeaderImageView clickableHeaderImageView) {
        this.aeH = clickableHeaderImageView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.z zVar;
        com.baidu.tbadk.core.data.z zVar2;
        com.baidu.tbadk.core.data.z zVar3;
        com.baidu.tbadk.core.data.z zVar4;
        com.baidu.tbadk.core.data.z zVar5;
        Context context;
        com.baidu.tbadk.core.data.z zVar6;
        com.baidu.tbadk.core.data.z zVar7;
        com.baidu.tbadk.core.data.z zVar8;
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        zVar = this.aeH.aeF;
        if (zVar != null) {
            zVar2 = this.aeH.aeF;
            if (zVar2.getAuthor() != null) {
                zVar3 = this.aeH.aeF;
                if (!StringUtils.isNull(zVar3.getAuthor().getName_show())) {
                    zVar4 = this.aeH.aeF;
                    if (!StringUtils.isNull(zVar4.getAuthor().getUserId())) {
                        zVar5 = this.aeH.aeF;
                        if (zVar5.sv() != null) {
                            MessageManager messageManager = MessageManager.getInstance();
                            context = this.aeH.mContext;
                            zVar6 = this.aeH.aeF;
                            String userId = zVar6.getAuthor().getUserId();
                            zVar7 = this.aeH.aeF;
                            String name_show = zVar7.getAuthor().getName_show();
                            zVar8 = this.aeH.aeF;
                            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, userId, name_show, zVar8.sv(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                            onClickListener = this.aeH.aeG;
                            if (onClickListener != null) {
                                onClickListener2 = this.aeH.aeG;
                                onClickListener2.onClick(view);
                            }
                        }
                    }
                }
            }
        }
    }
}
