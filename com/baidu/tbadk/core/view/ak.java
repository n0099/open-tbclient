package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class ak implements View.OnClickListener {
    final /* synthetic */ ThreadCommentAndPraiseInfoLayout alU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout) {
        this.alU = threadCommentAndPraiseInfoLayout;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        bl blVar;
        bl blVar2;
        String str;
        Context context;
        bl blVar3;
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        String str2;
        Context context2;
        bl blVar4;
        String str3;
        String str4;
        blVar = this.alU.ahM;
        if (blVar != null) {
            blVar2 = this.alU.ahM;
            if (!StringUtils.isNull(blVar2.rz())) {
                str = this.alU.mStType;
                if (!StringUtils.isNull(str)) {
                    str2 = this.alU.alN;
                    if (!StringUtils.isNull(str2)) {
                        MessageManager messageManager = MessageManager.getInstance();
                        context2 = this.alU.mContext;
                        FrsActivityConfig frsActivityConfig = new FrsActivityConfig(context2);
                        blVar4 = this.alU.ahM;
                        String rz = blVar4.rz();
                        str3 = this.alU.mStType;
                        str4 = this.alU.alN;
                        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, frsActivityConfig.createCfgForpersonalized(rz, str3, str4)));
                        onClickListener = this.alU.alO;
                        if (onClickListener == null) {
                            onClickListener2 = this.alU.alO;
                            onClickListener2.onClick(view);
                            return;
                        }
                        return;
                    }
                }
                MessageManager messageManager2 = MessageManager.getInstance();
                context = this.alU.mContext;
                FrsActivityConfig frsActivityConfig2 = new FrsActivityConfig(context);
                blVar3 = this.alU.ahM;
                messageManager2.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, frsActivityConfig2.createNormalCfg(blVar3.rz(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                onClickListener = this.alU.alO;
                if (onClickListener == null) {
                }
            }
        }
    }
}
