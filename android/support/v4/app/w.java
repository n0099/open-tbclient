package android.support.v4.app;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ v f291a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar) {
        this.f291a = vVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f291a.e();
    }
}
