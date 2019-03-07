package bolts;

import java.io.Closeable;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ScheduledFuture;
/* loaded from: classes2.dex */
public class e implements Closeable {
    private boolean closed;
    private final List<d> jS;
    private ScheduledFuture<?> jT;
    private boolean jU;
    private final Object lock;

    public boolean bb() {
        boolean z;
        synchronized (this.lock) {
            bc();
            z = this.jU;
        }
        return z;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.lock) {
            if (!this.closed) {
                bd();
                for (d dVar : this.jS) {
                    dVar.close();
                }
                this.jS.clear();
                this.closed = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(d dVar) {
        synchronized (this.lock) {
            bc();
            this.jS.remove(dVar);
        }
    }

    public String toString() {
        return String.format(Locale.US, "%s@%s[cancellationRequested=%s]", getClass().getName(), Integer.toHexString(hashCode()), Boolean.toString(bb()));
    }

    private void bc() {
        if (this.closed) {
            throw new IllegalStateException("Object already closed");
        }
    }

    private void bd() {
        if (this.jT != null) {
            this.jT.cancel(true);
            this.jT = null;
        }
    }
}
