package bolts;

import java.io.Closeable;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ScheduledFuture;
/* loaded from: classes14.dex */
public class e implements Closeable {
    private final List<d> Cu;
    private ScheduledFuture<?> Cv;
    private boolean Cw;
    private boolean closed;
    private final Object lock;

    public boolean hF() {
        boolean z;
        synchronized (this.lock) {
            hG();
            z = this.Cw;
        }
        return z;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.lock) {
            if (!this.closed) {
                hH();
                for (d dVar : this.Cu) {
                    dVar.close();
                }
                this.Cu.clear();
                this.closed = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(d dVar) {
        synchronized (this.lock) {
            hG();
            this.Cu.remove(dVar);
        }
    }

    public String toString() {
        return String.format(Locale.US, "%s@%s[cancellationRequested=%s]", getClass().getName(), Integer.toHexString(hashCode()), Boolean.toString(hF()));
    }

    private void hG() {
        if (this.closed) {
            throw new IllegalStateException("Object already closed");
        }
    }

    private void hH() {
        if (this.Cv != null) {
            this.Cv.cancel(true);
            this.Cv = null;
        }
    }
}
