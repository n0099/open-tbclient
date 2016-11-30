package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import com.baidu.adp.lib.util.StringUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ g ED;
    private final /* synthetic */ String EF;
    private final /* synthetic */ int EG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(g gVar, String str, int i) {
        this.ED = gVar;
        this.EF = str;
        this.EG = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        Handler handler2;
        Handler handler3;
        Handler handler4;
        String str = com.baidu.tbadk.core.voice.a.b.ee(com.baidu.tbadk.core.voice.i.ed(this.EF)).md5;
        handler = this.ED.mHandle;
        if (handler != null) {
            handler2 = this.ED.mHandle;
            handler2.removeCallbacks(this.ED.EC);
            if (StringUtils.isNull(str)) {
                handler4 = this.ED.mHandle;
                handler4.post(new k(this));
                return;
            }
            handler3 = this.ED.mHandle;
            handler3.post(new l(this, str, this.EG));
        }
    }
}
