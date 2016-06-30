package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class af implements View.OnClickListener {
    final /* synthetic */ ThreadCommentAndPraiseInfoLayout adS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout) {
        this.adS = threadCommentAndPraiseInfoLayout;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        az azVar;
        az azVar2;
        String str;
        Context context;
        az azVar3;
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        String str2;
        Context context2;
        az azVar4;
        String str3;
        String str4;
        azVar = this.adS.aas;
        if (azVar != null) {
            azVar2 = this.adS.aas;
            if (!StringUtils.isNull(azVar2.getForum_name())) {
                str = this.adS.adJ;
                if (!StringUtils.isNull(str)) {
                    str2 = this.adS.adK;
                    if (!StringUtils.isNull(str2)) {
                        MessageManager messageManager = MessageManager.getInstance();
                        context2 = this.adS.mContext;
                        FrsActivityConfig frsActivityConfig = new FrsActivityConfig(context2);
                        azVar4 = this.adS.aas;
                        String forum_name = azVar4.getForum_name();
                        str3 = this.adS.adJ;
                        str4 = this.adS.adK;
                        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, frsActivityConfig.createCfgForpersonalized(forum_name, str3, str4)));
                        onClickListener = this.adS.adL;
                        if (onClickListener == null) {
                            onClickListener2 = this.adS.adL;
                            onClickListener2.onClick(view);
                            return;
                        }
                        return;
                    }
                }
                MessageManager messageManager2 = MessageManager.getInstance();
                context = this.adS.mContext;
                FrsActivityConfig frsActivityConfig2 = new FrsActivityConfig(context);
                azVar3 = this.adS.aas;
                messageManager2.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, frsActivityConfig2.createNormalCfg(azVar3.getForum_name(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                onClickListener = this.adS.adL;
                if (onClickListener == null) {
                }
            }
        }
    }
}
