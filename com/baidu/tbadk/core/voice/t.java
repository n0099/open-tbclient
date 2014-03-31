package com.baidu.tbadk.core.voice;

import android.os.Handler;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.switchs.features.VoiceSwitchStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class t implements Runnable {
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
    public final void run() {
        Handler handler;
        Handler handler2;
        Handler handler3;
        Handler handler4;
        String a = com.baidu.adp.lib.util.c.a(ad.a(this.b));
        com.baidu.tbadk.core.voice.cache.d dVar = new com.baidu.tbadk.core.voice.cache.d();
        if (a == null) {
            dVar.c = 6;
            dVar.d = com.baidu.tbadk.core.voice.cache.d.a(dVar.c);
        } else if (com.baidu.tbadk.core.util.w.a(String.valueOf(com.baidu.tbadk.core.util.w.d()) + VoiceSwitchStatic.VOICE)) {
            String a2 = bc.a(com.baidu.tbadk.core.util.w.i(a));
            if (a2 == null) {
                dVar.c = 5;
                dVar.d = com.baidu.tbadk.core.voice.cache.d.a(dVar.c);
            } else {
                String a3 = com.baidu.tbadk.core.util.w.a(a2, 1, true);
                if (com.baidu.tbadk.core.util.w.g(a, a3)) {
                    dVar.b = a3;
                    dVar.a = a2;
                } else {
                    dVar.c = 1;
                    dVar.d = com.baidu.tbadk.core.voice.cache.d.a(dVar.c);
                }
            }
        } else {
            dVar.c = 7;
            dVar.d = com.baidu.tbadk.core.voice.cache.d.a(dVar.c);
        }
        String str = dVar.a;
        handler = this.a.p;
        if (handler != null) {
            handler2 = this.a.p;
            handler2.removeCallbacks(this.a.c);
            if (com.baidu.adp.lib.util.n.a(str)) {
                handler4 = this.a.p;
                handler4.post(new u(this));
                return;
            }
            handler3 = this.a.p;
            handler3.post(new v(this, str, this.c));
        }
    }
}
