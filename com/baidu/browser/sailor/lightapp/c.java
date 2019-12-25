package com.baidu.browser.sailor.lightapp;

import android.media.MediaPlayer;
import android.util.SparseArray;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public class c implements MediaPlayer.OnErrorListener {
    final /* synthetic */ BdLightappKernelClient IH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(BdLightappKernelClient bdLightappKernelClient) {
        this.IH = bdLightappKernelClient;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        SparseArray sparseArray;
        SparseArray sparseArray2;
        sparseArray = this.IH.mJsCallbacks;
        BdLightappKernelJsCallback bdLightappKernelJsCallback = (BdLightappKernelJsCallback) sparseArray.get(4);
        if (bdLightappKernelJsCallback != null) {
            bdLightappKernelJsCallback.sendCallBackWithRetCode(1);
            sparseArray2 = this.IH.mJsCallbacks;
            sparseArray2.remove(4);
            return false;
        }
        return false;
    }
}
