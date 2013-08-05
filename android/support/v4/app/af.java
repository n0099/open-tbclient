package android.support.v4.app;
/* loaded from: classes.dex */
class af implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ListFragment f276a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ListFragment listFragment) {
        this.f276a = listFragment;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f276a.b.focusableViewAvailable(this.f276a.b);
    }
}
