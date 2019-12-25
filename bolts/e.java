package bolts;

import java.io.Closeable;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ScheduledFuture;
/* loaded from: classes4.dex */
public class e implements Closeable {
    private boolean closed;
    private final List<d> dc;
    private ScheduledFuture<?> dd;
    private boolean de;
    private final Object lock;

    public boolean aS() {
        boolean z;
        synchronized (this.lock) {
            aT();
            z = this.de;
        }
        return z;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.lock) {
            if (!this.closed) {
                aU();
                for (d dVar : this.dc) {
                    dVar.close();
                }
                this.dc.clear();
                this.closed = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(d dVar) {
        synchronized (this.lock) {
            aT();
            this.dc.remove(dVar);
        }
    }

    public String toString() {
        return String.format(Locale.US, "%s@%s[cancellationRequested=%s]", getClass().getName(), Integer.toHexString(hashCode()), Boolean.toString(aS()));
    }

    private void aT() {
        if (this.closed) {
            throw new IllegalStateException("Object already closed");
        }
    }

    private void aU() {
        if (this.dd != null) {
            this.dd.cancel(true);
            this.dd = null;
        }
    }
}
