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
class ak implements View.OnClickListener {
    final /* synthetic */ ThreadCommentAndPraiseInfoLayout ame;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout) {
        this.ame = threadCommentAndPraiseInfoLayout;
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
        bkVar = this.ame.ahV;
        if (bkVar != null) {
            bkVar2 = this.ame.ahV;
            if (!StringUtils.isNull(bkVar2.rD())) {
                str = this.ame.mStType;
                if (!StringUtils.isNull(str)) {
                    str2 = this.ame.alX;
                    if (!StringUtils.isNull(str2)) {
                        MessageManager messageManager = MessageManager.getInstance();
                        context2 = this.ame.mContext;
                        FrsActivityConfig frsActivityConfig = new FrsActivityConfig(context2);
                        bkVar4 = this.ame.ahV;
                        String rD = bkVar4.rD();
                        str3 = this.ame.mStType;
                        str4 = this.ame.alX;
                        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, frsActivityConfig.createCfgForpersonalized(rD, str3, str4)));
                        onClickListener = this.ame.alY;
                        if (onClickListener == null) {
                            onClickListener2 = this.ame.alY;
                            onClickListener2.onClick(view);
                            return;
                        }
                        return;
                    }
                }
                MessageManager messageManager2 = MessageManager.getInstance();
                context = this.ame.mContext;
                FrsActivityConfig frsActivityConfig2 = new FrsActivityConfig(context);
                bkVar3 = this.ame.ahV;
                messageManager2.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, frsActivityConfig2.createNormalCfg(bkVar3.rD(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                onClickListener = this.ame.alY;
                if (onClickListener == null) {
                }
            }
        }
    }
}
