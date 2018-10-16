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
    final /* synthetic */ c Wf;
    final /* synthetic */ String Wg;
    final /* synthetic */ String Wh;
    final /* synthetic */ String Wi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(c cVar, String str, String str2, String str3) {
        this.Wf = cVar;
        this.Wg = str;
        this.Wh = str2;
        this.Wi = str3;
    }

    @Override // java.lang.Runnable
    @SuppressLint({"InlinedApi"})
    public void run() {
        MediaRecorder mediaRecorder;
        n nVar = new n(this.Wg, this.Wh);
        nVar.a(this.Wf);
        mediaRecorder = this.Wf.VY;
        if (mediaRecorder != null) {
            nVar.cA("Already in Recording , Please stop recording before start ");
            return;
        }
        this.Wf.qM();
        MediaRecorder mediaRecorder2 = new MediaRecorder();
        mediaRecorder2.setAudioSource(1);
        if (Build.VERSION.SDK_INT >= 11) {
            mediaRecorder2.setOutputFormat(3);
        }
        mediaRecorder2.setAudioEncoder(1);
        File c = TextUtils.isEmpty(this.Wi) ? com.baidu.browser.sailor.feature.a.d.c(com.baidu.browser.sailor.b.a.qR().getAppContext().getCacheDir(), String.valueOf(System.currentTimeMillis()) + ".amr") : new File(com.baidu.browser.sailor.util.c.a(this.Wf.qK(), this.Wi));
        mediaRecorder2.setOutputFile(c.getAbsolutePath());
        this.Wf.Wa = c;
        try {
            mediaRecorder2.prepare();
            mediaRecorder2.start();
            this.Wf.VY = mediaRecorder2;
            nVar.qQ();
        } catch (IOException e) {
            e.printStackTrace();
            nVar.cA(e.getMessage());
            this.Wf.qM();
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
            nVar.cA(e2.getMessage());
            this.Wf.qM();
        }
    }
}
