package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import com.baidu.adp.lib.util.StringUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ g BN;
    private final /* synthetic */ String BP;
    private final /* synthetic */ int BQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(g gVar, String str, int i) {
        this.BN = gVar;
        this.BP = str;
        this.BQ = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        Handler handler2;
        Handler handler3;
        Handler handler4;
        String str = com.baidu.tbadk.core.voice.a.b.dT(com.baidu.tbadk.core.voice.i.dS(this.BP)).md5;
        handler = this.BN.mHandle;
        if (handler != null) {
            handler2 = this.BN.mHandle;
            handler2.removeCallbacks(this.BN.BM);
            if (StringUtils.isNull(str)) {
                handler4 = this.BN.mHandle;
                handler4.post(new k(this));
                return;
            }
            handler3 = this.BN.mHandle;
            handler3.post(new l(this, str, this.BQ));
        }
    }
}
