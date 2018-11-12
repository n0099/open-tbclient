package com.baidu.browser.sailor.a;

import android.media.MediaRecorder;
import com.baidu.searchbox.ng.ai.apps.media.chooser.action.ChooseVideoAction;
import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class h implements Runnable {
    final /* synthetic */ c Wh;
    final /* synthetic */ String Wi;
    final /* synthetic */ String Wj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(c cVar, String str, String str2) {
        this.Wh = cVar;
        this.Wi = str;
        this.Wj = str2;
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
        n nVar = new n(this.Wi, this.Wj);
        nVar.a(this.Wh);
        mediaRecorder = this.Wh.Wa;
        if (mediaRecorder != null) {
            file = this.Wh.Wc;
            if (file != null) {
                file2 = this.Wh.Wc;
                if (file2.exists()) {
                    mediaRecorder2 = this.Wh.Wa;
                    mediaRecorder2.stop();
                    mediaRecorder3 = this.Wh.Wa;
                    mediaRecorder3.reset();
                    mediaRecorder4 = this.Wh.Wa;
                    mediaRecorder4.release();
                    file3 = this.Wh.Wb;
                    if (file3 != null) {
                        file11 = this.Wh.Wb;
                        if (file11.exists()) {
                            file12 = this.Wh.Wb;
                            file12.delete();
                        }
                    }
                    c cVar = this.Wh;
                    file4 = this.Wh.Wc;
                    cVar.Wb = file4;
                    this.Wh.Wc = null;
                    this.Wh.Wa = null;
                    nVar.aG(true);
                    file5 = this.Wh.Wb;
                    nVar.addField("path", file5.getAbsolutePath());
                    file6 = this.Wh.Wb;
                    nVar.addField("record_length", String.valueOf(file6.length()));
                    file7 = this.Wh.Wb;
                    nVar.addField("fullPath", file7.getAbsolutePath());
                    file8 = this.Wh.Wb;
                    nVar.addField("name", file8.getName());
                    file9 = this.Wh.Wb;
                    nVar.addField(ChooseVideoAction.CB_KEY_SIZE, String.valueOf(file9.length()));
                    file10 = this.Wh.Wb;
                    nVar.addField("lastModified", String.valueOf(file10.lastModified()));
                    nVar.addField("type", "audio/amr");
                    nVar.addField("height", "0");
                    nVar.addField("width", "0");
                    nVar.addField("duration", "0");
                    nVar.qN();
                }
            }
        }
        nVar.aG(false);
        nVar.qN();
    }
}
