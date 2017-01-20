package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import com.baidu.adp.lib.util.StringUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ g DP;
    private final /* synthetic */ String DR;
    private final /* synthetic */ int DS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(g gVar, String str, int i) {
        this.DP = gVar;
        this.DR = str;
        this.DS = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        Handler handler2;
        Handler handler3;
        Handler handler4;
        String str = com.baidu.tbadk.core.voice.a.b.dZ(com.baidu.tbadk.core.voice.i.dY(this.DR)).md5;
        handler = this.DP.mHandle;
        if (handler != null) {
            handler2 = this.DP.mHandle;
            handler2.removeCallbacks(this.DP.DO);
            if (StringUtils.isNull(str)) {
                handler4 = this.DP.mHandle;
                handler4.post(new k(this));
                return;
            }
            handler3 = this.DP.mHandle;
            handler3.post(new l(this, str, this.DS));
        }
    }
}
