package android.support.v4.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bk implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ViewPager f324a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(ViewPager viewPager) {
        this.f324a = viewPager;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f324a.setScrollState(0);
        this.f324a.c();
    }
}
