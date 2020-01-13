package com.baidu.browser.sailor.lightapp;

import android.media.MediaPlayer;
import android.util.SparseArray;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public class n implements MediaPlayer.OnCompletionListener {
    final /* synthetic */ BdLightappKernelClient IP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(BdLightappKernelClient bdLightappKernelClient) {
        this.IP = bdLightappKernelClient;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        SparseArray sparseArray;
        SparseArray sparseArray2;
        sparseArray = this.IP.mJsCallbacks;
        BdLightappKernelJsCallback bdLightappKernelJsCallback = (BdLightappKernelJsCallback) sparseArray.get(4);
        if (bdLightappKernelJsCallback != null) {
            bdLightappKernelJsCallback.sendCallBackWithRetCode(0);
            sparseArray2 = this.IP.mJsCallbacks;
            sparseArray2.remove(4);
        }
    }
}
