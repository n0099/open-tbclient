package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import com.baidu.adp.lib.util.StringUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ g Co;
    private final /* synthetic */ String Cq;
    private final /* synthetic */ int Cr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(g gVar, String str, int i) {
        this.Co = gVar;
        this.Cq = str;
        this.Cr = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        Handler handler2;
        Handler handler3;
        Handler handler4;
        String str = com.baidu.tbadk.core.voice.a.b.dW(com.baidu.tbadk.core.voice.i.dV(this.Cq)).md5;
        handler = this.Co.mHandle;
        if (handler != null) {
            handler2 = this.Co.mHandle;
            handler2.removeCallbacks(this.Co.Cn);
            if (StringUtils.isNull(str)) {
                handler4 = this.Co.mHandle;
                handler4.post(new k(this));
                return;
            }
            handler3 = this.Co.mHandle;
            handler3.post(new l(this, str, this.Cr));
        }
    }
}
