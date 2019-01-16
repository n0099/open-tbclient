package com.baidu.browser.sailor.a;

import android.media.MediaPlayer;
import android.util.SparseArray;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class i implements Runnable {
    final /* synthetic */ c Wq;
    final /* synthetic */ n Wu;
    final /* synthetic */ String Wv;
    final /* synthetic */ String val$type;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(c cVar, String str, n nVar, String str2) {
        this.Wq = cVar;
        this.val$type = str;
        this.Wu = nVar;
        this.Wv = str2;
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
                sparseArray4 = this.Wq.Wo;
                sparseArray4.put(4, this.Wu);
                mediaPlayer3 = this.Wq.Wm;
                if (mediaPlayer3 != null) {
                    mediaPlayer5 = this.Wq.Wm;
                    mediaPlayer5.stop();
                }
                this.Wq.cy(this.Wv);
                mediaPlayer4 = this.Wq.Wm;
                mediaPlayer4.start();
            } else if ("lightapp.device.AUDIO_TYPE.STOP".equals(this.val$type)) {
                sparseArray2 = this.Wq.Wo;
                sparseArray2.put(4, this.Wu);
                this.Wq.qO();
                mediaPlayer = this.Wq.Wm;
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer2 = this.Wq.Wm;
                    mediaPlayer2.stop();
                }
                sparseArray3 = this.Wq.Wo;
                ((n) sparseArray3.get(4)).l("", true);
            }
        } catch (IllegalStateException e) {
            this.Wu.bD(1);
            sparseArray = this.Wq.Wo;
            sparseArray.remove(4);
            e.printStackTrace();
        }
    }
}
