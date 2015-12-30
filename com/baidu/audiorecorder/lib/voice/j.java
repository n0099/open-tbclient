package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import com.baidu.adp.lib.util.StringUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ g La;
    private final /* synthetic */ String Lc;
    private final /* synthetic */ int Ld;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(g gVar, String str, int i) {
        this.La = gVar;
        this.Lc = str;
        this.Ld = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        Handler handler2;
        Handler handler3;
        Handler handler4;
        String str = com.baidu.tbadk.core.voice.a.b.dR(com.baidu.tbadk.core.voice.h.dQ(this.Lc)).md5;
        handler = this.La.mHandle;
        if (handler != null) {
            handler2 = this.La.mHandle;
            handler2.removeCallbacks(this.La.KZ);
            if (StringUtils.isNull(str)) {
                handler4 = this.La.mHandle;
                handler4.post(new k(this));
                return;
            }
            handler3 = this.La.mHandle;
            handler3.post(new l(this, str, this.Ld));
        }
    }
}
