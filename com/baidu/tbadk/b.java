package com.baidu.tbadk;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ar;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
/* loaded from: classes.dex */
class b implements Handler.Callback {
    final /* synthetic */ TbadkApplication a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(TbadkApplication tbadkApplication) {
        this.a = tbadkApplication;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 1:
                TbadkApplication.setCurrentAccount(null, this.a.getContext());
                String string = message.getData().getString("account");
                if (string == null) {
                    string = "";
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ar((Context) this.a, string, false, true)));
                break;
            case 4:
                long nanoTime = (((System.nanoTime() - this.a.mStartTime) / 1000000) - TbConfig.USE_TIME_INTERVAL) / 1000;
                if (nanoTime > 0) {
                    new aw(TbConfig.ST_TYPE_USE, String.valueOf(nanoTime)).start();
                    TiebaStatic.eventStat(TbadkApplication.m252getInst().getApp(), TbConfig.ST_TYPE_USE, null, 1, "st_param", String.valueOf(nanoTime));
                }
                this.a.mStartTime = 0L;
                break;
            case 5:
                if (Boolean.TRUE.equals(message.obj)) {
                    this.a.notifyAppEnterBackground();
                    break;
                } else {
                    this.a.notifyAppEnterForehead();
                    break;
                }
        }
        return false;
    }
}
