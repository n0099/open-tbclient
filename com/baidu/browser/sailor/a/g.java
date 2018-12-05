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
    final /* synthetic */ c Wh;
    final /* synthetic */ String Wi;
    final /* synthetic */ String Wj;
    final /* synthetic */ String Wk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(c cVar, String str, String str2, String str3) {
        this.Wh = cVar;
        this.Wi = str;
        this.Wj = str2;
        this.Wk = str3;
    }

    @Override // java.lang.Runnable
    @SuppressLint({"InlinedApi"})
    public void run() {
        MediaRecorder mediaRecorder;
        n nVar = new n(this.Wi, this.Wj);
        nVar.a(this.Wh);
        mediaRecorder = this.Wh.Wa;
        if (mediaRecorder != null) {
            nVar.cA("Already in Recording , Please stop recording before start ");
            return;
        }
        this.Wh.qJ();
        MediaRecorder mediaRecorder2 = new MediaRecorder();
        mediaRecorder2.setAudioSource(1);
        if (Build.VERSION.SDK_INT >= 11) {
            mediaRecorder2.setOutputFormat(3);
        }
        mediaRecorder2.setAudioEncoder(1);
        File c = TextUtils.isEmpty(this.Wk) ? com.baidu.browser.sailor.feature.a.d.c(com.baidu.browser.sailor.b.a.qO().getAppContext().getCacheDir(), String.valueOf(System.currentTimeMillis()) + ".amr") : new File(com.baidu.browser.sailor.util.c.a(this.Wh.qH(), this.Wk));
        mediaRecorder2.setOutputFile(c.getAbsolutePath());
        this.Wh.Wc = c;
        try {
            mediaRecorder2.prepare();
            mediaRecorder2.start();
            this.Wh.Wa = mediaRecorder2;
            nVar.qN();
        } catch (IOException e) {
            e.printStackTrace();
            nVar.cA(e.getMessage());
            this.Wh.qJ();
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
            nVar.cA(e2.getMessage());
            this.Wh.qJ();
        }
    }
}
