package com.baidu.tbadk.browser;

import android.os.Message;
import java.util.Timer;
import java.util.TimerTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends TimerTask {
    final /* synthetic */ BaseWebViewActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(BaseWebViewActivity baseWebViewActivity) {
        this.this$0 = baseWebViewActivity;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        Timer timer;
        Timer timer2;
        Timer timer3;
        Message message = new Message();
        message.what = BaseWebViewActivity.TIME_OUT_MSG_CODE;
        this.this$0.mHandler.sendMessage(message);
        timer = this.this$0.mTimer;
        if (timer != null) {
            timer2 = this.this$0.mTimer;
            timer2.cancel();
            timer3 = this.this$0.mTimer;
            timer3.purge();
        }
    }
}
