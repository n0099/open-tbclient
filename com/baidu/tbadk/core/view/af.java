package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class af implements View.OnClickListener {
    final /* synthetic */ ThreadCommentAndPraiseInfoLayout aeG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout) {
        this.aeG = threadCommentAndPraiseInfoLayout;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        be beVar;
        be beVar2;
        String str;
        Context context;
        be beVar3;
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        String str2;
        Context context2;
        be beVar4;
        String str3;
        String str4;
        beVar = this.aeG.abb;
        if (beVar != null) {
            beVar2 = this.aeG.abb;
            if (!StringUtils.isNull(beVar2.getForum_name())) {
                str = this.aeG.aex;
                if (!StringUtils.isNull(str)) {
                    str2 = this.aeG.aey;
                    if (!StringUtils.isNull(str2)) {
                        MessageManager messageManager = MessageManager.getInstance();
                        context2 = this.aeG.mContext;
                        FrsActivityConfig frsActivityConfig = new FrsActivityConfig(context2);
                        beVar4 = this.aeG.abb;
                        String forum_name = beVar4.getForum_name();
                        str3 = this.aeG.aex;
                        str4 = this.aeG.aey;
                        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, frsActivityConfig.createCfgForpersonalized(forum_name, str3, str4)));
                        onClickListener = this.aeG.aez;
                        if (onClickListener == null) {
                            onClickListener2 = this.aeG.aez;
                            onClickListener2.onClick(view);
                            return;
                        }
                        return;
                    }
                }
                MessageManager messageManager2 = MessageManager.getInstance();
                context = this.aeG.mContext;
                FrsActivityConfig frsActivityConfig2 = new FrsActivityConfig(context);
                beVar3 = this.aeG.abb;
                messageManager2.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, frsActivityConfig2.createNormalCfg(beVar3.getForum_name(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                onClickListener = this.aeG.aez;
                if (onClickListener == null) {
                }
            }
        }
    }
}
