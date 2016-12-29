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
import com.baidu.tbadk.core.util.ao;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements Handler.Callback {
    final /* synthetic */ TbadkCoreApplication this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(TbadkCoreApplication tbadkCoreApplication) {
        this.this$0 = tbadkCoreApplication;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 1:
                TbadkCoreApplication.setCurrentAccount(null, this.this$0.getContext());
                if (message.getData().getString(LoginActivityConfig.ACCOUNT) == null) {
                }
                NotLoginGuideActivityConfig notLoginGuideActivityConfig = new NotLoginGuideActivityConfig(this.this$0.getContext(), NotLoginGuideActivityConfig.FROM_ACCOUNT);
                notLoginGuideActivityConfig.getIntent().setFlags(268435456);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, notLoginGuideActivityConfig));
                break;
            case 4:
                long nanoTime = (((System.nanoTime() - this.this$0.mStartTime) / 1000000) - TbConfig.USE_TIME_INTERVAL) / 1000;
                if (nanoTime > 0) {
                    new ao(TbConfig.ST_TYPE_USE, String.valueOf(nanoTime)).start();
                    TiebaStatic.eventStat(TbadkCoreApplication.m9getInst().getApp(), TbConfig.ST_TYPE_USE, null, 1, "st_param", String.valueOf(nanoTime));
                }
                this.this$0.mStartTime = 0L;
                break;
            case 5:
                if (Boolean.TRUE.equals(message.obj)) {
                    this.this$0.notifyAppEnterBackground();
                    break;
                } else {
                    this.this$0.notifyAppEnterForehead();
                    break;
                }
        }
        return false;
    }
}
