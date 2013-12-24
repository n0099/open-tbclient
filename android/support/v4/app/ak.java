package android.support.v4.app;

import android.os.Bundle;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ak implements android.support.v4.content.e<Object> {
    final int a;
    final Bundle b;
    ai<Object> c;
    android.support.v4.content.c<Object> d;
    boolean e;
    boolean f;
    Object g;
    boolean h;
    boolean i;
    boolean j;
    boolean k;
    boolean l;
    boolean m;
    ak n;
    final /* synthetic */ aj o;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        if (this.i && this.j) {
            this.h = true;
        } else if (!this.h) {
            this.h = true;
            if (aj.a) {
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
        if (aj.a) {
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
            if (aj.a) {
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
        if (aj.a) {
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
        if (aj.a) {
            Log.v("LoaderManager", "  Destroying: " + this);
        }
        this.l = true;
        boolean z = this.f;
        this.f = false;
        if (this.c != null && this.d != null && this.e && z) {
            if (aj.a) {
                Log.v("LoaderManager", "  Reseting: " + this);
            }
            if (this.o.e != null) {
                String str2 = this.o.e.mFragments.u;
                this.o.e.mFragments.u = "onLoaderReset";
                str = str2;
            } else {
                str = null;
            }
            try {
                this.c.a(this.d);
            } finally {
                if (this.o.e != null) {
                    this.o.e.mFragments.u = str;
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

    @Override // android.support.v4.content.e
    public void a(android.support.v4.content.c<Object> cVar, Object obj) {
        if (aj.a) {
            Log.v("LoaderManager", "onLoadComplete: " + this);
        }
        if (this.l) {
            if (aj.a) {
                Log.v("LoaderManager", "  Ignoring load complete -- destroyed");
            }
        } else if (this.o.b.a(this.a) != this) {
            if (aj.a) {
                Log.v("LoaderManager", "  Ignoring load complete -- not active");
            }
        } else {
            ak akVar = this.n;
            if (akVar != null) {
                if (aj.a) {
                    Log.v("LoaderManager", "  Switching to pending loader: " + akVar);
                }
                this.n = null;
                this.o.b.b(this.a, null);
                f();
                this.o.a(akVar);
                return;
            }
            if (this.g != obj || !this.e) {
                this.g = obj;
                this.e = true;
                if (this.h) {
                    b(cVar, obj);
                }
            }
            ak a = this.o.c.a(this.a);
            if (a != null && a != this) {
                a.f = false;
                a.f();
                this.o.c.c(this.a);
            }
            if (this.o.e != null && !this.o.a()) {
                this.o.e.mFragments.d();
            }
        }
    }

    void b(android.support.v4.content.c<Object> cVar, Object obj) {
        String str;
        if (this.c != null) {
            if (this.o.e == null) {
                str = null;
            } else {
                String str2 = this.o.e.mFragments.u;
                this.o.e.mFragments.u = "onLoadFinished";
                str = str2;
            }
            try {
                if (aj.a) {
                    Log.v("LoaderManager", "  onLoadFinished in " + cVar + ": " + cVar.c(obj));
                }
                this.c.a((android.support.v4.content.c<android.support.v4.content.c<Object>>) cVar, (android.support.v4.content.c<Object>) obj);
                this.f = true;
            } finally {
                if (this.o.e != null) {
                    this.o.e.mFragments.u = str;
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
