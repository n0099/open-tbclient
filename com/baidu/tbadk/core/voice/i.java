package com.baidu.tbadk.core.voice;

import android.os.Handler;
import com.baidu.adp.lib.util.StringUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {
    private final /* synthetic */ String IG;
    private final /* synthetic */ int IH;
    final /* synthetic */ VoiceManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(VoiceManager voiceManager, String str, int i) {
        this.this$0 = voiceManager;
        this.IG = str;
        this.IH = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        Handler handler2;
        Handler handler3;
        Handler handler4;
        String str = com.baidu.tbadk.core.voice.a.b.cg(r.cf(this.IG)).md5;
        handler = this.this$0.mHandle;
        if (handler != null) {
            handler2 = this.this$0.mHandle;
            handler2.removeCallbacks(this.this$0.stopingRecorderRunnable);
            if (StringUtils.isNull(str)) {
                handler4 = this.this$0.mHandle;
                handler4.post(new j(this));
                return;
            }
            handler3 = this.this$0.mHandle;
            handler3.post(new k(this, str, this.IH));
        }
    }
}
