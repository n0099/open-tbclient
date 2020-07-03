package bolts;

import java.io.Closeable;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ScheduledFuture;
/* loaded from: classes7.dex */
public class e implements Closeable {
    private boolean closed;
    private final Object lock;
    private final List<d> zu;
    private ScheduledFuture<?> zv;
    private boolean zw;

    public boolean gF() {
        boolean z;
        synchronized (this.lock) {
            gG();
            z = this.zw;
        }
        return z;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.lock) {
            if (!this.closed) {
                gH();
                for (d dVar : this.zu) {
                    dVar.close();
                }
                this.zu.clear();
                this.closed = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(d dVar) {
        synchronized (this.lock) {
            gG();
            this.zu.remove(dVar);
        }
    }

    public String toString() {
        return String.format(Locale.US, "%s@%s[cancellationRequested=%s]", getClass().getName(), Integer.toHexString(hashCode()), Boolean.toString(gF()));
    }

    private void gG() {
        if (this.closed) {
            throw new IllegalStateException("Object already closed");
        }
    }

    private void gH() {
        if (this.zv != null) {
            this.zv.cancel(true);
            this.zv = null;
        }
    }
}
