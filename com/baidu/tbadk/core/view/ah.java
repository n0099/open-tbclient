package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class ah implements View.OnClickListener {
    final /* synthetic */ ThreadCommentAndPraiseInfoLayout alQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout) {
        this.alQ = threadCommentAndPraiseInfoLayout;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        bj bjVar;
        bj bjVar2;
        String str;
        Context context;
        bj bjVar3;
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        String str2;
        Context context2;
        bj bjVar4;
        String str3;
        String str4;
        bjVar = this.alQ.ain;
        if (bjVar != null) {
            bjVar2 = this.alQ.ain;
            if (!StringUtils.isNull(bjVar2.rV())) {
                str = this.alQ.alK;
                if (!StringUtils.isNull(str)) {
                    str2 = this.alQ.alL;
                    if (!StringUtils.isNull(str2)) {
                        MessageManager messageManager = MessageManager.getInstance();
                        context2 = this.alQ.mContext;
                        FrsActivityConfig frsActivityConfig = new FrsActivityConfig(context2);
                        bjVar4 = this.alQ.ain;
                        String rV = bjVar4.rV();
                        str3 = this.alQ.alK;
                        str4 = this.alQ.alL;
                        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, frsActivityConfig.createCfgForpersonalized(rV, str3, str4)));
                        onClickListener = this.alQ.alM;
                        if (onClickListener == null) {
                            onClickListener2 = this.alQ.alM;
                            onClickListener2.onClick(view);
                            return;
                        }
                        return;
                    }
                }
                MessageManager messageManager2 = MessageManager.getInstance();
                context = this.alQ.mContext;
                FrsActivityConfig frsActivityConfig2 = new FrsActivityConfig(context);
                bjVar3 = this.alQ.ain;
                messageManager2.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, frsActivityConfig2.createNormalCfg(bjVar3.rV(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                onClickListener = this.alQ.alM;
                if (onClickListener == null) {
                }
            }
        }
    }
}
