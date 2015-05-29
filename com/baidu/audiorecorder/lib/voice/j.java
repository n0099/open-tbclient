package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import com.baidu.adp.lib.util.StringUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ g Ko;
    private final /* synthetic */ String Kq;
    private final /* synthetic */ int Kr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(g gVar, String str, int i) {
        this.Ko = gVar;
        this.Kq = str;
        this.Kr = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        Handler handler2;
        Handler handler3;
        Handler handler4;
        String str = com.baidu.tbadk.core.voice.a.b.du(com.baidu.tbadk.core.voice.l.dt(this.Kq)).md5;
        handler = this.Ko.mHandle;
        if (handler != null) {
            handler2 = this.Ko.mHandle;
            handler2.removeCallbacks(this.Ko.Kn);
            if (StringUtils.isNull(str)) {
                handler4 = this.Ko.mHandle;
                handler4.post(new k(this));
                return;
            }
            handler3 = this.Ko.mHandle;
            handler3.post(new l(this, str, this.Kr));
        }
    }
}
