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
class d implements View.OnClickListener {
    final /* synthetic */ HeadPendantClickableView aei;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(HeadPendantClickableView headPendantClickableView) {
        this.aei = headPendantClickableView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bg bgVar;
        bg bgVar2;
        bg bgVar3;
        bg bgVar4;
        Context context;
        bg bgVar5;
        bg bgVar6;
        bg bgVar7;
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        bgVar = this.aei.adN;
        if (bgVar != null) {
            bgVar2 = this.aei.adN;
            if (bgVar2.getAuthor() != null) {
                bgVar3 = this.aei.adN;
                if (!StringUtils.isNull(bgVar3.getAuthor().getName_show())) {
                    bgVar4 = this.aei.adN;
                    if (!StringUtils.isNull(bgVar4.getAuthor().getUserId())) {
                        MessageManager messageManager = MessageManager.getInstance();
                        context = this.aei.mContext;
                        bgVar5 = this.aei.adN;
                        String userId = bgVar5.getAuthor().getUserId();
                        bgVar6 = this.aei.adN;
                        String name_show = bgVar6.getAuthor().getName_show();
                        bgVar7 = this.aei.adN;
                        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, userId, name_show, bgVar7.rK(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                        onClickListener = this.aei.adO;
                        if (onClickListener != null) {
                            onClickListener2 = this.aei.adO;
                            onClickListener2.onClick(view);
                        }
                    }
                }
            }
        }
    }
}
