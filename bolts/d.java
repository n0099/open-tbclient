package bolts;

import java.io.Closeable;
/* loaded from: classes7.dex */
public class d implements Closeable {
    private Runnable action;
    private boolean closed;
    private final Object lock;
    private e yT;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.lock) {
            if (!this.closed) {
                this.closed = true;
                this.yT.a(this);
                this.yT = null;
                this.action = null;
            }
        }
    }
}
