package com.baidu.browser.sailor.lightapp;

import android.media.MediaPlayer;
import android.util.SparseArray;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class j implements Runnable {
    final /* synthetic */ BdLightappKernelClient Jm;
    final /* synthetic */ String Jr;
    final /* synthetic */ BdLightappKernelJsCallback Js;
    final /* synthetic */ String Jt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(BdLightappKernelClient bdLightappKernelClient, String str, BdLightappKernelJsCallback bdLightappKernelJsCallback, String str2) {
        this.Jm = bdLightappKernelClient;
        this.Jr = str;
        this.Js = bdLightappKernelJsCallback;
        this.Jt = str2;
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
            if ("lightapp.device.AUDIO_TYPE.PLAY".equals(this.Jr)) {
                sparseArray4 = this.Jm.mJsCallbacks;
                sparseArray4.put(4, this.Js);
                mediaPlayer3 = this.Jm.mMediaPlayer;
                if (mediaPlayer3 != null) {
                    mediaPlayer5 = this.Jm.mMediaPlayer;
                    mediaPlayer5.stop();
                }
                this.Jm.prepareAudio(this.Jt);
                mediaPlayer4 = this.Jm.mMediaPlayer;
                mediaPlayer4.start();
            } else if ("lightapp.device.AUDIO_TYPE.STOP".equals(this.Jr)) {
                sparseArray2 = this.Jm.mJsCallbacks;
                sparseArray2.put(4, this.Js);
                this.Jm.ensureAudio();
                mediaPlayer = this.Jm.mMediaPlayer;
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer2 = this.Jm.mMediaPlayer;
                    mediaPlayer2.stop();
                }
                sparseArray3 = this.Jm.mJsCallbacks;
                ((BdLightappKernelJsCallback) sparseArray3.get(4)).handleResult("", true);
            }
        } catch (IllegalStateException e) {
            this.Js.sendCallBackWithRetCode(1);
            sparseArray = this.Jm.mJsCallbacks;
            sparseArray.remove(4);
            e.printStackTrace();
        }
    }
}
