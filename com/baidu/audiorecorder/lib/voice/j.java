package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import com.baidu.adp.lib.util.StringUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ g KK;
    private final /* synthetic */ String KM;
    private final /* synthetic */ int KN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(g gVar, String str, int i) {
        this.KK = gVar;
        this.KM = str;
        this.KN = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        Handler handler2;
        Handler handler3;
        Handler handler4;
        String str = com.baidu.tbadk.core.voice.a.b.dO(com.baidu.tbadk.core.voice.h.dN(this.KM)).md5;
        handler = this.KK.mHandle;
        if (handler != null) {
            handler2 = this.KK.mHandle;
            handler2.removeCallbacks(this.KK.KJ);
            if (StringUtils.isNull(str)) {
                handler4 = this.KK.mHandle;
                handler4.post(new k(this));
                return;
            }
            handler3 = this.KK.mHandle;
            handler3.post(new l(this, str, this.KN));
        }
    }
}
