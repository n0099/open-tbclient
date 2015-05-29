package com.baidu.tbadk.core;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.NotLoginGuideActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements Handler.Callback {
    final /* synthetic */ TbadkCoreApplication OW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(TbadkCoreApplication tbadkCoreApplication) {
        this.OW = tbadkCoreApplication;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 1:
                TbadkCoreApplication.setCurrentAccount(null, this.OW.getContext());
                if (message.getData().getString(LoginActivityConfig.ACCOUNT) == null) {
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NotLoginGuideActivityConfig(this.OW.getContext(), NotLoginGuideActivityConfig.FROM_ACCOUNT)));
                break;
            case 4:
                long nanoTime = (((System.nanoTime() - this.OW.mStartTime) / 1000000) - TbConfig.USE_TIME_INTERVAL) / 1000;
                if (nanoTime > 0) {
                    new aw(TbConfig.ST_TYPE_USE, String.valueOf(nanoTime)).start();
                    TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getApp(), TbConfig.ST_TYPE_USE, null, 1, "st_param", String.valueOf(nanoTime));
                }
                this.OW.mStartTime = 0L;
                break;
            case 5:
                if (Boolean.TRUE.equals(message.obj)) {
                    this.OW.notifyAppEnterBackground();
                    break;
                } else {
                    this.OW.notifyAppEnterForehead();
                    break;
                }
        }
        return false;
    }
}
