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
import com.baidu.tieba.ao4;
import com.baidu.tieba.fn4;
import com.baidu.tieba.hn4;
import com.baidu.tieba.in4;
import com.baidu.tieba.jn4;
import com.baidu.tieba.nn4;
import com.baidu.tieba.vn4;
import com.baidu.tieba.yn4;
import com.bumptech.glide.load.engine.GlideException;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* loaded from: classes3.dex */
public class Fragment implements ComponentCallbacks, View.OnCreateContextMenuListener {
    public static final yn4<String, Class<?>> Z = new yn4<>();
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
    public nn4 M;
    public boolean N;
    public boolean O;
    public Object Q;
    public Object R;
    public Object S;
    public Object T;
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
    public jn4 s;
    public hn4 t;
    public jn4 u;
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

    public void C0(boolean z) {
    }

    public boolean F0(MenuItem menuItem) {
        return false;
    }

    public void G0(Menu menu) {
    }

    public void H0(Menu menu) {
    }

    public void I0(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
    }

    public void J0(Bundle bundle) {
    }

    public void M0(View view2, @Nullable Bundle bundle) {
    }

    public void q0(int i, int i2, Intent intent) {
    }

    public boolean t0(MenuItem menuItem) {
        return false;
    }

    public Animation v0(int i, boolean z, int i2) {
        return null;
    }

    public void w0(Menu menu, MenuInflater menuInflater) {
    }

    @Nullable
    public View x0(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return null;
    }

    public void z0() {
    }

    /* loaded from: classes3.dex */
    public static class InstantiationException extends RuntimeException {
        public InstantiationException(String str, Exception exc) {
            super(str, exc);
        }
    }

    /* loaded from: classes3.dex */
    public class a extends fn4 {
        public a() {
        }

        @Override // com.baidu.tieba.fn4
        @Nullable
        public View a(int i) {
            View view2 = Fragment.this.I;
            if (view2 != null) {
                return view2.findViewById(i);
            }
            throw new IllegalStateException("Fragment does not have a view");
        }

        @Override // com.baidu.tieba.fn4
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
        this.T = null;
        this.U = obj;
        this.X = null;
        this.Y = null;
    }

    public void A0() {
        this.F = true;
    }

    public Object B() {
        Object obj = this.S;
        if (obj == a0) {
            return u();
        }
        return obj;
    }

    public void B0() {
        this.F = true;
    }

    public Object D() {
        Object obj = this.Q;
        if (obj == a0) {
            return t();
        }
        return obj;
    }

    public Object E() {
        return this.T;
    }

    public Object F() {
        Object obj = this.U;
        if (obj == a0) {
            return E();
        }
        return obj;
    }

    public void K0() {
        this.F = true;
        if (!this.N) {
            this.N = true;
            if (!this.O) {
                this.O = true;
                this.M = this.t.i(this.g, true, false);
            }
            nn4 nn4Var = this.M;
            if (nn4Var != null) {
                nn4Var.f();
            }
        }
    }

    public void L0() {
        this.F = true;
    }

    public final Fragment N() {
        return this.i;
    }

    public final int P() {
        return this.k;
    }

    public boolean U() {
        return this.L;
    }

    @Nullable
    public View V() {
        return this.I;
    }

