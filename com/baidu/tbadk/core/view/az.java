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
class az implements View.OnClickListener {
    final /* synthetic */ UserIconLayout amG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(UserIconLayout userIconLayout) {
        this.amG = userIconLayout;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
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
        bl blVar6;
        Context context;
        bl blVar7;
        bl blVar8;
        bl blVar9;
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        bl blVar10;
        Context context2;
        bl blVar11;
        bl blVar12;
        blVar = this.amG.ahM;
        if (blVar != null) {
            blVar2 = this.amG.ahM;
            if (blVar2.getAuthor() != null) {
                blVar3 = this.amG.ahM;
                if (!StringUtils.isNull(blVar3.getAuthor().getName_show())) {
                    blVar4 = this.amG.ahM;
                    if (!StringUtils.isNull(blVar4.getAuthor().getUserId())) {
                        blVar5 = this.amG.ahM;
                        if (blVar5.rz() != null) {
                            blVar6 = this.amG.ahM;
                            if (blVar6.sx() != null) {
                                blVar10 = this.amG.ahM;
                                if (blVar10.sx().channelId > 0) {
                                    MessageManager messageManager = MessageManager.getInstance();
                                    context2 = this.amG.mContext;
                                    blVar11 = this.amG.ahM;
                                    long j = blVar11.sx().channelId;
                                    blVar12 = this.amG.ahM;
                                    messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(context2, j, blVar12.sx().mCurrentPage)));
                                    onClickListener = this.amG.ama;
                                    if (onClickListener == null) {
                                        onClickListener2 = this.amG.ama;
                                        onClickListener2.onClick(view);
                                        return;
                                    }
                                    return;
                                }
                            }
                            MessageManager messageManager2 = MessageManager.getInstance();
                            context = this.amG.mContext;
                            blVar7 = this.amG.ahM;
                            String userId = blVar7.getAuthor().getUserId();
                            blVar8 = this.amG.ahM;
                            String name_show = blVar8.getAuthor().getName_show();
                            blVar9 = this.amG.ahM;
                            messageManager2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, userId, name_show, blVar9.rz(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                            onClickListener = this.amG.ama;
                            if (onClickListener == null) {
                            }
                        }
                    }
                }
            }
        }
    }
}
