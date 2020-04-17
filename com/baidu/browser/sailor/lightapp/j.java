package com.baidu.browser.sailor.lightapp;

import android.media.MediaPlayer;
import android.util.SparseArray;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class j implements Runnable {
    final /* synthetic */ BdLightappKernelClient acq;
    final /* synthetic */ String acv;
    final /* synthetic */ BdLightappKernelJsCallback acx;
    final /* synthetic */ String acy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(BdLightappKernelClient bdLightappKernelClient, String str, BdLightappKernelJsCallback bdLightappKernelJsCallback, String str2) {
        this.acq = bdLightappKernelClient;
        this.acv = str;
        this.acx = bdLightappKernelJsCallback;
        this.acy = str2;
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
            if ("lightapp.device.AUDIO_TYPE.PLAY".equals(this.acv)) {
                sparseArray4 = this.acq.mJsCallbacks;
                sparseArray4.put(4, this.acx);
                mediaPlayer3 = this.acq.mMediaPlayer;
                if (mediaPlayer3 != null) {
                    mediaPlayer5 = this.acq.mMediaPlayer;
                    mediaPlayer5.stop();
                }
                this.acq.prepareAudio(this.acy);
                mediaPlayer4 = this.acq.mMediaPlayer;
                mediaPlayer4.start();
            } else if ("lightapp.device.AUDIO_TYPE.STOP".equals(this.acv)) {
                sparseArray2 = this.acq.mJsCallbacks;
                sparseArray2.put(4, this.acx);
                this.acq.ensureAudio();
                mediaPlayer = this.acq.mMediaPlayer;
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer2 = this.acq.mMediaPlayer;
                    mediaPlayer2.stop();
                }
                sparseArray3 = this.acq.mJsCallbacks;
                ((BdLightappKernelJsCallback) sparseArray3.get(4)).handleResult("", true);
            }
        } catch (IllegalStateException e) {
            this.acx.sendCallBackWithRetCode(1);
            sparseArray = this.acq.mJsCallbacks;
            sparseArray.remove(4);
            e.printStackTrace();
        }
    }
}
