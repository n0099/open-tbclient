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
/* loaded from: classes8.dex */
public class h implements Runnable {
    final /* synthetic */ BdLightappKernelClient adk;
    final /* synthetic */ String adm;
    final /* synthetic */ String adn;
    final /* synthetic */ String ado;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(BdLightappKernelClient bdLightappKernelClient, String str, String str2, String str3) {
        this.adk = bdLightappKernelClient;
        this.adm = str;
        this.adn = str2;
        this.ado = str3;
    }

    @Override // java.lang.Runnable
    @SuppressLint({"InlinedApi"})
    public void run() {
        MediaRecorder mediaRecorder;
        File file;
        File file2 = null;
        BdLightappKernelJsCallback bdLightappKernelJsCallback = new BdLightappKernelJsCallback(this.adm, this.adn);
        bdLightappKernelJsCallback.setCallbackListener(this.adk);
        mediaRecorder = this.adk.mRecorder;
        if (mediaRecorder != null) {
            bdLightappKernelJsCallback.sendFailCallBack("Already in Recording , Please stop recording before start ");
            return;
        }
        this.adk.resetRecorder();
        MediaRecorder mediaRecorder2 = new MediaRecorder();
        mediaRecorder2.setAudioSource(1);
        if (Build.VERSION.SDK_INT >= 11) {
            mediaRecorder2.setOutputFormat(3);
        }
        mediaRecorder2.setAudioEncoder(1);
        if (TextUtils.isEmpty(this.ado)) {
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
            file2 = new File(com.baidu.browser.sailor.util.b.a(this.adk.getPaivateDir(), this.ado));
        }
        mediaRecorder2.setOutputFile(file2.getAbsolutePath());
        this.adk.mRecordingFile = file2;
        try {
            mediaRecorder2.prepare();
            mediaRecorder2.start();
            this.adk.mRecorder = mediaRecorder2;
            bdLightappKernelJsCallback.sendSuccCallBack();
        } catch (IOException e) {
            e.printStackTrace();
            bdLightappKernelJsCallback.sendFailCallBack(e.getMessage());
            this.adk.resetRecorder();
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
            bdLightappKernelJsCallback.sendFailCallBack(e2.getMessage());
            this.adk.resetRecorder();
        }
    }
}
