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
class ae implements View.OnClickListener {
    final /* synthetic */ ThreadCommentAndPraiseInfoLayout ahj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout) {
        this.ahj = threadCommentAndPraiseInfoLayout;
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
        biVar = this.ahj.adW;
        if (biVar != null) {
            biVar2 = this.ahj.adW;
            if (!StringUtils.isNull(biVar2.getForum_name())) {
                str = this.ahj.ahb;
                if (!StringUtils.isNull(str)) {
                    str2 = this.ahj.ahc;
                    if (!StringUtils.isNull(str2)) {
                        MessageManager messageManager = MessageManager.getInstance();
                        context2 = this.ahj.mContext;
                        FrsActivityConfig frsActivityConfig = new FrsActivityConfig(context2);
                        biVar4 = this.ahj.adW;
                        String forum_name = biVar4.getForum_name();
                        str3 = this.ahj.ahb;
                        str4 = this.ahj.ahc;
                        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, frsActivityConfig.createCfgForpersonalized(forum_name, str3, str4)));
                        onClickListener = this.ahj.ahd;
                        if (onClickListener == null) {
                            onClickListener2 = this.ahj.ahd;
                            onClickListener2.onClick(view);
                            return;
                        }
                        return;
                    }
                }
                MessageManager messageManager2 = MessageManager.getInstance();
                context = this.ahj.mContext;
                FrsActivityConfig frsActivityConfig2 = new FrsActivityConfig(context);
                biVar3 = this.ahj.adW;
                messageManager2.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, frsActivityConfig2.createNormalCfg(biVar3.getForum_name(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                onClickListener = this.ahj.ahd;
                if (onClickListener == null) {
                }
            }
        }
    }
}
