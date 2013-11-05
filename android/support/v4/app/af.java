package android.support.v4.app;
/* loaded from: classes.dex */
class af implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ListFragment f286a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ListFragment listFragment) {
        this.f286a = listFragment;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f286a.b.focusableViewAvailable(this.f286a.b);
    }
}
