package com.baidu.browser.sailor.lightapp;

import android.media.MediaPlayer;
import android.util.SparseArray;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class j implements Runnable {
    final /* synthetic */ BdLightappKernelClient adk;
    final /* synthetic */ String adp;
    final /* synthetic */ BdLightappKernelJsCallback adq;
    final /* synthetic */ String adr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(BdLightappKernelClient bdLightappKernelClient, String str, BdLightappKernelJsCallback bdLightappKernelJsCallback, String str2) {
        this.adk = bdLightappKernelClient;
        this.adp = str;
        this.adq = bdLightappKernelJsCallback;
        this.adr = str2;
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
            if ("lightapp.device.AUDIO_TYPE.PLAY".equals(this.adp)) {
                sparseArray4 = this.adk.mJsCallbacks;
                sparseArray4.put(4, this.adq);
                mediaPlayer3 = this.adk.mMediaPlayer;
                if (mediaPlayer3 != null) {
                    mediaPlayer5 = this.adk.mMediaPlayer;
                    mediaPlayer5.stop();
                }
                this.adk.prepareAudio(this.adr);
                mediaPlayer4 = this.adk.mMediaPlayer;
                mediaPlayer4.start();
            } else if ("lightapp.device.AUDIO_TYPE.STOP".equals(this.adp)) {
                sparseArray2 = this.adk.mJsCallbacks;
                sparseArray2.put(4, this.adq);
                this.adk.ensureAudio();
                mediaPlayer = this.adk.mMediaPlayer;
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer2 = this.adk.mMediaPlayer;
                    mediaPlayer2.stop();
                }
                sparseArray3 = this.adk.mJsCallbacks;
                ((BdLightappKernelJsCallback) sparseArray3.get(4)).handleResult("", true);
            }
        } catch (IllegalStateException e) {
            this.adq.sendCallBackWithRetCode(1);
            sparseArray = this.adk.mJsCallbacks;
            sparseArray.remove(4);
            e.printStackTrace();
        }
    }
}
