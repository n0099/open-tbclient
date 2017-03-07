package android.support.v4.media;

import android.view.KeyEvent;
/* loaded from: classes.dex */
class a implements c {
    final /* synthetic */ TransportMediator ju;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(TransportMediator transportMediator) {
        this.ju = transportMediator;
    }

    @Override // android.support.v4.media.c
    public void a(KeyEvent keyEvent) {
        keyEvent.dispatch(this.ju.jt);
    }

    @Override // android.support.v4.media.c
    public void k(int i) {
        this.ju.jo.onAudioFocusChange(i);
    }
}
