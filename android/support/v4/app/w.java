package android.support.v4.app;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ v f66a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar) {
        this.f66a = vVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f66a.e();
    }
}
