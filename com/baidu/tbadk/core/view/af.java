package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class af implements View.OnClickListener {
    final /* synthetic */ ThreadCommentAndPraiseInfoLayout ahk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout) {
        this.ahk = threadCommentAndPraiseInfoLayout;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        bg bgVar;
        bg bgVar2;
        String str;
        Context context;
        bg bgVar3;
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        String str2;
        Context context2;
        bg bgVar4;
        String str3;
        String str4;
        bgVar = this.ahk.adN;
        if (bgVar != null) {
            bgVar2 = this.ahk.adN;
            if (!StringUtils.isNull(bgVar2.rK())) {
                str = this.ahk.ahe;
                if (!StringUtils.isNull(str)) {
                    str2 = this.ahk.ahf;
                    if (!StringUtils.isNull(str2)) {
                        MessageManager messageManager = MessageManager.getInstance();
                        context2 = this.ahk.mContext;
                        FrsActivityConfig frsActivityConfig = new FrsActivityConfig(context2);
                        bgVar4 = this.ahk.adN;
                        String rK = bgVar4.rK();
                        str3 = this.ahk.ahe;
                        str4 = this.ahk.ahf;
                        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, frsActivityConfig.createCfgForpersonalized(rK, str3, str4)));
                        onClickListener = this.ahk.ahg;
                        if (onClickListener == null) {
                            onClickListener2 = this.ahk.ahg;
                            onClickListener2.onClick(view);
                            return;
                        }
                        return;
                    }
                }
                MessageManager messageManager2 = MessageManager.getInstance();
                context = this.ahk.mContext;
                FrsActivityConfig frsActivityConfig2 = new FrsActivityConfig(context);
                bgVar3 = this.ahk.adN;
                messageManager2.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, frsActivityConfig2.createNormalCfg(bgVar3.rK(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                onClickListener = this.ahk.ahg;
                if (onClickListener == null) {
                }
            }
        }
    }
}
