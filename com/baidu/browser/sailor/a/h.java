package com.baidu.browser.sailor.a;

import android.media.MediaRecorder;
import com.baidu.searchbox.ng.ai.apps.media.chooser.action.ChooseVideoAction;
import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class h implements Runnable {
    final /* synthetic */ c Wq;
    final /* synthetic */ String Wr;
    final /* synthetic */ String Ws;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(c cVar, String str, String str2) {
        this.Wq = cVar;
        this.Wr = str;
        this.Ws = str2;
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
        n nVar = new n(this.Wr, this.Ws);
        nVar.a(this.Wq);
        mediaRecorder = this.Wq.Wj;
        if (mediaRecorder != null) {
            file = this.Wq.Wl;
            if (file != null) {
                file2 = this.Wq.Wl;
                if (file2.exists()) {
                    mediaRecorder2 = this.Wq.Wj;
                    mediaRecorder2.stop();
                    mediaRecorder3 = this.Wq.Wj;
                    mediaRecorder3.reset();
                    mediaRecorder4 = this.Wq.Wj;
                    mediaRecorder4.release();
                    file3 = this.Wq.Wk;
                    if (file3 != null) {
                        file11 = this.Wq.Wk;
                        if (file11.exists()) {
                            file12 = this.Wq.Wk;
                            file12.delete();
                        }
                    }
                    c cVar = this.Wq;
                    file4 = this.Wq.Wl;
                    cVar.Wk = file4;
                    this.Wq.Wl = null;
                    this.Wq.Wj = null;
                    nVar.aG(true);
                    file5 = this.Wq.Wk;
                    nVar.addField("path", file5.getAbsolutePath());
                    file6 = this.Wq.Wk;
                    nVar.addField("record_length", String.valueOf(file6.length()));
                    file7 = this.Wq.Wk;
                    nVar.addField("fullPath", file7.getAbsolutePath());
                    file8 = this.Wq.Wk;
                    nVar.addField("name", file8.getName());
                    file9 = this.Wq.Wk;
                    nVar.addField(ChooseVideoAction.CB_KEY_SIZE, String.valueOf(file9.length()));
                    file10 = this.Wq.Wk;
                    nVar.addField("lastModified", String.valueOf(file10.lastModified()));
                    nVar.addField("type", "audio/amr");
                    nVar.addField("height", "0");
                    nVar.addField("width", "0");
                    nVar.addField("duration", "0");
                    nVar.qQ();
                }
            }
        }
        nVar.aG(false);
        nVar.qQ();
    }
}
