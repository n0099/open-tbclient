package android.support.v4.app;
/* loaded from: classes.dex */
class af implements Runnable {
    final /* synthetic */ ListFragment a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ListFragment listFragment) {
        this.a = listFragment;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.b.focusableViewAvailable(this.a.b);
    }
}
