package com.baidu.browser.sailor.lightapp;

import android.media.MediaPlayer;
import android.util.SparseArray;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public class j implements Runnable {
    final /* synthetic */ BdLightappKernelClient IP;
    final /* synthetic */ String IU;
    final /* synthetic */ BdLightappKernelJsCallback IW;
    final /* synthetic */ String IX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(BdLightappKernelClient bdLightappKernelClient, String str, BdLightappKernelJsCallback bdLightappKernelJsCallback, String str2) {
        this.IP = bdLightappKernelClient;
        this.IU = str;
        this.IW = bdLightappKernelJsCallback;
        this.IX = str2;
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
            if ("lightapp.device.AUDIO_TYPE.PLAY".equals(this.IU)) {
                sparseArray4 = this.IP.mJsCallbacks;
                sparseArray4.put(4, this.IW);
                mediaPlayer3 = this.IP.mMediaPlayer;
                if (mediaPlayer3 != null) {
                    mediaPlayer5 = this.IP.mMediaPlayer;
                    mediaPlayer5.stop();
                }
                this.IP.prepareAudio(this.IX);
                mediaPlayer4 = this.IP.mMediaPlayer;
                mediaPlayer4.start();
            } else if ("lightapp.device.AUDIO_TYPE.STOP".equals(this.IU)) {
                sparseArray2 = this.IP.mJsCallbacks;
                sparseArray2.put(4, this.IW);
                this.IP.ensureAudio();
                mediaPlayer = this.IP.mMediaPlayer;
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer2 = this.IP.mMediaPlayer;
                    mediaPlayer2.stop();
                }
                sparseArray3 = this.IP.mJsCallbacks;
                ((BdLightappKernelJsCallback) sparseArray3.get(4)).handleResult("", true);
            }
        } catch (IllegalStateException e) {
            this.IW.sendCallBackWithRetCode(1);
            sparseArray = this.IP.mJsCallbacks;
            sparseArray.remove(4);
            e.printStackTrace();
        }
    }
}
