package android.support.v4.media;

import android.view.KeyEvent;
/* loaded from: classes.dex */
class a implements c {
    final /* synthetic */ TransportMediator lH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(TransportMediator transportMediator) {
        this.lH = transportMediator;
    }

    @Override // android.support.v4.media.c
    public void a(KeyEvent keyEvent) {
        keyEvent.dispatch(this.lH.lG);
    }
}
