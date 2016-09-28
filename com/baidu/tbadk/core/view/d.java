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
class d implements View.OnClickListener {
    final /* synthetic */ HeadPendantClickableView aer;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(HeadPendantClickableView headPendantClickableView) {
        this.aer = headPendantClickableView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bi biVar;
        bi biVar2;
        bi biVar3;
        bi biVar4;
        Context context;
        bi biVar5;
        bi biVar6;
        bi biVar7;
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        biVar = this.aer.adW;
        if (biVar != null) {
            biVar2 = this.aer.adW;
            if (biVar2.getAuthor() != null) {
                biVar3 = this.aer.adW;
                if (!StringUtils.isNull(biVar3.getAuthor().getName_show())) {
                    biVar4 = this.aer.adW;
                    if (!StringUtils.isNull(biVar4.getAuthor().getUserId())) {
                        MessageManager messageManager = MessageManager.getInstance();
                        context = this.aer.mContext;
                        biVar5 = this.aer.adW;
                        String userId = biVar5.getAuthor().getUserId();
                        biVar6 = this.aer.adW;
                        String name_show = biVar6.getAuthor().getName_show();
                        biVar7 = this.aer.adW;
                        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, userId, name_show, biVar7.getForum_name(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                        onClickListener = this.aer.adX;
                        if (onClickListener != null) {
                            onClickListener2 = this.aer.adX;
                            onClickListener2.onClick(view);
                        }
                    }
                }
            }
        }
    }
}
