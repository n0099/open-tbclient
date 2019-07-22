package bolts;

import java.io.Closeable;
/* loaded from: classes2.dex */
public class d implements Closeable {
    private boolean closed;
    private e jP;
    private Runnable jQ;
    private final Object lock;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.lock) {
            if (!this.closed) {
                this.closed = true;
                this.jP.a(this);
                this.jP = null;
                this.jQ = null;
            }
        }
    }
}
