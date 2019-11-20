package bolts;

import java.io.Closeable;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ScheduledFuture;
/* loaded from: classes2.dex */
public class e implements Closeable {
    private final List<d> cb;
    private ScheduledFuture<?> cc;
    private boolean cd;
    private boolean closed;
    private final Object lock;

    public boolean aG() {
        boolean z;
        synchronized (this.lock) {
            aH();
            z = this.cd;
        }
        return z;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.lock) {
            if (!this.closed) {
                aI();
                for (d dVar : this.cb) {
                    dVar.close();
                }
                this.cb.clear();
                this.closed = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(d dVar) {
        synchronized (this.lock) {
            aH();
            this.cb.remove(dVar);
        }
    }

    public String toString() {
        return String.format(Locale.US, "%s@%s[cancellationRequested=%s]", getClass().getName(), Integer.toHexString(hashCode()), Boolean.toString(aG()));
    }

    private void aH() {
        if (this.closed) {
            throw new IllegalStateException("Object already closed");
        }
    }

    private void aI() {
        if (this.cc != null) {
            this.cc.cancel(true);
            this.cc = null;
        }
    }
}
