package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import com.baidu.adp.lib.util.StringUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ g KG;
    private final /* synthetic */ String KI;
    private final /* synthetic */ int KJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(g gVar, String str, int i) {
        this.KG = gVar;
        this.KI = str;
        this.KJ = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        Handler handler2;
        Handler handler3;
        Handler handler4;
        String str = com.baidu.tbadk.core.voice.a.b.dZ(com.baidu.tbadk.core.voice.i.dY(this.KI)).md5;
        handler = this.KG.mHandle;
        if (handler != null) {
            handler2 = this.KG.mHandle;
            handler2.removeCallbacks(this.KG.KF);
            if (StringUtils.isNull(str)) {
                handler4 = this.KG.mHandle;
                handler4.post(new k(this));
                return;
            }
            handler3 = this.KG.mHandle;
            handler3.post(new l(this, str, this.KJ));
        }
    }
}
