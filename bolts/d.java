package bolts;

import java.io.Closeable;
/* loaded from: classes6.dex */
public class d implements Closeable {
    private Runnable action;
    private boolean closed;
    private final Object lock;
    private e zH;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.lock) {
            if (!this.closed) {
                this.closed = true;
                this.zH.a(this);
                this.zH = null;
                this.action = null;
            }
        }
    }
}
