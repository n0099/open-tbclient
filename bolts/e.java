package bolts;

import java.io.Closeable;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ScheduledFuture;
/* loaded from: classes2.dex */
public class e implements Closeable {
    private boolean closed;
    private final List<d> jR;
    private ScheduledFuture<?> jS;
    private boolean jT;
    private final Object lock;

    public boolean bd() {
        boolean z;
        synchronized (this.lock) {
            be();
            z = this.jT;
        }
        return z;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.lock) {
            if (!this.closed) {
                bf();
                for (d dVar : this.jR) {
                    dVar.close();
                }
                this.jR.clear();
                this.closed = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(d dVar) {
        synchronized (this.lock) {
            be();
            this.jR.remove(dVar);
        }
    }

    public String toString() {
        return String.format(Locale.US, "%s@%s[cancellationRequested=%s]", getClass().getName(), Integer.toHexString(hashCode()), Boolean.toString(bd()));
    }

    private void be() {
        if (this.closed) {
            throw new IllegalStateException("Object already closed");
        }
    }

    private void bf() {
        if (this.jS != null) {
            this.jS.cancel(true);
            this.jS = null;
        }
    }
}
