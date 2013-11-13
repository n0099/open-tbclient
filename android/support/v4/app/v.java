package android.support.v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import com.baidu.zeus.bouncycastle.DERTags;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class v extends t {
    static final Interpolator A;
    static final Interpolator B;
    static final Interpolator C;

    /* renamed from: a  reason: collision with root package name */
    static boolean f300a = false;
    static final boolean b;
    static final Interpolator z;
    ArrayList<Runnable> c;
    Runnable[] d;
    boolean e;
    ArrayList<Fragment> f;
    ArrayList<Fragment> g;
    ArrayList<Integer> h;
    ArrayList<i> i;
    ArrayList<Fragment> j;
    ArrayList<i> k;
    ArrayList<Integer> l;
    ArrayList<u> m;
    n o;
    s p;
    Fragment q;
    boolean r;
    boolean s;
    boolean t;
    String u;
    boolean v;
    int n = 0;
    Bundle w = null;
    SparseArray<Parcelable> x = null;
    Runnable y = new w(this);

    static {
        b = Build.VERSION.SDK_INT >= 11;
        z = new DecelerateInterpolator(2.5f);
        A = new DecelerateInterpolator(1.5f);
        B = new AccelerateInterpolator(2.5f);
        C = new AccelerateInterpolator(1.5f);
    }

    private void a(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new android.support.v4.b.b("FragmentManager"));
        if (this.o != null) {
            try {
                this.o.dump("  ", null, printWriter, new String[0]);
            } catch (Exception e) {
                Log.e("FragmentManager", "Failed dumping state", e);
            }
        } else {
            try {
                a("  ", (FileDescriptor) null, printWriter, new String[0]);
            } catch (Exception e2) {
                Log.e("FragmentManager", "Failed dumping state", e2);
            }
        }
        throw runtimeException;
    }

    @Override // android.support.v4.app.t
    public ae a() {
        return new i(this);
    }

    @Override // android.support.v4.app.t
    public boolean b() {
        return e();
    }

    public boolean c() {
        t();
        b();
        return a(this.o.mHandler, (String) null, -1, 0);
    }

    @Override // android.support.v4.app.t
    public void a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("Bad id: " + i);
        }
        a((Runnable) new x(this, i, i2), false);
    }

    public void a(Bundle bundle, String str, Fragment fragment) {
        if (fragment.o < 0) {
            a(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        bundle.putInt(str, fragment.o);
    }

    public Fragment a(Bundle bundle, String str) {
        int i = bundle.getInt(str, -1);
        if (i == -1) {
            return null;
        }
        if (i >= this.f.size()) {
            a(new IllegalStateException("Fragement no longer exists for key " + str + ": index " + i));
        }
        Fragment fragment = this.f.get(i);
        if (fragment == null) {
            a(new IllegalStateException("Fragement no longer exists for key " + str + ": index " + i));
            return fragment;
        }
        return fragment;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((int) DERTags.TAGGED);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        if (this.q != null) {
            android.support.v4.b.a.a(this.q, sb);
        } else {
            android.support.v4.b.a.a(this.o, sb);
        }
        sb.append("}}");
        return sb.toString();
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        int size3;
        int size4;
        int size5;
        int size6;
        String str2 = str + "    ";
        if (this.f != null && (size6 = this.f.size()) > 0) {
            printWriter.print(str);
            printWriter.print("Active Fragments in ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(":");
            for (int i = 0; i < size6; i++) {
                Fragment fragment = this.f.get(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.println(fragment);
                if (fragment != null) {
                    fragment.a(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
        if (this.g != null && (size5 = this.g.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i2 = 0; i2 < size5; i2++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(this.g.get(i2).toString());
            }
        }
        if (this.j != null && (size4 = this.j.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i3 = 0; i3 < size4; i3++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(this.j.get(i3).toString());
            }
        }
        if (this.i != null && (size3 = this.i.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i4 = 0; i4 < size3; i4++) {
                i iVar = this.i.get(i4);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i4);
                printWriter.print(": ");
                printWriter.println(iVar.toString());
                iVar.a(str2, fileDescriptor, printWriter, strArr);
            }
        }
        synchronized (this) {
            if (this.k != null && (size2 = this.k.size()) > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack Indices:");
                for (int i5 = 0; i5 < size2; i5++) {
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i5);
                    printWriter.print(": ");
                    printWriter.println((i) this.k.get(i5));
                }
            }
            if (this.l != null && this.l.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.l.toArray()));
            }
        }
        if (this.c != null && (size = this.c.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Pending Actions:");
            for (int i6 = 0; i6 < size; i6++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i6);
                printWriter.print(": ");
                printWriter.println((Runnable) this.c.get(i6));
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mActivity=");
        printWriter.println(this.o);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.p);
        if (this.q != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.q);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.n);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.s);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.t);
        if (this.r) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.r);
        }
        if (this.u != null) {
            printWriter.print(str);
            printWriter.print("  mNoTransactionsBecause=");
            printWriter.println(this.u);
        }
        if (this.h != null && this.h.size() > 0) {
            printWriter.print(str);
            printWriter.print("  mAvailIndices: ");
            printWriter.println(Arrays.toString(this.h.toArray()));
        }
    }

    static Animation a(Context context, float f, float f2, float f3, float f4) {
        AnimationSet animationSet = new AnimationSet(false);
        ScaleAnimation scaleAnimation = new ScaleAnimation(f, f2, f, f2, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(z);
        scaleAnimation.setDuration(220L);
        animationSet.addAnimation(scaleAnimation);
        AlphaAnimation alphaAnimation = new AlphaAnimation(f3, f4);
        alphaAnimation.setInterpolator(A);
        alphaAnimation.setDuration(220L);
        animationSet.addAnimation(alphaAnimation);
        return animationSet;
    }

    static Animation a(Context context, float f, float f2) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(f, f2);
        alphaAnimation.setInterpolator(A);
        alphaAnimation.setDuration(220L);
        return alphaAnimation;
    }

    Animation a(Fragment fragment, int i, boolean z2, int i2) {
        int b2;
        Animation loadAnimation;
        Animation a2 = fragment.a(i, z2, fragment.P);
        if (a2 == null) {
            if (fragment.P == 0 || (loadAnimation = AnimationUtils.loadAnimation(this.o, fragment.P)) == null) {
                if (i != 0 && (b2 = b(i, z2)) >= 0) {
                    switch (b2) {
                        case 1:
                            return a(this.o, 1.125f, 1.0f, 0.0f, 1.0f);
                        case 2:
                            return a(this.o, 1.0f, 0.975f, 1.0f, 0.0f);
                        case 3:
                            return a(this.o, 0.975f, 1.0f, 0.0f, 1.0f);
                        case 4:
                            return a(this.o, 1.0f, 1.075f, 1.0f, 0.0f);
                        case 5:
                            return a(this.o, 0.0f, 1.0f);
                        case 6:
                            return a(this.o, 1.0f, 0.0f);
                        default:
                            if (i2 == 0 && this.o.getWindow() != null) {
                                i2 = this.o.getWindow().getAttributes().windowAnimations;
                            }
                            return i2 == 0 ? null : null;
                    }
                }
                return null;
            }
            return loadAnimation;
        }
        return a2;
    }

    public void a(Fragment fragment) {
        if (fragment.T) {
            if (this.e) {
                this.v = true;
                return;
            }
            fragment.T = false;
            a(fragment, this.n, 0, 0, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:114:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x02ce  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Fragment fragment, int i, int i2, int i3, boolean z2) {
        ViewGroup viewGroup;
        if ((!fragment.u || fragment.J) && i > 1) {
            i = 1;
        }
        if (fragment.v && i > fragment.j) {
            i = fragment.j;
        }
        if (fragment.T && fragment.j < 4 && i > 3) {
            i = 3;
        }
        if (fragment.j < i) {
            if (!fragment.x || fragment.y) {
                if (fragment.k != null) {
                    fragment.k = null;
                    a(fragment, fragment.l, 0, 0, true);
                }
                switch (fragment.j) {
                    case 0:
                        if (f300a) {
                            Log.v("FragmentManager", "moveto CREATED: " + fragment);
                        }
                        if (fragment.m != null) {
                            fragment.n = fragment.m.getSparseParcelableArray("android:view_state");
                            fragment.r = a(fragment.m, "android:target_state");
                            if (fragment.r != null) {
                                fragment.t = fragment.m.getInt("android:target_req_state", 0);
                            }
                            fragment.U = fragment.m.getBoolean("android:user_visible_hint", true);
                            if (!fragment.U) {
                                fragment.T = true;
                                if (i > 3) {
                                    i = 3;
                                }
                            }
                        }
                        fragment.C = this.o;
                        fragment.E = this.q;
                        fragment.B = this.q != null ? this.q.D : this.o.mFragments;
                        fragment.O = false;
                        fragment.a(this.o);
                        if (!fragment.O) {
                            throw new SuperNotCalledException("Fragment " + fragment + " did not call through to super.onAttach()");
                        }
                        if (fragment.E == null) {
                            this.o.onAttachFragment(fragment);
                        }
                        if (!fragment.L) {
                            fragment.i(fragment.m);
                        }
                        fragment.L = false;
                        if (fragment.x) {
                            fragment.R = fragment.b(fragment.b(fragment.m), null, fragment.m);
                            if (fragment.R != null) {
                                fragment.S = fragment.R;
                                fragment.R = al.a(fragment.R);
                                if (fragment.I) {
                                    fragment.R.setVisibility(8);
                                }
                                fragment.a(fragment.R, fragment.m);
                            } else {
                                fragment.S = null;
                            }
                        }
                    case 1:
                        if (i > 1) {
                            if (f300a) {
                                Log.v("FragmentManager", "moveto ACTIVITY_CREATED: " + fragment);
                            }
                            if (!fragment.x) {
                                if (fragment.G != 0) {
                                    viewGroup = (ViewGroup) this.p.a(fragment.G);
                                    if (viewGroup == null && !fragment.z) {
                                        a(new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(fragment.G) + " (" + fragment.j().getResourceName(fragment.G) + ") for fragment " + fragment));
                                    }
                                } else {
                                    viewGroup = null;
                                }
                                fragment.Q = viewGroup;
                                fragment.R = fragment.b(fragment.b(fragment.m), viewGroup, fragment.m);
                                if (fragment.R != null) {
                                    fragment.S = fragment.R;
                                    fragment.R = al.a(fragment.R);
                                    if (viewGroup != null) {
                                        Animation a2 = a(fragment, i2, true, i3);
                                        if (a2 != null) {
                                            fragment.R.startAnimation(a2);
                                        }
                                        viewGroup.addView(fragment.R);
                                    }
                                    if (fragment.I) {
                                        fragment.R.setVisibility(8);
                                    }
                                    fragment.a(fragment.R, fragment.m);
                                } else {
                                    fragment.S = null;
                                }
                            }
                            fragment.j(fragment.m);
                            if (fragment.R != null) {
                                fragment.f(fragment.m);
                            }
                            fragment.m = null;
                        }
                        break;
                    case 2:
                    case 3:
                        if (i > 3) {
                            if (f300a) {
                                Log.v("FragmentManager", "moveto STARTED: " + fragment);
                            }
                            fragment.x();
                        }
                    case 4:
                        if (i > 4) {
                            if (f300a) {
                                Log.v("FragmentManager", "moveto RESUMED: " + fragment);
                            }
                            fragment.w = true;
                            fragment.y();
                            fragment.m = null;
                            fragment.n = null;
                            break;
                        }
                        break;
                }
            } else {
                return;
            }
        } else if (fragment.j > i) {
            switch (fragment.j) {
                case 1:
                    if (i < 1) {
                        if (this.t && fragment.k != null) {
                            View view = fragment.k;
                            fragment.k = null;
                            view.clearAnimation();
                        }
                        if (fragment.k != null) {
                            fragment.l = i;
                            i = 1;
                            break;
                        } else {
                            if (f300a) {
                                Log.v("FragmentManager", "movefrom CREATED: " + fragment);
                            }
                            if (!fragment.L) {
                                fragment.E();
                            }
                            fragment.O = false;
                            fragment.b();
                            if (!fragment.O) {
                                throw new SuperNotCalledException("Fragment " + fragment + " did not call through to super.onDetach()");
                            }
                            if (!z2) {
                                if (!fragment.L) {
                                    d(fragment);
                                    break;
                                } else {
                                    fragment.C = null;
                                    fragment.B = null;
                                    break;
                                }
                            }
                        }
                    }
                    break;
                case 2:
                    if (i < 2) {
                        if (f300a) {
                            Log.v("FragmentManager", "movefrom ACTIVITY_CREATED: " + fragment);
                        }
                        if (fragment.R != null && !this.o.isFinishing() && fragment.n == null) {
                            e(fragment);
                        }
                        fragment.D();
                        if (fragment.R != null && fragment.Q != null) {
                            Animation a3 = (this.n <= 0 || this.t) ? null : a(fragment, i2, false, i3);
                            if (a3 != null) {
                                fragment.k = fragment.R;
                                fragment.l = i;
                                a3.setAnimationListener(new y(this, fragment));
                                fragment.R.startAnimation(a3);
                            }
                            fragment.Q.removeView(fragment.R);
                        }
                        fragment.Q = null;
                        fragment.R = null;
                        fragment.S = null;
                    }
                    if (i < 1) {
                    }
                    break;
                case 3:
                    if (i < 3) {
                        if (f300a) {
                            Log.v("FragmentManager", "movefrom STOPPED: " + fragment);
                        }
                        fragment.C();
                    }
                    if (i < 2) {
                    }
                    if (i < 1) {
                    }
                    break;
                case 4:
                    if (i < 4) {
                        if (f300a) {
                            Log.v("FragmentManager", "movefrom STARTED: " + fragment);
                        }
                        fragment.B();
                    }
                    if (i < 3) {
                    }
                    if (i < 2) {
                    }
                    if (i < 1) {
                    }
                    break;
                case 5:
                    if (i < 5) {
                        if (f300a) {
                            Log.v("FragmentManager", "movefrom RESUMED: " + fragment);
                        }
                        fragment.A();
                        fragment.w = false;
                    }
                    if (i < 4) {
                    }
                    if (i < 3) {
                    }
                    if (i < 2) {
                    }
                    if (i < 1) {
                    }
                    break;
            }
        }
        fragment.j = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Fragment fragment) {
        a(fragment, this.n, 0, 0, false);
    }

    void a(int i, boolean z2) {
        a(i, 0, 0, z2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, int i2, int i3, boolean z2) {
        if (this.o == null && i != 0) {
            throw new IllegalStateException("No activity");
        }
        if (z2 || this.n != i) {
            this.n = i;
            if (this.f != null) {
                int i4 = 0;
                boolean z3 = false;
                while (i4 < this.f.size()) {
                    Fragment fragment = this.f.get(i4);
                    if (fragment != null) {
                        a(fragment, i, i2, i3, false);
                        if (fragment.V != null) {
                            z3 |= fragment.V.a();
                        }
                    }
                    i4++;
                    z3 = z3;
                }
                if (!z3) {
                    d();
                }
                if (this.r && this.o != null && this.n == 5) {
                    this.o.supportInvalidateOptionsMenu();
                    this.r = false;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        if (this.f != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.f.size()) {
                    Fragment fragment = this.f.get(i2);
                    if (fragment != null) {
                        a(fragment);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    void c(Fragment fragment) {
        if (fragment.o < 0) {
            if (this.h == null || this.h.size() <= 0) {
                if (this.f == null) {
                    this.f = new ArrayList<>();
                }
                fragment.a(this.f.size(), this.q);
                this.f.add(fragment);
            } else {
                fragment.a(this.h.remove(this.h.size() - 1).intValue(), this.q);
                this.f.set(fragment.o, fragment);
            }
            if (f300a) {
                Log.v("FragmentManager", "Allocated fragment index " + fragment);
            }
        }
    }

    void d(Fragment fragment) {
        if (fragment.o >= 0) {
            if (f300a) {
                Log.v("FragmentManager", "Freeing fragment index " + fragment);
            }
            this.f.set(fragment.o, null);
            if (this.h == null) {
                this.h = new ArrayList<>();
            }
            this.h.add(Integer.valueOf(fragment.o));
            this.o.invalidateSupportFragment(fragment.p);
            fragment.u();
        }
    }

    public void a(Fragment fragment, boolean z2) {
        if (this.g == null) {
            this.g = new ArrayList<>();
        }
        if (f300a) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        c(fragment);
        if (!fragment.J) {
            if (this.g.contains(fragment)) {
                throw new IllegalStateException("Fragment already added: " + fragment);
            }
            this.g.add(fragment);
            fragment.u = true;
            fragment.v = false;
            if (fragment.M && fragment.N) {
                this.r = true;
            }
            if (z2) {
                b(fragment);
            }
        }
    }

    public void a(Fragment fragment, int i, int i2) {
        if (f300a) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.A);
        }
        boolean z2 = !fragment.f();
        if (!fragment.J || z2) {
            if (this.g != null) {
                this.g.remove(fragment);
            }
            if (fragment.M && fragment.N) {
                this.r = true;
            }
            fragment.u = false;
            fragment.v = true;
            a(fragment, z2 ? 0 : 1, i, i2, false);
        }
    }

    public void b(Fragment fragment, int i, int i2) {
        if (f300a) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (!fragment.I) {
            fragment.I = true;
            if (fragment.R != null) {
                Animation a2 = a(fragment, i, true, i2);
                if (a2 != null) {
                    fragment.R.startAnimation(a2);
                }
                fragment.R.setVisibility(8);
            }
            if (fragment.u && fragment.M && fragment.N) {
                this.r = true;
            }
            fragment.b(true);
        }
    }

    public void c(Fragment fragment, int i, int i2) {
        if (f300a) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.I) {
            fragment.I = false;
            if (fragment.R != null) {
                Animation a2 = a(fragment, i, true, i2);
                if (a2 != null) {
                    fragment.R.startAnimation(a2);
                }
                fragment.R.setVisibility(0);
            }
            if (fragment.u && fragment.M && fragment.N) {
                this.r = true;
            }
            fragment.b(false);
        }
    }

    public void d(Fragment fragment, int i, int i2) {
        if (f300a) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (!fragment.J) {
            fragment.J = true;
            if (fragment.u) {
                if (this.g != null) {
                    if (f300a) {
                        Log.v("FragmentManager", "remove from detach: " + fragment);
                    }
                    this.g.remove(fragment);
                }
                if (fragment.M && fragment.N) {
                    this.r = true;
                }
                fragment.u = false;
                a(fragment, 1, i, i2, false);
            }
        }
    }

    public void e(Fragment fragment, int i, int i2) {
        if (f300a) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.J) {
            fragment.J = false;
            if (!fragment.u) {
                if (this.g == null) {
                    this.g = new ArrayList<>();
                }
                if (this.g.contains(fragment)) {
                    throw new IllegalStateException("Fragment already added: " + fragment);
                }
                if (f300a) {
                    Log.v("FragmentManager", "add from attach: " + fragment);
                }
                this.g.add(fragment);
                fragment.u = true;
                if (fragment.M && fragment.N) {
                    this.r = true;
                }
                a(fragment, this.n, i, i2, false);
            }
        }
    }

    public Fragment a(int i) {
        if (this.g != null) {
            for (int size = this.g.size() - 1; size >= 0; size--) {
                Fragment fragment = this.g.get(size);
                if (fragment != null && fragment.F == i) {
                    return fragment;
                }
            }
        }
        if (this.f != null) {
            for (int size2 = this.f.size() - 1; size2 >= 0; size2--) {
                Fragment fragment2 = this.f.get(size2);
                if (fragment2 != null && fragment2.F == i) {
                    return fragment2;
                }
            }
        }
        return null;
    }

    @Override // android.support.v4.app.t
    public Fragment a(String str) {
        if (this.g != null && str != null) {
            for (int size = this.g.size() - 1; size >= 0; size--) {
                Fragment fragment = this.g.get(size);
                if (fragment != null && str.equals(fragment.H)) {
                    return fragment;
                }
            }
        }
        if (this.f != null && str != null) {
            for (int size2 = this.f.size() - 1; size2 >= 0; size2--) {
                Fragment fragment2 = this.f.get(size2);
                if (fragment2 != null && str.equals(fragment2.H)) {
                    return fragment2;
                }
            }
        }
        return null;
    }

    private void t() {
        if (this.s) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        if (this.u != null) {
            throw new IllegalStateException("Can not perform this action inside of " + this.u);
        }
    }

    public void a(Runnable runnable, boolean z2) {
        if (!z2) {
            t();
        }
        synchronized (this) {
            if (this.o == null) {
                throw new IllegalStateException("Activity has been destroyed");
            }
            if (this.c == null) {
                this.c = new ArrayList<>();
            }
            this.c.add(runnable);
            if (this.c.size() == 1) {
                this.o.mHandler.removeCallbacks(this.y);
                this.o.mHandler.post(this.y);
            }
        }
    }

    public int a(i iVar) {
        int size;
        synchronized (this) {
            if (this.l == null || this.l.size() <= 0) {
                if (this.k == null) {
                    this.k = new ArrayList<>();
                }
                size = this.k.size();
                if (f300a) {
                    Log.v("FragmentManager", "Setting back stack index " + size + " to " + iVar);
                }
                this.k.add(iVar);
            } else {
                size = this.l.remove(this.l.size() - 1).intValue();
                if (f300a) {
                    Log.v("FragmentManager", "Adding back stack index " + size + " with " + iVar);
                }
                this.k.set(size, iVar);
            }
        }
        return size;
    }

    public void a(int i, i iVar) {
        synchronized (this) {
            if (this.k == null) {
                this.k = new ArrayList<>();
            }
            int size = this.k.size();
            if (i < size) {
                if (f300a) {
                    Log.v("FragmentManager", "Setting back stack index " + i + " to " + iVar);
                }
                this.k.set(i, iVar);
            } else {
                while (size < i) {
                    this.k.add(null);
                    if (this.l == null) {
                        this.l = new ArrayList<>();
                    }
                    if (f300a) {
                        Log.v("FragmentManager", "Adding available back stack index " + size);
                    }
                    this.l.add(Integer.valueOf(size));
                    size++;
                }
                if (f300a) {
                    Log.v("FragmentManager", "Adding back stack index " + i + " with " + iVar);
                }
                this.k.add(iVar);
            }
        }
    }

    public void b(int i) {
        synchronized (this) {
            this.k.set(i, null);
            if (this.l == null) {
                this.l = new ArrayList<>();
            }
            if (f300a) {
                Log.v("FragmentManager", "Freeing back stack index " + i);
            }
            this.l.add(Integer.valueOf(i));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0083, code lost:
        r6.e = true;
        r1 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0086, code lost:
        if (r1 >= r3) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0088, code lost:
        r6.d[r1].run();
        r6.d[r1] = null;
        r1 = r1 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean e() {
        if (this.e) {
            throw new IllegalStateException("Recursive entry to executePendingTransactions");
        }
        if (Looper.myLooper() != this.o.mHandler.getLooper()) {
            throw new IllegalStateException("Must be called from main thread of process");
        }
        boolean z2 = false;
        while (true) {
            synchronized (this) {
                if (this.c == null || this.c.size() == 0) {
                    break;
                }
                int size = this.c.size();
                if (this.d == null || this.d.length < size) {
                    this.d = new Runnable[size];
                }
                this.c.toArray(this.d);
                this.c.clear();
                this.o.mHandler.removeCallbacks(this.y);
            }
            this.e = false;
            z2 = true;
        }
        if (this.v) {
            boolean z3 = false;
            for (int i = 0; i < this.f.size(); i++) {
                Fragment fragment = this.f.get(i);
                if (fragment != null && fragment.V != null) {
                    z3 |= fragment.V.a();
                }
            }
            if (!z3) {
                this.v = false;
                d();
            }
        }
        return z2;
    }

    void f() {
        if (this.m != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.m.size()) {
                    this.m.get(i2).a();
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(i iVar) {
        if (this.i == null) {
            this.i = new ArrayList<>();
        }
        this.i.add(iVar);
        f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(Handler handler, String str, int i, int i2) {
        if (this.i == null) {
            return false;
        }
        if (str == null && i < 0 && (i2 & 1) == 0) {
            int size = this.i.size() - 1;
            if (size < 0) {
                return false;
            }
            this.i.remove(size).b(true);
            f();
        } else {
            int i3 = -1;
            if (str != null || i >= 0) {
                int size2 = this.i.size() - 1;
                while (size2 >= 0) {
                    i iVar = this.i.get(size2);
                    if ((str != null && str.equals(iVar.c())) || (i >= 0 && i == iVar.o)) {
                        break;
                    }
                    size2--;
                }
                if (size2 < 0) {
                    return false;
                }
                if ((i2 & 1) != 0) {
                    size2--;
                    while (size2 >= 0) {
                        i iVar2 = this.i.get(size2);
                        if ((str == null || !str.equals(iVar2.c())) && (i < 0 || i != iVar2.o)) {
                            break;
                        }
                        size2--;
                    }
                }
                i3 = size2;
            }
            if (i3 == this.i.size() - 1) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (int size3 = this.i.size() - 1; size3 > i3; size3--) {
                arrayList.add(this.i.remove(size3));
            }
            int size4 = arrayList.size() - 1;
            int i4 = 0;
            while (i4 <= size4) {
                if (f300a) {
                    Log.v("FragmentManager", "Popping back stack state: " + arrayList.get(i4));
                }
                ((i) arrayList.get(i4)).b(i4 == size4);
                i4++;
            }
            f();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<Fragment> g() {
        ArrayList<Fragment> arrayList = null;
        if (this.f != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.f.size()) {
                    break;
                }
                Fragment fragment = this.f.get(i2);
                if (fragment != null && fragment.K) {
                    if (arrayList == null) {
                        arrayList = new ArrayList<>();
                    }
                    arrayList.add(fragment);
                    fragment.L = true;
                    fragment.s = fragment.r != null ? fragment.r.o : -1;
                    if (f300a) {
                        Log.v("FragmentManager", "retainNonConfig: keeping retained " + fragment);
                    }
                }
                i = i2 + 1;
            }
        }
        return arrayList;
    }

    void e(Fragment fragment) {
        if (fragment.S != null) {
            if (this.x == null) {
                this.x = new SparseArray<>();
            } else {
                this.x.clear();
            }
            fragment.S.saveHierarchyState(this.x);
            if (this.x.size() > 0) {
                fragment.n = this.x;
                this.x = null;
            }
        }
    }

    Bundle f(Fragment fragment) {
        Bundle bundle;
        if (this.w == null) {
            this.w = new Bundle();
        }
        fragment.k(this.w);
        if (this.w.isEmpty()) {
            bundle = null;
        } else {
            bundle = this.w;
            this.w = null;
        }
        if (fragment.R != null) {
            e(fragment);
        }
        if (fragment.n != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", fragment.n);
        }
        if (!fragment.U) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", fragment.U);
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Parcelable h() {
        int[] iArr;
        int size;
        int size2;
        boolean z2;
        BackStackState[] backStackStateArr = null;
        e();
        if (b) {
            this.s = true;
        }
        if (this.f == null || this.f.size() <= 0) {
            return null;
        }
        int size3 = this.f.size();
        FragmentState[] fragmentStateArr = new FragmentState[size3];
        int i = 0;
        boolean z3 = false;
        while (i < size3) {
            Fragment fragment = this.f.get(i);
            if (fragment != null) {
                if (fragment.o < 0) {
                    a(new IllegalStateException("Failure saving state: active " + fragment + " has cleared index: " + fragment.o));
                }
                FragmentState fragmentState = new FragmentState(fragment);
                fragmentStateArr[i] = fragmentState;
                if (fragment.j > 0 && fragmentState.j == null) {
                    fragmentState.j = f(fragment);
                    if (fragment.r != null) {
                        if (fragment.r.o < 0) {
                            a(new IllegalStateException("Failure saving state: " + fragment + " has target not in fragment manager: " + fragment.r));
                        }
                        if (fragmentState.j == null) {
                            fragmentState.j = new Bundle();
                        }
                        a(fragmentState.j, "android:target_state", fragment.r);
                        if (fragment.t != 0) {
                            fragmentState.j.putInt("android:target_req_state", fragment.t);
                        }
                    }
                } else {
                    fragmentState.j = fragment.m;
                }
                if (f300a) {
                    Log.v("FragmentManager", "Saved state of " + fragment + ": " + fragmentState.j);
                }
                z2 = true;
            } else {
                z2 = z3;
            }
            i++;
            z3 = z2;
        }
        if (!z3) {
            if (f300a) {
                Log.v("FragmentManager", "saveAllState: no fragments!");
                return null;
            }
            return null;
        }
        if (this.g == null || (size2 = this.g.size()) <= 0) {
            iArr = null;
        } else {
            iArr = new int[size2];
            for (int i2 = 0; i2 < size2; i2++) {
                iArr[i2] = this.g.get(i2).o;
                if (iArr[i2] < 0) {
                    a(new IllegalStateException("Failure saving state: active " + this.g.get(i2) + " has cleared index: " + iArr[i2]));
                }
                if (f300a) {
                    Log.v("FragmentManager", "saveAllState: adding fragment #" + i2 + ": " + this.g.get(i2));
                }
            }
        }
        if (this.i != null && (size = this.i.size()) > 0) {
            backStackStateArr = new BackStackState[size];
            for (int i3 = 0; i3 < size; i3++) {
                backStackStateArr[i3] = new BackStackState(this, this.i.get(i3));
                if (f300a) {
                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i3 + ": " + this.i.get(i3));
                }
            }
        }
        FragmentManagerState fragmentManagerState = new FragmentManagerState();
        fragmentManagerState.f277a = fragmentStateArr;
        fragmentManagerState.b = iArr;
        fragmentManagerState.c = backStackStateArr;
        return fragmentManagerState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Parcelable parcelable, ArrayList<Fragment> arrayList) {
        if (parcelable != null) {
            FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
            if (fragmentManagerState.f277a != null) {
                if (arrayList != null) {
                    for (int i = 0; i < arrayList.size(); i++) {
                        Fragment fragment = arrayList.get(i);
                        if (f300a) {
                            Log.v("FragmentManager", "restoreAllState: re-attaching retained " + fragment);
                        }
                        FragmentState fragmentState = fragmentManagerState.f277a[fragment.o];
                        fragmentState.k = fragment;
                        fragment.n = null;
                        fragment.A = 0;
                        fragment.y = false;
                        fragment.u = false;
                        fragment.r = null;
                        if (fragmentState.j != null) {
                            fragmentState.j.setClassLoader(this.o.getClassLoader());
                            fragment.n = fragmentState.j.getSparseParcelableArray("android:view_state");
                        }
                    }
                }
                this.f = new ArrayList<>(fragmentManagerState.f277a.length);
                if (this.h != null) {
                    this.h.clear();
                }
                for (int i2 = 0; i2 < fragmentManagerState.f277a.length; i2++) {
                    FragmentState fragmentState2 = fragmentManagerState.f277a[i2];
                    if (fragmentState2 != null) {
                        Fragment a2 = fragmentState2.a(this.o, this.q);
                        if (f300a) {
                            Log.v("FragmentManager", "restoreAllState: active #" + i2 + ": " + a2);
                        }
                        this.f.add(a2);
                        fragmentState2.k = null;
                    } else {
                        this.f.add(null);
                        if (this.h == null) {
                            this.h = new ArrayList<>();
                        }
                        if (f300a) {
                            Log.v("FragmentManager", "restoreAllState: avail #" + i2);
                        }
                        this.h.add(Integer.valueOf(i2));
                    }
                }
                if (arrayList != null) {
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        Fragment fragment2 = arrayList.get(i3);
                        if (fragment2.s >= 0) {
                            if (fragment2.s < this.f.size()) {
                                fragment2.r = this.f.get(fragment2.s);
                            } else {
                                Log.w("FragmentManager", "Re-attaching retained fragment " + fragment2 + " target no longer exists: " + fragment2.s);
                                fragment2.r = null;
                            }
                        }
                    }
                }
                if (fragmentManagerState.b != null) {
                    this.g = new ArrayList<>(fragmentManagerState.b.length);
                    for (int i4 = 0; i4 < fragmentManagerState.b.length; i4++) {
                        Fragment fragment3 = this.f.get(fragmentManagerState.b[i4]);
                        if (fragment3 == null) {
                            a(new IllegalStateException("No instantiated fragment for index #" + fragmentManagerState.b[i4]));
                        }
                        fragment3.u = true;
                        if (f300a) {
                            Log.v("FragmentManager", "restoreAllState: added #" + i4 + ": " + fragment3);
                        }
                        if (this.g.contains(fragment3)) {
                            throw new IllegalStateException("Already added!");
                        }
                        this.g.add(fragment3);
                    }
                } else {
                    this.g = null;
                }
                if (fragmentManagerState.c != null) {
                    this.i = new ArrayList<>(fragmentManagerState.c.length);
                    for (int i5 = 0; i5 < fragmentManagerState.c.length; i5++) {
                        i a3 = fragmentManagerState.c[i5].a(this);
                        if (f300a) {
                            Log.v("FragmentManager", "restoreAllState: back stack #" + i5 + " (index " + a3.o + "): " + a3);
                            a3.a("  ", new PrintWriter(new android.support.v4.b.b("FragmentManager")), false);
                        }
                        this.i.add(a3);
                        if (a3.o >= 0) {
                            a(a3.o, a3);
                        }
                    }
                    return;
                }
                this.i = null;
            }
        }
    }

    public void a(n nVar, s sVar, Fragment fragment) {
        if (this.o != null) {
            throw new IllegalStateException("Already attached");
        }
        this.o = nVar;
        this.p = sVar;
        this.q = fragment;
    }

    public void i() {
        this.s = false;
    }

    public void j() {
        this.s = false;
        a(1, false);
    }

    public void k() {
        this.s = false;
        a(2, false);
    }

    public void l() {
        this.s = false;
        a(4, false);
    }

    public void m() {
        this.s = false;
        a(5, false);
    }

    public void n() {
        a(4, false);
    }

    public void o() {
        this.s = true;
        a(3, false);
    }

    public void p() {
        a(2, false);
    }

    public void q() {
        a(1, false);
    }

    public void r() {
        this.t = true;
        e();
        a(0, false);
        this.o = null;
        this.p = null;
        this.q = null;
    }

    public void a(Configuration configuration) {
        if (this.g != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.g.size()) {
                    Fragment fragment = this.g.get(i2);
                    if (fragment != null) {
                        fragment.a(configuration);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void s() {
        if (this.g != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.g.size()) {
                    Fragment fragment = this.g.get(i2);
                    if (fragment != null) {
                        fragment.z();
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public boolean a(Menu menu, MenuInflater menuInflater) {
        boolean z2;
        ArrayList<Fragment> arrayList = null;
        if (this.g != null) {
            int i = 0;
            z2 = false;
            while (i < this.g.size()) {
                Fragment fragment = this.g.get(i);
                if (fragment != null && fragment.b(menu, menuInflater)) {
                    z2 = true;
                    if (arrayList == null) {
                        arrayList = new ArrayList<>();
                    }
                    arrayList.add(fragment);
                }
                i++;
                z2 = z2;
            }
        } else {
            z2 = false;
        }
        if (this.j != null) {
            for (int i2 = 0; i2 < this.j.size(); i2++) {
                Fragment fragment2 = this.j.get(i2);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.v();
                }
            }
        }
        this.j = arrayList;
        return z2;
    }

    public boolean a(Menu menu) {
        if (this.g != null) {
            boolean z2 = false;
            for (int i = 0; i < this.g.size(); i++) {
                Fragment fragment = this.g.get(i);
                if (fragment != null && fragment.c(menu)) {
                    z2 = true;
                }
            }
            return z2;
        }
        return false;
    }

    public boolean a(MenuItem menuItem) {
        if (this.g != null) {
            for (int i = 0; i < this.g.size(); i++) {
                Fragment fragment = this.g.get(i);
                if (fragment != null && fragment.c(menuItem)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public boolean b(MenuItem menuItem) {
        if (this.g != null) {
            for (int i = 0; i < this.g.size(); i++) {
                Fragment fragment = this.g.get(i);
                if (fragment != null && fragment.d(menuItem)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public void b(Menu menu) {
        if (this.g != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.g.size()) {
                    Fragment fragment = this.g.get(i2);
                    if (fragment != null) {
                        fragment.d(menu);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public static int c(int i) {
        switch (i) {
            case 4097:
                return 8194;
            case 4099:
                return 4099;
            case 8194:
                return 4097;
            default:
                return 0;
        }
    }

    public static int b(int i, boolean z2) {
        switch (i) {
            case 4097:
                return z2 ? 1 : 2;
            case 4099:
                return z2 ? 5 : 6;
            case 8194:
                return z2 ? 3 : 4;
            default:
                return -1;
        }
    }
}
