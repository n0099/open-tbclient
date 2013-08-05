package android.support.v4.content;

import android.os.Process;
import java.util.concurrent.atomic.AtomicBoolean;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends l {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ModernAsyncTask f303a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(ModernAsyncTask modernAsyncTask) {
        super(null);
        this.f303a = modernAsyncTask;
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        AtomicBoolean atomicBoolean;
        Object d;
        atomicBoolean = this.f303a.i;
        atomicBoolean.set(true);
        Process.setThreadPriority(10);
        d = this.f303a.d(this.f303a.a(this.b));
        return d;
    }
}
