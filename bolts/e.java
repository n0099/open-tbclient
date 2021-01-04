package bolts;

import java.io.Closeable;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ScheduledFuture;
/* loaded from: classes5.dex */
public class e implements Closeable {
    private boolean closed;
    private final Object lock;
    private final List<d> zI;
    private ScheduledFuture<?> zJ;
    private boolean zK;

    public boolean hy() {
        boolean z;
        synchronized (this.lock) {
            hz();
            z = this.zK;
        }
        return z;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.lock) {
            if (!this.closed) {
                hA();
                for (d dVar : this.zI) {
                    dVar.close();
                }
                this.zI.clear();
                this.closed = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(d dVar) {
        synchronized (this.lock) {
            hz();
            this.zI.remove(dVar);
        }
    }

    public String toString() {
        return String.format(Locale.US, "%s@%s[cancellationRequested=%s]", getClass().getName(), Integer.toHexString(hashCode()), Boolean.toString(hy()));
    }

    private void hz() {
        if (this.closed) {
            throw new IllegalStateException("Object already closed");
        }
    }

    private void hA() {
        if (this.zJ != null) {
            this.zJ.cancel(true);
            this.zJ = null;
        }
    }
}
