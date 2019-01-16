package com.baidu.browser.sailor.a;

import android.media.MediaPlayer;
import android.util.SparseArray;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class m implements MediaPlayer.OnCompletionListener {
    final /* synthetic */ c Wq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(c cVar) {
        this.Wq = cVar;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        SparseArray sparseArray;
        SparseArray sparseArray2;
        sparseArray = this.Wq.Wo;
        n nVar = (n) sparseArray.get(4);
        if (nVar != null) {
            nVar.bD(0);
            sparseArray2 = this.Wq.Wo;
            sparseArray2.remove(4);
        }
    }
}
