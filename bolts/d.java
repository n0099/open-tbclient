package bolts;

import java.io.Closeable;
/* loaded from: classes7.dex */
public class d implements Closeable {
    private Runnable action;
    private e cY;
    private boolean closed;
    private final Object lock;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.lock) {
            if (!this.closed) {
                this.closed = true;
                this.cY.a(this);
                this.cY = null;
                this.action = null;
            }
        }
    }
}
