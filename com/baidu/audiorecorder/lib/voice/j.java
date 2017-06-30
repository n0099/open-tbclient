package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import com.baidu.adp.lib.util.StringUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class j implements Runnable {
    final /* synthetic */ g JL;
    private final /* synthetic */ String JN;
    private final /* synthetic */ int JO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(g gVar, String str, int i) {
        this.JL = gVar;
        this.JN = str;
        this.JO = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        Handler handler2;
        Handler handler3;
        Handler handler4;
        String str = com.baidu.tbadk.core.voice.a.b.eq(com.baidu.tbadk.core.voice.i.ep(this.JN)).md5;
        handler = this.JL.mHandle;
        if (handler != null) {
            handler2 = this.JL.mHandle;
            handler2.removeCallbacks(this.JL.JK);
            if (StringUtils.isNull(str)) {
                handler4 = this.JL.mHandle;
                handler4.post(new k(this));
                return;
            }
            handler3 = this.JL.mHandle;
            handler3.post(new l(this, str, this.JO));
        }
    }
}
