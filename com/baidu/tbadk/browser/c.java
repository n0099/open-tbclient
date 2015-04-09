package com.baidu.tbadk.browser;

import android.os.Message;
import java.util.Timer;
import java.util.TimerTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends TimerTask {
    final /* synthetic */ BaseWebViewActivity Nn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(BaseWebViewActivity baseWebViewActivity) {
        this.Nn = baseWebViewActivity;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        Timer timer;
        Timer timer2;
        Message message = new Message();
        message.what = BaseWebViewActivity.TIME_OUT_MSG_CODE;
        this.Nn.mHandler.sendMessage(message);
        timer = this.Nn.mTimer;
        timer.cancel();
        timer2 = this.Nn.mTimer;
        timer2.purge();
    }
}
