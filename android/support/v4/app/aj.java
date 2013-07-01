package android.support.v4.app;

import android.util.Log;
import com.baidu.zeus.bouncycastle.DERTags;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj extends ah {

    /* renamed from: a  reason: collision with root package name */
    static boolean f53a = false;
    final android.support.v4.b.c b = new android.support.v4.b.c();
    final android.support.v4.b.c c = new android.support.v4.b.c();
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
        this.b.b(akVar.f54a, akVar);
        if (this.f) {
            akVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        if (f53a) {
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
            ((ak) this.b.e(a2)).a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        if (f53a) {
            Log.v("LoaderManager", "Stopping in " + this);
        }
        if (!this.f) {
            RuntimeException runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w("LoaderManager", "Called doStop when not started: " + this, runtimeException);
            return;
        }
        for (int a2 = this.b.a() - 1; a2 >= 0; a2--) {
            ((ak) this.b.e(a2)).e();
        }
        this.f = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        if (f53a) {
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
            ((ak) this.b.e(a2)).b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        if (this.g) {
            if (f53a) {
                Log.v("LoaderManager", "Finished Retaining in " + this);
            }
            this.g = false;
            for (int a2 = this.b.a() - 1; a2 >= 0; a2--) {
                ((ak) this.b.e(a2)).c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        for (int a2 = this.b.a() - 1; a2 >= 0; a2--) {
            ((ak) this.b.e(a2)).k = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g() {
        for (int a2 = this.b.a() - 1; a2 >= 0; a2--) {
            ((ak) this.b.e(a2)).d();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        if (!this.g) {
            if (f53a) {
                Log.v("LoaderManager", "Destroying Active in " + this);
            }
            for (int a2 = this.b.a() - 1; a2 >= 0; a2--) {
                ((ak) this.b.e(a2)).f();
            }
        }
        if (f53a) {
            Log.v("LoaderManager", "Destroying Inactive in " + this);
        }
        for (int a3 = this.c.a() - 1; a3 >= 0; a3--) {
            ((ak) this.c.e(a3)).f();
        }
        this.c.b();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((int) DERTags.TAGGED);
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
                ak akVar = (ak) this.b.e(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.b.d(i));
                printWriter.print(": ");
                printWriter.println(akVar.toString());
                akVar.a(str2, fileDescriptor, printWriter, strArr);
            }
        }
        if (this.c.a() > 0) {
            printWriter.print(str);
            printWriter.println("Inactive Loaders:");
            String str3 = str + "    ";
            for (int i2 = 0; i2 < this.c.a(); i2++) {
                ak akVar2 = (ak) this.c.e(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.c.d(i2));
                printWriter.print(": ");
                printWriter.println(akVar2.toString());
                akVar2.a(str3, fileDescriptor, printWriter, strArr);
            }
        }
    }

    @Override // android.support.v4.app.ah
    public boolean a() {
        int a2 = this.b.a();
        boolean z = false;
        for (int i = 0; i < a2; i++) {
            ak akVar = (ak) this.b.e(i);
            z |= akVar.h && !akVar.f;
        }
        return z;
    }
}
