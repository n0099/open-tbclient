package android.support.v4.content;

import android.os.Process;
import java.util.concurrent.atomic.AtomicBoolean;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends m {
    final /* synthetic */ e a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(e eVar) {
        super(null);
        this.a = eVar;
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        AtomicBoolean atomicBoolean;
        Object d;
        atomicBoolean = this.a.i;
        atomicBoolean.set(true);
        Process.setThreadPriority(10);
        d = this.a.d(this.a.a(this.b));
        return d;
    }
}
