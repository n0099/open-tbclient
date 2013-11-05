package android.support.v4.content;

import android.os.Handler;
import android.os.SystemClock;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes.dex */
public abstract class AsyncTaskLoader<D> extends c<D> {

    /* renamed from: a  reason: collision with root package name */
    volatile AsyncTaskLoader<D>.a f307a;
    volatile AsyncTaskLoader<D>.a b;
    long c;
    long d;
    Handler e;

    public abstract D d();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class a extends ModernAsyncTask<Void, Void, D> implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        D f310a;
        boolean b;
        private CountDownLatch e = new CountDownLatch(1);

        a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.support.v4.content.ModernAsyncTask
        public D a(Void... voidArr) {
            this.f310a = (D) AsyncTaskLoader.this.e();
            return this.f310a;
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
                AsyncTaskLoader.this.a((AsyncTaskLoader<a>.a) this, (a) this.f310a);
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
        this.f307a = new a();
        c();
    }

    public boolean b() {
        boolean z = false;
        if (this.f307a != null) {
            if (this.b != null) {
                if (this.f307a.b) {
                    this.f307a.b = false;
                    this.e.removeCallbacks(this.f307a);
                }
                this.f307a = null;
            } else if (this.f307a.b) {
                this.f307a.b = false;
                this.e.removeCallbacks(this.f307a);
                this.f307a = null;
            } else {
                z = this.f307a.a(false);
                if (z) {
                    this.b = this.f307a;
                }
                this.f307a = null;
            }
        }
        return z;
    }

    public void a(D d) {
    }

    void c() {
        if (this.b == null && this.f307a != null) {
            if (this.f307a.b) {
                this.f307a.b = false;
                this.e.removeCallbacks(this.f307a);
            }
            if (this.c > 0 && SystemClock.uptimeMillis() < this.d + this.c) {
                this.f307a.b = true;
                this.e.postAtTime(this.f307a, this.d + this.c);
                return;
            }
            this.f307a.a(ModernAsyncTask.d, null);
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
        if (this.f307a != aVar) {
            a((AsyncTaskLoader<AsyncTaskLoader<D>.a>.a) aVar, (AsyncTaskLoader<D>.a) d);
        } else if (l()) {
            a((AsyncTaskLoader<D>) d);
        } else {
            this.d = SystemClock.uptimeMillis();
            this.f307a = null;
            b(d);
        }
    }

    protected D e() {
        return d();
    }

    @Override // android.support.v4.content.c
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.a(str, fileDescriptor, printWriter, strArr);
        if (this.f307a != null) {
            printWriter.print(str);
            printWriter.print("mTask=");
            printWriter.print(this.f307a);
            printWriter.print(" waiting=");
            printWriter.println(this.f307a.b);
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
