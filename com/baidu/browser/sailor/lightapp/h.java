package com.baidu.browser.sailor.lightapp;

import android.annotation.SuppressLint;
import android.media.MediaRecorder;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.browser.sailor.platform.BdSailorPlatform;
import com.baidu.webkit.sdk.WebKitFactory;
import java.io.File;
import java.io.IOException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class h implements Runnable {
    final /* synthetic */ BdLightappKernelClient adq;
    final /* synthetic */ String ads;
    final /* synthetic */ String adt;
    final /* synthetic */ String adu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(BdLightappKernelClient bdLightappKernelClient, String str, String str2, String str3) {
        this.adq = bdLightappKernelClient;
        this.ads = str;
        this.adt = str2;
        this.adu = str3;
    }

    @Override // java.lang.Runnable
    @SuppressLint({"InlinedApi"})
    public void run() {
        MediaRecorder mediaRecorder;
        File file;
        File file2 = null;
        BdLightappKernelJsCallback bdLightappKernelJsCallback = new BdLightappKernelJsCallback(this.ads, this.adt);
        bdLightappKernelJsCallback.setCallbackListener(this.adq);
        mediaRecorder = this.adq.mRecorder;
        if (mediaRecorder != null) {
            bdLightappKernelJsCallback.sendFailCallBack("Already in Recording , Please stop recording before start ");
            return;
        }
        this.adq.resetRecorder();
        MediaRecorder mediaRecorder2 = new MediaRecorder();
        mediaRecorder2.setAudioSource(1);
        if (Build.VERSION.SDK_INT >= 11) {
            mediaRecorder2.setOutputFormat(3);
        }
        mediaRecorder2.setAudioEncoder(1);
        if (TextUtils.isEmpty(this.adu)) {
            String str = String.valueOf(System.currentTimeMillis()) + ".amr";
            File cacheDir = BdSailorPlatform.getInstance().getAppContext().getCacheDir();
            if (com.baidu.browser.sailor.util.b.a()) {
                File file3 = WebKitFactory.getContext() != null ? new File(WebKitFactory.getContext().getExternalFilesDir(""), "/baidu/SearchBox/com.baidu.searchbox.plugins.xsearch") : null;
                file = com.baidu.browser.sailor.util.b.a(file3) ? new File(file3, "lightapp_rec") : null;
            } else {
                File file4 = new File(cacheDir, BdLightappConstants.PLUGIN_PACKAGE_NAME);
                com.baidu.browser.sailor.util.b.a(file4);
                file = new File(file4, "lightapp_rec");
            }
            if (file != null && com.baidu.browser.sailor.util.b.a(file)) {
                file2 = new File(file, str);
            }
        } else {
            file2 = new File(com.baidu.browser.sailor.util.b.a(this.adq.getPaivateDir(), this.adu));
        }
        mediaRecorder2.setOutputFile(file2.getAbsolutePath());
        this.adq.mRecordingFile = file2;
        try {
            mediaRecorder2.prepare();
            mediaRecorder2.start();
            this.adq.mRecorder = mediaRecorder2;
            bdLightappKernelJsCallback.sendSuccCallBack();
        } catch (IOException e) {
            e.printStackTrace();
            bdLightappKernelJsCallback.sendFailCallBack(e.getMessage());
            this.adq.resetRecorder();
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
            bdLightappKernelJsCallback.sendFailCallBack(e2.getMessage());
            this.adq.resetRecorder();
        }
    }
}
