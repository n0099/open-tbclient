package android.support.v4.app;

import android.util.Log;
import com.baidu.zeus.bouncycastle.DERTags;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class i extends ae implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final v f283a;
    j b;
    j c;
    int d;
    int e;
    int f;
    int g;
    int h;
    int i;
    int j;
    boolean k;
    String m;
    boolean n;
    int p;
    CharSequence q;
    int r;
    CharSequence s;
    boolean l = true;
    int o = -1;

    public String toString() {
        StringBuilder sb = new StringBuilder((int) DERTags.TAGGED);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.o >= 0) {
            sb.append(" #");
            sb.append(this.o);
        }
        if (this.m != null) {
            sb.append(" ");
            sb.append(this.m);
        }
        sb.append("}");
        return sb.toString();
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        a(str, printWriter, true);
    }

    public void a(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.m);
            printWriter.print(" mIndex=");
            printWriter.print(this.o);
            printWriter.print(" mCommitted=");
            printWriter.println(this.n);
            if (this.i != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.i));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.j));
            }
            if (this.e != 0 || this.f != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.e));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f));
            }
            if (this.g != 0 || this.h != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.g));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.h));
            }
            if (this.p != 0 || this.q != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.p));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.q);
            }
            if (this.r != 0 || this.s != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.r));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.s);
            }
        }
        if (this.b != null) {
            printWriter.print(str);
            printWriter.println("Operations:");
            String str3 = str + "    ";
            int i = 0;
            j jVar = this.b;
            while (jVar != null) {
                switch (jVar.c) {
                    case 0:
                        str2 = "NULL";
                        break;
                    case 1:
                        str2 = "ADD";
                        break;
                    case 2:
                        str2 = "REPLACE";
                        break;
                    case 3:
                        str2 = "REMOVE";
                        break;
                    case 4:
                        str2 = "HIDE";
                        break;
                    case 5:
                        str2 = "SHOW";
                        break;
                    case 6:
                        str2 = "DETACH";
                        break;
                    case 7:
                        str2 = "ATTACH";
                        break;
                    default:
                        str2 = "cmd=" + jVar.c;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.print(str2);
                printWriter.print(" ");
                printWriter.println(jVar.d);
                if (z) {
                    if (jVar.e != 0 || jVar.f != 0) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(jVar.e));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(jVar.f));
                    }
                    if (jVar.g != 0 || jVar.h != 0) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(jVar.g));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(jVar.h));
                    }
                }
                if (jVar.i != null && jVar.i.size() > 0) {
                    for (int i2 = 0; i2 < jVar.i.size(); i2++) {
                        printWriter.print(str3);
                        if (jVar.i.size() == 1) {
                            printWriter.print("Removed: ");
                        } else {
                            if (i2 == 0) {
                                printWriter.println("Removed:");
                            }
                            printWriter.print(str3);
                            printWriter.print("  #");
                            printWriter.print(i2);
                            printWriter.print(": ");
                        }
                        printWriter.println(jVar.i.get(i2));
                    }
                }
                jVar = jVar.f284a;
                i++;
            }
        }
    }

    public i(v vVar) {
        this.f283a = vVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(j jVar) {
        if (this.b == null) {
            this.c = jVar;
            this.b = jVar;
        } else {
            jVar.b = this.c;
            this.c.f284a = jVar;
            this.c = jVar;
        }
        jVar.e = this.e;
        jVar.f = this.f;
        jVar.g = this.g;
        jVar.h = this.h;
        this.d++;
    }

    @Override // android.support.v4.app.ae
    public ae a(int i, Fragment fragment, String str) {
        a(i, fragment, str, 1);
        return this;
    }

    private void a(int i, Fragment fragment, String str, int i2) {
        fragment.B = this.f283a;
        if (str != null) {
            if (fragment.H != null && !str.equals(fragment.H)) {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.H + " now " + str);
            }
            fragment.H = str;
        }
        if (i != 0) {
            if (fragment.F != 0 && fragment.F != i) {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.F + " now " + i);
            }
            fragment.F = i;
            fragment.G = i;
        }
        j jVar = new j();
        jVar.c = i2;
        jVar.d = fragment;
        a(jVar);
    }

    @Override // android.support.v4.app.ae
    public ae a(Fragment fragment) {
        j jVar = new j();
        jVar.c = 3;
        jVar.d = fragment;
        a(jVar);
        return this;
    }

    @Override // android.support.v4.app.ae
    public ae b(Fragment fragment) {
        j jVar = new j();
        jVar.c = 6;
        jVar.d = fragment;
        a(jVar);
        return this;
    }

    @Override // android.support.v4.app.ae
    public ae c(Fragment fragment) {
        j jVar = new j();
        jVar.c = 7;
        jVar.d = fragment;
        a(jVar);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        if (this.k) {
            if (v.f290a) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i);
            }
            for (j jVar = this.b; jVar != null; jVar = jVar.f284a) {
                if (jVar.d != null) {
                    jVar.d.A += i;
                    if (v.f290a) {
                        Log.v("FragmentManager", "Bump nesting of " + jVar.d + " to " + jVar.d.A);
                    }
                }
                if (jVar.i != null) {
                    for (int size = jVar.i.size() - 1; size >= 0; size--) {
                        Fragment fragment = (Fragment) jVar.i.get(size);
                        fragment.A += i;
                        if (v.f290a) {
                            Log.v("FragmentManager", "Bump nesting of " + fragment + " to " + fragment.A);
                        }
                    }
                }
            }
        }
    }

    @Override // android.support.v4.app.ae
    public int a() {
        return a(false);
    }

    @Override // android.support.v4.app.ae
    public int b() {
        return a(true);
    }

    int a(boolean z) {
        if (this.n) {
            throw new IllegalStateException("commit already called");
        }
        if (v.f290a) {
            Log.v("FragmentManager", "Commit: " + this);
            a("  ", (FileDescriptor) null, new PrintWriter(new android.support.v4.b.b("FragmentManager")), (String[]) null);
        }
        this.n = true;
        if (this.k) {
            this.o = this.f283a.a(this);
        } else {
            this.o = -1;
        }
        this.f283a.a(this, z);
        return this.o;
    }

    @Override // java.lang.Runnable
    public void run() {
        Fragment fragment;
        if (v.f290a) {
            Log.v("FragmentManager", "Run: " + this);
        }
        if (this.k && this.o < 0) {
            throw new IllegalStateException("addToBackStack() called after commit()");
        }
        a(1);
        for (j jVar = this.b; jVar != null; jVar = jVar.f284a) {
            switch (jVar.c) {
                case 1:
                    Fragment fragment2 = jVar.d;
                    fragment2.P = jVar.e;
                    this.f283a.a(fragment2, false);
                    break;
                case 2:
                    Fragment fragment3 = jVar.d;
                    if (this.f283a.g != null) {
                        fragment = fragment3;
                        for (int i = 0; i < this.f283a.g.size(); i++) {
                            Fragment fragment4 = (Fragment) this.f283a.g.get(i);
                            if (v.f290a) {
                                Log.v("FragmentManager", "OP_REPLACE: adding=" + fragment + " old=" + fragment4);
                            }
                            if (fragment == null || fragment4.G == fragment.G) {
                                if (fragment4 == fragment) {
                                    fragment = null;
                                    jVar.d = null;
                                } else {
                                    if (jVar.i == null) {
                                        jVar.i = new ArrayList();
                                    }
                                    jVar.i.add(fragment4);
                                    fragment4.P = jVar.f;
                                    if (this.k) {
                                        fragment4.A++;
                                        if (v.f290a) {
                                            Log.v("FragmentManager", "Bump nesting of " + fragment4 + " to " + fragment4.A);
                                        }
                                    }
                                    this.f283a.a(fragment4, this.i, this.j);
                                }
                            }
                        }
                    } else {
                        fragment = fragment3;
                    }
                    if (fragment != null) {
                        fragment.P = jVar.e;
                        this.f283a.a(fragment, false);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    Fragment fragment5 = jVar.d;
                    fragment5.P = jVar.f;
                    this.f283a.a(fragment5, this.i, this.j);
                    break;
                case 4:
                    Fragment fragment6 = jVar.d;
                    fragment6.P = jVar.f;
                    this.f283a.b(fragment6, this.i, this.j);
                    break;
                case 5:
                    Fragment fragment7 = jVar.d;
                    fragment7.P = jVar.e;
                    this.f283a.c(fragment7, this.i, this.j);
                    break;
                case 6:
                    Fragment fragment8 = jVar.d;
                    fragment8.P = jVar.f;
                    this.f283a.d(fragment8, this.i, this.j);
                    break;
                case 7:
                    Fragment fragment9 = jVar.d;
                    fragment9.P = jVar.e;
                    this.f283a.e(fragment9, this.i, this.j);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + jVar.c);
            }
        }
        this.f283a.a(this.f283a.n, this.i, this.j, true);
        if (this.k) {
            this.f283a.b(this);
        }
    }

    public void b(boolean z) {
        if (v.f290a) {
            Log.v("FragmentManager", "popFromBackStack: " + this);
            a("  ", (FileDescriptor) null, new PrintWriter(new android.support.v4.b.b("FragmentManager")), (String[]) null);
        }
        a(-1);
        for (j jVar = this.c; jVar != null; jVar = jVar.b) {
            switch (jVar.c) {
                case 1:
                    Fragment fragment = jVar.d;
                    fragment.P = jVar.h;
                    this.f283a.a(fragment, v.c(this.i), this.j);
                    break;
                case 2:
                    Fragment fragment2 = jVar.d;
                    if (fragment2 != null) {
                        fragment2.P = jVar.h;
                        this.f283a.a(fragment2, v.c(this.i), this.j);
                    }
                    if (jVar.i != null) {
                        for (int i = 0; i < jVar.i.size(); i++) {
                            Fragment fragment3 = (Fragment) jVar.i.get(i);
                            fragment3.P = jVar.g;
                            this.f283a.a(fragment3, false);
                        }
                        break;
                    } else {
                        break;
                    }
                case 3:
                    Fragment fragment4 = jVar.d;
                    fragment4.P = jVar.g;
                    this.f283a.a(fragment4, false);
                    break;
                case 4:
                    Fragment fragment5 = jVar.d;
                    fragment5.P = jVar.g;
                    this.f283a.c(fragment5, v.c(this.i), this.j);
                    break;
                case 5:
                    Fragment fragment6 = jVar.d;
                    fragment6.P = jVar.h;
                    this.f283a.b(fragment6, v.c(this.i), this.j);
                    break;
                case 6:
                    Fragment fragment7 = jVar.d;
                    fragment7.P = jVar.g;
                    this.f283a.e(fragment7, v.c(this.i), this.j);
                    break;
                case 7:
                    Fragment fragment8 = jVar.d;
                    fragment8.P = jVar.g;
                    this.f283a.d(fragment8, v.c(this.i), this.j);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + jVar.c);
            }
        }
        if (z) {
            this.f283a.a(this.f283a.n, v.c(this.i), this.j, true);
        }
        if (this.o >= 0) {
            this.f283a.b(this.o);
            this.o = -1;
        }
    }

    public String c() {
        return this.m;
    }
}
