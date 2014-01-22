package android.support.v4.app;

import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj extends ah {
    static boolean a = false;
    final android.support.v4.b.c<ak> b = new android.support.v4.b.c<>();
    final android.support.v4.b.c<ak> c = new android.support.v4.b.c<>();
    final String d;
    n e;
    boolean f;
    boolean g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(String str, n nVar, boolean z) {
        this.d = str;
        this.e = nVar;
        this.f = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(n nVar) {
        this.e = nVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ak akVar) {
        this.b.b(akVar.a, akVar);
        if (this.f) {
            akVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        if (a) {
            Log.v("LoaderManager", "Starting in " + this);
        }
        if (this.f) {
            RuntimeException runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w("LoaderManager", "Called doStart when already started: " + this, runtimeException);
            return;
        }
        this.f = true;
        for (int a2 = this.b.a() - 1; a2 >= 0; a2--) {
            this.b.e(a2).a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        if (a) {
            Log.v("LoaderManager", "Stopping in " + this);
        }
        if (!this.f) {
            RuntimeException runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w("LoaderManager", "Called doStop when not started: " + this, runtimeException);
            return;
        }
        for (int a2 = this.b.a() - 1; a2 >= 0; a2--) {
            this.b.e(a2).e();
        }
        this.f = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        if (a) {
            Log.v("LoaderManager", "Retaining in " + this);
        }
        if (!this.f) {
            RuntimeException runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w("LoaderManager", "Called doRetain when not started: " + this, runtimeException);
            return;
        }
        this.g = true;
        this.f = false;
        for (int a2 = this.b.a() - 1; a2 >= 0; a2--) {
            this.b.e(a2).b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        if (this.g) {
            if (a) {
                Log.v("LoaderManager", "Finished Retaining in " + this);
            }
            this.g = false;
            for (int a2 = this.b.a() - 1; a2 >= 0; a2--) {
                this.b.e(a2).c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        for (int a2 = this.b.a() - 1; a2 >= 0; a2--) {
            this.b.e(a2).k = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g() {
        for (int a2 = this.b.a() - 1; a2 >= 0; a2--) {
            this.b.e(a2).d();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        if (!this.g) {
            if (a) {
                Log.v("LoaderManager", "Destroying Active in " + this);
            }
            for (int a2 = this.b.a() - 1; a2 >= 0; a2--) {
                this.b.e(a2).f();
            }
        }
        if (a) {
            Log.v("LoaderManager", "Destroying Inactive in " + this);
        }
        for (int a3 = this.c.a() - 1; a3 >= 0; a3--) {
            this.c.e(a3).f();
        }
        this.c.b();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        android.support.v4.b.a.a(this.e, sb);
        sb.append("}}");
        return sb.toString();
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        if (this.b.a() > 0) {
            printWriter.print(str);
            printWriter.println("Active Loaders:");
            String str2 = str + "    ";
            for (int i = 0; i < this.b.a(); i++) {
                ak e = this.b.e(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.b.d(i));
                printWriter.print(": ");
                printWriter.println(e.toString());
                e.a(str2, fileDescriptor, printWriter, strArr);
            }
        }
        if (this.c.a() > 0) {
            printWriter.print(str);
            printWriter.println("Inactive Loaders:");
            String str3 = str + "    ";
            for (int i2 = 0; i2 < this.c.a(); i2++) {
                ak e2 = this.c.e(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.c.d(i2));
                printWriter.print(": ");
                printWriter.println(e2.toString());
                e2.a(str3, fileDescriptor, printWriter, strArr);
            }
        }
    }

    @Override // android.support.v4.app.ah
    public boolean a() {
        int a2 = this.b.a();
        boolean z = false;
        for (int i = 0; i < a2; i++) {
            ak e = this.b.e(i);
            z |= e.h && !e.f;
        }
        return z;
    }
}
