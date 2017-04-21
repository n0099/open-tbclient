package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class ah implements View.OnClickListener {
    final /* synthetic */ ThreadCommentAndPraiseInfoLayout ame;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout) {
        this.ame = threadCommentAndPraiseInfoLayout;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        bi biVar;
        bi biVar2;
        String str;
        Context context;
        bi biVar3;
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        String str2;
        Context context2;
        bi biVar4;
        String str3;
        String str4;
        biVar = this.ame.aiC;
        if (biVar != null) {
            biVar2 = this.ame.aiC;
            if (!StringUtils.isNull(biVar2.st())) {
                str = this.ame.alY;
                if (!StringUtils.isNull(str)) {
                    str2 = this.ame.alZ;
                    if (!StringUtils.isNull(str2)) {
                        MessageManager messageManager = MessageManager.getInstance();
                        context2 = this.ame.mContext;
                        FrsActivityConfig frsActivityConfig = new FrsActivityConfig(context2);
                        biVar4 = this.ame.aiC;
                        String st = biVar4.st();
                        str3 = this.ame.alY;
                        str4 = this.ame.alZ;
                        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, frsActivityConfig.createCfgForpersonalized(st, str3, str4)));
                        onClickListener = this.ame.ama;
                        if (onClickListener == null) {
                            onClickListener2 = this.ame.ama;
                            onClickListener2.onClick(view);
                            return;
                        }
                        return;
                    }
                }
                MessageManager messageManager2 = MessageManager.getInstance();
                context = this.ame.mContext;
                FrsActivityConfig frsActivityConfig2 = new FrsActivityConfig(context);
                biVar3 = this.ame.aiC;
                messageManager2.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, frsActivityConfig2.createNormalCfg(biVar3.st(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                onClickListener = this.ame.ama;
                if (onClickListener == null) {
                }
            }
        }
    }
}
