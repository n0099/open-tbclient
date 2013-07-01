package android.support.v4.content;

import android.os.Handler;
import android.os.SystemClock;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* loaded from: classes.dex */
public abstract class AsyncTaskLoader extends c {

    /* renamed from: a  reason: collision with root package name */
    volatile a f72a;
    volatile a b;
    long c;
    long d;
    Handler e;

    public abstract Object d();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.content.c
    public void a() {
        super.a();
        b();
        this.f72a = new a(this);
        c();
    }

    public boolean b() {
        boolean z = false;
        if (this.f72a != null) {
            if (this.b != null) {
                if (this.f72a.b) {
                    this.f72a.b = false;
                    this.e.removeCallbacks(this.f72a);
                }
                this.f72a = null;
            } else if (this.f72a.b) {
                this.f72a.b = false;
                this.e.removeCallbacks(this.f72a);
                this.f72a = null;
            } else {
                z = this.f72a.a(false);
                if (z) {
                    this.b = this.f72a;
                }
                this.f72a = null;
            }
        }
        return z;
    }

    public void a(Object obj) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        if (this.b == null && this.f72a != null) {
            if (this.f72a.b) {
                this.f72a.b = false;
                this.e.removeCallbacks(this.f72a);
            }
            if (this.c > 0 && SystemClock.uptimeMillis() < this.d + this.c) {
                this.f72a.b = true;
                this.e.postAtTime(this.f72a, this.d + this.c);
                return;
            }
            this.f72a.a(ModernAsyncTask.d, (Object[]) null);
        }
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(a aVar, Object obj) {
        if (this.f72a != aVar) {
            a(aVar, obj);
        } else if (l()) {
            a(obj);
        } else {
            this.d = SystemClock.uptimeMillis();
            this.f72a = null;
            b(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object e() {
        return d();
    }

    @Override // android.support.v4.content.c
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.a(str, fileDescriptor, printWriter, strArr);
        if (this.f72a != null) {
            printWriter.print(str);
            printWriter.print("mTask=");
            printWriter.print(this.f72a);
            printWriter.print(" waiting=");
            printWriter.println(this.f72a.b);
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
