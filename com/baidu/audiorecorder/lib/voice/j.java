package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import com.baidu.adp.lib.util.StringUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ g Lw;
    private final /* synthetic */ String Ly;
    private final /* synthetic */ int Lz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(g gVar, String str, int i) {
        this.Lw = gVar;
        this.Ly = str;
        this.Lz = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        Handler handler2;
        Handler handler3;
        Handler handler4;
        String str = com.baidu.tbadk.core.voice.a.b.dX(com.baidu.tbadk.core.voice.i.dW(this.Ly)).md5;
        handler = this.Lw.mHandle;
        if (handler != null) {
            handler2 = this.Lw.mHandle;
            handler2.removeCallbacks(this.Lw.Lv);
            if (StringUtils.isNull(str)) {
                handler4 = this.Lw.mHandle;
                handler4.post(new k(this));
                return;
            }
            handler3 = this.Lw.mHandle;
            handler3.post(new l(this, str, this.Lz));
        }
    }
}
