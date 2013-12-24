package android.support.v4.content;

import android.os.Handler;
import android.os.SystemClock;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes.dex */
public abstract class AsyncTaskLoader<D> extends c<D> {
    volatile AsyncTaskLoader<D>.a a;
    volatile AsyncTaskLoader<D>.a b;
    long c;
    long d;
    Handler e;

    public abstract D d();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class a extends ModernAsyncTask<Void, Void, D> implements Runnable {
        D a;
        boolean b;
        private CountDownLatch e = new CountDownLatch(1);

        a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.support.v4.content.ModernAsyncTask
        public D a(Void... voidArr) {
            this.a = (D) AsyncTaskLoader.this.e();
            return this.a;
        }

        @Override // android.support.v4.content.ModernAsyncTask
        protected void a(D d) {
            try {
                AsyncTaskLoader.this.b(this, d);
            } finally {
                this.e.countDown();
            }
        }

        @Override // android.support.v4.content.ModernAsyncTask
        protected void a() {
            try {
                AsyncTaskLoader.this.a((AsyncTaskLoader<a>.a) this, (a) this.a);
            } finally {
                this.e.countDown();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b = false;
            AsyncTaskLoader.this.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.content.c
    public void a() {
        super.a();
        b();
        this.a = new a();
        c();
    }

    public boolean b() {
        boolean z = false;
        if (this.a != null) {
            if (this.b != null) {
                if (this.a.b) {
                    this.a.b = false;
                    this.e.removeCallbacks(this.a);
                }
                this.a = null;
            } else if (this.a.b) {
                this.a.b = false;
                this.e.removeCallbacks(this.a);
                this.a = null;
            } else {
                z = this.a.a(false);
                if (z) {
                    this.b = this.a;
                }
                this.a = null;
            }
        }
        return z;
    }

    public void a(D d) {
    }

    void c() {
        if (this.b == null && this.a != null) {
            if (this.a.b) {
                this.a.b = false;
                this.e.removeCallbacks(this.a);
            }
            if (this.c > 0 && SystemClock.uptimeMillis() < this.d + this.c) {
                this.a.b = true;
                this.e.postAtTime(this.a, this.d + this.c);
                return;
            }
            this.a.a(ModernAsyncTask.d, null);
        }
    }

    void a(AsyncTaskLoader<D>.a aVar, D d) {
        a((AsyncTaskLoader<D>) d);
        if (this.b == aVar) {
            this.d = SystemClock.uptimeMillis();
            this.b = null;
            c();
        }
    }

    void b(AsyncTaskLoader<D>.a aVar, D d) {
        if (this.a != aVar) {
            a((AsyncTaskLoader<AsyncTaskLoader<D>.a>.a) aVar, (AsyncTaskLoader<D>.a) d);
        } else if (l()) {
            a((AsyncTaskLoader<D>) d);
        } else {
            this.d = SystemClock.uptimeMillis();
            this.a = null;
            b(d);
        }
    }

    protected D e() {
        return d();
    }

    @Override // android.support.v4.content.c
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.a(str, fileDescriptor, printWriter, strArr);
        if (this.a != null) {
            printWriter.print(str);
            printWriter.print("mTask=");
            printWriter.print(this.a);
            printWriter.print(" waiting=");
            printWriter.println(this.a.b);
        }
        if (this.b != null) {
            printWriter.print(str);
            printWriter.print("mCancellingTask=");
            printWriter.print(this.b);
            printWriter.print(" waiting=");
            printWriter.println(this.b.b);
        }
        if (this.c != 0) {
            printWriter.print(str);
            printWriter.print("mUpdateThrottle=");
            android.support.v4.b.d.a(this.c, printWriter);
            printWriter.print(" mLastLoadCompleteTime=");
            android.support.v4.b.d.a(this.d, SystemClock.uptimeMillis(), printWriter);
            printWriter.println();
        }
    }
}
