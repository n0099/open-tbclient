package bolts;

import java.io.Closeable;
/* loaded from: classes19.dex */
public class d implements Closeable {
    private e Av;
    private Runnable action;
    private boolean closed;
    private final Object lock;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.lock) {
            if (!this.closed) {
                this.closed = true;
                this.Av.a(this);
                this.Av = null;
                this.action = null;
            }
        }
    }
}
