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
    final /* synthetic */ ThreadCommentAndPraiseInfoLayout ahw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout) {
        this.ahw = threadCommentAndPraiseInfoLayout;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        com.baidu.tbadk.core.data.ah ahVar;
        com.baidu.tbadk.core.data.ah ahVar2;
        String str;
        Context context;
        com.baidu.tbadk.core.data.ah ahVar3;
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        String str2;
        Context context2;
        com.baidu.tbadk.core.data.ah ahVar4;
        String str3;
        String str4;
        ahVar = this.ahw.afg;
        if (ahVar != null) {
            ahVar2 = this.ahw.afg;
            if (!StringUtils.isNull(ahVar2.tn())) {
                str = this.ahw.ahp;
                if (!StringUtils.isNull(str)) {
                    str2 = this.ahw.ahq;
                    if (!StringUtils.isNull(str2)) {
                        MessageManager messageManager = MessageManager.getInstance();
                        context2 = this.ahw.mContext;
                        FrsActivityConfig frsActivityConfig = new FrsActivityConfig(context2);
                        ahVar4 = this.ahw.afg;
                        String tn = ahVar4.tn();
                        str3 = this.ahw.ahp;
                        str4 = this.ahw.ahq;
                        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, frsActivityConfig.createCfgForpersonalized(tn, str3, str4)));
                        onClickListener = this.ahw.ahr;
                        if (onClickListener == null) {
                            onClickListener2 = this.ahw.ahr;
                            onClickListener2.onClick(view);
                            return;
                        }
                        return;
                    }
                }
                MessageManager messageManager2 = MessageManager.getInstance();
                context = this.ahw.mContext;
                FrsActivityConfig frsActivityConfig2 = new FrsActivityConfig(context);
                ahVar3 = this.ahw.afg;
                messageManager2.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, frsActivityConfig2.createNormalCfg(ahVar3.tn(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                onClickListener = this.ahw.ahr;
                if (onClickListener == null) {
                }
            }
        }
    }
}
