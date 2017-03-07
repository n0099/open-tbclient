package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import com.baidu.adp.lib.util.StringUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ g Ld;
    private final /* synthetic */ String Lf;
    private final /* synthetic */ int Lg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(g gVar, String str, int i) {
        this.Ld = gVar;
        this.Lf = str;
        this.Lg = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        Handler handler2;
        Handler handler3;
        Handler handler4;
        String str = com.baidu.tbadk.core.voice.a.b.dT(com.baidu.tbadk.core.voice.i.dS(this.Lf)).md5;
        handler = this.Ld.mHandle;
        if (handler != null) {
            handler2 = this.Ld.mHandle;
            handler2.removeCallbacks(this.Ld.Lc);
            if (StringUtils.isNull(str)) {
                handler4 = this.Ld.mHandle;
                handler4.post(new k(this));
                return;
            }
            handler3 = this.Ld.mHandle;
            handler3.post(new l(this, str, this.Lg));
        }
    }
}
