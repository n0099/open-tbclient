package com.baidu.tbadk.core.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.bl;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class au implements View.OnClickListener {
    final /* synthetic */ ThreadUserInfoLayout anp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(ThreadUserInfoLayout threadUserInfoLayout) {
        this.anp = threadUserInfoLayout;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        bm bmVar;
        bm bmVar2;
        bm bmVar3;
        bm bmVar4;
        bm bmVar5;
        bm bmVar6;
        Context context;
        bm bmVar7;
        bm bmVar8;
        bm bmVar9;
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        bm bmVar10;
        Context context2;
        bm bmVar11;
        bm bmVar12;
        bmVar = this.anp.aiu;
        if (bmVar != null) {
            bmVar2 = this.anp.aiu;
            if (bmVar2.getAuthor() != null) {
                bmVar3 = this.anp.aiu;
                if (!StringUtils.isNull(bmVar3.getAuthor().getName_show())) {
                    bmVar4 = this.anp.aiu;
                    if (!StringUtils.isNull(bmVar4.getAuthor().getUserId())) {
                        bmVar5 = this.anp.aiu;
                        if (bmVar5.rw() != null) {
                            if (view.getTag(w.h.tag_nick_name_activity) != null && (view.getTag(w.h.tag_nick_name_activity) instanceof String)) {
                                String str = (String) view.getTag(w.h.tag_nick_name_activity);
                                if (!TextUtils.isEmpty(str) && bl.aN(this.anp.getContext())) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                                    return;
                                }
                            }
                            bmVar6 = this.anp.aiu;
                            if (bmVar6.sv() != null) {
                                bmVar10 = this.anp.aiu;
                                if (bmVar10.sv().channelId > 0) {
                                    MessageManager messageManager = MessageManager.getInstance();
                                    context2 = this.anp.mContext;
                                    bmVar11 = this.anp.aiu;
                                    long j = bmVar11.sv().channelId;
                                    bmVar12 = this.anp.aiu;
                                    messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(context2, j, bmVar12.sv().mCurrentPage)));
                                    onClickListener = this.anp.amS;
                                    if (onClickListener == null) {
                                        onClickListener2 = this.anp.amS;
                                        onClickListener2.onClick(view);
                                        return;
                                    }
                                    return;
                                }
                            }
                            MessageManager messageManager2 = MessageManager.getInstance();
                            context = this.anp.mContext;
                            bmVar7 = this.anp.aiu;
                            String userId = bmVar7.getAuthor().getUserId();
                            bmVar8 = this.anp.aiu;
                            String name_show = bmVar8.getAuthor().getName_show();
                            bmVar9 = this.anp.aiu;
                            messageManager2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, userId, name_show, bmVar9.rw(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                            onClickListener = this.anp.amS;
                            if (onClickListener == null) {
                            }
                        }
                    }
                }
            }
        }
    }
}
