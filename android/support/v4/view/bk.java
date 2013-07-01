package android.support.v4.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bk implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ViewPager f91a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(ViewPager viewPager) {
        this.f91a = viewPager;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f91a.setScrollState(0);
        this.f91a.c();
    }
}
