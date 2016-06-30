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
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ ClickableHeaderImageView aaz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ClickableHeaderImageView clickableHeaderImageView) {
        this.aaz = clickableHeaderImageView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        az azVar;
        az azVar2;
        az azVar3;
        az azVar4;
        Context context;
        az azVar5;
        az azVar6;
        az azVar7;
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        azVar = this.aaz.aas;
        if (azVar != null) {
            azVar2 = this.aaz.aas;
            if (azVar2.getAuthor() != null) {
                azVar3 = this.aaz.aas;
                if (!StringUtils.isNull(azVar3.getAuthor().getName_show())) {
                    azVar4 = this.aaz.aas;
                    if (!StringUtils.isNull(azVar4.getAuthor().getUserId())) {
                        MessageManager messageManager = MessageManager.getInstance();
                        context = this.aaz.mContext;
                        azVar5 = this.aaz.aas;
                        String userId = azVar5.getAuthor().getUserId();
                        azVar6 = this.aaz.aas;
                        String name_show = azVar6.getAuthor().getName_show();
                        azVar7 = this.aaz.aas;
                        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, userId, name_show, azVar7.getForum_name(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                        onClickListener = this.aaz.aat;
                        if (onClickListener != null) {
                            onClickListener2 = this.aaz.aat;
                            onClickListener2.onClick(view);
                        }
                    }
                }
            }
        }
    }
}
