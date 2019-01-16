package com.baidu.browser.sailor.a;

import android.annotation.SuppressLint;
import android.media.MediaRecorder;
import android.os.Build;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class g implements Runnable {
    final /* synthetic */ c Wq;
    final /* synthetic */ String Wr;
    final /* synthetic */ String Ws;
    final /* synthetic */ String Wt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(c cVar, String str, String str2, String str3) {
        this.Wq = cVar;
        this.Wr = str;
        this.Ws = str2;
        this.Wt = str3;
    }

    @Override // java.lang.Runnable
    @SuppressLint({"InlinedApi"})
    public void run() {
        MediaRecorder mediaRecorder;
        n nVar = new n(this.Wr, this.Ws);
        nVar.a(this.Wq);
        mediaRecorder = this.Wq.Wj;
        if (mediaRecorder != null) {
            nVar.cB("Already in Recording , Please stop recording before start ");
            return;
        }
        this.Wq.qN();
        MediaRecorder mediaRecorder2 = new MediaRecorder();
        mediaRecorder2.setAudioSource(1);
        if (Build.VERSION.SDK_INT >= 11) {
            mediaRecorder2.setOutputFormat(3);
        }
        mediaRecorder2.setAudioEncoder(1);
        File c = TextUtils.isEmpty(this.Wt) ? com.baidu.browser.sailor.feature.a.d.c(com.baidu.browser.sailor.b.a.qS().getAppContext().getCacheDir(), String.valueOf(System.currentTimeMillis()) + ".amr") : new File(com.baidu.browser.sailor.util.c.a(this.Wq.qL(), this.Wt));
        mediaRecorder2.setOutputFile(c.getAbsolutePath());
        this.Wq.Wl = c;
        try {
            mediaRecorder2.prepare();
            mediaRecorder2.start();
            this.Wq.Wj = mediaRecorder2;
            nVar.qR();
        } catch (IOException e) {
            e.printStackTrace();
            nVar.cB(e.getMessage());
            this.Wq.qN();
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
            nVar.cB(e2.getMessage());
            this.Wq.qN();
        }
    }
}
