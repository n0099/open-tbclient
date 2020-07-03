package com.baidu.browser.sailor.lightapp;

import android.media.MediaRecorder;
import com.baidu.android.util.media.MimeType;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class i implements Runnable {
    final /* synthetic */ BdLightappKernelClient adq;
    final /* synthetic */ String ads;
    final /* synthetic */ String adt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(BdLightappKernelClient bdLightappKernelClient, String str, String str2) {
        this.adq = bdLightappKernelClient;
        this.ads = str;
        this.adt = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        MediaRecorder mediaRecorder;
        File file;
        File file2;
        MediaRecorder mediaRecorder2;
        MediaRecorder mediaRecorder3;
        MediaRecorder mediaRecorder4;
        File file3;
        File file4;
        File file5;
        File file6;
        File file7;
        File file8;
        File file9;
        File file10;
        File file11;
        File file12;
        BdLightappKernelJsCallback bdLightappKernelJsCallback = new BdLightappKernelJsCallback(this.ads, this.adt);
        bdLightappKernelJsCallback.setCallbackListener(this.adq);
        mediaRecorder = this.adq.mRecorder;
        if (mediaRecorder != null) {
            file = this.adq.mRecordingFile;
            if (file != null) {
                file2 = this.adq.mRecordingFile;
                if (file2.exists()) {
                    mediaRecorder2 = this.adq.mRecorder;
                    mediaRecorder2.stop();
                    mediaRecorder3 = this.adq.mRecorder;
                    mediaRecorder3.reset();
                    mediaRecorder4 = this.adq.mRecorder;
                    mediaRecorder4.release();
                    file3 = this.adq.mRecordFile;
                    if (file3 != null) {
                        file11 = this.adq.mRecordFile;
                        if (file11.exists()) {
                            file12 = this.adq.mRecordFile;
                            file12.delete();
                        }
                    }
                    BdLightappKernelClient bdLightappKernelClient = this.adq;
                    file4 = this.adq.mRecordingFile;
                    bdLightappKernelClient.mRecordFile = file4;
                    this.adq.mRecordingFile = null;
                    this.adq.mRecorder = null;
                    bdLightappKernelJsCallback.setResult(true);
                    file5 = this.adq.mRecordFile;
                    bdLightappKernelJsCallback.addField("path", file5.getAbsolutePath());
                    file6 = this.adq.mRecordFile;
                    bdLightappKernelJsCallback.addField("record_length", String.valueOf(file6.length()));
                    file7 = this.adq.mRecordFile;
                    bdLightappKernelJsCallback.addField("fullPath", file7.getAbsolutePath());
                    file8 = this.adq.mRecordFile;
                    bdLightappKernelJsCallback.addField("name", file8.getName());
                    file9 = this.adq.mRecordFile;
                    bdLightappKernelJsCallback.addField(TiebaInitialize.LogFields.SIZE, String.valueOf(file9.length()));
                    file10 = this.adq.mRecordFile;
                    bdLightappKernelJsCallback.addField("lastModified", String.valueOf(file10.lastModified()));
                    bdLightappKernelJsCallback.addField("type", MimeType.Audio.AMR);
                    bdLightappKernelJsCallback.addField("height", "0");
                    bdLightappKernelJsCallback.addField("width", "0");
                    bdLightappKernelJsCallback.addField("duration", "0");
                    bdLightappKernelJsCallback.notifyResult();
                }
            }
        }
        bdLightappKernelJsCallback.setResult(false);
        bdLightappKernelJsCallback.notifyResult();
    }
}
