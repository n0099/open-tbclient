package com.baidu.tbadk;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.ai;
import com.baidu.tbadk.core.util.bb;
/* loaded from: classes.dex */
class a implements Handler.Callback {
    final /* synthetic */ TbadkApplication a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(TbadkApplication tbadkApplication) {
        this.a = tbadkApplication;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 1:
                BdLog.e("TiebaApplication", "handleMessage", "Do Aoto Login" + String.valueOf(message.what));
                TbadkApplication.setCurrentAccount(null, this.a.getContext());
                String string = message.getData().getString("account");
                if (string == null) {
                    string = "";
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new ai((Context) this.a, string, false, true)));
                break;
            case 4:
                long nanoTime = (((System.nanoTime() - this.a.mStartTime) / 1000000) - TbConfig.USE_TIME_INTERVAL) / 1000;
                if (nanoTime > 0) {
                    new bb(TbConfig.ST_TYPE_USE, String.valueOf(nanoTime)).start();
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
