package com.baidu.tbadk.browser;

import android.os.Message;
import java.util.Timer;
import java.util.TimerTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends TimerTask {
    final /* synthetic */ BaseWebViewActivity Nl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(BaseWebViewActivity baseWebViewActivity) {
        this.Nl = baseWebViewActivity;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        Timer timer;
        Timer timer2;
        Message message = new Message();
        message.what = BaseWebViewActivity.TIME_OUT_MSG_CODE;
        this.Nl.mHandler.sendMessage(message);
        timer = this.Nl.mTimer;
        timer.cancel();
        timer2 = this.Nl.mTimer;
        timer2.purge();
    }
}
