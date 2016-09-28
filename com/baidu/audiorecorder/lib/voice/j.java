package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import com.baidu.adp.lib.util.StringUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ g EB;
    private final /* synthetic */ String ED;
    private final /* synthetic */ int EE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(g gVar, String str, int i) {
        this.EB = gVar;
        this.ED = str;
        this.EE = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        Handler handler2;
        Handler handler3;
        Handler handler4;
        String str = com.baidu.tbadk.core.voice.a.b.ec(com.baidu.tbadk.core.voice.i.eb(this.ED)).md5;
        handler = this.EB.mHandle;
        if (handler != null) {
            handler2 = this.EB.mHandle;
            handler2.removeCallbacks(this.EB.EA);
            if (StringUtils.isNull(str)) {
                handler4 = this.EB.mHandle;
                handler4.post(new k(this));
                return;
            }
            handler3 = this.EB.mHandle;
            handler3.post(new l(this, str, this.EE));
        }
    }
}
