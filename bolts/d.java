package bolts;

import java.io.Closeable;
/* loaded from: classes10.dex */
public class d implements Closeable {
    private e Bp;
    private Runnable action;
    private boolean closed;
    private final Object lock;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.lock) {
            if (!this.closed) {
                this.closed = true;
                this.Bp.a(this);
                this.Bp = null;
                this.action = null;
            }
        }
    }
}
