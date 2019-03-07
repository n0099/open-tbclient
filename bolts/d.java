package bolts;

import java.io.Closeable;
/* loaded from: classes2.dex */
public class d implements Closeable {
    private boolean closed;
    private e jQ;
    private Runnable jR;
    private final Object lock;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.lock) {
            if (!this.closed) {
                this.closed = true;
                this.jQ.a(this);
                this.jQ = null;
                this.jR = null;
            }
        }
    }
}
