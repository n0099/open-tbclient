package android.support.v4.app;

import android.os.Bundle;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class x implements android.support.v4.content.d {
    final int a;
    final Bundle b;
    v c;
    android.support.v4.content.b d;
    boolean e;
    boolean f;
    Object g;
    boolean h;
    boolean i;
    boolean j;
    boolean k;
    boolean l;
    boolean m;
    x n;
    final /* synthetic */ w o;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        if (this.i && this.j) {
            this.h = true;
        } else if (!this.h) {
            this.h = true;
            if (w.a) {
                Log.v("LoaderManager", "  Starting: " + this);
            }
            if (this.d == null && this.c != null) {
                this.d = this.c.a(this.a, this.b);
            }
            if (this.d != null) {
                if (this.d.getClass().isMemberClass() && !Modifier.isStatic(this.d.getClass().getModifiers())) {
                    throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.d);
                }
                if (!this.m) {
                    this.d.a(this.a, this);
                    this.m = true;
                }
                this.d.n();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        if (w.a) {
            Log.v("LoaderManager", "  Retaining: " + this);
        }
        this.i = true;
        this.j = this.h;
        this.h = false;
        this.c = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        if (this.i) {
            if (w.a) {
                Log.v("LoaderManager", "  Finished Retaining: " + this);
            }
            this.i = false;
            if (this.h != this.j && !this.h) {
                e();
            }
        }
        if (this.h && this.e && !this.k) {
            b(this.d, this.g);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        if (this.h && this.k) {
            this.k = false;
            if (this.e) {
                b(this.d, this.g);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        if (w.a) {
            Log.v("LoaderManager", "  Stopping: " + this);
        }
        this.h = false;
        if (!this.i && this.d != null && this.m) {
            this.m = false;
            this.d.a(this);
            this.d.p();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        String str;
        if (w.a) {
            Log.v("LoaderManager", "  Destroying: " + this);
        }
        this.l = true;
        boolean z = this.f;
        this.f = false;
        if (this.c != null && this.d != null && this.e && z) {
            if (w.a) {
                Log.v("LoaderManager", "  Reseting: " + this);
            }
            if (this.o.d != null) {
                String str2 = this.o.d.b.s;
                this.o.d.b.s = "onLoaderReset";
                str = str2;
            } else {
                str = null;
            }
            try {
                this.c.a(this.d);
            } finally {
                if (this.o.d != null) {
                    this.o.d.b.s = str;
                }
            }
        }
        this.c = null;
        this.g = null;
        this.e = false;
        if (this.d != null) {
            if (this.m) {
                this.m = false;
                this.d.a(this);
            }
            this.d.q();
        }
        if (this.n != null) {
            this.n.f();
        }
    }

    @Override // android.support.v4.content.d
    public void a(android.support.v4.content.b bVar, Object obj) {
        if (w.a) {
            Log.v("LoaderManager", "onLoadComplete: " + this);
        }
        if (this.l) {
            if (w.a) {
                Log.v("LoaderManager", "  Ignoring load complete -- destroyed");
            }
        } else if (this.o.b.a(this.a) != this) {
            if (w.a) {
                Log.v("LoaderManager", "  Ignoring load complete -- not active");
            }
        } else {
            x xVar = this.n;
            if (xVar != null) {
                if (w.a) {
                    Log.v("LoaderManager", "  Switching to pending loader: " + xVar);
                }
                this.n = null;
                this.o.b.b(this.a, null);
                f();
                this.o.a(xVar);
                return;
            }
            if (this.g != obj || !this.e) {
                this.g = obj;
                this.e = true;
                if (this.h) {
                    b(bVar, obj);
                }
            }
            x xVar2 = (x) this.o.c.a(this.a);
            if (xVar2 != null && xVar2 != this) {
                xVar2.f = false;
                xVar2.f();
                this.o.c.c(this.a);
            }
            if (this.o.d != null && !this.o.a()) {
                this.o.d.b.d();
            }
        }
    }

    void b(android.support.v4.content.b bVar, Object obj) {
        String str;
        if (this.c != null) {
            if (this.o.d == null) {
                str = null;
            } else {
                String str2 = this.o.d.b.s;
                this.o.d.b.s = "onLoadFinished";
                str = str2;
            }
            try {
                if (w.a) {
                    Log.v("LoaderManager", "  onLoadFinished in " + bVar + ": " + bVar.c(obj));
                }
                this.c.a(bVar, obj);
                this.f = true;
            } finally {
                if (this.o.d != null) {
                    this.o.d.b.s = str;
                }
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append("LoaderInfo{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" #");
        sb.append(this.a);
        sb.append(" : ");
        android.support.v4.b.a.a(this.d, sb);
        sb.append("}}");
        return sb.toString();
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.a);
        printWriter.print(" mArgs=");
        printWriter.println(this.b);
        printWriter.print(str);
        printWriter.print("mCallbacks=");
        printWriter.println(this.c);
        printWriter.print(str);
        printWriter.print("mLoader=");
        printWriter.println(this.d);
        if (this.d != null) {
            this.d.a(str + "  ", fileDescriptor, printWriter, strArr);
        }
        if (this.e || this.f) {
            printWriter.print(str);
            printWriter.print("mHaveData=");
            printWriter.print(this.e);
            printWriter.print("  mDeliveredData=");
            printWriter.println(this.f);
            printWriter.print(str);
            printWriter.print("mData=");
            printWriter.println(this.g);
        }
        printWriter.print(str);
        printWriter.print("mStarted=");
        printWriter.print(this.h);
        printWriter.print(" mReportNextStart=");
        printWriter.print(this.k);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.l);
        printWriter.print(str);
        printWriter.print("mRetaining=");
        printWriter.print(this.i);
        printWriter.print(" mRetainingStarted=");
        printWriter.print(this.j);
        printWriter.print(" mListenerRegistered=");
        printWriter.println(this.m);
        if (this.n != null) {
            printWriter.print(str);
            printWriter.println("Pending Loader ");
            printWriter.print(this.n);
            printWriter.println(":");
            this.n.a(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }
}