    public void V0() {
        jn4 jn4Var = this.u;
        if (jn4Var != null) {
            jn4Var.s();
        }
        this.F = false;
        y0();
        if (this.F) {
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroy()");
    }

    public void X0() {
        onLowMemory();
        jn4 jn4Var = this.u;
        if (jn4Var != null) {
            jn4Var.u();
        }
    }

    public void a0() {
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

    public void b1() {
        jn4 jn4Var = this.u;
        if (jn4Var != null) {
            jn4Var.x();
        }
        this.F = false;
        onPause();
        if (this.F) {
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onPause()");
    }

    public void d1() {
        jn4 jn4Var = this.u;
        if (jn4Var != null) {
            jn4Var.z();
        }
        if (this.N) {
            this.N = false;
            if (!this.O) {
                this.O = true;
                this.M = this.t.i(this.g, false, false);
            }
            nn4 nn4Var = this.M;
            if (nn4Var != null) {
                if (!this.C) {
                    nn4Var.g();
                } else {
                    nn4Var.e();
                }
            }
        }
    }

    public void g0() {
        jn4 jn4Var = new jn4();
        this.u = jn4Var;
        jn4Var.j(this.t, new a(), this);
    }

    public final FragmentActivity getActivity() {
        hn4 hn4Var = this.t;
        if (hn4Var == null) {
            return null;
        }
        return (FragmentActivity) hn4Var.getActivity();
    }

    public Context getContext() {
        hn4 hn4Var = this.t;
        if (hn4Var == null) {
            return null;
        }
        return hn4Var.getContext();
    }

    public final Resources getResources() {
        hn4 hn4Var = this.t;
        if (hn4Var != null) {
            return hn4Var.getContext().getResources();
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public void h1() {
        jn4 jn4Var = this.u;
        if (jn4Var != null) {
            jn4Var.C();
        }
        this.F = false;
        L0();
        if (this.F) {
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStop()");
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final boolean k0() {
        if (this.t != null && this.l) {
            return true;
        }
        return false;
    }

    public final boolean l0() {
        return this.A;
    }

    public final boolean m0() {
        return this.z;
    }

    public boolean n() {
        Boolean bool = this.W;
        if (bool == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public final boolean n0() {
        if (this.r > 0) {
            return true;
        }
        return false;
    }

    public boolean o() {
        Boolean bool = this.V;
        if (bool == null) {
            return true;
        }
        return bool.booleanValue();
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

    public final Bundle p() {
        return this.h;
    }

    public final in4 q() {
        if (this.u == null) {
            g0();
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

    public Object t() {
        return this.P;
    }

    public Object u() {
        return this.R;
    }

    public final in4 x() {
        return this.s;
    }

    public void y0() {
        this.F = true;
        if (!this.O) {
            this.O = true;
            this.M = this.t.i(this.g, this.N, false);
        }
        nn4 nn4Var = this.M;
        if (nn4Var != null) {
            nn4Var.b();
        }
    }

    /* loaded from: classes3.dex */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        public final Bundle mState;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

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

    public static Fragment d0(Context context, String str) {
        return e0(context, str, null);
    }

    public static boolean o0(Context context, String str) {
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

    public final String H(@StringRes int i, Object... objArr) {
        return getResources().getString(i, objArr);
    }

    public boolean T0(Menu menu, MenuInflater menuInflater) {
        boolean z = false;
        if (this.z) {
            return false;
        }
        if (this.D && this.E) {
            w0(menu, menuInflater);
            z = true;
        }
        jn4 jn4Var = this.u;
        if (jn4Var != null) {
            return z | jn4Var.r(menu, menuInflater);
        }
        return z;
    }

    public void l1(Fragment fragment, int i) {
        this.i = fragment;
        this.k = i;
    }

    public final void requestPermissions(@NonNull String[] strArr, int i) {
        hn4 hn4Var = this.t;
        if (hn4Var != null) {
            hn4Var.p(this, strArr, i);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public void startActivityForResult(Intent intent, int i) {
        hn4 hn4Var = this.t;
        if (hn4Var != null) {
            hn4Var.r(this, intent, i);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public static Fragment e0(Context context, String str, @Nullable Bundle bundle) {
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

    @Deprecated
    public void D0(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.F = true;
    }

    public void E0(Context context, AttributeSet attributeSet, Bundle bundle) {
        Activity activity;
        this.F = true;
        hn4 hn4Var = this.t;
        if (hn4Var == null) {
            activity = null;
        } else {
            activity = hn4Var.getActivity();
        }
        if (activity != null) {
            this.F = false;
            D0(activity, attributeSet, bundle);
        }
    }

    public View U0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        jn4 jn4Var = this.u;
        if (jn4Var != null) {
            jn4Var.V();
        }
        return x0(layoutInflater, viewGroup, bundle);
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view2, ContextMenu.ContextMenuInfo contextMenuInfo) {
        getActivity().onCreateContextMenu(contextMenu, view2, contextMenuInfo);
    }

    public final String G(@StringRes int i) {
        return getResources().getString(i);
    }

    public void N0(@Nullable Bundle bundle) {
        this.F = true;
    }

    public void Q0(Configuration configuration) {
        onConfigurationChanged(configuration);
        jn4 jn4Var = this.u;
        if (jn4Var != null) {
            jn4Var.o(configuration);
        }
    }

    public boolean R0(MenuItem menuItem) {
        if (!this.z) {
            if (t0(menuItem)) {
                return true;
            }
            jn4 jn4Var = this.u;
            if (jn4Var != null && jn4Var.p(menuItem)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final CharSequence S(@StringRes int i) {
        return getResources().getText(i);
    }

    public boolean Y0(MenuItem menuItem) {
        if (!this.z) {
            if (this.D && this.E && F0(menuItem)) {
                return true;
            }
            jn4 jn4Var = this.u;
            if (jn4Var != null && jn4Var.v(menuItem)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public void a1(Menu menu) {
        if (!this.z) {
            if (this.D && this.E) {
                G0(menu);
            }
            jn4 jn4Var = this.u;
            if (jn4Var != null) {
                jn4Var.w(menu);
            }
        }
    }

    public boolean c1(Menu menu) {
        boolean z = false;
        if (this.z) {
            return false;
        }
        if (this.D && this.E) {
            H0(menu);
            z = true;
        }
        jn4 jn4Var = this.u;
        if (jn4Var != null) {
            return z | jn4Var.y(menu);
        }
        return z;
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public void f1(Bundle bundle) {
        Parcelable e0;
        J0(bundle);
        jn4 jn4Var = this.u;
        if (jn4Var != null && (e0 = jn4Var.e0()) != null) {
            bundle.putParcelable(androidx.fragment.app.FragmentActivity.FRAGMENTS_TAG, e0);
        }
    }

    public void j1(Bundle bundle) {
        if (this.f < 0) {
            this.h = bundle;
            return;
        }
        throw new IllegalStateException("Fragment already active");
    }

    public void m1(boolean z) {
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

    public void p0(@Nullable Bundle bundle) {
        this.F = true;
    }

    @Deprecated
    public void r0(Activity activity) {
        this.F = true;
    }

    public void s0(Context context) {
        Activity activity;
        this.F = true;
        hn4 hn4Var = this.t;
        if (hn4Var == null) {
            activity = null;
        } else {
            activity = hn4Var.getActivity();
        }
        if (activity != null) {
            this.F = false;
            r0(activity);
        }
    }

    public void startActivity(Intent intent) {
        hn4 hn4Var = this.t;
        if (hn4Var != null) {
            hn4Var.r(this, intent, -1);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public void u0(@Nullable Bundle bundle) {
        this.F = true;
    }

    public LayoutInflater y(Bundle bundle) {
        LayoutInflater m = this.t.m();
        q();
        jn4 jn4Var = this.u;
        jn4Var.J();
        ao4.a(m, jn4Var);
        return m;
    }

    public void P0(Bundle bundle) {
        jn4 jn4Var = this.u;
        if (jn4Var != null) {
            jn4Var.V();
        }
        this.F = false;
        p0(bundle);
        if (this.F) {
            jn4 jn4Var2 = this.u;
            if (jn4Var2 != null) {
                jn4Var2.n();
                return;
            }
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onActivityCreated()");
    }

    public final void i1(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = this.e;
        if (sparseArray != null) {
            this.J.restoreHierarchyState(sparseArray);
            this.e = null;
        }
        this.F = false;
        N0(bundle);
        if (this.F) {
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onViewStateRestored()");
    }

    public void S0(Bundle bundle) {
        Parcelable parcelable;
        jn4 jn4Var = this.u;
        if (jn4Var != null) {
            jn4Var.V();
        }
        this.F = false;
        u0(bundle);
        if (this.F) {
            if (bundle != null && (parcelable = bundle.getParcelable(androidx.fragment.app.FragmentActivity.FRAGMENTS_TAG)) != null) {
                if (this.u == null) {
                    g0();
                }
                this.u.b0(parcelable, null);
                this.u.q();
                return;
            }
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onCreate()");
    }

    public void W0() {
        jn4 jn4Var = this.u;
        if (jn4Var != null) {
            jn4Var.t();
        }
        this.F = false;
        A0();
        if (this.F) {
            nn4 nn4Var = this.M;
            if (nn4Var != null) {
                nn4Var.c();
                return;
            }
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroyView()");
    }

    public void e1() {
        jn4 jn4Var = this.u;
        if (jn4Var != null) {
            jn4Var.V();
            this.u.E();
        }
        this.F = false;
        onResume();
        if (this.F) {
            jn4 jn4Var2 = this.u;
            if (jn4Var2 != null) {
                jn4Var2.A();
                this.u.E();
                return;
            }
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onResume()");
    }

    public void g1() {
        jn4 jn4Var = this.u;
        if (jn4Var != null) {
            jn4Var.V();
            this.u.E();
        }
        this.F = false;
        K0();
        if (this.F) {
            jn4 jn4Var2 = this.u;
            if (jn4Var2 != null) {
                jn4Var2.B();
            }
            nn4 nn4Var = this.M;
            if (nn4Var != null) {
                nn4Var.d();
                return;
            }
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStart()");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        vn4.a(this, sb);
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

    public final void k1(int i, Fragment fragment) {
        this.f = i;
        if (fragment != null) {
            this.g = fragment.g + ":" + this.f;
            return;
        }
        this.g = "android:fragment:" + this.f;
    }

    public void l(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
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
            nn4 nn4Var = this.M;
            nn4Var.h(str + GlideException.IndentedAppendable.INDENT, fileDescriptor, printWriter, strArr);
        }
        if (this.u != null) {
            printWriter.print(str);
            printWriter.println("Child " + this.u + ":");
            jn4 jn4Var = this.u;
            jn4Var.b(str + GlideException.IndentedAppendable.INDENT, fileDescriptor, printWriter, strArr);
        }
    }
}
