package com.baidu.browser.sailor.a;

import android.media.MediaPlayer;
import android.util.SparseArray;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class m implements MediaPlayer.OnCompletionListener {
    final /* synthetic */ c Wf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(c cVar) {
        this.Wf = cVar;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        SparseArray sparseArray;
        SparseArray sparseArray2;
        sparseArray = this.Wf.Wd;
        n nVar = (n) sparseArray.get(4);
        if (nVar != null) {
            nVar.bo(0);
            sparseArray2 = this.Wf.Wd;
            sparseArray2.remove(4);
        }
    }
}
