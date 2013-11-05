package android.support.v4.content;

import android.os.Process;
import java.util.concurrent.atomic.AtomicBoolean;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends p<Params, Result> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ModernAsyncTask f317a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(ModernAsyncTask modernAsyncTask) {
        super(null);
        this.f317a = modernAsyncTask;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Object, Result] */
    @Override // java.util.concurrent.Callable
    public Result call() {
        AtomicBoolean atomicBoolean;
        ?? d;
        atomicBoolean = this.f317a.i;
        atomicBoolean.set(true);
        Process.setThreadPriority(10);
        d = this.f317a.d(this.f317a.a((Object[]) this.b));
        return d;
    }
}
