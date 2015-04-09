package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import com.baidu.adp.lib.util.StringUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ g Kw;
    private final /* synthetic */ String Ky;
    private final /* synthetic */ int Kz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(g gVar, String str, int i) {
        this.Kw = gVar;
        this.Ky = str;
        this.Kz = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        Handler handler2;
        Handler handler3;
        Handler handler4;
        String str = com.baidu.tbadk.core.voice.a.b.dd(com.baidu.tbadk.core.voice.l.dc(this.Ky)).md5;
        handler = this.Kw.mHandle;
        if (handler != null) {
            handler2 = this.Kw.mHandle;
            handler2.removeCallbacks(this.Kw.Kv);
            if (StringUtils.isNull(str)) {
                handler4 = this.Kw.mHandle;
                handler4.post(new k(this));
                return;
            }
            handler3 = this.Kw.mHandle;
            handler3.post(new l(this, str, this.Kz));
        }
    }
}
