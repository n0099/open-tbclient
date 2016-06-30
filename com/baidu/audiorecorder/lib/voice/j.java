package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import com.baidu.adp.lib.util.StringUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ g BO;
    private final /* synthetic */ String BQ;
    private final /* synthetic */ int BR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(g gVar, String str, int i) {
        this.BO = gVar;
        this.BQ = str;
        this.BR = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        Handler handler2;
        Handler handler3;
        Handler handler4;
        String str = com.baidu.tbadk.core.voice.a.b.dX(com.baidu.tbadk.core.voice.i.dW(this.BQ)).md5;
        handler = this.BO.mHandle;
        if (handler != null) {
            handler2 = this.BO.mHandle;
            handler2.removeCallbacks(this.BO.BN);
            if (StringUtils.isNull(str)) {
                handler4 = this.BO.mHandle;
                handler4.post(new k(this));
                return;
            }
            handler3 = this.BO.mHandle;
            handler3.post(new l(this, str, this.BR));
        }
    }
}
