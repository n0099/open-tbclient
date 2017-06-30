package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class ak implements View.OnClickListener {
    final /* synthetic */ ThreadCommentAndPraiseInfoLayout amM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout) {
        this.amM = threadCommentAndPraiseInfoLayout;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        bm bmVar;
        bm bmVar2;
        String str;
        Context context;
        bm bmVar3;
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        String str2;
        Context context2;
        bm bmVar4;
        String str3;
        String str4;
        bmVar = this.amM.aiu;
        if (bmVar != null) {
            bmVar2 = this.amM.aiu;
            if (!StringUtils.isNull(bmVar2.rw())) {
                str = this.amM.mStType;
                if (!StringUtils.isNull(str)) {
                    str2 = this.amM.amE;
                    if (!StringUtils.isNull(str2)) {
                        MessageManager messageManager = MessageManager.getInstance();
                        context2 = this.amM.mContext;
                        FrsActivityConfig frsActivityConfig = new FrsActivityConfig(context2);
                        bmVar4 = this.amM.aiu;
                        String rw = bmVar4.rw();
                        str3 = this.amM.mStType;
                        str4 = this.amM.amE;
                        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, frsActivityConfig.createCfgForpersonalized(rw, str3, str4)));
                        onClickListener = this.amM.amF;
                        if (onClickListener == null) {
                            onClickListener2 = this.amM.amF;
                            onClickListener2.onClick(view);
                            return;
                        }
                        return;
                    }
                }
                MessageManager messageManager2 = MessageManager.getInstance();
                context = this.amM.mContext;
                FrsActivityConfig frsActivityConfig2 = new FrsActivityConfig(context);
                bmVar3 = this.amM.aiu;
                messageManager2.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, frsActivityConfig2.createNormalCfg(bmVar3.rw(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                onClickListener = this.amM.amF;
                if (onClickListener == null) {
                }
            }
        }
    }
}
