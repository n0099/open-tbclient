package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import com.baidu.adp.lib.util.StringUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ g KE;
    private final /* synthetic */ String KG;
    private final /* synthetic */ int KH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(g gVar, String str, int i) {
        this.KE = gVar;
        this.KG = str;
        this.KH = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        Handler handler2;
        Handler handler3;
        Handler handler4;
        String str = com.baidu.tbadk.core.voice.a.b.dZ(com.baidu.tbadk.core.voice.i.dY(this.KG)).md5;
        handler = this.KE.mHandle;
        if (handler != null) {
            handler2 = this.KE.mHandle;
            handler2.removeCallbacks(this.KE.KD);
            if (StringUtils.isNull(str)) {
                handler4 = this.KE.mHandle;
                handler4.post(new k(this));
                return;
            }
            handler3 = this.KE.mHandle;
            handler3.post(new l(this, str, this.KH));
        }
    }
}
