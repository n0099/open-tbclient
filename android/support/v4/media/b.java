package android.support.v4.media;

import android.view.KeyEvent;
/* loaded from: classes.dex */
class b implements KeyEvent.Callback {
    final /* synthetic */ TransportMediator ju;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(TransportMediator transportMediator) {
        this.ju = transportMediator;
    }

    @Override // android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (TransportMediator.j(i)) {
            return this.ju.jo.onMediaButtonDown(i, keyEvent);
        }
        return false;
    }

    @Override // android.view.KeyEvent.Callback
    public boolean onKeyLongPress(int i, KeyEvent keyEvent) {
        return false;
    }

    @Override // android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (TransportMediator.j(i)) {
            return this.ju.jo.onMediaButtonUp(i, keyEvent);
        }
        return false;
    }

    @Override // android.view.KeyEvent.Callback
    public boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
        return false;
    }
}
