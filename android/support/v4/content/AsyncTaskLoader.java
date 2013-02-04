package android.support.v4.content;

import android.os.Handler;
import android.os.SystemClock;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* loaded from: classes.dex */
public abstract class AsyncTaskLoader extends b {
    volatile a a;
    volatile a b;
    long c;
    long d;
    Handler e;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.content.b
    public void a() {
        super.a();
        b();
        this.a = new a(this);
        c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(a aVar, Object obj) {
        a(obj);
        if (this.b == aVar) {
            this.d = SystemClock.uptimeMillis();
            this.b = null;
            c();
        }
    }

    public void a(Object obj) {
    }

    @Override // android.support.v4.content.b
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
            android.support.v4.b.c.a(this.c, printWriter);
            printWriter.print(" mLastLoadCompleteTime=");
            android.support.v4.b.c.a(this.d, SystemClock.uptimeMillis(), printWriter);
            printWriter.println();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(a aVar, Object obj) {
        if (this.a != aVar) {
            a(aVar, obj);
        } else if (l()) {
            a(obj);
        } else {
            this.d = SystemClock.uptimeMillis();
            this.a = null;
            b(obj);
        }
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        if (this.b != null || this.a == null) {
            return;
        }
        if (this.a.b) {
            this.a.b = false;
            this.e.removeCallbacks(this.a);
        }
        if (this.c <= 0 || SystemClock.uptimeMillis() >= this.d + this.c) {
            this.a.a(e.d, (Object[]) null);
            return;
        }
        this.a.b = true;
        this.e.postAtTime(this.a, this.d + this.c);
    }

    public abstract Object d();

    /* JADX INFO: Access modifiers changed from: protected */
    public Object e() {
        return d();
    }
}
