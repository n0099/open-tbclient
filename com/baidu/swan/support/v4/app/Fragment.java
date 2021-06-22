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
import d.a.m0.o.a.a.i;
import d.a.m0.o.a.a.k;
import d.a.m0.o.a.a.l;
import d.a.m0.o.a.a.m;
import d.a.m0.o.a.a.q;
import d.a.m0.o.a.c.c;
import d.a.m0.o.a.c.f;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* loaded from: classes3.dex */
public class Fragment implements ComponentCallbacks, View.OnCreateContextMenuListener {
    public static final f<String, Class<?>> i0 = new f<>();
    public static final Object j0 = new Object();
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
    public q Q;
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
    public View f11994f;

    /* renamed from: g  reason: collision with root package name */
    public int f11995g;

    /* renamed from: h  reason: collision with root package name */
    public Bundle f11996h;

    /* renamed from: i  reason: collision with root package name */
    public SparseArray<Parcelable> f11997i;
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
    public m w;
    public k x;
    public m y;
    public Fragment z;

    /* renamed from: e  reason: collision with root package name */
    public int f11993e = 0;
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
        public final Bundle f11998e;

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
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            Bundle readBundle = parcel.readBundle();
            this.f11998e = readBundle;
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
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeBundle(this.f11998e);
        }
    }

    /* loaded from: classes3.dex */
    public class a extends i {
        public a() {
        }

        @Override // d.a.m0.o.a.a.i
        @Nullable
        public View a(int i2) {
            View view = Fragment.this.M;
            if (view != null) {
                return view.findViewById(i2);
            }
            throw new IllegalStateException("Fragment does not have a view");
        }

        @Override // d.a.m0.o.a.a.i
        public boolean b() {
            return Fragment.this.M != null;
        }
    }

    public Fragment() {
        Object obj = j0;
        this.U = obj;
        this.V = null;
        this.W = obj;
        this.X = null;
        this.Y = obj;
        this.b0 = null;
        this.c0 = null;
    }

    public static Fragment e0(Context context, String str) {
        return g0(context, str, null);
    }

    public static Fragment g0(Context context, String str, @Nullable Bundle bundle) {
        try {
            Class<?> cls = i0.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                i0.put(str, cls);
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

    public static boolean s0(Context context, String str) {
        try {
            Class<?> cls = i0.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                i0.put(str, cls);
            }
            return Fragment.class.isAssignableFrom(cls);
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public Object A() {
        Object obj = this.U;
        return obj == j0 ? r() : obj;
    }

    public void A0(Menu menu, MenuInflater menuInflater) {
    }

    @Nullable
    public View B0(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return null;
    }

    public void C0() {
    }

    public void D0() {
        this.J = true;
    }

    public void E0() {
        this.J = true;
    }

    public void F0(boolean z) {
    }

    @Deprecated
    public void G0(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.J = true;
    }

    public Object H() {
        return this.X;
    }

    public void H0(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.J = true;
        k kVar = this.x;
        Activity g2 = kVar == null ? null : kVar.g();
        if (g2 != null) {
            this.J = false;
            G0(g2, attributeSet, bundle);
        }
    }

    public Object I() {
        Object obj = this.Y;
        return obj == j0 ? H() : obj;
    }

    public boolean I0(MenuItem menuItem) {
        return false;
    }

    public final String J(@StringRes int i2) {
        return z().getString(i2);
    }

    public void J0(Menu menu) {
    }

    public void K0(Menu menu) {
    }

    public void L0(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
    }

    public void M0(Bundle bundle) {
    }

    public final String N(@StringRes int i2, Object... objArr) {
        return z().getString(i2, objArr);
    }

    public void N0(View view, @Nullable Bundle bundle) {
    }

    public void O0(@Nullable Bundle bundle) {
        this.J = true;
    }

    public final Fragment P() {
        return this.m;
    }

    public void P0(Bundle bundle) {
        m mVar = this.y;
        if (mVar != null) {
            mVar.V();
        }
        this.J = false;
        t0(bundle);
        if (this.J) {
            m mVar2 = this.y;
            if (mVar2 != null) {
                mVar2.n();
                return;
            }
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onActivityCreated()");
    }

    public void Q0(Configuration configuration) {
        onConfigurationChanged(configuration);
        m mVar = this.y;
        if (mVar != null) {
            mVar.o(configuration);
        }
    }

    public final int R() {
        return this.o;
    }

    public boolean R0(MenuItem menuItem) {
        if (this.D) {
            return false;
        }
        if (y0(menuItem)) {
            return true;
        }
        m mVar = this.y;
        return mVar != null && mVar.p(menuItem);
    }

    public void S0(Bundle bundle) {
        Parcelable parcelable;
        m mVar = this.y;
        if (mVar != null) {
            mVar.V();
        }
        this.J = false;
        onCreate(bundle);
        if (!this.J) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onCreate()");
        } else if (bundle == null || (parcelable = bundle.getParcelable("android:support:fragments")) == null) {
        } else {
            if (this.y == null) {
                k0();
            }
            this.y.b0(parcelable, null);
            this.y.q();
        }
    }

    public final CharSequence T(@StringRes int i2) {
        return z().getText(i2);
    }

    public boolean T0(Menu menu, MenuInflater menuInflater) {
        boolean z = false;
        if (this.D) {
            return false;
        }
        if (this.H && this.I) {
            A0(menu, menuInflater);
            z = true;
        }
        m mVar = this.y;
        return mVar != null ? z | mVar.r(menu, menuInflater) : z;
    }

    public View U0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        m mVar = this.y;
        if (mVar != null) {
            mVar.V();
        }
        return B0(layoutInflater, viewGroup, bundle);
    }

    public boolean V() {
        return this.P;
    }

    public void V0() {
        m mVar = this.y;
        if (mVar != null) {
            mVar.s();
        }
        this.J = false;
        onDestroy();
        if (this.J) {
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroy()");
    }

    public void W0() {
        m mVar = this.y;
        if (mVar != null) {
            mVar.t();
        }
        this.J = false;
        D0();
        if (this.J) {
            q qVar = this.Q;
            if (qVar != null) {
                qVar.c();
                return;
            }
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroyView()");
    }

    public void X0() {
        onLowMemory();
        m mVar = this.y;
        if (mVar != null) {
            mVar.u();
        }
    }

    public boolean Y0(MenuItem menuItem) {
        if (this.D) {
            return false;
        }
        if (this.H && this.I && I0(menuItem)) {
            return true;
        }
        m mVar = this.y;
        return mVar != null && mVar.v(menuItem);
    }

    public void Z0(Menu menu) {
        if (this.D) {
            return;
        }
        if (this.H && this.I) {
            J0(menu);
        }
        m mVar = this.y;
        if (mVar != null) {
            mVar.w(menu);
        }
    }

    public void a1() {
        m mVar = this.y;
        if (mVar != null) {
            mVar.x();
        }
        this.J = false;
        onPause();
        if (this.J) {
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onPause()");
    }

    @Nullable
    public View b0() {
        return this.M;
    }

    public boolean b1(Menu menu) {
        boolean z = false;
        if (this.D) {
            return false;
        }
        if (this.H && this.I) {
            K0(menu);
            z = true;
        }
        m mVar = this.y;
        return mVar != null ? z | mVar.y(menu) : z;
    }

    public void c0() {
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

    public void c1() {
        m mVar = this.y;
        if (mVar != null) {
            mVar.z();
        }
        if (this.R) {
            this.R = false;
            if (!this.S) {
                this.S = true;
                this.Q = this.x.k(this.k, false, false);
            }
            q qVar = this.Q;
            if (qVar != null) {
                if (!this.G) {
                    qVar.g();
                } else {
                    qVar.e();
                }
            }
        }
    }

    public void d1() {
        m mVar = this.y;
        if (mVar != null) {
            mVar.V();
            this.y.E();
        }
        this.J = false;
        onResume();
        if (this.J) {
            m mVar2 = this.y;
            if (mVar2 != null) {
                mVar2.A();
                this.y.E();
                return;
            }
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onResume()");
    }

    public void e1(Bundle bundle) {
        Parcelable e0;
        M0(bundle);
        m mVar = this.y;
        if (mVar == null || (e0 = mVar.e0()) == null) {
            return;
        }
        bundle.putParcelable("android:support:fragments", e0);
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public void f1() {
        m mVar = this.y;
        if (mVar != null) {
            mVar.V();
            this.y.E();
        }
        this.J = false;
        onStart();
        if (this.J) {
            m mVar2 = this.y;
            if (mVar2 != null) {
                mVar2.B();
            }
            q qVar = this.Q;
            if (qVar != null) {
                qVar.d();
                return;
            }
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStart()");
    }

    public void g(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.A));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.B));
        printWriter.print(" mTag=");
        printWriter.println(this.C);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.f11993e);
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
        if (this.f11996h != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.f11996h);
        }
        if (this.f11997i != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.f11997i);
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
        if (this.f11994f != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(this.f11994f);
            printWriter.print(str);
            printWriter.print("mStateAfterAnimating=");
            printWriter.println(this.f11995g);
        }
        if (this.Q != null) {
            printWriter.print(str);
            printWriter.println("Loader Manager:");
            q qVar = this.Q;
            qVar.h(str + GlideException.IndentedAppendable.INDENT, fileDescriptor, printWriter, strArr);
        }
        if (this.y != null) {
            printWriter.print(str);
            printWriter.println("Child " + this.y + ":");
            m mVar = this.y;
            mVar.b(str + GlideException.IndentedAppendable.INDENT, fileDescriptor, printWriter, strArr);
        }
    }

    public void g1() {
        m mVar = this.y;
        if (mVar != null) {
            mVar.C();
        }
        this.J = false;
        onStop();
        if (this.J) {
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStop()");
    }

    public final FragmentActivity h() {
        k kVar = this.x;
        if (kVar == null) {
            return null;
        }
        return (FragmentActivity) kVar.g();
    }

    public final void h1(@NonNull String[] strArr, int i2) {
        k kVar = this.x;
        if (kVar != null) {
            kVar.s(this, strArr, i2);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final void i1(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = this.f11997i;
        if (sparseArray != null) {
            this.N.restoreHierarchyState(sparseArray);
            this.f11997i = null;
        }
        this.J = false;
        O0(bundle);
        if (this.J) {
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onViewStateRestored()");
    }

    public boolean j() {
        Boolean bool = this.a0;
        if (bool == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public void j1(Bundle bundle) {
        if (this.j < 0) {
            this.l = bundle;
            return;
        }
        throw new IllegalStateException("Fragment already active");
    }

    public boolean k() {
        Boolean bool = this.Z;
        if (bool == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public void k0() {
        m mVar = new m();
        this.y = mVar;
        mVar.j(this.x, new a(), this);
    }

    public final void k1(int i2, Fragment fragment) {
        this.j = i2;
        if (fragment != null) {
            this.k = fragment.k + ":" + this.j;
            return;
        }
        this.k = "android:fragment:" + this.j;
    }

    public final boolean l0() {
        return this.x != null && this.p;
    }

    public void l1(Fragment fragment, int i2) {
        this.m = fragment;
        this.o = i2;
    }

    public final boolean m0() {
        return this.E;
    }

    public void m1(boolean z) {
        if (!this.P && z && this.f11993e < 4) {
            this.w.W(this);
        }
        this.P = z;
        this.O = !z;
    }

    public final Bundle n() {
        return this.l;
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
        h().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public void onDestroy() {
        this.J = true;
        if (!this.S) {
            this.S = true;
            this.Q = this.x.k(this.k, this.R, false);
        }
        q qVar = this.Q;
        if (qVar != null) {
            qVar.b();
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
        q qVar = this.Q;
        if (qVar != null) {
            qVar.f();
        }
    }

    public void onStop() {
        this.J = true;
    }

    public final l p() {
        if (this.y == null) {
            k0();
            int i2 = this.f11993e;
            if (i2 >= 5) {
                this.y.A();
            } else if (i2 >= 4) {
                this.y.B();
            } else if (i2 >= 2) {
                this.y.n();
            } else if (i2 >= 1) {
                this.y.q();
            }
        }
        return this.y;
    }

    public final boolean p0() {
        return this.D;
    }

    public Context q() {
        k kVar = this.x;
        if (kVar == null) {
            return null;
        }
        return kVar.h();
    }

    public final boolean q0() {
        return this.v > 0;
    }

    public Object r() {
        return this.T;
    }

    public Object s() {
        return this.V;
    }

    public void t0(@Nullable Bundle bundle) {
        this.J = true;
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

    public final l u() {
        return this.w;
    }

    public LayoutInflater v(Bundle bundle) {
        LayoutInflater p = this.x.p();
        p();
        m mVar = this.y;
        mVar.J();
        d.a.m0.o.a.d.a.a(p, mVar);
        return p;
    }

    public void v0(int i2, int i3, Intent intent) {
    }

    public Object w() {
        Object obj = this.W;
        return obj == j0 ? s() : obj;
    }

    @Deprecated
    public void w0(Activity activity) {
        this.J = true;
    }

    public void x0(Context context) {
        this.J = true;
        k kVar = this.x;
        Activity g2 = kVar == null ? null : kVar.g();
        if (g2 != null) {
            this.J = false;
            w0(g2);
        }
    }

    public boolean y0(MenuItem menuItem) {
        return false;
    }

    public final Resources z() {
        k kVar = this.x;
        if (kVar != null) {
            return kVar.h().getResources();
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public Animation z0(int i2, boolean z, int i3) {
        return null;
    }
}
