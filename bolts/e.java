package bolts;

import java.io.Closeable;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ScheduledFuture;
/* loaded from: classes12.dex */
public class e implements Closeable {
    private final List<d> Af;
    private ScheduledFuture<?> Ag;
    private boolean Ah;
    private boolean closed;
    private final Object lock;

    /* renamed from: if  reason: not valid java name */
    public boolean m8if() {
        boolean z;
        synchronized (this.lock) {
            ig();
            z = this.Ah;
        }
        return z;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.lock) {
            if (!this.closed) {
                ih();
                for (d dVar : this.Af) {
                    dVar.close();
                }
                this.Af.clear();
                this.closed = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(d dVar) {
        synchronized (this.lock) {
            ig();
            this.Af.remove(dVar);
        }
    }

    public String toString() {
        return String.format(Locale.US, "%s@%s[cancellationRequested=%s]", getClass().getName(), Integer.toHexString(hashCode()), Boolean.toString(m8if()));
    }

    private void ig() {
        if (this.closed) {
            throw new IllegalStateException("Object already closed");
        }
    }

    private void ih() {
        if (this.Ag != null) {
            this.Ag.cancel(true);
            this.Ag = null;
        }
    }
}
