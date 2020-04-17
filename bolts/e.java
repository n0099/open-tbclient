package bolts;

import java.io.Closeable;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ScheduledFuture;
/* loaded from: classes7.dex */
public class e implements Closeable {
    private boolean closed;
    private final Object lock;
    private final List<d> yU;
    private ScheduledFuture<?> yV;
    private boolean yW;

    public boolean gp() {
        boolean z;
        synchronized (this.lock) {
            gq();
            z = this.yW;
        }
        return z;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.lock) {
            if (!this.closed) {
                gr();
                for (d dVar : this.yU) {
                    dVar.close();
                }
                this.yU.clear();
                this.closed = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(d dVar) {
        synchronized (this.lock) {
            gq();
            this.yU.remove(dVar);
        }
    }

    public String toString() {
        return String.format(Locale.US, "%s@%s[cancellationRequested=%s]", getClass().getName(), Integer.toHexString(hashCode()), Boolean.toString(gp()));
    }

    private void gq() {
        if (this.closed) {
            throw new IllegalStateException("Object already closed");
        }
    }

    private void gr() {
        if (this.yV != null) {
            this.yV.cancel(true);
            this.yV = null;
        }
    }
}
