package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import com.baidu.adp.lib.util.StringUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ g Ku;
    private final /* synthetic */ String Kw;
    private final /* synthetic */ int Kx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(g gVar, String str, int i) {
        this.Ku = gVar;
        this.Kw = str;
        this.Kx = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        Handler handler2;
        Handler handler3;
        Handler handler4;
        String str = com.baidu.tbadk.core.voice.a.b.dd(com.baidu.tbadk.core.voice.l.dc(this.Kw)).md5;
        handler = this.Ku.mHandle;
        if (handler != null) {
            handler2 = this.Ku.mHandle;
            handler2.removeCallbacks(this.Ku.Kt);
            if (StringUtils.isNull(str)) {
                handler4 = this.Ku.mHandle;
                handler4.post(new k(this));
                return;
            }
            handler3 = this.Ku.mHandle;
            handler3.post(new l(this, str, this.Kx));
        }
    }
}
