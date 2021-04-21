package com.baidu.swan.support.v4.app;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import com.bumptech.glide.load.engine.GlideException;
import d.b.h0.m.a.a.h;
import d.b.h0.m.a.a.j;
import d.b.h0.m.a.a.k;
import d.b.h0.m.a.a.l;
import d.b.h0.m.a.a.p;
import d.b.h0.m.a.c.c;
import d.b.h0.m.a.c.f;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* loaded from: classes3.dex */
public class Fragment implements ComponentCallbacks, View.OnCreateContextMenuListener {
    public static final f<String, Class<?>> d0 = new f<>();
    public static final Object e0 = new Object();
    public int A;
    public int B;
    public String C;
    public boolean D;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean J;
    public int K;
    public ViewGroup L;
    public View M;
    public View N;
    public boolean O;
    public p Q;
    public boolean R;
    public boolean S;
    public Object U;
    public Object V;
    public Object W;
    public Object X;
    public Object Y;
    public Boolean Z;
    public Boolean a0;
    public SharedElementCallback b0;
    public SharedElementCallback c0;

    /* renamed from: f  reason: collision with root package name */
    public View f12701f;

    /* renamed from: g  reason: collision with root package name */
    public int f12702g;

    /* renamed from: h  reason: collision with root package name */
    public Bundle f12703h;
    public SparseArray<Parcelable> i;
    public String k;
    public Bundle l;
    public Fragment m;
    public int o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public int v;
    public l w;
    public j x;
    public l y;
    public Fragment z;

    /* renamed from: e  reason: collision with root package name */
    public int f12700e = 0;
    public int j = -1;
    public int n = -1;
    public boolean I = true;
    public boolean P = true;
    public Object T = null;

    /* loaded from: classes3.dex */
    public static class InstantiationException extends RuntimeException {
        public InstantiationException(String str, Exception exc) {
            super(str, exc);
        }
    }

    /* loaded from: classes3.dex */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: e  reason: collision with root package name */
        public final Bundle f12704e;

