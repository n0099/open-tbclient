package bolts;

import java.io.Closeable;
/* loaded from: classes19.dex */
public class d implements Closeable {
    private Runnable action;
    private boolean closed;
    private final Object lock;
    private e zv;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.lock) {
            if (!this.closed) {
                this.closed = true;
                this.zv.a(this);
                this.zv = null;
                this.action = null;
            }
        }
    }
}
