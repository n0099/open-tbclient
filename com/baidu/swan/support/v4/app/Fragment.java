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
import com.baidu.tieba.aq4;
import com.baidu.tieba.iq4;
import com.baidu.tieba.lq4;
import com.baidu.tieba.nq4;
import com.baidu.tieba.sp4;
import com.baidu.tieba.up4;
import com.baidu.tieba.vp4;
import com.baidu.tieba.wp4;
import com.bumptech.glide.load.engine.GlideException;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* loaded from: classes4.dex */
public class Fragment implements ComponentCallbacks, View.OnCreateContextMenuListener {
    public static final lq4<String, Class<?>> Z = new lq4<>();
    public static final Object a0 = new Object();
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean F;
    public int G;
    public ViewGroup H;
    public View I;
    public View J;
    public boolean K;
    public aq4 M;
    public boolean N;
    public boolean O;
    public Object Q;
    public Object R;
    public Object S;

    /* renamed from: T  reason: collision with root package name */
    public Object f1076T;
    public Object U;
    public Boolean V;
    public Boolean W;
    public SharedElementCallback X;
    public SharedElementCallback Y;
    public View b;
    public int c;
    public Bundle d;
    public SparseArray<Parcelable> e;
    public String g;
    public Bundle h;
    public Fragment i;
    public int k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public int r;
    public wp4 s;
    public up4 t;
    public wp4 u;
    public Fragment v;
    public int w;
    public int x;
    public String y;
    public boolean z;
    public int a = 0;
    public int f = -1;
    public int j = -1;
    public boolean E = true;
    public boolean L = true;
    public Object P = null;

    public void A0() {
    }

    public void D0(boolean z) {
    }

    public boolean G0(MenuItem menuItem) {
        return false;
    }

    public void H0(Menu menu) {
    }

    public void I0(Menu menu) {
    }

    public void J0(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
    }

    public void K0(Bundle bundle) {
    }

    public void N0(View view2, @Nullable Bundle bundle) {
    }

    public void r0(int i, int i2, Intent intent) {
    }

    public boolean u0(MenuItem menuItem) {
        return false;
    }

    public Animation w0(int i, boolean z, int i2) {
        return null;
    }

    public void x0(Menu menu, MenuInflater menuInflater) {
    }

    @Nullable
    public View y0(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return null;
    }

    /* loaded from: classes4.dex */
    public static class InstantiationException extends RuntimeException {
        public InstantiationException(String str, Exception exc) {
            super(str, exc);
        }
    }

    /* loaded from: classes4.dex */
    public class a extends sp4 {
        public a() {
        }

        @Override // com.baidu.tieba.sp4
        @Nullable
        public View a(int i) {
            View view2 = Fragment.this.I;
            if (view2 != null) {
                return view2.findViewById(i);
            }
            throw new IllegalStateException("Fragment does not have a view");
        }

        @Override // com.baidu.tieba.sp4
        public boolean b() {
            if (Fragment.this.I != null) {
                return true;
            }
            return false;
        }
    }

    public Fragment() {
        Object obj = a0;
        this.Q = obj;
        this.R = null;
        this.S = obj;
        this.f1076T = null;
        this.U = obj;
        this.X = null;
        this.Y = null;
    }

    public final vp4 A() {
        return this.s;
    }

    public void B0() {
        this.F = true;
    }

    public void C0() {
        this.F = true;
    }

    public Object D() {
        Object obj = this.S;
        if (obj == a0) {
            return t();
        }
        return obj;
    }

    public Object E() {
        Object obj = this.Q;
        if (obj == a0) {
            return r();
        }
        return obj;
    }

    public Object F() {
        return this.f1076T;
    }

    public Object G() {
        Object obj = this.U;
        if (obj == a0) {
            return F();
        }
        return obj;
    }

    public void L0() {
        this.F = true;
        if (!this.N) {
            this.N = true;
            if (!this.O) {
                this.O = true;
                this.M = this.t.i(this.g, true, false);
            }
            aq4 aq4Var = this.M;
            if (aq4Var != null) {
                aq4Var.f();
            }
        }
    }

    public void M0() {
        this.F = true;
    }

    public final Fragment S() {
        return this.i;
    }

    public final int T() {
        return this.k;
    }

