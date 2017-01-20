package android.support.v4.media;

import android.media.AudioManager;
/* loaded from: classes.dex */
class h implements AudioManager.OnAudioFocusChangeListener {
    final /* synthetic */ d this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(d dVar) {
        this.this$0 = dVar;
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public void onAudioFocusChange(int i) {
        this.this$0.bL.k(i);
    }
}
