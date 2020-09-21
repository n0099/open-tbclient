package bolts;

import java.io.Closeable;
/* loaded from: classes16.dex */
public class d implements Closeable {
    private e Ae;
    private Runnable action;
    private boolean closed;
    private final Object lock;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.lock) {
            if (!this.closed) {
                this.closed = true;
                this.Ae.a(this);
                this.Ae = null;
                this.action = null;
            }
        }
    }
}
