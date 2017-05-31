package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import com.baidu.adp.lib.util.StringUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class j implements Runnable {
    final /* synthetic */ g JM;
    private final /* synthetic */ String JO;
    private final /* synthetic */ int JP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(g gVar, String str, int i) {
        this.JM = gVar;
        this.JO = str;
        this.JP = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        Handler handler2;
        Handler handler3;
        Handler handler4;
        String str = com.baidu.tbadk.core.voice.a.b.dW(com.baidu.tbadk.core.voice.i.dV(this.JO)).md5;
        handler = this.JM.mHandle;
        if (handler != null) {
            handler2 = this.JM.mHandle;
            handler2.removeCallbacks(this.JM.JL);
            if (StringUtils.isNull(str)) {
                handler4 = this.JM.mHandle;
                handler4.post(new k(this));
                return;
            }
            handler3 = this.JM.mHandle;
            handler3.post(new l(this, str, this.JP));
        }
    }
}
