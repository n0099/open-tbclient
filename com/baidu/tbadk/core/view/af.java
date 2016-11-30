package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class af implements View.OnClickListener {
    final /* synthetic */ ThreadCommentAndPraiseInfoLayout ahJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout) {
        this.ahJ = threadCommentAndPraiseInfoLayout;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        bk bkVar;
        bk bkVar2;
        String str;
        Context context;
        bk bkVar3;
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        String str2;
        Context context2;
        bk bkVar4;
        String str3;
        String str4;
        bkVar = this.ahJ.aeu;
        if (bkVar != null) {
            bkVar2 = this.ahJ.aeu;
            if (!StringUtils.isNull(bkVar2.getForum_name())) {
                str = this.ahJ.ahB;
                if (!StringUtils.isNull(str)) {
                    str2 = this.ahJ.ahC;
                    if (!StringUtils.isNull(str2)) {
                        MessageManager messageManager = MessageManager.getInstance();
                        context2 = this.ahJ.mContext;
                        FrsActivityConfig frsActivityConfig = new FrsActivityConfig(context2);
                        bkVar4 = this.ahJ.aeu;
                        String forum_name = bkVar4.getForum_name();
                        str3 = this.ahJ.ahB;
                        str4 = this.ahJ.ahC;
                        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, frsActivityConfig.createCfgForpersonalized(forum_name, str3, str4)));
                        onClickListener = this.ahJ.ahD;
                        if (onClickListener == null) {
                            onClickListener2 = this.ahJ.ahD;
                            onClickListener2.onClick(view);
                            return;
                        }
                        return;
                    }
                }
                MessageManager messageManager2 = MessageManager.getInstance();
                context = this.ahJ.mContext;
                FrsActivityConfig frsActivityConfig2 = new FrsActivityConfig(context);
                bkVar3 = this.ahJ.aeu;
                messageManager2.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, frsActivityConfig2.createNormalCfg(bkVar3.getForum_name(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                onClickListener = this.ahJ.ahD;
                if (onClickListener == null) {
                }
            }
        }
    }
}
