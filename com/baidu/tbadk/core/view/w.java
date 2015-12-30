package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class w implements View.OnClickListener {
    final /* synthetic */ ThreadCommentAndPraiseInfoLayout agH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout) {
        this.agH = threadCommentAndPraiseInfoLayout;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        com.baidu.tbadk.core.data.z zVar;
        com.baidu.tbadk.core.data.z zVar2;
        String str;
        Context context;
        com.baidu.tbadk.core.data.z zVar3;
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        String str2;
        Context context2;
        com.baidu.tbadk.core.data.z zVar4;
        String str3;
        String str4;
        zVar = this.agH.aeF;
        if (zVar != null) {
            zVar2 = this.agH.aeF;
            if (!StringUtils.isNull(zVar2.sv())) {
                str = this.agH.agB;
                if (!StringUtils.isNull(str)) {
                    str2 = this.agH.agC;
                    if (!StringUtils.isNull(str2)) {
                        MessageManager messageManager = MessageManager.getInstance();
                        context2 = this.agH.mContext;
                        FrsActivityConfig frsActivityConfig = new FrsActivityConfig(context2);
                        zVar4 = this.agH.aeF;
                        String sv = zVar4.sv();
                        str3 = this.agH.agB;
                        str4 = this.agH.agC;
                        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, frsActivityConfig.createCfgForpersonalized(sv, str3, str4)));
                        onClickListener = this.agH.agD;
                        if (onClickListener == null) {
                            onClickListener2 = this.agH.agD;
                            onClickListener2.onClick(view);
                            return;
                        }
                        return;
                    }
                }
                MessageManager messageManager2 = MessageManager.getInstance();
                context = this.agH.mContext;
                FrsActivityConfig frsActivityConfig2 = new FrsActivityConfig(context);
                zVar3 = this.agH.aeF;
                messageManager2.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, frsActivityConfig2.createNormalCfg(zVar3.sv(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                onClickListener = this.agH.agD;
                if (onClickListener == null) {
                }
            }
        }
    }
}
