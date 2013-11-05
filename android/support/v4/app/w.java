package android.support.v4.app;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ v f301a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar) {
        this.f301a = vVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f301a.e();
    }
}
