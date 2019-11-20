package bolts;

import java.io.Closeable;
/* loaded from: classes2.dex */
public class d implements Closeable {
    private e bZ;
    private Runnable ca;
    private boolean closed;
    private final Object lock;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.lock) {
            if (!this.closed) {
                this.closed = true;
                this.bZ.a(this);
                this.bZ = null;
                this.ca = null;
            }
        }
    }
}