        /* loaded from: classes3.dex */
        public static class a implements Parcelable.Creator<SavedState> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            Bundle readBundle = parcel.readBundle();
            this.f12704e = readBundle;
            if (classLoader == null || readBundle == null) {
                return;
            }
            readBundle.setClassLoader(classLoader);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeBundle(this.f12704e);
        }
    }

    /* loaded from: classes3.dex */
    public class a extends h {
        public a() {
        }

        @Override // d.b.h0.m.a.a.h
        @Nullable
        public View a(int i) {
            View view = Fragment.this.M;
            if (view != null) {
                return view.findViewById(i);
            }
            throw new IllegalStateException("Fragment does not have a view");
        }

        @Override // d.b.h0.m.a.a.h
        public boolean b() {
            return Fragment.this.M != null;
        }
    }

    public Fragment() {
        Object obj = e0;
        this.U = obj;
        this.V = null;
        this.W = obj;
        this.X = null;
        this.Y = obj;
        this.b0 = null;
        this.c0 = null;
    }

    public static Fragment Y(Context context, String str) {
        return g0(context, str, null);
    }

    public static Fragment g0(Context context, String str, @Nullable Bundle bundle) {
        try {
            Class<?> cls = d0.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                d0.put(str, cls);
            }
            Fragment fragment = (Fragment) cls.newInstance();
            if (bundle != null) {
                bundle.setClassLoader(fragment.getClass().getClassLoader());
                fragment.l = bundle;
            }
            return fragment;
        } catch (ClassNotFoundException e2) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e2);
        } catch (IllegalAccessException e3) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e3);
        } catch (java.lang.InstantiationException e4) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e4);
        }
    }

    public static boolean n0(Context context, String str) {
        try {
            Class<?> cls = d0.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                d0.put(str, cls);
            }
            return Fragment.class.isAssignableFrom(cls);
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public Object A() {
        return this.X;
    }

    @Deprecated
    public void A0(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.J = true;
    }

    public void B0(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.J = true;
        j jVar = this.x;
        Activity g2 = jVar == null ? null : jVar.g();
        if (g2 != null) {
            this.J = false;
            A0(g2, attributeSet, bundle);
        }
    }

    public boolean C0(MenuItem menuItem) {
        return false;
    }

    public void D0(Menu menu) {
    }

    public void E0(Menu menu) {
    }

    public Object F() {
        Object obj = this.Y;
        return obj == e0 ? A() : obj;
    }

    public void F0(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
    }

    public final String G(@StringRes int i) {
        return u().getString(i);
    }

    public void G0(Bundle bundle) {
    }

    public void H0(View view, @Nullable Bundle bundle) {
    }

    public void I0(@Nullable Bundle bundle) {
        this.J = true;
    }

    public final String J(@StringRes int i, Object... objArr) {
        return u().getString(i, objArr);
    }

    public void J0(Bundle bundle) {
        l lVar = this.y;
        if (lVar != null) {
            lVar.U();
        }
        this.J = false;
        o0(bundle);
        if (this.J) {
            l lVar2 = this.y;
            if (lVar2 != null) {
                lVar2.m();
                return;
            }
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onActivityCreated()");
    }

    public final Fragment K() {
        return this.m;
    }

    public void K0(Configuration configuration) {
        onConfigurationChanged(configuration);
        l lVar = this.y;
        if (lVar != null) {
            lVar.n(configuration);
        }
    }

    public boolean L0(MenuItem menuItem) {
        if (this.D) {
            return false;
        }
        if (s0(menuItem)) {
            return true;
        }
        l lVar = this.y;
        return lVar != null && lVar.o(menuItem);
    }

    public void M0(Bundle bundle) {
        Parcelable parcelable;
        l lVar = this.y;
        if (lVar != null) {
            lVar.U();
        }
        this.J = false;
        onCreate(bundle);
        if (!this.J) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onCreate()");
        } else if (bundle == null || (parcelable = bundle.getParcelable("android:support:fragments")) == null) {
        } else {
            if (this.y == null) {
                h0();
            }
            this.y.a0(parcelable, null);
            this.y.p();
        }
    }

    public boolean N0(Menu menu, MenuInflater menuInflater) {
        boolean z = false;
        if (this.D) {
            return false;
        }
        if (this.H && this.I) {
            u0(menu, menuInflater);
            z = true;
        }
        l lVar = this.y;
        return lVar != null ? z | lVar.q(menu, menuInflater) : z;
    }

    public View O0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        l lVar = this.y;
        if (lVar != null) {
            lVar.U();
        }
        return v0(layoutInflater, viewGroup, bundle);
    }

    public void P0() {
        l lVar = this.y;
        if (lVar != null) {
            lVar.r();
        }
        this.J = false;
        onDestroy();
        if (this.J) {
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroy()");
    }

    public void Q0() {
        l lVar = this.y;
        if (lVar != null) {
            lVar.s();
        }
        this.J = false;
        x0();
        if (this.J) {
            p pVar = this.Q;
            if (pVar != null) {
                pVar.c();
                return;
            }
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroyView()");
    }

    public void R0() {
        onLowMemory();
        l lVar = this.y;
        if (lVar != null) {
            lVar.t();
        }
    }

    public final int S() {
        return this.o;
    }

    public boolean S0(MenuItem menuItem) {
        if (this.D) {
            return false;
        }
        if (this.H && this.I && C0(menuItem)) {
            return true;
        }
        l lVar = this.y;
        return lVar != null && lVar.u(menuItem);
    }

    public boolean T() {
        return this.P;
    }

    public void T0(Menu menu) {
        if (this.D) {
            return;
        }
        if (this.H && this.I) {
            D0(menu);
        }
        l lVar = this.y;
        if (lVar != null) {
            lVar.v(menu);
        }
    }

    public void U0() {
        l lVar = this.y;
        if (lVar != null) {
            lVar.w();
        }
        this.J = false;
        onPause();
        if (this.J) {
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onPause()");
    }

    public boolean V0(Menu menu) {
        boolean z = false;
        if (this.D) {
            return false;
        }
        if (this.H && this.I) {
            E0(menu);
            z = true;
        }
        l lVar = this.y;
        return lVar != null ? z | lVar.x(menu) : z;
    }

    @Nullable
    public View W() {
        return this.M;
    }

    public void W0() {
        l lVar = this.y;
        if (lVar != null) {
            lVar.y();
        }
        if (this.R) {
            this.R = false;
            if (!this.S) {
                this.S = true;
                this.Q = this.x.k(this.k, false, false);
            }
            p pVar = this.Q;
            if (pVar != null) {
                if (!this.G) {
                    pVar.g();
                } else {
                    pVar.e();
                }
            }
        }
    }

    public void X() {
        this.j = -1;
        this.k = null;
        this.p = false;
        this.q = false;
        this.r = false;
        this.s = false;
        this.t = false;
        this.u = false;
        this.v = 0;
        this.w = null;
        this.y = null;
        this.x = null;
        this.A = 0;
        this.B = 0;
        this.C = null;
        this.D = false;
        this.E = false;
        this.G = false;
        this.Q = null;
        this.R = false;
        this.S = false;
    }

    public void X0() {
        l lVar = this.y;
        if (lVar != null) {
            lVar.U();
            this.y.D();
        }
        this.J = false;
        onResume();
        if (this.J) {
            l lVar2 = this.y;
            if (lVar2 != null) {
                lVar2.z();
                this.y.D();
                return;
            }
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onResume()");
    }

    public void Y0(Bundle bundle) {
        Parcelable d02;
        G0(bundle);
        l lVar = this.y;
        if (lVar == null || (d02 = lVar.d0()) == null) {
            return;
        }
        bundle.putParcelable("android:support:fragments", d02);
    }

    public void Z0() {
        l lVar = this.y;
        if (lVar != null) {
            lVar.U();
            this.y.D();
        }
        this.J = false;
        onStart();
        if (this.J) {
            l lVar2 = this.y;
            if (lVar2 != null) {
                lVar2.A();
            }
            p pVar = this.Q;
            if (pVar != null) {
                pVar.d();
                return;
            }
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStart()");
    }

    public void a1() {
        l lVar = this.y;
        if (lVar != null) {
            lVar.B();
        }
        this.J = false;
        onStop();
        if (this.J) {
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStop()");
    }

    public final void b1(@NonNull String[] strArr, int i) {
        j jVar = this.x;
        if (jVar != null) {
            jVar.s(this, strArr, i);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public final void c1(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = this.i;
        if (sparseArray != null) {
            this.N.restoreHierarchyState(sparseArray);
            this.i = null;
        }
        this.J = false;
        I0(bundle);
        if (this.J) {
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onViewStateRestored()");
    }

    public void d1(Bundle bundle) {
        if (this.j < 0) {
            this.l = bundle;
            return;
        }
        throw new IllegalStateException("Fragment already active");
    }

    public void e(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.A));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.B));
        printWriter.print(" mTag=");
        printWriter.println(this.C);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.f12700e);
        printWriter.print(" mIndex=");
        printWriter.print(this.j);
        printWriter.print(" mWho=");
        printWriter.print(this.k);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.v);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.p);
        printWriter.print(" mRemoving=");
        printWriter.print(this.q);
        printWriter.print(" mResumed=");
        printWriter.print(this.r);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.s);
        printWriter.print(" mInLayout=");
        printWriter.println(this.t);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.D);
        printWriter.print(" mDetached=");
        printWriter.print(this.E);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.I);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.H);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.F);
        printWriter.print(" mRetaining=");
        printWriter.print(this.G);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.P);
        if (this.w != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.w);
        }
        if (this.x != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.x);
        }
        if (this.z != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.z);
        }
        if (this.l != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.l);
        }
        if (this.f12703h != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.f12703h);
        }
        if (this.i != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.i);
        }
        if (this.m != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(this.m);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.o);
        }
        if (this.K != 0) {
            printWriter.print(str);
            printWriter.print("mNextAnim=");
            printWriter.println(this.K);
        }
        if (this.L != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.L);
        }
        if (this.M != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.M);
        }
        if (this.N != null) {
            printWriter.print(str);
            printWriter.print("mInnerView=");
            printWriter.println(this.M);
        }
        if (this.f12701f != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(this.f12701f);
            printWriter.print(str);
            printWriter.print("mStateAfterAnimating=");
            printWriter.println(this.f12702g);
        }
        if (this.Q != null) {
            printWriter.print(str);
            printWriter.println("Loader Manager:");
            p pVar = this.Q;
            pVar.h(str + GlideException.IndentedAppendable.INDENT, fileDescriptor, printWriter, strArr);
        }
        if (this.y != null) {
            printWriter.print(str);
            printWriter.println("Child " + this.y + ":");
            l lVar = this.y;
            lVar.b(str + GlideException.IndentedAppendable.INDENT, fileDescriptor, printWriter, strArr);
        }
    }

    public final void e1(int i, Fragment fragment) {
        this.j = i;
        if (fragment != null) {
            this.k = fragment.k + ":" + this.j;
            return;
        }
        this.k = "android:fragment:" + this.j;
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final FragmentActivity f() {
        j jVar = this.x;
        if (jVar == null) {
            return null;
        }
        return (FragmentActivity) jVar.g();
    }

    public void f1(Fragment fragment, int i) {
        this.m = fragment;
        this.o = i;
    }

    public void g1(boolean z) {
        if (!this.P && z && this.f12700e < 4) {
            this.w.V(this);
        }
        this.P = z;
        this.O = !z;
    }

    public boolean h() {
        Boolean bool = this.a0;
        if (bool == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public void h0() {
        l lVar = new l();
        this.y = lVar;
        lVar.i(this.x, new a(), this);
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public boolean i() {
        Boolean bool = this.Z;
        if (bool == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public final boolean i0() {
        return this.x != null && this.p;
    }

    public final Bundle j() {
        return this.l;
    }

    public final boolean j0() {
        return this.E;
    }

    public final k k() {
        if (this.y == null) {
            h0();
            int i = this.f12700e;
            if (i >= 5) {
                this.y.z();
            } else if (i >= 4) {
                this.y.A();
            } else if (i >= 2) {
                this.y.m();
            } else if (i >= 1) {
                this.y.p();
            }
        }
        return this.y;
    }

    public Context l() {
        j jVar = this.x;
        if (jVar == null) {
            return null;
        }
        return jVar.h();
    }

    public final boolean l0() {
        return this.D;
    }

    public final boolean m0() {
        return this.v > 0;
    }

    public Object o() {
        return this.T;
    }

    public void o0(@Nullable Bundle bundle) {
        this.J = true;
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.J = true;
    }

    public void onCreate(@Nullable Bundle bundle) {
        this.J = true;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        f().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public void onDestroy() {
        this.J = true;
        if (!this.S) {
            this.S = true;
            this.Q = this.x.k(this.k, this.R, false);
        }
        p pVar = this.Q;
        if (pVar != null) {
            pVar.b();
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.J = true;
    }

    public void onPause() {
        this.J = true;
    }

    public void onResume() {
        this.J = true;
    }

    public void onStart() {
        this.J = true;
        if (this.R) {
            return;
        }
        this.R = true;
        if (!this.S) {
            this.S = true;
            this.Q = this.x.k(this.k, true, false);
        }
        p pVar = this.Q;
        if (pVar != null) {
            pVar.f();
        }
    }

    public void onStop() {
        this.J = true;
    }

    public Object p() {
        return this.V;
    }

    public void p0(int i, int i2, Intent intent) {
    }

    public LayoutInflater q(Bundle bundle) {
        LayoutInflater p = this.x.p();
        k();
        l lVar = this.y;
        lVar.I();
        d.b.h0.m.a.d.a.a(p, lVar);
        return p;
    }

    @Deprecated
    public void q0(Activity activity) {
        this.J = true;
    }

    public Object r() {
        Object obj = this.W;
        return obj == e0 ? p() : obj;
    }

    public void r0(Context context) {
        this.J = true;
        j jVar = this.x;
        Activity g2 = jVar == null ? null : jVar.g();
        if (g2 != null) {
            this.J = false;
            q0(g2);
        }
    }

    public boolean s0(MenuItem menuItem) {
        return false;
    }

    public Animation t0(int i, boolean z, int i2) {
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        c.a(this, sb);
        if (this.j >= 0) {
            sb.append(" #");
            sb.append(this.j);
        }
        if (this.A != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.A));
        }
        if (this.C != null) {
            sb.append(" ");
            sb.append(this.C);
        }
        sb.append('}');
        return sb.toString();
    }

    public final Resources u() {
        j jVar = this.x;
        if (jVar != null) {
            return jVar.h().getResources();
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public void u0(Menu menu, MenuInflater menuInflater) {
    }

    @Nullable
    public View v0(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return null;
    }

    public void w0() {
    }

    public void x0() {
        this.J = true;
    }

    public Object y() {
        Object obj = this.U;
        return obj == e0 ? o() : obj;
    }

    public void y0() {
        this.J = true;
    }

    public void z0(boolean z) {
    }
}
