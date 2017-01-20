package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class ag implements View.OnClickListener {
    final /* synthetic */ ThreadCommentAndPraiseInfoLayout agx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout) {
        this.agx = threadCommentAndPraiseInfoLayout;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        bh bhVar;
        bh bhVar2;
        String str;
        Context context;
        bh bhVar3;
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        String str2;
        Context context2;
        bh bhVar4;
        String str3;
        String str4;
        bhVar = this.agx.acX;
        if (bhVar != null) {
            bhVar2 = this.agx.acX;
            if (!StringUtils.isNull(bhVar2.rB())) {
                str = this.agx.agr;
                if (!StringUtils.isNull(str)) {
                    str2 = this.agx.ags;
                    if (!StringUtils.isNull(str2)) {
                        MessageManager messageManager = MessageManager.getInstance();
                        context2 = this.agx.mContext;
                        FrsActivityConfig frsActivityConfig = new FrsActivityConfig(context2);
                        bhVar4 = this.agx.acX;
                        String rB = bhVar4.rB();
                        str3 = this.agx.agr;
                        str4 = this.agx.ags;
                        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, frsActivityConfig.createCfgForpersonalized(rB, str3, str4)));
                        onClickListener = this.agx.agt;
                        if (onClickListener == null) {
                            onClickListener2 = this.agx.agt;
                            onClickListener2.onClick(view);
                            return;
                        }
                        return;
                    }
                }
                MessageManager messageManager2 = MessageManager.getInstance();
                context = this.agx.mContext;
                FrsActivityConfig frsActivityConfig2 = new FrsActivityConfig(context);
                bhVar3 = this.agx.acX;
                messageManager2.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, frsActivityConfig2.createNormalCfg(bhVar3.rB(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                onClickListener = this.agx.agt;
                if (onClickListener == null) {
                }
            }
        }
    }
}
