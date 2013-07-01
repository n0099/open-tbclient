package android.support.v4.app;
/* loaded from: classes.dex */
class af implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ListFragment f51a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ListFragment listFragment) {
        this.f51a = listFragment;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f51a.b.focusableViewAvailable(this.f51a.b);
    }
}
