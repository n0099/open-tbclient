package com.baidu.browser.sailor.a;

import android.media.MediaPlayer;
import android.util.SparseArray;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class d implements MediaPlayer.OnErrorListener {
    final /* synthetic */ c Wf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.Wf = cVar;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        SparseArray sparseArray;
        SparseArray sparseArray2;
        sparseArray = this.Wf.Wd;
        n nVar = (n) sparseArray.get(4);
        if (nVar != null) {
            nVar.bo(1);
            sparseArray2 = this.Wf.Wd;
            sparseArray2.remove(4);
            return false;
        }
        return false;
    }
}
