package com.baidu.tbadk.core.voice;

import android.os.Handler;
import com.baidu.adp.lib.util.StringUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements Runnable {
    final /* synthetic */ VoiceManager a;
    private final /* synthetic */ String b;
    private final /* synthetic */ int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(VoiceManager voiceManager, String str, int i) {
        this.a = voiceManager;
        this.b = str;
        this.c = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        Handler handler2;
        Handler handler3;
        Handler handler4;
        String str = com.baidu.tbadk.core.voice.a.e.a(ad.c(this.b)).a;
        handler = this.a.s;
        if (handler != null) {
            handler2 = this.a.s;
            handler2.removeCallbacks(this.a.c);
            if (StringUtils.isNull(str)) {
                handler4 = this.a.s;
                handler4.post(new u(this));
                return;
            }
            handler3 = this.a.s;
            handler3.post(new v(this, str, this.c));
        }
    }
}
