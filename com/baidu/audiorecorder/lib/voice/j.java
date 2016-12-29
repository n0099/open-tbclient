package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import com.baidu.adp.lib.util.StringUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ g EE;
    private final /* synthetic */ String EG;
    private final /* synthetic */ int EH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(g gVar, String str, int i) {
        this.EE = gVar;
        this.EG = str;
        this.EH = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        Handler handler2;
        Handler handler3;
        Handler handler4;
        String str = com.baidu.tbadk.core.voice.a.b.eb(com.baidu.tbadk.core.voice.i.ea(this.EG)).md5;
        handler = this.EE.mHandle;
        if (handler != null) {
            handler2 = this.EE.mHandle;
            handler2.removeCallbacks(this.EE.ED);
            if (StringUtils.isNull(str)) {
                handler4 = this.EE.mHandle;
                handler4.post(new k(this));
                return;
            }
            handler3 = this.EE.mHandle;
            handler3.post(new l(this, str, this.EH));
        }
    }
}
