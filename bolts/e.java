package bolts;

import java.io.Closeable;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ScheduledFuture;
/* loaded from: classes10.dex */
public class e implements Closeable {
    private final List<d> Bq;
    private ScheduledFuture<?> Br;
    private boolean Bs;
    private boolean closed;
    private final Object lock;

    public boolean ig() {
        boolean z;
        synchronized (this.lock) {
            ih();
            z = this.Bs;
        }
        return z;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.lock) {
            if (!this.closed) {
                ii();
                for (d dVar : this.Bq) {
                    dVar.close();
                }
                this.Bq.clear();
                this.closed = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(d dVar) {
        synchronized (this.lock) {
            ih();
            this.Bq.remove(dVar);
        }
    }

    public String toString() {
        return String.format(Locale.US, "%s@%s[cancellationRequested=%s]", getClass().getName(), Integer.toHexString(hashCode()), Boolean.toString(ig()));
    }

    private void ih() {
        if (this.closed) {
            throw new IllegalStateException("Object already closed");
        }
    }

    private void ii() {
        if (this.Br != null) {
            this.Br.cancel(true);
            this.Br = null;
        }
    }
}
