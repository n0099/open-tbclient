package com.baidu.browser.sailor.lightapp;

import android.media.MediaPlayer;
import android.util.SparseArray;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public class j implements Runnable {
    final /* synthetic */ BdLightappKernelClient IH;
    final /* synthetic */ String IO;
    final /* synthetic */ BdLightappKernelJsCallback IP;
    final /* synthetic */ String IQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(BdLightappKernelClient bdLightappKernelClient, String str, BdLightappKernelJsCallback bdLightappKernelJsCallback, String str2) {
        this.IH = bdLightappKernelClient;
        this.IO = str;
        this.IP = bdLightappKernelJsCallback;
        this.IQ = str2;
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
            if ("lightapp.device.AUDIO_TYPE.PLAY".equals(this.IO)) {
                sparseArray4 = this.IH.mJsCallbacks;
                sparseArray4.put(4, this.IP);
                mediaPlayer3 = this.IH.mMediaPlayer;
                if (mediaPlayer3 != null) {
                    mediaPlayer5 = this.IH.mMediaPlayer;
                    mediaPlayer5.stop();
                }
                this.IH.prepareAudio(this.IQ);
                mediaPlayer4 = this.IH.mMediaPlayer;
                mediaPlayer4.start();
            } else if ("lightapp.device.AUDIO_TYPE.STOP".equals(this.IO)) {
                sparseArray2 = this.IH.mJsCallbacks;
                sparseArray2.put(4, this.IP);
                this.IH.ensureAudio();
                mediaPlayer = this.IH.mMediaPlayer;
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer2 = this.IH.mMediaPlayer;
                    mediaPlayer2.stop();
                }
                sparseArray3 = this.IH.mJsCallbacks;
                ((BdLightappKernelJsCallback) sparseArray3.get(4)).handleResult("", true);
            }
        } catch (IllegalStateException e) {
            this.IP.sendCallBackWithRetCode(1);
            sparseArray = this.IH.mJsCallbacks;
            sparseArray.remove(4);
            e.printStackTrace();
        }
    }
}
