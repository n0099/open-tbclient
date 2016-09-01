package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class ag implements View.OnClickListener {
    final /* synthetic */ ThreadCommentAndPraiseInfoLayout ahB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout) {
        this.ahB = threadCommentAndPraiseInfoLayout;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        bg bgVar;
        bg bgVar2;
        String str;
        Context context;
        bg bgVar3;
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        String str2;
        Context context2;
        bg bgVar4;
        String str3;
        String str4;
        bgVar = this.ahB.adL;
        if (bgVar != null) {
            bgVar2 = this.ahB.adL;
            if (!StringUtils.isNull(bgVar2.getForum_name())) {
                str = this.ahB.ahs;
                if (!StringUtils.isNull(str)) {
                    str2 = this.ahB.aht;
                    if (!StringUtils.isNull(str2)) {
                        MessageManager messageManager = MessageManager.getInstance();
                        context2 = this.ahB.mContext;
                        FrsActivityConfig frsActivityConfig = new FrsActivityConfig(context2);
                        bgVar4 = this.ahB.adL;
                        String forum_name = bgVar4.getForum_name();
                        str3 = this.ahB.ahs;
                        str4 = this.ahB.aht;
                        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, frsActivityConfig.createCfgForpersonalized(forum_name, str3, str4)));
                        onClickListener = this.ahB.ahu;
                        if (onClickListener == null) {
                            onClickListener2 = this.ahB.ahu;
                            onClickListener2.onClick(view);
                            return;
                        }
                        return;
                    }
                }
                MessageManager messageManager2 = MessageManager.getInstance();
                context = this.ahB.mContext;
                FrsActivityConfig frsActivityConfig2 = new FrsActivityConfig(context);
                bgVar3 = this.ahB.adL;
                messageManager2.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, frsActivityConfig2.createNormalCfg(bgVar3.getForum_name(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                onClickListener = this.ahB.ahu;
                if (onClickListener == null) {
                }
            }
        }
    }
}
