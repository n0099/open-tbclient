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
public final class l extends j {
    static final Interpolator A;
    static boolean a = false;
    static final boolean b;
    static final Interpolator x;
    static final Interpolator y;
    static final Interpolator z;
    ArrayList c;
    Runnable[] d;
    boolean e;
    ArrayList f;
    ArrayList g;
    ArrayList h;
    ArrayList i;
    ArrayList j;
    ArrayList k;
    ArrayList l;
    ArrayList m;
    int n;
    g o;
    boolean p;
    boolean q;
    boolean r;
    String s;
    boolean t;
    Bundle u;
    SparseArray v;
    Runnable w;

    static {
        b = Build.VERSION.SDK_INT >= 11;
        x = new DecelerateInterpolator(2.5f);
        y = new DecelerateInterpolator(1.5f);
        z = new AccelerateInterpolator(2.5f);
        A = new AccelerateInterpolator(1.5f);
    }

    @Override // android.support.v4.app.j
    public q a() {
        return new b(this);
    }

    public boolean b() {
        return e();
    }

    public boolean c() {
        s();
        b();
        return a(this.o.a, (String) null, -1, 0);
    }

    @Override // android.support.v4.app.j
    public void a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("Bad id: " + i);
        }
        a((Runnable) new m(this, i, i2), false);
    }

    public void a(Bundle bundle, String str, Fragment fragment) {
        if (fragment.n < 0) {
            throw new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager");
        }
        bundle.putInt(str, fragment.n);
    }

    public Fragment a(Bundle bundle, String str) {
        int i = bundle.getInt(str, -1);
        if (i == -1) {
            return null;
        }
        if (i >= this.f.size()) {
            throw new IllegalStateException("Fragement no longer exists for key " + str + ": index " + i);
        }
        Fragment fragment = (Fragment) this.f.get(i);
        if (fragment == null) {
            throw new IllegalStateException("Fragement no longer exists for key " + str + ": index " + i);
        }
        return fragment;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((int) DERTags.TAGGED);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        android.support.v4.b.a.a(this.o, sb);
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
                Fragment fragment = (Fragment) this.f.get(i);
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
                printWriter.println(((Fragment) this.g.get(i2)).toString());
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
                printWriter.println(((Fragment) this.j.get(i3)).toString());
            }
        }
        if (this.i != null && (size3 = this.i.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i4 = 0; i4 < size3; i4++) {
                b bVar = (b) this.i.get(i4);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i4);
                printWriter.print(": ");
                printWriter.println(bVar.toString());
                bVar.a(str2, fileDescriptor, printWriter, strArr);
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
                    printWriter.println((b) this.k.get(i5));
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
        printWriter.print("  mCurState=");
        printWriter.print(this.n);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.q);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.r);
        if (this.p) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.p);
        }
        if (this.s != null) {
            printWriter.print(str);
            printWriter.print("  mNoTransactionsBecause=");
            printWriter.println(this.s);
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
        scaleAnimation.setInterpolator(x);
        scaleAnimation.setDuration(220L);
        animationSet.addAnimation(scaleAnimation);
        AlphaAnimation alphaAnimation = new AlphaAnimation(f3, f4);
        alphaAnimation.setInterpolator(y);
        alphaAnimation.setDuration(220L);
        animationSet.addAnimation(alphaAnimation);
        return animationSet;
    }

    static Animation a(Context context, float f, float f2) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(f, f2);
        alphaAnimation.setInterpolator(y);
        alphaAnimation.setDuration(220L);
        return alphaAnimation;
    }

    Animation a(Fragment fragment, int i, boolean z2, int i2) {
        int b2;
        Animation loadAnimation;
        Animation a2 = fragment.a(i, z2, fragment.M);
        if (a2 == null) {
            if (fragment.M == 0 || (loadAnimation = AnimationUtils.loadAnimation(this.o, fragment.M)) == null) {
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
        if (fragment.Q) {
            if (this.e) {
                this.t = true;
                return;
            }
            fragment.Q = false;
            a(fragment, this.n, 0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0314  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x035a  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x037c  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0212  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Fragment fragment, int i, int i2, int i3) {
        ViewGroup viewGroup;
        if (!fragment.t && i > 1) {
            i = 1;
        }
        if (fragment.u && i > fragment.i) {
            i = fragment.i;
        }
        if (fragment.Q && fragment.i < 4 && i > 3) {
            i = 3;
        }
        if (fragment.i < i) {
            if (!fragment.w || fragment.x) {
                if (fragment.j != null) {
                    fragment.j = null;
                    a(fragment, fragment.k, 0, 0);
                }
                switch (fragment.i) {
                    case 0:
                        if (a) {
                            Log.v("FragmentManager", "moveto CREATED: " + fragment);
                        }
                        if (fragment.l != null) {
                            fragment.m = fragment.l.getSparseParcelableArray("android:view_state");
                            fragment.q = a(fragment.l, "android:target_state");
                            if (fragment.q != null) {
                                fragment.s = fragment.l.getInt("android:target_req_state", 0);
                            }
                            fragment.R = fragment.l.getBoolean("android:user_visible_hint", true);
                            if (!fragment.R) {
                                fragment.Q = true;
                                if (i > 3) {
                                    i = 3;
                                }
                            }
                        }
                        fragment.B = this.o;
                        fragment.A = this.o.b;
                        fragment.L = false;
                        fragment.a(this.o);
                        if (!fragment.L) {
                            throw new z("Fragment " + fragment + " did not call through to super.onAttach()");
                        }
                        this.o.a(fragment);
                        if (!fragment.I) {
                            fragment.L = false;
                            fragment.a(fragment.l);
                            if (!fragment.L) {
                                throw new z("Fragment " + fragment + " did not call through to super.onCreate()");
                            }
                        }
                        fragment.I = false;
                        if (fragment.w) {
                            fragment.O = fragment.a(fragment.b(fragment.l), (ViewGroup) null, fragment.l);
                            if (fragment.O != null) {
                                fragment.P = fragment.O;
                                fragment.O = y.a(fragment.O);
                                if (fragment.F) {
                                    fragment.O.setVisibility(8);
                                }
                                fragment.a(fragment.O, fragment.l);
                            } else {
                                fragment.P = null;
                            }
                        }
                        if (i > 1) {
                            if (a) {
                                Log.v("FragmentManager", "moveto ACTIVITY_CREATED: " + fragment);
                            }
                            if (!fragment.w) {
                                if (fragment.D != 0) {
                                    viewGroup = (ViewGroup) this.o.findViewById(fragment.D);
                                    if (viewGroup == null && !fragment.y) {
                                        throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(fragment.D) + " for fragment " + fragment);
                                    }
                                } else {
                                    viewGroup = null;
                                }
                                fragment.N = viewGroup;
                                fragment.O = fragment.a(fragment.b(fragment.l), viewGroup, fragment.l);
                                if (fragment.O != null) {
                                    fragment.P = fragment.O;
                                    fragment.O = y.a(fragment.O);
                                    if (viewGroup != null) {
                                        Animation a2 = a(fragment, i2, true, i3);
                                        if (a2 != null) {
                                            fragment.O.startAnimation(a2);
                                        }
                                        viewGroup.addView(fragment.O);
                                    }
                                    if (fragment.F) {
                                        fragment.O.setVisibility(8);
                                    }
                                    fragment.a(fragment.O, fragment.l);
                                } else {
                                    fragment.P = null;
                                }
                            }
                            fragment.L = false;
                            fragment.d(fragment.l);
                            if (!fragment.L) {
                                throw new z("Fragment " + fragment + " did not call through to super.onActivityCreated()");
                            }
                            if (fragment.O != null) {
                                fragment.e();
                            }
                            fragment.l = null;
                        }
                        if (i > 3) {
                            if (a) {
                                Log.v("FragmentManager", "moveto STARTED: " + fragment);
                            }
                            fragment.L = false;
                            fragment.p();
                            if (!fragment.L) {
                                throw new z("Fragment " + fragment + " did not call through to super.onStart()");
                            }
                        }
                        if (i > 4) {
                            if (a) {
                                Log.v("FragmentManager", "moveto RESUMED: " + fragment);
                            }
                            fragment.L = false;
                            fragment.v = true;
                            fragment.j();
                            if (!fragment.L) {
                                throw new z("Fragment " + fragment + " did not call through to super.onResume()");
                            }
                            fragment.l = null;
                            fragment.m = null;
                            break;
                        }
                        break;
                    case 1:
                        if (i > 1) {
                        }
                        if (i > 3) {
                        }
                        if (i > 4) {
                        }
                        break;
                    case 2:
                    case 3:
                        if (i > 3) {
                        }
                        if (i > 4) {
                        }
                        break;
                    case 4:
                        if (i > 4) {
                        }
                        break;
                }
            } else {
                return;
            }
        } else if (fragment.i > i) {
            switch (fragment.i) {
                case 1:
                    if (i < 1) {
                        if (this.r && fragment.j != null) {
                            View view = fragment.j;
                            fragment.j = null;
                            view.clearAnimation();
                        }
                        if (fragment.j != null) {
                            fragment.k = i;
                            i = 1;
                            break;
                        } else {
                            if (a) {
                                Log.v("FragmentManager", "movefrom CREATED: " + fragment);
                            }
                            if (!fragment.I) {
                                fragment.L = false;
                                fragment.l();
                                if (!fragment.L) {
                                    throw new z("Fragment " + fragment + " did not call through to super.onDestroy()");
                                }
                            }
                            fragment.L = false;
                            fragment.n();
                            if (!fragment.L) {
                                throw new z("Fragment " + fragment + " did not call through to super.onDetach()");
                            }
                            if (!fragment.I) {
                                d(fragment);
                                break;
                            } else {
                                fragment.B = null;
                                fragment.A = null;
                                break;
                            }
                        }
                    }
                    break;
                case 2:
                    if (i < 2) {
                        if (a) {
                            Log.v("FragmentManager", "movefrom ACTIVITY_CREATED: " + fragment);
                        }
                        if (fragment.O != null && !this.o.isFinishing() && fragment.m == null) {
                            e(fragment);
                        }
                        fragment.L = false;
                        fragment.s();
                        if (!fragment.L) {
                            throw new z("Fragment " + fragment + " did not call through to super.onDestroyView()");
                        }
                        if (fragment.O != null && fragment.N != null) {
                            Animation a3 = (this.n <= 0 || this.r) ? null : a(fragment, i2, false, i3);
                            if (a3 != null) {
                                fragment.j = fragment.O;
                                fragment.k = i;
                                a3.setAnimationListener(new n(this, fragment));
                                fragment.O.startAnimation(a3);
                            }
                            fragment.N.removeView(fragment.O);
                        }
                        fragment.N = null;
                        fragment.O = null;
                        fragment.P = null;
                    }
                    if (i < 1) {
                    }
                    break;
                case 3:
                    if (i < 3) {
                        if (a) {
                            Log.v("FragmentManager", "movefrom STOPPED: " + fragment);
                        }
                        fragment.r();
                    }
                    if (i < 2) {
                    }
                    if (i < 1) {
                    }
                    break;
                case 4:
                    if (i < 4) {
                        if (a) {
                            Log.v("FragmentManager", "movefrom STARTED: " + fragment);
                        }
                        fragment.L = false;
                        fragment.q();
                        if (!fragment.L) {
                            throw new z("Fragment " + fragment + " did not call through to super.onStop()");
                        }
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
                        if (a) {
                            Log.v("FragmentManager", "movefrom RESUMED: " + fragment);
                        }
                        fragment.L = false;
                        fragment.k();
                        if (!fragment.L) {
                            throw new z("Fragment " + fragment + " did not call through to super.onPause()");
                        }
                        fragment.v = false;
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
        fragment.i = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Fragment fragment) {
        a(fragment, this.n, 0, 0);
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
                boolean z3 = false;
                for (int i4 = 0; i4 < this.f.size(); i4++) {
                    Fragment fragment = (Fragment) this.f.get(i4);
                    if (fragment != null) {
                        a(fragment, i, i2, i3);
                        if (fragment.S != null) {
                            z3 |= fragment.S.a();
                        }
                    }
                }
                if (!z3) {
                    d();
                }
                if (this.p && this.o != null && this.n == 5) {
                    this.o.c();
                    this.p = false;
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
                    Fragment fragment = (Fragment) this.f.get(i2);
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
        if (fragment.n < 0) {
            if (this.h == null || this.h.size() <= 0) {
                if (this.f == null) {
                    this.f = new ArrayList();
                }
                fragment.a(this.f.size());
                this.f.add(fragment);
                return;
            }
            fragment.a(((Integer) this.h.remove(this.h.size() - 1)).intValue());
            this.f.set(fragment.n, fragment);
        }
    }

    void d(Fragment fragment) {
        if (fragment.n >= 0) {
            if (a) {
                Log.v("FragmentManager", "Freeing fragment index " + fragment.n);
            }
            this.f.set(fragment.n, null);
            if (this.h == null) {
                this.h = new ArrayList();
            }
            this.h.add(Integer.valueOf(fragment.n));
            this.o.a(fragment.n);
            fragment.m();
        }
    }

    public void a(Fragment fragment, boolean z2) {
        if (this.g == null) {
            this.g = new ArrayList();
        }
        if (a) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        c(fragment);
        if (!fragment.G) {
            this.g.add(fragment);
            fragment.t = true;
            fragment.u = false;
            if (fragment.J && fragment.K) {
                this.p = true;
            }
            if (z2) {
                b(fragment);
            }
        }
    }

    public void a(Fragment fragment, int i, int i2) {
        if (a) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.z);
        }
        boolean z2 = !fragment.f();
        if (!fragment.G || z2) {
            this.g.remove(fragment);
            if (fragment.J && fragment.K) {
                this.p = true;
            }
            fragment.t = false;
            fragment.u = true;
            a(fragment, z2 ? 0 : 1, i, i2);
        }
    }

    public void b(Fragment fragment, int i, int i2) {
        if (a) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (!fragment.F) {
            fragment.F = true;
            if (fragment.O != null) {
                Animation a2 = a(fragment, i, true, i2);
                if (a2 != null) {
                    fragment.O.startAnimation(a2);
                }
                fragment.O.setVisibility(8);
            }
            if (fragment.t && fragment.J && fragment.K) {
                this.p = true;
            }
            fragment.b(true);
        }
    }

    public void c(Fragment fragment, int i, int i2) {
        if (a) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.F) {
            fragment.F = false;
            if (fragment.O != null) {
                Animation a2 = a(fragment, i, true, i2);
                if (a2 != null) {
                    fragment.O.startAnimation(a2);
                }
                fragment.O.setVisibility(0);
            }
            if (fragment.t && fragment.J && fragment.K) {
                this.p = true;
            }
            fragment.b(false);
        }
    }

    public void d(Fragment fragment, int i, int i2) {
        if (a) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (!fragment.G) {
            fragment.G = true;
            if (fragment.t) {
                this.g.remove(fragment);
                if (fragment.J && fragment.K) {
                    this.p = true;
                }
                fragment.t = false;
                a(fragment, 1, i, i2);
            }
        }
    }

    public void e(Fragment fragment, int i, int i2) {
        if (a) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.G) {
            fragment.G = false;
            if (!fragment.t) {
                this.g.add(fragment);
                fragment.t = true;
                if (fragment.J && fragment.K) {
                    this.p = true;
                }
                a(fragment, this.n, i, i2);
            }
        }
    }

    public Fragment a(int i) {
        if (this.f != null) {
            for (int size = this.g.size() - 1; size >= 0; size--) {
                Fragment fragment = (Fragment) this.g.get(size);
                if (fragment != null && fragment.C == i) {
                    return fragment;
                }
            }
            for (int size2 = this.f.size() - 1; size2 >= 0; size2--) {
                Fragment fragment2 = (Fragment) this.f.get(size2);
                if (fragment2 != null && fragment2.C == i) {
                    return fragment2;
                }
            }
        }
        return null;
    }

    public Fragment a(String str) {
        if (this.f != null && str != null) {
            for (int size = this.g.size() - 1; size >= 0; size--) {
                Fragment fragment = (Fragment) this.g.get(size);
                if (fragment != null && str.equals(fragment.E)) {
                    return fragment;
                }
            }
            for (int size2 = this.f.size() - 1; size2 >= 0; size2--) {
                Fragment fragment2 = (Fragment) this.f.get(size2);
                if (fragment2 != null && str.equals(fragment2.E)) {
                    return fragment2;
                }
            }
        }
        return null;
    }

    private void s() {
        if (this.q) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        if (this.s != null) {
            throw new IllegalStateException("Can not perform this action inside of " + this.s);
        }
    }

    public void a(Runnable runnable, boolean z2) {
        if (!z2) {
            s();
        }
        synchronized (this) {
            if (this.o == null) {
                throw new IllegalStateException("Activity has been destroyed");
            }
            if (this.c == null) {
                this.c = new ArrayList();
            }
            this.c.add(runnable);
            if (this.c.size() == 1) {
                this.o.a.removeCallbacks(this.w);
                this.o.a.post(this.w);
            }
        }
    }

    public int a(b bVar) {
        int size;
        synchronized (this) {
            if (this.l == null || this.l.size() <= 0) {
                if (this.k == null) {
                    this.k = new ArrayList();
                }
                size = this.k.size();
                if (a) {
                    Log.v("FragmentManager", "Setting back stack index " + size + " to " + bVar);
                }
                this.k.add(bVar);
            } else {
                size = ((Integer) this.l.remove(this.l.size() - 1)).intValue();
                if (a) {
                    Log.v("FragmentManager", "Adding back stack index " + size + " with " + bVar);
                }
                this.k.set(size, bVar);
            }
        }
        return size;
    }

    public void a(int i, b bVar) {
        synchronized (this) {
            if (this.k == null) {
                this.k = new ArrayList();
            }
            int size = this.k.size();
            if (i < size) {
                if (a) {
                    Log.v("FragmentManager", "Setting back stack index " + i + " to " + bVar);
                }
                this.k.set(i, bVar);
            } else {
                while (size < i) {
                    this.k.add(null);
                    if (this.l == null) {
                        this.l = new ArrayList();
                    }
                    if (a) {
                        Log.v("FragmentManager", "Adding available back stack index " + size);
                    }
                    this.l.add(Integer.valueOf(size));
                    size++;
                }
                if (a) {
                    Log.v("FragmentManager", "Adding back stack index " + i + " with " + bVar);
                }
                this.k.add(bVar);
            }
        }
    }

    public void b(int i) {
        synchronized (this) {
            this.k.set(i, null);
            if (this.l == null) {
                this.l = new ArrayList();
            }
            if (a) {
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
        if (Looper.myLooper() != this.o.a.getLooper()) {
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
                this.o.a.removeCallbacks(this.w);
            }
            this.e = false;
            z2 = true;
        }
        if (this.t) {
            boolean z3 = false;
            for (int i = 0; i < this.f.size(); i++) {
                Fragment fragment = (Fragment) this.f.get(i);
                if (fragment != null && fragment.S != null) {
                    z3 |= fragment.S.a();
                }
            }
            if (!z3) {
                this.t = false;
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
                    ((k) this.m.get(i2)).a();
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(b bVar) {
        if (this.i == null) {
            this.i = new ArrayList();
        }
        this.i.add(bVar);
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
            ((b) this.i.remove(size)).b(true);
            f();
        } else {
            int i3 = -1;
            if (str != null || i >= 0) {
                int size2 = this.i.size() - 1;
                while (size2 >= 0) {
                    b bVar = (b) this.i.get(size2);
                    if ((str != null && str.equals(bVar.c())) || (i >= 0 && i == bVar.o)) {
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
                        b bVar2 = (b) this.i.get(size2);
                        if ((str == null || !str.equals(bVar2.c())) && (i < 0 || i != bVar2.o)) {
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
                if (a) {
                    Log.v("FragmentManager", "Popping back stack state: " + arrayList.get(i4));
                }
                ((b) arrayList.get(i4)).b(i4 == size4);
                i4++;
            }
            f();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList g() {
        ArrayList arrayList = null;
        if (this.f != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.f.size()) {
                    break;
                }
                Fragment fragment = (Fragment) this.f.get(i2);
                if (fragment != null && fragment.H) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(fragment);
                    fragment.I = true;
                    fragment.r = fragment.q != null ? fragment.q.n : -1;
                }
                i = i2 + 1;
            }
        }
        return arrayList;
    }

    void e(Fragment fragment) {
        if (fragment.P != null) {
            if (this.v == null) {
                this.v = new SparseArray();
            } else {
                this.v.clear();
            }
            fragment.P.saveHierarchyState(this.v);
            if (this.v.size() > 0) {
                fragment.m = this.v;
                this.v = null;
            }
        }
    }

    Bundle f(Fragment fragment) {
        Bundle bundle;
        if (this.u == null) {
            this.u = new Bundle();
        }
        fragment.e(this.u);
        if (this.u.isEmpty()) {
            bundle = null;
        } else {
            bundle = this.u;
            this.u = null;
        }
        if (fragment.O != null) {
            e(fragment);
        }
        if (fragment.m != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", fragment.m);
        }
        if (!fragment.R) {
            bundle.putBoolean("android:user_visible_hint", fragment.R);
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
            this.q = true;
        }
        if (this.f == null || this.f.size() <= 0) {
            return null;
        }
        int size3 = this.f.size();
        FragmentState[] fragmentStateArr = new FragmentState[size3];
        int i = 0;
        boolean z3 = false;
        while (i < size3) {
            Fragment fragment = (Fragment) this.f.get(i);
            if (fragment != null) {
                FragmentState fragmentState = new FragmentState(fragment);
                fragmentStateArr[i] = fragmentState;
                if (fragment.i > 0 && fragmentState.j == null) {
                    fragmentState.j = f(fragment);
                    if (fragment.q != null) {
                        if (fragment.q.n < 0) {
                            String str = "Failure saving state: " + fragment + " has target not in fragment manager: " + fragment.q;
                            Log.e("FragmentManager", str);
                            a("  ", (FileDescriptor) null, new PrintWriter(new android.support.v4.b.b("FragmentManager")), new String[0]);
                            throw new IllegalStateException(str);
                        }
                        if (fragmentState.j == null) {
                            fragmentState.j = new Bundle();
                        }
                        a(fragmentState.j, "android:target_state", fragment.q);
                        if (fragment.s != 0) {
                            fragmentState.j.putInt("android:target_req_state", fragment.s);
                        }
                    }
                } else {
                    fragmentState.j = fragment.l;
                }
                if (a) {
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
            if (a) {
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
                iArr[i2] = ((Fragment) this.g.get(i2)).n;
                if (a) {
                    Log.v("FragmentManager", "saveAllState: adding fragment #" + i2 + ": " + this.g.get(i2));
                }
            }
        }
        if (this.i != null && (size = this.i.size()) > 0) {
            backStackStateArr = new BackStackState[size];
            for (int i3 = 0; i3 < size; i3++) {
                backStackStateArr[i3] = new BackStackState(this, (b) this.i.get(i3));
                if (a) {
                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i3 + ": " + this.i.get(i3));
                }
            }
        }
        FragmentManagerState fragmentManagerState = new FragmentManagerState();
        fragmentManagerState.a = fragmentStateArr;
        fragmentManagerState.b = iArr;
        fragmentManagerState.c = backStackStateArr;
        return fragmentManagerState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Parcelable parcelable, ArrayList arrayList) {
        if (parcelable != null) {
            FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
            if (fragmentManagerState.a != null) {
                if (arrayList != null) {
                    for (int i = 0; i < arrayList.size(); i++) {
                        Fragment fragment = (Fragment) arrayList.get(i);
                        if (a) {
                            Log.v("FragmentManager", "restoreAllState: re-attaching retained " + fragment);
                        }
                        FragmentState fragmentState = fragmentManagerState.a[fragment.n];
                        fragmentState.k = fragment;
                        fragment.m = null;
                        fragment.z = 0;
                        fragment.x = false;
                        fragment.t = false;
                        fragment.q = null;
                        if (fragmentState.j != null) {
                            fragmentState.j.setClassLoader(this.o.getClassLoader());
                            fragment.m = fragmentState.j.getSparseParcelableArray("android:view_state");
                        }
                    }
                }
                this.f = new ArrayList(fragmentManagerState.a.length);
                if (this.h != null) {
                    this.h.clear();
                }
                for (int i2 = 0; i2 < fragmentManagerState.a.length; i2++) {
                    FragmentState fragmentState2 = fragmentManagerState.a[i2];
                    if (fragmentState2 != null) {
                        Fragment a2 = fragmentState2.a(this.o);
                        if (a) {
                            Log.v("FragmentManager", "restoreAllState: adding #" + i2 + ": " + a2);
                        }
                        this.f.add(a2);
                        fragmentState2.k = null;
                    } else {
                        if (a) {
                            Log.v("FragmentManager", "restoreAllState: adding #" + i2 + ": (null)");
                        }
                        this.f.add(null);
                        if (this.h == null) {
                            this.h = new ArrayList();
                        }
                        if (a) {
                            Log.v("FragmentManager", "restoreAllState: adding avail #" + i2);
                        }
                        this.h.add(Integer.valueOf(i2));
                    }
                }
                if (arrayList != null) {
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        Fragment fragment2 = (Fragment) arrayList.get(i3);
                        if (fragment2.r >= 0) {
                            if (fragment2.r < this.f.size()) {
                                fragment2.q = (Fragment) this.f.get(fragment2.r);
                            } else {
                                Log.w("FragmentManager", "Re-attaching retained fragment " + fragment2 + " target no longer exists: " + fragment2.r);
                                fragment2.q = null;
                            }
                        }
                    }
                }
                if (fragmentManagerState.b != null) {
                    this.g = new ArrayList(fragmentManagerState.b.length);
                    for (int i4 = 0; i4 < fragmentManagerState.b.length; i4++) {
                        Fragment fragment3 = (Fragment) this.f.get(fragmentManagerState.b[i4]);
                        if (fragment3 == null) {
                            throw new IllegalStateException("No instantiated fragment for index #" + fragmentManagerState.b[i4]);
                        }
                        fragment3.t = true;
                        if (a) {
                            Log.v("FragmentManager", "restoreAllState: making added #" + i4 + ": " + fragment3);
                        }
                        this.g.add(fragment3);
                    }
                } else {
                    this.g = null;
                }
                if (fragmentManagerState.c != null) {
                    this.i = new ArrayList(fragmentManagerState.c.length);
                    for (int i5 = 0; i5 < fragmentManagerState.c.length; i5++) {
                        b a3 = fragmentManagerState.c[i5].a(this);
                        if (a) {
                            Log.v("FragmentManager", "restoreAllState: adding bse #" + i5 + " (index " + a3.o + "): " + a3);
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

    public void a(g gVar) {
        if (this.o != null) {
            throw new IllegalStateException();
        }
        this.o = gVar;
    }

    public void i() {
        this.q = false;
    }

    public void j() {
        this.q = false;
        a(1, false);
    }

    public void k() {
        this.q = false;
        a(2, false);
    }

    public void l() {
        this.q = false;
        a(4, false);
    }

    public void m() {
        this.q = false;
        a(5, false);
    }

    public void n() {
        a(4, false);
    }

    public void o() {
        this.q = true;
        a(3, false);
    }

    public void p() {
        a(2, false);
    }

    public void q() {
        this.r = true;
        e();
        a(0, false);
        this.o = null;
    }

    public void a(Configuration configuration) {
        if (this.f != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.g.size()) {
                    Fragment fragment = (Fragment) this.g.get(i2);
                    if (fragment != null) {
                        fragment.onConfigurationChanged(configuration);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void r() {
        if (this.f != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.g.size()) {
                    Fragment fragment = (Fragment) this.g.get(i2);
                    if (fragment != null) {
                        fragment.onLowMemory();
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
        ArrayList arrayList = null;
        if (this.f != null) {
            int i = 0;
            z2 = false;
            while (i < this.g.size()) {
                Fragment fragment = (Fragment) this.g.get(i);
                if (fragment != null && !fragment.F && fragment.J && fragment.K) {
                    z2 = true;
                    fragment.a(menu, menuInflater);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
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
                Fragment fragment2 = (Fragment) this.j.get(i2);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.o();
                }
            }
        }
        this.j = arrayList;
        return z2;
    }

    public boolean a(Menu menu) {
        if (this.f != null) {
            boolean z2 = false;
            for (int i = 0; i < this.g.size(); i++) {
                Fragment fragment = (Fragment) this.g.get(i);
                if (fragment != null && !fragment.F && fragment.J && fragment.K) {
                    z2 = true;
                    fragment.a(menu);
                }
            }
            return z2;
        }
        return false;
    }

    public boolean a(MenuItem menuItem) {
        if (this.f != null) {
            for (int i = 0; i < this.g.size(); i++) {
                Fragment fragment = (Fragment) this.g.get(i);
                if (fragment != null && !fragment.F && fragment.J && fragment.K && fragment.a(menuItem)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public boolean b(MenuItem menuItem) {
        if (this.f != null) {
            for (int i = 0; i < this.g.size(); i++) {
                Fragment fragment = (Fragment) this.g.get(i);
                if (fragment != null && !fragment.F && fragment.b(menuItem)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public void b(Menu menu) {
        if (this.f != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.g.size()) {
                    Fragment fragment = (Fragment) this.g.get(i2);
                    if (fragment != null && !fragment.F && fragment.J && fragment.K) {
                        fragment.b(menu);
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
