package com.baidu.browser.sailor.lightapp;

import android.media.MediaPlayer;
import android.util.SparseArray;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class j implements Runnable {
    final /* synthetic */ BdLightappKernelClient acL;
    final /* synthetic */ String acQ;
    final /* synthetic */ BdLightappKernelJsCallback acR;
    final /* synthetic */ String acS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(BdLightappKernelClient bdLightappKernelClient, String str, BdLightappKernelJsCallback bdLightappKernelJsCallback, String str2) {
        this.acL = bdLightappKernelClient;
        this.acQ = str;
        this.acR = bdLightappKernelJsCallback;
        this.acS = str2;
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
            if ("lightapp.device.AUDIO_TYPE.PLAY".equals(this.acQ)) {
                sparseArray4 = this.acL.mJsCallbacks;
                sparseArray4.put(4, this.acR);
                mediaPlayer3 = this.acL.mMediaPlayer;
                if (mediaPlayer3 != null) {
                    mediaPlayer5 = this.acL.mMediaPlayer;
                    mediaPlayer5.stop();
                }
                this.acL.prepareAudio(this.acS);
                mediaPlayer4 = this.acL.mMediaPlayer;
                mediaPlayer4.start();
            } else if ("lightapp.device.AUDIO_TYPE.STOP".equals(this.acQ)) {
                sparseArray2 = this.acL.mJsCallbacks;
                sparseArray2.put(4, this.acR);
                this.acL.ensureAudio();
                mediaPlayer = this.acL.mMediaPlayer;
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer2 = this.acL.mMediaPlayer;
                    mediaPlayer2.stop();
                }
                sparseArray3 = this.acL.mJsCallbacks;
                ((BdLightappKernelJsCallback) sparseArray3.get(4)).handleResult("", true);
            }
        } catch (IllegalStateException e) {
            this.acR.sendCallBackWithRetCode(1);
            sparseArray = this.acL.mJsCallbacks;
            sparseArray.remove(4);
            e.printStackTrace();
        }
    }
}
