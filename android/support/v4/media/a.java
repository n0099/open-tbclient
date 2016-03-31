package android.support.v4.media;

import android.view.KeyEvent;
/* loaded from: classes.dex */
class a implements c {
    final /* synthetic */ TransportMediator lJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(TransportMediator transportMediator) {
        this.lJ = transportMediator;
    }

    @Override // android.support.v4.media.c
    public void a(KeyEvent keyEvent) {
        keyEvent.dispatch(this.lJ.lI);
    }

    @Override // android.support.v4.media.c
    public void j(int i) {
        this.lJ.lC.onAudioFocusChange(i);
    }
}
