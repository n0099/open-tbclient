package com.baidu.tbadk.core.voice;

import android.media.AudioTrack;
import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.util.BdLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        AudioTrack audioTrack;
        AudioTrack audioTrack2;
        int i;
        Handler handler;
        Runnable runnable;
        Handler handler2;
        int i2;
        Handler handler3;
        audioTrack = this.a.b;
        if (audioTrack != null) {
            audioTrack2 = this.a.b;
            if (audioTrack2.getPlayState() == 3) {
                int a = this.a.a() + 0;
                BdLog.d(getClass(), "TestVoice2", "elapsedTime=" + a);
                i = this.a.i;
                if (a != i) {
                    this.a.i = a;
                    handler2 = this.a.f;
                    Message obtainMessage = handler2.obtainMessage(6);
                    i2 = this.a.i;
                    obtainMessage.arg1 = i2;
                    handler3 = this.a.f;
                    handler3.sendMessage(obtainMessage);
                }
                handler = this.a.j;
                runnable = this.a.k;
                handler.postDelayed(runnable, 100L);
            }
        }
    }
}
