package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import com.baidu.adp.lib.util.StringUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ g Lp;
    private final /* synthetic */ String Lr;
    private final /* synthetic */ int Ls;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(g gVar, String str, int i) {
        this.Lp = gVar;
        this.Lr = str;
        this.Ls = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        Handler handler2;
        Handler handler3;
        Handler handler4;
        String str = com.baidu.tbadk.core.voice.a.b.dQ(com.baidu.tbadk.core.voice.i.dP(this.Lr)).md5;
        handler = this.Lp.mHandle;
        if (handler != null) {
            handler2 = this.Lp.mHandle;
            handler2.removeCallbacks(this.Lp.Lo);
            if (StringUtils.isNull(str)) {
                handler4 = this.Lp.mHandle;
                handler4.post(new k(this));
                return;
            }
            handler3 = this.Lp.mHandle;
            handler3.post(new l(this, str, this.Ls));
        }
    }
}
