package com.baidu.tbadk.core;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.NotLoginGuideActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements Handler.Callback {
    final /* synthetic */ TbadkCoreApplication TJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(TbadkCoreApplication tbadkCoreApplication) {
        this.TJ = tbadkCoreApplication;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 1:
                TbadkCoreApplication.setCurrentAccount(null, this.TJ.getContext());
                if (message.getData().getString(LoginActivityConfig.ACCOUNT) == null) {
                }
                NotLoginGuideActivityConfig notLoginGuideActivityConfig = new NotLoginGuideActivityConfig(this.TJ.getContext(), NotLoginGuideActivityConfig.FROM_ACCOUNT);
                notLoginGuideActivityConfig.getIntent().setFlags(268435456);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, notLoginGuideActivityConfig));
                break;
            case 4:
                long nanoTime = (((System.nanoTime() - this.TJ.mStartTime) / 1000000) - TbConfig.USE_TIME_INTERVAL) / 1000;
                if (nanoTime > 0) {
                    new aj(TbConfig.ST_TYPE_USE, String.valueOf(nanoTime)).start();
                    TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getApp(), TbConfig.ST_TYPE_USE, null, 1, "st_param", String.valueOf(nanoTime));
                }
                this.TJ.mStartTime = 0L;
                break;
            case 5:
                if (Boolean.TRUE.equals(message.obj)) {
                    this.TJ.notifyAppEnterBackground();
                    break;
                } else {
                    this.TJ.notifyAppEnterForehead();
                    break;
                }
        }
        return false;
    }
}
