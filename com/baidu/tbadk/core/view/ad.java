package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class ad implements View.OnClickListener {
    final /* synthetic */ ThreadCommentAndPraiseInfoLayout ahB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout) {
        this.ahB = threadCommentAndPraiseInfoLayout;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        com.baidu.tbadk.core.data.as asVar;
        com.baidu.tbadk.core.data.as asVar2;
        String str;
        Context context;
        com.baidu.tbadk.core.data.as asVar3;
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        String str2;
        Context context2;
        com.baidu.tbadk.core.data.as asVar4;
        String str3;
        String str4;
        asVar = this.ahB.aeC;
        if (asVar != null) {
            asVar2 = this.ahB.aeC;
            if (!StringUtils.isNull(asVar2.tr())) {
                str = this.ahB.ahu;
                if (!StringUtils.isNull(str)) {
                    str2 = this.ahB.ahv;
                    if (!StringUtils.isNull(str2)) {
                        MessageManager messageManager = MessageManager.getInstance();
                        context2 = this.ahB.mContext;
                        FrsActivityConfig frsActivityConfig = new FrsActivityConfig(context2);
                        asVar4 = this.ahB.aeC;
                        String tr = asVar4.tr();
                        str3 = this.ahB.ahu;
                        str4 = this.ahB.ahv;
                        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, frsActivityConfig.createCfgForpersonalized(tr, str3, str4)));
                        onClickListener = this.ahB.ahw;
                        if (onClickListener == null) {
                            onClickListener2 = this.ahB.ahw;
                            onClickListener2.onClick(view);
                            return;
                        }
                        return;
                    }
                }
                MessageManager messageManager2 = MessageManager.getInstance();
                context = this.ahB.mContext;
                FrsActivityConfig frsActivityConfig2 = new FrsActivityConfig(context);
                asVar3 = this.ahB.aeC;
                messageManager2.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, frsActivityConfig2.createNormalCfg(asVar3.tr(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                onClickListener = this.ahB.ahw;
                if (onClickListener == null) {
                }
            }
        }
    }
}
