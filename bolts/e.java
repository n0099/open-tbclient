package bolts;

import java.io.Closeable;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ScheduledFuture;
/* loaded from: classes19.dex */
public class e implements Closeable {
    private boolean closed;
    private final Object lock;
    private final List<d> zw;
    private ScheduledFuture<?> zx;
    private boolean zy;

    public boolean gF() {
        boolean z;
        synchronized (this.lock) {
            gG();
            z = this.zy;
        }
        return z;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.lock) {
            if (!this.closed) {
                gH();
                for (d dVar : this.zw) {
                    dVar.close();
                }
                this.zw.clear();
                this.closed = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(d dVar) {
        synchronized (this.lock) {
            gG();
            this.zw.remove(dVar);
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
        if (this.zx != null) {
            this.zx.cancel(true);
            this.zx = null;
        }
    }
}