    public void W0() {
        wp4 wp4Var = this.u;
        if (wp4Var != null) {
            wp4Var.s();
        }
        this.F = false;
        z0();
        if (this.F) {
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroy()");
    }

    public void Y0() {
        onLowMemory();
        wp4 wp4Var = this.u;
        if (wp4Var != null) {
            wp4Var.u();
        }
    }

    public boolean Z() {
        return this.L;
    }

    @Nullable
    public View b0() {
        return this.I;
    }

    public void b1() {
        wp4 wp4Var = this.u;
        if (wp4Var != null) {
            wp4Var.x();
        }
        this.F = false;
        onPause();
        if (this.F) {
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onPause()");
    }

    public void c0() {
        this.f = -1;
        this.g = null;
        this.l = false;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = false;
        this.q = false;
        this.r = 0;
        this.s = null;
        this.u = null;
        this.t = null;
        this.w = 0;
        this.x = 0;
        this.y = null;
        this.z = false;
        this.A = false;
        this.C = false;
        this.M = null;
        this.N = false;
        this.O = false;
    }

    public void d1() {
        wp4 wp4Var = this.u;
        if (wp4Var != null) {
            wp4Var.z();
        }
        if (this.N) {
            this.N = false;
            if (!this.O) {
                this.O = true;
                this.M = this.t.i(this.g, false, false);
            }
            aq4 aq4Var = this.M;
            if (aq4Var != null) {
                if (!this.C) {
                    aq4Var.g();
                } else {
                    aq4Var.e();
                }
            }
        }
    }

    public final FragmentActivity getActivity() {
        up4 up4Var = this.t;
        if (up4Var == null) {
            return null;
        }
        return (FragmentActivity) up4Var.getActivity();
    }

    public Context getContext() {
        up4 up4Var = this.t;
        if (up4Var == null) {
            return null;
        }
        return up4Var.getContext();
    }

    public final Resources getResources() {
        up4 up4Var = this.t;
        if (up4Var != null) {
            return up4Var.getContext().getResources();
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public void i1() {
        wp4 wp4Var = this.u;
        if (wp4Var != null) {
            wp4Var.C();
        }
        this.F = false;
        M0();
        if (this.F) {
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStop()");
    }

    public void k0() {
        wp4 wp4Var = new wp4();
        this.u = wp4Var;
        wp4Var.j(this.t, new a(), this);
    }

    public final boolean l0() {
        if (this.t != null && this.l) {
            return true;
        }
        return false;
    }

    public boolean m() {
        Boolean bool = this.W;
        if (bool == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public final boolean m0() {
        return this.A;
    }

    public boolean n() {
        Boolean bool = this.V;
        if (bool == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public final boolean n0() {
        return this.z;
    }

    public final Bundle o() {
        return this.h;
    }

    public final boolean o0() {
        if (this.r > 0) {
            return true;
        }
        return false;
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.F = true;
    }

    public void onPause() {
        this.F = true;
    }

    public void onResume() {
        this.F = true;
    }

    public final vp4 p() {
        if (this.u == null) {
            k0();
            int i = this.a;
            if (i >= 5) {
                this.u.A();
            } else if (i >= 4) {
                this.u.B();
            } else if (i >= 2) {
                this.u.n();
            } else if (i >= 1) {
                this.u.q();
            }
        }
        return this.u;
    }

    public Object r() {
        return this.P;
    }

    public Object t() {
        return this.R;
    }

    public void z0() {
        this.F = true;
        if (!this.O) {
            this.O = true;
            this.M = this.t.i(this.g, this.N, false);
        }
        aq4 aq4Var = this.M;
        if (aq4Var != null) {
            aq4Var.b();
        }
    }

    /* loaded from: classes4.dex */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        public final Bundle mState;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        /* loaded from: classes4.dex */
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

        public SavedState(Bundle bundle) {
            this.mState = bundle;
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            Bundle readBundle = parcel.readBundle();
            this.mState = readBundle;
            if (classLoader != null && readBundle != null) {
                readBundle.setClassLoader(classLoader);
            }
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeBundle(this.mState);
        }
    }

    public static Fragment i0(Context context, String str) {
        return j0(context, str, null);
    }

    public static boolean p0(Context context, String str) {
        try {
            Class<?> cls = Z.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                Z.put(str, cls);
            }
            return Fragment.class.isAssignableFrom(cls);
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public final String O(@StringRes int i, Object... objArr) {
        return getResources().getString(i, objArr);
    }

    public boolean U0(Menu menu, MenuInflater menuInflater) {
        boolean z = false;
        if (this.z) {
            return false;
        }
        if (this.D && this.E) {
            x0(menu, menuInflater);
            z = true;
        }
        wp4 wp4Var = this.u;
        if (wp4Var != null) {
            return z | wp4Var.r(menu, menuInflater);
        }
        return z;
    }

    public void m1(Fragment fragment, int i) {
        this.i = fragment;
        this.k = i;
    }

    public final void requestPermissions(@NonNull String[] strArr, int i) {
        up4 up4Var = this.t;
        if (up4Var != null) {
            up4Var.p(this, strArr, i);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public void startActivityForResult(Intent intent, int i) {
        up4 up4Var = this.t;
        if (up4Var != null) {
            up4Var.r(this, intent, i);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public static Fragment j0(Context context, String str, @Nullable Bundle bundle) {
        try {
            Class<?> cls = Z.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                Z.put(str, cls);
            }
            Fragment fragment = (Fragment) cls.newInstance();
            if (bundle != null) {
                bundle.setClassLoader(fragment.getClass().getClassLoader());
                fragment.h = bundle;
            }
            return fragment;
        } catch (ClassNotFoundException e) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e);
        } catch (IllegalAccessException e2) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e2);
        } catch (java.lang.InstantiationException e3) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e3);
        }
    }

    public LayoutInflater C(Bundle bundle) {
        LayoutInflater m = this.t.m();
        p();
        wp4 wp4Var = this.u;
        wp4Var.J();
        nq4.a(m, wp4Var);
        return m;
    }

    public final String K(@StringRes int i) {
        return getResources().getString(i);
    }

    public void O0(@Nullable Bundle bundle) {
        this.F = true;
    }

    public void Q0(Configuration configuration) {
        onConfigurationChanged(configuration);
        wp4 wp4Var = this.u;
        if (wp4Var != null) {
            wp4Var.o(configuration);
        }
    }

    public boolean R0(MenuItem menuItem) {
        if (!this.z) {
            if (u0(menuItem)) {
                return true;
            }
            wp4 wp4Var = this.u;
            if (wp4Var != null && wp4Var.p(menuItem)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final CharSequence Y(@StringRes int i) {
        return getResources().getText(i);
    }

    public boolean Z0(MenuItem menuItem) {
        if (!this.z) {
            if (this.D && this.E && G0(menuItem)) {
                return true;
            }
            wp4 wp4Var = this.u;
            if (wp4Var != null && wp4Var.v(menuItem)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public void a1(Menu menu) {
        if (!this.z) {
            if (this.D && this.E) {
                H0(menu);
            }
            wp4 wp4Var = this.u;
            if (wp4Var != null) {
                wp4Var.w(menu);
            }
        }
    }

    public boolean c1(Menu menu) {
        boolean z = false;
        if (this.z) {
            return false;
        }
        if (this.D && this.E) {
            I0(menu);
            z = true;
        }
        wp4 wp4Var = this.u;
        if (wp4Var != null) {
            return z | wp4Var.y(menu);
        }
        return z;
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public void g1(Bundle bundle) {
        Parcelable e0;
        K0(bundle);
        wp4 wp4Var = this.u;
        if (wp4Var != null && (e0 = wp4Var.e0()) != null) {
            bundle.putParcelable(androidx.fragment.app.FragmentActivity.FRAGMENTS_TAG, e0);
        }
    }

    public void k1(Bundle bundle) {
        if (this.f < 0) {
            this.h = bundle;
            return;
        }
        throw new IllegalStateException("Fragment already active");
    }

    public void n1(boolean z) {
        if (!this.L && z && this.a < 4) {
            this.s.W(this);
        }
        this.L = z;
        this.K = !z;
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.F = true;
    }

    public void q0(@Nullable Bundle bundle) {
        this.F = true;
    }

    @Deprecated
    public void s0(Activity activity) {
        this.F = true;
    }

    public void startActivity(Intent intent) {
        up4 up4Var = this.t;
        if (up4Var != null) {
            up4Var.r(this, intent, -1);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public void t0(Context context) {
        Activity activity;
        this.F = true;
        up4 up4Var = this.t;
        if (up4Var == null) {
            activity = null;
        } else {
            activity = up4Var.getActivity();
        }
        if (activity != null) {
            this.F = false;
            s0(activity);
        }
    }

    public void v0(@Nullable Bundle bundle) {
        this.F = true;
    }

    @Deprecated
    public void E0(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.F = true;
    }

    public void F0(Context context, AttributeSet attributeSet, Bundle bundle) {
        Activity activity;
        this.F = true;
        up4 up4Var = this.t;
        if (up4Var == null) {
            activity = null;
        } else {
            activity = up4Var.getActivity();
        }
        if (activity != null) {
            this.F = false;
            E0(activity, attributeSet, bundle);
        }
    }

    public View V0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        wp4 wp4Var = this.u;
        if (wp4Var != null) {
            wp4Var.V();
        }
        return y0(layoutInflater, viewGroup, bundle);
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view2, ContextMenu.ContextMenuInfo contextMenuInfo) {
        getActivity().onCreateContextMenu(contextMenu, view2, contextMenuInfo);
    }

    public void P0(Bundle bundle) {
        wp4 wp4Var = this.u;
        if (wp4Var != null) {
            wp4Var.V();
        }
        this.F = false;
        q0(bundle);
        if (this.F) {
            wp4 wp4Var2 = this.u;
            if (wp4Var2 != null) {
                wp4Var2.n();
                return;
            }
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onActivityCreated()");
    }

    public final void j1(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = this.e;
        if (sparseArray != null) {
            this.J.restoreHierarchyState(sparseArray);
            this.e = null;
        }
        this.F = false;
        O0(bundle);
        if (this.F) {
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onViewStateRestored()");
    }

    public void S0(Bundle bundle) {
        Parcelable parcelable;
        wp4 wp4Var = this.u;
        if (wp4Var != null) {
            wp4Var.V();
        }
        this.F = false;
        v0(bundle);
        if (this.F) {
            if (bundle != null && (parcelable = bundle.getParcelable(androidx.fragment.app.FragmentActivity.FRAGMENTS_TAG)) != null) {
                if (this.u == null) {
                    k0();
                }
                this.u.b0(parcelable, null);
                this.u.q();
                return;
            }
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onCreate()");
    }

    public void X0() {
        wp4 wp4Var = this.u;
        if (wp4Var != null) {
            wp4Var.t();
        }
        this.F = false;
        B0();
        if (this.F) {
            aq4 aq4Var = this.M;
            if (aq4Var != null) {
                aq4Var.c();
                return;
            }
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroyView()");
    }

    public void f1() {
        wp4 wp4Var = this.u;
        if (wp4Var != null) {
            wp4Var.V();
            this.u.E();
        }
        this.F = false;
        onResume();
        if (this.F) {
            wp4 wp4Var2 = this.u;
            if (wp4Var2 != null) {
                wp4Var2.A();
                this.u.E();
                return;
            }
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onResume()");
    }

    public void h1() {
        wp4 wp4Var = this.u;
        if (wp4Var != null) {
            wp4Var.V();
            this.u.E();
        }
        this.F = false;
        L0();
        if (this.F) {
            wp4 wp4Var2 = this.u;
            if (wp4Var2 != null) {
                wp4Var2.B();
            }
            aq4 aq4Var = this.M;
            if (aq4Var != null) {
                aq4Var.d();
                return;
            }
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStart()");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        iq4.a(this, sb);
        if (this.f >= 0) {
            sb.append(" #");
            sb.append(this.f);
        }
        if (this.w != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.w));
        }
        if (this.y != null) {
            sb.append(" ");
            sb.append(this.y);
        }
        sb.append('}');
        return sb.toString();
    }

    public void k(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.w));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.x));
        printWriter.print(" mTag=");
        printWriter.println(this.y);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.a);
        printWriter.print(" mIndex=");
        printWriter.print(this.f);
        printWriter.print(" mWho=");
        printWriter.print(this.g);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.r);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.l);
        printWriter.print(" mRemoving=");
        printWriter.print(this.m);
        printWriter.print(" mResumed=");
        printWriter.print(this.n);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.o);
        printWriter.print(" mInLayout=");
        printWriter.println(this.p);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.z);
        printWriter.print(" mDetached=");
        printWriter.print(this.A);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.E);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.D);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.B);
        printWriter.print(" mRetaining=");
        printWriter.print(this.C);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.L);
        if (this.s != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.s);
        }
        if (this.t != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.t);
        }
        if (this.v != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.v);
        }
        if (this.h != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.h);
        }
        if (this.d != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.d);
        }
        if (this.e != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.e);
        }
        if (this.i != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(this.i);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.k);
        }
        if (this.G != 0) {
            printWriter.print(str);
            printWriter.print("mNextAnim=");
            printWriter.println(this.G);
        }
        if (this.H != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.H);
        }
        if (this.I != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.I);
        }
        if (this.J != null) {
            printWriter.print(str);
            printWriter.print("mInnerView=");
            printWriter.println(this.I);
        }
        if (this.b != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(this.b);
            printWriter.print(str);
            printWriter.print("mStateAfterAnimating=");
            printWriter.println(this.c);
        }
        if (this.M != null) {
            printWriter.print(str);
            printWriter.println("Loader Manager:");
            aq4 aq4Var = this.M;
            aq4Var.h(str + GlideException.IndentedAppendable.INDENT, fileDescriptor, printWriter, strArr);
        }
        if (this.u != null) {
            printWriter.print(str);
            printWriter.println("Child " + this.u + ":");
            wp4 wp4Var = this.u;
            wp4Var.b(str + GlideException.IndentedAppendable.INDENT, fileDescriptor, printWriter, strArr);
        }
    }

    public final void l1(int i, Fragment fragment) {
        this.f = i;
        if (fragment != null) {
            this.g = fragment.g + ":" + this.f;
            return;
        }
        this.g = "android:fragment:" + this.f;
    }
}
