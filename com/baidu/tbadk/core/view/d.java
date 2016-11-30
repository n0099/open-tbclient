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
class d implements View.OnClickListener {
    final /* synthetic */ HeadPendantClickableView aeP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(HeadPendantClickableView headPendantClickableView) {
        this.aeP = headPendantClickableView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bk bkVar;
        bk bkVar2;
        bk bkVar3;
        bk bkVar4;
        Context context;
        bk bkVar5;
        bk bkVar6;
        bk bkVar7;
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        bkVar = this.aeP.aeu;
        if (bkVar != null) {
            bkVar2 = this.aeP.aeu;
            if (bkVar2.getAuthor() != null) {
                bkVar3 = this.aeP.aeu;
                if (!StringUtils.isNull(bkVar3.getAuthor().getName_show())) {
                    bkVar4 = this.aeP.aeu;
                    if (!StringUtils.isNull(bkVar4.getAuthor().getUserId())) {
                        MessageManager messageManager = MessageManager.getInstance();
                        context = this.aeP.mContext;
                        bkVar5 = this.aeP.aeu;
                        String userId = bkVar5.getAuthor().getUserId();
                        bkVar6 = this.aeP.aeu;
                        String name_show = bkVar6.getAuthor().getName_show();
                        bkVar7 = this.aeP.aeu;
                        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, userId, name_show, bkVar7.getForum_name(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                        onClickListener = this.aeP.aev;
                        if (onClickListener != null) {
                            onClickListener2 = this.aeP.aev;
                            onClickListener2.onClick(view);
                        }
                    }
                }
            }
        }
    }
}
