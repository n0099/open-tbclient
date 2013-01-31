package android.support.v4.content;

import android.content.Context;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* loaded from: classes.dex */
public class b {
    int m;
    d n;
    Context o;
    boolean p;
    boolean q;
    boolean r;
    boolean s;

    public void b(Object obj) {
        if (this.n != null) {
            this.n.a(this, obj);
        }
    }

    public Context j() {
        return this.o;
    }

    public void a(int i, d dVar) {
        if (this.n != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.n = dVar;
        this.m = i;
    }

    public void a(d dVar) {
        if (this.n == null) {
            throw new IllegalStateException("No listener register");
        }
        if (this.n != dVar) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
        this.n = null;
    }

    public boolean k() {
        return this.p;
    }

    public boolean l() {
        return this.q;
    }

    public boolean m() {
        return this.r;
    }

    public final void n() {
        this.p = true;
        this.r = false;
        this.q = false;
        g();
    }

    protected void g() {
    }

    public void o() {
        a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
    }

    public void p() {
        this.p = false;
        h();
    }

    protected void h() {
    }

    public void q() {
        i();
        this.r = true;
        this.p = false;
        this.q = false;
        this.s = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i() {
    }

    public boolean r() {
        boolean z = this.s;
        this.s = false;
        return z;
    }

    public void s() {
        if (this.p) {
            o();
        } else {
            this.s = true;
        }
    }

    public String c(Object obj) {
        StringBuilder sb = new StringBuilder(64);
        android.support.v4.b.a.a(obj, sb);
        sb.append("}");
        return sb.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        android.support.v4.b.a.a(this, sb);
        sb.append(" id=");
        sb.append(this.m);
        sb.append("}");
        return sb.toString();
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.m);
        printWriter.print(" mListener=");
        printWriter.println(this.n);
        printWriter.print(str);
        printWriter.print("mStarted=");
        printWriter.print(this.p);
        printWriter.print(" mContentChanged=");
        printWriter.print(this.s);
        printWriter.print(" mAbandoned=");
        printWriter.print(this.q);
        printWriter.print(" mReset=");
        printWriter.println(this.r);
    }
}
