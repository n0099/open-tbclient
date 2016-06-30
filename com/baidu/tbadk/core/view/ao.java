package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class ao implements View.OnClickListener {
    final /* synthetic */ UserIconLayout aeo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(UserIconLayout userIconLayout) {
        this.aeo = userIconLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        az azVar;
        az azVar2;
        az azVar3;
        az azVar4;
        az azVar5;
        Context context;
        az azVar6;
        az azVar7;
        az azVar8;
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        azVar = this.aeo.aas;
        if (azVar != null) {
            azVar2 = this.aeo.aas;
            if (azVar2.getAuthor() != null) {
                azVar3 = this.aeo.aas;
                if (!StringUtils.isNull(azVar3.getAuthor().getName_show())) {
                    azVar4 = this.aeo.aas;
                    if (!StringUtils.isNull(azVar4.getAuthor().getUserId())) {
                        azVar5 = this.aeo.aas;
                        if (azVar5.getForum_name() != null) {
                            MessageManager messageManager = MessageManager.getInstance();
                            context = this.aeo.mContext;
                            azVar6 = this.aeo.aas;
                            String userId = azVar6.getAuthor().getUserId();
                            azVar7 = this.aeo.aas;
                            String name_show = azVar7.getAuthor().getName_show();
                            azVar8 = this.aeo.aas;
                            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, userId, name_show, azVar8.getForum_name(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                            onClickListener = this.aeo.aei;
                            if (onClickListener != null) {
                                onClickListener2 = this.aeo.aei;
                                onClickListener2.onClick(view);
                            }
                        }
                    }
                }
            }
        }
    }
}
