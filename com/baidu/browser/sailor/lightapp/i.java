package com.baidu.browser.sailor.lightapp;

import android.media.MediaRecorder;
import com.baidu.android.util.media.MimeType;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class i implements Runnable {
    final /* synthetic */ BdLightappKernelClient acL;
    final /* synthetic */ String acN;
    final /* synthetic */ String acO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(BdLightappKernelClient bdLightappKernelClient, String str, String str2) {
        this.acL = bdLightappKernelClient;
        this.acN = str;
        this.acO = str2;
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
        BdLightappKernelJsCallback bdLightappKernelJsCallback = new BdLightappKernelJsCallback(this.acN, this.acO);
        bdLightappKernelJsCallback.setCallbackListener(this.acL);
        mediaRecorder = this.acL.mRecorder;
        if (mediaRecorder != null) {
            file = this.acL.mRecordingFile;
            if (file != null) {
                file2 = this.acL.mRecordingFile;
                if (file2.exists()) {
                    mediaRecorder2 = this.acL.mRecorder;
                    mediaRecorder2.stop();
                    mediaRecorder3 = this.acL.mRecorder;
                    mediaRecorder3.reset();
                    mediaRecorder4 = this.acL.mRecorder;
                    mediaRecorder4.release();
                    file3 = this.acL.mRecordFile;
                    if (file3 != null) {
                        file11 = this.acL.mRecordFile;
                        if (file11.exists()) {
                            file12 = this.acL.mRecordFile;
                            file12.delete();
                        }
                    }
                    BdLightappKernelClient bdLightappKernelClient = this.acL;
                    file4 = this.acL.mRecordingFile;
                    bdLightappKernelClient.mRecordFile = file4;
                    this.acL.mRecordingFile = null;
                    this.acL.mRecorder = null;
                    bdLightappKernelJsCallback.setResult(true);
                    file5 = this.acL.mRecordFile;
                    bdLightappKernelJsCallback.addField("path", file5.getAbsolutePath());
                    file6 = this.acL.mRecordFile;
                    bdLightappKernelJsCallback.addField("record_length", String.valueOf(file6.length()));
                    file7 = this.acL.mRecordFile;
                    bdLightappKernelJsCallback.addField("fullPath", file7.getAbsolutePath());
                    file8 = this.acL.mRecordFile;
                    bdLightappKernelJsCallback.addField("name", file8.getName());
                    file9 = this.acL.mRecordFile;
                    bdLightappKernelJsCallback.addField(TiebaInitialize.LogFields.SIZE, String.valueOf(file9.length()));
                    file10 = this.acL.mRecordFile;
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
