package com.baidu.tbadk.browser;

import android.os.Message;
import java.util.Timer;
import java.util.TimerTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends TimerTask {
    final /* synthetic */ BaseWebViewActivity Sl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(BaseWebViewActivity baseWebViewActivity) {
        this.Sl = baseWebViewActivity;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        Timer timer;
        Timer timer2;
        Timer timer3;
        Message message = new Message();
        message.what = BaseWebViewActivity.TIME_OUT_MSG_CODE;
        this.Sl.mHandler.sendMessage(message);
        timer = this.Sl.mTimer;
        if (timer != null) {
            timer2 = this.Sl.mTimer;
            timer2.cancel();
            timer3 = this.Sl.mTimer;
            timer3.purge();
        }
    }
}
