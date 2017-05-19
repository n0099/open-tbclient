package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import com.baidu.adp.lib.util.StringUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class j implements Runnable {
    final /* synthetic */ g JY;
    private final /* synthetic */ String Ka;
    private final /* synthetic */ int Kb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(g gVar, String str, int i) {
        this.JY = gVar;
        this.Ka = str;
        this.Kb = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        Handler handler2;
        Handler handler3;
        Handler handler4;
        String str = com.baidu.tbadk.core.voice.a.b.dY(com.baidu.tbadk.core.voice.i.dX(this.Ka)).md5;
        handler = this.JY.mHandle;
        if (handler != null) {
            handler2 = this.JY.mHandle;
            handler2.removeCallbacks(this.JY.JX);
            if (StringUtils.isNull(str)) {
                handler4 = this.JY.mHandle;
                handler4.post(new k(this));
                return;
            }
            handler3 = this.JY.mHandle;
            handler3.post(new l(this, str, this.Kb));
        }
    }
}
