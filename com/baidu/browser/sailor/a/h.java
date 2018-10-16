package com.baidu.browser.sailor.a;

import android.media.MediaRecorder;
import com.baidu.searchbox.ng.ai.apps.media.chooser.action.ChooseVideoAction;
import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class h implements Runnable {
    final /* synthetic */ c Wf;
    final /* synthetic */ String Wg;
    final /* synthetic */ String Wh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(c cVar, String str, String str2) {
        this.Wf = cVar;
        this.Wg = str;
        this.Wh = str2;
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
        n nVar = new n(this.Wg, this.Wh);
        nVar.a(this.Wf);
        mediaRecorder = this.Wf.VY;
        if (mediaRecorder != null) {
            file = this.Wf.Wa;
            if (file != null) {
                file2 = this.Wf.Wa;
                if (file2.exists()) {
                    mediaRecorder2 = this.Wf.VY;
                    mediaRecorder2.stop();
                    mediaRecorder3 = this.Wf.VY;
                    mediaRecorder3.reset();
                    mediaRecorder4 = this.Wf.VY;
                    mediaRecorder4.release();
                    file3 = this.Wf.VZ;
                    if (file3 != null) {
                        file11 = this.Wf.VZ;
                        if (file11.exists()) {
                            file12 = this.Wf.VZ;
                            file12.delete();
                        }
                    }
                    c cVar = this.Wf;
                    file4 = this.Wf.Wa;
                    cVar.VZ = file4;
                    this.Wf.Wa = null;
                    this.Wf.VY = null;
                    nVar.as(true);
                    file5 = this.Wf.VZ;
                    nVar.addField("path", file5.getAbsolutePath());
                    file6 = this.Wf.VZ;
                    nVar.addField("record_length", String.valueOf(file6.length()));
                    file7 = this.Wf.VZ;
                    nVar.addField("fullPath", file7.getAbsolutePath());
                    file8 = this.Wf.VZ;
                    nVar.addField("name", file8.getName());
                    file9 = this.Wf.VZ;
                    nVar.addField(ChooseVideoAction.CB_KEY_SIZE, String.valueOf(file9.length()));
                    file10 = this.Wf.VZ;
                    nVar.addField("lastModified", String.valueOf(file10.lastModified()));
                    nVar.addField("type", "audio/amr");
                    nVar.addField("height", "0");
                    nVar.addField("width", "0");
                    nVar.addField("duration", "0");
                    nVar.qP();
                }
            }
        }
        nVar.as(false);
        nVar.qP();
    }
}
