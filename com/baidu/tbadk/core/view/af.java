package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class af implements View.OnClickListener {
    final /* synthetic */ ThreadCommentAndPraiseInfoLayout adu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout) {
        this.adu = threadCommentAndPraiseInfoLayout;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        ax axVar;
        ax axVar2;
        String str;
        Context context;
        ax axVar3;
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        String str2;
        Context context2;
        ax axVar4;
        String str3;
        String str4;
        axVar = this.adu.aab;
        if (axVar != null) {
            axVar2 = this.adu.aab;
            if (!StringUtils.isNull(axVar2.qQ())) {
                str = this.adu.adl;
                if (!StringUtils.isNull(str)) {
                    str2 = this.adu.adm;
                    if (!StringUtils.isNull(str2)) {
                        MessageManager messageManager = MessageManager.getInstance();
                        context2 = this.adu.mContext;
                        FrsActivityConfig frsActivityConfig = new FrsActivityConfig(context2);
                        axVar4 = this.adu.aab;
                        String qQ = axVar4.qQ();
                        str3 = this.adu.adl;
                        str4 = this.adu.adm;
                        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, frsActivityConfig.createCfgForpersonalized(qQ, str3, str4)));
                        onClickListener = this.adu.adn;
                        if (onClickListener == null) {
                            onClickListener2 = this.adu.adn;
                            onClickListener2.onClick(view);
                            return;
                        }
                        return;
                    }
                }
                MessageManager messageManager2 = MessageManager.getInstance();
                context = this.adu.mContext;
                FrsActivityConfig frsActivityConfig2 = new FrsActivityConfig(context);
                axVar3 = this.adu.aab;
                messageManager2.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, frsActivityConfig2.createNormalCfg(axVar3.qQ(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                onClickListener = this.adu.adn;
                if (onClickListener == null) {
                }
            }
        }
    }
}
