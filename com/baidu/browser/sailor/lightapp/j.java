package com.baidu.browser.sailor.lightapp;

import android.media.MediaPlayer;
import android.util.SparseArray;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class j implements Runnable {
    final /* synthetic */ BdLightappKernelClient adq;
    final /* synthetic */ String adv;
    final /* synthetic */ BdLightappKernelJsCallback adw;
    final /* synthetic */ String adx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(BdLightappKernelClient bdLightappKernelClient, String str, BdLightappKernelJsCallback bdLightappKernelJsCallback, String str2) {
        this.adq = bdLightappKernelClient;
        this.adv = str;
        this.adw = bdLightappKernelJsCallback;
        this.adx = str2;
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
            if ("lightapp.device.AUDIO_TYPE.PLAY".equals(this.adv)) {
                sparseArray4 = this.adq.mJsCallbacks;
                sparseArray4.put(4, this.adw);
                mediaPlayer3 = this.adq.mMediaPlayer;
                if (mediaPlayer3 != null) {
                    mediaPlayer5 = this.adq.mMediaPlayer;
                    mediaPlayer5.stop();
                }
                this.adq.prepareAudio(this.adx);
                mediaPlayer4 = this.adq.mMediaPlayer;
                mediaPlayer4.start();
            } else if ("lightapp.device.AUDIO_TYPE.STOP".equals(this.adv)) {
                sparseArray2 = this.adq.mJsCallbacks;
                sparseArray2.put(4, this.adw);
                this.adq.ensureAudio();
                mediaPlayer = this.adq.mMediaPlayer;
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer2 = this.adq.mMediaPlayer;
                    mediaPlayer2.stop();
                }
                sparseArray3 = this.adq.mJsCallbacks;
                ((BdLightappKernelJsCallback) sparseArray3.get(4)).handleResult("", true);
            }
        } catch (IllegalStateException e) {
            this.adw.sendCallBackWithRetCode(1);
            sparseArray = this.adq.mJsCallbacks;
            sparseArray.remove(4);
            e.printStackTrace();
        }
    }
}
