package com.baidu.browser.sailor.a;

import android.media.MediaPlayer;
import android.util.SparseArray;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class i implements Runnable {
    final /* synthetic */ c Wh;
    final /* synthetic */ n Wl;
    final /* synthetic */ String Wm;
    final /* synthetic */ String val$type;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(c cVar, String str, n nVar, String str2) {
        this.Wh = cVar;
        this.val$type = str;
        this.Wl = nVar;
        this.Wm = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        SparseArray sparseArray;
        SparseArray sparseArray2;
        MediaPlayer mediaPlayer;
        SparseArray sparseArray3;
        MediaPlayer mediaPlayer2;
        SparseArray sparseArray4;
        MediaPlayer mediaPlayer3;
        MediaPlayer mediaPlayer4;
        MediaPlayer mediaPlayer5;
        try {
            if ("lightapp.device.AUDIO_TYPE.PLAY".equals(this.val$type)) {
                sparseArray4 = this.Wh.Wf;
                sparseArray4.put(4, this.Wl);
                mediaPlayer3 = this.Wh.Wd;
                if (mediaPlayer3 != null) {
                    mediaPlayer5 = this.Wh.Wd;
                    mediaPlayer5.stop();
                }
                this.Wh.cx(this.Wm);
                mediaPlayer4 = this.Wh.Wd;
                mediaPlayer4.start();
            } else if ("lightapp.device.AUDIO_TYPE.STOP".equals(this.val$type)) {
                sparseArray2 = this.Wh.Wf;
                sparseArray2.put(4, this.Wl);
                this.Wh.qK();
                mediaPlayer = this.Wh.Wd;
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer2 = this.Wh.Wd;
                    mediaPlayer2.stop();
                }
                sparseArray3 = this.Wh.Wf;
                ((n) sparseArray3.get(4)).l("", true);
            }
        } catch (IllegalStateException e) {
            this.Wl.bD(1);
            sparseArray = this.Wh.Wf;
            sparseArray.remove(4);
            e.printStackTrace();
        }
    }
}
