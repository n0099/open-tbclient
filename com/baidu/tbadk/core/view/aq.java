package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class aq implements View.OnClickListener {
    final /* synthetic */ UserIconLayout ahH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(UserIconLayout userIconLayout) {
        this.ahH = userIconLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bg bgVar;
        bg bgVar2;
        bg bgVar3;
        bg bgVar4;
        bg bgVar5;
        Context context;
        bg bgVar6;
        bg bgVar7;
        bg bgVar8;
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        bgVar = this.ahH.adN;
        if (bgVar != null) {
            bgVar2 = this.ahH.adN;
            if (bgVar2.getAuthor() != null) {
                bgVar3 = this.ahH.adN;
                if (!StringUtils.isNull(bgVar3.getAuthor().getName_show())) {
                    bgVar4 = this.ahH.adN;
                    if (!StringUtils.isNull(bgVar4.getAuthor().getUserId())) {
                        bgVar5 = this.ahH.adN;
                        if (bgVar5.rK() != null) {
                            MessageManager messageManager = MessageManager.getInstance();
                            context = this.ahH.mContext;
                            bgVar6 = this.ahH.adN;
                            String userId = bgVar6.getAuthor().getUserId();
                            bgVar7 = this.ahH.adN;
                            String name_show = bgVar7.getAuthor().getName_show();
                            bgVar8 = this.ahH.adN;
                            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, userId, name_show, bgVar8.rK(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                            onClickListener = this.ahH.ahA;
                            if (onClickListener != null) {
                                onClickListener2 = this.ahH.ahA;
                                onClickListener2.onClick(view);
                            }
                        }
                    }
                }
            }
        }
    }
}
