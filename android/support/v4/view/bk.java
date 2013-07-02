package android.support.v4.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bk implements Runnable {
    final /* synthetic */ ViewPager a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(ViewPager viewPager) {
        this.a = viewPager;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.setScrollState(0);
        this.a.c();
    }
}
