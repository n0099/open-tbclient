package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class d implements View.OnClickListener {
    final /* synthetic */ HeadPendantClickableView ail;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(HeadPendantClickableView headPendantClickableView) {
        this.ail = headPendantClickableView;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        bl blVar;
        bl blVar2;
        bl blVar3;
        bl blVar4;
        bl blVar5;
        Context context;
        bl blVar6;
        bl blVar7;
        bl blVar8;
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        bl blVar9;
        Context context2;
        bl blVar10;
        bl blVar11;
        if (this.ail.ahO == null || !this.ail.ahO.s(view)) {
            blVar = this.ail.ahM;
            if (blVar != null) {
                blVar2 = this.ail.ahM;
                if (blVar2.getAuthor() != null) {
                    blVar3 = this.ail.ahM;
                    if (!StringUtils.isNull(blVar3.getAuthor().getName_show())) {
                        blVar4 = this.ail.ahM;
                        if (!StringUtils.isNull(blVar4.getAuthor().getUserId())) {
                            blVar5 = this.ail.ahM;
                            if (blVar5.sx() != null) {
                                blVar9 = this.ail.ahM;
                                if (blVar9.sx().channelId > 0) {
                                    MessageManager messageManager = MessageManager.getInstance();
                                    context2 = this.ail.mContext;
                                    blVar10 = this.ail.ahM;
                                    long j = blVar10.sx().channelId;
                                    blVar11 = this.ail.ahM;
                                    messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(context2, j, blVar11.sx().mCurrentPage)));
                                    onClickListener = this.ail.ahN;
                                    if (onClickListener == null) {
                                        onClickListener2 = this.ail.ahN;
                                        onClickListener2.onClick(view);
                                        return;
                                    }
                                    return;
                                }
                            }
                            MessageManager messageManager2 = MessageManager.getInstance();
                            context = this.ail.mContext;
                            blVar6 = this.ail.ahM;
                            String userId = blVar6.getAuthor().getUserId();
                            blVar7 = this.ail.ahM;
                            String name_show = blVar7.getAuthor().getName_show();
                            blVar8 = this.ail.ahM;
                            messageManager2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, userId, name_show, blVar8.rz(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                            onClickListener = this.ail.ahN;
                            if (onClickListener == null) {
                            }
                        }
                    }
                }
            }
        }
    }
}
