package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class d implements View.OnClickListener {
    final /* synthetic */ HeadPendantClickableView adt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(HeadPendantClickableView headPendantClickableView) {
        this.adt = headPendantClickableView;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        bh bhVar;
        bh bhVar2;
        bh bhVar3;
        bh bhVar4;
        bh bhVar5;
        Context context;
        bh bhVar6;
        bh bhVar7;
        bh bhVar8;
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        bh bhVar9;
        Context context2;
        bh bhVar10;
        bh bhVar11;
        bhVar = this.adt.acX;
        if (bhVar != null) {
            bhVar2 = this.adt.acX;
            if (bhVar2.getAuthor() != null) {
                bhVar3 = this.adt.acX;
                if (!StringUtils.isNull(bhVar3.getAuthor().getName_show())) {
                    bhVar4 = this.adt.acX;
                    if (!StringUtils.isNull(bhVar4.getAuthor().getUserId())) {
                        bhVar5 = this.adt.acX;
                        if (bhVar5.sz() != null) {
                            bhVar9 = this.adt.acX;
                            if (bhVar9.sz().channelId > 0) {
                                MessageManager messageManager = MessageManager.getInstance();
                                context2 = this.adt.mContext;
                                bhVar10 = this.adt.acX;
                                long j = bhVar10.sz().channelId;
                                bhVar11 = this.adt.acX;
                                messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(context2, j, bhVar11.sz().mCurrentPage)));
                                onClickListener = this.adt.acY;
                                if (onClickListener == null) {
                                    onClickListener2 = this.adt.acY;
                                    onClickListener2.onClick(view);
                                    return;
                                }
                                return;
                            }
                        }
                        MessageManager messageManager2 = MessageManager.getInstance();
                        context = this.adt.mContext;
                        bhVar6 = this.adt.acX;
                        String userId = bhVar6.getAuthor().getUserId();
                        bhVar7 = this.adt.acX;
                        String name_show = bhVar7.getAuthor().getName_show();
                        bhVar8 = this.adt.acX;
                        messageManager2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, userId, name_show, bhVar8.rB(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                        onClickListener = this.adt.acY;
                        if (onClickListener == null) {
                        }
                    }
                }
            }
        }
    }
}
