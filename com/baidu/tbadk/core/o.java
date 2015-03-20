package com.baidu.tbadk.core;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements Handler.Callback {
    final /* synthetic */ TbadkCoreApplication Ox;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(TbadkCoreApplication tbadkCoreApplication) {
        this.Ox = tbadkCoreApplication;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 1:
                TbadkCoreApplication.setCurrentAccount(null, this.Ox.getContext());
                String string = message.getData().getString(LoginActivityConfig.ACCOUNT);
                if (string == null) {
                    string = "";
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LoginActivityConfig(this.Ox.getContext(), string, false, true)));
                break;
            case 4:
                long nanoTime = (((System.nanoTime() - this.Ox.mStartTime) / 1000000) - TbConfig.USE_TIME_INTERVAL) / 1000;
                if (nanoTime > 0) {
                    new ay(TbConfig.ST_TYPE_USE, String.valueOf(nanoTime)).start();
                    TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getApp(), TbConfig.ST_TYPE_USE, null, 1, "st_param", String.valueOf(nanoTime));
                }
                this.Ox.mStartTime = 0L;
                break;
            case 5:
                if (Boolean.TRUE.equals(message.obj)) {
                    this.Ox.notifyAppEnterBackground();
                    break;
                } else {
                    this.Ox.notifyAppEnterForehead();
                    break;
                }
        }
        return false;
    }
}
