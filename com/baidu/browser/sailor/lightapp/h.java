package com.baidu.browser.sailor.lightapp;

import android.annotation.SuppressLint;
import android.media.MediaRecorder;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.browser.sailor.platform.BdSailorPlatform;
import java.io.File;
import java.io.IOException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class h implements Runnable {
    final /* synthetic */ BdLightappKernelClient Jm;
    final /* synthetic */ String Jo;
    final /* synthetic */ String Jp;
    final /* synthetic */ String Jq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(BdLightappKernelClient bdLightappKernelClient, String str, String str2, String str3) {
        this.Jm = bdLightappKernelClient;
        this.Jo = str;
        this.Jp = str2;
        this.Jq = str3;
    }

    @Override // java.lang.Runnable
    @SuppressLint({"InlinedApi"})
    public void run() {
        MediaRecorder mediaRecorder;
        BdLightappKernelJsCallback bdLightappKernelJsCallback = new BdLightappKernelJsCallback(this.Jo, this.Jp);
        bdLightappKernelJsCallback.setCallbackListener(this.Jm);
        mediaRecorder = this.Jm.mRecorder;
        if (mediaRecorder != null) {
            bdLightappKernelJsCallback.sendFailCallBack("Already in Recording , Please stop recording before start ");
            return;
        }
        this.Jm.resetRecorder();
        MediaRecorder mediaRecorder2 = new MediaRecorder();
        mediaRecorder2.setAudioSource(1);
        if (Build.VERSION.SDK_INT >= 11) {
            mediaRecorder2.setOutputFormat(3);
        }
        mediaRecorder2.setAudioEncoder(1);
        File a = TextUtils.isEmpty(this.Jq) ? com.baidu.browser.sailor.feature.a.d.a(BdSailorPlatform.getInstance().getAppContext().getCacheDir(), String.valueOf(System.currentTimeMillis()) + ".amr") : new File(com.baidu.browser.sailor.util.b.a(this.Jm.getPaivateDir(), this.Jq));
        mediaRecorder2.setOutputFile(a.getAbsolutePath());
        this.Jm.mRecordingFile = a;
        try {
            mediaRecorder2.prepare();
            mediaRecorder2.start();
            this.Jm.mRecorder = mediaRecorder2;
            bdLightappKernelJsCallback.sendSuccCallBack();
        } catch (IOException e) {
            e.printStackTrace();
            bdLightappKernelJsCallback.sendFailCallBack(e.getMessage());
            this.Jm.resetRecorder();
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
            bdLightappKernelJsCallback.sendFailCallBack(e2.getMessage());
            this.Jm.resetRecorder();
        }
    }
}
