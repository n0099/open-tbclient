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
    final /* synthetic */ HeadPendantClickableView aeg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(HeadPendantClickableView headPendantClickableView) {
        this.aeg = headPendantClickableView;
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
        bgVar = this.aeg.adL;
        if (bgVar != null) {
            bgVar2 = this.aeg.adL;
            if (bgVar2.getAuthor() != null) {
                bgVar3 = this.aeg.adL;
                if (!StringUtils.isNull(bgVar3.getAuthor().getName_show())) {
                    bgVar4 = this.aeg.adL;
                    if (!StringUtils.isNull(bgVar4.getAuthor().getUserId())) {
                        MessageManager messageManager = MessageManager.getInstance();
                        context = this.aeg.mContext;
                        bgVar5 = this.aeg.adL;
                        String userId = bgVar5.getAuthor().getUserId();
                        bgVar6 = this.aeg.adL;
                        String name_show = bgVar6.getAuthor().getName_show();
                        bgVar7 = this.aeg.adL;
                        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, userId, name_show, bgVar7.getForum_name(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                        onClickListener = this.aeg.adM;
                        if (onClickListener != null) {
                            onClickListener2 = this.aeg.adM;
                            onClickListener2.onClick(view);
                        }
                    }
                }
            }
        }
    }
}
