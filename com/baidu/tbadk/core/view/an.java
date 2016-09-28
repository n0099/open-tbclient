package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class an implements View.OnClickListener {
    final /* synthetic */ UserIconLayout ahF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(UserIconLayout userIconLayout) {
        this.ahF = userIconLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bi biVar;
        bi biVar2;
        bi biVar3;
        bi biVar4;
        bi biVar5;
        Context context;
        bi biVar6;
        bi biVar7;
        bi biVar8;
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        biVar = this.ahF.adW;
        if (biVar != null) {
            biVar2 = this.ahF.adW;
            if (biVar2.getAuthor() != null) {
                biVar3 = this.ahF.adW;
                if (!StringUtils.isNull(biVar3.getAuthor().getName_show())) {
                    biVar4 = this.ahF.adW;
                    if (!StringUtils.isNull(biVar4.getAuthor().getUserId())) {
                        biVar5 = this.ahF.adW;
                        if (biVar5.getForum_name() != null) {
                            MessageManager messageManager = MessageManager.getInstance();
                            context = this.ahF.mContext;
                            biVar6 = this.ahF.adW;
                            String userId = biVar6.getAuthor().getUserId();
                            biVar7 = this.ahF.adW;
                            String name_show = biVar7.getAuthor().getName_show();
                            biVar8 = this.ahF.adW;
                            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, userId, name_show, biVar8.getForum_name(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                            onClickListener = this.ahF.ahz;
                            if (onClickListener != null) {
                                onClickListener2 = this.ahF.ahz;
                                onClickListener2.onClick(view);
                            }
                        }
                    }
                }
            }
        }
    }
}
