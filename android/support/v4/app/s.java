package android.support.v4.app;
/* loaded from: classes.dex */
class s implements Runnable {
    final /* synthetic */ ListFragment a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(ListFragment listFragment) {
        this.a = listFragment;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.b.focusableViewAvailable(this.a.b);
    }
}
